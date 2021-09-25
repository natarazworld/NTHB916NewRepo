package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="ANNO_NIT_OTOFK_PERSON")
public class Person implements Serializable {
	@GenericGenerator(name ="gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	@Id
	private Integer pid;
	@NonNull
	@Column(length=20)
	private String pname;
	@NonNull
	@Column(length=20)
	private String paddrs;
	
	public Person() {
		System.out.println("Person: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", pname=" + pname + ", paddrs=" + paddrs + "]";
	}
	
	

}
