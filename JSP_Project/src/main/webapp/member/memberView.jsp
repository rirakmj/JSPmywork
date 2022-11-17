<%@page import="com.member.dto.MemberDTO"%>
<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/member.js"></script> <!-- 회원가입 유효성 검사 그대로 쓰기 -->
<title>Insert title here</title>
</head>
<%
String sid = (String)session.getAttribute("sUserid");
MemberDAO dao = MemberDAOImpl.getInstance();
MemberDTO mdto = dao.findById(sid);
%>
<body>
<div class="container mt-3">
	<div align="right">
	<%=sid %>님 반갑습니다.
	/ <a href="logout.jsp">로그아웃</a>
	/ <a href="..board/list.jsp">게시판으로</a>
	</div>
</div>

<div class="container mt-3">
  <h2>회원정보 수정</h2>
  
<form action="memberUpdatePro.jsp" method="post" id="frm">
<input type="hidden" name="userid" id="userid" value="<%=mdto.getUserid() %>">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="text" class="form-control" id="name" name="name" value="<%=mdto.getName() %>">
    </div>
    
    <div class="form-group">
      <label for="pwd">Password:</label>
      <input type="password" class="form-control" id="pwd" placeholder="Enter Password" name="pwd" value="<%=mdto.getPwd() %>">
    </div>
    
    <div class="form-group">
      <label for="pwd_check">Password_Check:</label>
      <input type="password" class="form-control" id="pwd_check" placeholder="Enter Password_check" name="pwd_check">
    </div>
    
    <div class="form-group">
      <label for="email">Email:</label>
      <input type="text" class="form-control" id="email" name="email" value="<%=mdto.getEmail()%>">
    </div>
    <div class="form-group">
      <label for="phone">Phone:</label>
      <input type="text" class="form-control" id="phone" name="phone" value="<%=mdto.getPhone()%>">
    </div>
    
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    
    <div class="form-check-inline">
      <label class="form-check-label">
        <input type="radio" class="form-check-input" name="admin" value="0">일반회원
      </label>
    </div>
    
    <div class="form-check-inline">
      <label class="form-check-label">
        <input type="radio" class="form-check-input" name="admin" value="1">관리자
      </label>
    </div>
    <script>
    $("input:radio[value=<%=mdto.getAdmin()%>]").attr("checked", true);
    </script>
    
    <br/><br/>
    <button type="button" class="btn btn-primary" id="sendBtn">수정하기</button>
    <button type="button" class="btn btn-secondary">취소하기</button>
    <button type="button" class="btn btn-danger"
    onclick="location.href='userDeletePro.jsp'">탈퇴하기</button>
 
 </form>
 </div>
</body>
</html>