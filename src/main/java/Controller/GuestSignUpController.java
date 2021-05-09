/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DB.DTO;
import DB.MemberDAO;
import Src.Guest;
import Src.Member;
import Src.MemberType;
import Src.SignUpBuilder;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
    
    int check_id = 0; // id 체크를 위해 사용, 1인경우는 중복된 아이디가 있다.
    ArrayList<Guest> guest_list= new ArrayList<Guest>();
    MemberDAO md = new MemberDAO();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        btn_idcheck.setOnMouseClicked(new EventHandler<MouseEvent>() { // id 중복확인 체크
            @Override
            public void handle(MouseEvent event) {
                if(md.checkId(field_signupid.getText())){ // id가 중복이면
                    check_id = 2;
                    System.out.println("중복된 ID 입니다.");
                }else{
                    check_id = 1;
                    System.out.println("사용가능한 ID 입니다.");
                }
            }
        }
        );
        
        btn_signup.setOnMouseClicked(new EventHandler<MouseEvent>() { // 회원가입
            @Override
            public void handle(MouseEvent event) {
                if(check_id == 1 & field_signuppw.getText().contains(field_signuppwcheck.getText()) 
                        & field_signuppwcheck.getText() != null
                        & field_signupname.getText() != null
                        & field_signupadress.getText() != null
                        & field_signuptel.getText() != null
                        & field_signupmoney.getText() != null ){
                    Member member = new SignUpBuilder()  // builder 패턴을 적용한 소스코드를 통한 회원가입 
                                    .setIdx(1)
                                    .setId(field_signupid.getText())
                                    .setPw(field_signuppw.getText())
                                    .setName(field_signupname.getText())
                                    .setTel(field_signuptel.getText())
                                    .setAddress(field_signupadress.getText())
                                    .setBalance(Integer.parseInt(field_signupmoney.getText()))
                                    .build(MemberType.GUEST);
                    md.signUpGuest(member.getIdx(), member.getId(), member.getPw(), member.getName(), member.getTel(), member.getAddress(), member.getBalance());
                    System.out.println("회원가입이 완료되었습니다.");
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
}
