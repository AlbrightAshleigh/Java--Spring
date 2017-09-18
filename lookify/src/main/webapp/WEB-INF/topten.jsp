<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <a href="/dashboard">Dashboard</a>


<c:forEach items="${songs}" var="song">
			<p> <c:out value="${song.rating}" /> - <a href="/songs/${song.id}"><c:out value="${song.title}"/></a> - <c:out value="${song.artist}"/> </p>
		</c:forEach>