<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<a href=""></a> <a href=""></a> 

<form method="POST" action="/search">
	  		Search: <input type="text" name="search"> <button type="submit">Search</button>
	  		</form>
	  		
	  		<c:out value="${searchitem}"/>
<table border= "1">
	<thead>
		<th>Name</th>
		<th>Rating</th>
		<th>Actions</th>
	</thead>
	<c:forEach items="${songs}" var="song">
	<tr>
		<td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
		<td><c:out value="${song.rating}"/></td>
		<td><a href="songs/delete/${song.id}">Delete</a></td>
	</tr>
	</c:forEach>
</table>