//LockingTest1.java
package com.nt.test;

import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import com.nt.entity.Product;

public class LockingTest2 {

	public static void main(String[] args) {
	    // activate HB fgramework
		Configuration cfg=new Configuration();
		//specify hibernate cfg file name and location
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Create HB SessionFactory object
		SessionFactory factory=cfg.buildSessionFactory();
		//create SEssion object
		Session ses=factory.openSession();
		Transaction tx=null;
		try(factory;ses){
			 Product prod=ses.get(Product.class,101);
			 System.out.println(prod);
			 tx=ses.beginTransaction();
			      prod.setQty(2677.0);
 		          ses.update(prod);
 		        tx.commit();
 		        System.out.println("Object is modifed");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				  System.out.println("Problem in Object modification");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
