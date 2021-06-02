/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.LoginDTO;
import Src.SignIn_StrategyPattern.GuestLoginBehavior;
import Src.SignIn_StrategyPattern.Login;
import Src.SignIn_StrategyPattern.StoreManagerLoginBehavior;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
 * @author 박성호, 허세진
 */
public class IntroViewController implements Initializable {
    
    
    @FXML
    private Button btn_login_guest; // 테스트용
    @FXML 
    private Button btn_login_manager; // 테스트용
    @FXML
    private Button btn_login_adminirastor; // 테스트용
    @FXML
    private Button btn_login;
    @FXML
    private Button btn_signup_guest;
    @FXML
    private Button btn_signup_manager;
    @FXML
    private AnchorPane login_stage;
    @FXML
    private TextField field_id;
    @FXML
    private TextField field_pw;
    
    protected static String getField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        btn_login_guest.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                Stage stage = (Stage) login_stage.getScene().getWindow();
                Parent main = null;
                
                try {
                    main = FXMLLoader.load(getClass().getResource("/fxml/GuestMainView.fxml"));
                } catch (IOException ex) {
                Logger.getLogger(GuestMainViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                okWindow();
                Scene scene = new Scene(main);
                stage.setScene(scene);
                stage.show();

            }
        }
        );
        btn_login_manager.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                Stage stage = (Stage) login_stage.getScene().getWindow();
                Parent main = null;
                
                try {
                    main = FXMLLoader.load(getClass().getResource("/fxml/StoreManagerMainView.fxml"));
                } catch (IOException ex) {
                Logger.getLogger(StoreManagerMainViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                okWindow();
                Scene scene = new Scene(main);
                stage.setScene(scene);
                stage.show();

            }
        }
        );
        
        btn_login_adminirastor.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                Stage stage = (Stage) login_stage.getScene().getWindow();
                Parent main = null;
                
                try {
                    main = FXMLLoader.load(getClass().getResource("/fxml/AdminMainView.fxml"));
                } catch (IOException ex) {
                Logger.getLogger(AdminMainViewController.class.getName()).log(Level.SEVERE, null, ex);
                }
                okWindow();
                Scene scene = new Scene(main);
                stage.setScene(scene);
                stage.show();

            }
        }
        );
        
        btn_signup_guest.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                Stage stage = (Stage) login_stage.getScene().getWindow();
                Parent main = null;
                
                try {
                    main = FXMLLoader.load(getClass().getResource("/fxml/GuestSignUp.fxml"));
                } catch (IOException ex) {
                Logger.getLogger(GuestSignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(main);
                stage.setScene(scene);
                stage.show();

            }
        }
        );
        
        btn_signup_manager.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                
                Stage stage = (Stage) login_stage.getScene().getWindow();
                Parent main = null;
                
                try {
                    main = FXMLLoader.load(getClass().getResource("/fxml/StoreSignUp.fxml"));
                } catch (IOException ex) {
                Logger.getLogger(StoreSignUpController.class.getName()).log(Level.SEVERE, null, ex);
                }
                Scene scene = new Scene(main);
                stage.setScene(scene);
                stage.show();

            }
        }
        );
        
        btn_login.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                getField = field_id.getText();
                Login storeManagerLogin = new Login(new StoreManagerLoginBehavior());
                Login guestLogin = new Login(new GuestLoginBehavior());
                Stage stage = (Stage) login_stage.getScene().getWindow();
                Parent main = null;
//                System.out.println(storeManagerLogin.unLock(field_id.getText(), field_pw.getText()));
//                System.out.println(guestLogin.unLock(field_id.getText(), field_pw.getText()));
                
                if( guestLogin.unLock(field_id.getText(), field_pw.getText()) == 1){
                    try {
                        main = FXMLLoader.load(getClass().getResource("/fxml/GuestMainView.fxml"));
                    } catch (IOException ex) {
                    Logger.getLogger(GuestMainViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    okWindow();
                    Scene scene = new Scene(main);
                    stage.setScene(scene);
                    stage.show();
                } else if( storeManagerLogin.unLock(field_id.getText(), field_pw.getText()) == 2){
                    try {
                        main = FXMLLoader.load(getClass().getResource("/fxml/StoreManagerMainView.fxml"));
                    } catch (IOException ex) {
                    Logger.getLogger(StoreManagerMainViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    okWindow();
                    Scene scene = new Scene(main);
                    stage.setScene(scene);
                    stage.show();   
                }
                 else 
                {
                 noWindow();
                }
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
        public static void noWindow() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("음식 예약 프로그램 : Waiter");
        alert.setHeaderText(null);
        alert.setContentText("ID 또는 PW를 확인하세요.");
        alert.showAndWait();
    }
}
