/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.IntroViewController.getField;
import Src.ReservationConfirm_Observer.ReservationData;
import Src.ReservationConfirm_Observer.WaitingNumberDisplay;
import Src.ReservationConfirm_Observer.WaitingTimeDisplay;
import Src.ReservationConfirm_Observer.TableDisplay;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author 박성호, 허세진
 */
public class StoreOrderCheckViewController implements Initializable{
    
    @FXML
    private Button btn_table_check;
    @FXML
    private Button btn_pay_card;
    @FXML
    private Button btn_pay_cash;
    @FXML
    private ListView<String>list_now_table;
    @FXML
    private ListView list_menuname;
    @FXML
    private ListView list_price;
    @FXML
    private TextField field_total_price;
    @FXML
    private TextField field_registor_price;
    @FXML
    private TextField field_give_card;
    @FXML
    private TextField field_give_cash;
    @FXML
    private TextField field_table_check;
    private ObservableList<String> cGuestList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
          ReservationData reservationInfo = new ReservationData();
        //ReservationDisplay d1 = new ReservationDisplay(reservationInfo);
        WaitingNumberDisplay d2 = new WaitingNumberDisplay(reservationInfo);
        WaitingTimeDisplay d3 = new WaitingTimeDisplay(reservationInfo);
        TableDisplay d4 = new TableDisplay(reservationInfo);
        
        try {
            reservationInfo.setReservation(IntroViewController.getField);
        } catch (SQLException ex) {
            Logger.getLogger(StoreOrderCheckViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
          cGuestList = FXCollections.observableArrayList(); 
          
         for(int i = 0; i < d4.display(getField).size();i++){
             cGuestList.add(d4.display(getField).get(i));
         }
        list_now_table.setItems(cGuestList);
        
        
    }
}
