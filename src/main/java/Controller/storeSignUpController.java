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
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;


/**
 *
 * @author sejin
 */
public class storeSignUpController implements Initializable{
   
    @FXML
    private Button btn_store_idcheck;
    @FXML
    private Button btn_store_signup;
    @FXML
    private TextField field_store_signupid;
            @FXML
    private TextField field_store_signuppw;
            @FXML
    private TextField field_store_signuppwcheck;
            @FXML
    private TextField field_store_signupname;
            @FXML
    private TextField field_store_signupadress;
            @FXML
    private TextField field_store_signuptel;
            @FXML
    private TextField field_store_signupmoney;
             @FXML
    private RadioButton radiobtn_store_table;
             @FXML
    private RadioButton radiobtn_store_takeout;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
