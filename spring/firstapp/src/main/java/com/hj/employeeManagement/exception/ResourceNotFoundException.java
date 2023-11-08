package com.hj.employeeManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//예외처리 과정 시 RuntimeException을 상속받는다.
//RuntimeException은 상위 익셉션이기 때문
@ResponseStatus(value = HttpStatus.NOT_FOUND)//에러가 발생했을 때 http로 어떤 에러코드를 보여줄 것인지
public class ResourceNotFoundException extends RuntimeException{

//시리얼 = 시리얼라이즈 (직렬화) 오류를 잡아내기 위함(이 코드를 보고 어디서 오류가 났는지 잘못되었는지 확인할 수 있음, 누가 잘못했는지 로그를 확인함)
	private  static final long serialVersionUID = 1L; //long형이기 때문에 뒤에 대문자 L을 붙임(플롯은 F)
	private String resourceName; //무슨 문제가 일어났느냐(여러가지 상황)
	private String fieldName; //(네가 지금 찾고 있는 것)
	private Object fieldValue;//해당하는 것(문자,숫자,플롯 등 그래서 오브젝트를 사용함. 어떤 값이든 다 받을 수 있어서)을 못찾았다는 것을 알려주기 위한
	
	//자기 생성자
	public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
		super(String.format("%snot found with %s: ", resourceName, fieldName, fieldValue)); //상속받은 녀석만 찾을 수 있음. 부모의 생성자를 찾는다.
		//%s 는 달러표시 대신에 사용한다(백틱과 비슷하지만 다르다)
		//예외처리는 수정할 수 없다.
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
		
	}

	public String getResourceName() {
		return resourceName;
	}

	public String getFieldName() {
		return fieldName;
	}


	public Object getFieldValue() {
		return fieldValue;
	}

	
	
	
	
}
