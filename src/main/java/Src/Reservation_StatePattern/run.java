/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.Reservation_StatePattern;

import DB.ReservationDAO;
import static java.lang.String.format;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author 박성호
 */
public class run {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        String from = "2021-05-16";
        java.sql.Date d = java.sql.Date.valueOf(from);
        
        ReservationDAO rd = new ReservationDAO();
        //        rd.guestReserve( "test1234", "고기집", d, 3, "닭고기", 9000, 2, 0);
        //ReservationSystem(String guestId, String storeName, Date reserveDate, int reserveTime, String menu, int amount, int payCheck)
        ReservationSystem rs = new ReservationSystem("zxc123", "세진국밥", d, 4, "돼지국밥", 2, 1);
        
        rs.setReservationState(FullReservation.instance());
        rs.update();
        
    }

}
