/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;



/**
 * @date : 2021.05.04 
 * @용도 :  손님용 GUI 컨트롤러 
 * @author : sejin
 */
public class GuestMainViewController implements Initializable{
    @FXML
    private Button btn_go_reserve;
    @FXML
    private Button btn_go_reserveinfo;
    @FXML
    private Button btn_go_review;
    @FXML
    private Button btn_guestlogout;
    @FXML
    private Label Label_guestname;
    @FXML
    private AnchorPane guestempty_stage;
    @FXML
    private AnchorPane reserve_stage;
    @FXML
    private AnchorPane reserveinfo_stage;
    @FXML
    private AnchorPane review_stage;
    @FXML
    private AnchorPane guest_stage;

      
 @Override
    public void initialize(URL url, ResourceBundle rb) {

      
    
    }
}
