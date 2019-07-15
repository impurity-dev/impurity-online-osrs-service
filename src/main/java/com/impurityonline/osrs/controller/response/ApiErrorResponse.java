package com.impurityonline.osrs.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * @author impurity
 */
@Getter
public class ApiErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private final LocalDateTime timestamp;
    private final HttpStatus status;
    private final String message;
    @JsonProperty(value = "debug_message")
    private final String debugMessage;

    public ApiErrorResponse(@NonNull HttpStatus status, @NonNull String message, @NonNull Throwable ex) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.message = message;
        this.debugMessage = ex.getLocalizedMessage();
    }
}
