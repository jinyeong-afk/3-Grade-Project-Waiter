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

    }

//    public String getGuestId(){
//        return guestId;
//    }
//
//    public void setGuestId(String guestId) {
//        this.guestId = guestId;
//    }
//
//    public String getStoreName() {
//        return storeName;
//    }
//
//    public void setStoreName(String storeName) {
//        this.storeName = storeName;
//    }
//
//    public Date getReserveDate() {
//        return reserveDate;
//    }
//
//    public void setReserveDate(Date reserveDate) {
//        this.reserveDate = reserveDate;
//    }
//
//    public int getResertime() {
//        return resertime;
//    }
//
//    public void setResertime(int resertime) {
//        this.resertime = resertime;
//    }
//
//    public String getMenu() {
//        return menu;
//    }
//
//    public void setMenu(String menu) {
//        this.menu = menu;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//
//    public int getPayCheck() {
//        return payCheck;
//    }
//
//    public void setPayCheck(int payCheck) {
//        this.payCheck = payCheck;
//    }
//
//
//    public ReservationState getReservationState() {
//        return reservationState;
//    }

    public void setReservationState(ReservationState reservationState) {
        this.reservationState = reservationState;
    }
    
    public void update(){
        reservationState.updateState(this, guestId, storeName, reserveDate, resertime, menu, amount, payCheck);
    }
    
}
