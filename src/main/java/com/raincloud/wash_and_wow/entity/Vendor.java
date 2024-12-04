package com.raincloud.wash_and_wow.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", unique = true, updatable = false, nullable = false)
    private String code;

    @Column(name = "gst", unique = true, nullable = false)
    private String gst;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendorAddress> vendorAddress;

    @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VendorBankDetail> vendorBankDetail;

    public Vendor() {
    }

    public Vendor(String name, String code, String gst) {
        this.name = name;
        this.code = code;
        this.gst = gst;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getGst() {
        return gst;
    }

    public void setGst(String gst) {
        this.gst = gst;
    }

    public List<VendorAddress> getVendorAddress() {
        return vendorAddress;
    }

    public void setVendorAddress(List<VendorAddress> vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public List<VendorBankDetail> getVendorBankDetail() {
        return vendorBankDetail;
    }

    public void setVendorBankDetail(List<VendorBankDetail> vendorBankDetail) {
        this.vendorBankDetail = vendorBankDetail;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", gst='" + gst + '\'' +
                ", vendorAddress=" + vendorAddress +
                ", vendorBankDetail=" + vendorBankDetail +
                '}';
    }
}
