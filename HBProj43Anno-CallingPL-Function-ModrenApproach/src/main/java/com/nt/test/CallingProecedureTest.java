package com.nt.test;

import java.util.List;

import javax.persistence.ParameterMode;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

/*CREATE OR REPLACE PROCEDURE P_HB_GET_ACTORS_BY_ADDRESES 
(
  ADDRS1 IN VARCHAR2 
, ADDRS2 IN VARCHAR2 
, ADDRS3 IN VARCHAR2 
,DETAILS OUT SYS_REFCURSOR
) AS 
  
BEGIN
   OPEN DETAILS FOR
     SELECT  * FROM ACTOR WHERE ACTORADDRS IN(ADDRS1,ADDRS2,ADDRS3) ORDER BY ACTORADDRS;
  
END P_HB_GET_ACTORS_BY_ADDRESES;
*/
public class CallingProecedureTest {

	public static void main(String[] args) {
		// Get Sessionfactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			// Create ProcedureCall object representing PL/SQL procedure
			ProcedureCall call=ses.createStoredProcedureCall("P_HB_GET_ACTORS_BY_ADDRESES",Actor.class);
			//register PL/SQL procedure parmaeters with JDBC types and bind values to them
			call.registerParameter(1, String.class,ParameterMode.IN).bindValue("hyd");
			call.registerParameter(2, String.class,ParameterMode.IN).bindValue("delhi");
			call.registerParameter(3, String.class,ParameterMode.IN).bindValue("mumbai");
			call.registerParameter(4, Actor.class,ParameterMode.REF_CURSOR);
			//call  PL/SQL procedure and get its result
            List<Actor> list=call.getResultList();
			list.forEach(actor->{
				System.out.println(actor);
			});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}//main
}//class
