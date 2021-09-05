package com.nt.test;

import java.util.List;
import java.util.Scanner;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class PaginationTest_JPAQBC {

	public static void main(String[] args) {
		//get SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session obj
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			
			//To get count of records
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			CriteriaQuery<Long> ctQuery=builder.createQuery(Long.class);
			Root<Actor>  root=ctQuery.from(Actor.class);
			ctQuery.multiselect(builder.count(root.get("actorId")));
			Query query=ses.createQuery(ctQuery);
			long rowCount=(long)query.getSingleResult();
			
			
			//evaluate no.of pages
			 Scanner sc=new Scanner(System.in);
			 System.out.println("enter pageSize::");
			 int pageSize=sc.nextInt();
			   long pagesCount=rowCount/pageSize;
			   pagesCount= (rowCount%pageSize==0)?pagesCount:++pagesCount;
			   System.out.println(" no.of pages:::"+pagesCount);
			
			//Display records with pagigation
				CriteriaQuery<Actor> ctQuery1=builder.createQuery(Actor.class);
				Root<Actor>  root1=ctQuery1.from(Actor.class);
			   ctQuery1.select(root1);
			   Query query1=ses.createQuery(ctQuery1);
			for(int i=0,pageNo=1;i<rowCount;i+=pageSize,pageNo++) {
				System.out.println(pageNo+" page records are ::");
				query1.setFirstResult(i);
				query1.setMaxResults(pageSize);
				List<Actor> list=query1.getResultList();
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
