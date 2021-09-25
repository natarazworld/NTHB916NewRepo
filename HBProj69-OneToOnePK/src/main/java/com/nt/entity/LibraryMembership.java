package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
//LibraryMembership.java
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class LibraryMembership implements Serializable {
	private  Integer lid;
	@NonNull
	private  String type;
	@NonNull
	private  LocalDateTime doj;
	private Student studDetails;
	
	public LibraryMembership() {
		System.out.println("LibraryMembership:: 0-param constructor");
	}

	@Override
	public String toString() {
		return "LibraryMembership [lid=" + lid + ", type=" + type + ", doj=" + doj + "]";
	}
	
	

}
