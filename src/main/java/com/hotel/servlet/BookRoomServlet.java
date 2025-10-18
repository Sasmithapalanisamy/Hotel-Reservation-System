package com.hotel.servlet;
import com.hotel.dao.BookingDAO;
import com.hotel.dao.RoomDAO;
import com.hotel.model.Booking;
import com.hotel.model.Room;
import com.hotel.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;

public class BookRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session=req.getSession(false);
        if(session==null || session.getAttribute("user")==null){
            res.sendRedirect("jsp/login.jsp?error=loginrequired");
            return;
        }
        User u = (User) session.getAttribute("user");
        int roomId = Integer.parseInt(req.getParameter("room_id"));
        LocalDate checkin = LocalDate.parse(req.getParameter("checkin"));
        LocalDate checkout = LocalDate.parse(req.getParameter("checkout"));

        BookingDAO bdao = new BookingDAO();
        RoomDAO rdao = new RoomDAO();
        Room room = rdao.findById(roomId);
        if(room==null){
            res.sendRedirect("jsp/search.jsp?error=noroom");
            return;
        }
        if(!bdao.isRoomAvailable(roomId, checkin, checkout)){
            res.sendRedirect("jsp/search.jsp?error=notavailable");
            return;
        }
        double days = java.time.temporal.ChronoUnit.DAYS.between(checkin, checkout);
        if(days <= 0) { res.sendRedirect("jsp/search.jsp?error=dates"); return;}
        double total = days * room.getPrice();

        Booking b = new Booking();
        b.setUserId(u.getUserId());
        b.setRoomId(roomId);
        b.setCheckinDate(checkin);
        b.setCheckoutDate(checkout);
        b.setStatus("Booked");
        b.setTotalAmount(total);

        boolean ok = bdao.createBooking(b);
        if(ok) {
            // Optionally set room to Occupied immediately or during check-in. We'll leave as Vacant until check-in.
            res.sendRedirect("jsp/success.jsp?msg=booked");
        } else {
            res.sendRedirect("jsp/search.jsp?error=bookfail");
        }
    }
}
