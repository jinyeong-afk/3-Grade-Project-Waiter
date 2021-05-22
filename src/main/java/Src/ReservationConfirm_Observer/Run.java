/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.ReservationConfirm_Observer;


import Controller.GuestReserveController;
import Controller.GuestReserveInfoController;
import DB.ReservationDAO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author GGuPro
 */
public class Run extends GuestReserveController{

    
    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        ReservationData reservationInfo = new ReservationData();
       // WaitingNumberDisplay d2 = new WaitingNumberDisplay(reservationInfo);
       //WaitingTimeDisplay d3 = new WaitingTimeDisplay(reservationInfo);
        TableDisplay d4 = new TableDisplay(reservationInfo);
        
        reservationInfo.setReservation("asd123");
      
        //System.out.println(d2.display("qqq111").get(0));
        //System.out.println(d3.display("qqq111").get(0));
        
        for(int i = 0; i< d4.display("asd123").size();i++){
           String GuestName;
           GuestName = d4.display("asd123").get(i);
           System.out.println(GuestName+"ㅎ");
        }
        
}
}
