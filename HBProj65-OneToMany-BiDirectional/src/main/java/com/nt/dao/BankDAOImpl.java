package com.nt.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.entity.IPerson;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class BankDAOImpl implements IBankDAO {

	@Override
	public void saveDataUsingParent() {
	   // Get Session object
		Session ses=HibernateUtil.getSession();
		//prepare objects
		 //child objs
		   BankAccount account1=new BankAccount("SBI", "savings", "hyd");
		   BankAccount account2=new BankAccount("ICICI", "savings", "delhi");
		   //parent obj
		   Person per1=new Person("raja","hyd");
		   //map parent object with childs
		   account1.setPerson(per1);
		   account2.setPerson(per1);
		   //map child objs to parent object
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
				   BankAccount account1=new BankAccount("HDFC", "savings", "hyd");
				   BankAccount account2=new BankAccount("CANARA", "savings", "delhi");
				   //parent obj
				   Person per1=new Person("suresh","delhi");
				   //map parent object with childs
				   account1.setPerson(per1);
				   account2.setPerson(per1);
				   //map child objs to parent object
				   per1.setAccounts(Set.of(account1,account2));
				   
				   Transaction tx=null;
				   try(ses){ 
					   //Begin Tx
					   tx=ses.beginTransaction();
					      ses.save(account1); ses.save(account2);
					   tx.commit();
					   System.out.println("Parent to child objs are saved");
				   }
				   catch(HibernateException he) {
					   he.printStackTrace();
					   if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly()) {
						   tx.rollback();
						   System.out.println("Problem in saving objects");
					   }//fi
				   }//catch
	}//method
	
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
						//System.out.println("childs count::"+accounts.size());
					/*	accounts.forEach(acc->{
						   System.out.println("child(BankAccount) ::"+acc);
						}); */
				   });
				}
				catch(HibernateException he) {
					he.printStackTrace();
				}
	}//loadData()
	
	@Override
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
	}
	
/*	@Override
	public void deleteDataUsingParent() {
		  // Get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			 //Load parent
			Person per=ses.get(Person.class, 1);
			//delete parent
			ses.delete(per);
			System.out.println("Parent and associated child objects are deleted");
			tx.commit();
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in deletion");
			}
		}
	}
	
	@Override
	public void deleteAlltheChildsOfAParent() {
		  // Get Session object
			Session ses=HibernateUtil.getSession();
			Transaction tx=null;
			try(ses){
				tx=ses.beginTransaction();
				 //Load parent
				Person per=ses.get(Person.class, 2);
				//get Childs of a prent 
				Set<BankAccount> accounts=per.getAccounts();
				   accounts.removeAll(accounts);
				System.out.println("All childs of a Parent are deleted");
				tx.commit();
			}//try
			catch(HibernateException he) {
				if(tx!=null || tx.getStatus()!=null ||tx.getRollbackOnly() ) {
					tx.rollback();
					System.out.println("Problem is record deletion..");
				}
				
			}
			
	}//methid
	
	@Override
	public void addChildToAParent() {
		 // Get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			//Load Parent  object
			Person per=ses.get(Person.class, 2);
			//get all childs of a parent
			Set<BankAccount> accounts=per.getAccounts();
			//create a new child
			BankAccount ac1=new BankAccount("SBI", "savings", "hyd");
			accounts.add(ac1);
			tx.commit();
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in adding new child to existing parent");
			}
		}
	}//method
	
	@Override
	public void deleteOneChildOfAParent() {
		 // Get Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			 //Load parent  object
			Person per=ses.get(Person.class, 2);
			//Load childs of a parent
			Set<BankAccount>  accounts=per.getAccounts();
			  //Load the child object that u want to delete
			BankAccount account=ses.get(BankAccount.class, 12345L);
			accounts.remove(account);
			tx.commit();
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in deleting child");
			}
		}//catch
	}//method  */
	
}//class
