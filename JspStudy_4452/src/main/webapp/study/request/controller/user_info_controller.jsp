<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="user.User" %>

 <%
 	request.setAttribute("data", 100); //request저장소에 data 키값으로 100(value)이 들어감
 	User user = User.builder()
 			.username(request.getParameter("username"))
 			.phone(request.getParameter("phone"))
 			.email(request.getParameter("email"))
 			.address(request.getParameter("address"))
 			.build();
 	
 	request.setAttribute("user", user);
 %>
 <jsp:forward page="../view/user_info_show.jsp"></jsp:forward>