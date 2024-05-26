<%@page import="cn.techtutorial.model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>E-Commerce Cart</title>
<a href="login.jsp"></a>
<style>
    .container{
        width: 100%;
        height:100%;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    .login{
        width: 350px;
        height: 350px;
        margin: auto 0;
        background-color: transparent;
        border: 1px solid black;
        border-radius: 10px;
        padding: 20px;
    }
    .form-group{
        
        display: flex;
        flex-direction: column;
        gap:5px;
    }
    .form-group input{
        padding: 5px 10px;
    }
    .title{
        text-align: center;
    }
    .btn_c{
        width: 100%;
        display: flex;
        justify-content: center;
    }
    .btn{
        width: 80px;
        margin-top: 30px;
        padding:5px 10px;
        border-radius: 10px;
        
    }
</style>
</head>
<body>
	

	<div class="container">
		<div class="login w-50 mx-auto my-5">
			<h1 class="title text-center">User Login</h1>
			<div class="card-body">
				<form action="AuthServlet" method="post">
					<div class="form-group">
						<h4>Email address</h4> 
						<input type="email" name="email" class="form-control" placeholder="Enter email">
					</div>
					<div class="form-group">
						<h4>Password</h4> 
						<input type="password" name="password" class="form-control" placeholder="Password">
					</div>
					<div class="btn_c">
						<button  type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>