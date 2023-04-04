package com.producter.playermanager.repository;

import com.producter.playermanager.model.Log;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogRepository extends JpaRepository<Log,Long> {
}
