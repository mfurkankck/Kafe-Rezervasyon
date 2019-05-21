package com.example.kaferezervasyon.model;


import java.util.HashMap;

public class Rezervasyon {
    private String isim;
    private String tarih;
    private String bassaati;
    private String bitsaati;
    private String mail;
    private String telefon;
    private String menü ;
    private String masa ;
    private HashMap<Integer, Integer> yemekSayisi;

    public void setIsim(String isim) {
        this.isim = isim;

    }

    public void setTarih(String tarih) {
        this.tarih = tarih;



    }

    public void setBassaati(String bassaati) {
        this.bassaati = bassaati;
    }

    public void setBitsaati(String bitsaati) {
        this.bitsaati = bitsaati;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setMenü(String menü) {
        this.menü = menü;
    }

    public void setMasa(String masa) {
        this.masa = masa;
    }

    public String getIsim() {
        return isim;

    }

    public String getTarih() {
        return tarih;
    }

    public String getBassaati() {
        return bassaati;
    }

    public String getBitsaati() {
        return bitsaati;
    }

    public String getMail() {

        return mail;
    }

    public String getTelefon() {
        return telefon;
    }

    public String getMenü() {
        return menü;
    }

    public String getMasa() {
        return masa;
    }

    public HashMap<Integer, Integer> getYemekSayisi() {
        return yemekSayisi;
    }

    public void setYemekSayisi(HashMap<Integer, Integer> yemekSayisi) {
        this.yemekSayisi = yemekSayisi;
    }
}
