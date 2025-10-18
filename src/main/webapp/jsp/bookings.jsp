<%@ page import="java.util.List,com.hotel.model.Booking,com.hotel.dao.BookingDAO" %>
<%
    HttpSession session = request.getSession(false);
    if(session==null || session.getAttribute("user")==null) {
        response.sendRedirect("login.jsp");
        return;
    }
    com.hotel.model.User u = (com.hotel.model.User) session.getAttribute("user");
    com.hotel.dao.BookingDAO dao = new com.hotel.dao.BookingDAO();
    List<Booking> bookings = dao.getBookingsByUser(u.getUserId());
%>
<html><body>
<h2>My Bookings</h2>
<a href="search.jsp">Search Rooms</a> | <a href="../LogoutServlet">Logout</a>
<table border="1">
<tr><th>ID</th><th>Room</th><th>Check-in</th><th>Check-out</th><th>Status</th><th>Action</th></tr>
<% for(Booking b: bookings) { %>
<tr>
  <td><%=b.getBookingId()%></td>
  <td><%=b.getRoomId()%></td>
  <td><%=b.getCheckinDate()%></td>
  <td><%=b.getCheckoutDate()%></td>
  <td><%=b.getStatus()%></td>
  <td>
    <% if("Booked".equalsIgnoreCase(b.getStatus())){ %>
      <form action="../CancelBookingServlet" method="post">
         <input type="hidden" name="booking_id" value="<%=b.getBookingId()%>" />
         <button type="submit">Cancel</button>
      </form>
    <% } %>
  </td>
</tr>
<% } %>
</table>
</body></html>
