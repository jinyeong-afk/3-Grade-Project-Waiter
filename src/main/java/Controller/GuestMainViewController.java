/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.LoginDTO;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author 박성호, 허세진
 */
public class GuestMainViewController implements Initializable {

    @FXML
    private Button btn_go_reserve;
    @FXML
    private Button btn_go_reserveinfo;
    @FXML
    private Button btn_go_review;
    @FXML
    private Button btn_logout;
    @FXML
    private Label label_guestname;
    @FXML
    private AnchorPane guestempty_stage;
    @FXML
    private AnchorPane reserve_stage;
    @FXML
    private AnchorPane reserveinfo_stage;
    @FXML
    private AnchorPane main_stage;
    @FXML
    private AnchorPane sub_stage;
    @FXML
    private AnchorPane third_stage;
    
    LoginDTO db = new LoginDTO();
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        try {
            label_guestname.setText(db.getname(IntroViewController.getField));
        } catch (SQLException ex) {
            Logger.getLogger(StoreManagerMainViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btn_go_reserve.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sub_stage.getChildren().remove(third_stage);
                try {
                    third_stage = FXMLLoader.load(getClass().getResource("/fxml/GuestReserve.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(GuestReserveController.class.getName()).log(Level.SEVERE, null, ex);
                }

                sub_stage.getChildren().add(third_stage);
            }
        });

        btn_go_reserveinfo.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sub_stage.getChildren().remove(third_stage);
                try {
                    third_stage = FXMLLoader.load(getClass().getResource("/fxml/GuestReserveInfo.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(GuestReserveInfoController.class.getName()).log(Level.SEVERE, null, ex);
                }

                sub_stage.getChildren().add(third_stage);
            }
        });

        btn_go_review.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                sub_stage.getChildren().remove(third_stage);
                try {
                    third_stage = FXMLLoader.load(getClass().getResource("/fxml/GuestReview.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(GuestReviewController.class.getName()).log(Level.SEVERE, null, ex);
                }

                sub_stage.getChildren().add(third_stage);
            }
        });

        btn_logout.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Stage stage = (Stage) btn_logout.getScene().getWindow();
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
