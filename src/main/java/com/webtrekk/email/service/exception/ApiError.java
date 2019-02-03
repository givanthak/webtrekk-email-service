package com.webtrekk.email.service.exception;

import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

/**
 * The type Api error.
 */
public class ApiError {

    private HttpStatus status;
    private String message;
    private List<String> errors;

    /**
     * Instantiates a new Api error.
     */
    public ApiError() {
        super();
    }

    /**
     * Instantiates a new Api error.
     *
     * @param status  the status
     * @param message the message
     * @param errors  the errors
     */
    public ApiError(final HttpStatus status, final String message, final List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    /**
     * Instantiates a new Api error.
     *
     * @param status  the status
     * @param message the message
     * @param error   the error
     */
    public ApiError(final HttpStatus status, final String message, final String error) {
        super();
        this.status = status;
        this.message = message;
        errors = Arrays.asList(error);
    }

    //

    /**
     * Gets status.
     *
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(final HttpStatus status) {
        this.status = status;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * Gets errors.
     *
     * @return the errors
     */
    public List<String> getErrors() {
        return errors;
    }

    /**
     * Sets errors.
     *
     * @param errors the errors
     */
    public void setErrors(final List<String> errors) {
        this.errors = errors;
    }

    /**
     * Sets error.
     *
     * @param error the error
     */
    public void setError(final String error) {
        errors = Arrays.asList(error);
    }
}
