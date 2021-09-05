package com.nt.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import org.hibernate.annotations.ListIndexBase;

import lombok.Data;

@Data
@Table(name="COLLECTION_ANNO_STUDENTINFO")
@Entity
public class StudentInfo {
	@Id
	@GeneratedValue
	private Integer sno;
	@Column(length=20)
	private String sname;
	
	@ElementCollection
	@JoinTable(name = "ANNO_STUDENT_FRIENDS")
	@JoinColumn(name = "STUD_ID",referencedColumnName = "SNO")
	@OrderColumn(name = "FRIEND_INDEX")
	@ListIndexBase(value = 1)
	@Column(name="FRIEND")
	private List<String> friends;
	
	@ElementCollection
	@JoinTable(name = "ANNO_STUDENT_VISITED_PLACES")
	@JoinColumn(name = "STUD_ID",referencedColumnName = "SNO")
	@Column(name="PLACE")
	private List<String> visitedPlaces;
	
	@ElementCollection
	@JoinTable(name = "ANNO_STUDENT_PHONE_NUMBERS")
	@JoinColumn(name = "STUD_ID",referencedColumnName = "SNO")
	@Column(name="MOBILENUMBER")
	private  Set<Long> phoneNumbers;
	
	@ElementCollection
	@JoinTable(name = "ANNO_STUDENT_ID_CERTIFICATES")
	@JoinColumn(name = "STUD_ID",referencedColumnName = "SNO")
	@MapKeyColumn(name = "CERTIFICATE_TYPE",length=20)
	@Column(name="CERTIFICATE_NO")
	private Map<String,Long> idCertificates;

}
