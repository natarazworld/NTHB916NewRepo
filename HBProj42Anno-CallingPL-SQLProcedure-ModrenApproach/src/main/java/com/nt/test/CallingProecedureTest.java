package com.nt.test;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;

import com.nt.utility.HibernateUtil;

public class CallingProecedureTest {

	public static void main(String[] args) {
		// Get Sessionfactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			// Create ProcedureCall object representing PL/SQL procedure
			ProcedureCall call=ses.createStoredProcedureCall("P_HB_AUTHENTCATION");
			//register PL/SQL procedure parmaeters with JDBC types and bind values to them
			call.registerParameter(1, String.class,ParameterMode.IN).bindValue("raja");
			call.registerParameter(2, String.class,ParameterMode.IN).bindValue("rani1");
			call.registerParameter(3, String.class,ParameterMode.OUT);
			//call  PL/SQL procedure and get its result
			String result=(String) call.getOutputParameterValue(3);
			System.out.println("RESULT :"+result);
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}//main
}//class
