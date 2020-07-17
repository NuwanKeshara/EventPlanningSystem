<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	

<html>

<head>

	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Registration</title>

	<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/resources/css/registration.css">
	


</head>

<body>

	<center>

		<div id="registerform">
		
			<center>
			
				<h5>Sign up now</h5>
				
				<form action='home' method="POST">

					<input class='txtbx1' type='text' name='firstName'
						placeholder='first name' value='' required> <br> <br>
						
						
					<input class='txtbx1' type='text' name='lastName'
						placeholder='lastname' value='' required> <br> <br>
						
						
					<input class='txtbx1' type='tel' name='contact'
						placeholder='contact no' value='' pattern="[0][0-9]{9}" title='Should be 
						a valid phone number'required>
					
					<br> <br> 
					
					
					<input class='txtbx1' type='email' name='email'
						placeholder='email'
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" required><br>

					<p style='font-size: 12px'>Ex : abc@gmail.com</p>	
							
					<br/> <br>  
					
					<input class='txtbx1' id='userName' type='text'
						name='userName' placeholder='user Name' pattern='(?=.*[A-Za-z]).{6,}'
						title='At least one letter and 6 or more characters' required>
						
                    <p id='result'></p>
					

					<br><br><br> 
					
					<input id='password'  class='txtbx1' type='password' name='password'
						placeholder='password' value=''
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}"
						title="Must contain at least one  number and one uppercase and lowercase letter, and at least 6 or more characters"
						required>
						
						
					<p style="font-size: 12px;">(Must contain at least one number
						and one uppercase and lowercase letter, and at least 6 or more
						characters)</p>
					
					<br/>
					<br/> <br/>
					
					
					<input class='txtbx1' id='confirm_password' type='password'
						placeholder='re-enter password' required> <br>

							
					<p id="message"></p><br/><br/>
					
					
					
					<p>
						<input type="checkbox" name="checkbox" required>  I agree to <a
							href=''> terms and conditions </a>
					</p>
					
					<br> 
					
					
					<input id='btn' type='submit' value='register'><br>

					<a href='Login.jsp'>Already have an account </a> 
					
					</br> </br> 
					
					
					<a href='TempHome.jsp'>Back to home page </a> <br>
					
				</form>
			
			</center>
		
		</div>
	
	</center>
	
	
	
</body>

<script src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/registration.js"></script>

</html>