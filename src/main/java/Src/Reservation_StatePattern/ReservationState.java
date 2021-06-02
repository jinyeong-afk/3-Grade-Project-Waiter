/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Reservation_StatePattern;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author 박성호
 */
public interface ReservationState {
    
     void updateState(ReservationSystem reservationSystem, String guestId, String storeName, Date reserveDate, int resertime, String menu, int amount, int payCheck);
    
}
    