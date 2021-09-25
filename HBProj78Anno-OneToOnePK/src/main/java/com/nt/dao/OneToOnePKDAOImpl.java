package com.nt.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.nt.entity.LibraryMembership;
import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class OneToOnePKDAOImpl implements IOneToOnePKDAO {

	@Override
	public void saveDataUsingParent() {
		//get Session object
		Session ses=HibernateUtil.getSession();
		//prepare objects
		Student st=new Student("raja","hyd");
		LibraryMembership library=new LibraryMembership("gold",LocalDateTime.now());
		//set parent to child and vice-versa
		st.setLibraryDetails(library); library.setStudDetails(st);
		
		//Bein Tx
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			   ses.save(st);
			tx.commit();
			System.out.println("Parent to child objs are saved");
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}//method
	
	@Override
	public void saveDataUsingChild() {
		//get Session object
		Session ses=HibernateUtil.getSession();
		//prepare objects
		Student st=new Student("anil","hyd");
		LibraryMembership library=new LibraryMembership("silver",LocalDateTime.now());
		//set parent to child and vice-versa
		st.setLibraryDetails(library); library.setStudDetails(st);
		
		//Bein Tx
		Transaction tx=null;
		try(ses) {
			tx=ses.beginTransaction();
			   ses.save(library);
			tx.commit();
			System.out.println("Parent to child objs are saved");
		}
		catch(HibernateException he) {
			he.printStackTrace();
		}

		
	}//method
	
	@Override
	public void loadDataUsingParent() {
		//get Session object
				Session ses=HibernateUtil.getSession();
				try(ses){
					Query query=ses.createQuery("from Student");
					List<Student> listStuds=query.getResultList();
					listStuds.forEach(stud->{
						System.out.println("parent::"+stud);
						LibraryMembership library=stud.getLibraryDetails();
						System.out.println("child::"+library);
					});
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
				}
		
	}

}
