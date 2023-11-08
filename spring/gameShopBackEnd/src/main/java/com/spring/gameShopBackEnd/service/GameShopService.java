package com.spring.gameShopBackEnd.service;

import java.util.List;

import com.spring.gameShopBackEnd.model.Game;
import com.spring.gameShopBackEnd.model.Purchase;

//어노테이션을 사용할 수 없음. 어노테이션을 사용하면 객체가 빈이 되기 때문에(그 객체의 생명주기를 스프링이 관리(ioc 컨테이너))
//interface는 객체를 인스턴스화 할 수 없기 때문에
public interface GameShopService {

	//gaem을 save하고 그것을 그대로 return 함
	Game saveGame(Game game); //game을 저장 //game 정보를 생성
	List<Game> getAllGames(); //game을 List형태로 return //전체 게임 조회
	Game getGameById(long id);//game 형태로 return //game 하나를 ID로 조회한다.
	Game updateGameById(Game game, long id); //Game 하나를 업데이트한다.
	void deleteGameById(long id); //Game 하나를 지운다.
	Purchase savePurchase(Purchase purchase);//구매 목록 저장
	List<Purchase> getAllPurchase();//구매한 목록을 전부 준다.
	
}
