package com.nt.test;

import com.nt.dao.BankDAOImpl;
import com.nt.dao.IBankDAO;
import com.nt.utility.HibernateUtil;

public class OToMSaveObjectTest {

	public static void main(String[] args) {
		//create DAO class obj
		IBankDAO dao=new BankDAOImpl();
		//dao.saveDataUsingParent();
		//dao.loadDataUsingParent();
		//dao.deleteDataUsingParent();
		//dao.deleteAlltheChildsOfAParent();
		//dao.addChildToAParent();
		dao.deleteOneChildOfAParent();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
