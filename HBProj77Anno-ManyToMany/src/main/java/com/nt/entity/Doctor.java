//Doctor.java
package com.nt.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@Entity
@Table(name="ANNO_NIT_MTM_DOCTOR")
public class Doctor {
	@Id
	@GenericGenerator(name="gen1",strategy = "increment")
	@GeneratedValue(generator = "gen1")
	private Integer docId;
	@NonNull
	@Column(length=20)
	private String docName;
	@NonNull
	@Column(length=20)
	private String category;
	//HAS-A property
	@ManyToMany(targetEntity = Patient.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable( name = "ANNO_NIT_MTM_DOCTORS_PATIENTS",
			              joinColumns = @JoinColumn(name = "DOCTOR_ID",referencedColumnName = "DOCID"),
	                      inverseJoinColumns = @JoinColumn(name="PATIENT_ID",referencedColumnName = "PATID"))
	private Set<Patient> patients;
	
	public Doctor() {
		System.out.println("Doctor:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Doctor [docId=" + docId + ", docName=" + docName + ", category=" + category + "]";
	}
	
	
	

}
