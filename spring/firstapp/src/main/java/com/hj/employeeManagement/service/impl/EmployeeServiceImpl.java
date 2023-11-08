package com.hj.employeeManagement.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hj.employeeManagement.exception.ResourceNotFoundException;
import com.hj.employeeManagement.model.Employee;
import com.hj.employeeManagement.repository.EmployeeRepository;
import com.hj.employeeManagement.service.EmployeeService;

//@Service를 사용하면 imployee의 구현체가 서비스로 인해 빈이 된다. 빈의 형태로 만들어줘야 AutoWired를 사용할 수 있음.
@Service
public class EmployeeServiceImpl implements EmployeeService {
private EmployeeRepository employeeRepository;

@Autowired
public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
super();
this.employeeRepository = employeeRepository;
}
	//직원정보를 새로 생성한다.
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	//전체 직원 정보를 조회한다.
	@Override
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	//ID로 직원 한명의 정보를 조회한다.
	@Override
	public Employee getEmployeebyId(long id) {
		
//		Optional<Employee> employee = employeeRepository.findById(id); //다른 기능들의 매우 기본이기 때문에 선택사항이 많고 없으면 익셉션(예외처리를 한다).
//		if(employee.isPresent()) {
//			return employee.get();
//			}else {
//				return null;
//			}
		//optional employee의 객체 형태(optional 객체에는 여러 메소드가 있다. (예외처리 기능들이 있다.)예외를 자바에서는 보통 던진다고 표현함.)
		return employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","ID",id)); //원래 기존의 자바스크립트와 비슷한 형태로 작성함. ((여기에는 관련 정보를 넣어줌)->우리는 여기가 null이기 때문에 괄호에 아무것도 넣지 않음.) 

	}
//	(Id말고도 이름이나 연봉으로도 조회가 가능하게끔 만들 수 있으나 그때는 Employee가 아니라 다수기 때문에 List로 작성)
	
	//ID로 직원 한명의 정보를 업데이트 한다.
	@Override
	public Employee updateEmployeeById(Employee employee, long id) {
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","ID",id)); //existingEmployee는 변수명임.
//		객체는 참조복사이기 때문에 일일이 하나씩 넣는게 편함
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}
//임플로이를 가져와 정보를 받아 업데이트를 해야하기 때문
	
	//ID로 직원 한명의 정보를 삭제한다.
	//return이 없기 때문에 void 형식으로 작성함.
	@Override
	public void deleteEmployee(long id) {
		employeeRepository.findById(id).orElseThrow(()->
		new ResourceNotFoundException("Employee","ID",id));
		employeeRepository.deleteById(id); //지우는 코드
	}
}
