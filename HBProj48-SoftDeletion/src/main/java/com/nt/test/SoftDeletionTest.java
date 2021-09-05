package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class SoftDeletionTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			//Load object
			BankAccount account=ses.get(BankAccount.class, 102L);
			if(account==null) {
				System.out.println("Account not found");
				return;
			}
			else {
    			 tx=ses.beginTransaction();
    			    ses.delete(account);
    			  tx.commit();
    			  System.out.println("Account deleted");
			}
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Account not deleted");
			}
				
		}//catch

	}//main
}//class
