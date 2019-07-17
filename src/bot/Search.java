package bot;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

public class Search extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		Connection con = null;

		String servername = "desktop-r954n2s";
		String port = "1521";
		String sid = "xe";
		String url = "jdbc:oracle:thin:@"+servername+":"+port+":"+sid;
		String user = "SYSTEM";
		String pwd = "tiger";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String dbName = "NEWS";
		Statement st;
		ArrayList<News> list = new ArrayList<News>();

		String message = request.getParameter("msg");
		//Command Check
		int firstIndex = message.indexOf(' ');
		String command = message.substring(0,firstIndex);
		String condition="";
		switch(command) {
			case "!category":
				condition = "topic ='"+message.substring(firstIndex+1)+"'";
				break;
			case "!date":
				condition = "date ='"+message.substring(firstIndex+1)+"'";
				break;
			case "!headline":
				condition = "headline ='"+message.substring(firstIndex+1)+"'";
				break;
			case "!publisher":
				condition = "source ='"+message.substring(firstIndex+1)+"'";
				break;
			default:
				condition="-1";
				out.println(command);
		}


		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("Connected");


			if(!condition.equals("-1")) {
				String query = "select * from news where "+condition;

				st = con.createStatement();
				ResultSet rs = st.executeQuery(query);


				while(rs.next()) {
					list.add(new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6)));
				}

				request.setAttribute("nList",list);
				RequestDispatcher view = request.getRequestDispatcher("../index.jsp");
				view.forward(request, response);
				con.close();
			}
			else {
				out.println(condition);
			}


		}
		catch(Exception e){
			out.println(e);
		};
	}
}
