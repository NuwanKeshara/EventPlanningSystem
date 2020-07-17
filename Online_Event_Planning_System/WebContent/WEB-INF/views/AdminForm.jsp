
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html lang="en">

<head>

	<title>Login V18</title>
	
	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link rel="icon" type="image/png" href="<%=request.getContextPath() %>/resources/images/icons/favicon.ico"/>

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">

	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/util.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/main.css">

	

</head>

<body>
	
	
	
	<div class="limiter">
	
		<div class="container-login100">
		
			<div class="wrap-login100">
			
				<span class="container-login100-form-btn" >
						<a href="home.jsp" style="float:left; font-size:36px; color:puple"><b><< Home</b></a>
				</span>
			
				<form class="login100-form validate-form" action="AddAdmin" method='POST'>
				
					<span class="login100-form-title p-b-43">Admin Details</span>
					
				<form >
					
					<span style="padiing-left:20px">First Name :</span>
					
					<div class="wrap-input100 validate-input">
						
						<input class="input100" type="text" name="firstName" value="" required>
						
						<span class="focus-input100"></span>
						
						
					</div>
					
					<br/>
					<span style="padiing-left:20px">Last Name :</span>
					
					<div class="wrap-input100 validate-input">
					
						<input class="input100" type="text" name="lastName" value=""  required>
						
						<span class="focus-input100"></span>
						
					</div>
					
					<br/>
					
					<span style="padiing-left:20px">Contact :</span>
					
					<div class="wrap-input100 validate-input" >
					
						<input class="input100" type="text" name="contact" value="" 
						pattern="[0][0-9]{9}" title='Should be a valid phone number' required>
						
						<span class="focus-input100"></span>
						
					</div>
					
					<br/>
					
					<span style="padiing-left:20px">Address :</span>
					
					<div class="wrap-input100 validate-input" >
					
						<input class="input100" type="text" name="address" value="" required>
						
						<span class="focus-input100"></span>
						
					</div>
					
					<br/>
					
					<span style="padiing-left:20px">User Name :</span>
					
					<div class="wrap-input100 validate-input" >
					
						<input class="input100" id="userName" type="text" name="userName" value="" 
						pattern='(?=.*[A-Za-z]).{6,}'
						title='At least one letter and 6 or more characters'required>
						
						<span class="focus-input100"></span>
						
					</div>
					
					<p id='result' style='color:red'></p>
					
					
					<br/>
					
					<span style="padiing-left:20px">Password :</span>
					
					<div class="wrap-input100 validate-input" >
					
						<input class="input100" type="text" name="password" value=""
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
						title="Must contain at least one  number and one uppercase and lowercase letter,and at least 6 or more characters" required>
					
						<span class="focus-input100"></span>
						
					</div>
					
					
					<div class="container-login100-form-btn">
					
						<button class="login100-form-btn" name="newAdmin" value="">ADD</button>
					
					</div>
					
					<br/>
					
					
			</form>
					

					
			</form>

			<div class="login100-more" style="background-image: url('<%=request.getContextPath() %>/resources/images/admin.jpg')">
			</div>
				
	
	
	
	

	
	
	<script src="<%=request.getContextPath() %>/resources/js/registration.js"></script>
	<script src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>

	<script src="<%=request.getContextPath() %>/resources/bootstrap/js/popper.js"></script>
	<script src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap.min.js"></script>

	<script src="<%=request.getContextPath() %>/resources/js/main.js"></script>

</body>
</html>