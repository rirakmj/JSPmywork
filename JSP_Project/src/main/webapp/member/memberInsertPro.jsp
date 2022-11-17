<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="mdto" class="com.member.dto.MemberDTO"></jsp:useBean>
<jsp:setProperty property="*" name="mdto"/>

<%
MemberDAO dao = MemberDAOImpl.getInstance();
dao.memberInsert(mdto); //추가
response.sendRedirect("memberList.jsp");
%>