package grocery_billing.com;

import java.util.*;
class User {
	private static Scanner sc= new Scanner(System.in);
	static void user() {
		int access = sc.nextInt();
		switch(access) {
		case 1 :
				Admin.user();
				break;
		case 2 :
				Receipt.user();
				break;
		default :
				System.out.println("Unauthorized user ");
		}
	}
	
}


public class Bill_System { 

	public static void main(String[] args) {
		System.out.println("Enter user access: admin or receipt ");
		User user = new User();
		User.user();
		
		
		

	}

}
