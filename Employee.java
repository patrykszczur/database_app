import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Employee {

	public static  java.sql.Connection getConnection() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "1234");
			return conn ;
		
		}catch (Exception e){
			System.out.println(e); 	
		}
		return null ; 
		
		}
	
	public Connection showEmployee() throws Exception {
		try {
			
			java.sql.Connection conn = getConnection() ;
			String query = "SELECT * FROM employee " ;
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("idEmployee "+ " | " + "First_Name "+ " | " + "Last_Name "+ " | " + "Password "+ " | " + "Sex "+ " | " + "Mail "+ " | " + "Employee_idEmployee");
			while (rs.next()){
				System.out.println(rs.getString("idEmployee") + "  |  " + rs.getString("First_Name") + "  |  " + rs.getString("Last_Name")+ "  |  " + rs.getString("Password")+ "  |  " +  rs.getString("Sex")+ "  |  " + rs.getString("Mail")+ "  |  " + rs.getString("Employee_idEmployee"));
			}
		}catch (Exception e){
			System.out.println(e); 
		}
			finally{
				System.out.println("\nsuccess");
			};
		
		return null ; 
		
	}
	
	public void insertEmployee(String First_Name , String Last_Name , String Password , int Sex , String Mail , int Employee_idEmployee ) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement insertStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO employee (First_Name,Last_Name,Password,Sex,Mail,Employee_idEmployee) VALUES (?,?,?,?,?,?)");
			insertStatement.setString(1, First_Name);
			insertStatement.setString(2, Last_Name );
			insertStatement.setString(3, Password);
			insertStatement.setInt(4, Sex);
			insertStatement.setString(5, Mail);
			insertStatement.setInt(6 ,Employee_idEmployee);
			insertStatement.execute();
			insertStatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
	
	public void deleteEmployee(String First_Name , String Last_Name ) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement deleteEmployeeStatement = (PreparedStatement) conn.prepareStatement("DELETE FROM employee WHERE First_Name = ? AND Last_Name = ?");
			deleteEmployeeStatement.setString(1, First_Name);
			deleteEmployeeStatement.setString(2, Last_Name );
			deleteEmployeeStatement.execute();
			deleteEmployeeStatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
}
