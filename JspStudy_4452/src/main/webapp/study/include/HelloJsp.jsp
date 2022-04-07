<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
	private String name = "김가흘";
	private String phone = "010-2208-4452";
	private String email = "rkgmf1230@naver.com";
	
	public void show(){
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=name %></title>
</head>
<body>
	<%
		for(int i =0; i< 5; i++){
			show(); 
	%>
		<p><%=name %></p> <!--표현식은 태그안(html)  -->
	<%
		}
	%>
	<h1>hello JSP</h1>
</body>
</html>