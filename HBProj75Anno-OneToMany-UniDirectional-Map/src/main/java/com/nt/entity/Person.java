//Person.java (parent class)
package com.nt.entity;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="ANNO_NIT_OTM_PERSON_MAP")
public class Person {
	@Id
	@GenericGenerator(name="gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private  Integer pid;
	@NonNull
	private String pname;
	@NonNull
	private String paddrs;
	@NonNull
	@OneToMany(targetEntity = BankAccount.class,
	                          cascade = CascadeType.ALL,fetch = FetchType.EAGER,
	                         orphanRemoval=true )
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	@LazyCollection(LazyCollectionOption.EXTRA)
	@Fetch(FetchMode.JOIN)
	@MapKeyColumn(name = "MAP_INDX",length = 10)
	private  Map<String,BankAccount> accounts;
	
	public Person() {
		System.out.println("Person:: 0-param constructor");
	}
	
	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	

}
