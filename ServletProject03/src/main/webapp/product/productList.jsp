<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="container">
  <h2>Product List</h2>            
  <div class="row">
  <c:forEach items="${products }" var = "item">
<!--  <div class="col"> -->
  <div class="col-4" style="width:300px">
    <img class="card-img-top" src="../upload/${item.filename }" alt="Card image" style="width:300px; height:300px">
    <div class="card-body">
      <h4 class="card-title">${item.pname }</h4>
      <p class="card-text">${item.description }</p>
<a href ="pdetail?productId=${item.productId}" class="btn btn-secondary">상세보기</a> 
      </div>
<!--     </div> -->
    </div> <!-- col -->
   </c:forEach>
  </div>
  </div>
<%@ include file="../include/footer.jsp"%>