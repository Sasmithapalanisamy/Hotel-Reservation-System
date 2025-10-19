<%@ page import="java.util.List,com.hotel.model.Booking,com.hotel.dao.BookingDAO,com.hotel.dao.RoomDAO,com.hotel.model.Room" %>
<%
    BookingDAO bdao = new BookingDAO();
    List<Booking> bookings = bdao.getAllBookings();
    RoomDAO rdao = new RoomDAO();
    List<Room> rooms = rdao.getAllRooms();
%>
<html><body>
<h2>Admin Dashboard</h2>
<a href="../LogoutServlet">Logout</a>
<h3>Rooms</h3>
<table border="1">
<tr><th>ID</th><th>Number</th><th>Type</th><th>Status</th><th>Change Status</th></tr>
<% for(Room r: rooms) { %>
<tr>
  <td><%=r.getRoomId()%></td>
  <td><%=r.getRoomNumber()%></td>
  <td><%=r.getType()%></td>
  <td><%=r.getStatus()%></td>
  <td>
    <form action="../../UpdateRoomStatusServlet" method="post">
      <input type="hidden" name="room_id" value="<%=r.getRoomId()%>" />
      <select name="status">
        <option value="Vacant">Vacant</option>
        <option value="Occupied">Occupied</option>
        <option value="Maintenance">Maintenance</option>
      </select>
      <button type="submit">Update</button>
    </form>
  </td>
</tr>
<% } %>
</table>

<h3>All Bookings</h3>
<table border="1">
<tr><th>ID</th><th>User</th><th>Room</th><th>Check-in</th><th>Check-out</th><th>Status</th></tr>
<% for(Booking b: bookings) { %>
<tr>
  <td><%=b.getBookingId()%></td>
  <td><%=b.getUserId()%></td>
  <td><%=b.getRoomId()%></td>
  <td><%=b.getCheckinDate()%></td>
  <td><%=b.getCheckoutDate()%></td>
  <td><%=b.getStatus()%></td>
</tr>
<% } %>
</table>
</body></html>
