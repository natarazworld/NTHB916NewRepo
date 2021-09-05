package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.nt.entity.Actor;
import com.nt.utility.HibernateUtil;

public class ActorDAOImpl implements IActorDAO {
  private static final String  GET_ACTORS_COUNT="SELECT COUNT(*) FROM com.nt.entity.Actor";
  private static final String  GET_ACTORS_PAGE_DATA=" FROM com.nt.entity.Actor";
	@Override
	public long getRecordsCount() {
		 //Get Session object
		Session ses=HibernateUtil.getSession();
		long count=0;
		try(ses){
			//execute JPQL 
			Query query=ses.createQuery(GET_ACTORS_COUNT);
			 count=(long) query.getSingleResult();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<Actor> getPageData(int startPos, int pageSize) {
		//Get Session object
		Session ses=HibernateUtil.getSession();
		try(ses){
			// execute JPQL
			Query query=ses.createQuery(GET_ACTORS_PAGE_DATA);
			// pagination settings
			query.setFirstResult(startPos);
			query.setMaxResults(pageSize);
			List<Actor> list=query.getResultList();
			return list;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
