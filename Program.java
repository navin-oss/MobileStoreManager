package MainMenue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Mobile;
import entity.User;
import util.DbUtil;


public class Program {
	  public static void addUser(Scanner sc) {
	        User user = new User();       
	        user.accept(sc);         

	        String sql = "INSERT INTO user(name, email, password, city) VALUES (?, ?, ?, ?)";

	        try (Connection connection = DbUtil.getConnectio()) {   
	            try (PreparedStatement insertStatement = connection.prepareStatement(sql)) {
	                insertStatement.setString(1, user.getName());
	                insertStatement.setString(2, user.getEmail());
	                insertStatement.setString(3, user.getPassword());
	                insertStatement.setString(4, user.getCity());

	                insertStatement.executeUpdate();
	                System.out.println("User registered successfully...");
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	  
	  public static void addMobile(Scanner sc) {
		  Mobile mobile=new Mobile();
		  mobile.accept(sc);
		  String sql = "INSERT INTO mobile(company,model,price) VALUES(?,?,?)";
		  try(Connection connection=DbUtil.getConnectio()){
			  try(PreparedStatement insertStatement=connection.prepareStatement(sql)){
				   insertStatement.setString(1,mobile.getCompany());
				   insertStatement.setString(2,mobile.getModel());
				   insertStatement.setDouble(3,mobile.getPrice());
				   insertStatement.executeUpdate();
				   System.out.println("Mobile is added successfully....");
				   }
			  
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  }
	  public static void displayAllMobiles() {
		  String sql = "SELECT * FROM mobile";
		  try (Connection connection=DbUtil.getConnectio()){
			  try(PreparedStatement selectStatement = connection.prepareStatement(sql)){
				  ResultSet rs=selectStatement.executeQuery();
				  List<Mobile> mobilelist=new ArrayList<>();
				  while(rs.next()) {
					  Mobile mobile=new Mobile();
					  mobile.setMobileid(rs.getInt(1));
					  mobile.setCompany(rs.getString(2));
					  mobile.setModel(rs.getString(3));
					  mobile.setPrice(rs.getDouble(4));
					  mobilelist.add(mobile);
					  }
				  mobilelist.forEach(m -> System.out.println(m));
				  
			  }
		  }
           catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	  
	  }
	  
	  public static User loginUser(Scanner sc) {
		User user=new User();
		String sql= "SELECT * FROM user WHERE email = ? AND password = ?";
		System.out.print("Enter the email :");
		user.setEmail(sc.next());
		System.out.print("Enter the password :");
		user.setPassword(sc.next());
		try(Connection connection=DbUtil.getConnectio()){
			try(PreparedStatement selectStatement= connection.prepareStatement(sql)){
				selectStatement.setString(1, user.getEmail());
				selectStatement.setString(2, user.getPassword());
				ResultSet rs = selectStatement.executeQuery();
				if(rs.next()) {
					user.setUserid(rs.getInt(1));
					user.setName(rs.getString(2));
					user.setCity(rs.getString(5));
					return user;
				}
			}
		  
	  } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return null;
	  }
	  
	  protected static void placeOrder(Scanner sc,int userid) {
		  displayAllMobiles();
		  String sql="INSERT INTO orders(mobileid,userid) VALUES(?,?)";
		  System.out.print("Enter Mobile id to purchase :");
		  int mobileid=sc.nextInt();
		  try(Connection connection = DbUtil.getConnectio()){
			  try(PreparedStatement insertStatement = connection.prepareStatement(sql)){
					insertStatement.setInt(1, mobileid);
					insertStatement.setInt(2, userid);
					insertStatement.executeUpdate();
					System.out.println("YAY...Order Placed  :)");
			  }
		  } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  private static void orderHistory(int userid) {
			String sql = "SELECT m.company,m.model,m.price FROM mobile m INNER JOIN orders o ON m.mobileid=o.mobileid WHERE o.userid=?";
			try(Connection connection = DbUtil.getConnectio()){
				try(PreparedStatement selectStatement= connection.prepareStatement(sql)){
					selectStatement.setInt(1, userid);
					ResultSet rs=selectStatement.executeQuery();
					while(rs.next()) {
						System.out.print(rs.getString(1) + " - ");
						System.out.print(rs.getString(2) + " - ");
						System.out.print(rs.getDouble(3));
						System.out.println();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	
	
	
	
    public static int menu(Scanner sc) {
    	System.out.println("**********************************");
    	System.out.println("0.Exit :");
    	System.out.println("1.Add User :");
    	System.out.println("2.Add Mobile  :");
    	System.out.println("3.Display All Mobiles :");
    	System.out.println("4.Login :");
    	System.out.println("5.Place order :");
    	System.out.println("6.Order history :");
    	System.out.println("7.Logout  :");
    	System.out.print("Enter the choice :");
    	int choice=sc.nextInt();
		System.out.println("****************************");
		return choice;
    	
    }
	

	public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
     User user=null;
     int choice;
     while((choice = menu(sc))!=0) {
    	 switch(choice) {
    	 case 1:
    		 addUser(sc);
    		 break;
    	 case 2:
    		 addMobile(sc);
    	 case 3:
    		 displayAllMobiles();
    	 case 4:
    		 user=loginUser(sc);
    		 if(user != null){
    			 System.out.println("Login Successfully.....");
    		 }
    		 else {
    			 System.out.println("Invalid email and password.....");
    		 }
    		 break;
    	 case 5:
    		 if (user != null)
					placeOrder(sc, user.getUserid());
				else
					System.out.println("You need to login...");
				break;
    	 case 6:
    		 if (user != null)
					orderHistory(user.getUserid());
				else
					System.out.println("You need to login...");
				break;
    	 case 7:
    		 user = null;
				System.out.println("Logout Successful...");
				break;

			default:
				System.out.println("Wrong choice ... :(");
				break;
    	 }
    	 
     }
     sc.close();
     System.out.println("THANK YOU FOR USING OUR APP :");

	}


}
