package com.raincloud.wash_and_wow.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_addresses")
public class VendorAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @Column(name = "door_no", nullable = false)
    private String doorNo;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "area", nullable = false)
    private String area;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "district", nullable = false)
    private String district;

    @Column(name = "pin_code", nullable = false)
    private int pinCode;

    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "latitude", nullable = false)
    private long latitude;

    @Column(name = "longitude", nullable = false)
    private long longitude;

    public VendorAddress() {
    }

    public VendorAddress(Vendor vendor, String doorNo, String street, String area, String city, String district, int pinCode, String state, long latitude, long longitude) {
        this.vendor = vendor;
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

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
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

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "VendorAddress{" +
                "id=" + id +
                ", vendor=" + vendor +
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
