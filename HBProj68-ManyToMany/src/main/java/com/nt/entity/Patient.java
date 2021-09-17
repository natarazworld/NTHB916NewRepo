//Patient.java
package com.nt.entity;

import java.util.Set;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
public class Patient {
	private Integer patId;
	@NonNull
	private String patName;
	@NonNull
	private String problem;
	//HAS- A
	private Set<Doctor> doctors;
	
	public Patient() {
		System.out.println("Patient:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "Patient [patId=" + patId + ", patName=" + patName + ", problem=" + problem + "]";
	}
	
	

}
