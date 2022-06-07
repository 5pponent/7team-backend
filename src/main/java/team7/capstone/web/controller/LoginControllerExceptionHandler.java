package team7.capstone.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import team7.capstone.web.ResponseErrors;
import team7.capstone.web.ResponseForm;
import team7.capstone.web.exceptions.AccountMismatchException;

import static team7.capstone.web.ResponseForm.badRequest;

@Slf4j
@RestControllerAdvice
public class LoginControllerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ResponseErrors> AccountMismatchExceptionHandler
            (AccountMismatchException e) {
        ResponseErrors errors = new ResponseErrors();
        errors.put("global", e.getMessage());
        return badRequest(errors);
    }
}
