/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.LoginDTO.conn;
import static DB.LoginDTO.pstmt;
import static DB.LoginDTO.rs;
import static DB.LoginDTO.stmt;
import static DB.StoreDAO.conn;
import static DB.StoreDAO.pstmt;
import static DB.StoreDAO.rs;
import static DB.StoreDAO.stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 박경민
 */
public class PermissionDAO {
    static Connection conn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static ResultSet rss = null;
    static  PreparedStatement pstmt = null;
    static  PreparedStatement pstnt = null;
    String sql;
    String sqll;
    
    public ArrayList<String> getStringStoreInfo(String storename) throws SQLException{

     ArrayList<String> list = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println(" getStringStoreInformaiton 연결");
            sql = "select * from store where storename = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,storename);
            rs=pstmt.executeQuery(); 
            String[] valueString = new String[3];

            
            while(rs.next()){
                valueString[0] = rs.getString(2); //storename
                valueString[1] = rs.getString(4); //storetel
                valueString[2] = rs.getString(3); //storeaddress 
                for(int i=0; i<valueString.length; i++){
                    list.add(valueString[i]);
                }
            }
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
        return list;
    }
    
    public ArrayList<Integer> getIntStoreInfo(String storename) throws SQLException{

        ArrayList<Integer> list = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getIntStoreInformaiton 연결");
            sql = "select * from store where storename = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,storename);
            rs=pstmt.executeQuery(); 

            int[] valueInt = new int[4];
            
            while(rs.next()){
                valueInt[0] = rs.getInt(7); //max 테이블수
                valueInt[1] = rs.getInt(7); //max 재고 수
                valueInt[2] = rs.getInt(5); //opentime
                valueInt[3] = rs.getInt(6); //close_time
               
                for(int i=0; i<valueInt.length; i++){
                    list.add(valueInt[i]);
                }
                
        }
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
        return list;
    }
    
    public void PermissionStore(String storename) throws SQLException{
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "UPDATE store SET permission=1 WHERE storename = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,storename);
            
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
