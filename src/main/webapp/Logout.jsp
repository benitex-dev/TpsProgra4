<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    session.invalidate();         // borra todos los datos del Session 
    response.sendRedirect("Login.jsp");  // redirige al login
%>