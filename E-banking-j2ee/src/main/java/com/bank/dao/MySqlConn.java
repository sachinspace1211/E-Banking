package  com.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConn {

	static Connection c;

	public static Connection getConn(){
	   try{
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      if (c==null){
              c=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","Sachin@1205");
              System.out.println("connected "+c);
	      }
	   }
       catch(Exception e){
	      System.out.println(e);
       }
       return c;
   }
}
