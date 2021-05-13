/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
public class StoreManagerMenuManageViewController implements Initializable{
     
    @FXML
    private Button btn_menu_registor;
    @FXML
    private Button btn_menu_modify;
    @FXML
    private Button btn_menu_delete;
    @FXML
    private Button btn_store_modify;
    @FXML
    private ListView list_menuname;
    @FXML
    private ListView list_price;
    @FXML
    private TextField field_registor_menuname;
    @FXML
    private TextField field_registor_price;
    @FXML
    private TextField field_storename;
    @FXML
    private TextField field_storetel;
    @FXML
    private TextField field_storeaddress;
    @FXML
    private TextField field_storetable;
    @FXML
    private TextField field_storetable1;
    @FXML
    private TextField field_open_time;
    @FXML
    private TextField field_end_time;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
    }
}
