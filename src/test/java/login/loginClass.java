/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
/**
 *
 * @author jin
 */
public class loginClass {
    void login() throws SQLException // 로그인하는 함수 @송진영
    {
        
        String id, pw;
        int value;
        
        Scanner sc = new Scanner(System.in);
	System.out.println("아이디를 입력하세요: ");
	id = sc.nextLine();
        System.out.println("비밀번호를 입력하세요: ");
	pw = sc.nextLine();
        String boolquery1 = "select id from login where id = '"+id + "'";
        String boolquery2 = "select id from login where pw = '"+pw + "'";
        String intquery = "select value from login where id = '"+id + "'";
        String intvalue = "value";
        
        DB db = new DB();
        db.loadDB();
        
        if (!db.getDBBool(boolquery1) && !db.getDBBool(boolquery2)) 
        {
            value = db.getDBInt(intquery, intvalue);
            if(value == 0) System.out.println("시스템 관리자로 로그인하였습니다.");
            else if(value == 1) System.out.println("매장 관리자로 로그인하였습니다.");
            else if(value == 2) System.out.println("손님으로 로그인하였습니다.");
        }
        else System.out.println("아이디나 비번이 일치하지 않습니다.");
        
        db.closeDB();
    }
}
