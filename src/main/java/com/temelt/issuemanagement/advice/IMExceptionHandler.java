package com.temelt.issuemanagement.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by temelt on 6.02.2019.
 */
@ControllerAdvice
@RestController

public class IMExceptionHandler extends ResponseEntityExceptionHandler {

	Logger log = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<?> handleExceptions(Exception ex, WebRequest request) {
        log.error("ControllerAdvice -> ExceptionHandler -> " , ex ,request);
        ExceptionResponse  exceptionResponse =new ExceptionResponse();
        return new ResponseEntity<>(exceptionResponse , HttpStatus.EXPECTATION_FAILED);
    }
}
