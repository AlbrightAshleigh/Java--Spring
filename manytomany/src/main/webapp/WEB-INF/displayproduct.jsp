<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

	<h1>${product.name}</h1>
	
	<form action="/product/add/${product.id}" method="POST">
		<select name="category">
			<c:forEach items="${categories}" var="category">
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add">
	</form>
	<h3>Categories:</h3>
	<ul>
	<c:forEach items="${product.categories}" var="category">
		<li><c:out value="${category.name}"/></li>
	</c:forEach>
	</ul>

