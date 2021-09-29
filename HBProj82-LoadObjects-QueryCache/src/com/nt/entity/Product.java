//Product.java (Entity class)
package com.nt.entity;

public final class Product {
	// bean propertes
	private Integer pid;
	private String pname;
	private Double price;
	private double qty;
	private String status;
	
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
