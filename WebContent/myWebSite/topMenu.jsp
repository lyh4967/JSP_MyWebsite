<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
request.setCharacterEncoding("UTF-8");
%>
<body>

<div class="category">
	<h1 class="header"><a href="">Hoon's Home</a></h1>
        <ul>
            <li><a href="/myWebSite/index.jsp">Home</a></li><!--메인페이지로  -->
            <li><a href="#">News</a></li><!--없음  -->
            <li><a href="#">Contact</a></li><!--없음  -->
            <li class="dropdown"><a href="#" class="dropbtn">게시판</a><!--드랍다운  -->
            <div class="dropdown-content">
                <a href="table/Table.jsp">Hoon's 게시판</a><!--게시판으로  -->
            </div>
            </li>
            
            <!--세션에 아이디정보가 있으면 로그아웃 블락  -->
             <c:choose>
             <c:when test="${sessionScope.id!=null}">
             <li class="member"><a href="MyGoogle.html">Sitemap</a></li><!--구글지도로 가는 a태그  -->
            <li class="member"><a href="logout.jsp">로그아웃</a></li><!--로그아운.jsp  -->
            <li class="member"><a href="/LoadMember">마이 페이지</a></li><!--로그인 정보출력  -->
            <!--세션에 아이디 정보가 없으면 로그인 블락  -->
        	</c:when>
        	<c:otherwise>
            <li class="member"><a href="MyGoogle.html">Sitemap</a></li>
            <li class="member"><a href="register/Register.jsp">회원가입</a></li>
            <li class="member"><a href="login/Login.jsp">로그인</a></li>
            </c:otherwise>
            </c:choose>
        </ul>
    </div>
</body>
</html>