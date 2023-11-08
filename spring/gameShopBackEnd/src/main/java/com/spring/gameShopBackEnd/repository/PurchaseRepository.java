package com.spring.gameShopBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.gameShopBackEnd.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>{

}
