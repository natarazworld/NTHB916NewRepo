package com.nt.test;

import java.sql.CallableStatement;
import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nt.utility.HibernateUtil;

/*CREATE OR REPLACE FUNCTION FX_HB_GET_ACTOTS_DETAILS_ID 
(
  ID IN NUMBER 
, NAME OUT VARCHAR2 
, PHONENO OUT NUMBER 
) RETURN VARCHAR2 AS 
  ADDRS VARCHAR2(20);
BEGIN
 SELECT ACTORNAME,ACTORADDRS,MOBILENO INTO NAME,ADDRS,PHONENO FROM ACTOR WHERE ACTORID=ID;
 
 RETURN ADDRS;
  
END FX_HB_GET_ACTOTS_DETAILS_ID;
*/
public class CallingFunctionTest {

	public static void main(String[] args) {
		// Get Sessionfactory
		SessionFactory factory=HibernateUtil.getSessionFactory();
		//get Session
		Session ses=HibernateUtil.getSession();
		try(factory;ses){
			String result[]=ses.doReturningWork(con->{
				//create CallablesTatement
				CallableStatement cs=con.prepareCall("{?= call FX_HB_GET_ACTOTS_DETAILS_ID(?,?,?)}");
				//register return ,out  parameters
				cs.registerOutParameter(1,Types.VARCHAR);
				cs.registerOutParameter(3,Types.VARCHAR);
				cs.registerOutParameter(4, Types.NUMERIC);
				//set values to IN paramters
				cs.setInt(2, 1001);
				//execute PL/SQL proecedure
				cs.execute();
				//gather results from out,return paramters and store into any array
				String results[]=new String[3];
				results[0]=cs.getString(1);
				results[1]=cs.getString(3);
				results[2]=cs.getString(4);
				return results;
			});
			System.out.println("results are " );
			for(String res:result) {
				System.out.print(res+"  ");
			}
			System.out.println();
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}

	}//main
}//class
