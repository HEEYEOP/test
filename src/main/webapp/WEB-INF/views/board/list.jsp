<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<head>
	<style>
		.page-item .fas{
			font-size:20px;
		}
	</style>
</head>
    
<div style="min-height:561px;">
	<div>
		<form action="<%=request.getContextPath()%>/board/list" method="get" class="row mb-2 mt-2">
			<div class="form-group col-2 mb-0">
			  <select class="form-control" name="type">
			    <option value="0" <c:if test="${pageMaker.criteria.type == 0 }">selected</c:if>>선택</option>
			    <option value="1" <c:if test="${pageMaker.criteria.type == 1 }">selected</c:if>>제목</option>
			    <option value="2" <c:if test="${pageMaker.criteria.type == 2 }">selected</c:if>>작성자</option>
			    <option value="3" <c:if test="${pageMaker.criteria.type == 3 }">selected</c:if>>내용</option>
			  </select>
			</div>
			<div class="form-group col-4 mb-0">
			  <input type="text" class="form-control" name="search" value="${pageMaker.criteria.search}">
			</div>
			<button type="submit" class="btn btn-success">검색</button>
		</form>
	</div>
	<table class="table table-hover">
	    <thead>
	      <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	      	<th>작성일</th>
	      	<th>조회수</th>
	      </tr>
	    </thead>
	    <tbody>
	     <c:if test="${list.size() ne 0 }">
		     <c:forEach var="board" items="${list}">
			     <tr>
			        <td>${board.num}</td>
			        <td><a href="<%=request.getContextPath()%>/board/display?num=${board.num}&page=${pageMaker.criteria.page}&type=${pageMaker.criteria.type}&search=${pageMaker.criteria.search}">${board.title}</a></td>
			        <td>${board.writer}</td>
			        <td>${board.registeredUntilDay}</td>
			        <td>${board.views}</td>
			     </tr>
		     </c:forEach>
	     </c:if>
	     <c:if test="${list.size() eq 0 }">
		     <tr>
		        <td colspan="5" class="">게시글이 존재하지 않습니다</td>
		     </tr>
	     </c:if>
	    </tbody>
	</table>
	
	<ul class="pagination" style="justify-content: center;">
	    <c:if test="${pageMaker.prev}">
	        <li class="page-item">
	            <a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pageMaker.startPage-1}&type=${pageMaker.criteria.type}&search=${pageMaker.criteria.search}"><i class="fas fa-chevron-left"></i></a>
	        </li>
	    </c:if>
	    <c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage}" var="index">
	        <c:choose>
		        <c:when test="${pageMaker.criteria.page != index}">
			        <li class="page-item">
			            <a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&type=${pageMaker.criteria.type}&search=${pageMaker.criteria.search}">${index}</a>
			        </li>
		        </c:when>
		        <c:otherwise>
			        <li class="page-item active">
			            <a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${index}&type=${pageMaker.criteria.type}&search=${pageMaker.criteria.search}">${index}</a>
			        </li>
		        </c:otherwise>
	        </c:choose>
	    </c:forEach>
	    <c:if test="${pageMaker.next}">
	        <li class="page-item">
	            <a class="page-link" href="<%=request.getContextPath()%>/board/list?page=${pageMaker.endPage+1}&type=${pageMaker.criteria.type}&search=${pageMaker.criteria.search}"><i class="fas fa-chevron-right"></i></a>
	        </li>
	    </c:if>
	</ul>
	<c:if test="${user ne null}">
		<div>
			<a href="<%=request.getContextPath()%>/board/delete"><button class="btn btn-success">등록</button></a>
		</div>
	</c:if>
	
	
</div>
