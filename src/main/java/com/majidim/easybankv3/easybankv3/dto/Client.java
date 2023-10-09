package com.majidim.easybankv3.easybankv3.dto;

import java.time.LocalDate;
import java.util.List;

public final class Client extends Personne{
    private String code ;

    public Client(String code, String nom, String prenom, LocalDate dateN, String tel, String adress) {
        super(nom, prenom, dateN, tel, adress);
        setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }



    @Override
    public String toString() {
        return "Client{" +
                "code='" + code + '\'' +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", dateN=" + getDateN() +
                ", tel='" + getTel() + '\'' +
                ", adress='" + getAdress() + '\'' +
                '}';
    }

}
