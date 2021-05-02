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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
/**
 *
 * @author 박성호
 */
public class IntroViewController implements Initializable {
    
    
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_guest;
    @FXML
    private Button btn_manager;
    @FXML
    private AnchorPane login_stage;
    @FXML
    private TextField field_id;
    @FXML
    private TextField field_pw;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        btn_login.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                Stage stage = (Stage) login_stage.getScene().getWindow();
                Parent main = null;
                
                try {
                    main = FXMLLoader.load(getClass().getResource("/fxml/guestMainView.fxml"));
                } catch (IOException ex) {
                Logger.getLogger(guestMainViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                okWindow();
                Scene scene = new Scene(main);
                stage.setScene(scene);
                stage.show();

            }
        }
        );
    }
        
    public static void okWindow() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("음식 예약 프로그램 : Waiter");
        alert.setHeaderText(null);
        alert.setContentText("정상적으로 로그인되었습니다.");
        alert.showAndWait();
    }
}
