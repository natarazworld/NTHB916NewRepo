package com.nt.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.Data;

@Data
@Entity
@Table(name="BANK_ACCOUNT_SOFT_DELETION")
@SQLDelete(sql="UPDATE BANK_ACCOUNT_SOFT_DELETION SET STATUS='CLOSED' WHERE ACNO=?")
@Where(clause="STATUS NOT IN('CLOSED','BLOCKED')")
public class BankAccount {
	@Id
	private long acno;
	private String holderName;
	private  float balance;
	private  String status;

}
