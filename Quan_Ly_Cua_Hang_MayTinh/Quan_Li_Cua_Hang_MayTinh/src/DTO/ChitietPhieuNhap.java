package DTO;

/**
 *
 * @author Nguyen
 */
public class ChitietPhieuNhap {
    private String phieunhapctID;
    private String phieunhapID;
    private String sanphamID;
    private String soluong;
    private String thanhtien;

    public String getPhieunhapctID() {
        return phieunhapctID;
    }

    public void setPhieunhapctID(String phieunhapctID) {
        this.phieunhapctID = phieunhapctID;
    }

    public String getPhieunhapID() {
        return phieunhapID;
    }

    public void setPhieunhapID(String phieunhapID) {
        this.phieunhapID = phieunhapID;
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

    public String getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(String thanhtien) {
        this.thanhtien = thanhtien;
    }

    public ChitietPhieuNhap(String phieunhapctID, String phieunhapID, String sanphamID, String soluong, String thanhtien) {
        this.phieunhapctID = phieunhapctID;
        this.phieunhapID = phieunhapID;
        this.sanphamID = sanphamID;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public ChitietPhieuNhap(String phieunhapID, String sanphamID, String soluong, String thanhtien) {
        this.phieunhapID = phieunhapID;
        this.sanphamID = sanphamID;
        this.soluong = soluong;
        this.thanhtien = thanhtien;
    }

    public ChitietPhieuNhap() {
    }
    
}
