<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String userid = request.getParameter("userid");
String pwd = request.getParameter("pwd");
MemberDAO dao = MemberDAOImpl.getInstance();
//  로그인 체크
int flag = dao.loginCheck(userid, pwd);
// 세션에 저장해야될 때는 0 또는 1일 때
if(flag==0 || flag==1){
	session.setAttribute("sUserid", userid);
}
out.println(flag);
%>