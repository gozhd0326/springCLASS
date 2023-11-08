package hj.securityproject.member.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import hj.securityproject.common.status.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

//시스템 개발자가 개발자 중에서는 최고로 치는데 오퍼레이팅시스템(윈도우 등)을 만드는 사람
//정규식 표현(Regular Expression)은 문자열만 인식할 수 있음.
//때문에 String형으로 바꿈
//Entity와 다르기 때문에 따로 만들어야 됨.
//dto와 모델이 다르면 1대1 맵핑이 어렵기 때문에 좋지 않으나 다를거면 차라리
//dto가 여러개 모델은 하나가 낫다.
public class MemberDto {

	private Long id;
	
	@NotBlank
	private String loginId; //아이디에 준하는 유니크한 키를 지정해야됨. 중복은 허용하지 않음!!
	
	@NotBlank
	@Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%^&*!])[A-Za-z\\d@#$%^&*!]{8,20}$",message = "영문 숫자 특수문자를 포함한 8~20자리로 입력해주세요")
	private String password;
	
	@NotBlank
	private String name;

	@NotBlank
	@Pattern(regexp = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$", message = "날짜형식(YYYY-MM-DD)을 확인해주세요.")
	private String birthDate; //날짜를 입력받는 애
	
	@NotBlank
	@Pattern(regexp = "^(MAN|WOMAN)$", message = "MAN이나 WOMAN중 하나를 선택해주세요.")
	private String gender;
	
	@NotBlank
	@Email
	private String email;


	public MemberDto() {
		super();
	}

	//mapper 서로 다른 것을 연결하기 위해 정보를 맞춰줌.
	//ex)(코드가 길어질 경우에는 method만들어 따로 관리) memberdto2 = member
	public MemberDto(Long id, String loginId, String password, String name, String birthDate, String gender,
			String email) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.birthDate = birthDate;
		this.gender = gender;
		this.email = email;
	}

//DTO를 Entity로 변환

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public LocalDate getBirthDate() {
		return LocalDate.parse(birthDate, //LocalDate로 변환시키는 코드
				DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}


	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}


	public Gender getGender() { //Enum형식의 코드로 변경
		return Gender.valueOf(gender); //문자열타입의 gender를 gender타입으로 변경
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


}
