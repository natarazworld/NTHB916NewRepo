package com.nt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nt.entity.Actor;
import com.nt.service.ActorManagmentServiceImpl;
import com.nt.service.IActorManagementService;

@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	
	private IActorManagementService service;
	@Override
	public void init() throws ServletException {
	  service=new ActorManagmentServiceImpl();
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//read special req param value to decide wheather request has come submit button or hyplink
		 String s1=req.getParameter("s1");
		 int pageNo=0; int pageSize=0;
		 HttpSession ses=req.getSession();
		  if(s1.equalsIgnoreCase("Get Report")) { //for submit button
			  pageSize=Integer.parseInt(req.getParameter("pageSize"));
			  pageNo=1;
			  ses.setAttribute("pageSize", pageSize);
		  }
		  else {  //from hyperlink
			  pageNo=Integer.parseInt(req.getParameter("pageNo"));
			  pageSize=(int) ses.getAttribute("pageSize");
     	  }
		  //use service
		  int pagesCount=service.getPagesCount(pageSize);
		  List<Actor> list=service.getReportPageData(pageNo, pageSize);
		  //keep results in request scope
		  req.setAttribute("pageData",list);
		  req.setAttribute("pagesCount",pagesCount);
		  //forward to jsp page
		  RequestDispatcher rd=req.getRequestDispatcher("/show_report.jsp");
		  rd.forward(req, res);
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
