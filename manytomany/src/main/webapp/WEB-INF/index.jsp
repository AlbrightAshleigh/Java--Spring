<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="POST" action="/new/product" modelAttribute="product">
	
	<h1> Add A New Product</h1>
	<form:label path="name">Name
    <form:errors path="name"/>
    <form:textarea path="name"/></form:label>
    <br>
    
    <form:label path="description">Description
    <form:errors path="description"/>
    <form:textarea path="description"/></form:label>
    <br>
    <form:label path="price">Price
    <form:errors path="price"/>
    <form:textarea path="price"/></form:label>
    <br>
	<input type="submit" value="Create"/>
	
	</form:form>