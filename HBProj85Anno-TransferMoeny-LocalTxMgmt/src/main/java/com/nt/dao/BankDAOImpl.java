package com.nt.dao;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.utility.HibernateUtil;

public class BankDAOImpl implements IBankDAO {

	@Override
	public String transferMoney(int srcAcno, int destAcno, double amount) {
		//get Session
		Session ses=HibernateUtil.getSession();
		Transaction tx=null;
		try(ses){
			tx=ses.beginTransaction();
			  Query query1=ses.createQuery("update BankAccount set balance=balance-:amt where acno=:no"); //withdraw operation
			  Query query2=ses.createQuery("update BankAccount set balance=balance+:amt where acno=:no"); //deposite operation
			  query1.setParameter("amt", amount);
			  query1.setParameter("no", srcAcno);
			  query2.setParameter("amt", amount);
			  query2.setParameter("no", destAcno);
			  int result1=query1.executeUpdate();
			  int result2=query2.executeUpdate();
			  
			  if(result1==0 || result2==0) {
				  tx.rollback();
				  return "Tx rolleback , Moeney not transffered";
			  }
			  else {
				  tx.commit();
				  return "Tx Committed , Moeney  transffered";
			  }
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
			if(tx!=null ||tx.getStatus()==null ||tx.getRollbackOnly()) {
				tx.rollback();
				return "Tx Rolled back , Moeney not  transffered";
			}
			else {
       				return "Tx Rolled back , unknown problem";
			}
		}//catch
		
	}//method
}//class
