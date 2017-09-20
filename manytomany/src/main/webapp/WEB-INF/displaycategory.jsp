<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<h1>${category.name}</h1>

<h3>Products:</h3>
<ul>
<c:forEach items="${category.products}" var="product">
	<li><c:out value="${product.name}"/></li>
</c:forEach>
</ul>