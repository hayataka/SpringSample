package com.example.demo.trySpring;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	@Autowired
	private HelloRepository helloRepository;
	
	public Employee findOne(int id) {
		
		Map<String, Object> map = helloRepository.findOne(id);
		Integer employeeId = (Integer)map.get("employee_id");
		String employeeName = (String)map.get("employee_name");
		int age = (int)map.get("age");
		
		Employee employee = new Employee();
		employee.setEmployeeId(employeeId);
		employee.setEmployeeName(employeeName);
		employee.setAge(age);
		return employee;
		
	}
}
