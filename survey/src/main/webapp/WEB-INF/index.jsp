    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
   
   <h1>Coding Dojo Survey</h1>
   <form method="POST" action="/process">
    <p>Your Name: <input type="text" name="name"></p>
    <p>Dojo Location:<select name="location"></p>
                <option value="Washington D.C.">Washington D.C.</option>
                <option value="Chicago">Chicago</option>
                <option value="Boston">Boston</option>
                <option value="Richmond">Richmond</option>
            </select>
            <p>Favorite Location:<select name="language">
                <option value="python">Python</option>
                <option value="c++">C++</option>
                <option value="javascript">Javascript</option>
                <option value="mean">MEAN</option>
            </select></p>
            <p>Comments(optional):</p><p><textarea rows="4" cols="40" placeholder="Type your comments here..." name="comment"></textarea></p>
            <p><input type="submit"  value="Submit"></p>
   
	</form>
    