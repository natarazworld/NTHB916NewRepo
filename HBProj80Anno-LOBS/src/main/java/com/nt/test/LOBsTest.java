package com.nt.test;

import com.nt.dao.IPersonProfileDAO;
import com.nt.dao.PersonProfileDAOImpl;
import com.nt.utility.HibernateUtil;

public class LOBsTest {

	public static void main(String[] args) {
		//create DAO class object
		IPersonProfileDAO dao=new PersonProfileDAOImpl();
		//dao.saveData();
		dao.loadData();
		
		//close Session factory
		HibernateUtil.closeSessionFactory();

	}

}
