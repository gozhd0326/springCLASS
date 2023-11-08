package com.hj.firstapp.DI;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class DIApplication {

	
//	익셉션 핸들링 => 예외 상황이 생겼을 때 어떻게 해야될까
//	위험 부담이 있는 코드는 try를 이용해서 작성
	//main은 하나만 존재해야 되기 때문에 main Application에서만 사용함.
	public static void main(String[] args) {
		
		try(var context =  new AnnotationConfigApplicationContext(DIApplication.class)){
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
		System.out.println(context.getBean(MyBusiness.class));
		} 
//		context가 null 이면 실행이 안됨
//		}catch{
//			
//		}
		// 성공이면 try 실패면

//		org.springframework.context.annotation.internalConfigurationAnnotationProcessor
//		org.springframework.context.annotation.internalAutowiredAnnotationProcessor
//		org.springframework.context.annotation.internalCommonAnnotationProcessor
//		org.springframework.context.event.internalEventListenerProcessor
//		org.springframework.context.event.internalEventListenerFactory
//		얘네는 기본적으로 context에 포함되어 있는 애들임. 모두 빈으로 등록되어있다는 증거임.
	}

}
