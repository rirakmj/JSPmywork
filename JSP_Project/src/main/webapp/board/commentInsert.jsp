<%@page import="com.board.dto.CommentDTO"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String msg = request.getParameter("msg");
	int bnum = Integer.parseInt(request.getParameter("bnum"));
	session.getAttribute("sUserid");
	String sid = (String)session.getAttribute("sUserid");
	if(sid==null) { // 로그인 안 됨
		out.println("1");
	}else { // 로그인	
	BoardDAO dao = BoardDAO.getInstance();
	CommentDTO comment = new CommentDTO();
	comment.setMsg(msg);
	comment.setBnum(bnum);
	comment.setUserid(sid);
	dao.commentInsert(comment);
	}
%>