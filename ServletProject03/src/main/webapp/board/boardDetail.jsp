<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<title>Insert title here</title>
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
    <button type="button" class="btn btn-primary"
onclick="location.href='update?num=${board.num}'">수정</button>
<button type="button" class="btn btn-secondary" id="delBtn">삭제</button>

<div class="container mt-5">
<div class="form-group">
<label for="comment">Comment:</label>
<textarea class="form-control" rows="5" id="msg" name="text"></textarea>
</div>
<button type="button" class="btn btn-success" id="commentBtn">Comment Write</button>
</div>
<div class="mt-5">댓글(<span class ="cntSpan"></span>)</div>
<div id="result"></div>
</div>


<%@ include file="../include/footer.jsp"%>
