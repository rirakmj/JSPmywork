<%@page import="com.member.dto.MemberDTO"%>
<%@page import="com.member.dao.MemberDAOImpl"%>
<%@page import="com.member.dao.MemberDAO"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String userid = request.getParameter("userid");
MemberDAO dao = MemberDAOImpl.getInstance();
dao.memberDelete(userid); // 삭제 실행
ArrayList<MemberDTO> marr = dao.memberList();
int count = dao.getCount();
// System.out.println(count);

// 자바 ==> json

// mainObj (루트), 멤버리스트와 숫자를 아우르는 객체
JSONObject mainObj = new JSONObject();

// countObj (개수)
JSONObject countObj = new JSONObject();
countObj.put("count",count);

// jarr (배열)
JSONArray jarr = new JSONArray();
for(MemberDTO mdto: marr){
 	String mode = mdto.getAdmin()==0?"일반회원":"관리자";
	JSONObject obj = new JSONObject();
	obj.put("name", mdto.getName());
	obj.put("userid",mdto.getUserid());
	obj.put("pwd",mdto.getPwd());
	obj.put("email",mdto.getEmail());
	obj.put("phone",mdto.getPhone());
	obj.put("admin",mode);
	jarr.add(obj);
}
mainObj.put("countObj", countObj);
mainObj.put("jarrObj",jarr);
out.println(mainObj.toString());
%>