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
		
		<section class="container">
			<div>
				<a class="btn btn-danger pull-left"><span class="glyphicon glyphicon-remove">Clear Cart</span></a>
			</div>
			<table class="table table-hover">
				<tr>
					<th>Product Name</th>
					<th>Unit Price</th>
					<th>Quantity</th>
					<th>Price</th>
					<th>Action</th>
				</tr>
				<tr>
					<td>productName</td>
					<td>unitPrice</td>
					<td>quantity</td>
					<td>price</td>
					<td>remove button</td>
				</tr>
				
				<tr>
					<th></th>
					<th></th>
					<th>Grand Total</th>
					<th>grandTotal</th>
					<th></th>
				</tr>
			</table>
			
			<a href='<spring:url value="/productList" />'>Continue Shopping</a>
		</section>
	</div>
</div>

<%@include file="/WEB-INF/views/templates/footer.jsp" %>