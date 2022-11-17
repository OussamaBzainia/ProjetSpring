package com.example.tp.services;

import com.example.tp.entities.Stock;

import java.util.List;

public interface IStockService {

    List<Stock> retrieveAllStocks();

    Stock addStock(Stock s);

    Stock updateStock(Stock u);

    Stock retrieveStock(Long id);
}
