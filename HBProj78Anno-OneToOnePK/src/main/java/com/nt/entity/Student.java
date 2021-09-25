package com.nt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

//Student.java
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="ANNO_NIT_OTO_STUDENT")
public class Student  implements Serializable {
	@Id
	@GenericGenerator(name="gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private Integer sid;
	
	@NonNull
	@Column(length = 20)
	private String sname;
	@NonNull
	@Column(length = 20)
	private  String sadd;
	@OneToOne(targetEntity = LibraryMembership.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "LID",referencedColumnName = "SID")
	private LibraryMembership libraryDetails;
	
	public Student() {
		System.out.println("Student:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sadd=" + sadd + "]";
	}
	
	
	
	

}
