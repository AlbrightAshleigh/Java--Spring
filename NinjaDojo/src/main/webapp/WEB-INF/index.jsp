    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    

	<h1> New Dojo</h1>
	<form:form method="POST" action="/new/dojo" modelAttribute="dojo">
	
	<form:label path="name">Name
    <form:errors path="name"/>
    <form:textarea path="name"/></form:label>
    <br>
	<input type="submit" value="Create"/>
	
	</form:form>