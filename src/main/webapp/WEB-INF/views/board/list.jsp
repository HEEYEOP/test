<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div>
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
			        <td><a href="<%=request.getContextPath()%>/display?num=${board.num}">${board.title}</a></td>
			        <td>${board.writer}</td>
			        <td>${board.registered}</td>
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
</div>
