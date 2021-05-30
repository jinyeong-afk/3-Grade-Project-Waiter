/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.TemplateMethodPattern;

/**
 *
 * @author 박성호
 */
public class Administrator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         DeleteTask dt = new DeleteTask();
         BlackListTask bt = new BlackListTask();
         ModifyTask mt = new ModifyTask();
         
//         dt.batchTask("aa", "aa1123");

//        mt.batchTask("qqq", "1234");
    }
    
}
