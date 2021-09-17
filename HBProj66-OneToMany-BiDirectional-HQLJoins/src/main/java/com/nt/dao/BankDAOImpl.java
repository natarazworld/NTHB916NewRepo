package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.nt.entity.BankAccount;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class BankDAOImpl implements IBankDAO {

	
	
	@Override
	public void loadDataUsingParentAndJoins() {
		  // Get Session object
				Session ses=HibernateUtil.getSession();
				try(ses){
					//HQL Join query
				   //Query query=ses.createQuery("select p.pid,p.pname,p.paddrs,b.accno,b.bankName,b.type,b.location from  Person p inner join p.accounts b");
					Query query=ses.createQuery("select p.pid,p.pname,p.paddrs,b.accno,b.bankName,b.type,b.location from  Person p full join p.accounts b");
				   List<Object[]> list=query.getResultList();
				   list.forEach(data->{
					     for(Object o:data)
					    	 System.out.print(o+"  ");
					     System.out.println();
				   });
				}
				catch(HibernateException he) {
					he.printStackTrace();
				}
	}//loadData()
	
	/*@Override
	public void loadDataUsingChild() {
		// Get Session object
		Session ses=HibernateUtil.getSession();
		try(ses){
		   Query query=ses.createQuery("from  com.nt.entity.BankAccount");
		   List<BankAccount> list=query.getResultList();
			list.forEach(ac->{
			   System.out.println("Account (child) ::"+ac);
				IPerson per=ac.getPerson();
				 System.out.println(" Person (parent) ::"+per);  
			});
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}*/
	

	
}//class
