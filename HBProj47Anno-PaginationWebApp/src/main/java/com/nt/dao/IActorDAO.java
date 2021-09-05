package com.nt.dao;

import java.util.List;

import com.nt.entity.Actor;

public interface IActorDAO {
     public  long  getRecordsCount();
     public List<Actor> getPageData(int startPos,int pageSize);
}
