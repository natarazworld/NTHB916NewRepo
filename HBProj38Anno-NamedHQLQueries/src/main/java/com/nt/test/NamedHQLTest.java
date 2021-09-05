package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class NamedHQLTest {

	public static void main(String[] args) {
		 SessionFactory factory=HibernateUtil.getSessionFactory();
		   Session ses=HibernateUtil.getSession();
		   Transaction tx=null;
		   try(factory;ses){
			   //get Access the Named HQL query
			    Query query=ses.getNamedQuery("HQL_GET_ACTORS_BY_ACTORID_RANGE");
			    //set query param values
			    query.setParameter("min", 1000);
			    query.setParameter("max",10000);
			    //execute the query
               List<Actor> list=query.getResultList();
               list.forEach(actor->{
            	   System.out.println(actor);
               });
               System.out.println("-----------------------");
               tx=ses.beginTransaction();
			   //get Access the Named HQL query
			    Query query1=ses.getNamedQuery("HQL_DELETE_ACTORS_BY_ADDRS");
			    query1.setParameter("addrs", "delhi");
			    //execute the Query
			    int count=query1.executeUpdate();
			    System.out.println("no,of records that deleted ::"+count);
               tx.commit();
		   }//try
		   catch(HibernateException he) {
				     System.out.println("problem in record insertion");
				     if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				    	   tx.rollback();
			   }
		   }//main
	}//class
