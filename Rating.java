import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Rating {
	
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
	
	public Connection showRating() throws Exception {
		try {
			Connection conn = (Connection) getConnection() ;
			String query = "SELECT * FROM rating" ;
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs1 = stmt.executeQuery(query);
			System.out.println("idRating"+ "  | " + "Rating " + " | "+ "Comment "+ " | " + "Product_idProduct ");
			while (rs1.next()){
				System.out.println(rs1.getString("idRating") + "  |  " + rs1.getString("Rating") + "  |  " + rs1.getString("Comment") + "  |  " + rs1.getString("Product_idProduct"));
			}
		}catch (Exception e){
			System.out.println(e); 
		}
			finally{
				System.out.println("\nsuccess");
			};
		
		return null ; 
		
	}
	
	public void insertRating(int Rating , String Comment , int Product_idProduct ) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement insertStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO rating (Rating,Comment,Product_idProduct) VALUES (?,?,?)");
			insertStatement.setInt(1, Rating);
			insertStatement.setString(2, Comment);
			insertStatement.setInt(3, Product_idProduct);
			insertStatement.execute();
			insertStatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
	public void deleteRating(int idRating) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement deleteRatingStatement = (PreparedStatement) conn.prepareStatement("DELETE FROM rating WHERE idRating = ?");
			deleteRatingStatement.setInt(1, idRating);
			deleteRatingStatement.execute();
			deleteRatingStatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
}
