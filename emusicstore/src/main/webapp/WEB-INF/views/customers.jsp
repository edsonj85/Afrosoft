<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="wrapper">
	<div class="container">
		<div class="page-header">
			<h3>Customer Management</h3>
			<p class="lead">Here you can view and manage customers!</p>
		</div>

		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Name: </th>	
					<th>Email: </th>	
					<th>Phone: </th>	
					<th>Username: </th>	
					<th>Enabled: </th>				
				</tr>
			</thead>
			<tbody>
 				<c:forEach items="${ customers}" var="customer"> 
				<tr>
					<td>${customer.customerName}</td>
					<td>${customer.customerEmail }</td>
					<td>${customer.customerPhone }</td>
					<td>${customer.username }</td>
					<td>${customer.enabled }</td>
				</tr>
 				</c:forEach> 
			</tbody>
		</table>
		
<%@include file="/WEB-INF/views/templates/footer.jsp" %>