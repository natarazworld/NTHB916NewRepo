package com.nt.service;

import java.util.List;

import com.nt.dao.ActorDAOImpl;
import com.nt.dao.IActorDAO;
import com.nt.entity.Actor;

public class ActorManagmentServiceImpl implements IActorManagementService {
	
	private IActorDAO  dao;
	
	public ActorManagmentServiceImpl() {
		dao=new ActorDAOImpl();
	}

	@Override
	public int getPagesCount(int pageSize) {
		long recordsCount =dao.getRecordsCount();
		int pagesCount=(int) (recordsCount/pageSize);
		pagesCount=recordsCount%pageSize==0?pagesCount:++pagesCount;
		return pagesCount;
	}

	@Override
	public List<Actor> getReportPageData(int pageNo, int pageSize) {
		//decide start Position
		int startPos= (pageNo*pageSize)-pageSize;
		//use DAO
		List<Actor> list=dao.getPageData(startPos, pageSize);
		return list;
	}

}
