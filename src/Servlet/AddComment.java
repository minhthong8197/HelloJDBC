package Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/AddComment")
public class AddComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddComment() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//lay thong tin nhap vao
    	String Name = request.getParameter("name");
    	String Message = request.getParameter("message");
    	
    	Connection c = null;
		try
		{
			String url = "jdbc:mysql://localhost/guestbook";
			String username = "minhthong8197";
			String password = "1111";
			
			String sql = "insert into guestbook (name,message) values (?,?)";
			
			c = DriverManager.getConnection(url, username, password);
			PreparedStatement pstmt = c.prepareStatement(sql);
			pstmt.setString(1, Name);
			pstmt.setString(2, Message);
			
			//Thực thi câu lenh
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			throw new ServletException(e);
		}
		finally
		{
			//đóng connection
			try
			{
				if(c != null) c.close();
			}
			catch(SQLException e)
			{
				throw new ServletException(e);
			}
		}
		
		request.getRequestDispatcher("/GuestBook").forward(request, response);
	}

}
