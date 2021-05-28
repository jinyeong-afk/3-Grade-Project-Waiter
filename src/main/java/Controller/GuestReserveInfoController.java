/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.IntroViewController.getField;
import DB.ReservationDAO;
import Src.ReservationConfirm_Observer.ReservationData;
import Src.ReservationConfirm_Observer.WaitingNumberDisplay;
import Src.ReservationConfirm_Observer.WaitingTimeDisplay;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author 박성호, 허세진
 */
public class GuestReserveInfoController implements Initializable{
    
    @FXML
    private Button btn_reserveinfo_cancle;
    @FXML
    private Label label_waitperson;
    @FXML
    private Label label_waittime;
    @FXML
    private Label label_store;
    @FXML
    private Label label_date;
    @FXML
    private Label label_time;
    @FXML
    private TextField field_reserveinfo;
    @FXML
    private ListView list_reservationmenu;
         
    private ObservableList<String> cStoreList;
    private ArrayList<String> ReservationMenu = new ArrayList<>();
    private ReservationDAO rd = new ReservationDAO();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cStoreList = FXCollections.observableArrayList();  // 배열화
        label_store.setText(rd.getReserveStoreName(IntroViewController.getField));
        label_date.setText(rd.getReserveDate(IntroViewController.getField));
        label_time.setText(Integer.toString(rd.getReserveTime(IntroViewController.getField))+"시 예약입니다");
        
        
        ReservationMenu = rd.getReservemenu(IntroViewController.getField, "menu");
        for(int i = 0; i<ReservationMenu.size(); i++){
            cStoreList.add(ReservationMenu.get(i));
            list_reservationmenu.setItems(cStoreList);
        }
        
        ReservationData reservationInfo = new ReservationData();
        WaitingNumberDisplay d2 = new WaitingNumberDisplay(reservationInfo);
        WaitingTimeDisplay d3 = new WaitingTimeDisplay(reservationInfo);
        
        try {
            reservationInfo.setReservation(IntroViewController.getField);
        } catch (SQLException ex) {
            Logger.getLogger(GuestReserveInfoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       String WaitingNumber = d2.display(getField).toString();
       String WaitingTime = d3.display(getField).toString();

       label_waitperson.setText(WaitingNumber);
       label_waittime.setText(WaitingTime);
        
       
    }
}


