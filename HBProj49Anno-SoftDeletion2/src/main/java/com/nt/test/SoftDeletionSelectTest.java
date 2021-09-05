package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class SoftDeletionSelectTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
		   //execute  JPQL query
			Query query=ses.createQuery("from BankAccount");
			List<BankAccount> list=query.getResultList();
			 list.forEach(System.out::println);
		}//try
		catch(HibernateException he) {
          he.printStackTrace();				
		}//catch

	}//main
}//class
