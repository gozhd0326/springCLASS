//Entity!! 데이터를 담당하고 있다!

package com.hj.employeeManagement.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//class에는 필드, 생성자, getter&setter가 필수적으로 들어간다. 

//import가 제대로 되지 않았다면 pom.xml에 jpa가 제대로 작동하지 않는다는 것임
//jpa가 데이터베이스와 스프링을 관리함.
//jpa는 관계형데이터베이스에서만 사용 가능
//테이블에서 컬럼 -> 키  로우-> 벨류
//절대 없으면 안되는 컬럼 => id
//여기서는 model = entity

@Entity //jpa가 있을 때만 사용가능(jpa와 연동, jpa에 의해 관리됨.) Employee를 테이블로 만듦 테이블을 관계형데이터베이스에 맞게 명령을 만들어줌. 스키마를 만들어야겠다고 인식
@Table(name = "employess")//테이블이라는 이름을 지을 수 있음.
public class Employee {

	@Id //이것을 붙여야 아이디로 입력
	//strategy = 절약이라는 뜻
	@GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스에서 알아서 아이디 값을 증가시킨다. //mySQL에서 사용하는 방법 
	private long id; //long형은 인티저(int형)보다 더 길게 담을 수 있음.//특별하기 때문에 어노테이션을 지정함.
	
	@Column(name = "first_name", nullable = false)//데이터베이스는 보통 스네이크케이스를 사용. column어노테이션은 컬럼의 이름을 다시 지정할 수 있음.
	private String firstName;
	@Column(name = "last_name", nullable = false)//여러가지 제한,규칙들을 넣을 수 있음(예)nullable등의 속성을 넣을 수 있음. nullalbe은 null값을 허용하는지 여부를 정할 수 있음.
	private String lastName;
	@Column(name = "email")
	private String email;
	
//	Entity에는 반드시 기본생성자가 필요하다!!!(Java의 Reflection 때문)
	public Employee() {
		
	} // => 기본생성자임
	
	public Employee(long id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
