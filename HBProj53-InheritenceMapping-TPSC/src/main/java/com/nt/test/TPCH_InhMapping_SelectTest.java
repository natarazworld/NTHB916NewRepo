package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class TPCH_InhMapping_SelectTest {

	public static void main(String[] args) {
	   //get SessionFactory 
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			 Query query1=ses.createQuery("from Person");
			 List<Person> list1=query1.getResultList();
			 list1.forEach(per->{
				 System.out.println(per);
			 });
			 System.out.println("-------------------------------");
			 Query query2=ses.createQuery("from Customer");
			 List<Customer> list2=query2.getResultList();
			 list2.forEach(cust->{
				 System.out.println(cust);
			 });
			 System.out.println("-------------------------------");
			 Query query3=ses.createQuery("from Employee");
			 List<Employee> list3=query3.getResultList();
			 list3.forEach(emp->{
				 System.out.println(emp);
			 });
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}//catch
	}//main
}//class
