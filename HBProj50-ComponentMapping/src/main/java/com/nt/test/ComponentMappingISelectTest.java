//ComponentMappingISelectTest.java
package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.JobDetails;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class ComponentMappingISelectTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			 //prepare and execute JPQL
			Query query=ses.createQuery("from Person");
			List<Person> list=query.getResultList();
			list.forEach(per->{
				System.out.println("Person:"+per);
				JobDetails details=per.getDetails();
				System.out.println("JobDetails::"+details);
			});
			System.out.println("------------------------------------");
			Query query1=ses.createQuery("from Person where  details.desg=?1");
			query1.setParameter(1, "CLERK");
			List<Person> list1=query1.getResultList();
			list1.forEach(per->{
				System.out.println("Person:"+per);
				JobDetails details=per.getDetails();
				System.out.println("JobDetails::"+details);
			});
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}//catch

	}//main
}//class
