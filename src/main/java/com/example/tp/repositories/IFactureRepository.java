package com.example.tp.repositories;

import com.example.tp.entities.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFactureRepository extends JpaRepository<Facture,Long> {
}
