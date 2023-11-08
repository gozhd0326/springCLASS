package com.spring.gameShopBackEnd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.gameShopBackEnd.exception.ResourceNotFoundException;
import com.spring.gameShopBackEnd.model.Game;
import com.spring.gameShopBackEnd.model.Purchase;
import com.spring.gameShopBackEnd.repository.GameShopRepository;
import com.spring.gameShopBackEnd.repository.PurchaseRepository;
import com.spring.gameShopBackEnd.service.GameShopService;

@Service
public class GameShopServiceImpl implements GameShopService{
private GameShopRepository gameShopRepository;
private PurchaseRepository purchaseRepository;

@Autowired
public GameShopServiceImpl(GameShopRepository gameShopRepository,
		PurchaseRepository purchaseRepository) {
	super();
	this.gameShopRepository = gameShopRepository;
	this.purchaseRepository = purchaseRepository;
}

@Override
public Game saveGame(Game game) {
	return gameShopRepository.save(game);
}

@Override
public List<Game> getAllGames(){
	return gameShopRepository.findAll();
}

@Override
public Game getGameById(long id) {
	return gameShopRepository.findById(id).orElseThrow(()->
	new ResourceNotFoundException("Game","ID",id));
}

@Override
public Game updateGameById(Game game,long id) {
	Game existingGame = gameShopRepository.findById(id).orElseThrow(()->
	new ResourceNotFoundException("Game","ID",id));
	existingGame.setTitle(game.getTitle());
	existingGame.setPrice(game.getPrice());
	existingGame.setGenre(game.getGenre());
	existingGame.setImage(game.getImage());
	existingGame.setText(game.getText());
	
	gameShopRepository.save(existingGame);
	return existingGame;
}

@Override
public void deleteGameById(long id) {
	gameShopRepository.findById(id).orElseThrow(()->
	new ResourceNotFoundException("Game","ID",id));
	gameShopRepository.deleteById(id);
}

@Override
public Purchase savePurchase(Purchase purchase) {
	return purchaseRepository.save(purchase);
}

@Override
public List<Purchase> getAllPurchase() {
	return purchaseRepository.findAll();
}
}
