package com.example.clonecoding.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class RestApiException {
    private String result;
    private String errorMessage;
    private HttpStatus httpStatus;
}
