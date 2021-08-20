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

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class JPACriteriaTest {

	public static void main(String[] args) {
		//SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//Session object
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
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
