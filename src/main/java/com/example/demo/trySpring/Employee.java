package com.example.demo.trySpring;

import lombok.Data;

@Data
public class Employee {
	/**従業員ID.**/
	private int employeeId;

	/**従業員名.**/
	private String employeeName;

	/**年齢.**/
	private int age;
}
