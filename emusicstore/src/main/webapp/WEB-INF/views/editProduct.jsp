<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>

<div class="wrapper">
	<div class="container">
		
		<div class="page-header">
			<h3>Edit Product</h3>
			<p class="lead">Edit the product details!</p>
		</div>
		
		<form:form action="${pageContext.request.contextPath}/admin/productInventory/editProduct" method="Post" commandName="product" enctype="multipart/form-data">
			
			<form:hidden path="productId" value="${product.productId }"/>
		
			<div class="form-group">
				<label for="name">Name:</label><form:errors path="productName" cssStyle="color: ff0000;"/>
				<form:input path="productName" cssClass="form-control" id="name" value="${product.productName }"/>
			</div>
			
			<div class="form-group">
				<label for="category">Category:</label>
				<label class="radio-inline"><form:radiobutton path="productCategory" id="category" value="category" />Instrument</label>
				<label class="radio-inline"><form:radiobutton path="productCategory" id="category" value="record" />Record</label>
				<label class="radio-inline"><form:radiobutton path="productCategory" id="category" value="accessory" />Accessory</label>
			</div>
			
			<div class="form-group">
			<label for="description">Description</label>
			<form:textarea path="productDescription" id="description" cssClass="form-control"/>
		</div>
		
		<div class="form-group">
			<label for="status">Status</label>
			<label class="radio-inline"><form:radiobutton path="productStatus" id="status" value="active"/>Active</label>
			<label class="radio-inline"><form:radiobutton path="productStatus" id="status" value="inactive"/>Inactive</label>
		</div>
		
		<div class="form-group">
			<label for="condition">Condition</label>
			<label class="radio-inline"><form:radiobutton path="productCondition" id="condition" value="new"/>New</label>
			<label class="radio-inline"><form:radiobutton path="productCondition" id="condition" value="used"/>Used</label>
		</div>
		
		<div class="form-group">
			<label for="price">Price</label><form:errors path="productPrice" cssStyle="color: ff0000;"/>
			<form:input path="productPrice" id="price" cssClass="form-control" value="${product.productPrice }" />
		</div>
		
		<div class="form-group">
			<label for="unitsInStock">Units in Stock</label><form:errors path="unitsInStock" cssStyle="color: ff0000;"/>
			<form:input path="unitsInStock" id="unitsInStock" cssClass="form-control" value="${product.unitsInStock }" />
		</div>
		
		<div class="form-group">
			<label for="manufacturer">Manufacturer</label><form:errors path="manufacturer" cssStyle="color: ff0000;"/>
			<form:input path="manufacturer" id="manufacturer" cssClass="form-control" value="${product.manufacturer }"/>
		</div>
		
		<div class="form-group">
			<label class="control-label" for="productImage">Upload image</label>
			<form:input path="productImage" id="productImage" type="file" cssClass="form:input-large"/>
		</div>
			
		<input type="submit" value="submit" class="btn btn-default"/>
		<a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
		</form:form>
		
<%@include file="/WEB-INF/views/templates/footer.jsp" %>