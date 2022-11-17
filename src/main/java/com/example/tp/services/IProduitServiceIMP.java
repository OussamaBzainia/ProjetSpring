package com.example.tp.services;

import com.example.tp.entities.Produit;
import com.example.tp.entities.Rayon;
import com.example.tp.entities.Stock;
import com.example.tp.repositories.IProduitRepository;
import com.example.tp.repositories.IRayonRepository;
import com.example.tp.repositories.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IProduitServiceIMP implements IProduitService{
    @Autowired
    IProduitRepository iProduitRepository ;
    @Autowired
    IRayonRepository  iRayonRepository;
    @Autowired
    IStockRepository iStockRepository;

    @Override
    public List<Produit> retrieveAllProduits() {
        return iProduitRepository.findAll();
    }

    @Override
    public Produit addProduit(Produit p, Long idRayon, Long idStock) {

       Rayon rayon= iRayonRepository.findById(idRayon).orElse(null);
       Stock stock=iStockRepository.findById(idStock).orElse(null);

       p.setRayon(rayon);
       p.setStock(stock);

       iProduitRepository.save(p);

       return p;
    }

    @Override
    public Produit retrieveProduit(Long id) {
        return iProduitRepository.findById(id).orElse(null);
    }

    @Override
    public void assignProduitToStock(Long idProduit, Long idStock){
        Stock stock =iStockRepository.findById(idStock).orElse(null);
        Produit produit=iProduitRepository.findById(idProduit).orElse(null);

        if(stock != null && produit !=null){
            produit.setStock(stock);
            iProduitRepository.save(produit);
        }

    }
}
