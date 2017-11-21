<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

    <%@ page import="Hoons.Cookies" %>
<%@page import="java.util.Enumeration" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<meta charset="UTF-8">
    <title>Document</title>
    <link rel="stylesheet" href="../myWeb_css/login.css">
</head>
<%
request.setCharacterEncoding("UTF-8");
String msg=(String)request.getAttribute("msg");
String referer=request.getHeader("Referer");
Cookies cookies=new Cookies(request);
String target=request.getParameter("target");
%>

<body>
<%=target %>
 <form action="/login" method=post>
   <div class="header">
       <h1><a href="">Hoon's</a></h1>
   </div>
  
   <div class="container">
    <%if(msg!=null){%>
	<%=msg %>
 <% }%>
      <div class="input-row">
      <%
		if(cookies.exists("id")){      
      %>
      <input type="text" name="id" value="<%=cookies.getValue("id")%>">
      <%}else{ %>
       <input type="text" name="id" placeholder="아이디">
       <%} %>
      </div>
      <div class="input-row">
       <input type="password" name="pw" placeholder="비밀번호">
       </div>
       
       <div id="checkBox">
       <%
       if(cookies.exists("id")){
    	 %>
    	    <input type="checkbox" name="idSet" value="idset" checked="checked"><a href="">id 저장</a>
       <%
        }else{
        	%> 	
       <input type="checkbox" name="idSet" value="idset"><a href=""></a>id 저장
      <%   	
        }
       %>
      
       </div>
       <input type="submit" name="login-btn" value="로그인">
    <input type="text" name="target" value="<%=target %>"  />
   </div>
</form>
</body>
</html>