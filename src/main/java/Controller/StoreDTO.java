/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.StoreDTO.conn;
import static DB.StoreDTO.rs;
import static DB.StoreDTO.stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sejin
 */
public class StoreDTO {
    static public Connection conn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static  PreparedStatement pstmt = null;
    String sql;
    

    
     public void ChangeStore(String ID, String storename, String storeaddress, String storetel, int open_time, int close_time, int Max){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
                System.out.println("연결"); 
                
                sql = "UPDATE store SET storename = ?, storeaddress = ?, STORETELL= ?, open_time = ?, close_time = ?, MAX=? WHERE store_id ='"+ ID +"'";
                
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, storename);
                pstmt.setString(2, storeaddress);
                pstmt.setString(3, storetel);
                pstmt.setInt(4, open_time);
                pstmt.setInt(5, close_time);
                pstmt.setInt(6, Max);
                
               
                
                rs=pstmt.executeQuery();
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
    }
      public void signUpStore(String ID,  String storetype, String storename, String storetel, String storeaddress, int open_time, int close_time, int max){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
                System.out.println("연결"); 
                
                sql = "insert into store(store_id, storename, storetell, storeaddress, open_time, close_time, max, storetype, permission)";
                sql+= "values(?,?,?,?,?,?,?,?, 1)";
                
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, ID);
                pstmt.setString(2, storename);
                pstmt.setString(4, storeaddress);
                pstmt.setString(3, storetel);
                pstmt.setInt(5, open_time);
                pstmt.setInt(6, close_time);
                pstmt.setInt(7, max);
                pstmt.setString(8, storetype);
                
               
                rs=pstmt.executeQuery();
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
    }
}
