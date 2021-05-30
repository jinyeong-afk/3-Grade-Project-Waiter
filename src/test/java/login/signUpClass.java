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
public class signUpClass {
    void signUp() throws SQLException // 회원가입 하는 함수 @송진영
    {
        String id, pw;
        int value;
        Scanner sc = new Scanner(System.in);
	System.out.println("아이디를 입력하세요: ");
	id = sc.nextLine();
        System.out.println("비밀번호를 입력하세요: ");
	pw = sc.nextLine();
        System.out.println("권한을 입력하세요(0: 시스템관리자, 1: 매장관리자, 2: 손님): ");
	value = sc.nextInt();
        
        String boolquery = "select id from login where id = '"+id + "'";
        String changequery = "insert into login( id , pw , value ) values( '" + id + "' , '" + pw + "' , '" + value + "' )";
        DB db = new DB();
        db.loadDB();
        if (db.getDBBool(boolquery)) 
        {
            db.changeDB(changequery);
            System.out.println("아이디가 생성되었습니다.");
        }
        else System.out.println("중복된 아이디가 존재합니다.");
        
        db.closeDB();
    }
}
