package DTO;

/**
 *
 * @author Nguyen
 */
public class top_sanpham {
    private String topspID;
    private String sanphamID;
    private String soluong;
    private String ngay;
    private String thanhtien;

    public String getTopspID() {
        return topspID;
    }

    public void setTopspID(String topspID) {
        this.topspID = topspID;
    }

    public String getSanphamID() {
        return sanphamID;
    }

    public void setSanphamID(String sanphamID) {
        this.sanphamID = sanphamID;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }

    

    public top_sanpham() {
    }

    public top_sanpham(String topspID, String sanphamID, String soluong, String ngay, String thanhtien) {
        this.topspID = topspID;
        this.sanphamID = sanphamID;
        this.soluong = soluong;
        this.ngay = ngay;
        this.thanhtien = thanhtien;
    }

    public top_sanpham(String sanphamID, String soluong, String ngay, String thanhtien) {
        this.sanphamID = sanphamID;
        this.soluong = soluong;
        this.ngay = ngay;
        this.thanhtien = thanhtien;
    }
    
    
}
