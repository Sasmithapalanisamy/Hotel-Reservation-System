<%@ page %>
<html><body>
<h2>Login</h2>
<form action="../LoginServlet" method="post">
Email: <input name="email" required/><br/>
Password: <input type="password" name="password" required/><br/>
<button type="submit">Login</button>
</form>
<% if(request.getParameter("error")!=null){ %>
 <p style="color:red;">Invalid credentials</p>
<% } %>
</body></html>
