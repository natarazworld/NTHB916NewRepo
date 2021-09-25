package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import org.hibernate.annotations.Parameter;

//LibraryMembership.java
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="ANNO_NIT_OTO_LIBRARYMEMBERSHIP")
public class LibraryMembership implements Serializable {
	@Id
	@GenericGenerator(name="gen1",strategy = "foreign",
	                                      parameters =@Parameter(name="property",value="studDetails") )
	@GeneratedValue(generator = "gen1")
	private  Integer lid;
	@NonNull
	@Column(length = 20)
	private  String type;
	@NonNull
	private  LocalDateTime doj;
	@OneToOne(targetEntity = Student.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "libraryDetails")
	private Student studDetails;
	
	public LibraryMembership() {
		System.out.println("LibraryMembership:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", type=" + type + ", doj=" + doj + "]";
	}
	
	

}
