//BankAccount.java
package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="HB_ACCOUNT")
@Entity
public class BankAccount {
	@Id
	@GeneratedValue
	private Integer acno;
	private String holdername;
	private  double balance;

}
