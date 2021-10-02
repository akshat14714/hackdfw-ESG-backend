package com.akshat14714.stockcalculator.repository;

import com.akshat14714.stockcalculator.common.dtos.User;
import com.akshat14714.stockcalculator.common.dtos.UserStocks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Component
public interface StockRepository extends JpaRepository<UserStocks, Integer> {

    @Query(value = "SELECT s FROM StockTable s WHERE s.userId = ?1")
    List<UserStocks> findAllStocksByUserId(int userId);
}
