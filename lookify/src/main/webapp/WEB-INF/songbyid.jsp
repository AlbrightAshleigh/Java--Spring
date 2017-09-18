<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <a href="/dashboard">Dashboard</a>
 
 Title:<c:out value="${song.title}"/>
 Artist: <c:out value="${song.artist}"/>
 Rating(1-10):<c:out value="${song.rating}"/>
 
 <a href="songs/delete/${song.id}">Delete</a>
 
