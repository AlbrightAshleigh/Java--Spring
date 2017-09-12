    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page import="java.util.*" %>
    
    <link rel="stylesheet" href="css/style.css" type="text/css">
	
	<h1>Ninja Gold</h1>
	<p>Your Gold:<c:out value="${gold}"/></p>
	<div class="building" id = "farm">
    <form action="/process/farm" method="post">
        <h3>Farm</h3>
        (earns 10-20 gold)
        <input type="submit" name="farm" value="Find Gold!">
    </form>
    </div>
    <div class="building" id= "cave">
    <form action="/process/cave" method="post">
        <h3>Cave</h3>
        (earns 5-10 gold)
        <input type="submit"  name="cave" value="Find Gold!">
    </form>
    </div>
    <div class="building" id= "house">
    <form action="/process/house" method="post">
        <h3>House</h3>
        (earns 2-5 gold)
        <input type="submit" name="house" value="Find Gold!">
    </form>
    </div>
    <div class="building" id= "casino">
    <form action="/process/casino" method="post">
        <h3>Casino</h3>
        (earns/takes 0-50)
        <input type="submit" name="casino"  value="Find Gold!">
    </form>
    </div>
    <p>Activities:</p>
    <div class= "activity">
    
        <% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities"); %>
        		<% for (int i = 0; i < activities.size(); i++){ %>
        			<p><%= activities.get(i) %></p>
        		
        <% } %> 
    
    </div>