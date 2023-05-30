package com.StockApp.StockPriceApplication.service;

import com.StockApp.StockPriceApplication.entity.StockEntity;
import com.StockApp.StockPriceApplication.repository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class StockService {
    @Autowired
    StockRepository stockRepository;

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Scheduled(fixedRate = 2000)
    public void updateAppleStockPrice() {
        Optional<StockEntity> stockOptional = stockRepository.findByStockName("Apple");

        if (stockOptional.isPresent()) {
            StockEntity stock = stockOptional.get();
            int newPrice = generateRandomPrice();
            stock.setStockPrice(newPrice);
            stockRepository.save(stock);

        }
    }

    @Scheduled(fixedRate = 3000)
    public void updateIBMStockPrice() {
        Optional<StockEntity> stockOptional = stockRepository.findByStockName("IBM");

        if (stockOptional.isPresent()) {
            StockEntity stock = stockOptional.get();
            int newPrice = generateRandomPrice();
            stock.setStockPrice(newPrice);
            stockRepository.save(stock);
        }
    }

    @Scheduled(fixedRate = 1000)
    public void updateInfosysStockPrice() {
        Optional<StockEntity> stockOptional = stockRepository.findByStockName("Infosys");

        if (stockOptional.isPresent()) {
            StockEntity stock = stockOptional.get();
            int newPrice = generateRandomPrice();
            stock.setStockPrice(newPrice);
            stockRepository.save(stock);
        }
    }

    @Scheduled(fixedRate = 2500)
    public void updateRelianceStockPrice() {
        Optional<StockEntity> stockOptional = stockRepository.findByStockName("Reliance");

        if (stockOptional.isPresent()) {
            StockEntity stock = stockOptional.get();
            int newPrice = generateRandomPrice();
            stock.setStockPrice(newPrice);
            stockRepository.save(stock);
        }
    }

    @Scheduled(fixedRate = 1500)
    public void updateZensarStockPrice() {
        Optional<StockEntity> stockOptional = stockRepository.findByStockName("Zensar");

        if (stockOptional.isPresent()) {
            StockEntity stock = stockOptional.get();
            int newPrice = generateRandomPrice();
            stock.setStockPrice(newPrice);
            stockRepository.save(stock);
        }
    }

    @Scheduled(fixedDelay = 1000)
    public void updatedPrice() {
        simpMessagingTemplate.convertAndSend("/topic/stocks", stockRepository.findAll());
    }



    private int generateRandomPrice() {
        Random rand = new Random();
        int min = 50;
        int max = 200;
        return rand.nextInt((max - min) + 1) + min;
    }

    public List<StockEntity> getAllStocks() {

        return stockRepository.findAll();
    }

}
