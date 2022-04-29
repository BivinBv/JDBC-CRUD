package jdbccrud;
import java.sql.*;
class JDBC
{
	public static Connection getconnection() throws Exception 
	{
		Connection con=null;
		String url="jdbc:mysql://localhost:3306/companydlts";
		String uname="root";
		String pass="root";
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,uname,pass);
		return con;
	}
}
public class Crud {

	public static void main(String[] args) {
		

	}

}
