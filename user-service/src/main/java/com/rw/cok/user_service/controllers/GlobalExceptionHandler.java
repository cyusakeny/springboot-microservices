//package com.rw.cok.user_service.controllers;
//
//import com.rw.cok.user_service.Exceptions.BadRequestException;
//import com.rw.cok.user_service.utils.ApiResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//
//import java.nio.file.AccessDeniedException;
//
//@RestControllerAdvice
//@Order(Ordered.HIGHEST_PRECEDENCE)
//@EnableWebMvc
//@Slf4j
//public class GlobalExceptionHandler {
//    @ExceptionHandler(UsernameNotFoundException.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public ResponseEntity<?> handleUsernameNotFound(UsernameNotFoundException usernameNotFoundException){
//        return new ResponseEntity<>(new ApiResponse<String>(null,usernameNotFoundException.getMessage(),"UNAUTHORIZED",HttpStatus.UNAUTHORIZED),HttpStatus.NOT_FOUND);
//    }
//    @ExceptionHandler(BadRequestException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<?> badRequestExceptionHandler(BadRequestException exception){
//        return new ResponseEntity<>(new ApiResponse<String>(null,exception.getMessage(),exception.getErrorCode(),HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ResponseEntity<?> internalServerErrorHandler(Exception exception){
//        return new ResponseEntity<>(new ApiResponse<String>(null,exception.getMessage(),"INTERNAL SEVER ERROR",HttpStatus.INTERNAL_SERVER_ERROR),HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    @ExceptionHandler(BadCredentialsException.class)
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    public ResponseEntity<?> BadCredentialsErrorHandler(BadCredentialsException exception){
//        return new ResponseEntity<>(new ApiResponse<String>(null,exception.getMessage(),"BAD_CREDENTIALS",HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(AccessDeniedException.class)
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    public ResponseEntity<?> accessDeniedErrorHandler(AccessDeniedException exception){
//        return new ResponseEntity<>(new ApiResponse<String>(null,exception.getMessage(),"NO_PERMISSION",HttpStatus.FORBIDDEN),HttpStatus.FORBIDDEN);
//    }
//    @ExceptionHandler(DuplicateKeyException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseEntity<?> duplicateErrorHandler(DuplicateKeyException exception){
//        return new ResponseEntity<>(new ApiResponse<String>(null,exception.getMessage(),"DUPLICATED_VALUES",HttpStatus.BAD_REQUEST),HttpStatus.BAD_REQUEST);
//    }
//}
