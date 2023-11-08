package com.spring.gameShopBackEnd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.spring.gameShopBackEnd.model.Game;
import com.spring.gameShopBackEnd.model.Purchase;
import com.spring.gameShopBackEnd.service.GameShopService;

@RestController
@RequestMapping("/products")
@CrossOrigin(origins="http://localhost:3000",
methods= {RequestMethod.GET,RequestMethod.POST}) //원래는 front가 8080이지만 이것은 리액트에서 만든 테스트 서버이기 때문에 3000이 맞다.
public class GameShopController {

	private GameShopService gameShopService;

	
	@Autowired
	public GameShopController(GameShopService gameShopService) {
		super();
		this.gameShopService = gameShopService;
	}
	
	@Autowired
	public GameShopService gameShopService() {
		return gameShopService;
	}
	
	@Autowired
	public void setGameShopService(GameShopService gameShopService) {
		this.gameShopService = gameShopService;
	}
	//game정보를 새로 생성
	@PostMapping()
	public ResponseEntity<Game> saveGame(
			@RequestBody Game game){
		
		return new ResponseEntity<Game>(
		gameShopService.saveGame(game),
		HttpStatus.CREATED);
	}
			
	//전체 game의 정보를 조회한다.
	@GetMapping()
	public ResponseEntity<List<Game>> getAllGames(){
		System.out.println("request from FrontEnd");
		List<Game> game = gameShopService.getAllGames();
		return new ResponseEntity<>(game,HttpStatus.OK);
			
	}
	//ID로 게임 하나를 조회한다.
	@GetMapping("{id}")
	public ResponseEntity<Game> getGameById(
			@RequestBody Game game, @PathVariable long id ){
		return new ResponseEntity<Game>
		(gameShopService.getGameById(id),
				HttpStatus.OK);
	}
	
	//game 한 개의 정보를 업데이트한다.
	@PutMapping("{id}") //언제나 바뀌는 값 변수라서 중괄호를 사용하여 변수로 받아줌. 그렇지 않으면 여러 번 코드를 작성해주어야 됨.(Pathvariable)
	public ResponseEntity<Game> updateGameById(
			@RequestBody Game game, @PathVariable long id){
		return new ResponseEntity<Game>
		(gameShopService.updateGameById(game,id),
		HttpStatus.OK);
	}
	
	//game 한 개를 삭제하겠다.
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteGameById(
			@RequestBody Game game, @PathVariable long id){
		gameShopService.deleteGameById(id);
		return new ResponseEntity<String>("Game deleted successfully",HttpStatus.OK);
	}
	
	@PostMapping("purchase") //고정값(Path) 언제나 항상 같음.
	public ResponseEntity<Purchase> savePurcahse(@RequestBody Purchase purchase){
		return new ResponseEntity<Purchase>(
				gameShopService.savePurchase(purchase),HttpStatus.OK);
	}
	
	@PostMapping("purchaselist")
	public ResponseEntity<List<Purchase>> savePurchaseList(
			@RequestBody List<Purchase> purchaseList){
		List<Purchase> savedPurchaseList = new ArrayList<Purchase>();//배열을 만듦
		for(Purchase purchase : purchaseList) {
			savedPurchaseList.add(gameShopService.savePurchase(purchase));
		}
		return new ResponseEntity<List<Purchase>>(savedPurchaseList,HttpStatus.OK);
	}
	
	
	@GetMapping("purchase")
	public ResponseEntity<List<Purchase>> getAllPurchase(){
		return new ResponseEntity<List<Purchase>>(
				gameShopService.getAllPurchase(),HttpStatus.OK);
	}
	
}
