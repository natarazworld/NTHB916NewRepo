package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name="ANNO_NIT_OTOFK_DRIVINGLICENSE")
public class DrivingLicense implements Serializable {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "LICENSE_SEQ",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private  Long lid;
	@NonNull
	@Column(length = 20)
	private  String type;
	@NonNull
	private LocalDateTime expiryDate;
	@NonNull
	@OneToOne(targetEntity = Person.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
	@JoinColumn(name = "PERSON_ID",referencedColumnName = "PID")
	private Person licenseHolder;
	
	public DrivingLicense() {
		System.out.println("DrivingLicense: 0-param constructor");
	}

	@Override
	public String toString() {
		return "DrivingLicense [lid=" + lid + ", type=" + type + ", expirtDate=" + expiryDate + "]";
	}
	
	

}
