package com.majidim.easybankv3.easybankv3.interfeces;

import com.majidim.easybankv3.easybankv3.dto.Client;
import com.majidim.easybankv3.easybankv3.dto.Personne;

import java.util.List;
import java.util.Optional;

public interface IClient extends IPersonne {
    List<Client> SearchByCode(String code);
    boolean Delete(String code);
    List<Client> Showlist();
    Optional<Client> Update(Client client);
    Optional<Personne> Add(Personne personne);
}
