package com.example.adsrestapi.advice;

import com.example.adsrestapi.exception.AddressNotFoundException;
import com.example.adsrestapi.exception.PatientNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class AdvantisWebAPIExceptionHandlerGlobal {

    @ExceptionHandler(AddressNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handleAddressNotFoundException(AddressNotFoundException
                                                                     addressNotFoundException){
        Map<String,String> errorMessageMap = new HashMap<>();

        errorMessageMap.put("errorMessage",addressNotFoundException.getMessage());

        return errorMessageMap;

    }

    @ExceptionHandler(PatientNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> handlePatientNotFoundException(PatientNotFoundException
                                                                     patientNotFoundException){
        Map<String,String> errorMessageMap = new HashMap<>();

        errorMessageMap.put("errorMessage",patientNotFoundException.getMessage());

        return errorMessageMap;

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleBeanValidationException(
            MethodArgumentNotValidException methodArgumentNotValidException) {

        Map<String, String> errorMap = new HashMap<>();
        methodArgumentNotValidException.getBindingResult()
                .getFieldErrors()
                .forEach(fieldError -> errorMap.put(fieldError.getField(),fieldError.getDefaultMessage()));

        return errorMap;
    }

    // BadCredentialsException
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BadCredentialsException.class)
    public Map<String, String> handleUserAuthBadCredentialException(BadCredentialsException bcEx) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", bcEx.getMessage());
        errorMap.put("errorDisplayText", "Invalid Username and/or Password!");
        return errorMap;
    }
}
