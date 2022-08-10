package com.sda.studysystem.handlers.exception;


import com.sda.studysystem.exceptions.SchoolNotFoundException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Handler for Exception
 *
 * @author @Marek Uibo
 */

@RestController
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex){
        List<String> details=new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse errorResponse=new ErrorResponse("Server Error", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SchoolNotFoundException.class)
    public final ResponseEntity<Object> handleSchoolNotFoundException(Exception ex){
        List<String> details=new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse errorResponse=new ErrorResponse("Server Error", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SchoolAlreadyExistsException.class)
    public final ResponseEntity<Object> handleSchoolAlreadyExistsException(Exception ex){
        List<String> details=new ArrayList<>();
        details.add(ex.getLocalizedMessage());
        ErrorResponse errorResponse=new ErrorResponse("School already exists", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @Override
    @NonNull
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders httpHeaders,
                                                                  HttpStatus httpStatus, WebRequest webRequest){
        List<String> details = new ArrayList<>();
        for(ObjectError error: ex.getBindingResult().getAllErrors()){
            details.add(error.getDefaultMessage());
        }
        ErrorResponse errorResponse = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
