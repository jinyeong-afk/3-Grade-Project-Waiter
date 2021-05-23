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
 * @ 적용 패턴 : 상태 패턴, 싱글 패턴
 * @ 특징 : 상태 패턴의 객체는 싱글턴 패턴으로 이뤄져야 한다.
 * @author 박성호
 */
public class WaitingReservation implements ReservationState{
    
//    @Override
//    public boolean reservation(String Guest_id, String storename, Date date, int time, int price, int amount, String menu, int payCheck, int sequence){
//        // if false 면 예약이 불가능한 상태입니다.
//        return false;
//    }

    //Singletone
    private static WaitingReservation instance = new WaitingReservation();
    
    private WaitingReservation() {}
    
    public static WaitingReservation instance(){
        return instance;
    }
    
    // Business logic and state transition
    @Override
    public void updateState(ReservationSystem reservationSystem, String guestId, String storeName, Date reserveDate, int reserveTime, String menu, int amount, int payCheck){
        
        ReservationDAO rd = new ReservationDAO();
        if(rd.checkSequence(guestId, storeName, reserveDate, reserveTime) == 1){
            reservationSystem.setReservationState(PossibleReservation.instance());
        }else if(rd.checkSequence(guestId, storeName, reserveDate, reserveTime) == 3){
            reservationSystem.setReservationState(FullReservation.instance());
        }else{
            System.out.println("WaitingReservation");
            rd.guestReserve(guestId, storeName, reserveDate, reserveTime, menu, amount, payCheck);
            reservationSystem.setReservationState(WaitingReservation.instance());
        }
        
    }
    
}
