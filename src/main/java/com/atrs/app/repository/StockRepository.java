package com.atrs.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.atrs.app.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

}
