<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Invalid Cart!</h1>
					
					
				</div>
			</div>
		</section>
		
		<section class="container">
				<div>
				<p>
					<a href='<spring:url value="/product/productList" />' class="btn btn-default">Products</a></p>
				</div>
			</section>		
	</div>
</div>

<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>