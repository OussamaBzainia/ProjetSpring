package com.example.tp.repositories;

import com.example.tp.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStockRepository extends JpaRepository<Stock,Long> {
}
