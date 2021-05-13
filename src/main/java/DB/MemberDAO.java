/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DTO.conn;
import static DB.DTO.rs;
import static DB.DTO.stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author qwe98
 */
public class MemberDAO {
    static public Connection conn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static  PreparedStatement pstmt = null;
    String sql;
    
    public boolean checkId(String id) {
	boolean check = false;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select id from member where id=?";
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
    
    public void signUpGuest(int idx, String id, String pw, String name, String tel, String address, int balance){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
                System.out.println("연결"); 
                
                sql = "insert into member(idx, id, pw, name, tel, address, balance)";
                sql+= "values(?,?,?,?,?,?,?)";
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,idx);
                pstmt.setString(2, id);
                pstmt.setString(3,pw);
                pstmt.setString(4,name);
                pstmt.setString(5,tel);
                pstmt.setString(6,address);
                pstmt.setInt(7,balance);
                
                rs=pstmt.executeQuery();
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
    }
    
     public void signUpStoreManager(int idx, String id, String pw, String name, String tel, String address, String storetype){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
                System.out.println("연결"); 
                
                sql = "insert into member(idx, id, pw, name, tel, address, storetype)";
                sql+= "values(?,?,?,?,?,?,?)";
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,idx);
                pstmt.setString(2, id);
                pstmt.setString(3,pw);
                pstmt.setString(4,name);
                pstmt.setString(5,tel);
                pstmt.setString(6,address);
                pstmt.setString(7,storetype);
                
                rs=pstmt.executeQuery();
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
    }
    
    static void closeDB() throws SQLException{ // DB 자원해제 함수 @송진영
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
        if(conn != null) conn.close();
    }
}
