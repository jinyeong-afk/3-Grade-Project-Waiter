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
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author sejin
 */
public class AdminmodifyController implements Initializable{
     @FXML
    private ListView list_adminguest;
     @FXML
    private ListView list_adminstormanager;
     @FXML
    private Button btn_adminmodify;
     @FXML
    private Button btn_admindelete;
    @FXML
    private TextField field_modifyID;
    @FXML
    private TextField field_modifyPW;
    @FXML
    private TextField feld_modifyPWcheck;
    
      @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
}
