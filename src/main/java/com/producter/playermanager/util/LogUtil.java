package com.producter.playermanager.util;

import com.producter.playermanager.model.Log;
import com.producter.playermanager.repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogUtil {

    private final LogRepository logRepository;

    public void save(Log log){
        logRepository.save(log);
    }

}