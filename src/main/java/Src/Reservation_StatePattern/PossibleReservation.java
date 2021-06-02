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
 * @author 박성호
 */
public class PossibleReservation implements ReservationState {

    //Singletone 패턴을 적용하여 객체 생성
    private static PossibleReservation instance = new PossibleReservation();

    private PossibleReservation() {
    }

    public static PossibleReservation instance() {
        return instance;
    }

    @Override
    public void updateState(ReservationSystem reservationSystem, String guestId, String storeName, Date reserveDate, int reserveTime, String menu, int amount, int payCheck) {

        ReservationDAO rd = new ReservationDAO();

        System.out.println("PossibleReservation");
        rd.guestReserve(guestId, storeName, reserveDate, reserveTime, menu, amount, payCheck);  // DB를 통해 정상적으로 예약 반영

    }
}
