/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.ReservationConfirm_Observer;

/**
 *
 * @author GGuPro
 */
public class WaitingNumber {
    //private String date;
    //private int time;
    private int sequence;
    private String StoreName;
    
    /*public String getDate() {
        return date;
    }*/

    /*public int getTime() {
        return time;
    }*/
    
    public int getSequence() {
        return sequence;
    }
    
    public String getStoreName(){
        return StoreName;
    }

    public WaitingNumber(String StoreName, int sequence) {
        //this.date = date;
        //this.time = time;
        this.sequence = sequence;
        this.StoreName=StoreName;
    }
}
