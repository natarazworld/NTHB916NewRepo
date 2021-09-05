package com.nt.test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
//CollectMappingInsertTest.java
import org.hibernate.Transaction;

import com.nt.entity.StudentInfo;
import com.nt.utility.HibernateUtil;

public class CollectMappingInsertTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(factory;ses){
			//begin Tx
			tx=ses.beginTransaction();
			  StudentInfo stud1=new StudentInfo();
			  stud1.setSname("raja");
			  stud1.setFriends(List.of("suresh","mahesh","ramesh"));
			  stud1.setVisitedPlaces(List.of("hyd","delhi","goa"));
			  stud1.setPhoneNumbers(Set.of(999999999L,888888888L));
			  stud1.setIdCertificates(Map.of("aadharNo",54353453L,"voterId",54553454543L));
			  
			  StudentInfo stud2=new StudentInfo();
			  stud2.setSname("karan");
			  stud2.setFriends(List.of("suresh1","mahesh1","ramesh1"));
			  stud2.setVisitedPlaces(List.of("Mahabhalleswar","ooty","munnar hills"));
			  stud2.setPhoneNumbers(Set.of(77777777L,66666666L));
			  stud2.setIdCertificates(Map.of("aadharNo",154353453L,"voterId",14553454543L,"panNo",4543454L));
			  ses.save(stud1); ses.save(stud2);
			tx.commit();
			System.out.println("Object is saved");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Object is not saved");
			}
		}

	}//main
}//class
