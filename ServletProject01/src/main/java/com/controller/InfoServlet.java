package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InfoServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	  req.setCharacterEncoding("utf-8");
	  String name = req.getParameter("name");
	  String id = req.getParameter("id");
	  String pwd = req.getParameter("pwd");
	  String phone = req.getParameter("phone");
	  String address = req.getParameter("address");
	  
	  // 값 저장
//	  req.setAttribute("name", name);
//	  req.setAttribute("id", id);
//	  req.setAttribute("pwd", pwd);
//	  req.setAttribute("phone", phone);
//	  req.setAttribute("address", address);
	  
//	  Info info = new Info();
//	  info.setAddress(address);
//	  info.setId(id);
//	  info.setName(name);
//	  info.setPhone(phone);
//	  info.setPwd(pwd);

	  Info info = new Info(name, id, pwd, phone, address);
	  req.setAttribute("info",info);
	  
	  RequestDispatcher rd = req.getRequestDispatcher("infoResult.jsp");
	  rd.forward(req, resp);
	}
//	  resp.setContentType("text/html; charset=UTF-8");
//	  PrintWriter out = resp.getWriter();
//	  out.println("<html>");
//	  out.println("<head>");
//	  out.println("<body>");
//	  out.println("<b>이름:" + name + "</b><br/>");
//	  out.println("<b>제목:" + subject + "</b><br/>");
//	  out.println("<b>내용:" + memo + "</b><br/>");
//	  out.println("</body>");
//	  out.println("</head>");
//	  out.println("</html>");
//	}


}
