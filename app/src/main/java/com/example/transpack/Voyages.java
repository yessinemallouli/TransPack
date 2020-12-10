package com.example.transpack;

public class Voyages {
    private String paysdepart;
    private String paysarrivee;
    private String datedepart;
    private String datearrivee;
    private Float prix;
    private String name;
    private Long phone;

    public Voyages() {
    }

    public Voyages(String paysdepart, String paysarrivee, String datedepart, String datearrivee, Float prix, String name, Long phone) {
        this.paysdepart = paysdepart;
        this.paysarrivee = paysarrivee;
        this.datedepart = datedepart;
        this.datearrivee = datearrivee;
        this.prix = prix;
        this.name = name;
        this.phone = phone;
    }

    public String getPaysdepart() {
        return paysdepart;
    }

    public void setPaysdepart(String paysdepart) {
        this.paysdepart = paysdepart;
    }

    public String getPaysarrivee() {
        return paysarrivee;
    }

    public void setPaysarrivee(String paysarrivee) {
        this.paysarrivee = paysarrivee;
    }

    public String getDatedepart() {
        return datedepart;
    }

    public void setDatedepart(String datedepart) {
        this.datedepart = datedepart;
    }

    public String getDatearrivee() {
        return datearrivee;
    }

    public void setDatearrivee(String datearrivee) {
        this.datearrivee = datearrivee;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
