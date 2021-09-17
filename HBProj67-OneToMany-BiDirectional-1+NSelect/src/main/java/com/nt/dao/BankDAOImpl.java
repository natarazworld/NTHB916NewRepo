package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

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

	@Override
	public void loadDataUsingParent() {
		// Get Session object
		Session ses=HibernateUtil.getSession();
		try(ses){
			//HQL Join query
			Query query=ses.createQuery("from Person");
		   List<Person> list=query.getResultList();
		   list.forEach(per->{
			     System.out.println("parent ::"+per);
			     Set<BankAccount> childs=per.getAccounts();
			     childs.forEach(account->{
			    	 System.out.println("child ::"+account);
			     });
		   });
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
		
	}
	
	
	@Override
	public void loadDataUsingParentAndUsingHBQBC() {
	    //get Session 
		Session ses=HibernateUtil.getSession();
		try(ses){
			Criteria criteria=ses.createCriteria(Person.class);
			//criteria.setFetchMode("accounts",FetchMode.JOIN);
			List<Person>  list=criteria.list();
			list.forEach(per->{
			     System.out.println("parent ::"+per);
			     Set<BankAccount> childs=per.getAccounts();
			     childs.forEach(account->{
			    	 System.out.println("child ::"+account);
			     });
		   });
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}
	}
	
	@Override
	public void loadDataUsingParentAndUsingJPAQBC() {
		 //get Session 
		Session ses=HibernateUtil.getSession();
		try(ses){
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaQuery<Person > ctQuery=builder.createQuery(Person.class);
			Root<Person> root=ctQuery.from(Person.class);
			//root.join("accounts");
			 root.fetch("accounts", JoinType.INNER);
			Query query=ses.createQuery(ctQuery);
			List<Person>  list=query.getResultList();
			list.forEach(per->{
			     System.out.println("parent ::"+per);
			     Set<BankAccount> childs=per.getAccounts();
			     childs.forEach(account->{
			    	 System.out.println("child ::"+account);
			     });
		   });
		}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
	}//method
	
	@Override
	public void loadDataUsingParentAndHQLFetchJoin() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			Query query=ses.createQuery("select p  from Person p  inner join fetch p.accounts");
			List<Person>  list=query.getResultList();
			list.forEach(per->{
			     System.out.println("parent ::"+per);
			     Set<BankAccount> childs=per.getAccounts();
			     childs.forEach(account->{
			    	 System.out.println("child ::"+account);
			     });
		   });
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
	
	}
	
	
	@Override
	public void loadDataUsingParentAndFetchJoins() {
		Session ses=HibernateUtil.getSession();
		try(ses){
			Query query=ses.createQuery("select p.pid,p.name,p.addrs,u.accno,u.bankName.u.type  from Person p  inner join fetch p.accounts u");
			List<Person> list=query.getResultList();
			list.forEach(per->{
			 System.out.println("parent ::"+per);
		     Set<BankAccount> childs=per.getAccounts();
		     childs.forEach(account->{
		    	 System.out.println("child ::"+account);
		     });
	   });
		}//try
			catch(HibernateException he) {
				he.printStackTrace();
			}
	}
	

	
}//class
