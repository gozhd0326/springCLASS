package com.spring.gameShopBackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.gameShopBackEnd.model.Game;

public interface GameShopRepository extends JpaRepository<Game, Long>{

}
