package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
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
	private  Set<BankAccount> accounts;  //One To many
	
	public Person() {
		System.out.println("Person:: 0-param constructor"+this.getClass());
	}
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}

	
	

}
