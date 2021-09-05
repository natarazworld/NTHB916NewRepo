package com.nt.entity;

import lombok.Data;

@Data
public class BankAccount {
	private long acno;
	private String holderName;
	private  float balance;
	private  String status;

}
