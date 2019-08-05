<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
	<style type="text/css">
	
	.login-box{
		border:3px solid green;
		width:400px;
		height:200px;
		margin:100px auto 0;
		padding:20px;
	}
	</style>
</head>
<div style="height: 600px">
	<c:if test="${user eq null }">
		<div class="login-box">
			<form method="Post" action="<%=request.getContextPath()%>/">
				<div class="form-group">
				  <input type="text" class="form-control" name="id" placeholder="아이디를 입력하세요">
				</div>
				<div class="form-group">
				  <input type="password" class="form-control" name="pw" placeholder="비밀번호를 입력하세요">
				</div>
				<button type="submit" class="btn btn-success col-12">로그인</button>
			</form>
		</div>
	</c:if>
</div>

