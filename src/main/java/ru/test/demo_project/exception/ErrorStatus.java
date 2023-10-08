package ru.test.demo_project.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ErrorStatus {
    ERROR_NOT_FOUND_ID(HttpStatus.NOT_FOUND, "id board is not found");

    private HttpStatus httpStatus;
    private String message;
}
