package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@DiscriminatorValue("emp")
@Entity	
@Table(name="ANNO_INH_EMPLOYEE_TPSC1")
@PrimaryKeyJoinColumn(name = "PERSON_ID",referencedColumnName = "ID")
public class Employee extends Person {
	@Column(length = 20)
	private String desg;
	private Integer deptNo;
	private  double salary;
	@Override
	public String toString() {
		return "Employee [desg=" + desg + ", deptNo=" + deptNo + ", salary=" + salary + ", id=" + getId()
				+ ", name=" + getName() + ", addrs=" + getAddrs() + "]";
	}
	
	

}
