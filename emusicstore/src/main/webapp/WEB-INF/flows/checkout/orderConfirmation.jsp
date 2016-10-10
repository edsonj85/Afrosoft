<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<<jsp:useBean id="now" class="java.util.Date"/>

<div class="wrapper">
	<div class="container">
		
		<div class="page-header">
			<h3>Order</h3>
			<p class="lead">Order Confirmation</p>
		</div>

	<div class="container">
		<div class="row">
			<form:form commandName="order" cssClass="form-horizontal">
				
				<div class="well col-xs-10 col-sm-10 cpl-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
					
					<div class="text-center">
						<h1>Receipt</h1>
					</div>
					
					<div class="row">
						<div class="col-xm-6 col-sm-6 col-md-6">
							<address>
								<strong>Shipping Address</strong><br>
								${cart.customer.shippingAddress.street }
								<br>
								${cart.customer.shippingAddress.apartmentNumber }
								<br>
								${cart.customer.shippingAddress.city }, ${cart.customer.shippingAddress.state }
								<br>
								${cart.customer.shippingAddress.country }, ${cart.customer.shippingAddress.zipCode }
								<br>
							</address>
						</div>
						<div class="col-xm-6 col-sm-6 col-md-6 text-right">
							<p>Shipping Date: <fmt:formatDate type="date" value="${now }" /></p>
						</div>
					</div>
					
					<div class="row">
						<div class="col-xm-6 col-sm-6 col-md-6">
							<address>
								<strong>Billing Address</strong><br>
								${cart.customer.billingAddress.street }
								<br>
								${cart.customer.billingAddress.apartmentNumber }
								<br>
								${cart.customer.billingAddress.city }, ${cart.customer.billingAddress.state }
								<br>
								${cart.customer.billingAddress.country }, ${cart.customer.billingAddress.zipCode }
								<br>
							</address>
						</div>
					</div>
					
					<div class="row">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>Product</th>
									<th>#</th>	
									<th class="text-center">Price</th>
									<th class="text-center">Total</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<c:forEach var="cartItem" items="${cart.cartItems }">
										<td class="col-md-9">${cartItem.product.productName }</td>
										<td class="col-md-1">${cartItem.quantity}</td>
										<td class="col-md-1">${cartItem.product.productPrice }</td>
										<td class="col-md-1">${cartItem.totalPrice }</td>
									</c:forEach>
								</tr>
								
								<tr>
									<td></td>
									<td></td>
									<td class="text-right">
										<h4><strong>Grand Total: </strong></h4>
									</td>
									<td>
										<h4><strong>$ ${cart.grondTotal }</strong></h4>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					
					<input type="hidden" name="_flowExecutionKey" />
					
					<button class="btn btn-default" name="_eventId_backToCollectShippingDetail">Back</button>
					
					<input value="Submit Order" class="btn btn-default" type="submit" name="_eventId_orderConfirmed"/>
					<button class="btn btn-default" name="_eventId_cancel" >Cancel</button>
				
				</div>
			</form:form>
		</div>
	</div>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>