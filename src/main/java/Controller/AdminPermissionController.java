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
import javafx.scene.control.Label;

/**
 *
 * @author sejin
 */
public class AdminPermissionController implements Initializable{
     @FXML
    private ListView list_permissionstore;
     @FXML
    private ListView list_permissioninfo;
     @FXML
    private ListView list_permissionmenu;
     @FXML
    private Button btn_permissionbtn;
    @FXML
    private TextField field_permissiontext;
    @FXML
    private Label Lable_AdStoreInfo;
     @FXML
    private Label Lable_AdStoremeun;
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
}
