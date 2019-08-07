<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<html lang="en">

<head>
	<title>회원가입</title>
	<style>
	*{
		margin: 0;
		padding : 0;
	}
	.main{
		margin-top:50px;
	}
	.row{
		margin: 5px 0px;
	}
	.fab.fa-amazon{
		font-size: 100px;
		color: red;
	}
	</style>

	<script type="text/javascript">
		var isCheck = false;
		
		$(document).ready(function(){
			
			$('#signup').submit(function(){
				if(!isCheck){  //----------------------여기에 !붙는거 헷갈료
					alert('아이디 중복 체크를 해주세요')
					return false;
				}
			})	
			
			$('#dup').click(function(){
				var id = $('input[name=id]').val();
				
				$.ajax({
			        async:true, //비동기 
			        type:'POST',
			        data:id, // 요렇게도 쓸 수 있지 ===> data:{'id':id}
			        url:"<%=request.getContextPath()%>"+"/dup",
			        dataType:"json",
			        contentType:"application/json; charset=UTF-8",
			        success : function(data){
			            if(!data){
			            	alert('회원 가입이 가능한 아이디입니다');
			            	isCheck = true;     	
			            }else{
			            	alert('해당 아이디는 이미 존재합니다');
			            	isCheck = false;
			            }
			        }
			    });
			})
			$('input[name=id]').change(function(){
				isCheck = false;
			})
		});	
	</script>	

</head>
<body>
	<div>
		<div class="offset-4 col-4 border border-dark mt-5">
			<h1 class="text-center">회원가입</h1>
			<form method="post" action="" id="signup">
				<div class="row">
					<label class="col-4">아이디</label>
					<input name="id" type="text"class="form-control col-7" placeholder="아이디" >
				</div>
				<div class="row">
					<label id="id-error" class="offset-4 col-7 error p-0" for="id"></label>
				</div>
				<div>
					<button type="button" class="btn btn-outline-success offset-4 col-7" id="dup">중복 확인</button>
				</div>
				<div class="row">
					<label class="col-4">비밀번호</label>
					<input name="pw" type="password"class="form-control col-7" placeholder="비밀번호" id="pw" >
				</div>
				<div class="row">
					<label class="col-4">비밀번호확인</label>
					<input name="pw2" type="password"class="form-control col-7" placeholder="비밀번호확인">
				</div>
				<div class="row">
					<label class="col-4">성별</label>
					<div class="col-8">
						<label class="form-check-label col-5">
							<input name="gender" type="radio" class="form-check-input" value="M" checked >남성
						</label>
						<label class="form-check-label">
							<input name="gender" type="radio" class="form-check-input" value="F" >여성
						</label>
					</div>
				</div>
				<div class="row">
					<label class="col-4">이메일</label>
					<input name="email" type="email"class="form-control col-7" placeholder="이메일">
				</div>
				<div class="offset-8 col-3 clearfix p-0">
					<button class="btn btn-primary float-right">가입</button>
				</div>
			</form>
		</div>
	</div>

	

</body>

</html>
</html>
 