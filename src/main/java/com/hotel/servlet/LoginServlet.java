package com.hotel.servlet;
import com.hotel.dao.UserDAO;
import com.hotel.model.User;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email=req.getParameter("email");
        String password=req.getParameter("password");
        UserDAO dao = new UserDAO();
        User u = dao.findByEmailPassword(email,password);
        if(u!=null){
            HttpSession session=req.getSession();
            session.setAttribute("user", u);
            if("admin".equalsIgnoreCase(u.getRole())) res.sendRedirect("jsp/admin/adminDashboard.jsp");
            else res.sendRedirect("jsp/search.jsp");
        } else {
            res.sendRedirect("jsp/login.jsp?error=1");
        }
    }
}
