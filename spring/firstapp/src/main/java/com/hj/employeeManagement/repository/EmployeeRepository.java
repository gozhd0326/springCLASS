package com.hj.employeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hj.employeeManagement.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
//jparepository 안에 우리가 사용할 method가 들어 있기 때문에 안에 내용이 없다.
//자세한 것을 조회할 경우에는 repository의 impl을 만들어서 사용함.
//jpa(일종의 스펙임(구격).orm의 통칭)의 구현체는 hibernate 이다.
}
