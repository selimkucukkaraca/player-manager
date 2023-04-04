package com.producter.playermanager.model;

import jakarta.persistence.*;

public class Log extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private LogType logType;

    public Log(LogType logType) {
        this.logType = logType;
    }
}
