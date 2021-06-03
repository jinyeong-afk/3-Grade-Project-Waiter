/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.StatePatternTest;

import DB.ReservationDAO;
import Src.Reservation_StatePattern.FullReservation;
import Src.Reservation_StatePattern.ReservationSystem;
import Src.Reservation_StatePattern.WaitingReservation;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author qwe98
 */
public class StatePatternTest {
    
    @Test
    public void Test(){
        
        String from = "2021-05-16";
        java.sql.Date date = java.sql.Date.valueOf(from);
        
        ReservationDAO rd = new ReservationDAO();
        ReservationSystem rsPossibleReservation = new ReservationSystem("zxc123", "세진국밥", date, 4, "돼지국밥", 2, 1);
        
        rsPossibleReservation.update();
        assertEquals(rsPossibleReservation.getGuestId(), "zxc123");
        assertEquals(rsPossibleReservation.getStoreName(), "세진국밥");
        assertEquals(rsPossibleReservation.getReserveDate(), date);
        assertEquals(rsPossibleReservation.getResertime(),4);
        assertEquals(rsPossibleReservation.getMenu(),"돼지국밥");
        assertEquals(rsPossibleReservation.getAmount(), 2);
        assertEquals(rsPossibleReservation.getPayCheck(), 1);
        
        ReservationSystem rsWatingRservation = new ReservationSystem("park", "세진국밥", date, 4, "돼지국밥", 2, 1);
        rsWatingRservation.setReservationState(WaitingReservation.instance());
        rsWatingRservation.update();
        assertEquals(rsWatingRservation.getGuestId(), "park");
        assertEquals(rsWatingRservation.getStoreName(), "세진국밥");
        assertEquals(rsWatingRservation.getReserveDate(), date);
        assertEquals(rsWatingRservation.getResertime(), 4);
        assertEquals(rsWatingRservation.getMenu(),"돼지국밥");
        assertEquals(rsWatingRservation.getAmount(), 2);
        assertEquals(rsWatingRservation.getPayCheck(), 1);
        assertEquals(rd.getSequence("park", "세진국밥", date, 4), 2);
        // 인당 대기 시간을 15분으로 잡아 가게의 최대 테이블 개수 + 4까지 예약을 하며 최대 테이블을 초과하여 예약하는 경우 대기번호로 간주한다.
        
        ReservationSystem rsFullReservation = new ReservationSystem("test", "세진국밥", date, 4, "돼지국밥", 2, 1);
        rsFullReservation.setReservationState(FullReservation.instance());
        rsFullReservation.update();
        assertEquals(rd.getSequence("test", "세진국밥", date, 5), 1);
        // 예약이 불가능한 상태면 자동으로 예약을 다음 시간으로 연기하여 저장한다.
                

        
    }
}
