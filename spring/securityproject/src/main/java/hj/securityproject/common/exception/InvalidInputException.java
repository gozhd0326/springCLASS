package hj.securityproject.common.exception;

//우리가 직접 excetion(예외사항)을 발생시키기 위해 새로 만듦(발동,처리를 우리가 함)
//RuntimeException은 프로그램이 실행하는 도중 발생하는 모든 Exception을 포함하고 있는 부모이다.
public class InvalidInputException extends RuntimeException{

	//임플리먼츠가 아니기 때문에 오버라이드를 해도 되고 안해도 된다.
	private String fieldName; //baseException에 맞춰 만듦
	private String message;
	public InvalidInputException(String fielName, String message) {
		super();
		this.fieldName = fielName;
		this.message = message;
	}
	public String getFieldName() {
		return fieldName;
	}
	public void setFielName(String fielName) {
		this.fieldName = fielName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
