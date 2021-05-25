/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.collections.FXCollections;
import static Controller.IntroViewController.okWindow;
import DB.ReservationDAO;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author 박성호, 허세진
 */
public class GuestReviewController implements Initializable{

    @FXML
    private RadioButton review_score5;
    @FXML
    private RadioButton review_score4;
    @FXML
    private RadioButton review_score3;    
    @FXML
    private RadioButton review_score2;
    @FXML
    private RadioButton review_score1;
    @FXML
    private Button btn_ReviewScore;
    @FXML
    private Button btn_Reviewwrite;
    @FXML
    private TextArea textarea1_review;
    @FXML
    private ToggleGroup StoreScore;
    @FXML
    private ListView<String>  list_showreview;
    @FXML
    private ListView<String> list_reviewstorename; 
    @FXML
    private Label label_reviewstorename;
    
    private ObservableList<String> cStoreList;
    int score = 0;
    String Review;
    private ReservationDAO rd = new ReservationDAO();
    private ArrayList<String> listStoreReview = new ArrayList<>();
    private ArrayList<String> listStoreName = new ArrayList<>();
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
    
        
        cStoreList = FXCollections.observableArrayList();  // 배열화
        listStoreName = rd.getGuestReviewName(IntroViewController.getField);
        for(int i=0; i<listStoreName.size(); i++){
            cStoreList.add(listStoreName.get(i));
        }
            list_reviewstorename.setItems(cStoreList);
        
        
    StoreScore.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
    {
        @Override
        public void changed(ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1)
            {
            RadioButton chk = (RadioButton)t1.getToggleGroup().getSelectedToggle(); // Cast object to radio button
            score = Integer.parseInt(chk.getText());
            System.out.println(score);
            }
        });
    
    btn_Reviewwrite.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
               
               Review= textarea1_review.getText();
               rd.signUpReview(label_reviewstorename.getText(), IntroViewController.getField,  Review, score);
               rd.PaycheckUpdate(IntroViewController.getField, label_reviewstorename.getText(), 2);
               
               cStoreList = FXCollections.observableArrayList();  // 배열화
               listStoreName = rd.getGuestReviewName(IntroViewController.getField);
                for(int i=0; i<listStoreName.size(); i++){
                    cStoreList.add(listStoreName.get(i));
                    
                }
                list_reviewstorename.setItems(cStoreList);
        
            }
        });
    
     list_reviewstorename.setOnMouseClicked(new EventHandler<MouseEvent>() {  //리스트뷰 클릭 시 메뉴이름 텍스트박스에 출력
                @Override
                public void handle(MouseEvent event) {
                Object obj = list_reviewstorename.getSelectionModel().getSelectedItem();
                label_reviewstorename.setText(obj.toString());
                
                }
        });
     }
  }
