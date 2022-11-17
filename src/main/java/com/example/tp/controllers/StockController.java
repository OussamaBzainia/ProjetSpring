package com.example.tp.controllers;


import com.example.tp.entities.Stock;
import com.example.tp.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    IStockService iStockService;

    @GetMapping("/retrieveAllStocks")
    public List<Stock> retrieveAllStocks(){
        return iStockService.retrieveAllStocks();
    }

    @PostMapping("/addStock")
    public Stock addStock(@RequestBody Stock s){
        return iStockService.addStock(s);
    }

    @PutMapping("/updateStock")
    public Stock updateStock(@RequestBody Stock u){
        return iStockService.updateStock(u);
    }

    @GetMapping("/retrieveStock/{id}")
    public Stock retrieveStock(@PathVariable Long id){
        return iStockService.retrieveStock(id);
    }


}
