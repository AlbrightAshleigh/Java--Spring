    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
    
    	<h1> New Ninja</h1>
	<form:form method="POST" action="/newninja" modelAttribute="ninja">
	
	<form:label path="dojo">Dojo Name:
		<form:errors path="dojo"/><br>
		<form:select path="dojo">
		    <c:forEach items="${dojos}" var="dojo">
			<form:option value="${dojo.id}">${dojo.name}</form:option>
			</c:forEach>
		</form:select></form:label>
		<br>
	
	<form:label path="firstName">First Name
    <form:errors path="firstName"/>
    <form:textarea path="firstName"/></form:label>
    <br>
    
    <form:label path="lastName">Last Name
    <form:errors path="lastName"/>
    <form:textarea path="lastName"/></form:label>
    <br>
    
    <form:label path="age">Age
    <form:errors path="age"/>
    <form:textarea path="age"/></form:label>
    <br>
	<input type="submit" value="Create"/>
	
	</form:form>