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
    private TextField field_reserveinfo;
    @FXML
    private ListView list_reservationmenu;
     
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
