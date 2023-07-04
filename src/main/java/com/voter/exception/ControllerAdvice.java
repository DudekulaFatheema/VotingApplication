package com.voter.exception;



import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

 

@RestControllerAdvice

public class ControllerAdvice {

 

@ExceptionHandler(NullValueFoundException.class)

public ResponseEntity<String> nullValueFoundException(NullValueFoundException nufe) {

return new ResponseEntity<>(nufe.getMessage(),HttpStatus.BAD_GATEWAY);

}
@ExceptionHandler(InvalidCredentialsException.class)

public ResponseEntity<String> cantLoginUser(InvalidCredentialsException invc) {

return new ResponseEntity<String>(invc.getMessage(),HttpStatus.BAD_REQUEST);

}

 

@ExceptionHandler(NullUserNameFoundException.class)

public ResponseEntity<String> nullUserNameFoundException(NullUserNameFoundException uidcnn) {

return new ResponseEntity<String>(uidcnn.getMessage(),HttpStatus.BAD_REQUEST);

}

 

/*@ExceptionHandler(UserAlreadyExistException.class)

public ResponseEntity<String> userAlreadyExist(UserAlreadyExistException uae) {

return new ResponseEntity<String>(uae.getMessage(),HttpStatus.CONFLICT);

}

 




}*/

}

 
