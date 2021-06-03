/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import static Controller.StoreSignUpController.setWindow;
import DB.DTO;
import DB.MemberDAO;
import Src.SignUp_BuilderPattern.GuestBuilder;
import Src.SignUp_BuilderPattern.SignUpProduct;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar.Builder;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author 박성호, 허세진
 */
public class GuestSignUpController implements Initializable {

    @FXML
    private Button btn_idcheck;
    @FXML
    private Button btn_signup;
    @FXML
    private Button btn_goback;
    @FXML
    private TextField field_signupid;
    @FXML
    private PasswordField field_signuppw;
    @FXML
    private PasswordField field_signuppwcheck;
    @FXML
    private TextField field_signupname;
    @FXML
    private TextField field_signupadress;
    @FXML
    private TextField field_signuptel;
    @FXML
    private TextField field_signupmoney;

    int check_id = 0; // id 체크를 위해 사용, 1인경우는 중복된 아이디가 있다.
    MemberDAO md = new MemberDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_idcheck.setOnMouseClicked(new EventHandler<MouseEvent>() { // id 중복확인 체크
            @Override
            public void handle(MouseEvent event) {
                if (md.checkId(field_signupid.getText())) { // id가 중복이면
                    check_id = 2;
                    setWindow("이미 존재하는 ID 입니다.");
                    System.out.println("중복된 ID 입니다.");
                } else {
                    check_id = 1;
                    setWindow("사용 가능한 ID 입니다.");
                    System.out.println("사용가능한 ID 입니다.");
                }
            }
        }
        );

        btn_signup.setOnMouseClicked(new EventHandler<MouseEvent>() { // 회원가입
            @Override
            public void handle(MouseEvent event) {
                if (check_id == 1 & field_signuppw.getText().contains(field_signuppwcheck.getText())
                        & !(field_signuppwcheck.getText().equals(""))
                        & !(field_signupname.getText().equals(""))
                        & !(field_signupadress.getText().equals(""))
                        & !(field_signuptel.getText().equals(""))
                        & !(field_signupmoney.getText().equals(""))) {
                   SignUpProduct guestBuilder= new GuestBuilder()
                             .setBalance(Integer.parseInt(field_signupmoney.getText()))
                             .setIdx(1)
                             .setId(field_signupid.getText())
                             .setPw(field_signuppw.getText())
                             .setName(field_signupname.getText())
                             .setTel(field_signuptel.getText())
                             .setAddress(field_signupadress.getText())
                             .build();
                    guestBuilder.SignUp(1);
                    System.out.println("회원가입이 완료되었습니다.");  
                    setWindow("회원가입이 완료되었습니다.");
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
                  else if(check_id == 0){
                 setWindow("ID 중복 체크를 해주세요");
                }
                else
                {
                    setWindow("빈 공간 없이 입력해주세요");
                }
            }
        }
        );

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

    public static void setWindow(String text) { // String 매개 변수를 받아 메시지창을 띄우는 함수
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("음식 예약 프로그램 : Waiter");
        alert.setHeaderText(null);
        alert.setContentText(text);
        alert.showAndWait();
    }
}
