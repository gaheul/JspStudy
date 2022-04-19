<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<c:forEach var="img" items="${imgList}"> <!--  imgList반복문 돌려서 img객체 들고옴-->
			<tr>
				<td>이미지 코드번호</td>
				<td>${img.fileCode} </td>
			</tr>
			<tr>
				<td>이미지</td>
				<td><img alt="" src="${realPath}${img.fileName}"></td>
			</tr>
			<tr>
				<td>생성일자</td>
				<td>${img.createDate} </td>
			</tr>
			<tr>
				<td>수정일자</td>
				<td>${img.updateDate} </td>
			</tr>
			<tr>
				<td></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>