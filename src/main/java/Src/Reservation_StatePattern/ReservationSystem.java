/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Reservation_StatePattern;

import DB.ReservationDAO;
import java.sql.Date;

/**
 *
 * @author 박성호
 */
public class ReservationSystem {
    
    private String guestId;
    private String storeName;
    private Date reserveDate;
    private int resertime;
    private String menu;
    private int price;
    private int amount;
    private int payCheck;
            
    private ReservationState reservationState;

    public ReservationSystem(String guestId, String storeName, Date reserveDate, int reserveTime, String menu, int amount, int payCheck) {
        this.guestId = guestId;
        this.storeName = storeName;
        this.reserveDate = reserveDate;
        this.resertime = reserveTime;
        this.menu = menu;
        this.amount = amount;
        this.payCheck = payCheck;
        
        setReservationState(PossibleReservation.instance());

    }

    public void setReservationState(ReservationState reservationState) {
        this.reservationState = reservationState;
    }
    
    public void update(){
        reservationState.updateState(this, guestId, storeName, reserveDate, resertime, menu, amount, payCheck);
    }
    
}
