<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
	<div class="container">
	  	<a class="navbar-brand" href="<%=request.getContextPath()%>/">Navbar</a>
	  	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
	    	<span class="navbar-toggler-icon"></span>
	  	</button>
	  	<div class="collapse navbar-collapse" id="collapsibleNavbar">
	    	<ul class="navbar-nav">
		      	<li class="nav-item">
		        	<a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a>
		      	</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="#">Link</a>
		      	</li>
		      	<li class="nav-item">
		        	<a class="nav-link" href="#">Link</a>
		      	</li>    
	    	</ul>
		</div> 
		<c:if test="${user ne null}">
			<a href="<%=request.getContextPath()%>/signout" class="float-right">로그아웃</a>
		</c:if>
	</div> 
	
</nav>