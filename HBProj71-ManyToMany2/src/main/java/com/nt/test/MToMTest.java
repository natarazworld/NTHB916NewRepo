package com.nt.test;

import com.nt.dao.ManyToManyDAO;
import com.nt.dao.ManyToManyDAOImpl;
import com.nt.utility.HibernateUtil;

public class MToMTest {

	public static void main(String[] args) {
		//ceeate DAO class obj
		ManyToManyDAO dao=new ManyToManyDAOImpl();
          dao.saveDataUsingChild();
		HibernateUtil.closeSessionFactory();
	}//main
}//class
