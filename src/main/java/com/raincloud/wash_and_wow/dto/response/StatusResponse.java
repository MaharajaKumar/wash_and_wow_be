package com.raincloud.wash_and_wow.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusResponse {
    private String status;
    private String message;
    private String token;
    private Object data;
    private List<ValidationErrorResponse> field_description;

    public static StatusResponse success(String message) {
        return new StatusResponse("SUCCESS", message);
    }

    public static StatusResponse failure(String message) {
        return new StatusResponse("FAILURE", message);
    }

    public static StatusResponse data(Object data) {
        return new StatusResponse(data);
    }

    public static StatusResponse authorized(String message, String token) {
        return new StatusResponse("SUCCESS", message, token);
    }

    public static StatusResponse validationError(String message, List<ValidationErrorResponse> field_description) {
        return new StatusResponse("FAILURE", message, null, field_description);
    }

    private StatusResponse(Object data) {
        this.data = data;
    }

    private StatusResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }

    private StatusResponse(String status, String message, String token) {
        this.status = status;
        this.message = message;
        this.token = token;
    }

    private StatusResponse(String status, String message, String token, List<ValidationErrorResponse> field_description) {
        this.status = status;
        this.message = message;
        this.token = token;
        this.field_description = field_description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<ValidationErrorResponse> getField_description() {
        return field_description;
    }

    public void setField_description(List<ValidationErrorResponse> field_description) {
        this.field_description = field_description;
    }
}