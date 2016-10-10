<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="container-wrapper" ng-app="cartApp">
	<div class="container">
		
		<div class="page-header">
			<h3>View Product</h3>
			<p class="lead">Check the product detail!</p>
		</div>

		<div class="container" ng-controller="cartCntrl as ctrl">
			<div class="row" >
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
					<br>
					<c:set var="role" scope="page" value="${param.role }" />
					<c:set var="url" scope="page" value="/product/productList"/>
					<c:if test="${role='admin' }">
						<c:set var="url" scope="page" value="/admin/productInventory"/>
					</c:if>
					
					<p >
						<a href="<c:url value="${url }"/>" class="btn btn-default">Back</a>
						<a href="" class="btn btn-warning btn-large" ng-click="ctrl.addToCart('${product.productId }')"><span class="glyphicon glyphicon-shopping-cart"></span>Order Now</a>
						<a href="<spring:url value="/rest/cart/{{ctrl.cart.cartId}}}" />"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
					</p>
				</div>
			</div>		
		</div>
		
		
<%@include file="/WEB-INF/views/templates/footer.jsp" %>