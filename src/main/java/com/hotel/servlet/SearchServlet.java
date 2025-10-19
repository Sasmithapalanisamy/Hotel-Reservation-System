package com.hotel.servlet;
import com.hotel.dao.RoomDAO;
import com.hotel.model.Room;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
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
