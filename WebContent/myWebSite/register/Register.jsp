<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="../myWeb_css/register.css">
<title>회원가입</title>
</head>
<body>
    <div class="header">
       <h1><a href="">회원가입</a></h1>
   </div>
   <div class="container">
    
    <div class="form">
     <form action="/RegisterAction" method=post>
    <div class="input-row">
       <input type="text" name="id" placeholder="id">
      </div>
      <div class="input-row">
       <input type="password" id="pw" name="pw" placeholder="password">
       </div>
       <div class="input-row">
       <input type="text" name="username" placeholder="username">
       </div>
       <div class="input-row">
       <select name="occupation" id="occupation">
           <option value="student">학생</option>
           <option value="officer">회사원</option>
           <option value="whiteman">백수</option>
       </select>
       </div>
       <div class="input-row">
       <input type="text" name="email" placeholder="E-mail">
       </div>
    </div>
       <div class="input-row">
       <input type="submit" name=login-btn value="확인">
    </div>
    </form>
   </div>
</body>
</html>