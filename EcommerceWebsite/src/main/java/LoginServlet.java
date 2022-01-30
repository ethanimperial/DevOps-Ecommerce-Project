

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
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
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out = response.getWriter();
		
		
		/*
		 * try { Class.forName("com.mysql.jdbc.Driver"); Connection con =
		 * DriverManager.getConnection( "jdbc:mysql://localhost:3306/ecommerceproject",
		 * "root", "password");
		 * 
		 * Statement stm = con.createStatement(); ResultSet rs =
		 * stm.executeQuery("select * from userdetails where username='"
		 * +username+"' and password ='"+password+"'" ); if(rs.next()) {
		 * response.sendRedirect("ProductDetailsServlet/dashboard"); }else {
		 * out.println("Wrong username or password..."); }
		 * 
		 * }catch(Exception e) { System.out.println(e.getMessage()); }
		 */
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		RegisterServlet db = new RegisterServlet(ConnectionPro.getConnection());
		User user = db.logUser(username, password);
		if(user !=null) {
			HttpSession session = request.getSession();
			session.setAttribute("logUser", user);
			response.sendRedirect("ProductDetailsServlet/dashboard");
		}else {
			out.print("user not found");
		}
	}

}
