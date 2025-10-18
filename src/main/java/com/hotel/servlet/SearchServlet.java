package com.hotel.servlet;
import com.hotel.dao.RoomDAO;
import com.hotel.model.Room;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class SearchServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RoomDAO dao = new RoomDAO();
        List<Room> rooms = dao.getAllRooms();
        req.setAttribute("rooms", rooms);
        RequestDispatcher rd = req.getRequestDispatcher("jsp/search.jsp");
        rd.forward(req,res);
    }
}
