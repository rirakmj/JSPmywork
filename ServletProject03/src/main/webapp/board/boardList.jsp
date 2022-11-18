<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<script>
$(function() {
	$("#writeBtn").click(function() {
		if(${empty sessonScope.suser }) {
			alert("로그인 하세요");
			location.href="../member/login"
			return false;
		}
		location.href="../member/write"
	})
})

</script>
<div class="container">
<a href ="write"><button type="button" class="btn btn-secondary" id="writeBtn">글쓰기</button></a>
  <h2>Board List</h2>            
  <table class="table table-striped">
    <thead>
      <tr>
      <th>글번호</th>
        <th>작성자(ID)</th>
        <th>제목</th>
        <th>내용</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${arr }" var="list">
      <tr>
      <td>${list.num }</td>
        <td>${list.userid }</td>
        <td><a href="detail?num=${list.num }">${list.subject }</a></td>
        <td>${list.content }</td>
      </tr>
 	</c:forEach>
    </tbody>
  </table>
</div>
<%@ include file="../include/footer.jsp"%>