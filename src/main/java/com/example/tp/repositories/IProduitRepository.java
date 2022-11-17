package com.example.tp.repositories;

import com.example.tp.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProduitRepository extends JpaRepository<Produit,Long> {
}
