package com.raincloud.wash_and_wow.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.raincloud.wash_and_wow.util.ValidationPatterns;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserAddressRequest {

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "door_no", required = true)
    @NotBlank
    @NotNull
    private String doorNo;

    @JsonProperty(value = "street", required = true)
    @NotBlank
    @NotNull
    private String street;

    @JsonProperty(value = "area", required = true)
    @NotBlank
    @NotNull
    private String area;

    @JsonProperty(value = "city", required = true)
    @NotBlank
    @NotNull
    private String city;

    @JsonProperty(value = "district", required = true)
    @NotBlank
    @NotNull
    private String district;

    @JsonProperty(value = "pinCode", required = true)
    @NotBlank
    @NotNull
    @Pattern(regexp = ValidationPatterns.postalCode, message = ValidationPatterns.inValidPostalCodeMessage)
    private String pinCode;

    @JsonProperty(value = "state", required = true)
    @NotBlank
    @NotNull
    private String state;

    @JsonProperty(value = "latitude", required = true)
    @NotBlank
    @NotNull
    // @Pattern(regexp = ValidationPatterns.latitude, message = ValidationPatterns.inValidLatitudeMessage)
    private String latitude;

    @JsonProperty(value = "longitude", required = true)
    @NotBlank
    @NotNull
    // @Pattern(regexp = ValidationPatterns.longitude, message = ValidationPatterns.inValidLongitudeMessage)
    private String longitude;

    public UserAddressRequest() {
    }

    public UserAddressRequest(String doorNo, String street, String area, String city, String district, String pinCode, String state, String latitude, String longitude) {
        this.doorNo = doorNo;
        this.street = street;
        this.area = area;
        this.city = city;
        this.district = district;
        this.pinCode = pinCode;
        this.state = state;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank @NotNull String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(@NotBlank @NotNull String doorNo) {
        this.doorNo = doorNo;
    }

    public @NotBlank @NotNull String getStreet() {
        return street;
    }

    public void setStreet(@NotBlank @NotNull String street) {
        this.street = street;
    }

    public @NotBlank @NotNull String getArea() {
        return area;
    }

    public void setArea(@NotBlank @NotNull String area) {
        this.area = area;
    }

    public @NotBlank @NotNull String getCity() {
        return city;
    }

    public void setCity(@NotBlank @NotNull String city) {
        this.city = city;
    }

    public @NotBlank @NotNull String getDistrict() {
        return district;
    }

    public void setDistrict(@NotBlank @NotNull String district) {
        this.district = district;
    }

    @NotBlank
    @NotNull
    @Pattern(regexp = ValidationPatterns.postalCode, message = ValidationPatterns.inValidPostalCodeMessage)
    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(@NotBlank @NotNull @Pattern(regexp = ValidationPatterns.postalCode, message = ValidationPatterns.inValidPostalCodeMessage) String pinCode) {
        this.pinCode = pinCode;
    }

    public @NotBlank @NotNull String getState() {
        return state;
    }

    public void setState(@NotBlank @NotNull String state) {
        this.state = state;
    }

    @NotBlank
    @NotNull
    // @Pattern(regexp = ValidationPatterns.latitude, message = ValidationPatterns.inValidLatitudeMessage)
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(@NotBlank @NotNull String latitude) {
        this.latitude = latitude;
    }

    @NotBlank
    @NotNull
    // @Pattern(regexp = ValidationPatterns.longitude, message = ValidationPatterns.inValidLongitudeMessage)
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(@NotBlank @NotNull String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "UserAddressRequest{" +
                "id=" + id +
                ", doorNo='" + doorNo + '\'' +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", pinCode=" + pinCode +
                ", state='" + state + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
