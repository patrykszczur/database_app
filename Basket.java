import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Basket {
	
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

	public Connection showOrder() throws Exception {
		try {
			
			java.sql.Connection conn = getConnection() ;
			String query = " SELECT c.idOrder, a.Name, a.Surname, a.`Phone_Number`, b.Product_name, b.`Serial_Number`," +
					" c.Order_address, c.Status, c.`Total_Price`, c.Created_at FROM `order` c JOIN order_has_product d " +
					"ON c.idOrder = d.Order_idOrder JOIN user a ON c.User_idUser = a.idUser JOIN product b ON " +
					"d.Product_idProduct = b.idProduct" ;
					
						
			java.sql.Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("idOrder "  + " | " + "Name " + " | " + "Surname "+ " | " + "Phone_Number "+ " | "+ "Product_name "+ " | " + "Serial_Number "+ " | " + "Order_address "+ " | " + "Status "+ " | " + "Total_Price " + " | " + "Created_at ");
			while (rs.next()){
				System.out.println(rs.getString("idOrder") + "  |  " + rs.getString("Name") + "  |  " + rs.getString("Surname") + "  |  "  + rs.getString("Phone_Number") + "  |   " + rs.getString("Product_name")+ "  |  " + rs.getString("Serial_Number")+ "  |  " + rs.getString("Order_address")+ "  |  " +  rs.getString("Status")+ "  |  " + rs.getString("Total_Price")+ "  |  " + rs.getString("Created_at"));
			}
		}catch (Exception e){
			System.out.println(e); 
		}
			finally{
				System.out.println("\nsuccess");
			};
		
		return null ; 
		
	}
	
	
}