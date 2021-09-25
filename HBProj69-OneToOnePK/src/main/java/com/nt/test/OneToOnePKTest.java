package com.nt.test;

import com.nt.dao.IOneToOnePKDAO;
import com.nt.dao.OneToOnePKDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToOnePKTest {

	public static void main(String[] args) {
		IOneToOnePKDAO  dao=new OneToOnePKDAOImpl();
		//dao.saveDataUsingParent();
		//saveDataUsingChild();
		dao.loadDataUsingParent();
		
		//close SEssion Factory
		HibernateUtil.closeSessionFactory();

	}

}
