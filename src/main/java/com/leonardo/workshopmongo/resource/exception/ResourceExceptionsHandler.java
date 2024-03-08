package com.leonardo.workshopmongo.resource.exception;

import com.leonardo.workshopmongo.service.exception.NotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionsHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(NotFoundException e, HttpServletRequest request) {
        String error = " Resource Not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError stndError = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(stndError);
    }
}
