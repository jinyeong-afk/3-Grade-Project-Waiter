/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.ReservationDAO.conn;
import static DB.ReservationDAO.pstmt;
import static DB.ReservationDAO.rs;
import static DB.ReservationDAO.stmt;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @사용용도 : StoreManagerMenuManageView GUI 컨트롤
 * @author : 허세진
 */
public class StoreDAO{
    static Connection conn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static  PreparedStatement pstmt = null;
    String sql;
    
    /**
    * @메서드이름 : getMenuNameList 
    * @작성날짜 : 21.05.15
    * @용도 : 매개변수를 받은 id의 table 필드 menu를 string 배열로 반환한다..
    * @author 허세진, 박성호
    */
       public ArrayList<String> getMenuNameList(String storename){
        
        ArrayList<String> list = new ArrayList<>();
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getMenuNameList 연결");
            sql = "select menu_name from menu where store_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, storename);
            
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
    /**
    * @메서드이름 : getPriceList 
    * @작성날짜 : 21.05.15
    * @용도 : 매개변수를 받은 id의 table 필드 price를 string 배열로 반환한다..
    * @author 허세진, 박성호
    */
    public ArrayList<String> getPriceList(String storename){
        
        ArrayList<String> list = new ArrayList<>();
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getPriceList 연결");
            sql = "select menu_value from menu where store_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, storename);
            
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
    /**
    * @메서드이름 : ChangeStore 
    * @작성날짜 : 21.05.15
    * @용도 : store 테이블에서 매개변수를 받은 ID의를 검색해서 다른 매개변수들 값으로 DB를 수정한다. .
    * @author 허세진
    */
    public void ChangeStore(String ID, String storename, String storeaddress, String storetel, int open_time, int close_time, int Max){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
                System.out.println("ChangeStore 연결"); 
                
                sql = "UPDATE store SET storename = ?, storeaddress = ?, STORETELL= ?, open_time = ?, close_time = ?, MAX=? WHERE store_id ='"+ ID +"'";
                
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, storename);
                pstmt.setString(2, storeaddress);;
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
     /**
    * @메서드이름 : Changemenu
    * @작성날짜 : 21.06.03
    * @용도 : store 테이블에서 매개변수를 받은 ID의를 검색해서 다른 매개변수들 값으로 DB를 수정한다. .
    * @author 허세진
    */
    public void Changemenu(String storename, String mdstorename){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
                System.out.println("ChangeStore 연결"); 
                
                sql = "UPDATE menu SET store_name = ? WHERE store_name = ? ";
                
                
                pstmt = conn.prepareStatement(sql);
              
                pstmt.setString(1, mdstorename);
                pstmt.setString(2, storename);
         
                rs=pstmt.executeQuery();
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
    }  
    public boolean checkforhere (String id){  
	boolean check = false;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("checkforhere 연결");
            sql = "select * from member where id=? and storetype = 'forhere'";
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
    * @메서드이름 : signUpMenu 
    * @작성날짜 : 21.05.15
    * @용도 : menu 테이블에 매개변수로 받은 가게명, 메뉴명, 가격을 추가한다.  
    * @author 허세진
    */
public void signUpMenu(String store_name, String menu_name, int price){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
                System.out.println("signUpMenu 연결"); 
                
                
                sql = "insert into menu(store_name, menu_name, menu_value)";
                sql+= "values(?,?,?)";
                
                
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, store_name );
                pstmt.setString(2, menu_name);
                pstmt.setInt(3, price);
               
         
                rs=pstmt.executeQuery();
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
    }
    /**
    * @메서드이름 : Modifymenu 
    * @작성날짜 : 21.05.15
    * @용도 : menu 테이블에 매개변수로 받은 가게명, 메뉴명, 가격을 수정한다.  
    * @author 허세진
    */
    public void Modifymenu(String store_name, String menu_name, int price){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
                System.out.println("Modifymenu 연결"); 
              
 
                sql = "UPDATE menu SET menu_value=? WHERE store_name = ? and menu_name= ?";
                  
                  
                pstmt = conn.prepareStatement(sql);
               
                pstmt.setInt(1, price);
                pstmt.setString(2, store_name);
                pstmt.setString(3, menu_name);
               
               
                rs=pstmt.executeQuery();
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
    }
    /**
    * @메서드이름 : Delmenu 
    * @작성날짜 : 21.05.15
    * @용도 : 매개변수로 받은 가게이름과, 메뉴이름을 검사하고 거기에 맞는 menu 테이블 삭제.
    * @author 허세진
    */
    public void Delmenu(String store_name, String menu_name){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
                System.out.println("Delmenu 연결"); 
              
 
                sql = "delete from menu where store_name = ? and menu_name= ?";
                  
                  
                pstmt = conn.prepareStatement(sql);
             
                pstmt.setString(1, store_name);
                pstmt.setString(2, menu_name);
               
               
                rs=pstmt.executeQuery();
                
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch(Exception e) {
                e.printStackTrace();
                System.out.println("DB 로드 실패");
            }
    }
    /**
    * @메서드이름 : signUpStore 
    * @작성날짜 : 21.05.05
    * @용도 : 매개변수로 받은 ID값을 store 테이블에서 검사해서 새로운 튜블을 생성한다.
    * @author 허세진
    */
    public void signUpStore(String ID,  String storetype, String storename, String storetel, String storeaddress, int open_time, int close_time, int max){
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
                System.out.println("signUpStore 연결"); 
                
                sql = "insert into store(store_id, storename, storetell, storeaddress, open_time, close_time, max, storetype, permission)";
                sql+= "values(?,?,?,?,?,?,?,?, 0)";
                
                
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
    
    /**
    * @메서드이름 : checkRegist 
    * @작성날짜 : 21.05.03
    * @용도 : member의 id값을 검사해서 있으면 true를 리턴하고 없으면 false를 리턴 
    * @author 박성호
    */
public boolean checkRegist(String id){  
	boolean check = false;
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("check Regist 연결");
            sql = "select * from store where store_id=?";
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
    * @메서드이름 : getStringStoreInformaiton 
    * @작성날짜 : 21.05.03
    * @용도 : 매개변수를 받은 id의 필드들을 string 배열로 저장하고 반환. 
    * @author 박성호
    */
public ArrayList<String> getStringStoreInformaiton(String id) throws SQLException{

     ArrayList<String> list = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println(" getStringStoreInformaiton 연결");
            sql = "select * from store where store_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs=pstmt.executeQuery(); 
            String[] valueString = new String[4];

            
            while(rs.next()){
                valueString[0] = rs.getString(2); //storename
                valueString[1] = rs.getString(3); //storeaddress 
                valueString[2] = rs.getString(4); //storetel
                valueString[3] = rs.getString(8); //storetype
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
    /**
    * @메서드이름 : getIntStoreInformaiton 
    * @작성날짜 : 21.05.03
    * @용도 : 매개변수를 받은 id의 필드들을 int배열로 저장한다. 
    * @author 박성호
    */
        public ArrayList<Integer> getIntStoreInformaiton(String id) throws SQLException{

        ArrayList<Integer> list = new ArrayList<>();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getIntStoreInformaiton 연결");
            sql = "select * from store where store_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,id);
            rs=pstmt.executeQuery(); 

            int[] valueInt = new int[4];
            
            while(rs.next()){
                valueInt[0] = rs.getInt(5); //opentime
                valueInt[1] = rs.getInt(6); //close_time
                valueInt[2] = rs.getInt(7); //max
                valueInt[3] = rs.getInt(9); //permission
               
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
    public String getstorename(String id) {

        String value = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            //sql = "select guest_id from guest where storename = ? ";
            sql = "select storename from store where store_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                value = rs.getString(1);
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
        return value;
    }
}
