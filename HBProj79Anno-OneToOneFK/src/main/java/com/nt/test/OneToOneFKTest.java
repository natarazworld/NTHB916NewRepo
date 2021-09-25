package com.nt.test;

import com.nt.dao.IOneToOneFKDAO;
import com.nt.dao.OneToOneFKDAOImpl;
import com.nt.utility.HibernateUtil;

public class OneToOneFKTest {

	public static void main(String[] args) {
		//Create DAO class object
		IOneToOneFKDAO dao=new OneToOneFKDAOImpl();
		  //dao.saveDataUsingChild();
		dao.loadDataUsingChild();
     //close SEssionfactory
		    HibernateUtil.closeSessionFactory();
	}

}
