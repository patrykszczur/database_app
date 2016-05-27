import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class Product {
	
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
	
	public Connection showProduct() throws Exception {
		try {
			
			Connection conn = (Connection) getConnection() ;
			String query = "SELECT * FROM product" ;
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("id " + " | "+ "Product_name " + " | "+ "serial_number " + " | "+ "Description "+ " | " + "price "+ " | " + "Quantity");
			while (rs.next()){
				System.out.println(rs.getString("idProduct") +  "  |  " + rs.getString("Product_name")  +  "  |  " + rs.getString("Serial_Number") +"  |  " + rs.getString("Description")+ "  |  " +  rs.getString("Price") +  "  |  " + rs.getString("Quantity"));
			}
		}catch (Exception e){
			System.out.println(e); 
		}
			finally{
				System.out.println("\nsuccess");
			};
		
		return null ; 
		
	}
	
	public void insertProduct(String Product_name , String Serial_Number , String Description , String Description_full , double Price , int Quantity ) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement insertStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO product (Product_name ,Serial_Number,Description,Description_full,Price,Quantity) VALUES (?,?,?,?,?,?)");
			insertStatement.setString(1, Product_name);
			insertStatement.setString(2, Serial_Number );
			insertStatement.setString(3, Description);
			insertStatement.setString(4, Description_full);
			insertStatement.setDouble(5, Price);
			insertStatement.setInt(6 ,Quantity);
			insertStatement.execute();
			insertStatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
	
	public void deleteProduct(String Product_name , String Serial_Number) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement deleteproductstatement  = (PreparedStatement) conn.prepareStatement("DELETE FROM product WHERE Product_name = ? AND Serial_Number= ?");
			deleteproductstatement.setString(1, Product_name);
			deleteproductstatement.setString(2, Serial_Number );
			deleteproductstatement.execute();
			deleteproductstatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
}
