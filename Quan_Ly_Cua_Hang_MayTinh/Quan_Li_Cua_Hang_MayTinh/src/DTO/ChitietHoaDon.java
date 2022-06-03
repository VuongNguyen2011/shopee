/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nguyen
 */
public class ChitietHoaDon {
    private String ctmaHD;
    private String mahd;
    private String maSP;
//    private String tenSP;
    private String soluong;
    private String dongia;
    private String tongtien;
    private String tiengiamgia;
    private String thanhtien;

    public ChitietHoaDon(String ctmaHD, String mahd, String maSP, String soluong, String dongia, String tongtien, String tiengiamgia, String thanhtien) {
        this.ctmaHD = ctmaHD;
        this.mahd = mahd;
        this.maSP = maSP;
        this.soluong = soluong;
        this.dongia = dongia;
        this.tongtien = tongtien;
        this.tiengiamgia = tiengiamgia;
        this.thanhtien = thanhtien;
    }

    public ChitietHoaDon(String mahd, String maSP, String soluong, String dongia, String tongtien, String tiengiamgia, String thanhtien) {
        this.mahd = mahd;
        this.maSP = maSP;
        this.soluong = soluong;
        this.dongia = dongia;
        this.tongtien = tongtien;
        this.tiengiamgia = tiengiamgia;
        this.thanhtien = thanhtien;
    }

    

   

    public ChitietHoaDon() {
    }

    public String getMahd() {
        return mahd;
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getCtmaHD() {
        return ctmaHD;
    }

    public void setCtmaHD(String ctmaHD) {
        this.ctmaHD = ctmaHD;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public String getTiengiamgia() {
        return tiengiamgia;
    }

    public void setTiengiamgia(String tiengiamgia) {
        this.tiengiamgia = tiengiamgia;
    }


    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getDongia() {
        return dongia;
    }

    public void setDongia(String dongia) {
        this.dongia = dongia;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }
    
}
