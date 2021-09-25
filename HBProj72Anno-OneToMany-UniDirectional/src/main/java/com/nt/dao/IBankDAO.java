package com.nt.dao;

public interface IBankDAO {
    public  void saveDataUsingParent();
    public  void  loadDataUsingParent();
    public  void  loadDataUsingParentAndQBC();
    public void  deleteDataUsingParent();
    public void  deleteAlltheChildsOfAParent();
    public void  addChildToAParent();
    public  void deleteOneChildOfAParent();
}
