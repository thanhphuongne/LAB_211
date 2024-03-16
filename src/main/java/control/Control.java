package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;
import model.GiaoVien;
import model.SinhVien;
import util.Inputter;

public class Control {

    public ArrayList<SinhVien> arrS = new ArrayList();
    public ArrayList<GiaoVien> arrG = new ArrayList();

    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connection failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    
    
    // dang nhap
    public GiaoVien dangnhap() {
        int magiaovien;
        int flag;
        GiaoVien a = new GiaoVien();
        do {
            flag = 1;
            magiaovien = Inputter.getInt("nhap ma giao vien");
            String matkhau = Inputter.getString("Nhập mật khẩu: ");
            a.setMagiaovien(magiaovien);
            a.setMatkhau(matkhau);
            if(magiaovien==111)
            {
                a.setType(2);
            }
            for (int i = 0; i < arrG.size(); i++) {
                if (arrG.contains(a)) {
                    flag = 0;
                }
            }
        } while (flag == 1);
        return a;
    }

    //lấy dữ liệu sinh vien
    public static void layDuLieuSinhVien(Connection conn, Control c) {
        try {
            java.sql.Statement stsm = conn.createStatement();
            java.sql.ResultSet rs = stsm.executeQuery("SELECT * FROM SinhVien");
            while (rs.next()) {
                int masinhvien = rs.getInt("masinhvien");
                String hoten = rs.getString("hoten");
                String diachi = rs.getString("diachi");
                String sodienthoai = rs.getString("sodienthoai");
                int magiaovien = rs.getInt("magiaovien");
                c.arrS.add(new SinhVien(masinhvien, hoten, diachi, sodienthoai, magiaovien));
            }
        } catch (Exception e) {
        }
    }

    //lấy dữ liệu giáo viên
    public static void layDuLieuGiaoVien(Connection conn, Control c) {
        try {
            java.sql.Statement stsm = conn.createStatement();
            java.sql.ResultSet rs = stsm.executeQuery("SELECT * FROM GiaoVien");
            while (rs.next()) {
                int magiaovien = rs.getInt("magiaovien");
                String hoten = rs.getString("hoten");
                String diachi = rs.getString("diachi");
                String matkhau = rs.getString("matkhau");
                String sodienthoai = rs.getString("sodienthoai");
                String monhoc = rs.getString("monhoc");
                int theloai = rs.getInt("theloai");
                c.arrG.add(new GiaoVien(magiaovien, hoten, diachi, matkhau, sodienthoai, monhoc, magiaovien));
            }
        } catch (Exception e) {
        }
    }
    
    //hien thi menu
    public static void hienThiMenu(Connection conn, int x)
    {
        try {
            java.sql.Statement stsm = conn.createStatement();
            java.sql.ResultSet rs = stsm.executeQuery("SELECT* FROM Menu");
            while (rs.next()) {
                int id = rs.getInt("id");
                String choose = rs.getString("choose");
                int position = rs.getInt("position");
                if(x ==1)
                {
                    if(position ==1||id==1)
                        System.out.println(id+"."+choose);                                    
                } else if(x==2)
                        System.out.println(id+"."+choose);
            }
        } catch (Exception e) {
        }
    }
    // Student 
    //add student

    public void addStudent() {

        int id = Inputter.getInt("ID");
        SinhVien s = new SinhVien(id);
        if (arrS.contains(s)) {
            System.out.println("Id had exitted");
            return;
        }
        s.setHoten(Inputter.getString("name"));
        s.setDiachi(Inputter.getString("Address"));
        s.setSodienthoai(Inputter.getString("SDT"));
        s.setMagiaovien(Inputter.getInt("ma giao vien"));
        arrS.add(s);
    }

    //delete student
    public void deleteStudent() {
        int id = Inputter.getInt("nhap id sinh vien muon xoa");
        SinhVien s = new SinhVien(id);
        if (arrS.contains(s)) {
            arrS.remove(arrS.indexOf(s));
            return;
        }
        System.out.println("ID khong ton tai");

    }

    //edit student
    public void editStudent() {
        SinhVien st = new SinhVien();
        int id = Inputter.getInt("nhap id sinh vien muon edit");
        st.setMasinhvien(id);
        arrS.get(arrS.indexOf(st)).setHoten(Inputter.getString("New name"));
        arrS.get(arrS.indexOf(st)).setMagiaovien(Inputter.getInt("ma giao vien"));
        arrS.get(arrS.indexOf(st)).setDiachi(Inputter.getString("address"));
        arrS.get(arrS.indexOf(st)).setSodienthoai(Inputter.getString("phone"));

    }

    //show student
    public void showStudent() {
        for (SinhVien s : arrS) {
            System.out.println(s);
        }
    }

    // Teacher 
    public void addTeacher() {

        int id = Inputter.getInt("nhap ma giao vien");
        GiaoVien s = new GiaoVien(id);
        if (arrG.contains(s)) {
            System.out.println("ma giao vien da ton tai");
            return;
        }
        s.setHoten(Inputter.getString("name"));
        s.setDiachi(Inputter.getString("Address"));
        s.setMatkhau(Inputter.getString("nhap mat khau moi"));
        s.setSodienthoai(Inputter.getString("SDT"));
        s.setMonhoc(Inputter.getString("mon hoc"));
        arrG.add(s);
    }

    //delete teacher
    public void deleteTeacher() {
        int id = Inputter.getInt("nhap id giao vien muon xoa");
        GiaoVien s = new GiaoVien(id);
        if (arrS.contains(s)) {
            arrS.remove(arrG.indexOf(s));
            return;
        }
        System.out.println("ID khong ton tai");

    }

    //edit teacher
    public void editTeacher() {
        GiaoVien st = new GiaoVien();
        int id = Inputter.getInt("nhap magiaovien cho giao vien muon sua");
        st.setMagiaovien(id);
        arrG.get(arrG.indexOf(st)).setHoten(Inputter.getString("New name"));
        arrG.get(arrG.indexOf(st)).setDiachi(Inputter.getString("address"));
        arrG.get(arrG.indexOf(st)).setMatkhau(Inputter.getString("nhap mat khau moi"));
        arrG.get(arrG.indexOf(st)).setSodienthoai(Inputter.getString("phone"));
        arrG.get(arrG.indexOf(st)).setMonhoc(Inputter.getString("mon hoc"));
        arrG.get(arrG.indexOf(st)).setType(Inputter.getInt("nhap type moi"));
    }

}
