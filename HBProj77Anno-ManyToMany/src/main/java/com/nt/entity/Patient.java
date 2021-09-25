//Patient.java
package com.nt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="ANNO_NIT_MTM_PATIENT")
public class Patient {
	@Id
	@SequenceGenerator(name="gen1",sequenceName = "PAT_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer patId;
	
	@NonNull
	@Column(length=20)
	private String patName;
	
	@NonNull
	@Column(length=20)
	private String problem;
	//HAS- A
	@ManyToMany(targetEntity = Doctor.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy="patients")
	private Set<Doctor> doctors;
	
	public Patient() {
		System.out.println("Patient:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Patient [patId=" + patId + ", patName=" + patName + ", problem=" + problem + "]";
	}
	
	

}
