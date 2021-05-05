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

/**
 *
 * @author sejin
 */
public class AdminMainViewController implements Initializable{
     @FXML
    private Button btn_permisson;
     @FXML
    private Button btn_userinfomodify;
     @FXML
    private Button btn_adminlogout;
     @FXML
    private AnchorPane Adminempty_stage;
    @FXML
    private AnchorPane adminmodify_stage;
    @FXML
    private AnchorPane AdminPermission_stage;
      @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
}
