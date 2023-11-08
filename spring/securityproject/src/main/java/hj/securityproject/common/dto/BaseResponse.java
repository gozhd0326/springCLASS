package hj.securityproject.common.dto;

//컨트롤러가 클라이언트게 응답할 때 그 응답 메시지의 형식을 만드는 클래스
public class BaseResponse<T> {
// 여기서 T는 확장성 때문에 사용함. 어떤 녀석이든 들어갈 수 있음.(제네릭문법)
	private String resultCode;
	
	private T data; //데이터 타입이 무엇이든 다 넣을 수 있음.
	
	private String message;

	public BaseResponse() {
		super();
	}

	public BaseResponse(String resultCode, T data, String message) {
		super();
		this.resultCode = resultCode;
		this.data = data;
		this.message = message;
	}

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
