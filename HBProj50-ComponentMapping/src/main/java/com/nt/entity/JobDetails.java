package com.nt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobDetails implements Serializable{
	private  String desg;
	private  String company;
	private  String deptName;
	private  double  salary;
	
	@Override
	public String toString() {
		return "JobDetails [desg=" + desg + ", company=" + company + ", deptName=" + deptName + ", salary=" + salary
				+ "]";
	}
	
	

}
