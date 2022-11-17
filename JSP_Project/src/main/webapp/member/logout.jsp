<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
session.invalidate(); // session 다 지우는 것
response.sendRedirect("loginForm.jsp");
%>