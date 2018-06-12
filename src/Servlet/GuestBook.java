package Servlet;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.GuestBookEntry;

@WebServlet("/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestBook() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e)
		{
			throw new ServletException(e);
		}
	}
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<GuestBookEntry> entries = new ArrayList<GuestBookEntry>();
		
		Connection c = null;
		try
		{
			String url = "jdbc:mysql://localhost/guestbook";
			String username = "minhthong8197";
			String password = "1111";
			
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			
			//Thực thi câu truy vấn
			ResultSet rs = stmt.executeQuery("SELECT * FROM guestbook.guestbook;");
			
			//xử lý kết quả
			while(rs.next()) 
			{
				GuestBookEntry entry = new GuestBookEntry(
				rs.getInt("ID"),
				rs.getString("Name"),
				rs.getString("Message")
				);
				entries.add(entry);
			}
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
		
		request.setAttribute("newentries", entries);
		request.getRequestDispatcher("GuestBook.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
