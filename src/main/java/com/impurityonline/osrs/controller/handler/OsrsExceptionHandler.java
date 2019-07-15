package com.impurityonline.osrs.controller.handler;

import com.impurityonline.osrs.controller.response.ApiErrorResponse;
import com.impurityonline.osrs.exception.ItemNotFoundException;
import com.impurityonline.osrs.exception.OsrsClientItemHttpRequestException;
import com.impurityonline.osrs.exception.OsrsClientPlayerHttpRequestException;
import com.impurityonline.osrs.exception.PlayerNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * @author impurity
 */
@Slf4j
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OsrsExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(PlayerNotFoundException.class)
    protected ResponseEntity<ApiErrorResponse> handledOsrsPlayerNotFoundException(final PlayerNotFoundException ex) {
        log.info("The Osrs player from the Osrs API could not be found: {}", ex.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(NOT_FOUND, "Could not find osrs player.", ex);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
    
    @ExceptionHandler(ItemNotFoundException.class)
    protected ResponseEntity<ApiErrorResponse> handledOsrsItemNotFoundException(final ItemNotFoundException ex) {
        log.info("The Osrs player from the Osrs API could not be found: {}", ex.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(NOT_FOUND, "Could not find osrs item.", ex);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(OsrsClientPlayerHttpRequestException.class)
    protected ResponseEntity<ApiErrorResponse> handledOsrsClientPlayerHttpRequestException(final OsrsClientPlayerHttpRequestException ex) {
        log.info("The Osrs Client was unable to successfully complete the get player request: {}:{}", ex.getStatus(), ex.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(INTERNAL_SERVER_ERROR, "Could not complete request to fetch osrs player.", ex);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    @ExceptionHandler(OsrsClientItemHttpRequestException.class)
    protected ResponseEntity<ApiErrorResponse> handledOsrsClientItemHttpRequestException(final OsrsClientItemHttpRequestException ex) {
        log.info("The Osrs Client was unable to successfully complete the get item request: {}:{}", ex.getStatus(), ex.getMessage());
        ApiErrorResponse apiError = new ApiErrorResponse(INTERNAL_SERVER_ERROR, "Could not complete request to fetch osrs item.", ex);
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }
}
