<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	
</head>
    
<div style="min-height:561px;">
	<h1>게시글 등록</h1>
	<form method="Post" action="<%=request.getContextPath()%>/board/register">
		<div class="form-group">
			<input type="text" class="form-control" name="title" placeholder="제목">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="writer" value="${user.id}">
		</div>
		<textarea id="summernote" name="contents"></textarea>
		<button type="submit" class="btn btn-success">등록</button>
	</form>
</div>
<script>
	$(document).ready(function(){
		$('#summernote').summernote({
		  placeholder: 'Hello bootstrap 4',
		  tabsize: 2,
		  height: 100,
		  lang: 'ko-KR'
		});
	});
</script>
