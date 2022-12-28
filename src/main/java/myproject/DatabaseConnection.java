/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
 
public class DatabaseConnection {
  String driver;
  String dbName;
  String connectionURL;
 
  String username;
  String password;
  public DatabaseConnection()
  {
   driver = "com.mysql.cj.jdbc.Driver";
   connectionURL = "jdbc:mysql://localhost/";
   dbName = "gms";
   username = "root";
   password = "123456789";
  }
   
  public Connection getConnection() throws Exception {
 
    Class.forName(driver);
    Connection connection = DriverManager.getConnection(connectionURL+dbName,username,password);
 
    return connection;
  }
   
  public static void main(String[] args) {
   DatabaseConnection db = new DatabaseConnection();
   try {
    Connection conn = db.getConnection();
    Statement st = conn.createStatement();
    System.out.println("Database successfully connected!");
    conn.close();
    st.cancel();
   } catch (Exception e) {
    // TODO Auto-generated catch block
       System.out.println("Error");
   }
  }
}
