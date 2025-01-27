package org.example.expert.domain.auth.exception;

import org.springframework.http.HttpStatus;

public class AuthException extends RuntimeException {

    public AuthException(String message, HttpStatus unauthorized) {
        super(message);
    }
}
