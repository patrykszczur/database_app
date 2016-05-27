import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Message {

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

	public Connection showMessageAndHeander() throws Exception {
		try {
			
			Connection conn = (Connection) getConnection() ;
			String query = "SELECT * FROM message JOIN header " ;
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery(query);
			System.out.println("id "+ "| " + "content of the message"+ " | "+ "Subject ");
			while (rs1.next()){
				System.out.println(rs1.getString("idMessage") + "  |  " + rs1.getString("Description") +  "  |  " + rs1.getString("Subject"));
			}
		}catch (Exception e){
			System.out.println(e); 
		}
			finally{
				System.out.println("\nsuccess");
			};
		
		return null ; 
		
	}
	public void insertMessage(String Description , int Header_idHeader ) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement insertStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO message (Description,Header_idHeader) VALUES (?,?)");
			insertStatement.setString(1, Description);
			insertStatement.setInt(2, Header_idHeader );
			insertStatement.execute();
			insertStatement.close(); 
			conn.close() ; 
			
			System.out.println("\nsuccess");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
	
	public void deleteMessage(String idMessage) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement deleteEmployeeStatement = (PreparedStatement) conn.prepareStatement("DELETE FROM message WHERE idMessage = ?");
			deleteEmployeeStatement.setString(1, idMessage);
			deleteEmployeeStatement.execute();
			deleteEmployeeStatement.close(); 
			conn.close() ; 
			
			System.out.println("\nsuccess");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}

}
