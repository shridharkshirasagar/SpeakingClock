package com.shridhar.SpeakingClock.exceptionHandler;


import com.shridhar.SpeakingClock.exceptions.InvalidTimeFormatException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class SpeakingclockExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(InvalidTimeFormatException.class)
    public String invalidFormat(InvalidTimeFormatException invalidTimeFormatException){
        return "Time format is invalid unable to process the request";
    }
}
