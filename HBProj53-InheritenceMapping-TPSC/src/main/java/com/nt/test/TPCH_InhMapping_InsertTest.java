package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Customer;
import com.nt.entity.Employee;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class TPCH_InhMapping_InsertTest {

	public static void main(String[] args) {
	   //get SessionFactory 
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			tx=ses.beginTransaction();
				//parepare objects
			   Person per=new Person();
			     per.setName("raja"); per.setAddrs("hyd");
			    Customer cust=new Customer();
			    cust.setName("suresh"); cust.setAddrs("vizag"); cust.setPaymentType("Card"); cust.setBillAmt(80000);
            Employee emp=new Employee();
              emp.setName("naresh"); emp.setAddrs("hyd"); emp.setDesg("develoer");emp.setSalary(9000);emp.setDeptNo(8001);
              //save objects
              ses.save(per);
              ses.save(cust);
              ses.save(emp);
			tx.commit();
			System.out.println("Objects are saved");
		}
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				 tx.rollback();
				 System.out.println("Problem is saving objects");
			}
		}//catch
	}//main
}//class
