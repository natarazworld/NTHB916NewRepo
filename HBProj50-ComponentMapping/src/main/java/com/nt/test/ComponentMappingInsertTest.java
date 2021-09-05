//ComponentMappingInsertTest.java
package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingInsertTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			//	Beging Transaction
			tx=ses.beginTransaction();
			   //prepare objects
			     JobDetails  details=new JobDetails("MANAGER", "Wipro","IT", 30000);
			     Person per=new Person("rajesh","mumbai",details);
			     //save object
			      int idVal=(int) ses.save(per);
			      tx.commit();
			      System.out.println("Object is saved with id value::"+idVal);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object is not saved");
			}
		}//catch

	}//main
}//class
