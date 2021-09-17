package com.nt.dao;

public interface IBankDAO {
    
	public  void  loadDataUsingParent();
	public  void  loadDataUsingParentAndUsingHBQBC();
	public  void  loadDataUsingParentAndUsingJPAQBC();
	public  void  loadDataUsingParentAndHQLFetchJoin();
    public  void  loadDataUsingParentAndJoins();
    public  void  loadDataUsingParentAndFetchJoins();
    
    
}
