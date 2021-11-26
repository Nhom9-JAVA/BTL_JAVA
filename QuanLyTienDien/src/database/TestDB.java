/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.Connection;



/**
 *
 * @author TIEN THANH HOA
 */
public class TestDB {
  
    public static void main(String[] args) {
      //  Connect conn = new Connect();
       // conn.getConnect();
         String ser="DESKTOP-5SBE75L\\LLOYY";
       String db="qltd";
       int p=1466;
       SQLServerDataSource sd = new SQLServerDataSource();
       
        try(Connection conn = sd.getConnection()) {
            
            System.out.println("t   xacascascasc c ");
            System.out.println(conn.getCatalog());
        } catch (Exception e) {
            e.printStackTrace();
        }
          
    }
}
