package com.hj.employeeManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hj.employeeManagement.model.Employee;
import com.hj.employeeManagement.service.EmployeeService;

@RestController //controller에는 반드시 사용하기
@RequestMapping("/api/employee") //여기 밑에 들어 있는 자식들은 무조건 "/api/employee"로 들어간다. ( 그렇기에 중복되는 주소 ex) @PostMapping("/api/employee") 이런식으로 쓰지 않아도 된다.
public class EmployeeController {


	private EmployeeService employeeService;
	
	//의존성주입이 안되면 employee를 사용할 수 없기 때문에 AutoWired를 사용해야함.(생성자에 AutoWired만들기)
	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	//localhost:8080/api/employee
	//직원정보를 새로 생성한다.
//	ResponseEntity=>편지봉투
//	=>컨트롤러를 사용하여 리스폰스엔티티에 담아 클라이언트에게 전송할 것이다.(처리하는 서블렛이 따로 존재)
//	post는 body에 작성해야 됨
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(
			@RequestBody Employee employee){
//		RequestBody에 employee형태로 담아 전송해라
		
//		test) System.out.println(employee.getFirstName());
//		임플로이에 퍼스트네임을 확인하고
		return new ResponseEntity<Employee>(
				employeeService.saveEmployee(employee),
				//employeeService의 구현체인 employeeImpl이 사용됨
				HttpStatus.CREATED);
//		임플로이형태로 보여줘라.
	
	}
	
	//전체 직원정보를 조회한다.
	@GetMapping()
	public ResponseEntity<List<Employee>> getAllEmployees(){
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees,HttpStatus.OK);
				//employeeService의 구현체인 employeeImpl이 사용됨
	}
	
	//ID로 직원 한명의 정보를 조회한다.
	@GetMapping("{id}")
	//업데이트 할때 아이디를 받는 방법과 이 밑의 방법이 있는데 이 밑의 방법은 변수명을 변경하고 싶을 때 사용한다.
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id")long id2){
		return new ResponseEntity<Employee>(
				employeeService.getEmployeebyId(id2),HttpStatus.OK); 
	}
	//ID로 직원 한명의 정보를 업데이트한다.
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployeeById(
	//바디 정보를 받아야 하기 때문에 @RequsetBody Annotation을 사용한다.
	//@RequestBody와 @PathVariable은 wrapper의 성격을 띈다.
	@RequestBody Employee employee,@PathVariable long id){ //Id 값을 받아야 하기 때문에 @PathVariable(url주소창에 id정보가 있음)을 사용한다.
		return new ResponseEntity<Employee>(
		employeeService.updateEmployeeById(employee, id),
		HttpStatus.OK);
	}
	
	//ID로 직원 한명의 정보를 삭제한다.
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id){
	employeeService.deleteEmployee(id);
	return new ResponseEntity<String>("Employee deleted successfully",HttpStatus.OK);//(Entity,HttpStatus.OK);
	}//entity를 return하는 대신에 문자열을 return한다.
	//void deleteEmployee(long id);

}
