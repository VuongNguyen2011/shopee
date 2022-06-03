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

public class HoaDon {
    private int hoadonID;
    private int khachhangID;
    private int nhanvienID;

    private String ngaylap;
    private String tongtien;
    

    public HoaDon() {
    }
    
    public int getHoadonID() {
        return hoadonID;
    }

    public void setHoadonID(int hoadonID) {
        this.hoadonID = hoadonID;
    }

    public int getKhachhangID() {
        return khachhangID;
    }

    public void setKhachhangID(int khachhangID) {
        this.khachhangID = khachhangID;
    }

    public int getNhanvienID() {
        return nhanvienID;
    }

    public void setNhanvienID(int nhanvienID) {
        this.nhanvienID = nhanvienID;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public HoaDon(int hoadonID, int khachhangID, int nhanvienID, String ngaylap, String tongtien) {
        this.hoadonID = hoadonID;
        this.khachhangID = khachhangID;
        this.nhanvienID = nhanvienID;
        this.ngaylap = ngaylap;
        this.tongtien = tongtien;
    }
    public HoaDon(int khachhangID, int nhanvienID, String ngaylap, String tongtien) {
        this.khachhangID = khachhangID;
        this.nhanvienID = nhanvienID;
        this.ngaylap = ngaylap;
        this.tongtien = tongtien;
    }

    public HoaDon(int khachhangID) {
        this.khachhangID = khachhangID;
    }

   
}
