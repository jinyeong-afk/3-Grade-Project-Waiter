/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.MemberDAO;
import Src.SignUp_BuilderPattern.Guest;
import Src.SignUp_BuilderPattern.Member;
import Src.SignUp_BuilderPattern.MemberType;
import Src.SignUp_BuilderPattern.SignUpBuilder;
import Src.SignUp_BuilderPattern.StoreManager;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 *
 * @author 박성호, 허세진
 */
public class StoreSignUpController implements Initializable {

    @FXML
    private Button btn_store_idcheck;
    @FXML
    private Button btn_store_signup;
    @FXML
    private Button btn_goback;

    @FXML
    private TextField field_store_signupid;
    @FXML
    private PasswordField field_store_signuppw;
    @FXML
    private PasswordField field_store_signuppwcheck;
    @FXML
    private TextField field_store_signupname;
    @FXML
    private TextField field_store_signupaddress;
    @FXML
    private TextField field_store_signuptel;
    @FXML
    private TextField field_store_storetype;

    int check_id = 0; // id 체크를 위해 사용, 1인경우는 중복된 아이디가 있다.
    ArrayList<StoreManager> guest_list = new ArrayList<StoreManager>();
    MemberDAO md = new MemberDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_store_idcheck.setOnMouseClicked(new EventHandler<MouseEvent>() { // id 중복확인 체크
            @Override
            public void handle(MouseEvent event) {
                if (md.checkId(field_store_signupid.getText())) { // id가 중복이면
                    check_id = 2;
                    System.out.println("중복된 ID 입니다.");
                    setWindow("이미 존재하는 ID 입니다.");
                } else {
                    check_id = 1;
                    System.out.println("사용가능한 ID 입니다.");
                    setWindow("사용 가능한 ID 입니다.");
                }
            }
        }
        );

        btn_store_signup.setOnMouseClicked(new EventHandler<MouseEvent>() { // 회원가입
            @Override
            public void handle(MouseEvent event) {
                if (check_id == 1 & field_store_signuppw.getText().contains(field_store_signuppwcheck.getText())
                        & !(field_store_signuppwcheck.getText().equals(""))
                        & !(field_store_signupname.getText().equals(""))
                        & !(field_store_signupaddress.getText().equals(""))
                        & !(field_store_signuptel.getText().equals(""))) {
                    //& (field_store_storetype.getText().equalsIgnoreCase("forhere") || field_store_storetype.getText().equalsIgnoreCase("takeout"))){
                    Member member = new SignUpBuilder() // builder 패턴을 적용한 소스코드를 통한 회원가입 
                            .setIdx(2)
                            .setId(field_store_signupid.getText())
                            .setPw(field_store_signuppw.getText())
                            .setName(field_store_signupname.getText())
                            .setAddress(field_store_signupaddress.getText())
                            .setTel(field_store_signuptel.getText())
                            .setStoretype(field_store_storetype.getText())
                            .build(MemberType.STOREMANAGER);
                    md.signUpStoreManager(member.getIdx(), member.getId(), member.getPw(), member.getName(), member.getTel(), member.getAddress(), member.getStoretype());
                    System.out.println("회원가입이 완료되었습니다.");

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

                setWindow("회원가입이 완료되었습니다.");
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
