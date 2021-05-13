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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    
}
