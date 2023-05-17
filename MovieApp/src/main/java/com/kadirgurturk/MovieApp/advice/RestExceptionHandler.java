package com.kadirgurturk.MovieApp.advice;

import com.kadirgurturk.MovieApp.advice.exceptions.NotFoundExp;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class RestExceptionHandler extends   ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {NotFoundExp.class})
    public ResponseEntity<Object> NotFound(NotFoundExp exp)
    {
        var res = new NotFoundResponse(exp.getMessage(),HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(res,HttpStatus.NOT_FOUND);
    }


    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });

        return ResponseEntity.badRequest().body(errorMap);
    }
}
