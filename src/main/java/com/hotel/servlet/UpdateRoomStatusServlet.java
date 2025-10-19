package com.hotel.servlet;
import com.hotel.dao.RoomDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class UpdateRoomStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int roomId = Integer.parseInt(req.getParameter("room_id"));
        String status = req.getParameter("status");
        RoomDAO dao = new RoomDAO();
        dao.updateRoomStatus(roomId, status);
        res.sendRedirect("jsp/admin/adminDashboard.jsp?msg=statusupdated");
    }
}
