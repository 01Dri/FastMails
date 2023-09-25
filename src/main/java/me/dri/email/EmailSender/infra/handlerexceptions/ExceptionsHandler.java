package me.dri.email.EmailSender.infra.handlerexceptions;


import me.dri.email.EmailSender.entities.exception.ContentIsEmptyException;
import me.dri.email.EmailSender.entities.exception.FastMailException;
import me.dri.email.EmailSender.entities.exception.entities.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ExceptionsHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(FastMailException.class)
    public ResponseEntity fastMailExceptionHandler(FastMailException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionResponse exceptionResponse = new ExceptionResponse(status.value(), ex.getMessage(), new Date());
        return new ResponseEntity<>(exceptionResponse, status);

    }

    @ExceptionHandler(ContentIsEmptyException.class)
    public ResponseEntity ContentIsEmptyExceptionHandler(ContentIsEmptyException ex) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        ExceptionResponse exceptionResponse = new ExceptionResponse(status.value(), ex.getMessage(), new Date());
        return new ResponseEntity<>(exceptionResponse, status);

    }
}
