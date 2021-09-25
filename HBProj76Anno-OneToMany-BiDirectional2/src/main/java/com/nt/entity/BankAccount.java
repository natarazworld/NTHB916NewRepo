//BankAccount.java
package com.nt.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="ANNO_NIT_OTM_BANKACCOUNT_BI")
public class BankAccount {
	@Id
	@SequenceGenerator(name = "gen1",
	                                          sequenceName = "ACCNO_SEQ",
	                                          initialValue = 1000000,allocationSize =1 )
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private long accno;
	@NonNull
	private String bankName;
	@NonNull
	private  String type;
	@NonNull
	private  String location;
	@ManyToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	@LazyToOne(LazyToOneOption.PROXY)
	private  Person  person;
	
	public BankAccount() {
		System.out.println("BankAccount:: 0-param constructor");
	}
	
	@Override
	public String toString() {
		return "BankAccount [accno=" + accno + ", bankName=" + bankName + ", type=" + type + ", location=" + location
				+ "]";
	}
	
	

}
