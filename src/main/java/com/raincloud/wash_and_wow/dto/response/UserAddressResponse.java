package com.raincloud.wash_and_wow.dto.response;

public class UserAddressResponse {
    private int id;
    private int user_id;
    private String doorNo;
    private String street;
    private String area;
    private String city;
    private String district;
    private String pinCode;
    private String state;
    private String latitude;
    private String longitude;

    public UserAddressResponse() {
    }

    public UserAddressResponse(int id, int user_id, String doorNo, String street, String area, String city, String district, String pinCode, String state, String latitude, String longitude) {
        this.id = id;
        this.user_id = user_id;
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

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "UserAddressResponse{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", doorNo='" + doorNo + '\'' +
                ", street='" + street + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", state='" + state + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }
}
