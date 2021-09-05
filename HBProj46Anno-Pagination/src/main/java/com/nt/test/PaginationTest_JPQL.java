package com.nt.test;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class PaginationTest_JPQL {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session obj
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			
			//prepare  and execute HQL/JPQL
			Query query1=ses.createQuery("select count(*)  from Actor");
			long rowCount=(long) query1.getSingleResult();
			
			//evaluate no.of pages
			 Scanner sc=new Scanner(System.in);
			 System.out.println("enter pageSize::");
			 int pageSize=sc.nextInt();
			   long pagesCount=rowCount/pageSize;
			   pagesCount= (rowCount%pageSize==0)?pagesCount:++pagesCount;
			   System.out.println(" no.of pages:::"+pagesCount);
			//prepare  and execute HQL/JPQL
			Query query=ses.createQuery("from Actor");
			
			for(int i=0;i<rowCount;i+=pageSize) {
				System.out.println("===="+ (i+1)+" page details");
			//pagiation settings
		    	query.setFirstResult(i);  //start pos
			  query.setMaxResults(pageSize);  // pageSize
			  List<Actor> list=query.getResultList();
			  list.forEach(actor->{
				  System.out.println(actor);
			   });
			
			}//for
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
