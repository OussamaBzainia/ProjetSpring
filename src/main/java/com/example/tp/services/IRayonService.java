package com.example.tp.services;

import com.example.tp.entities.Rayon;

public interface IRayonService {

    Rayon retrieveRayon(Long id);

    Rayon addRayon(Rayon r);
}
