
<%@page import="ec.ecommerce.connection.DbCon"%>
<%@page import="ec.ecommerce.model.*"%>
<%@page import="ec.ecommerce.dao.*"%>
<%@page import="java.util.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%
User auth = (User) request.getSession().getAttribute("auth");
if (auth != null) {
    request.setAttribute("auth", auth);
}

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	
	request.setAttribute("cart_list", cart_list);
}

ProductDao pd = new ProductDao(DbCon.getConnection());
List<Product> products = pd.getAllProducts();


%>
   

<!DOCTYPE html>
<html>
<head>
<%@include file="/includes/head.jsp"%>
	
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="/includes/navbar.jsp"%>
<%@include file="/includes/footer.jsp"%>

<div class="container">
		<div class="card-header my-3">All Products</div>
		<div class="row">
		
		<% if( !products.isEmpty()){
			for(Product p:products){	%>
				
				<div class="col-md-3 my-3">
			<div class="card w-100" style="width: 18rem;">
			<img class="card-img-top" src=<%= p.getImage() %> alt="">
			<div class="card-body">
				<h5 class="card-title"><%= p.getName() %></h5>
				<h6 class="price"><%= p.getPrice() %></h6>
				<h6 class="category"><%= p.getCategory() %></h6>
				<div class="mt-3 d-flex justify-content-between">
					<a class="btn btn-dark" href="AddToCartServlet?id=<%= p.getId() %>">Add to Cart</a> <a
						class="btn btn-primary" href=>Buy Now</a>
				</div>
			</div>
		</div>
		
	</div>
				
			<%}
		} %>
		
		
			
		</div>
	</div>



</body>
</html>