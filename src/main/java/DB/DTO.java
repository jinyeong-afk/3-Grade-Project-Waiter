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
 * @author 송진영
 */
public class DTO {
    static public Connection conn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static  PreparedStatement st = null;
    
    public static void changeDB(String query) throws SQLException { // DB에 insert, delete, update 등 수정 @송진영 

        String sql = query;
        st = conn.prepareStatement(sql);
        st.executeUpdate();
    }
    
    public static String getDBString(String query, String getValue) throws SQLException { // DB에서 String 값을 가져오는 함수 @송진영
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        String value = "";
        while (rs.next()) {
            value = rs.getString(getValue);
        }
        return value;
    }
    
    public static int getDBInt(String query, String getValue) throws SQLException { //DB에서 Int 값을 가져오는 함수 @author 송진영 
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        int value = 0;
        while (rs.next()) {
            value = rs.getInt(getValue);
        }
        return value;
    }
    
    public static boolean getDBBool(String query) throws SQLException { //DB에 값이 있는지 확인하는 함수 @author 송진영 
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        if (rs.next()) {
           return false;
        }
        else
        {
           return true;
        }
    }
    
    static public ArrayList<Integer> getDBListPrice(String query, String getValue, String getValue2) throws SQLException { // DB에서 int 값을 arryalist로 가져오는 함수 @송진영
        stmt = conn.createStatement();
        rs = stmt.executeQuery(query);
        int value = 0;
        int value_2 = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (rs.next()) {
            value = rs.getInt(getValue);
            value_2 = rs.getInt(getValue2);
            list.add(value * value_2);
        }
        return list;
    }
    
    public static void loadDB() throws SQLException{ // DB를 불러오는 함수 @송진영
        try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
        System.out.println("연결");
        }
        catch(Exception e) {
        e.printStackTrace();
        System.out.println("DB 로드 실패");
        }
    }
    
    public static void closeDB() throws SQLException{ // DB 자원해제 함수 @송진영
        if(rs != null) rs.close();
        if(stmt != null) stmt.close();
        if(conn != null) conn.close();
    }
}
