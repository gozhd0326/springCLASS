package com.hj.firstapp.game;

public class AppGaming {

	//args(argument)아그스(아규먼트) = 인수 , func1(인수) , parameter(매개변수)=>public String func1(매개변수)
	public static void main(String[]args) {
		
		var marioGame = new MarioGame();
		var superGame = new SuperContraGame();
		var packmanGame = new PackmanGame();
		var gameRunner = new GameRunner(packmanGame);
		gameRunner.run();
	}
}
