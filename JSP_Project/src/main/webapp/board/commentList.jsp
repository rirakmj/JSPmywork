<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="com.board.dto.CommentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.board.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
int bnum = Integer.parseInt(request.getParameter("bnum"));
BoardDAO dao = BoardDAO.getInstance();
dao.commentList(bnum);
ArrayList<CommentDTO> carr = dao.commentList(bnum);
int count = dao.getCommentCount(bnum);
// main
JSONObject mainObj = new JSONObject();

// carr -> json 댓글 내용
JSONArray jarr = new JSONArray();
for(CommentDTO comm : carr) {
	JSONObject obj = new JSONObject();
	obj.put("userid", comm.getUserid());
	obj.put("cnum", comm.getCnum());
	obj.put("bnum", comm.getBnum());
	obj.put("regdate", comm.getRegdate());
	obj.put("msg", comm.getMsg());
	jarr.add(obj);
}
// 개수
JSONObject countObj = new JSONObject();
countObj.put("count",count);

// 메인에 추가, 데이터와 개수
mainObj.put("dataObj",jarr);
mainObj.put("countObj",countObj);
out.println(mainObj.toString());
%>
