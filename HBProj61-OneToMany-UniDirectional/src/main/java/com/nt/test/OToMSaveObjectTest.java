package com.nt.test;

import com.nt.dao.EmployeeDAOImpl;
import com.nt.dao.IEmployeeDAO;
import com.nt.utility.HibernateUtil;

public class OToMSaveObjectTest {

	public static void main(String[] args) {
		//create DAO class obj
		IEmployeeDAO dao=new EmployeeDAOImpl();
		//dao.saveDataUsingParent();
		dao.loadDataUsingParent();
		
		HibernateUtil.closeSessionFactory();
	}//main
}//class
