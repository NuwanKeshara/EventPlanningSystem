<%@page import="java.util.ArrayList"%>
<%@page import="com.oeps.model.User"%>
<%@page import="com.oeps.service.ClientRelative"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    

<html>
<head>

	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<title>Client List</title>

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/clients.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/users.css">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap-grid.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/bootstrap/css/bootstrap-reboot.min.css">
	
	<!--important (button disable)-->
	<!--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">-->

</head>

<body>

<h1><b style="color:white;font-size:60px;"><<</b><a style="text-decoration:none;color:white;" href="home.jsp"><b>Home Page</b></a></h1>

<br/> 
<br/>  
<br/>

		<center>
			<h2 style="color:white;font-size:45;"><strong>CLIENTS</strong></h2>
		</center>
		

	  <center>
	  
		<table class="table table-hover table-responsivee" style="width: 90% !important;">
		
		 
		  <thead>
		  
		 	 <tr class="table-primary">
		  
		  		<th id="hash"># </th>
                <th>First Name </th>
                <th>Last Name</th>
                <th>Contact No</th>
                <th style="text-align:center !important">E-mail</th>
                <th>UserName</th>
				<th></th>
				
                
           	 </tr>
            
           </thead>
            
            <%
            
            String [] list = {"table-secondary" , "table-success" , "table-danger" , "table-warning" , "table-info"};
            
            ClientRelative rel = new ClientRelative();
            ArrayList<User> clientList = rel.ViewUsers();
			
			int count = 0;
			int no = 1;
			
			for(User user : clientList){
			
			if(count > 4){
				count = 0;
			}
			
			%>
			
			<tbody>
			
			  <tr class="<%= list[count] %>">
			 
			    <td><b> <%= no %> </b></td>
				<td><b> <%= user.getFirstName() %> </b></td>
				<td><b> <%= user.getLastName() %> </b></td>
				<td><b> <%= user.getContact() %> </b></td>
				<td><b> <%= user.getEmail() %> </b></td>
				<td><b> <%= user.getUserName() %> </b></td>
				
				<td> 
				
				
						<form method = "POST" action = "DeleteClient">
				
				
				 		<input type="submit" value= "Delete Client" class="btn btn-primary btn-change7" />
					    <input type="hidden" name="ClientID" value="<%=user.getClientID()%>"/>  
				 
						</form>
				 
				</td>	
				 
			  </tr>
			  
			</tbody>
						
			<%	
			
			count++;
			no++;
			   }
			
            %>   
              
		</table>
		
	</center>

</body>

	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/resources/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/bootstrap/js/jquery.min.js"></script>
	<script src="<%=request.getContextPath() %>/resources/js/jquery.js"></script>
	
</html>
