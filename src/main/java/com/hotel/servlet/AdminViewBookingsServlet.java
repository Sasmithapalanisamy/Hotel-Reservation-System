package com.hotel.servlet;
import com.hotel.dao.BookingDAO;
import com.hotel.model.Booking;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AdminViewBookingsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        BookingDAO dao = new BookingDAO();
        List<Booking> bookings = dao.getAllBookings();
        req.setAttribute("bookings", bookings);
        RequestDispatcher rd = req.getRequestDispatcher("jsp/admin/adminDashboard.jsp");
        rd.forward(req,res);
    }
}
