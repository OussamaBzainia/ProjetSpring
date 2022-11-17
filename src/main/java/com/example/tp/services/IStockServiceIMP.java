package com.example.tp.services;

import com.example.tp.entities.Stock;
import com.example.tp.repositories.IStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IStockServiceIMP implements IStockService{

    @Autowired
    IStockRepository iStockRepository;

    @Override
    public List<Stock> retrieveAllStocks() {
        return iStockRepository.findAll();
    }

    @Override
    public Stock addStock(Stock s) {
        return iStockRepository.save(s);
    }

    @Override
    public Stock updateStock(Stock u) {
        return iStockRepository.save(u);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return iStockRepository.findById(id).orElse(null);
    }
}
