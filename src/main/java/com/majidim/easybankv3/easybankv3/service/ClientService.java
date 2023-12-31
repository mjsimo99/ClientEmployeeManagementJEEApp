package com.majidim.easybankv3.easybankv3.service;

import com.majidim.easybankv3.easybankv3.dto.Client;
import com.majidim.easybankv3.easybankv3.dto.Personne;
import com.majidim.easybankv3.easybankv3.implementation.ClientImpl;

import java.util.List;
import java.util.Optional;

public class ClientService {
    private final ClientImpl clientImpl;

    public ClientService(ClientImpl clientImpl) {
        this.clientImpl =  clientImpl;
    }

    public List<Client> SearchByCode(String code) {
        return clientImpl.SearchByCode(code);
    }

    public boolean Delete(String code) {
        return clientImpl.Delete(code);
    }

    public List<Client> Showlist() {
        return clientImpl.Showlist();
    }

    public Optional<Client> Update(Client client) {
        return clientImpl.Update(client);
    }

    public Optional<Personne> Add(Personne personne) {
        return clientImpl.Add(personne);
    }

    public List<Client> SearchByLastName(String lastName) {
        return clientImpl.SearchByLastName(lastName);
    }
}


