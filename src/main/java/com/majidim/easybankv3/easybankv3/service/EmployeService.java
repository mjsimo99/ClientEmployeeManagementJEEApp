package com.majidim.easybankv3.easybankv3.service;

import com.majidim.easybankv3.easybankv3.dto.Employe;
import com.majidim.easybankv3.easybankv3.dto.Personne;
import com.majidim.easybankv3.easybankv3.implementation.ClientImpl;
import com.majidim.easybankv3.easybankv3.implementation.EmployeImpl;

import java.util.List;
import java.util.Optional;

public class EmployeService {
    private final EmployeImpl employeImpl;

    public EmployeService(EmployeImpl employeImpl) {
        this.employeImpl = employeImpl;
    }
    public List<Employe> SearchByMatricule(String matricule){
        return employeImpl.SearchByMatricule(matricule);
    }
    public boolean Delete(String marticule){
        return employeImpl.Delete(marticule);
    }
    public List<Employe> ShowList(){
        return employeImpl.ShowList();
    }
    public List<Employe> SearchByEmail(String emailAdresse){
        return employeImpl.SearchByEmail(emailAdresse);
    }
    public Optional<Employe> Update(Employe employe){
        return employeImpl.Update(employe);
    }
    public Optional<Personne> add(Personne personne) {
        return employeImpl.Add(personne);
    }

}
