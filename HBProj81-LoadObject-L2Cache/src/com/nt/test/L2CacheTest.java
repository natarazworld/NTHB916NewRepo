
//L2CacheTest.java
package com.nt.test;


import org.hibernate.Cache;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Product;

public class L2CacheTest {

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
			//Load object
			Product p1=ses.get(Product.class, 1); // collects from DB and keeps in L2,L1 caches
			System.out.println(p1);
			Product p2=ses.get(Product.class, 1); // collects from L1 cache
			System.out.println(p2);
			ses.evict(p2);
			Product p3=ses.get(Product.class, 1); // collects from L2 cache and keeps in L1 cache
			System.out.println(p3);
			ses.clear();
			Product p4=ses.get(Product.class, 1); // collects from L2 cache and keeps in L1 cache
			System.out.println(p4);
			System.out.println("App goes to sleep mode....");
			ses.clear();  //removes objects from L1 cache
			Thread.sleep(15000);  //removes object form L2 cache
			Product p5=ses.get(Product.class, 1); // collects from DB and keeps in L1,L2 caches
			System.out.println(p5);
			
			Cache cache=factory.getCache();
			ses.clear();
			//cache.evictAll();
			cache.evict(Product.class);
			Product p6=ses.get(Product.class, 1); // collects from DB and keeps in L1,L2 caches
			System.out.println(p6);

		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
