import java.util.Scanner;

public class MainClass {	
	/**
	 * @author PatrykSzczur 
	 * @version 4.0
	 * 
	 * 
	 * 
	 * @param args
	 * @throws Exception 
	 */
	
	public static void main(String[] args) throws Exception  {
		
    	Product product = new Product() ;
    	Employee employee =  new Employee () ; 
    	Message message = new Message () ;
    	User user =  new User () ; 
    	Rating rating = new Rating() ; 
    	Basket basket = new Basket() ; 
    	Order order = new Order () ; 
    	
    	int kindOfuser ; 
		int userNumber=0;
		int numberOfAdmin = 0  ;
		
		System.out.println("this is application to use the database  " + "\n");
		System.out.println("here you can add new record and see other entries  " + "\n");
		System.out.println("so dear user . . . first chose who you are ?" + "\n");
		System.out.println("press 1 if you are user and 2 if you are employee" + "\n");

		
		Scanner kindOfuser_instert = new Scanner(System.in);
		kindOfuser = kindOfuser_instert.nextInt();
		
		if(kindOfuser == 1){
			
			while (userNumber != '9')
			{
	        System.out.println("1. press 1 to check ouer products" );
	        System.out.println("5. press 5 to add new Rating");
	        System.out.println("12. press 12 to show rating \n"); 
	        
	        
	        System.out.println("17. press 17 to add order "); 
	        System.out.println("11. press 11 to show all information about order ");
	        System.out.println("18. press 18 to delete order \n");  
	        
	        
	        System.out.println("15. press 15 to add message "); 
	        System.out.println("14. press 14 to delete your account");         
	        System.out.println("13. press 13 to register "); 
	        System.out.println("3. press 3 see ouer team ");        
	        System.out.println("19. press 19 to exit \n");			
	        System.out.println("your choice: ");
	        @SuppressWarnings("resource")
			Scanner number = new Scanner(System.in);
	        userNumber = number.nextInt();
			
	        switch(userNumber)
	        {
	            case 1:  
	            	product.showProduct() ;
	            	break;	        		
	            case 3 : 
	            	employee.showEmployee();
	            	break;	           
	            case 5 :  
	            	Scanner rating_input = new Scanner(System.in);
	         		int Rating ;
	         		System.out.println("enter Rating");
	         		Rating = rating_input.nextInt() ; 
	         		String Commentt ; 
	         		System.out.println("enter your Comment");
	         		Commentt = rating_input.next();
	         		int Product_idProduct ; 
	         		System.out.println("enter id of product");
	         		Product_idProduct = rating_input.nextInt() ; 
	         		rating.insertRating( Rating , Commentt , Product_idProduct );	
	            	break ;                    
	            case 11 : 
	            	basket.showOrder() ; 
	            	break ;  
	            case 12 :
	            	rating.showRating() ;
	            	break ;
	            case 13 :
	            	Scanner user_inputt = new Scanner(System.in);
	        		String user_Name ;
	        		System.out.println("enter name of user");
	        		user_Name = user_inputt.next();
	        		String user_Surname ; 
	        		System.out.println("enter surname of user");
	        		user_Surname = user_inputt.next();
	        		String user_Password ; 
	        		System.out.println("enter password of user");
	        		user_Password = user_inputt.next();
	        		int user_Sex ; 
	        		System.out.println("are you man (press 1) or woman (press 0)");
	        		user_Sex = user_inputt.nextInt() ; 
	        		String user_Mail ; 
	        		System.out.println("enter  email in format xxxxx@gmail.com ");
	        		user_Mail = user_inputt.next();
	        		String user_Address ;
	        		System.out.println("enter Adress ");
	        		user_Address = user_inputt.nextLine() ; 
	        		String user_phone_number ; 
	        		System.out.println("enter phone number");
	        		user_phone_number = user_inputt.nextLine() ; 
	            	user.insertUser (user_Name , user_Surname , user_Password , user_Sex ,  user_Mail , user_Address  , user_phone_number ) ;
	            	break ; 
	            case 14 :
	            	Scanner duser_input = new Scanner(System.in);
	        		String duser_Name ;
	        		System.out.println("enter name of user");
	        		duser_Name = duser_input.next();
	        		String duser_Surname ; 
	        		System.out.println("enter surname of user");
	        		duser_Surname = duser_input.next();
	        		user.deleteUser(duser_Name ,duser_Surname);
	            	break ;
	            case 15 :
	            	Scanner mes_input = new Scanner(System.in);
	        		String Description ;
	        		System.out.println("enter your message");
	        		Description = mes_input.nextLine();
	        		int Header_idHeader ; 
	        		Header_idHeader = 1 ;
	            	message.insertMessage( Description ,  Header_idHeader  );

	            	break ; 
	           
	            case 17 : 
	            	
	            	Scanner order_input = new Scanner(System.in);
	        		String Order_address ;
	        		System.out.println("enter address of order ");
	        		Order_address = order_input.nextLine();
	        		
	        		int Amount ;
	        		System.out.println("enter amount");
	        		Amount = order_input.nextInt();
	        		
	        		String Total_Price ;
	        		System.out.println("enter total price");
	        		Total_Price = order_input.next();
	        		
	        		String Status ;
	        		System.out.println("enter status ... you can choose done or during");
	        		Status = order_input.next();
	        		
	        		int Employees_idEmployees ;
	        		System.out.println("enter id of employees");
	        		Employees_idEmployees = order_input.nextInt();
	        		
	        		int User_idUser ;
	        		System.out.println("enter user id");
	        		User_idUser = order_input.nextInt();
	        				
	        		int Order_idOrderr ;
	        		System.out.println("enter id your order");
	        		Order_idOrderr = order_input.nextInt();
	        		
	        		int Product_idProductt ;
	        		System.out.println("enter id of product");
	        		Product_idProductt = order_input.nextInt();
	        		
	        		   		
	            	order.insertOrder( Order_address ,  Amount ,  Total_Price ,  Status ,  Employees_idEmployees ,  User_idUser);
	            	order.productName( Order_idOrderr , Product_idProductt );
	            	break ;
	            case 18 :
	            	Scanner dorder_input = new Scanner(System.in);
	            	int idOr ;
	        		System.out.println("enter id of order");
	        		idOr = dorder_input.nextInt();
	            	order.deleteOrder(idOr) ; 
	            	break ;
	            case 19 :
	            	 System.out.println("Thanks for using my application \n\nmade by Patryk Szczur\n	Bartosz Betka");
	            	 System.exit(0);
	            	 
	            	 break ;
	            	 
	        }
			
		}
			
		}else if(kindOfuser == 2){
			
			System.out.println("part of the administrator\n\n");
			
			while (userNumber != '1')
			{
					 System.out.println("1. press 1 to show products in db");
				     System.out.println("2. press 2 to add new product");
				     System.out.println("8. press 8 to delete product ( you have to know serial number ) \n");
				     System.out.println("4. press 4 to add new employee to ouer DB ");
				     System.out.println("7. press 7 to delete employee");
				     System.out.println("3. press 3 to show employee\n");
				     System.out.println("10. press 10 to show messagess from users");
				     System.out.println("16. press 16 to delete message \n"); 
				     System.out.println("6. press 6 to delete rating ");
				     System.out.println("9. press 9 to show users ");

				 
			        System.out.println("\n" + "19. press 19 to exit ");

			        System.out.println("your choice: ");
			        @SuppressWarnings("resource")
					Scanner number = new Scanner(System.in);
			        numberOfAdmin = number.nextInt();
			        
			        switch(numberOfAdmin)
			        {
			        case 1:  
		            	product.showProduct() ;
		            	break;	   
		            	
			        case 2:        
		            	Scanner user_prod = new Scanner(System.in);
		        		String Name ;
		        		System.out.println("enter Product name");
		        		Name = user_prod.nextLine();
		        		String Serial_num ; 
		        		System.out.println("enter serial number of product you can use numbers and letters ");
		        		Serial_num = user_prod.nextLine();
		        		String description ; 
		        		System.out.println("enter description");
		        		description = user_prod.nextLine();
		        		String description_all ; 
		        		System.out.println("if you want to write something else now you can /n do this if no enter 'no'");
		        		description_all = user_prod.nextLine() ; 
		        		double price ; 
		        		System.out.println("enter price of product ");
		        		price = user_prod.nextDouble();
		        		int quantity ;
		        		System.out.println("how much product do you want to add  ?  ");
		        		quantity = user_prod.nextInt() ; 
		        		product.insertProduct( Name + "" , Serial_num , description , description_all , price , quantity );       
		        		break;
			        case 3 : 
		            	employee.showEmployee();
		            	break;	
			        case 4 :            	
		            	Scanner user_input = new Scanner(System.in);
		        		String First_Name ;
		        		System.out.println("enter your name");
		        		First_Name = user_input.next();
		        		String Last_Name ; 
		        		System.out.println("enter your surname");
		        		Last_Name = user_input.next();
		        		String Password ; 
		        		System.out.println("enter your password");
		        		Password = user_input.next();
		        		int Sex ; 
		        		System.out.println("are you man (press 1) or woman (press 0)");
		        		Sex = user_input.nextInt() ; 
		        		String Mail ; 
		        		System.out.println("enter your email in format xxxxx@gmail.com ");
		        		Mail = user_input.next();
		        		int Employee_idEmployee ;
		        		System.out.println("enter Employee Id ... this is number of your booss");
		        		Employee_idEmployee = user_input.nextInt() ; 
		        		employee.insertEmployee(First_Name , Last_Name , Password , Sex , Mail , Employee_idEmployee ); 
		        		break ;
			        case 6 :
		            	Scanner drating_input = new Scanner(System.in);
		         		int deleterating ;
		         		System.out.println("enter idRating ");
		         		deleterating = drating_input.nextInt() ;
		         		rating.deleteRating(deleterating);
		               	break ;	
			        case 7 :
		            	Scanner dscaner = new Scanner(System.in);
		            	String name ;
		        		System.out.println("enter name");
		        		name = dscaner.next();
		        		String surname ; 
		        		System.out.println("enter your surname");
		        		surname = dscaner.next();
		            	employee.deleteEmployee(name ,surname);
		              	 break ;	
			        case 8 :
		            	Scanner dpscaner = new Scanner(System.in);
		            	String nameofproduct ;
		        		System.out.println("enter model of product");
		        		nameofproduct = dpscaner.nextLine();
		        		String serialnumber ; 
		        		System.out.println("enter serial number of product");
		        		serialnumber = dpscaner.nextLine();
		        		product.deleteProduct ( nameofproduct ,serialnumber );
		              	break ;
			        case 9 : 
		            	user.showUser() ; 
		            	break ; 
			        case 10 : 
		            	message.showMessageAndHeander() ;
		            	break ; 
			        case 16 : 
		            	Scanner mess_input = new Scanner(System.in);
		        		String idMessage ;
		        		System.out.println("enter message id");
		        		idMessage = mess_input.next();
		        		message.deleteMessage(idMessage) ; 
		            	break ;
			        case 19 :
		            	 System.out.println("Thanks for using my application \n\nmade by Patryk Szczur\n	Bartosz Betka");
		            	 System.exit(0);
		            	 break ;
			        }
			        
			}
			
			
		}else {
			System.out.println("ups ... you have chosen the wrong number");
		}
	}
	
}
