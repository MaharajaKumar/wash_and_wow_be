package com.raincloud.wash_and_wow.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raincloud.wash_and_wow.util.ValidationPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class LoginRequest {

    @JsonProperty(value = "code", required = true)
    @NotBlank
    @NotNull
    @Pattern(regexp = ValidationPatterns.code, message = ValidationPatterns.inValidCodeMessage)
    private String code;

    @JsonProperty(value = "password", required = true)
    @NotBlank
    @NotNull
    @Pattern(regexp = ValidationPatterns.password,
            message = ValidationPatterns.inValidPasswordMessage)
    private String password;

    public LoginRequest() {
    }

    public LoginRequest(String code, String password) {
        this.code = code;
        this.password = password;
    }

    public @NotBlank @NotNull @Pattern(regexp = ValidationPatterns.code, message = ValidationPatterns.inValidCodeMessage) String getCode() {
        return code;
    }

    public void setCode(@NotBlank @NotNull @Pattern(regexp = ValidationPatterns.code, message = ValidationPatterns.inValidCodeMessage) String code) {
        this.code = code;
    }

    public @NotBlank @NotNull @Pattern(regexp = ValidationPatterns.password,
            message = ValidationPatterns.inValidPasswordMessage) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @NotNull @Pattern(regexp = ValidationPatterns.password,
            message = ValidationPatterns.inValidPasswordMessage) String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "code='" + code + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
