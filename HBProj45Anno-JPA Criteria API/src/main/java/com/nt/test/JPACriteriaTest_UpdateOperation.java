package com.nt.test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class JPACriteriaTest_UpdateOperation {

	public static void main(String[] args) {
		//SessionFactory object
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//Session object
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			// begin Tx
			  tx=ses.beginTransaction();
				//Create CriteriaBuilder object
				CriteriaBuilder builder=ses.getCriteriaBuilder();
				//create CriteriaQuery object
				CriteriaUpdate<Actor> ctUpdate=builder.createCriteriaUpdate(Actor.class);
				//create Root object
				Root<Actor> root=ctUpdate.from(Actor.class);
				//specify new vlaues with condition
				ctUpdate.set(root.get("actorAddrs"), "New Delhi").where(builder.like(root.get("actorName"),"s%"));
				//prepare Query object
				Query query=ses.createQuery(ctUpdate);
				//execute QBC logic
				int result=query.executeUpdate();
				System.out.println("No.of records that are effected::"+result);
               tx.commit();				
			}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				tx.rollback();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}//main
}//class
