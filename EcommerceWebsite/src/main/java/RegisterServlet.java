


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.ecommerce.connection.*;
import ec.ecommerce.model.*;
;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	public RegisterServlet(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String n = request.getParameter("username");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		String c = request.getParameter("phonenumber");
		
		try {
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection(
		 "jdbc:mysql://localhost:3306/ecommerceproject", "root", "password");
	
		 PreparedStatement ps = con.prepareStatement("insert into USERDETAILS (username,password,email,phonenumber) values (?,?,?,?)");
		
		 ps.setString(1, n);
		 ps.setString(2, p);
		 ps.setString(3, e);
		 ps.setString(4, c);
		
		 int i = ps.executeUpdate();
		 
		 if (i > 0){
			  response.sendRedirect("Login.jsp");
			 }
			 }
			 
			 catch (Exception exception) {
			  System.out.println(exception);
			  out.close();
			 }
		
		
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public User logUser(String username, String password) {
		User user = null;
		try {
			
			 Class.forName("com.mysql.jdbc.Driver");
			 Connection con = DriverManager.getConnection(
			 "jdbc:mysql://localhost:3306/ecommerceproject", "root", "password");
		
			PreparedStatement pst = con.prepareStatement("select * from USERDETAILS where username=? and password=?");
			
		
			pst.setString(1, username);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setName("username");
				user.setEmail("email");
				user.setPassword("password");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

}
