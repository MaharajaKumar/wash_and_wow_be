package com.raincloud.wash_and_wow.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raincloud.wash_and_wow.util.ValidationPatterns;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public class UserRegistrationRequest {

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "code", required = true)
    @NotBlank
    @NotNull
    @Pattern(regexp = ValidationPatterns.code, message = ValidationPatterns.inValidCodeMessage)
    private String code;

    @JsonProperty(value = "first_name", required = true)
    @NotBlank
    @NotNull
    @Pattern(regexp = ValidationPatterns.alphabetsWithSpace, message = ValidationPatterns.inValidNameMessage)
    private String firstName;

    @JsonProperty(value = "last_name", required = true)
    @NotBlank
    @NotNull
    private String lastName;

    @JsonProperty(value = "dob", required = true)
    @NotNull(message = ValidationPatterns.inValidDateOfBirthMessage)
    private Date dob;

    @JsonProperty(value = "role")
    private String role;

    @JsonProperty(value = "mobile_number", required = true)
    @NotBlank
    @NotNull
    @Pattern(regexp = ValidationPatterns.mobileNo, message = ValidationPatterns.inValidMobileNo)
    private String mobileNumber;

    @JsonProperty(value = "email", required = true)
    @NotBlank
    @NotNull
    @Email(message = ValidationPatterns.inValidEmailMessage)
    private String email;

    @JsonProperty(value = "password", required = true)
    @NotBlank
    @NotNull
    @Pattern(regexp = ValidationPatterns.password, message = ValidationPatterns.inValidPasswordMessage)
    private String password;

    public UserRegistrationRequest() {
    }

    public UserRegistrationRequest(int id, String code, String firstName, String lastName, Date dob, String role, String mobileNumber, String email, String password) {
        this.id = id;
        this.code = code;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.role = role;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank @NotNull @Pattern(regexp = ValidationPatterns.code, message = ValidationPatterns.inValidCodeMessage) String getCode() {
        return code;
    }

    public void setCode(@NotBlank @NotNull @Pattern(regexp = ValidationPatterns.code, message = ValidationPatterns.inValidCodeMessage) String code) {
        this.code = code;
    }

    public @NotBlank @NotNull @Pattern(regexp = ValidationPatterns.alphabetsWithSpace, message = ValidationPatterns.inValidNameMessage) String getFirstName() {
        return firstName;
    }

    public void setFirstName(@NotBlank @NotNull @Pattern(regexp = ValidationPatterns.alphabetsWithSpace, message = ValidationPatterns.inValidNameMessage) String firstName) {
        this.firstName = firstName;
    }

    public @NotBlank @NotNull String getLastName() {
        return lastName;
    }

    public void setLastName(@NotBlank @NotNull String lastName) {
        this.lastName = lastName;
    }

    public @NotNull Date getDob() {
        return dob;
    }

    public void setDob(@NotNull Date dob) {
        this.dob = dob;
    }

    public @NotBlank @NotNull String getRole() {
        return role;
    }

    public void setRole(@NotBlank @NotNull String role) {
        this.role = role;
    }

    public @NotBlank @NotNull @Pattern(regexp = ValidationPatterns.mobileNo, message = ValidationPatterns.inValidMobileNo) String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(@NotBlank @NotNull @Pattern(regexp = ValidationPatterns.mobileNo, message = ValidationPatterns.inValidMobileNo) String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public @NotBlank @NotNull @Email(message = ValidationPatterns.inValidEmailMessage) String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank @NotNull @Email(message = ValidationPatterns.inValidEmailMessage) String email) {
        this.email = email;
    }

    public @NotBlank @NotNull @Pattern(regexp = ValidationPatterns.password, message = ValidationPatterns.inValidPasswordMessage) String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @NotNull @Pattern(regexp = ValidationPatterns.password, message = ValidationPatterns.inValidPasswordMessage) String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", role='" + role + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
