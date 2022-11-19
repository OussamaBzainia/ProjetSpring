package com.example.tp.services;

import com.example.tp.entities.Produit;

import java.util.List;

public interface IProduitService {
    List<Produit> retrieveAllProduits();

    Produit addProduit(Produit p, Long idRayon, Long idStock);

    Produit retrieveProduit(Long id);
    void assignProduitToStock(Long idProduit, Long idStock);
    void assignFournisseurToProduit(Long fournisseurId, Long produitId) ;
}
