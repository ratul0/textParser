/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textparser;

import collectData.SinglePage;
import database.Connect;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author yousufkhan
 */
public class TextParser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String SqlRead,SqlUpdate,aritcleData = "";
        BufferedWriter bw = null;
        try{
            Connection connection = Connect.CreateConntection();
            try {
                Statement statement = Connect.CreateStatement(connection);
                //Statement updateStatement = Connect.CreateStatement(connection);
                SqlRead = "SELECT id, link, status FROM environment where status = 1";
                SqlUpdate = "update environment set status=1 where id=?";
                ResultSet rs = statement.executeQuery(SqlRead);
                PreparedStatement preparedStatement =  connection.prepareStatement(SqlUpdate);
                 //PreparedStatement preparedStatement =  updateStatement.prepareStatement(SqlUpdate);                                      
                
                while(rs.next()){
                    //Retrieve by column name
                    int id  = rs.getInt("id");
                    String link = rs.getString("link");
                    int status = rs.getInt("status");
                    
                    try {
                        bw = new BufferedWriter(new FileWriter(new File("dataset/environment/link" + id + ".txt"), false));
                        aritcleData = SinglePage.getArticle(link);
                    } catch (IOException ex) {

                    }

                    try {
                        if (bw != null) {
                            bw.write(aritcleData);
                            bw.newLine();
                        }

                    } catch (IOException ex) {

                    } finally {
                        if (bw != null) {
                            bw.flush();
                            bw.close();
                        }
                    }
                
                
                    
                    preparedStatement.setInt(1, id);
                    int rowsAffected = preparedStatement.executeUpdate();
                    connection.commit();
                    

                    System.out.print("ID: " + id);
                    System.out.print(", Status: " + status);
                    System.out.println("\n");
                 }
                
                rs.close();
                statement.close();
                connection.close();
                
            }catch(Exception e){
                System.out.println("Couldn't create statement.");
            }
        }catch(Exception e){
            System.out.println("Couldn't create Connection.");
        }
    }
    
}
