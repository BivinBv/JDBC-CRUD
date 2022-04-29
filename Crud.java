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
	
	void insert()
	{
		try
		{
		int status=0;
	    String query="insert into employee(Employee_id,Employee_name,manager_id,Salary,project_id)"
				+ "values(?,?,?,?,?)";
	    PreparedStatement ps=getconnection().prepareStatement(query);
	    ps.setInt(1, 308);
	    ps.setString(2, "Varun");
	    ps.setInt(3,305);
	    ps.setInt(4, 38000);
	    ps.setString(5, "33D");
	    status=ps.executeUpdate();
	    if(status>0)
	    {
	    	System.out.println("Updated successfully");
	    }
	    else
	    {
	    	System.out.println("Failed to update");
	    }
		}
		catch(Exception e) {System.out.println(e);}
	
	}
}
public class Crud {

	public static void main(String[] args) {
		JDBC j=new JDBC();
		j.insert();

	}

}
