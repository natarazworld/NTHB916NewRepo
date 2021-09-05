package com.nt.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StandardBasicTypes;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class NativeSQLSelectTest {

	public static void main(String[] args) {
		SessionFactory factory=HibernateUtil.getSessionFactory();
		Session ses=factory.openSession();
		try(factory;ses){
			/*//prepare  NativeQuery object representing native SQL query (Entity query)
			NativeQuery query=ses.createNativeQuery("SELECT * FROM ACTOR");
			//execute query
			List<Object[]> list=query.getResultList();
			list.forEach(row->{
				 for(Object val:row) {
					 System.out.print(val+"   ");
				 }
				 System.out.println();
			});*/
			
			/*//prepare  NativeQuery object representing native SQL query (Entity query)
			NativeQuery query=ses.createNativeQuery("SELECT * FROM ACTOR");
			//map results with Entity class
			query.addEntity(Actor.class);
			//execute query
			List<Actor> list=query.getResultList();
			list.forEach(actor->{
				  System.out.println(actor);
				 });
			*/
			
			/*			//prepare  NativeQuery object representing native SQL query (scalar query - multiple properties)
						NativeQuery query=ses.createNativeQuery("SELECT ACTORID,ACTORNAME,ACTORADDRS FROM ACTOR WHERE  ACTORADDRS IN(?,?,?) ORDER BY ACTORADDRS DESC ");
						 //register col names with  HB data types
								   query.addScalar("ACTORID",StandardBasicTypes.INTEGER);
								   query.addScalar("ACTORNAME",StandardBasicTypes.STRING);
								   query.addScalar("ACTORADDRS",StandardBasicTypes.STRING);
						//set query param values
						query.setParameter(1, "hyd");
						query.setParameter(2, "mumbai");
						query.setParameter(3, "delhi");
						 //execute  the query
						List<Object[]> list=query.getResultList();
						list.forEach(row->{
							for(Object val:row) {
								System.out.print(val+"   "+val.getClass());
							}
							System.out.println();
						});
			*/			
			/*			//prepare  NativeQuery object representing native SQL query (scalar query -single rpoperty)
						NativeQuery query=ses.createNativeQuery("SELECT ACTORNAME FROM ACTOR WHERE  ACTORADDRS=:addrs");
						 //register col names with  HB data types
								   query.addScalar("ACTORNAME",StandardBasicTypes.STRING);
						//set query param values
						query.setParameter("addrs", "mumbai");
									 //execute  the query
						List<String> list=query.getResultList();
						list.forEach(data->{
							System.out.println(data);
						});
			*/			
			
			/*//prepare  NativeQuery object representing native SQL query (scalar query--aggrate functions )
			NativeQuery query=ses.createNativeQuery("SELECT COUNT(*)  FROM ACTOR");
			 //register col names with  HB data types
				   query.addScalar("COUNT(*)",StandardBasicTypes.INTEGER);
			 //execute  the query
			int count=(int) query.getSingleResult();
			System.out.println("records count::"+count);*/
			
			
			//prepare  NativeQuery object representing native SQL query (scalar query--aggrate functions )
			NativeQuery query=ses.createNativeQuery("SELECT COUNT(*),AVG(ACTORID), MAX(ACTORID),MIN(ACTORID)  FROM ACTOR");
			 //register col names with  HB data types
				   query.addScalar("COUNT(*)",StandardBasicTypes.INTEGER);
				   query.addScalar("AVG(ACTORID)",StandardBasicTypes.FLOAT);
				   query.addScalar("MAX(ACTORID)",StandardBasicTypes.INTEGER);
				   query.addScalar("MIN(ACTORID)",StandardBasicTypes.INTEGER);
			 //execute  the query
			Object row[]=(Object[]) query.getSingleResult();
			System.out.println("records count::"+row[0]);
			System.out.println("records ACTOR ID::"+row[1]);
			System.out.println("records ACTOR  value::"+row[2]);
			System.out.println("records aACTORD MIN value::"+row[3]);
			
			
			
			
		}

	}

}
