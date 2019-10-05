package com.impurityonline.osrs.controller.handler;

import com.impurityonline.osrs.controller.response.ApiErrorResponse;
import com.impurityonline.osrs.exception.ServerRestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

/**
 * @author impurity
 */
@Slf4j
@ControllerAdvice
@Order(Ordered.LOWEST_PRECEDENCE)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ApiErrorResponse> handledIllegalArgumentException(final IllegalArgumentException ex) {
        log.info("Illegal Argument: {}", ex.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(BAD_REQUEST, "Illegal Argument present internally", ex);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ApiErrorResponse> handledNullPointerException(final NullPointerException ex) {
        log.info("Null pointer: {}", ex.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(INTERNAL_SERVER_ERROR, "Null Pointer present internally", ex);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(ServerRestException.class)
    protected ResponseEntity<ApiErrorResponse> handledRestTemplateServerException(final ServerRestException ex) {
        log.info("Rest template server exception: {}", ex.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(SERVICE_UNAVAILABLE, "Could not complete request to external resource. Try again later.", ex);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
