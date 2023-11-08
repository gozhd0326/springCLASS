package com.hj.firstapp;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

//record 형의 객체는 변경할 수 없고(절대 불변) 겟터 세터도 없음. 
record Person (String name, int age, Address address) {};
record Address(String firstLine, String city) {};


@Configuration
public class HelloWorldConfiguration {

	
	
	@Bean
	public String name() {
//		return "This is bean method.";
		return "Sam";
//		return "Amy";
	}
	@Bean
	public String name2() {
//		return "This is bean method.";
		return "Sam2";
//		return "Amy";
	}
	
	@Bean
	public int age() {
		return 20;
	}
	@Bean
	//	@Primary
	//person이라는 이름을 사용하면 얘가 나옴
	public Person person() {
		return new Person("Tom",25, new Address("Main Street","NY"));
	}
	@Bean
	//	@Primary //우선 순위를 지정
	//Person이라는 클래스를 사용하면 얘가 나옴
	public Person person2() {
		return new Person("Steve",17, new Address("Center Rd","DJ"));
	}
	
	@Bean
	//	@Primary //우선 순위를 지정
	//Person이라는 클래스를 사용하면 얘가 나옴
	public Person personMethodCall() {
		return new Person(name(), age(), address());
	}
	
//	@Bean
//	public Person personParams(String name, int age, Address address2) {
//		return new Person(name,age,address2);	
//	}
	@Bean
	public Person personParams(String name, int age, 
			@Qualifier("addressQualifier") Address address2) {
		return new Person(name,age,address2);	
	}
	
	@Bean(name = "addressBaker") // bean들의 이름이 겹칠 때 bean의 이름을 새로 지정해주는 기능.
	@Qualifier("addressQualifier")
	public Address address() {
		return new Address("Baker Street","London");
	}
	
	@Bean
//	@Primary
	@Qualifier("address2Qualifier")
	public Address address2() {
		return new Address("Baeul-2ro","Daejeon");
	}
	
}
