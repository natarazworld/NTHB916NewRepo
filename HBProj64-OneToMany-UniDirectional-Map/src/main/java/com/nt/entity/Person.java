package com.nt.entity;

import java.util.Map;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Person {
	private  Integer pid;
	@NonNull
	private String pname;
	@NonNull
	private String paddrs;
	@NonNull
	private  Map<String,BankAccount> accounts;
	
	public Person() {
		System.out.println("Person:: 0-param constructor");
	}
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	

}
