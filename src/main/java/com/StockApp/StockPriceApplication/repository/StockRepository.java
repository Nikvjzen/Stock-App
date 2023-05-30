package com.StockApp.StockPriceApplication.repository;

import com.StockApp.StockPriceApplication.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<StockEntity, Integer> {

    Optional<StockEntity> findByStockName(String string);
}