//CollectMappingSelectTest.java
package com.nt.test;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.StudentInfo;
import com.nt.utility.HibernateUtil;

public class CollectMappingSelectTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			 Query query=ses.createQuery("from StudentInfo");
			 List<StudentInfo>  list=query.getResultList();
			 list.forEach(info->{
				 System.out.println(info);
			 });
			 
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}

}
