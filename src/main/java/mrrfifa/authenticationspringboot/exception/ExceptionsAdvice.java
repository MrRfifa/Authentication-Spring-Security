package mrrfifa.authenticationspringboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionsAdvice {

    @ResponseBody
    @ExceptionHandler(EmailAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> emailAlreadyExist(EmailAlreadyExistsException emailAlreadyExistsException){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("error message",emailAlreadyExistsException.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(NotValidEmailException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> notValidEmail(NotValidEmailException notValidEmailException){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("error message",notValidEmailException.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(TokenNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> tokenNotFound(TokenNotFoundException tokenNotFoundException){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("error message",tokenNotFoundException.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(EmailAlreadyConfirmedException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> emailAlreadyConfirmed(EmailAlreadyConfirmedException emailAlreadyConfirmedException){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("error message",emailAlreadyConfirmedException.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(TokenExpiredException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> tokenExpired(TokenExpiredException tokenExpiredException){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("error message",tokenExpiredException.getMessage());
        return errorMap;
    }

    @ResponseBody
    @ExceptionHandler(FailedToSendEmailException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String,String> failedToSendEmail(FailedToSendEmailException failedToSendEmailException){

        Map<String,String> errorMap=new HashMap<>();
        errorMap.put("error message",failedToSendEmailException.getMessage());
        return errorMap;
    }

}
