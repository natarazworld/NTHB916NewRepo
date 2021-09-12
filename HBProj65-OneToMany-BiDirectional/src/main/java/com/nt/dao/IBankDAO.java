package com.nt.dao;

public interface IBankDAO {
    public  void saveDataUsingParent();
    public  void saveDataUsingChild();
    public  void  loadDataUsingParent();
    public  void  loadDataUsingChild();
    
    /*public void  deleteDataUsingParent();
    public void  deleteAlltheChildsOfAParent();
    public void  addChildToAParent();
    public  void deleteOneChildOfAParent(); */
}
