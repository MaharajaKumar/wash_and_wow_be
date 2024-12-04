package com.raincloud.wash_and_wow.util;

public class ValidationPatterns {
    public static final String code = "^[a-zA-Z]{3}[0-9]*$";
    public static final String mobileNo = "^[6-9][0-9]{9}$";
    public static final String password = "^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+=-{};:'<>,./?]).{6,}$";
    public static final String alphabetsWithSpace = "^[a-zA-Z .]+$";
    public static final String postalCode = "^\\d{6}$";
    public static final String latitude = "^-?([0-8]?[0-9]|90)(\\.[0-9]+)?$";
    public static final String longitude = "^-?((180)|(1[0-7][0-9])|(0[0-9]{1,2}))(\\\\.[0-9]*)?$";

    public static final String inValidCodeMessage = "Invalid code";
    public static final String inValidUserIdMessage = "Invalid user id";
    public static final String inValidNameMessage = "Invalid name";
    public static final String inValidMobileNo = "Invalid mobile number";
    public static final String inValidEmailMessage = "Invalid email address";
    public static final String inValidPasswordMessage = "Invalid password";
    public static final String inValidPostalCodeMessage = "Invalid postal code";
    public static final String inValidLatitudeMessage = "Invalid latitude";
    public static final String inValidLongitudeMessage = "Invalid longitude";
    public static final String inValidDateOfBirthMessage = "Date of Birth must not be null or empty";
}