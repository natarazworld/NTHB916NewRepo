package com.nt.test;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class JPACriteriaTest_ScalarQueries {

	public static void main(String[] args) {
		//SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//Session object
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			/*	//Create CriteriaBuilder object
				CriteriaBuilder builder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
				CriteriaQuery<Object[]> ctQuery=builder.createQuery(Object[].class);
				//create Root object
				Root<Actor> root=ctQuery.from(Actor.class);
				//add column names
				ctQuery.multiselect(root.get("actorId"),root.get("actorName")).where(root.get("actorAddrs").in("hyd","mumbai")).orderBy(builder.asc(root.get("actorAddrs")));
				//prepare Query object
				Query query=ses.createQuery(ctQuery);
				//execute the QBC logic
				List<Object[]> list=query.getResultList();
				list.forEach(row->{
					for(Object val:row)
						System.out.print(val+"  ");
					
					System.out.println();
				});*/
			
			/*	//Create CriteriaBuilder object
				CriteriaBuilder builder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
				CriteriaQuery<Object[]> ctQuery=builder.createQuery(Object[].class);
				//create Root object
				Root<Actor> root=ctQuery.from(Actor.class);
				//add column names and  conditions
				ctQuery.multiselect(root.get("actorId"),root.get("actorName"),root.get("actorAddrs"))
				 .where(builder.and(
						    builder.ge(root.get("actorId"), 5000),
						    builder.le(root.get("actorId"), 10000)
						 ));
				//prepare Query object
				Query query=ses.createQuery(ctQuery);
				  //execute QBC logic
				List<Object[]> list=query.getResultList();
				list.forEach(row->{
					for(Object val:row)
						System.out.print(val+"  ");
					
					System.out.println();
				});*/
			
			/*// agggrate operation
			//Create CriteriaBuilder object
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//create CriteriaQuery object
			CriteriaQuery<Long> ctQuery=builder.createQuery(Long.class);
			//create Root object
			Root<Actor> root=ctQuery.from(Actor.class);
			//add column names and  conditions
			ctQuery.multiselect(builder.count(root.get("actorId")));
			//prepare Query object
			Query query=ses.createQuery(ctQuery);
			  //execute QBC logic
			long count=(long) query.getSingleResult();
			System.out.println("records count:::"+count);*/
			
			// agggrate operations
						//Create CriteriaBuilder object
						CriteriaBuilder builder=ses.getCriteriaBuilder();
						//create CriteriaQuery object
						CriteriaQuery<Object[]> ctQuery=builder.createQuery(Object[].class);
						//create Root object
						Root<Actor> root=ctQuery.from(Actor.class);
						//add column names and  conditions
						ctQuery.multiselect(builder.count(root.get("actorId")),builder.sum(root.get("actorId")),builder.avg(root.get("actorId")),builder.min(root.get("actorId")));
						//prepare Query object
						Query query=ses.createQuery(ctQuery);
						  //execute QBC logic
						List<Object[]> list=query.getResultList();
						Object result[]=list.get(0);
						System.out.println(" actors count::"+result[0]);
						System.out.println(" sum of actors Ids::"+result[1]);
						System.out.println(" avg of actors Ids::"+result[2]);
						System.out.println(" Min actorId::"+result[3]);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}//main
}//class
