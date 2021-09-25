package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class BankDAOImpl implements IBankDAO {

	@Override
	public void saveDataUsingParent() {
	   // Get Session object
		Session ses=HibernateUtil.getSession();
		//prepare objects
		 //child objs
		   BankAccount account1=new BankAccount("HDFC", "savings", "hyd");
		   BankAccount account2=new BankAccount("ICICI", "savings", "delhi");
		   //parent obj
		   Person per1=new Person("anil","hyd");
		   //set parent to childs
		   account1.setPerson(per1);
		   account2.setPerson(per1);
		   //set childs to parent
		   per1.setAccounts(Set.of(account1,account2));
		   
		   
		   Transaction tx=null;
		   try(ses){ 
			   //Begin Tx
			   tx=ses.beginTransaction();
			       ses.save(per1);
			   tx.commit();
			   System.out.println("Parent to child objs are saved");
		   }
		   catch(HibernateException he) {
			   he.printStackTrace();
			   if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly()) {
				   tx.rollback();
				   System.out.println("Problem in saving objects");
			   }
		   }
	}//methid
	
	@Override
	public void saveDataUsingChild() {
		 // Get Session object
		Session ses=HibernateUtil.getSession();
		//prepare objects
		 //child objs
		   BankAccount account1=new BankAccount("IDBI", "savings", "hyd");
		   BankAccount account2=new BankAccount("HDFC", "savings", "delhi");
		   //parent obj
		   Person per1=new Person("suresh","hyd");
		   //set parent to childs
		   account1.setPerson(per1);
		   account2.setPerson(per1);
		   //set childs to parent
		   per1.setAccounts(Set.of(account1,account2));
		   
		   
		   Transaction tx=null;
		   try(ses){ 
			   //Begin Tx
			   tx=ses.beginTransaction();
			     ses.save(account1); ses.save(account2);
			   tx.commit();
			   System.out.println(" child  to Parent objs are saved");
		   }
		   catch(HibernateException he) {
			   he.printStackTrace();
			   if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly()) {
				   tx.rollback();
				   System.out.println("Problem in saving objects");
			   }
		   }
	}//loadData()
	
		
}//class
