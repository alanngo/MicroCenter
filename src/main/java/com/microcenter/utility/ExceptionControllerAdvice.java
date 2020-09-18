package com.microcenter.utility;

import com.microcenter.exception.MicroCenterException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice
{
    private static final Log LOGGER = LogFactory.getLog(ExceptionControllerAdvice.class);

    @Autowired
    private Environment environment;

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception)
    {
        LOGGER.error(exception.getMessage(), exception);
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(),
                environment.getProperty(exception.getMessage()));
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value = MicroCenterException.class)
    public ResponseEntity<ErrorInfo> microcenterExceptionHandler(MicroCenterException exception)
    {
        LOGGER.error(exception.getMessage(), exception);
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.NOT_FOUND.value(),
                environment.getProperty(exception.getMessage()));
        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class, ConstraintViolationException.class})
    public ResponseEntity<ErrorInfo> validExceptionHandler(Exception exception)
    {
        LOGGER.error(exception.getMessage(), exception);
        String message="";
        if (exception instanceof MethodArgumentNotValidException)
        {
            MethodArgumentNotValidException m = (MethodArgumentNotValidException) exception;
            message = m.getBindingResult()
                    .getAllErrors()
                    .stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));
        }
        if (exception instanceof  ConstraintViolationException)
        {
            ConstraintViolationException c = (ConstraintViolationException) exception;
            message = c.getConstraintViolations()
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(", "));
        }
        String[] errList = message.split(", ");
        StringBuilder allMssg = new StringBuilder();
        for (String e: errList)
        {
            String value = environment.getProperty(e);
            allMssg.append(value).append(" ");
        }
        ErrorInfo errorInfo = new ErrorInfo(HttpStatus.BAD_REQUEST.value(), allMssg.toString());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }
}
