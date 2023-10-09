package com.majidim.easybankv3.easybankv3.dto;

import java.time.LocalDate;
import java.util.List;

public final class Employe extends Personne {
    private String matricule;
    private LocalDate dateRecrutement;
    private String emailAdresse;



    public Employe(String nom, String prenom, LocalDate dateN, String tel, String adress, String matricule, LocalDate dateRecrutement, String emailAdresse) {
        super(nom, prenom, dateN, tel, adress);
        setMatricule(matricule);
        setDateRecrutement(dateRecrutement);
        setEmailAdresse(emailAdresse);
    }









    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateRecrutement() {
        return dateRecrutement;
    }

    public void setDateRecrutement(LocalDate dateRecrutement) {
        this.dateRecrutement = dateRecrutement;
    }

    public String getEmailAdresse() {
        return emailAdresse;
    }

    public void setEmailAdresse(String emailAdresse) {
        this.emailAdresse = emailAdresse;
    }

    @Override
    public String toString() {
        return "Employe{" +
                "matricule='" + getMatricule() + '\'' +
                ", dateRecrutement=" + getDateRecrutement() +
                ", emailAdresse='" + getEmailAdresse() + '\'' +
                ", nom='" + getNom() + '\'' +
                ", prenom='" + getPrenom() + '\'' +
                ", dateN=" + getDateN() +
                ", tel='" + getTel() + '\'' +
                ", adress='" + getAdress() + '\'' +
                '}';
    }
}
