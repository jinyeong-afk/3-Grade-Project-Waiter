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
import javafx.scene.control.RadioButton;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 *
 * @author sejin
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
    
     
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
