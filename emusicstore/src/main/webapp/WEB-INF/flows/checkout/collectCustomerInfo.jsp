<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="wrapper">
	<div class="container">
		
		<div class="page-header">
			<h3>Customer</h3>
			<p class="lead">Customer Details</p>
		</div>

	<form:form commandName="order" cssClass="form-horizontal">
		<h3>Basic Info:</h3>
		<div class="form-group">
			<label for="name">Name:</label>
			<form:input path="cart.customer.customerName" id="name" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="phoneno">Phone Number:</label>
			<form:input path="cart.customer.customerPhone" id="phoneno" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="email">Email:</label>
			<form:input path="cart.customer.customerEmail" id="email" cssClass="form-control"/>
		</div>
		
		<h3>Billing Address:</h3>
		<div class="form-group">
			<label for="billingStreet">Street:</label>
			<form:input path="cart.customer.billingAddress.street" id="billingStreet" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="billingApartmentNo">Apartment Number:</label>
			<form:input path="cart.customer.billingAddress.apartmentNumber" id="billingApartmentNo" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="billingCity">City:</label>
			<form:input path="cart.customer.billingAddress.city" id="billingCity" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="billingState">State:</label>
			<form:input path="cart.customer.billingAddress.state" id="billingState" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="billingCountry">Country:</label>
			<form:input path="cart.customer.billingAddress.country" id="billingCountry" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="billingZip">Zip Code:</label>
			<form:input path="cart.customer.billingAddress.zipCode" id="billingZip" cssClass="form-control"/>
		</div>
		
		<input type="hidden" name="_flowExecutionKey" />
		
		<input value="Next" class="btn btn-default" type="submit" name="_eventId_customerInfoCollected"/>
		<button class="btn btn-default" name="_eventId_cancel" >Cancel</button>
	</form:form>
		
<%@include file="/WEB-INF/views/templates/footer.jsp" %>