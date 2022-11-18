<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../include/header.jsp"%>

<script>
$(function() {
$("#delBtn").click(function() {
if (confirm("정말 삭제할까요?")) {
location.href = "delete?num=${board.num}"
}
})
})
</script>

<div class="container">
<form action=detail method="get">
  <h2>Details</h2>
 
  <div class="table-responsive">
  <input type="hidden" id="num" value="${board.num }" />
    <table class="table table-bordered">
      <thead>
        <tr>
          <th>글번호</th>
          <th>작성자(ID)</th>
          <th>이메일</th>
          <th>글제목</th>
          <th>조회수</th>
          <th>작성일</th>      
          <th>글내용</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <td>${board.num }</td>
          <td>${board.userid }</td>
          <td>${board.email }</td>
          <td>${board.subject }</td>
          <td>${board.readcount }</td>
          <td>${board.regdate }</td>
          <td>${board.content }</td>
        </tr>
      </tbody>
    </table>
  </div>
  </form>
</div>

<div class = "container">
<c:if test="${sessionScope.suser.userid == board.userid }">
<button type="button" class="btn btn-primary"
onclick="location.href='update?num=${board.num}'">수정</button>
<button type="button" class="btn btn-secondary" id="delBtn">삭제</button>
<!-- 로그인 한 사람의 본인글에만 버튼이 보이도록 -->
</c:if>
</div>

<div class="container mt-5">
	<div class="form-group">
		<label for="comment">Comment:</label>
		<textarea class="form-control" rows="5" id="msg" name="text"></textarea>
	</div>
<button type="button" class="btn btn-success" id="commentBtn">Comment Write</button>
	</div>
	<div class="container mt-5">
<div class="mt-5">댓글(<span class ="cntSpan"></span>)</div>
<div id="result"></div>
</div>
<script>
var init = function(){
	$.getJSON("commentList",
	{"bnum":$("#num").val()},
	function(resp) {
// 		alert(resp.countObj.count)
		var str = "<table>"
		$.each(resp.jarr, function(key, val) {
			str+="<tr>"
			str+="<td>"+val.msg+"</td>"
			str+="<td>"+val.userid+"</td>"
			str+="<td>"+val.regdate+"</td>"
			str+="</tr>"
		})
		str+="</table>"
		$("#result").html(str);
		$(".cntSpan").text(resp.count)
		}) // getJSON
} // init
$("#commentBtn").click(function(){ //.on("click", function() ?
	if($("#msg").val()==""){
		alert("메세지를 입력하세요")
		return;
	}
	$.ajax({
			type:"post",
			url : "commentInsert",
			data : {"msg" : $("#msg").val(), "bnum" : $("#num").val()}
	})	
	.done (function(resp) {
				if(resp.trim()=="1") { // 로그인 안 됨
					alert("로그인하세요");
				    location.href="../member/login"; 
				 } else {
				   alert("성공");
				   init();
				   $("#msg").val('');
			}
	})
	.fail (function(e) {
				alert("error : " + e);
	}) //ajax
})//commentBtn
init();
</script>

<%@ include file="../include/footer.jsp"%>