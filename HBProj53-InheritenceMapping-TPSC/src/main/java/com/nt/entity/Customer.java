package com.nt.entity;

import lombok.Data;

@Data
public class Customer extends Person {
    private double billAmt;
    private  String paymentType;
	@Override
	public String toString() {
		return "Customer [billAmt=" + billAmt + ", paymentType=" + paymentType + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getAddrs()=" + getAddrs() +  "]";
	}
    
    
}
