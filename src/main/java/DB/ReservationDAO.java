/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import Src.ReservationConfirm_Observer.WaitingNumber;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author qwe98
 */
public class ReservationDAO {
    
    static public Connection conn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static  PreparedStatement pstmt = null;
    String sql;
    
    
    public ArrayList<String> getStoreNameList(){
        
        ArrayList<String> list = new ArrayList<>();
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select storename from store where permission = 0";
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            String value = "";
            while(rs.next()){
                value = rs.getString(1);
                list.add(value);
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
    public ArrayList getWaitSequence(String id) throws SQLException{
         ArrayList<WaitingNumber> list = new ArrayList<>();
         WaitingNumber W;
         
         try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select storename, wait_sequence from guest where guest_id = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            
            rs=pstmt.executeQuery();
            
            if(rs.next()){
                
                W = new WaitingNumber(rs.getString(1), rs.getInt(2));
                list.add(W);
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

 
    
    public ArrayList<String> getGuestNameList(String id){
        
         ArrayList<String> list = new ArrayList<>();
         String value = "";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            //sql = "select guest_id from guest where storename = ? ";
            sql = "select distinct(guest_id) from( select * from store join guest using (storename)) where store_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            
            rs=pstmt.executeQuery();
            
            while(rs.next()){
                value = rs.getString(1);
                list.add(value);
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
    
    public int getStoreMaxTable(String id){
        //ArrayList<Integer> list = new ArrayList<>();
        int value = 0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select max from store where storename = '"+id+"'";
            
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            
            while(rs.next()){
                value = rs.getInt(1);
            }
            
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
        return value;
    }
    
    
}
