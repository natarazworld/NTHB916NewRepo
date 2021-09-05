package com.nt.service;

import java.util.List;

import com.nt.entity.Actor;

public interface IActorManagementService {
      public   int  getPagesCount(int pageSize);
      public   List<Actor>  getReportPageData(int pageNo, int pageSize);
}
