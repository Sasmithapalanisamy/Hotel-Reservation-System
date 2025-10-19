package com.hotel.servlet;
import com.hotel.dao.UserDAO;
import com.hotel.model.User;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String name=req.getParameter("name");
        String email=req.getParameter("email");
        String password=req.getParameter("password");

        // simple email regex
        if(!email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            res.sendRedirect("jsp/register.jsp?error=invalidemail");
            return;
        }
        
        res.getWriter().print("In registerServlet");

        User u = new User();
        u.setName(name); u.setEmail(email); u.setPassword(password); u.setRole("guest");
        UserDAO dao = new UserDAO();
        boolean saved = dao.save(u);
        if(saved) res.sendRedirect("jsp/login.jsp?msg=registered");
        else res.sendRedirect("jsp/register.jsp?error=exists");
    }
}
