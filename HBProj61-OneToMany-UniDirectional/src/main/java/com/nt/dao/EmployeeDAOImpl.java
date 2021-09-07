package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements IEmployeeDAO {

	@Override
	public void saveDataUsingParent() {
	   // Get Session object
		Session ses=HibernateUtil.getSession();
		//prepare objects
		 //child objs
		   BankAccount account1=new BankAccount("SBI", "savings", "hyd");
		   BankAccount account2=new BankAccount("ICICI", "savings", "delhi");
		   //parent obj
		   
		   Person per1=new Person("raja","hyd",Set.of(account1,account2));
		   
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
	public void loadDataUsingParent() {
		  // Get Session object
				Session ses=HibernateUtil.getSession();
				try(ses){
				   Query query=ses.createQuery("from  com.nt.entity.Person");
				   List<Person> list=query.getResultList();
				   list.forEach(per->{
					   System.out.println("parent(Person) ::"+per);
						Set<BankAccount> accounts=per.getAccounts();
						System.out.println("childs count::"+accounts.size());
						/*accounts.forEach(acc->{
						   System.out.println("child(BankAccount) ::"+acc);
						});*/
				   });
				}
				catch(HibernateException he) {
					he.printStackTrace();
				}
	}//loadData()
	
}//class
