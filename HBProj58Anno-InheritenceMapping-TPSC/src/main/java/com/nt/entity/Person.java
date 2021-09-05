package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="ANNO_INH_PERSON_TPSC1")
public class Person {
	@Id
	@GeneratedValue
	private Integer id;
	@Column(length = 20)
	private String name;
	@Column(length = 20)
	private String addrs;

}
