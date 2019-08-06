<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	
</head>
    
<div style="min-height:561px;">
	<h1>게시글 등록</h1>
	<form method="Post" action="<%=request.getContextPath()%>/board/modify">
		<input type="hidden" value="${board.num}" name="num">
		<div class="form-group">
			<input type="text" class="form-control" name="title" value="${board.title}">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
		</div>
		<textarea id="summernote" name="contents">${board.contents}</textarea>
		<button type="submit" class="btn btn-success">수정하기</button>
	</form>
</div>
<script>
	$(document).ready(function(){
		$('#summernote').summernote({
		  placeholder: '내용을 입력해주세요',
		  tabsize: 2,
		  height: 300,
		   lang: 'ko-KR'
		});
	});
</script>
