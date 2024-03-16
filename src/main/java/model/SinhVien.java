
package model;

public class SinhVien {
    private int masinhvien;
    private String hoten;
    private String diachi;
    private String sodienthoai;
    private int magiaovien;

    public SinhVien() {
    }

    public SinhVien(int masinhvien) {
        this.masinhvien = masinhvien;
    }
    

    public SinhVien(int masinhvien, String hoten, String diachi, String sodienthoai, int magiaovien) {
        this.masinhvien = masinhvien;
        this.hoten = hoten;
        this.diachi = diachi;
        this.sodienthoai = sodienthoai;
        this.magiaovien = magiaovien;
    }

    public int getMasinhvien() {
        return masinhvien;
    }

    public String getHoten() {
        return hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public int getMagiaovien() {
        return magiaovien;
    }

    public void setMasinhvien(int masinhvien) {
        this.masinhvien = masinhvien;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public void setMagiaovien(int magiaovien) {
        this.magiaovien = magiaovien;
    }

    @Override
    public String toString() {
        return masinhvien+" " +hoten+ " "+ diachi+" "+sodienthoai+" "+ magiaovien;
    }

  
    @Override
    public boolean equals(Object obj) {
        
        final SinhVien other = (SinhVien) obj;
        if (this.masinhvien != other.masinhvien) {
            return false;
        }
        return true;
    }
    
    
    
}
