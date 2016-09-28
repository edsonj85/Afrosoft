<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="wrapper">
	<div class="container">
		<h1>All Products</h1>
		<div class="page-header">
			<h3>All products</h3>
			<p class="lead">Check all awesome products available now!</p>
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
				
					<td><img style="width: 100%" alt="Product picture" src="<c:url value="/resources/images/${product.productId}.png"/> " />  </td>
					<td>${product.productName}</td>
					<td>${product.productCategory}</td>
					<td>${product.productCondition}</td>
					<td>${product.productPrice}</td>
					<td><a href="<spring:url value="/product/viewProduct/${product.productId }" />"><span class="glyphicon glyphicon-info-sign"></span></a> </td>
				</tr>
 				</c:forEach> 
			</tbody>
		</table>
		
<%@include file="/WEB-INF/views/templates/footer.jsp" %>