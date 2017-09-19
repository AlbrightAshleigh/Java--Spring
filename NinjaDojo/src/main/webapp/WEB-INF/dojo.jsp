    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<c:out value="${dojo.name}"/> 


<table>
<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Age</th>
</tr>
<c:forEach items="${ninjas}" var="ninja">
<tr>    
	<td><c:out value="${ninja.firstName}"/></td>
	<td><c:out value="${ninja.lastName}"/></td>
	<td><c:out value="${ninja.age}"/></td>
</tr>
</c:forEach>
 </table>