package com.example.transpack;

public class Transporter {
    String name;
    String mail;
    String password;
    Long phone;
    Long cin;


    public Transporter() {
    }

    public Transporter(String name, String mail, String pass, String phone, String cin) {
    }

    public Transporter(String name, String mail, String password, Long phone, Long cin) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
        this.cin = cin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public Long getCin() {
        return cin;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }
}
