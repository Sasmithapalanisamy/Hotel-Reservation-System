<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Invalidate the session to log out the user
    if (session != null) {
        session.invalidate();
    }
    // Redirect to login page after logout
    response.sendRedirect("/Hotel-Reservation-System/jsp/login.jsp");
%>
