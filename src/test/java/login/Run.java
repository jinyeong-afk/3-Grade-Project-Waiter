/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.sql.SQLException;
import java.util.Scanner;


/**
 *
 * @author jin
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    

    
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        signUpClass su = new signUpClass();
        loginClass li = new loginClass();
        
        int value = 0;
        
        Scanner sc = new Scanner(System.in);
        while(true)
        {
            System.out.println("(0: 회원가입, 1: 로그인, 2: 종료): ");
            value = sc.nextInt();
            if(value == 0)
            {
                su.signUp();
            }
            else if(value == 1)
            {
                li.login();
            }
            else if(value == 2)
            {
                System.out.println("종료");
                break;
            }
            else
            {
                System.out.println("다시 입력해주세요");
                continue;
            }
        }
        
    }
    
}
