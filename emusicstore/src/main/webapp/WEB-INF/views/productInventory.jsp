<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="wrapper">
	<div class="container">
		<h1>Product Inventory</h1>
		<div class="page-header">
			<h3>All products</h3>
			<p class="lead">Manage all the products in stock!</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Photo Thump</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>Condition</th>
					<th>Price</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
 				<c:forEach items="${ products}" var="product"> 
				<tr>
				
					<td><img style="width: 100%" alt="Product picture" src="<c:url value="/resources/images/${product.productId}.png"/> " /> </td>
					<td>${product.productName}</td>
					<td>${product.productCategory}</td>
					<td>${product.productCondition}</td>
					<td>${product.productPrice}</td>
					<td><a href="<spring:url value="/productList/viewProduct/${product.productId }" />"><span class="glyphicon glyphicon-info-sign"></span></a>
						<a href="<spring:url value="/admin/productInventory/editProduct/${product.productId }" />"><span class="glyphicon glyphicon-pencil"></span></a>
						<a href="<spring:url value="/admin/productInventory/deleteProduct/${product.productId }" />"><span class="glyphicon glyphicon-remove"></span></a>
					 </td>
				</tr>
 				</c:forEach> 
			</tbody>
		</table>
		
		<a href="<spring:url value="/admin/productInventory/addProduct"/>" class="btn btn-primary">Add Product</a>
		
<%@include file="/WEB-INF/views/templates/footer.jsp" %>