package com.majidim.easybankv3.easybankv3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public abstract class Personne {
    protected String nom;
    protected String prenom;
    protected LocalDate dateN;
    protected String tel;
    protected String adress;


}

