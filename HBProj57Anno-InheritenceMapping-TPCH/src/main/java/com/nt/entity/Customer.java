package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;

@Data
@DiscriminatorValue("cust")
@Entity	
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
