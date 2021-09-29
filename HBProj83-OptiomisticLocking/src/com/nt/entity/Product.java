//Product.java (Entity class)
package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="PRODUCT")
public  class Product {
	// bean propertes
	@Id
	@GeneratedValue
	private Integer pid;
	@Column(length=20)
	private String pname;
	private Double price;
	private double qty;
	@Column(length=10)
	private String status;
	@Version
	private  Integer ver;
	
	public Product() {
	  System.out.println("Product:: 0-param constructor ::"+this.getClass()+"  "+System.identityHashCode(this)+"  "+this.getClass().getSuperclass());
	}

	// setters && getters (alt+shift+s, r)
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQty() {
		return qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	// toString() ( (alt+shift+s, s)
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", qty=" + qty + ", status=" + status
				+ "]";
	}

}
