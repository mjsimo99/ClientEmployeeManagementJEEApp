package com.majidim.easybankv3.easybankv3.interfeces;


import com.majidim.easybankv3.easybankv3.dto.Client;

import java.util.List;
import java.util.Optional;

public interface IClient extends IPersonne {
    List<Client> SearchByCode(String code);
    boolean Delete(String code);
    List<Client> Showlist() ;
    List<Client> SearchByLastName(String prenom);
    Optional<Client> Update(Client client);
}
