package com.example.tp.repositories;

import com.example.tp.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
