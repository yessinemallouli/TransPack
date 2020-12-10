package com.example.transpack;

public class CTmer {
    String name;
    String mail;
    String password;
    Long phone;

    public CTmer() {
    }

    public CTmer(String name, String mail, String password, Long phone) {
        this.name = name;
        this.mail = mail;
        this.password = password;
        this.phone = phone;
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
}
