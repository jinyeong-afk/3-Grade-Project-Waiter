/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author sejin
 */
public class StoreDAO{
    static Connection conn;
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
    
    public boolean checkRegist(String id){
	boolean check = false;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select * from member where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs=pstmt.executeQuery();
            check = rs.next();
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
        return check;
	}
    
    public ArrayList<String> getStringStoreInformaiton(String id) throws SQLException{

        ArrayList<String> list = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select * from store where store_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs=pstmt.executeQuery(); 
            String[] valueString = new String[3];

            
            while(rs.next()){
                valueString[0] = rs.getString(1);
                valueString[1] = rs.getString(2); 
                valueString[2] = rs.getString(8);
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
    
        public ArrayList<Integer> getIntStoreInformaiton(String id) throws SQLException{

        ArrayList<Integer> list = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select * from store where store_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs=pstmt.executeQuery(); 

            int[] valueInt = new int[6];
            
            while(rs.next()){
                valueInt[0] = rs.getInt(3);
                valueInt[1] = rs.getInt(4); 
                valueInt[2] = rs.getInt(5);
                valueInt[3] = rs.getInt(6);
                valueInt[4] = rs.getInt(7);
                valueInt[5] = rs.getInt(9);
                
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
}
