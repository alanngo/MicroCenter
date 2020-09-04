package com.microcenter.utility;

import com.microcenter.exception.MicroCenterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice
{
    private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);

    @Autowired
    private Environment environment;

    @ExceptionHandler(value = MicroCenterException.class)
    public ResponseEntity<ErrorInfo> microcenterExceptionHandler(MicroCenterException exception)
    {
        LOGGER.error(exception.getMessage(), exception);
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(),
                environment.getProperty(exception.getMessage()));
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }
}
