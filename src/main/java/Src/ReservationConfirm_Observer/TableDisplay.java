/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Src.ReservationConfirm_Observer;

import Controller.GuestReserveController;
import DB.ReservationDAO;
import Src.ReservationConfirm_Observer.DisplayElement;
import Src.ReservationConfirm_Observer.Observer;
import Src.ReservationConfirm_Observer.Subject;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
/**
 *
 * @author 이규철
 */
 public class TableDisplay  extends GuestReserveController implements Observer,DisplayElement {
          ReservationDAO rd = new ReservationDAO();
          private ArrayList<String> Reservations;
          private final Subject ReservationData; // observer 에서 탈퇴할 일이 생긴다면 유용하게 활용
          
           // 생성자에 subject 객체를 전달하고, 그 객체를 사용하여 디스플레이를 옵저버로 등록
          public TableDisplay(Subject ReservationInfo){
              this.ReservationData = ReservationInfo;
              ReservationInfo.registerObserver(this);
              
          }
          
          @Override
          public void update(ArrayList<String> Reservation, ArrayList<WaitingNumber> WaitingNumber, String id){
              this.Reservations = Reservation;
              display(id);
              System.out.println("성공");
          }
        
           @FXML Label lable_waitperson;
          public ArrayList<String> display(String id){
              
              ArrayList<String> list = new ArrayList<>();
              
              for(int i=0; i<Reservations.size();i++){
              String table = Reservations.get(i).toString();
              list.add(table);
          }
               return list;
         }
 }
