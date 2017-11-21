<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="Hoons.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="../myWeb_css/register.css">
<title>마이 페이지</title>
</head>
<% 
User u=(User)session.getAttribute("u");
%>
<body>
계정 삭제
    <div class="header">
       <h1><a href="Updatemember.jsp">마이 페이지</a></h1>
   </div>
   <div class="container">
    
    <div class="form">
     <form action="/UpdateMember" method=post>
      </div>
      <div class="input-row">
       <input type="password" id="pw" name="pw" value=${u.getPwd() }>
       </div>
       <div class="input-row">
       <input type="text" name="username" value=${u.getName() }>
       </div>
       <div class="input-row">
       <select name="occupation" id="occupation">
           <option value="student">학생</option>
           <option value="officer">회사원</option>
           <option value="whiteman">백수</option>
       </select>
       </div>
       <div class="input-row">
       <input type="text" name="email" value=${u.getEmail() }>
       </div>
    </div>
       <div class="input-row">
       <input type="submit" name=login-btn value="확인">
    </div>
    </form>
   </div>
</body>
</html>