/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.ReservationConfirm_Observer;

/**
 *
 * @author 이규철
 */
public interface Subject {
    public abstract void registerObserver(Observer o); // observer = guest 
    public abstract void removeObserver(Observer o); 
    public abstract void notifyObserver(String id);
}
