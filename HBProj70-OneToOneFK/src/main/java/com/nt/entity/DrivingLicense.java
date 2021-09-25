package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DrivingLicense implements Serializable {
	private  Long lid;
	@NonNull
	private  String type;
	@NonNull
	private LocalDateTime expiryDate;
	@NonNull
	private Person licenseHolder;
	
	public DrivingLicense() {
		System.out.println("DrivingLicense: 0-param constructor");
	}

	@Override
	public String toString() {
		return "DrivingLicense [lid=" + lid + ", type=" + type + ", expirtDate=" + expiryDate + "]";
	}
	
	

}
