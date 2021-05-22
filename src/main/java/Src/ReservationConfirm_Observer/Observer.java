/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.ReservationConfirm_Observer;

import java.util.*;
import java.util.ArrayList;
/**
 *
 * @author 이규철
 */
public interface Observer {
    public abstract void update(ArrayList<String> Reservation,ArrayList<WaitingNumber> WaitingNumber, String id);
}
