package com.nt.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.build.AllowSysOut;

import com.nt.entity.DrivingLicense;
import com.nt.entity.Person;
import com.nt.utility.HibernateUtil;

public class OneToOneFKDAOImpl implements IOneToOneFKDAO {

	@Override
	public void saveDataUsingChild() {
		//Get Session 
		Session ses=HibernateUtil.getSession();
		//prepare obejcts
		Person per=new Person("raja","hyd");
		DrivingLicense license=new DrivingLicense("two-wheeler", LocalDateTime.of(2030,10,20,11,20,40), per);
		Transaction tx=null;
		try(ses) {
			//begin Tx
			tx=ses.beginTransaction();
			   ses.save(license);
          tx.commit();
          System.out.println("Child ot parent objects are saved");
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null || tx.getStatus()!=null || tx.getRollbackOnly()) {
				tx.rollback();
				System.out.println("Problem in saving objects");
			}
		}

	}//method

	@Override
	public void loadDataUsingChild() {
		//Get Session 
				Session ses=HibernateUtil.getSession();
				try(ses) {
					Query query=ses.createQuery("from DrivingLicense");
					List<DrivingLicense> list=query.getResultList();
					list.forEach(dl->{
						System.out.println("child::"+dl);
						Person per=dl.getLicenseHolder();
						System.out.println("parent::"+per);
					});
				}//try
				catch(HibernateException he) {
					he.printStackTrace();
				}
	}//method
}//class
