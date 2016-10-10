<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="wrapper">
	<div class="container">
		<h1>All Products</h1>
		<div class="page-header">
			<h3>Administrator</h3>
			
			<p class="lead">Manage the products!</p>
		</div>
		
		<c:if test="${pageContext.request.userPrincipal.name != null }">
			<h2>
				Welcome: ${pageContext.request.userPrincipal.name } | <a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
			</h2>
		</c:if>

		<a href="<spring:url value="/admin/productInventory"/>" class="btn btn-link">Product Inventory</a>
		
		<p>Here you can view, check and modify product inventory.</p>
		
		<br><br>
		
		<a href="<spring:url value="/admin/customers"/>" class="btn btn-link">Customer Management</a>
		
		<p>Here you can view, check and modify product inventory.</p>
		
<%@include file="/WEB-INF/views/templates/footer.jsp" %>