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
public class product {
    private String spID;
    private String spName;
    private int soluong;
    private String laixuat;
    private String gia;
    private String mota;
    private String nccID;
    private  byte[] img;

    public product(String spID, String spName, int soluong, String laixuat, String gia, String mota, String nccID, byte[] img) {
        this.spID = spID;
        this.spName = spName;
        this.soluong = soluong;
        this.laixuat = laixuat;
        this.gia = gia;
        this.mota = mota;
        this.nccID = nccID;
        this.img = img;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public String getSpID() {
        return spID;
    }

    public void setSpID(String spID) {
        this.spID = spID;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getLaixuat() {
        return laixuat;
    }

    public void setLaixuat(String laixuat) {
        this.laixuat = laixuat;
    }

    public product(String spID, String spName, int soluong, String laixuat, String gia, String mota, String nccID) {
        this.spID = spID;
        this.spName = spName;
        this.soluong = soluong;
        this.laixuat = laixuat;
        this.gia = gia;
        this.mota = mota;
        this.nccID = nccID;
    }

    public product() {
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNccID() {
        return nccID;
    }

    public void setNccID(String nccID) {
        this.nccID = nccID;
    }

    
    
    
}
