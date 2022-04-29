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
//--------------------------------view---------------------------------------------------------------------
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
	
//--------------------------------------Insert-----------------------------------------------------------	
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
//-------------------------------------Update-----------------------------------------------------------	
	void update()
	{
		try
		{
			int status=0;
			String query="update employee set Employee_name=?,Salary=? where employee_id=?";
			PreparedStatement ps=getconnection().prepareStatement(query);
			ps.setString(1, "Ganesh");
			ps.setInt(2, 39000);
			ps.setInt(3,308);
			status=ps.executeUpdate();
			
			if(status>0)
			{
				System.out.println("Updated Successfully");
			}else {System.out.println("Failed to update");}
			
		}catch(Exception e) {System.out.println(e);}
	}
//----------------------------------Delete------------------------------------------------------------------
		
		void delete()
		{
			try
			{
				int status=0;
			String query="delete from employee where Employee_id=?";
			PreparedStatement ps=getconnection().prepareStatement(query);
			ps.setInt(1, 308);
			status=ps.executeUpdate();
			if(status>0)
			{
				System.out.println("Deleted Successfully");
			}
			else {System.out.println("Failed to delete");}
			}catch(Exception e) {System.out.println(e);}
		}
}
public class Crud {

	public static void main(String[] args) {
		JDBC j=new JDBC();
		j.delete();


	}

}
