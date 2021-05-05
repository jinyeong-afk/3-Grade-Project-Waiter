/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author 박성호, 허세진
 */
public class copytitleController implements Initializable {
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
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
}
