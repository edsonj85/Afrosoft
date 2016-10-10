<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="wrapper">
	<div class="container">
		
		<div class="page-header">
			<h3>Shipping</h3>
			<p class="lead">Shipping Detail</p>
		</div>

	<form:form commandName="order" cssClass="form-horizontal">
		
		<h3>Shipping Address:</h3>
		<div class="form-group">
			<label for="shippingStreet">Street:</label>
			<form:input path="cart.customer.shippingAddress.street" id="shippingStreet" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingApartmentNo">Apartment Number:</label>
			<form:input path="cart.customer.shippingAddress.apartmentNumber" id="shippingApartmentNo" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingCity">City:</label>
			<form:input path="cart.customer.shippingAddress.city" id="shippingCity" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingState">State:</label>
			<form:input path="cart.customer.shippingAddress.state" id="shippingState" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingCountry">Country:</label>
			<form:input path="cart.customer.shippingAddress.country" id="shippingCountry" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingZip">Zip Code:</label>
			<form:input path="cart.customer.shippingAddress.zipCode" id="shippingZip" cssClass="form-control"/>
		</div>
		
		<input type="hidden" name="_flowExecutionKey" />
		
		<button class="btn btn-default" name="_eventId_backToCollectCustomerInfo">Back</button>
		
		<input value="Next" class="btn btn-default" type="submit" name="_eventId_shippingDetailCollected"/>
		<button class="btn btn-default" name="_eventId_cancel" >Cancel</button>
	</form:form>
		
<%@include file="/WEB-INF/views/templates/footer.jsp" %>