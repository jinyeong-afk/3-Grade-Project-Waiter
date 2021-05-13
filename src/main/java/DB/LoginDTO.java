/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.MemberDAO.conn;
import static DB.MemberDAO.pstmt;
import static DB.MemberDAO.rs;
import static DB.MemberDAO.stmt;
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
public class LoginDTO {
    
    static public Connection conn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static  PreparedStatement pstmt = null;
    String sql;
    
    public boolean checkLogin(int idx, String id, String pw){
	boolean check = false;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select id from member where idx = ? and id=? and pw=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,idx);
            pstmt.setString(2,id);
            pstmt.setString(3,pw);
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
    
    public int getIdx(String id, String pw) throws SQLException{
        
        int flag = 0;
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select * from member where id=? and pw=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            pstmt.setString(2,pw);
            rs=pstmt.executeQuery();
            if(rs.next()){
                flag = rs.getInt(1);
            }
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
        return flag;
    }
    
    public String getname(String id) throws SQLException{

        String name = "";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select * from member where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs=pstmt.executeQuery();
            if(rs.next()){
                name = rs.getString(4);
            }
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
        return name;
    }
}
