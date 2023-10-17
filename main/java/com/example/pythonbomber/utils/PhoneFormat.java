package com.example.pythonbomber.utils;

public class PhoneFormat {
    String phone;
    public PhoneFormat(String phone) {
        this.phone = phone;
    }
    public String firstFormat() {
        StringBuilder num = new StringBuilder(phone);
        String format = "38(0" + num.substring(3,5) + ")" + num.substring(5,8) + "-" + num.substring(8,10) + "-" + num.substring(10,12);
        return format;
    }
    public String secondFormat() {
        StringBuilder num = new StringBuilder(phone);
        String format = "+380" + "(" + num.substring(3,5) + ")" + num.substring(5,8) + "-" + num.substring(8,12);
        return format;
    }
}
