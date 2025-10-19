<%@ page import="java.util.List,com.hotel.model.Room" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<Room> rooms = (List<Room>) request.getAttribute("rooms");
    if(rooms==null) {
        // if rooms not set, call SearchServlet via redirect
        response.sendRedirect("../SearchServlet");
        return;
    }
%>
<html><body>
<h2>Available Rooms</h2>
<a href="../jsp/logout.jsp">Logout</a> | <a href="../jsp/bookings.jsp">My Bookings</a>
<table border="1">
<tr><th>Room #</th><th>Type</th><th>Price</th><th>Capacity</th><th>Status</th><th>Action</th></tr>
<% for(Room r: rooms) { %>
<tr>
  <td><%=r.getRoomNumber()%></td>
  <td><%=r.getType()%></td>
  <td><%=r.getPrice()%></td>
  <td><%=r.getCapacity()%></td>
  <td><%=r.getStatus()%></td>
  <td>
  
<form action="../Hotel-Reservation-System/BookRoomServlet" method="post">
      <input type="hidden" name=room_id" value="<%=r.getRoomId()%>" />
      Check-in: <input type="date" name="checkin" required />
      Check-out: <input type="date" name="checkout" required />
      <button type="submit">Book</button>
    </form>
  </td>
</tr>
<% } %>
</table>
</body></html>
