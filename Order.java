import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Order {

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
	
	public void insertOrder(String Order_address , int Amount , String Total_Price , String Status , int Employees_idEmployees , int User_idUser) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement insertStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO  `order` (Order_address,Amount,Total_Price,Status,Employees_idEmployees,User_idUser) VALUES (?,?,?,?,?,?)");
			
			insertStatement.setString(1, Order_address);
			insertStatement.setInt(2, Amount);
			insertStatement.setString(3, Total_Price);
			insertStatement.setString(4, Status);
			insertStatement.setInt(5, Employees_idEmployees);
			insertStatement.setInt(6 ,User_idUser);
			insertStatement.execute();
			insertStatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
	public void productName(int Order_idOrder , int Product_idProduct ) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement insertStatement = (PreparedStatement) conn.prepareStatement("INSERT INTO order_has_product (Order_idOrder  , Product_idProduct ) VALUES (?,?)");
			
			insertStatement.setInt(1, Order_idOrder);
			insertStatement.setInt(2, Product_idProduct);
			insertStatement.execute();
			insertStatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
	public void deleteOrder(int idOrder) throws Exception  {
		
		Connection conn = (Connection) getConnection() ;
		try {
			PreparedStatement deleteEmployeeStatement = (PreparedStatement) conn.prepareStatement("DELETE FROM `order` WHERE idOrder = ?");
			deleteEmployeeStatement.setInt(1, idOrder);
			deleteEmployeeStatement.execute();
			deleteEmployeeStatement.close(); 
			conn.close() ; 
			
			System.out.println("Success");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} 
	}
}
