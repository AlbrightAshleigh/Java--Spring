<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

	<form:form method="POST" action="/new/category" modelAttribute="category">
	<h1> Add A New Category</h1>
	<form:label path="name">Name
    <form:errors path="name"/>
    <form:textarea path="name"/></form:label>
    <br>

  
	<input type="submit" value="Create"/>
	</form:form>