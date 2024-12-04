package com.raincloud.wash_and_wow.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_bank_details")
public class VendorBankDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "vendor_id", nullable = false)
    private Vendor vendor;

    @Column(name = "bank_account_number", unique = true , nullable = false)
    private String bankAccountNumber;

    @Column(name = "bank_name", nullable = false)
    private String bankName;

    @Column(name = "bank_branch", nullable = false)
    private String bankBranch;

    @Column(name = "account_holder_name", nullable = false)
    private String accountHolderName;

    @Column(name = "ifsc_code", nullable = false)
    private String ifscCode;

    @Column(name = "bank_address", nullable = false)
    private String bankAddress;

    @Column(name = "account_type", nullable = false)
    private String accountType;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    public VendorBankDetail() {
    }

    public VendorBankDetail(Vendor vendor, String bankAccountNumber, String bankName, String bankBranch, String accountHolderName, String ifscCode, String bankAddress, String accountType, String paymentMethod) {
        this.vendor = vendor;
        this.bankAccountNumber = bankAccountNumber;
        this.bankName = bankName;
        this.bankBranch = bankBranch;
        this.accountHolderName = accountHolderName;
        this.ifscCode = ifscCode;
        this.bankAddress = bankAddress;
        this.accountType = accountType;
        this.paymentMethod = paymentMethod;
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

    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "VendorBankDetail{" +
                "id=" + id +
                ", vendor=" + vendor +
                ", bankAccountNumber='" + bankAccountNumber + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankBranch='" + bankBranch + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", bankAddress='" + bankAddress + '\'' +
                ", accountType='" + accountType + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }
}
