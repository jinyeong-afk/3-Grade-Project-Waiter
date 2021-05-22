
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.ReservationConfirm_Observer;

import DB.DTO;
import DB.ReservationDAO;
import java.util.*;
import java.util.ArrayList;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 이규철
 */
public class ReservationData implements Subject { //  업데이트 할 구체적인 예약 정보 클래스 @이규철
    private List<Observer> observers;
    private ArrayList<String> Reservations;
    private ArrayList<WaitingNumber> WaitingNumber;
    
    public ReservationData(){
    observers = new ArrayList();
    }
    
    @Override
    public void registerObserver(Observer o){ //옵저버 등록 
    observers.add(o);
    }
    
    @Override
     public void removeObserver(Observer o){ //옵저버 삭제
    int i = observers.indexOf(o);
    if(i>=0){
        observers.remove(i);
    }
    }

    @Override
     public void notifyObserver(String id) { // 옵저버 목록에 있는 녀석들 업데이트
          for(int i = 0;i<observers.size();i++){
          Observer observer = (Observer)observers.get(i);
          observer.update(Reservations, WaitingNumber, id);
          }
        }
      
      public void ReservationChanged(String id){ // 위랑 똑같음.
          notifyObserver(id);
      }
      
      public void setReservation(String Guest_id) throws SQLException{
          ReservationDAO addReser = new ReservationDAO(); // GUEST 테이블 가져와서 원하는 목록만 출력한다.
          
          this.WaitingNumber = addReser.getWaitSequence(Guest_id);
          this.Reservations = addReser.getGuestNameList(Guest_id);
          ReservationChanged(Guest_id);
          
      }
      
     /* public void removeReservation(String id) throws SQLException{ // 
        DB db = new DB();
          db.loadDB();
          String changeQuery = "delete from orders where "+id+")";//insert into reservation(store,waitingnum) values ( 'ddffgg', '"+WaitingNum+"')"; /*ddffgg -> 원래는 손님 id 
          db.changeDB(changeQuery);
          String query = "SELECT * FROM ORDERS";
          ArrayList<ReservationInformation> list = db.getReservation(query);
          
          this.Reservations = db.getReservation(query);
          
          ReservationChanged();
          db.closeDB();
      }*/
}
     
    
    


    

