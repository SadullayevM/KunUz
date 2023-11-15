package com.example.kun_uz.controller;

import com.example.kun_uz.exp.AppBadRuquestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(AppBadRuquestException.class)
    public ResponseEntity<String> handler(AppBadRuquestException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
