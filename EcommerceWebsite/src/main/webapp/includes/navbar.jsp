<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container">
		<a class="navbar-brand" href="index.jsp">E-Commerce Cart</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/EcommerceWebsite/index.jsp">Home</a></li>
			
				
			<%
			if(auth != null){%>
				
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/EcommerceWebsite/ProductDetailsServlet/dashboard">Admin</a></li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/EcommerceWebsite/cart.jsp">Cart <span class="badge badge-danger">${cart_list.size()}</span> </a></li>
				<li class="nav-item"><a class="nav-link" href="http://localhost:8080/EcommerceWebsite/LogoutServlet">Logout</a></li>
				
				
			<%}else{%>
				<li class="nav-item"><a class="nav-link" href="Register.jsp">Register</a></li>
				
			<%}
			%>
			</ul>
		</div>
	</div>
</nav>

