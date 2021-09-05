package com.nt.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class PaginationTest_HBQBC {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session obj
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			
			
			
			//To get count of records
			Criteria criteria=ses.createCriteria(Actor.class);
			Projection p1=Projections.count("actorId");
			criteria.setProjection(p1);
			long rowCount=(long) criteria.list().get(0);
			
			//evaluate no.of pages
			 Scanner sc=new Scanner(System.in);
			 System.out.println("enter pageSize::");
			 int pageSize=sc.nextInt();
			   long pagesCount=rowCount/pageSize;
			   pagesCount= (rowCount%pageSize==0)?pagesCount:++pagesCount;
			   System.out.println(" no.of pages:::"+pagesCount);
			
			//Display records with pagigation
			   Criteria criteria1= ses.createCriteria(Actor.class);
			for(int i=0,pageNo=1;i<rowCount;i+=pageSize,pageNo++) {
				
				System.out.println(pageNo+" page records are ::");
				criteria1.setFirstResult(i);
				criteria1.setMaxResults(pageSize);
				List<Actor> list=criteria1.list();
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
