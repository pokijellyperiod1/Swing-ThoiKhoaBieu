package javaproject_original;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;




public class MyConnection {
    
    
    
    public static Connection getConnection(String dbName){
        
        Connection connection = null;
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName, "root", "");
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
        
        
        return connection;
    }
    
    
    
    
    
    
    
    
    
    
}
