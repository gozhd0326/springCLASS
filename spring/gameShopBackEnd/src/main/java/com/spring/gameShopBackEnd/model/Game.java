package com.spring.gameShopBackEnd.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//setter만이 유일하게 private를 수정할 수 있음.(setter가 없는 경우에는 영원불멸.. 변경하지 못함...) public으로 지정하면 언제나 바꿀 수 있음.
@Entity // 반드시 기본생성자가 필요하다. // JPA가 리플렉션이라는 기술을 사용하는데 그 기술은 기본생성자가 있어야 사용할 수 있음.
@Table(name = "games")
public class Game {

//	class를 은닉하기 위해 private를 사용함. // 버그가 생기는 것을 미연에 방지(외부에서 접근하지 못하도록)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String title;
	@Column
	private String genre;
	@Column
	private int price;
	@Column
	private String image;
	@Column
	private String text;

	//	필드 끝~~~~
	
	//일반적인 생성자!!
	public Game(long id, String title, String genre, int price, String image, String text) {
		super(); //super는 없어도 상관 없음!
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.image = image;
		this.text = text;
	}
	// 기본생성자 생성!!(데이터 타입이 없는 것)(순서는 상관 없음!)
	public Game() {
		super();
	}

	
	
	//getter setter 만들기~~
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	

	
}
