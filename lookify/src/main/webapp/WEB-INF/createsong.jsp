<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<h1>Add A New Song</h1> <a href="/dashboard">Dashboard</a>
<!-- ... -->
<form:form method="POST" action="/songs/new" modelAttribute="song">

	<form:label path="artist">Artist
    <form:errors path="artist"/>
    <form:textarea path="artist"/></form:label>
    <br>
    
    
    <form:label path="title">Title
    <form:errors path="title"/>
    <form:input path="title"/></form:label>
    <br>
    
    
    
    <form:label path="rating">rating
    <form:errors path="rating"/>
    		    <form:select path="rating">
		    		<% for(int i = 1; i <= 10; i++) { %>
		    			<form:option value="<%=i %>"><%= i %></form:option>
		    		<% } %>
		    </form:select></form:label><br>
    
    <input type="submit" value="Submit"/>
    <% if(request.getAttribute("errs") != null) { %>
	  	<fieldset>
	  		<legend>Errors</legend>
	  		<c:forEach items="${errs}" var="err">
				<p><c:out value="${err.getDefaultMessage()}"/></p>
			</c:forEach>
	  	</fieldset>
	  	<% } %>
</form:form>