package com.majidim.easybankv3.easybankv3.interfeces;


import com.majidim.easybankv3.easybankv3.dto.Personne;

import java.util.Optional;

public interface IPersonne {
    Optional<Personne> Add(Personne personne);
}


