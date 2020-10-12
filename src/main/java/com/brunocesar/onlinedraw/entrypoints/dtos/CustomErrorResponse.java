package com.brunocesar.onlinedraw.entrypoints.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * CustomErrorResponse
 *
 * @author : Bruno Cesar
 * @since : 06/10/2020
 **/
public class CustomErrorResponse implements Serializable {

    @JsonProperty(value = "timestamp")
    private LocalDateTime timestamp;

    @JsonProperty(value = "path")
    private String path;

    @JsonProperty(value = "status")
    private Integer status;

    @JsonProperty(value = "error")
    private String error;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "requestId")
    private String requestId;

    public CustomErrorResponse(Integer statusCode, String error, String message, String requestId, String path) {
        this.status = statusCode;
        this.error = error;
        this.message = message;
        this.requestId = requestId;
        this.timestamp = LocalDateTime.now();
        this.path = path;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private HttpStatus httpStatus;
        private String error;
        private String message;
        private ServerHttpRequest request;

        public Builder withStatus(HttpStatus httpStatus) {
            this.httpStatus = httpStatus;
            return this;
        }

        public Builder withError(String error) {
            this.error = error;
            return this;
        }

        public Builder withMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder withRequest(ServerHttpRequest request) {
            this.request = request;
            return this;
        }

        public CustomErrorResponse build() {
            Objects.requireNonNull(httpStatus, "httpStatus is required");
            Objects.requireNonNull(request, "ServerHttpRequest is required");
            Objects.requireNonNull(error, "error is required");

            final String requestId = request.getId();
            final String path = request.getURI().getPath();

            return new CustomErrorResponse(httpStatus.value(), error, message, requestId, path);

        }

    }
}
