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
public class FullReservation implements ReservationState {

    private static FullReservation instance = new FullReservation();

    private FullReservation() {
    }

    public static FullReservation instance() {
        return instance;
    }

    @Override
    public void updateState(ReservationSystem reservationSystem, String guestId, String storeName, Date reserveDate, int reserveTime, String menu, int amount, int payCheck) {

        ReservationDAO rd = new ReservationDAO();

        System.out.println("fullREservation");
        rd.guestFullReserve(guestId, storeName, reserveDate, reserveTime, menu, amount, payCheck);

    }
}
