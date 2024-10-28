<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String username = request.getParameter("uname");
String password = request.getParameter("password");
if (username.equals("") || password.equals("") || username.length() == 0 || password.length() == 0) {
	out.println("Provide Credentials");
	return;
}

if (username.equalsIgnoreCase("sachin") && password.equals("tendulkar"))
	out.println("Valid Credentials");
else
	out.println("Invalid Credentials");
%>
