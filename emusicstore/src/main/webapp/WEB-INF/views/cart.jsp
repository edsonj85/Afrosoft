<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Cart</h1>
					
					<p>All the selected products in your shopping cart.</p>
				</div>
			</div>
		</section>
		
		<section class="container" ng-app="cartApp">
			<div ng-controller="cartCntrl as ctrl" ng-init="ctrl.initCartId('${cartId }')">
				<div>
					<a class="btn btn-danger pull-left" href="#" ng-click="ctrl.deleteCart()"><span class="glyphicon glyphicon-remove">Clear Cart</span></a>
				</div>
				<table class="table table-hover">
					<tr>
						<th>Product Name</th>
						<th>Unit Price</th>
						<th>Quantity</th>
						<th>Price</th>
						<th>Action</th>
					</tr>
					<tr ng-repeat="item in ctrl.cart.cartItems">
						<td>{{item.product.productName}}</td>
						<td>{{item.product.unitPrice}}</td>
						<td>{{item.quantity}}</td>
						<td>{{item.totalPrice}}</td>
						<td><a href="#" class="label label-danger" ng-click="ctrl.removeFromCart('item.product.productId')"><span class="glyphicon glyphicon-remove"></span>remove</a></td>
					</tr>
					
					<tr>
						<th></th>
						<th></th>
						<th>Grand Total</th>
						<th>{{ctrl.calGrandTotal()}}}</th>
						<th></th>
					</tr>
				</table>
				
				<a href='<spring:url value="/productList" />' class="btn btn-default">Continue Shopping</a>
				</div>
			</section>		
	</div>
</div>

<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>