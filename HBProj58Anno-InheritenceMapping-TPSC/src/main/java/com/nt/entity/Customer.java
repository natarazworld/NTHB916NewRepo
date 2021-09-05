package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@DiscriminatorValue("cust")
@Entity	
@Table(name="ANNO_INH_CUSTOMER_TPSC1")
@PrimaryKeyJoinColumn(name = "PERSON_ID",referencedColumnName = "ID")
public class Customer extends Person {
    private double billAmt;
    @Column(length = 20)
    private  String paymentType;
	@Override
	public String toString() {
		return "Customer [billAmt=" + billAmt + ", paymentType=" + paymentType + ", id=" + getId() + ", name="
				+ getName() + ", addrs=" + getAddrs() +  "]";
	}
    
    
}
