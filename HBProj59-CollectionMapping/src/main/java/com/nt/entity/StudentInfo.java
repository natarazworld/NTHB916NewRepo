package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.Data;

@Data
public class StudentInfo {
	private Integer sno;
	private String sname;
	private List<String> friends;
	private  Set<Long> phoneNumbers;
	private Map<String,Long> idCertificates;

}
