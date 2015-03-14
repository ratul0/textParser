/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author yousufkhan
 */
public class Connect {
    
    public static Connection CreateConntection(){
        Connection c = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager
                    .getConnection("jdbc:mysql://localhost/thesis",
                            "root", "");
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");
            return c;
            

        }catch(Exception e){
            throw new NullPointerException();
        }
        
    }
    
    public static Statement CreateStatement(Connection c){

        Statement stmt = null;
        try {
            System.out.println("Create statement successfully");
            return stmt = c.createStatement();
            
        }catch(Exception e){
            throw new NullPointerException();
        }
        
    }
    
}
