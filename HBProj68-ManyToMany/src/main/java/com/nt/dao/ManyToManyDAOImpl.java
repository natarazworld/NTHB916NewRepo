package com.nt.dao;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Doctor;
import com.nt.entity.Patient;
import com.nt.utility.HibernateUtil;

public class ManyToManyDAOImpl implements ManyToManyDAO {

	@Override
	public void saveDataUsingParent() {
		// Get Session object
		Session ses=HibernateUtil.getSession();
		 //prepare obects
		  Doctor doc1=new Doctor("raja","cardio");
		  Doctor doc2=new Doctor("rajesh","artho");
		  Patient pat1=new Patient("mahesh","Heart problem");
		  Patient pat2=new Patient("suresh","Diabetic problem");
		  Patient pat3=new Patient("ramesh","Heart problem");
		  Patient pat4=new Patient("naresh","Diabetic problem");
		  // child objects to parent objects
		  doc1.setPatients(Set.of(pat1, pat2));
		  doc2.setPatients(Set.of(pat1, pat3,pat4));
		  // parent objects to child objects
		    pat1.setDoctors(Set.of(doc1,doc2));
		    pat2.setDoctors(Set.of(doc1));
		    pat3.setDoctors(Set.of(doc2));
		    pat4.setDoctors(Set.of(doc2));
		Transaction tx=null;
		try(ses){
			//begin Tx
			tx=ses.beginTransaction();
			  //save object (parent to  child)
			 ses.save(doc1);
			 ses.save(doc2);
			tx.commit();
			System.out.println("Parent to chold objcts are inserted");
		}
		catch(HibernateException he) {
			System.out.println("Problem  in parent  to child objcts are insertion");
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
				 tx.rollback();
		}

	}//amin
	
	
	@Override
	public void saveDataUsingChild() {
		// Get Session object
				Session ses=HibernateUtil.getSession();
				 //prepare obects
				  Doctor doc1=new Doctor("anil","cardio");
				  Doctor doc2=new Doctor("tanish","artho");
				  Patient pat1=new Patient("murugan","Heart problem");
				  Patient pat2=new Patient("abdul","Diabetic problem");
				  Patient pat3=new Patient("kalam","Heart problem");
				  Patient pat4=new Patient("jhon","Diabetic problem");
				  // child objects to parent objects
				  doc1.setPatients(Set.of(pat1, pat2));
				  doc2.setPatients(Set.of(pat1, pat3,pat4));
				  // parent objects to child objects
				    pat1.setDoctors(Set.of(doc1,doc2));
				    pat2.setDoctors(Set.of(doc1));
				    pat3.setDoctors(Set.of(doc2));
				    pat4.setDoctors(Set.of(doc2));
				Transaction tx=null;
				try(ses){
					//begin Tx
					tx=ses.beginTransaction();
					  //save object (  child to parent)
					 ses.save(pat1);
					 ses.save(pat2);
					 ses.save(pat3);
					 ses.save(pat4);
					tx.commit();
					System.out.println("Parent to chold objcts are inserted");
				}
				catch(HibernateException he) {
					System.out.println("Problem  in parent  to child objcts are insertion");
					he.printStackTrace();
					if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly())
						 tx.rollback();
				}
		
	}
	

}//c lass
