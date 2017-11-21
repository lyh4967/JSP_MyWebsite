<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*" %>
 <%@ page import="Hoons.Writing" %>
 <%@ page import="Hoons.BoardDao" %>
 <%@ page import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hoon's</title>
 <link rel="stylesheet" href="../myWeb_css/table.css">
</head>
<% 
request.setCharacterEncoding("UTF-8");/*utf-8 인코딩  */
//Connection conn=(Connection)session.getAttribute("conn");/*세션에서 conn정보를 받아온다  */
BoardDao BD=BoardDao.getInstance();/*게시판객체를 conn 파라미터로 생성  */
 List<Writing> list=BD.selectAllWritings();/*BoardDao객체를 이용하여 모든 게시판 리스트를 받아온다.  */
Iterator it=list.iterator(); /*글목록을 차례로 출력한다  */
%>
<body>

    <h1 class="header">Hoon's table</h1>
    <div class="write">
        <a href="/myWebSite/writer/Writer.jsp">글쓰기</a><!--글쓰기 페이지로 이동  -->
    </div>
    
    
    <table>
        <tr>
            <td>글번호</td>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
            <td>조회수</td>
        </tr>
      <%while(it.hasNext()){/*iterator컬렉터를 이용하여 글목록 출력  */
        	Writing w=(Writing)it.next();/*글객체를 생성  */
        %>
        <tr>
            <td><%=w.getID() %></td>
            <td><%=w.getTitle() %></td>
            <td><%=w.getWriter() %></td>
            <td><%=w.getDate() %></td>
            <td><%=w.getCount() %></td> 
      </tr>
        <% }%> 
    </table> 
   
    <div class="bottom">
       <label for="length"></label>
        <select name="length" id="length">
           <option value="entire">전체기간</option>
            <option value="day">1일</option>
            <option value="week">1주일</option>
            <option value="month">1달</option>
            <option value="year">1년</option>
        </select>
        <label for="content"></label>
        <select name="content" id="content">
            <option value="titleAndcontent">제목+내용</option>
            <option value="title">제목만</option>
            <option value="writer">글작성자</option>
            <option value="det">댓글내용</option>
            <option value="detWriter">댓글작성자</option>
        </select>
        <input type="text" id="content" name="content">
        <input type="submit" value="검색">
    </div>
    
    
        <div class="pagination">
                <a href="#" class="first">처음페이지</a>
                 <a href="#" class="arrow left"><<</a>
                 <a href="#" class="num">1</a>
                 <a href="#" class="num">2</a>
                 <a href="#" class="num">3</a>
                 <a href="#" class="arrow right">>></a>
                 <a href="#" class="last">끝 페이지</a>    
        </div>
   
</body>
</html>