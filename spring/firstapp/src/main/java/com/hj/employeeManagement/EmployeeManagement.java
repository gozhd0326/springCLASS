//main임. springbootapplication이 무조건 있어야 됨. componentscan이 들어 있기 때문에!!(자식들을 bean화 할 수 있음)
package com.hj.employeeManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//보통 패키지명은 소문자로 시작(캐멀케이스는 상관 없음) 클래스명은 대문자로 시작

@SpringBootApplication
public class EmployeeManagement {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	SpringApplication.run(EmployeeManagement.class, args); //스스로를 run
	}

}
