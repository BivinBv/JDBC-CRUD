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
	void view()
	{
		try
		{
		String query="select * from employee";
		Statement st=getconnection().createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next())
		{
			int empid=rs.getInt("Employee_id");
			String empname=rs.getString("Employee_name");
			int managerid=rs.getInt("manager_id");
			String projectid=rs.getString("project_id");
			System.out.println(empid+"  "+empname+"  "+managerid+"  "+projectid);
		}
		}catch(Exception e){System.out.println(e);}
	}
	
}
public class Crud {

	public static void main(String[] args) {
		JDBC j=new JDBC();
		j.view();

	}

}
