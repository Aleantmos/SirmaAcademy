package com.exam.pairidentifier.model.dto.response;

import com.exam.pairidentifier.model.dto.PairInfoDTO;

public class ApiResponse {

    private PairInfoDTO bestPair;
    private ApiError error;

    public ApiResponse() {
    }

    public PairInfoDTO getBestPair() {
        return bestPair;
    }

    public void setBestPair(PairInfoDTO bestPair) {
        this.bestPair = bestPair;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }
}
