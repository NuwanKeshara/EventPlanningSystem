<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<html>

<head>

	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<title>Login</title>

	<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/login.css">

  
</head>

<body>

	<form action="Home" method="post">


		<div class="login-box">
		
			<h1>Login</h1>
			
			<div class="textbox">
				<input type="text" name="userName" id="userId" placeholder="Username" value="" required>
			</div>
			
			
			<div class="textbox">
				<input type="password" name="password" id="pwd" placeholder="Password" value="" required>
			</div>
			
			
			<div>
				<span style="color: red"><%=(request.getAttribute("role") == null) ? "" : (String)request.getAttribute("role")%></span>
			</div>
			
			
			<br/>
			<br/> 
			
			
			<input class="btn" type="submit" name="user" value="Sign in">

			<input class="btn" type="submit" name="admin"
				value="Log in as a admin"> <a href='Registration.jsp'>
				
			<button class="btn" type="button">Not a Member</button></a>

		</div>
		
	</form>
	
</body>

</html>
