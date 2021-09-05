package com.nt.test;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.utility.HibernateUtil;

public class NativeSQLNon_SelectTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=factory.openSession();
		Transaction  tx=null;
		try(factory;ses){
			tx=ses.beginTransaction();
			NativeQuery query=ses.createNativeQuery("INSERT INTO ACTOR VALUES(?,?,?,?)");
			query.setParameter(1, 5545);
			query.setParameter(2, "akshay");
			query.setParameter(3, "mumbai");
			query.setParameter(4, 5534543543L);
			//execute the query
			int result=query.executeUpdate();
			//process the result
			if(result==0)
				System.out.println("record not inserted");
			else
				System.out.println("record inserted");
			//commit the tx
			tx.commit();
		}
		catch(HibernateException he) {
			if(tx!=null || tx.getStatus()==null || tx.getRollbackOnly())
				  tx.rollback();
		}

	}//main
}//class
