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

public class JPACriteriaTest_EntityQueries {

	public static void main(String[] args) {
		//SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//Session object
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			/* ====== Example1 ===========
			    //create CriteriaBuilder object
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//Create CriteriaQuery object
			CriteriaQuery<Actor> ctQuery=builder.createQuery(Actor.class);
			// create Root object   
			Root<Actor> root=ctQuery.from(Actor.class);  //decides from db table
			//Add Root object Criteria object.
			ctQuery.select(root);
			//prepare Query object having CriteriaQuery object
			Query query=ses.createQuery(ctQuery);
			//execute logic
			List<Actor> list=query.getResultList();
			list.forEach(System.out::println);*/
			
			/*	// ====== Example2 ===========
			//create CriteriaBuilder object
			CriteriaBuilder builder=ses.getCriteriaBuilder();
			//Create CriteriaQuery object
			CriteriaQuery<Actor> ctQuery=builder.createQuery(Actor.class);
			// create Root object   
			Root<Actor> root=ctQuery.from(Actor.class);  //decides from db table
			//Add Root object Criteria object.
			ctQuery.select(root).where(builder.between(root.get("actorId"), 5000, 10000));  //where cluase
			//prepare Query object having CriteriaQuery object
			Query query=ses.createQuery(ctQuery);
			//execute logic
			List<Actor> list=query.getResultList();
			list.forEach(System.out::println);*/
			
			/*			// ====== Example3 ===========
						//create CriteriaBuilder object
						CriteriaBuilder builder=ses.getCriteriaBuilder();
						//Create CriteriaQuery object
						CriteriaQuery<Actor> ctQuery=builder.createQuery(Actor.class);
						// create Root object   
						Root<Actor> root=ctQuery.from(Actor.class);  //decides from db table
						//Add Root object Criteria object.
						ctQuery.select(root).where(root.get("actorAddrs").in("hyd","mumbai")).orderBy(builder.asc(root.get("actorName")));
						//prepare Query object having CriteriaQuery object
						Query query=ses.createQuery(ctQuery);
						//execute logic
						List<Actor> list=query.getResultList();
						list.forEach(System.out::println);*/
			
			// ====== Example4 ===========
						//create CriteriaBuilder object
						CriteriaBuilder builder=ses.getCriteriaBuilder();
						//Create CriteriaQuery object
						CriteriaQuery<Actor> ctQuery=builder.createQuery(Actor.class);
						// create Root object   
						Root<Actor> root=ctQuery.from(Actor.class);  //decides from db table
						//Add Root object Criteria object.
						ctQuery.select(root).where(builder.and(
								                                            builder.ge(root.get("actorId"), 5000),
								                                            builder.like(root.get("actorName"), "s%")
							                                            ));
						
						//prepare Query object having CriteriaQuery object
						Query query=ses.createQuery(ctQuery);
						//execute logic
						List<Actor> list=query.getResultList();
						list.forEach(System.out::println);
			
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
