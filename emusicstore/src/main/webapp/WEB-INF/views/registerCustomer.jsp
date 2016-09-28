<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="wrapper">
	<div class="container">
		
		<div class="page-header">
			<h3>Register</h3>
			<p class="lead">Enter your details to register!</p>
		</div>

	<form:form action="${pageContext.request.contextPath }/register" commandName="customer" method="post">
		<h3>Basic Info:</h3>
		<div class="form-group">
			<label for="name">Name:</label>
			<form:input path="customerName" id="name" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="username">User Name:</label>
			<form:input path="username" id="username" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="password">Password:</label>
			<form:password path="password" id="password" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="phoneno">Phone Number:</label>
			<form:input path="customerPhone" id="phoneno" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="email">Username:</label>
			<form:input path="customerEmail" id="email" cssClass="form-control"/>
		</div>
		
		<h3>Shipping Address:</h3>
		<div class="form-group">
			<label for="shippingStreet">Street:</label>
			<form:input path="shippingAddress.street" id="shippingStreet" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingApartmentNo">Apartment Number:</label>
			<form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNo" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingCity">Street:</label>
			<form:input path="shippingAddress.city" id="shippingCity" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingState">Street:</label>
			<form:input path="shippingAddress.state" id="shippingState" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingStreet">Street:</label>
			<form:input path="shippingAddress.street" id="shippingStreet" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingCountry">Street:</label>
			<form:input path="shippingAddress.country" id="shippingCountry" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingZip">Street:</label>
			<form:input path="shippingAddress.zipCode" id="shippingZip" cssClass="form-control"/>
		</div>
		
				<h3>Shipping Address:</h3>
		<div class="form-group">
			<label for="shippingStreet">Street:</label>
			<form:input path="shippingAddress.street" id="shippingStreet" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingApartmentNo">Apartment Number:</label>
			<form:input path="shippingAddress.apartmentNumber" id="shippingApartmentNo" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingCity">Street:</label>
			<form:input path="shippingAddress.city" id="shippingCity" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingState">Street:</label>
			<form:input path="shippingAddress.state" id="shippingState" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingStreet">Street:</label>
			<form:input path="shippingAddress.street" id="shippingStreet" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingCountry">Street:</label>
			<form:input path="shippingAddress.country" id="shippingCountry" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="shippingZip">Street:</label>
			<form:input path="shippingAddress.zipCode" id="shippingZip" cssClass="form-control"/>
		</div>
		
		<input value="Sumbit" class="btn btn-default" type="submit"/>
		<a href="<c:url value="/"/>" class="btn btn-default">Cancel</a>
	</form:form>
		
<%@include file="/WEB-INF/views/templates/footer.jsp" %>