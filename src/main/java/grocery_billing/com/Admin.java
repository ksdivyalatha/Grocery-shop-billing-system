package grocery_billing.com;


import java.util.*;
import java.sql.*;
public class Admin extends Jdbc_connection{
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
			System.out.println("Enter choice");
			int choice=sc.nextInt();
			switch(choice){
			case 1:
				insertProducts();
				
				break;

			case 2:
				updateProducts();
				break;
				
			case 3:
				insertDiscount();
				break;
				
			case 4:
				updateDiscount();
				break;
			default:
				System.out.println("Enter correct details");
					
			}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			

		} 
	private static void insertProducts() throws Exception {
		String s1="insert into products values(?,?,?,?)";
		PreparedStatement pre= con.prepareStatement(s1);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter Product ID: ");
		int pid = sc.nextInt();
		pre.setInt(1, pid);
		sc.nextLine();
		
		System.out.println("Enter Product Name: ");
		String pname =	sc.nextLine();
		pre.setString(2, pname);
		
		System.out.println("Enter Product Brand: ");
		String pbrand =	sc.nextLine();
		pre.setString(3,pbrand);
		
		System.out.println("Enter Product Quantity: ");
		int pquantity =	sc.nextInt();
		pre.setInt(4,pquantity);
		int rows =pre.executeUpdate();
		if(rows>0) {
			System.out.println("Record inserted succesfully");
		}
	}


	private static void updateProducts() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product ID for updating");
		int pid = sc.nextInt();

		System.out.println("Enter quantity:");
		int upquan = sc.nextInt();
		String sq1="update products set p_quantity="+upquan + " where p_id="+pid;
		PreparedStatement pq =con.prepareStatement(sq1);
		int rows =pq.executeUpdate();
		if(rows>0) {
			System.out.println("Record updated succesfully");
		}
		String sq="select * from products";
		Statement st= con.createStatement();
		ResultSet rt=st.executeQuery(sq);
		while(rt.next()) {
			String name = rt.getString("p_name");
			System.out.println(name);
	
		}
		
	}
	
	private static void insertDiscount() throws Exception {
		String s1="insert into discount values(?,?,?,?)";
		PreparedStatement pre= con.prepareStatement(s1);
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter Product ID: ");
		int pid = sc.nextInt();
		pre.setInt(1, pid);
		
		System.out.println("Enter Product Discount: ");
		double p_discount =	sc.nextDouble();
		pre.setDouble(2,p_discount);
		
		System.out.println("Enter Product Price: ");
		double p_price =	sc.nextDouble();
		pre.setDouble(3,p_price);
		
		double finalcost = p_price - (p_price*5/100);
		pre.setDouble(4,finalcost);
		

		
		
		int rows =pre.executeUpdate();
		if(rows>0) {
			System.out.println("Record inserted succesfully");
		}
	}
	
	
	private static void updateDiscount() throws Exception{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product ID for updating");
		int pid = sc.nextInt();
	
		System.out.println("Enter Discount:");
		double discount = sc.nextDouble();
		String sq1="update discount set p_discount="+discount +" where p_id="+pid;
		PreparedStatement pq =con.prepareStatement(sq1);
		int rows =pq.executeUpdate();
		if(rows>0) {
			System.out.println("Record updated succesfully");
		}
		String sq="select * from discount";
		Statement st= con.createStatement();
		ResultSet rt=st.executeQuery(sq);
//		while(rt.next()) {
//			String name = rt.getString("p_name");
//			System.out.println(name);
//	
//		}
		
	}

}
	