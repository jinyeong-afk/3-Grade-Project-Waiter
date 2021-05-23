/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Reservation_StatePattern;

import DB.ReservationDAO;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author qwe98
 */
public class PossibleReservation implements ReservationState{
  
//    @Override
//    public boolean reservation(String Guest_id, String storename, Date date, int time, int price, int amount, String menu, int payCheck, int sequence){
//        ReservationDAO rd = new ReservationDAO();
//        rd.guestReserve(Guest_id, storename, date, time, price, amount, menu, payCheck);
//        return true;
//    }
    
    //Singletone
    private static PossibleReservation instance = new PossibleReservation();
    
    private PossibleReservation() {}
    
    public static PossibleReservation instance(){
        return instance;
    }
    
    @Override
    public void updateState(ReservationSystem reservationSystem, String guestId, String storeName, Date reserveDate, int reserveTime, String menu, int amount, int payCheck){
        
        ReservationDAO rd = new ReservationDAO();
        if(rd.checkSequence(guestId, storeName, reserveDate, reserveTime) == 3){
                                    
            System.out.println("FullReservation");
            reservationSystem.setReservationState(FullReservation.instance());
            reservationSystem.update();
        }
        else if(rd.checkSequence(guestId, storeName, reserveDate, reserveTime) == 2){
                        
            System.out.println("WaitingReservation");
            reservationSystem.setReservationState(WaitingReservation.instance());
            reservationSystem.update();
        }else{
            
            System.out.println("PossibleReservation");
            rd.guestReserve(guestId, storeName, reserveDate, reserveTime, menu, amount, payCheck);
//            reservationSystem.setReservationState(PossibleReservation.instance());
        }
    }
}
