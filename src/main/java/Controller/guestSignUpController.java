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
/**
 *
 * @author sejin
 */
public class GuestSignUpController implements Initializable{
   
    @FXML
    private Button btn_idcheck;
    @FXML
    private Button btn_signup;
    @FXML
    private TextField field_signupid;
    @FXML
    private TextField field_signuppw;
    @FXML
    private TextField field_signuppwcheck;
    @FXML
    private TextField field_signupname;
    @FXML
    private TextField field_signupadress;
    @FXML
    private TextField field_signuptel;
    @FXML
    private TextField field_signupmoney;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
