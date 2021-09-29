
//QueryCacheTest.java
package com.nt.test;


import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.query.Query;

import com.nt.entity.Product;

public class QueryCacheTest {

	public static void main(String[] args) {
	    // activate HB fgramework
		Configuration cfg=new Configuration();
		//specify hibernate cfg file name and location
		cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		//Create HB SessionFactory object
		SessionFactory factory=cfg.buildSessionFactory();
		//create SEssion object
		Session ses=factory.openSession();
		try(factory;ses){
			 Query query=ses.createQuery("from Product");
			 query.setCacheable(true);
			 query.setCacheRegion("region1");
			 List<Product> list=query.getResultList();
			 list.forEach(prod->{
				 System.out.println(prod);
			 });
			 System.out.println("---------------------------");
			 List<Product> list1=query.getResultList();
			 list1.forEach(prod1->{
				 System.out.println(prod1);
			 });
 		
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
