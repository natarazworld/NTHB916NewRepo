package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="HB_PERSON_COMP_MAPPING")
public class Person implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	@NonNull
	private String pname;
	@NonNull
	private String paddrs;
	@NonNull
	@Embedded
	private JobDetails details;  //component property
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	

}
