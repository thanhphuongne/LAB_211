package view;

import com.sun.org.apache.xml.internal.resolver.Resolver;
import control.Control;
import java.sql.Connection;
import java.sql.Statement;
import static control.Control.getConnection;
import model.GiaoVien;
import model.SinhVien;
import util.Inputter;

public class Menu {

    private static String DB_URL = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=QuanLiSinhVien;"
            + "encryte=true;trustServerCentificate=true";
    private static String USER_NAME = "thanhphuong";
    private static String PASSWORD = "123456";

    public static void main(String[] args) {
        try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();

            Control c = new Control();
            Control.layDuLieuGiaoVien(conn, c);
            Control.layDuLieuSinhVien(conn, c);

            GiaoVien a = new GiaoVien();
            int choice;
            String s;
            do {
                a = c.dangnhap();
                if (a.getType() == 2) {
                    System.out.println("ban dang dang nhap voi tu cach la admin");
                    Control.hienThiMenu(conn, 2);
                    choice = Inputter.getInt("Lua chon cua ban");
                    switch (choice) {
                        case 1:
                            System.out.println("Ban da dang xuat thanh cong");
                            break;
                        case 2:
                            c.addStudent();
                            break;
                        case 3:
                            c.deleteStudent();
                            break;
                        case 4:
                            c.editStudent();
                            break;
                        case 5:
                            c.addTeacher();
                            break;
                        case 6:
                            c.deleteTeacher();
                            break;
                        case 7:
                            c.editTeacher();
                    }
                    s = Inputter.getString("Ban co muon thoat?");

                }
                if (a.getType() != 2) {
                    System.out.println("Ban dang dang nhap voi tu cach la giao vien");
                    Control.hienThiMenu(conn, 1);
                    choice = Inputter.getInt("lua chon cua ban");
                    switch (choice) {
                        case 1:
                            System.out.println("Ban da dang xuat thanh cong");
                            break;
                        case 2:
                            c.addStudent();
                            break;
                        case 3:
                            c.deleteStudent();
                            break;
                        case 4:
                            c.editStudent();
                            break;
                    }

                }
                s = Inputter.getString("Ban co muon thoat?");
            } while (s != "y");

            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
