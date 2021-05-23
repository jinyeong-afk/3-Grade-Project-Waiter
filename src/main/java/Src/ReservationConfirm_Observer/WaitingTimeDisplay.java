/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.ReservationConfirm_Observer;

import DB.ReservationDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GGuPro
 */
public class WaitingTimeDisplay implements Observer, DisplayElement {

    ReservationDAO rd = new ReservationDAO();
    private ArrayList<String> Reservations;
    private ArrayList<WaitingNumber> WaitingNumber;
    private Subject ReservationInfo; // observer 에서 탈퇴할 일이 생긴다면 유용하게 활용

    // 생성자에 subject 객체를 전달하고, 그 객체를 사용하여 디스플레이를 옵저버로 등록
    public WaitingTimeDisplay(Subject ReservationInfo) {
        this.ReservationInfo = ReservationInfo;
        ReservationInfo.registerObserver(this);
    }

    public void update(ArrayList<String> Reservation, ArrayList<WaitingNumber> WaitingNum, String id) {
        this.Reservations = Reservation;
        this.WaitingNumber = WaitingNum;
        display(id);
    }

    public ArrayList<String> display(String id) {
        ArrayList<String> waitingTime = new ArrayList<>();

        int MaxTable = 0;
        MaxTable = rd.getStoreMaxTable(WaitingNumber.get(0).getStoreName());
        int WaitingTime = WaitingNumber.get(0).getSequence();

        if (WaitingTime > MaxTable) {
            WaitingTime = (WaitingTime - MaxTable) * 15;
            String WaitingT = Integer.toString(WaitingTime);
            waitingTime.add(WaitingT);
        } else {
            String yet = "0";
            waitingTime.add(yet);
        }

        return waitingTime;
    }

}
