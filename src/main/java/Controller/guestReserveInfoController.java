/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author sejin
 */
public class GuestReserveInfoController implements Initializable{
    
    @FXML
    private Button btn_reserveinfo_cancle;
    @FXML
    private Label lable_waitperson;
    @FXML
    private Label label_waittime;
    @FXML
    private ListView list_reservationinfo;
    @FXML
    private ListView list_reservationmenu;
     
     
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
  
    }
}
