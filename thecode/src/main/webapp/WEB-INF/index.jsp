<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<form method="POST" action="/guess">
${errors}
<p>What is the code?</p>
<input type="text" name="guess">
<input type="submit" value="Try Code">
</form>