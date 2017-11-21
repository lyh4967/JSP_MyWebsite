<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../myWeb_css/writer.css">
<title>글 작성</title>
</head>
<body>
	<div class="header">
		<div class="inner">
			<h1>글쓰기</h1>
		</div>
	</div>

	<div class="main">
		<div class="inner">
			<form action="/InsertBoard" method="post">
				<div class="editor-box">

					<!--글작성 서블릿 이동  -->
					<ul>
						<li><label for="">카테고리</label> <select name="table-select">
								<option value="Hoon">Hoon's게시판</option>
						</select> <select name="head" id="">
								<option value="">말머리선택</option>
						</select></li>
						<li><label for="">제목</label> <input type="text" name="title">
							<!--"title"이라는 이름으로 제목전송  --></li>
						<li><div class="file">
								<label for="">파일첨부</label>
								<ul>
									<li><a href="">사진</a><span>|</span></li>
									<li><a href="">동영상</a><span>|</span></li>
									<li><a href="">지도</a><span>|</span></li>
									<li><a href="">GPS</a><span>|</span></li>
									<li><a href="">일정</a><span>|</span></li>
									<li><a href="">링크</a><span>|</span></li>
									<li><a href="">파일</a><span>|</span></li>
									<li><a href="">투표</a><span>|</span></li>
									<li><a href="">음악</a></li>
								</ul>
							</div>
							<div class="writing">
								<textarea name="textarea" rows=10></textarea>
								<!--name=textarea로 내용 전송  -->
							</div></li>
					</ul>
				</div>
				<input type="submit" name="login-btn" value="등록">
			</form>
		</div>
	</div>
</body>
</html>