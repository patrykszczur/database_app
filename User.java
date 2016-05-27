import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User {

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
	
	public Connection showUser() throws Exception {
		try {
			
			Connection conn = (Connection) getConnection() ;
			String query = "SELECT * FROM user" ;
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("idUser "+ " | " + "Name "+ " | " + "Surname "+ " | " + "Password "+ " | " + "Sex " + " | "+ "Mail "+ " | " +  "Address "+ " | " + "phone_number");
			while (rs.next()){
				System.out.println(rs.getString("idUser") + "  |  " + rs.getString("Name") + "  |  " + rs.getString("Surname")+ "  |  " + rs.getString("Password")+ "  |  " +  rs.getString("Sex")+ "  |  " + rs.getString("Mail")+ "   |   " + rs.getString("Address")+ "   |   " + rs.getString("Phone_Number"));
			}
		}catch (Exception e){
			System.out.println(e); 
		}
			finally{
				System.out.println("\nsuccess");
			};
		
		return null ; 
		
	}

	public void insertUser (String Name , String Surname , String Password , int Sex , String Mail , String Address  , String phone_number ) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement insertStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO user (Name,Surname,Password,Sex,Mail,Address , phone_number ) VALUES (?,?,?,?,?,?,?)");
			insertStatement.setString(1, Name);
			insertStatement.setString(2, Surname );
			insertStatement.setString(3, Password);
			insertStatement.setInt(4, Sex);
			insertStatement.setString(5, Mail);
			insertStatement.setString(6 ,Address);
			insertStatement.setString(7 ,phone_number);
			insertStatement.execute();
			insertStatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
	
	public void deleteUser (String Name , String Surname ) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement deleteEmployeeStatement = (PreparedStatement) conn.prepareStatement("DELETE FROM user WHERE Name = ? AND Surname = ?");
			deleteEmployeeStatement.setString(1, Name);
			deleteEmployeeStatement.setString(2, Surname );
			deleteEmployeeStatement.execute();
			deleteEmployeeStatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
}