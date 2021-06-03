/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;


/**
 *
 * @author jin
 */
public class Run {

    /**
     * @param args the command line arguments
     */
    

    
    public static void main(String[] args) throws ParseException{
        // TODO code application logic here
 
            SimpleDateFormat dateFormat = new 
                SimpleDateFormat ("yyyy-MM-dd");
            Date now = new Date();
            
            Date date2 = dateFormat.parse("2020-01-25");
            if (now.after(date2)) {
                System.out.println(
                    "Date-1 is > Date-2");
            }
         
            
    }
    
}
