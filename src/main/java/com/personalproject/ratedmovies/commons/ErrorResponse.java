package com.personalproject.ratedmovies.commons;

import java.util.List;

public class ErrorResponse {
    private String error;
    private List<String> errors;

    public ErrorResponse(String error, List<String> errors) {
        this.error = error;
        this.errors = errors;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
