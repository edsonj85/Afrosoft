<%@include file="/WEB-INF/views/templates/header.jsp" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="container-wrapper">
	<div class="container">
		<section>
			<div class="jumbotron">
				<div class="container">
					<h1>Thanks for doing business with us!</h1>
					
					<p>Your order will be shipped in two days time</p>
				</div>
			</div>
		</section>
		
		<section class="container">
				<div>
				<p>
					<a href='<spring:url value="/" />' class="btn btn-default">Ok</a></p>
				</div>
			</section>		
	</div>
</div>

<script src="<c:url value="/resources/js/controller.js" />"></script>
<%@include file="/WEB-INF/views/templates/footer.jsp" %>