package hj.securityproject.common.status;

//enum은 반드시 써야하는 것은 아님 편리하게 실수하는 것을 줄이기 위해 사용함
public enum ResultCode {

	//success나 error 둘 중하나만 나옴
	
	SUCCESS("정상 처리되었습니다."),
	ERROR("에러가 발생했습니다.");
	
	private final String msg;
	
	private ResultCode(String msg) {
	this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
}
