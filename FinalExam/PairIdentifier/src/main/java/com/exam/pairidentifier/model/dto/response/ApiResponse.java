package com.exam.pairidentifier.model.dto.response;

public class ApiResponse<T> {

    private T response;
    private ApiError error;

    public ApiResponse() {
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }
}
