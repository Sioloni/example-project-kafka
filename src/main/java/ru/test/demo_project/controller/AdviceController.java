package ru.test.demo_project.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.test.demo_project.exception.AdviceException;
import ru.test.demo_project.exception.ErrorResponse;

@RestControllerAdvice
public class AdviceController {


    @ExceptionHandler
    public ErrorResponse handler(AdviceException exception) {
        return new ErrorResponse
                (
                        exception.getStatus().getMessage(),
                        exception.getStatus().getHttpStatus(),
                        exception.getLocalDateTime()
                );
    }
}
