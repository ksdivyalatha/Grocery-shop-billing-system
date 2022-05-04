package grocery_billing.com;

import java.util.*;
import java.sql.*;
public class Receipt extends Jdbc_connection{
	private static Connection con  = null;
	
	private static Statement s;

	 
	public static void user() {
		Scanner sc = new Scanner(System.in);
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/grocery_billing_system";
			String user="root";
			String password="Divyalatha1011@";
			con=DriverManager.getConnection(url,user,password);
			System.out.println("Enter choice 1");
			int choice=sc.nextInt();
			switch(choice){
			case 1:
				receipt();
				
				break;
			default:
				System.out.println("Please enter only 1");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	public static void receipt() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product ID");
		int p_id = sc.nextInt();
		System.out.println("Quantity needed");
		int quan = sc.nextInt();
		String sq = "select products.p_name, products.p_brand, discount.p_price, discount.p_discount, discount.p_after_discount from products join discount where products.p_id = "+p_id + " and discount.p_id = "+p_id;
		PreparedStatement preparedStatement = con.prepareStatement(sq);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet !=null) {
			System.out.println("Receipt");
		}
		
		
		


		while(resultSet.next()) {
			
			
			
			System.out.println(resultSet.getString("products.p_name")+"     "+resultSet.getString("products.p_brand")+"     "+quan+"     "+resultSet.getDouble("discount.p_price")+"     "+resultSet.getDouble("discount.p_discount")+"     "+ +resultSet.getDouble("discount.p_after_discount"));
			double price = resultSet.getFloat("p_after_discount");
			double apr = price * quan;
			System.out.println("Total Price = " +apr);
		}
	}
}

	

