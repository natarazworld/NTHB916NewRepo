package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class NamedNativeSQLTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			//access and execute Named native SQL queries
			NativeQuery query1=ses.getNamedNativeQuery("GET_ALL_ACTORS_BY_ADDRS");
			query1.setParameter(1,"mumbai");
			List<Actor> list=query1.getResultList();
			list.forEach(System.out::println);
			
			System.out.println("-----------------------------------------------");
			NativeQuery query2=ses.getNamedNativeQuery("GET_ACTORS_DATA_BY_ACTORID_RANAGE");
			query2.setParameter(1,1000);
			query2.setParameter(2,10000);
			List<Object[]> list2=query2.getResultList();
			list2.forEach(row->{
				for(Object val:row) {
					System.out.print(val+"  ");
				}
				System.out.println();
			});
		
		System.out.println("-----------------------------------------------");
		tx=ses.beginTransaction();
		NativeQuery query3=ses.getNamedNativeQuery("CHANGE_ACTOR_ADDRS_BY_NAME");
		query3.setParameter("newAddrs","delhi");
		query3.setParameter("name","amitab");
		int count=query3.executeUpdate();
		 if(count==0)
			 System.out.println("Record not updated");
		 else
			 System.out.println("Record updated");
		 tx.commit();
	}//try
	catch(HibernateException he) {
		he.printStackTrace();
		if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
			tx.rollback();
	}
  }//main
}//class
