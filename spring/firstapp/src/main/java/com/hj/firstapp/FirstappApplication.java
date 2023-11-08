package com.hj.firstapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class FirstappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstappApplication.class, args);
	

//		bean들을 관리하는 컨텍스트(ioc컨테이너)
//		var context = 
//				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//		//AnnotationConfigApplicationContext라는 클래스는 HelloWorldConfiguration 안에 있는 bean들에서 정보를 추출해라.
//		System.out.println(context.getBean("person"));
//		//context는 name이라는 빈메소드에서 얻어와라
//	}
		
//		var context = 
//				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//		//AnnotationConfigApplicationContext라는 클래스는 HelloWorldConfiguration 안에 있는 bean들에서 정보를 추출해라.
//		System.out.println(context.getBean(Person.class));
//		//context는 name이라는 빈메소드에서 얻어와라
//	}
//	}
//		var context = 
//				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//		//AnnotationConfigApplicationContext라는 클래스는 HelloWorldConfiguration 안에 있는 bean들에서 정보를 추출해라.
//		System.out.println(context.getBean("address"));
//		//context는 name이라는 빈메소드에서 얻어와라
//	}
//	}
//	var context = 
//			new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//	//AnnotationConfigApplicationContext라는 클래스는 HelloWorldConfiguration 안에 있는 bean들에서 정보를 추출해라.
//	System.out.println(context.getBean("addressBaker"));
//	//context는 name이라는 빈메소드에서 얻어와라
//}
	
//		bean들을 관리하는 컨텍스트(ioc컨테이너)
//		var context = 
//				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
//		//AnnotationConfigApplicationContext라는 클래스는 HelloWorldConfiguration 안에 있는 bean들에서 정보를 추출해라.
//		System.out.println(context.getBean("personMethodCall"));
//		//context는 name이라는 빈메소드에서 얻어와라
//	}
//		
		var context = 
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		//AnnotationConfigApplicationContext라는 클래스는 HelloWorldConfiguration 안에 있는 bean들에서 정보를 추출해라.
		System.out.println(context.getBean("personParams"));
		//context는 name이라는 빈메소드에서 얻어와라
	}
		
		
	@Bean
	public ServletRegistrationBean<MyServlet> myServelt(){
		ServletRegistrationBean<MyServlet> registraitonBean = new ServletRegistrationBean<>(new MyServlet(), "/my-servlet");
		return registraitonBean;
	}

}
