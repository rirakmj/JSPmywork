<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 	request.setCharacterEncoding("utf-8"); // 인코딩하고 객체를 넣는다
 %>   
 <jsp:useBean id="board" class="com.board.dto.BoardDTO"></jsp:useBean>
<jsp:setProperty property="*" name ="board" />
 
 <%
 	BoardDAO dao = BoardDAO.getInstance();
  
     String ip = request.getRemoteAddr() ;
     board.setIp(ip);
 	 dao.boardInsert(board);
 	 response.sendRedirect("list.jsp");
 %>