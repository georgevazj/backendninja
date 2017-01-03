package com.udemy.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Jorge on 2/1/17.
 */

@ControllerAdvice
public class ErrorsController {
    private static final String ISE_VIEW="error/500";

    @ExceptionHandler(Exception.class)
    public String showInternalServerError(){
        return ISE_VIEW;
    }

}
