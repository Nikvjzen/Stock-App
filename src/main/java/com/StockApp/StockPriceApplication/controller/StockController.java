package com.StockApp.StockPriceApplication.controller;

import com.StockApp.StockPriceApplication.entity.StockEntity;
import com.StockApp.StockPriceApplication.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StockController {

    @Autowired
    StockService stockService;

    //Just for checking API in postman, Not related to WS.
    @GetMapping("/stocks")
    @SendTo("/topic/stocks")
    public ResponseEntity getData(){
        List<StockEntity> response = stockService.getAllStocks();
        return ResponseEntity.ok().body(response);
    }
}