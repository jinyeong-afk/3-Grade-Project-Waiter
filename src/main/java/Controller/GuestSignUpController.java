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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 *
 * @author 박성호, 허세진
 */
public class GuestSignUpController implements Initializable{
   
    @FXML
    private Button btn_idcheck;
    @FXML
    private Button btn_signup;
    @FXML
    private Button btn_goback;
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
        
        btn_goback.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                Stage stage = (Stage) btn_goback.getScene().getWindow();
                Parent main = null;
                
                try {
                    main = FXMLLoader.load(getClass().getResource("/fxml/IntroView.fxml"));
                } catch (IOException ex) {
                Logger.getLogger(IntroViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(main);
                stage.setScene(scene);
                stage.show();

            }
        }
        );
    }
}
