<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<head>

<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/home.css">


</head>

<body>
	
	<%
	/*
	*redirect unauthorized accesses to login page
	*/
		if (session.getAttribute("role") == null) {
			response.sendRedirect("Login.jsp");
		}
	%>



	<center>
		<h1 class='headerName'
			style="font-size: 100px; color: #0040ff; padding-top: 60px; font-family: serif;">Online
			Event Planning System</h1>
	</center>
	<br />

	<p style="font-size: 40px; color: purple;">
		<b><i>Welcome <%=session.getAttribute("role")%> ,</i></b></p>

	<ul>
		<li><a href="#">Home</a></li>
		<li><a href="#">Add New Events</a></li>
		<li><a href="#">My Events</a></li>
		<li><a href="#">Feedbacks</a></li>
		<li><a href="#">about us</a></li>
		<li><a href="LoginOut">Log Out</a></li>
		
		
		<div class="search">
			<input type="text" placeholder="Search.." name="search">
			<input type="submit" value="Search">
		</div>
	</ul>

	<!-- -->

	<div class="image-slide-show" style="width: 100%">
	
		<img class="mySlides" src="<%=request.getContextPath()%>/resources/images/image1.jpg"
			style="width: 100%; height: 800px"> 
		<img class="mySlides" src="<%=request.getContextPath()%>/resources/images/wedding1.jpg"
			style="width: 100%; height: 800px"> 
		<img class="mySlides" src="<%=request.getContextPath()%>/resources/images/event10.jpg"
			style="width: 100%; height: 800px">
	    <img class="mySlides" src="<%=request.getContextPath()%>/resources/images/event9.jpg"
			style="width: 100%; height: 800px">
	</div>







	<h1 id="about">About Us</h1>
	
	<center>
		<hr class="hr">
	</center>

	<p id="info">This site will provide you with the tools and most of
		all the resources to make your event much more amazing and
		wonderful.Also this site suit for many users such as
		students,Teachers,lectureres,researches so on.... We are confident
		that you will get more than what you looking for using this site.Our
		main goal is to provide best event planning to this modern day</p>
	<center>
		<hr class="hr">
	</center>

	<img class="main" src="<%=request.getContextPath()%>/resources/images/image2.jpg" alt="">
	
	<hr class="hrd">
	<h1 id="event">Previous Events</h1>
	
	<center>
		<hr id="middle">
	</center>
	
	<center>
		<video id="video" width="720" height="440" controls>
			<source src="<%=request.getContextPath()%>/resources/video/trailer.mp4" type="video/mp4">
	
		</video>
	</center>
	
	<hr class="hrd">
	<h1 id="about">Join Us</h1>
	
	<center>
		<hr class="hr">
	</center>
	
	<p id="info">If you are truly interest in our community and looking
		to make changes to this society then please send your details to
		us.Also you can find us or follow us through social media,then we can
		provide updates about our site</p>
		
	<center>
		<hr class="hr">
	</center>

	<footer id="footer">
		<div class="connect">
			<p id="main_para">Connect with us</p>
			<a href="https://www.facebook.com">
				<img src="<%=request.getContextPath()%>/resources/images/facebook.png"
				id="facebook"></a> 
				
			<a href="https://twitter.com">
				<img src="<%=request.getContextPath()%>/resources/images/twitter.png"
				id="twitter"></a> 
			
			<a href="https://www.instagram.com"><img
				src="<%=request.getContextPath()%>/resources/images/instergram.png"
				id="instergram"></a> 
				
			<a href="https://mail.google.com"><img
				src="<%=request.getContextPath()%>/resources/images/email.png"
				id="email"></a>
				
			</p>
		</div>
		
		<p id="thank">Thank you for your interest in Online Event Planning
			System.</p>
			
		<p id="copyright">Copyright 2019. All rights reserved.</p>
		
	</footer>
	
</body>
<script src="<%=request.getContextPath() %>/resources/js/home.js"></script>

</html>
