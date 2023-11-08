package com.hj.firstapp.DI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


// class에는 필드와 생성자, 겟터 세터가 반드시 있어야함(bean의 경우에는 특히!!! 하지 않을 시 ioc에 엑세스할 방법이 없어짐.)
//오토와이어드는 생성자에 달아주는게 가장 좋음.


//MyBusiness는 Dependency1, Dependency2에 대한 의존성을 띄고 있음.
@Component
public class MyBusiness {

	Dependency1 dependency1;
	Dependency2 dependency2;
	
//	필드에 달아주는 방법! 제일 최악의 방법. cpu에게는 다시 일처리 하게 해야 됨.
//	@Autowired //이 어노테이션이 선언된 디펜던시를 사용하면 자동으로 메모리 주소가 연결이 됨.  인젝션 = 참조복사
////	명시적인 표시를 해줘야 이 아이가 얘를 쓰겠다고 알려줌. 이 아이를 쓰지 않고 자동으로 연결되게 할 수도 있지만 문제 점이 더 많음.(사용티켓)
	
	//Dependency1 dependency1;
////	
////	@Autowired
	//Dependency2 dependency2;
//
//	
	
//	Bean으로 되어있는 애들은 spring이 대신 만들어 구현해줌.(single turn으로 나오기 때문에 new로 만들지 않음) dependency injection(의존성주입);
//	Dependency1 dependency1 = new Dependency1();
//	Dependency2 dependency2 = new Dependency2();
	
//세터에 달아주는 방법! 세터의 값이 바뀔 때만 호출되기 때문에 무조건 실행된다는 보장이 없음.

//	@Autowired
//	public void setDependency1(Dependency1 dependency1) {
//		this.dependency1 = dependency1;
//	}
//
//	@Autowired
//	public void setDependency2(Dependency2 dependency2) {
//		this.dependency2 = dependency2;
//	}



	//String의 내용을 표현해주는 함수
	public String toString() {
		// toString => dependency를 제대로 가져왔는지 확인하는 것
		return "Using" + dependency1 + " and " + dependency2;
	}

	
//	생성자에 달아주는 방식! Spring에서 권장하는 방식! 무조건 생성자는 불려야 하기 때문에 그 때 같이 일을하면 됨으로 가장 효율적임
//	생성자를 만들어주면 자동으로 오토와이어가 실행됨. 하지만 명시적으로 써주는 것은 좋은 습관임.
	@Autowired
	public MyBusiness(Dependency1 dependency1, Dependency2 dependency2) {
	super();
	this.dependency1 = dependency1;
	this.dependency2 = dependency2;
} 
}
@Component
class Dependency1{
	
}

@Component
class Dependency2{
	
}