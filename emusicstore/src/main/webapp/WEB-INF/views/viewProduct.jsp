<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="wrapper">
	<div class="container">
		
		<div class="page-header">
			<h3>View Product</h3>
			<p class="lead">Check the product detail!</p>
		</div>

		<div class="container" >
			<div class="row">
				<div class="col-md-5">
					<img style="width: 100%" alt="Product picture" src="<c:url value="/resources/images/${product.productId}.png"/> "> 
				</div>
				<div class="col-md-5">
					<h3>${product.productName}</h3>
					<p>
						<strong>Manufacturer: ${product.manufacturer }</strong>
					</p>
					<p>
						<strong>Category: ${product.productCategory }</strong>
					</p>
					<p>
						<strong>Condition: ${product.productCondition }</strong>
					</p>
					<p>
						<strong> Product Description: ${product.productDescription }</strong>
					</p>
					<p>
						<strong> Product Status: ${product.productStatus }</strong>
					</p>
					<h4>Price: ${product.productPrice } USD</h4>
					<p>
						<strong> Quantity: ${product.unitsInStock }</strong>
					</p>
				</div>
			</div>		
		</div>
		
<%@include file="/WEB-INF/views/templates/footer.jsp" %>