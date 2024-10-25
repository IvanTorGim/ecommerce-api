package com.itortosagimeno.ecommerce_api.exceptions;

import java.time.LocalDateTime;

public record ApiException(
        String error,
        String message,
        Integer status,
        LocalDateTime time
) {
    public static ApiExceptionBuilder builder() {
        return new ApiExceptionBuilder();
    }

    public static class ApiExceptionBuilder {
        private String error;
        private String message;
        private Integer status;
        private LocalDateTime time;

        public ApiExceptionBuilder() {
        }

        public ApiExceptionBuilder error(String error) {
            this.error = error;
            return this;
        }

        public ApiExceptionBuilder message(String message) {
            this.message = message;
            return this;
        }

        public ApiExceptionBuilder status(Integer status) {
            this.status = status;
            return this;
        }

        public ApiExceptionBuilder time(LocalDateTime time){
            this.time = time;
            return this;
        }

        public ApiException build() {
            return new ApiException(error, message, status, time);
        }
    }
}
