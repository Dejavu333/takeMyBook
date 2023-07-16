package com.elte.fsz.takemybook.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.elte.fsz.takemybook.application.exception.BusinessException;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(code = HttpStatus.BAD_GATEWAY)
    public String handleCustomException(BusinessException ex, Model model) {
        model.addAttribute("errorCode", ex.getErrorCode());
        model.addAttribute("errorMessage", ex.getErrorMessage());
        return "error";
    }
}
