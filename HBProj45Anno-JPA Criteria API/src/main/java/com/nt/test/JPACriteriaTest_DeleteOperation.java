package com.nt.test;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class JPACriteriaTest_DeleteOperation {

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
				CriteriaDelete<Actor> ctDelete=builder.createCriteriaDelete(Actor.class);
				//create Root object
				Root<Actor> root=ctDelete.from(Actor.class);
				//specify new vlaues with condition
				ctDelete.where(root.get("mobileNo").isNull());
				//prepare Query object
				Query query=ses.createQuery(ctDelete);
				//execute QBC logic
				int result=query.executeUpdate();
				System.out.println("No.of records that are deleted::"+result);
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
