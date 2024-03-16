
package model;

public class GiaoVien {
    private int magiaovien;
    private String hoten;
    private String diachi ;
    private String matkhau ;
    private String sodienthoai;
    private String monhoc ;
    private int type;

    public GiaoVien() {
    }

    public GiaoVien(int magiaovien, String hoten, String diachi, String matkhau, String sodienthoai, String monhoc, int type) {
        this.magiaovien = magiaovien;
        this.hoten = hoten;
        this.diachi = diachi;
        this.matkhau = matkhau;
        this.sodienthoai = sodienthoai;
        this.monhoc = monhoc;
        this.type = type;
    }

    public GiaoVien(int magiaovien) {
        this.magiaovien = magiaovien;
    }

    public GiaoVien(int magiaovien, String matkhau) {
        this.magiaovien = magiaovien;
        this.matkhau = matkhau;
    }

    
    

    public int getMagiaovien() {
        return magiaovien;
    }

    public String getHoten() {
        return hoten;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public String getSodienthoai() {
        return sodienthoai;
    }

    public String getMonhoc() {
        return monhoc;
    }

    public int getType() {
        return type;
    }
    
    

    public void setMagiaovien(int magiaovien) {
        this.magiaovien = magiaovien;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }

    public void setMonhoc(String monhoc) {
        this.monhoc = monhoc;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return  magiaovien  + hoten + diachi  + matkhau  + sodienthoai  + monhoc  + type ;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final GiaoVien other = (GiaoVien) obj;
        if (this.magiaovien != other.magiaovien) {
            return false;
        }
        return true;
    }
    
    
    
}
