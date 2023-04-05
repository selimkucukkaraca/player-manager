package com.producter.playermanager.service;

import com.producter.playermanager.dto.TeamDto;
import com.producter.playermanager.dto.converter.TeamConverter;
import com.producter.playermanager.dto.request.CreateTeamRequest;
import com.producter.playermanager.exception.generic.NotFoundException;
import com.producter.playermanager.exception.generic.GenericExistException;
import com.producter.playermanager.model.Log;
import com.producter.playermanager.model.LogType;
import com.producter.playermanager.model.Team;
import com.producter.playermanager.repository.TeamRepository;
import com.producter.playermanager.util.LogUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;
    private final TeamConverter teamConverter;
    private final LogUtil logUtil;

    public TeamDto createTeam(CreateTeamRequest request) {
        var saved = teamConverter.toEntity(request);
        if (teamRepository.existsTeamByName(saved.getName())) {
            throw new GenericExistException("User already exist, mail: " + saved.getName());
        }
        teamRepository.save(saved);
        logUtil.save(new Log("Team successfully add : " + saved.getName() ,LogType.CREATE));
        return teamConverter.convertDto(saved);
    }

    public List<TeamDto> getAllTeams(int page, int size){
        Pageable pageable = PageRequest.of(page,size);

        logUtil.save(new Log("All teams successfully called : " ,LogType.LIST));
        return teamRepository.findAll(pageable)
                .stream()
                .map(teamConverter::convertDto)
                .toList();
    }

    public void deleteTeam(String name) {
        var team = getTeamByName(name);
        teamRepository.delete(team);
        logUtil.save(new Log("team successfully deleted : " + name, LogType.DELETE));
    }

    protected Team getTeamByName(String name) {
        return teamRepository.findTeamByName(name)
                .orElseThrow(() -> new NotFoundException("Team not fount, team name: " + name));
    }

}