package com.hj.employeeManagement.service;

import java.util.List;

import com.hj.employeeManagement.model.Employee;

public interface EmployeeService {

	//직원정보를 새로 생성한다.
	Employee saveEmployee(Employee employee);
	
	//전체 직원 정보를 조회한다.(findAll)
	List<Employee> getAllEmployees();
	
	//ID로 직원 한명의 정보를 조회한다.(findbyId)
	Employee getEmployeebyId(long id);
//	(Id말고도 이름이나 연봉으로도 조회가 가능하게끔 만들 수 있으나 그때는 Employee가 아니라 다수기 때문에 List로 작성)
	
	//ID로 직원 한명의 정보를 업데이트 한다.(findbyId + employee를 바꿔서 새로 업데이트)
	Employee updateEmployeeById(Employee employee, long id);
//임플로이를 가져와 정보를 받아 업데이트를 해야하기 때문
	
	//ID로 직원 한명의 정보를 삭제한다.(deletebyId)
	void deleteEmployee(long id);
}
