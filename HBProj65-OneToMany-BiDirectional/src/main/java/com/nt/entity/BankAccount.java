package com.nt.entity;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class BankAccount {
	private long accno;
	@NonNull
	private String bankName;
	@NonNull
	private  String type;
	@NonNull
	private  String location;
	
	private  IPerson person;  // for Many to One
	
	public BankAccount() {
		System.out.println("BankAccount:: 0-param constructor");
	}
	
	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", bankName=" + bankName + ", type=" + type + ", location=" + location
				+ "]";
	}
	
	

}
