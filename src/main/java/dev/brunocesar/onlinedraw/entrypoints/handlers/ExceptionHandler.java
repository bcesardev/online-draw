package dev.brunocesar.onlinedraw.entrypoints.handlers;

import dev.brunocesar.onlinedraw.entrypoints.dtos.CustomErrorResponse;
import dev.brunocesar.onlinedraw.business.exceptions.DrawException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;


/**
 * ExceptionHandler
 *
 * @author : Bruno Cesar
 * @since : 06/10/2020
 **/
@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(DrawException.class)
    public ResponseEntity<CustomErrorResponse> handleDrawException(DrawException drawException, ServerHttpRequest request) {

        CustomErrorResponse response = CustomErrorResponse.builder()
                .withError("Draw Exception")
                .withMessage(drawException.getMessage())
                .withRequest(request)
                .withStatus(HttpStatus.BAD_REQUEST)
                .build();


        return ResponseEntity.badRequest().body(response);
    }

}
