<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	
</head>
    
<div style="min-height:561px;">
	<h1>게시글 수정</h1>
	<form method="Post" action="<%=request.getContextPath()%>/board/modify" enctype="multipart/form-data">
		<input type="hidden" value="${board.num}" name="num">
		<div class="form-group">
			<input type="text" class="form-control" name="title" value="${board.title}">
		</div>
		<div class="form-group">
			<input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
		</div>
		<textarea id="summernote" name="contents">${board.contents}</textarea>
		<div class="form-group">
		<label>첨부파일</label>
			<c:if test="${board.fileName ne '' }">
				<a id="fileLink" href="<%=request.getContextPath()%>/board/download?fileName=${board.file}">${board.fileName}</a>
				<input type="hidden" name="file" value="${board.file}">
				<i class="fas fa-times close"></i>
			</c:if>
			<c:if test="${board.fileName eq '' }">
				없음
			</c:if>
		</div>
		<input type="file" class="form-control-file border" name="file2">
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
		})
		
		$('.close').click(function(){
			$('#fileLink').remove();
			$('input[name=file]').val('');
			$(this).css('display','none');
		})
	});
</script>
