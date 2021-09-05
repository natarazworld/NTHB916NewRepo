package com.nt.entity;

import lombok.Data;

@Data
public class Employee extends Person {
	private String desg;
	private Integer deptNo;
	private  double salary;
	@Override
	public String toString() {
		return "Employee [desg=" + desg + ", deptNo=" + deptNo + ", salary=" + salary + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getAddrs()=" + getAddrs() + "]";
	}
	
	

}
