<%@ page %>
<html><body>
<h2>Register</h2>
<form action="../RegisterServlet" method="post">
Name: <input name="name" required/><br/>
Email: <input name="email" required/><br/>
Password: <input type="password" name="password" required/><br/>
<button type="submit">Register</button>
</form>
<% if(request.getParameter("error")!=null){ %>
 <p style="color:red;">Error: <%=request.getParameter("error")%></p>
<% } %>
</body></html>
