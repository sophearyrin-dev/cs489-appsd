package edu.miu.cs.cs489.lesson7.citylibraryapp.advice;

import edu.miu.cs.cs489.lesson7.citylibraryapp.exception.PublisherNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CityLibraryWebAPIExceptionHandler {


    @ExceptionHandler(PublisherNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePublisherNotFoundException(PublisherNotFoundException publisherNotFoundException) {
        Map<String , String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", publisherNotFoundException.getMessage());
        return errorMessageMap;
    }

}
