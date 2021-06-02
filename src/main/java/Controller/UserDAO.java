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
import static DB.PermissionDAO.conn;
import static DB.PermissionDAO.pstmt;
import static DB.PermissionDAO.rs;
import static DB.PermissionDAO.stmt;
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
 * @author 박경민,박성호
 */
public class UserDAO {

    static Connection conn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement pstmt = null;
    String sql;

    public ArrayList<String> getGuestIDName() {

        ArrayList<String> list = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getGuestIDName 연결");
            sql = "select id from member where idx=1";//게스트
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            String value = "";
            while (rs.next()) {
                value = rs.getString(1);
                list.add(value);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }
    
      public ArrayList<String> getBlackIDName() {

        ArrayList<String> list = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getGuestIDName 연결");
            sql = "select id from member where idx=4";//게스트
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            String value = "";
            while (rs.next()) {
                value = rs.getString(1);
                list.add(value);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }

    public ArrayList<String> getManagerIDName() {

        ArrayList<String> list1 = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getManagerIDName 연결");
            sql = "select id from member where idx=2 ";//매장 관리자
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            String value = "";
            while (rs.next()) {
                value = rs.getString(1);
                list1.add(value);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list1;
    }

    public ArrayList<String> getIDPW(String ID) throws SQLException {

        ArrayList<String> list2 = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println(" getStringStoreInformaiton 연결");
            sql = "select * from member where id=?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, ID);
            rs = pstmt.executeQuery();
            String[] valueString = new String[2];

            while (rs.next()) {
                valueString[0] = rs.getString(2); //storename
                valueString[1] = rs.getString(3); //storetel
                for (int i = 0; i < valueString.length; i++) {
                    list2.add(valueString[i]);
                }
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list2;
    }

    public void ModifyInfo(String ID, String PW) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("ModifyInfo 연결");

            sql = "UPDATE member SET PW = ? WHERE ID='" + ID + "'";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, PW);
            System.out.println(ID);
            System.out.println(PW);

            rs = pstmt.executeQuery();

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
    }

    public void DelInfo(String ID, String PW) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("DelInfo 연결");

            sql = "delete from member where ID =? and pw = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ID);
            pstmt.setString(2, PW);


            rs = pstmt.executeQuery();

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
    }
    public void DelStoreInfo(String ID) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("DelInfo 연결");

            sql = "delete from store where store_id =?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ID);


            rs = pstmt.executeQuery();

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
    }
       public boolean isStore(String id) {
	boolean check = false;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select store_id from store where store_id=?";
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
    

    /**
     * @메서드이름 : blacklist
     * @작성날짜 : 21.05.29
     * @용도 : 사용자를 블랙리스트에 추가한다.
     * @author 박성호
     */
    public void blacklist(String id, String pw) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("blacklist 연결");

            sql = "update member set idx=4 where ID =? and pw = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, id);
            pstmt.setString(2, pw);

            rs = pstmt.executeQuery();

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
    }
}
