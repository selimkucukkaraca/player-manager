package com.producter.playermanager.exception;

public class PlayerCountLimitExceededException extends RuntimeException{

    public PlayerCountLimitExceededException(String message) {
        super(message);
    }
}