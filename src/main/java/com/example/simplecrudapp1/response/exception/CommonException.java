package com.example.simplecrudapp1.response.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class CommonException extends RuntimeException{

    private final String message;
    private final HttpStatus httpStatus;
}