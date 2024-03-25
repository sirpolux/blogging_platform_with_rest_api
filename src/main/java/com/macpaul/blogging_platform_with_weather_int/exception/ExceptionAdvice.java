package com.macpaul.blogging_platform_with_weather_int.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, String> errors= new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error->{
                    errors.put(error.getField(), error.getDefaultMessage());
                });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(NullWeatherDataException.class)
    @ResponseStatus(HttpStatus.GATEWAY_TIMEOUT)
    public HashMap<String, String> handleNullWeatherDataException(NullWeatherDataException ex){
        HashMap<String, String> errors= new HashMap<>();
        errors.put("msg",ex.getMessage());
        return errors;
    }

    @ExceptionHandler(PostNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HashMap<String, String> handlePostNotFoundException(PostNotFoundException ex){
        HashMap<String, String> errors= new HashMap<>();
        errors.put("msg",ex.getMessage());
        return errors;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
        HashMap<String, String> errors= new HashMap<>();
        errors.put("msg","Error processing input");
        errors.put("error",ex.getMessage());
        errors.put("value_provided",(String)ex.getValue());
        errors.put("field",ex.getName());
        return errors;
    }

}
