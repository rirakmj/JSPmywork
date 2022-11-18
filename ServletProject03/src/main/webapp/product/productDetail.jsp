<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>상품 상세보기</h1>
	</div>
</div>
   
 <div class='d-flex container'>
 	<div class="card" style="width:300px">
    	<img class="card-img-top" src="../upload/${product.filename }" alt="Card image" style="width:100%; height:100%">
    </div>
  <div class="container">
  	<table class="table table-borderless">
  	<tr>
  	 <td width="200px">제품 번호</td>
  	 <td>${product.productId }</td>
  	 </tr>
  	<tr>
  	 <td width="200px">상품명(분류)</td>
  	 <td>${product.pname }(${product.category })</td>
  	 </tr>
  	 <tr>
  	 <td width="200px">가격</td>
  	 <td>${product.unitPrice }</td>
  	 </tr>
  	 <tr>
  	 <td width="200px">설명</td>
  	 <td>${product.description }</td>
  	 </tr>
  	 <tr>
  	 <td width="200px">제조사</td>
  	 <td>${product.manufacturer }</td>
  	 </tr>
  	 <tr>
  	 <td width="200px">재고수</td>
  	 <td>${product.unitsInStock }</td>
  	 </tr>
  	 <tr>
  	 <td width="200px">상태</td>
  	 <td>${product.condition }</td>
  	 </tr>
  	  	 </table>
  </div>
  </div>
   <br/><br/>
    <%@ include file="../include/footer.jsp"%>