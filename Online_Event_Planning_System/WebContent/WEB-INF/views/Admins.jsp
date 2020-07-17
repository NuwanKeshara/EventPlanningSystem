<%@page import="java.util.ArrayList"%>
<%@page import="com.oeps.model.Admin"%>
<%@page import="com.oeps.service.AdminRelative"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html>

<head>

	<meta charset="ISO-8859-1">
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
	<title>Admins</title>

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-grid.min.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap-reboot.min.css">
	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/clients.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/css/admins.css">
	<!--imprtant button disable-->
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.disable.css">

</head>


<body>

	<h1 class="h1-text1"><b><<</b><a href="home.jsp" class="a-text1"><b>Home Page</b></a></h1>
	
	<h1 class="h1-text2">
		<b><</b><a href="AddAdmin" class="a-text2"><b>Add New Admin</b></a></h1>


	<br/>

	<br/>

	<br/>

	<center>
		<h2><strong>ADMINS</strong></h2>
	</center>
	
	<center>

		<table class="table table-dark table-responsive table-hover" style="width: 90% !important;">


			<thead>
			
				<tr>
				
					<th id="hash">#</th>
					<th style="width: 240px !important;"><i>First Name</i></th>
					<th style="width: 240px !important;"><i>Last  Name</i></th>
					<th style="width: 240px !important;"><i>Contact No</i></th>
					<th style="width: 240px !important;"><i>Address</i></th>
					<th style="width: 240px !important;"><i>UserName</i></th>
					<th style="width: 240px !important;"></th>
					<th style="width: 240px !important;"></th>
					
				</tr>

			</thead>

			<%
				int count = 1;

				AdminRelative rel = new AdminRelative();
				ArrayList<Admin> adminList = rel.ViewAdmins();
				

				for (Admin user : adminList) {
			%>
			
			<tbody>
			
				<tr>
				
					<td><b> <%=count%></b></td>
					<td><b> <%=user.getFirstName()%></b></td>
					<td><b> <%=user.getLastName()%></b></td>
					<td><b> <%=user.getContact()%></b></td>
					<td><b> <%=user.getAddress()%></b></td>
					<td><b> <%=user.getUserName()%></b></td>

					<%
						if (session.getAttribute("role").equals(user.getUserName())) {
					%>
					
					<td>
						<form method="POST" action="UpdateAdmin">

							<input type="submit" value="Update Details"
								class="btn btn-primary btn-change7"
								id="hidden"/> 
								
							<input type="hidden" name="AdminID" value="<%=user.getAdminID()%>" />

						</form>
					</td>

					<%
						} else {
					%>
					
					<td>
						<input type="submit" value="Update Details"class="btn btn-primary disabled" />
					</td>

					<%
						}
					%>

					<td>

						<form method="POST" action="DeleteAdmin">

							<input type="submit" value="Delete Admin"
								class="btn btn-primary btn-change7"
								id="hidden"/> 
								
							<input type="hidden" name="AdminID" value="<%=user.getAdminID()%>"/>

						</form>
					</td>
					
				</tr>
				
			</tbody>

			<%
				count++;
				}
			%>
			
		</table>

	</center>



</body>

<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/bootstrap/js/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>

</html>
