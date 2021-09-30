package com.nt.test;

import com.nt.dao.BankDAOImpl;
import com.nt.dao.IBankDAO;
import com.nt.utility.HibernateUtil;

public class TxMgmtTest {

	public static void main(String[] args) {
	  IBankDAO dao=new BankDAOImpl();
	  
	  //invoke method
	  String result=dao.transferMoney(1051,1001,4599);
	  System.out.println(result);
		
    //close session factory
	    HibernateUtil.closeSessionFactory();
	}

}
