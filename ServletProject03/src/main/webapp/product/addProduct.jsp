<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>상품등록</h1>
	</div>
</div>

  <form action="pInsert" method="post" enctype="multipart/form-data">
  <div class=container>
    <div class="form-group">
      <label for="productId">ProductID:</label>
      <input type="text" class="form-control" placeholder="Enter productID" id="productId" name="productId">
    </div>
    <div class="row">
      <div class="col">
         <label for="name">Name:</label>
      <input type="text" class="form-control" placeholder="Enter name"  id="name" name="name">
      </div>
    </div>
    <div class="form-group">
      <label for="unitprice">Unit Price:</label>
      <input type="text" class="form-control" placeholder="Enter unitprice" id="unitprice" name="unitPrice">
    </div>
    <div class="form-group">
      <label for="description">Description:</label>
      <input type="text" class="form-control"  placeholder="Enter description" id="description" name="description">
    </div>
    <div class="form-group">
      <label for="category">Category:</label>
      <input type="text" class="form-control" placeholder="Enter category" id="category" name="category">
    </div>
    <div class="form-group">
      <label for="manufacturer">Manufacturer:</label>
      <input type="text" class="form-control" placeholder="Enter manufacturer" id="manufacturer" name="manufacturer">
    </div>
    
     <div class="form-group">
      <label for="unitsInStock">Units In Stock:</label>
      <input type="text" class="form-control" placeholder="Enter units In Stock" id="unitsInStock" name="unitsInStock">
    </div>
    
    <div class="">
    <div class="form-check-inline">
      <label class="form-check-label">
        <input type="radio" class="form-check-input" name="condition" value="New" checked>New
      </label>
    </div>
    <div class="form-check-inline">
      <label class="form-check-label">
        <input type="radio" class="form-check-input" name="condition" value="Old">Old
      </label>
    </div>
    <div class="form-check-inline">
      <label class="form-check-label">
        <input type="radio" class="form-check-input" name="condition" value="Refurbished">Refurbished
      </label>
    </div><br><br>
    </div>
    
    <div class="form-group">
      <label for="file">file:</label>
      <input type="file" class="form-control" placeholder="Enter file" id="productImage" name="productImage">
    </div>
    </div>
    
    <div class = container>
    <button type="submit" class="btn btn-primary" id="sendBtn">등록</button>
    </div>
    
	</form>







<%@ include file="../include/footer.jsp"%>