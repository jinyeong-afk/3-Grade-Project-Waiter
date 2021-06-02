/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static DB.DTO.rs;
import Src.ReservationConfirm_Observer.WaitingNumber;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author 박성호
 */
public class ReservationDAO {

    static public Connection conn;
    static Statement stmt = null;
    static ResultSet rs = null;
    static PreparedStatement pstmt = null;
    String sql;

    /**
     * @메서드이름 : getStoreNameList
     * @작성날짜 : 21.05.23
     * @용도 : 최종 관리자가 허가된 매장의 이름을 출력
     * @author 허세진
     */
    public ArrayList<String> getStoreNameList() {

        ArrayList<String> list = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select storename from store where permission = 1";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            String value = "";
            while (rs.next()) {
                value = rs.getString(1);
                list.add(value);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }

    public ArrayList<String> getStoreNameList(int permission) {

        ArrayList<String> list = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select storename from store where permission =" + permission;
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            String value = "";
            while (rs.next()) {
                value = rs.getString(1);
                list.add(value);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }

    /**
     * @메서드이름 : getWaitSequence
     * @작성날짜 : 21.05.5
     * @용도 : 대기 순번을 뽑아온다.
     * @author 이규철
     */
    public ArrayList getWaitSequence(String id) throws SQLException {
        ArrayList<WaitingNumber> list = new ArrayList<>();
        WaitingNumber W;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select storename, wait_sequence from guest where guest_id = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {

                W = new WaitingNumber(rs.getString(1), rs.getInt(2));
                list.add(W);
            }

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }

    /**
     * @메서드이름 : signUpReview
     * @작성날짜 : 21.05.23
     * @용도 : 가게 리뷰 등록
     * @author 허세진
     */
    public void signUpReview(String store_name, String guest_id, String review, int score) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");

            sql = "insert into store_review(store_name, guest_id, review, score, review_count)";
            sql += "values(?,?,?,?,(SELECT COUNT(*)+1 from store_review where store_name=?))";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, store_name);
            pstmt.setString(2, guest_id);
            pstmt.setString(3, review);
            pstmt.setInt(4, score);
            pstmt.setString(5, store_name);

            rs = pstmt.executeQuery();

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
    }

    /**
     * @메서드이름 : getStoreNameList
     * @작성날짜 : 21.05.23
     * @용도 : 최종 관리자가 허가된 매장의 이름을 출력
     * @author 허세진
     */
    public ArrayList<String> getReservemenu(String id, String field) {

        ArrayList<String> list = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select " + field + " from guest where guest_id = ?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            String value = "";
            while (rs.next()) {
                value = rs.getString(1);
                list.add(value);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }

    /**
     * @메서드이름 : getReserveDate
     * @작성날짜 : 21.05.23
     * @용도 : 예약한 날짜 반환.
     * @author 허세진
     */
    public String getReserveDate(String id) {

        String value = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getReserveDate 연결");
            //sql = "select guest_id from guest where storename = ? ";
            sql = "select DISTINCT TO_CHAR(reservation_date, 'YYYY-MM-DD') from guest where guest_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                value = rs.getString(1);
            }

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return value;
    }

    /**
     * @메서드이름 : getReserveTime
     * @작성날짜 : 21.05.23
     * @용도 : 예약한 시간 반환
     * @author 허세진
     */
    public int getReserveTime(String id) {

        int value = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            //sql = "select guest_id from guest where storename = ? ";
            sql = "select DISTINCT reservation_time from guest where guest_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
                value = rs.getInt(1);
            }

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return value;
    }

    /**
     * @메서드이름 : getReserveStoreName
     * @작성날짜 : 21.05.23
     * @용도 : 사용자가 예약한 식당 반환.
     * @author 허세진
     */
    public String getReserveStoreName(String id) {

        String value = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            //sql = "select guest_id from guest where storename = ? ";
            sql = "select DISTINCT storename from guest where guest_id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                value = rs.getString(1);
            }

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return value;
    }

    /**
     * @메서드이름 : getGuestReviewName
     * @작성날짜 : 21.05.23
     * @용도 : 결제가 완료되서 리뷰를 사용할 매장들을 반환해준다.
     * @author 허세진
     */
    public ArrayList<String> getGuestReviewName(String id) {

        ArrayList<String> list = new ArrayList<>();
        String value = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            //sql = "select guest_id from guest where storename = ? ";
            sql = "select DISTINCT storename from guest where guest_id = ? and pay_check = 1";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                value = rs.getString(1);
                list.add(value);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }

    /**
     * @메서드이름 : getMenuNameList
     * @작성날짜 : 21.05.5
     * @용도 : 가게 메뉴리스트를 뽑아온다.
     * @author 박성호
     */
    public ArrayList<String> getMenuNameList(String storename) {

        ArrayList<String> list = new ArrayList<>();

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getMenuNameList 연결");
            sql = "select storename,storeaddress,storetell from store where storename = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, storename);

            rs = pstmt.executeQuery();
            String value = "";
            while (rs.next()) {
                for (int i = 1; i < 4; i++) {
                    value = rs.getString(i);
                    list.add(value);
                }
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }

    /**
     * @메서드이름 : getGuestNameList
     * @작성날짜 : 21.05.5
     * @용도 : 손님 이름을 뽑아온다.
     * @author 박성호
     */
    public ArrayList<String> getGuestNameList(String id) {

        ArrayList<String> list = new ArrayList<>();
        String value = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            //sql = "select guest_id from guest where storename = ? ";
            sql = "select distinct(guest_id) from( select * from store join guest using (storename)) where store_id = ? and pay_check = 0";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                value = rs.getString(1);
                list.add(value);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }

    /**
     * @메서드이름 : guestReserve
     * @작성날짜 : 21.05.18
     * @용도 : 손님이 매장을 예약할때 값을 DB로 넘겨준다.
     * @author 박성호
     */
    public void guestReserve(String Guest_id, String storename, Date date, int time, String menu, int amount, int payCheck) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");;
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("guestReserve 연결");

            int sequence = getSequence(Guest_id, storename, date, time);
            int price = getMenuPrice(storename, menu);
            System.out.println(sequence);
            sql = "insert into guest(guest_id, storename, reservation_date, reservation_time, menu, price, amount, pay_check, wait_sequence)";
            sql += "values(?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Guest_id);
            pstmt.setString(2, storename);
            pstmt.setDate(3, date);
            pstmt.setInt(4, time);
            pstmt.setString(5, menu);
            pstmt.setInt(6, price);
            pstmt.setInt(7, amount);
            pstmt.setInt(8, payCheck);
            pstmt.setInt(9, sequence);
            rs = pstmt.executeQuery();
            if (rs != null) {
                rs.close();
                System.out.println("guestReserve1 닫기");
            }
            if (stmt != null) {
                stmt.close();
                System.out.println("guestReserve2 닫기");
            }
            if (conn != null) {
                conn.close();
                System.out.println("guestReserve3 닫기");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("guestReserve DB 로드 실패");
        }
    }
    /**
     * @메서드이름 : guestWaitReserve
     * @작성날짜 : 21.05.18
     * @용도 : 손님이 매장을 예약할때 값을 DB로 넘겨준다.
     * @author 박성호
     */
    public void guestWaitReserve(String Guest_id, String storename, Date date, int time, String menu, int amount, int payCheck) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");;
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("guestReserve 연결");

            int sequence = getSequence(Guest_id, storename, date, time);
            int price = getMenuPrice(storename, menu);
            System.out.println(sequence);
            if (sequence < sequence + 4) {
                sql = "insert into guest(guest_id, storename, reservation_date, reservation_time, menu, price, amount, pay_check, wait_sequence)";
                sql += "values(?,?,?,?,?,?,?,?,?)";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, Guest_id);
                pstmt.setString(2, storename);
                pstmt.setDate(3, date);
                pstmt.setInt(4, time);
                pstmt.setString(5, menu);
                pstmt.setInt(6, price);
                pstmt.setInt(7, amount);
                pstmt.setInt(8, payCheck);
                pstmt.setInt(9, sequence);
                rs = pstmt.executeQuery();
                if (rs != null) {
                    rs.close();
                    System.out.println("guestWaitReserve 닫기");
                }
                if (stmt != null) {
                    stmt.close();
                    System.out.println("guestWaitReserve 닫기");
                }
                if (conn != null) {
                    conn.close();
                    System.out.println("guestWaitReserve 닫기");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("guestWaitReserve DB 로드 실패");
        }

    }

    /**
     * @메서드이름 : guestFullReserve
     * @작성날짜 : 21.05.20
     * @용도 : 예약이 가득찬 경우, 다음 시간으로 자동으로 예약해준다.
     * @author 박성호
     */
    public void guestFullReserve(String Guest_id, String storename, Date date, int time, String menu, int amount, int payCheck) {
        int sequence = 0;
        int closeTime = 0;
        int price = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("guestFullReserve 연결");
//                closeTime = getStoreCloseTime(storename);
            sequence = getSequence(Guest_id, storename, date, time + 1);
            price = getMenuPrice(storename, menu);
            if (getStoreCloseTime(storename) > time) {

                sql = "insert into guest(guest_id, storename, reservation_date, reservation_time, menu, price, amount, pay_check, wait_sequence)";
                sql += "values(?,?,?,?,?,?,?,?,?)";

                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, Guest_id);
                pstmt.setString(2, storename);
                pstmt.setDate(3, date);
                pstmt.setInt(4, time + 1);
                pstmt.setString(5, menu);
                pstmt.setInt(6, price);
                pstmt.setInt(7, amount);
                pstmt.setInt(8, payCheck);
                pstmt.setInt(9, sequence);

                rs = pstmt.executeQuery();

                if (rs != null) {
                    rs.close();
                    System.out.println("guestFullReserve 닫기");
                }
                if (stmt != null) {
                    stmt.close();
                    System.out.println("guestFullReserve 닫기");
                }
                if (conn != null) {
                    conn.close();
                    System.out.println("guestFullReserve 닫기");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("guestFullReserve DB 로드 실패");
        }
    }

    /**
     * @메서드이름 : getSequence
     * @작성날짜 : 21.05.18
     * @용도 : 해당 가게의 같은 날짜 같은 시간대의 마지막 순서를 추출한다.
     * @author 박성호
     */
    public int getSequence(String guest_id, String storename, Date date, int time) {

        int sequence = 0;

        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getSequence 연결");
            sql = "select count(*) from (select distinct wait_sequence from guest where guest_id not in ? and storename = ? and reservation_date = ? and  reservation_time = ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guest_id);
            pstmt.setString(2, storename);
            pstmt.setDate(3, date);
            pstmt.setInt(4, time);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                sequence = rs.getInt(1) + 1;
            }
//            if (rs != null) {
//                rs.close();
//                System.out.println("guestSequence1 닫기");
//            }
//            if (pstmt != null) {
//                pstmt.close();
//                System.out.println("guestSequence2 닫기");
//            }
//            if (conn != null) {
//                conn.close();
//                System.out.println("guestSequence3 닫기");
//            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getSequence DB 로드 실패");
        }

        return sequence;
    }
 /**
     * @메서드이름 : getMax
     * @작성날짜 : 21.05.20
     * @용도 :  매장의 최대 테이블 개수를 가져온다..
     * @author 박성호
     */
    public int getMax(String storename) {

        int max = 0;

        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getMax 연결");

            sql = "select max from store where storename = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, storename);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                max = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getMax DB 로드 실패");
        }

        return max;
    }

    /**
     * @메서드이름 : checkSequence
     * @작성날짜 : 21.05.20
     * @용도 : 예약이 가능한지 순서를 확인한다.
     * @author 박성호
     */
    public int checkSequence(String guest_id, String storename, Date date, int time) {

        int sequence = 0;
        int max = 0;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("checkSequence 연결");
            sequence = getSequence(guest_id, storename, date, time);

            sql = "select max from store where storename = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, storename);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                max = rs.getInt(1);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("checkSequence DB 로드 실패");
        }

        if (sequence <= max) {
            return 1;  // 예약 완료
        } else if (max < sequence && sequence <= max + 4) {
            return 2;  // 대기 번호 부여
        } else {
            return 3;  // 다음시간으로 이월
        }
    }

    /**
     * @메서드이름 : getStoreCloseTime
     * @작성날짜 : 21.05.20
     * @용도 : 마감시간 이후에는 예약이 되지 않도록 해당 가게의 마감시간을 가져온다.
     * @author 박성호
     */
    private int getStoreCloseTime(String storename) {

        int closeTime = 0;

        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getStoreCloseTime 연결");
            sql = "select close_time from store where storename = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, storename);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                closeTime = rs.getInt(1);
            }
//            if (rs != null) {
//                rs.close();
//            }
//            if (stmt != null) {
//                stmt.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getStoreCloseTime DB 로드 실패");
        }

        return closeTime;
    }

    /**
     * @메서드이름 : getStoreCloseTime
     * @작성날짜 : 21.05.20
     * @용도 : GUI에 영업시간을 입력받기 위해 사용
     * @author 박성호
     */
    public ArrayList<Integer> getStoreOperatertime(String storename) {

        int Time = 0;
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getStoreCloseTime 연결");
            sql = "select open_time, close_time from store where storename = ? ";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, storename);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                Time = rs.getInt(1);
                list.add(Time);
                Time = rs.getInt(2);
                list.add(Time);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getStoreCloseTime DB 로드 실패");
        }

        return list;
    }

    /**
     * @메서드이름 : getMenuPrice
     * @작성날짜 : 21.05.20
     * @용도 : 메뉴에 대한 가격을 가져온다.
     * @author 박성호
     */
    private int getMenuPrice(String storename, String menu) {

        int price = 0;
        try {
//            Class.forName("oracle.jdbc.driver.OracleDriver");
//            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("getMenuPrice 연결");
            sql = "select menu_value from menu where store_name = ?  and menu_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, storename);
            pstmt.setString(2, menu);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                price = rs.getInt(1);
            }
//            if (rs != null) {
//                rs.close();
//            }
//            if (stmt != null) {
//                stmt.close();
//            }
//            if (conn != null) {
//                conn.close();
//            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("getMenuPrice DB 로드 실패");
        }

        return price;
    }

    /**
     * @메서드이름 : getStoreScore
     * @작성날짜 : 21.05.23
     * @용도 : 가게 리뷰 출력
     * @author 허세진
     */

    public ArrayList<String> getStoreReview(String store_name) {

        ArrayList<String> list = new ArrayList<>();
        String value = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select review from store_review where store_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, store_name);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                value = rs.getString(1);
                list.add(value);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }

    /**
     * @메서드이름 : PaycheckDel
     * @작성날짜 : 21.05.25
     * @용도 : PaycheckDel
     * @author 허세진
     */
    public void PaycheckDel(String guest_id, String storename) {

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("PaycheckUpdate 연결");

            sql = "DELETE FROM guest where guest_id= ? and storename=?";

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, guest_id);
            pstmt.setString(2, storename);

            rs = pstmt.executeQuery();

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
    }

    /**
     * @메서드이름 : getStoreScore
     * @작성날짜 : 21.05.23
     * @용도 : 가게 평점 출력
     * @author 허세진
     */
    public ArrayList<String> getStoreScore(String store_name) {

        ArrayList<String> list = new ArrayList<>();
        String value = "";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select score from store_review where store_name = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, store_name);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                value = Integer.toString(rs.getInt(1));
                list.add(value);
            }
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return list;
    }

    public int getStoreMaxTable(String id) {
        //ArrayList<Integer> list = new ArrayList<>();
        int value = 0;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@sedb.deu.ac.kr:1521:orcl", "a20173192", "20173192");
            System.out.println("연결");
            sql = "select max from store where storename = '" + id + "'";

            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                value = rs.getInt(1);
            }

            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("DB 로드 실패");
        }
        return value;
    }

}
