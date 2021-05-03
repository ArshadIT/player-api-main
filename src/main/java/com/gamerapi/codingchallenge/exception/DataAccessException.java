package com.gamerapi.codingchallenge.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DataAccessException extends RuntimeException {
    public DataAccessException(String message){
        super(message);
    }

    public DataAccessException(String message, Throwable cause){
        super(message, cause);
    }
}
