package com.hj.firstapp.game;

//MarioGame은 구현체임.
public class MarioGame implements GamingConsole{
	
	public void up() {
		System.out.println("Jump");
	}
	public void down() {
		System.out.println("Go in a hole");
	}
	public void left() {
		System.out.println("Go back");
	}
	public void right() {
		System.out.println("Accelerate");
	}
}
