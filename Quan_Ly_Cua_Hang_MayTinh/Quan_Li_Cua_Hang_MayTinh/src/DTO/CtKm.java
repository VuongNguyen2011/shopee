package DTO;

/**
 *
 * @author Nguyen
 */
public class CtKm {
    private String maMK;
    private String tenCT;
    private String loai;
    private String thoigianBD;
    private String thoigianKT;
    private String noidung;
    private String dieukien;

    public CtKm() {
    }

    public CtKm(String maMK, String tenCT, String loai, String thoigianBD, String thoigianKT, String noidung, String dieukien) {
        this.maMK = maMK;
        this.tenCT = tenCT;
        this.loai = loai;
        this.thoigianBD = thoigianBD;
        this.thoigianKT = thoigianKT;
        this.noidung = noidung;
        this.dieukien = dieukien;
    }

    public String getMaMK() {
        return maMK;
    }

    public void setMaMK(String maMK) {
        this.maMK = maMK;
    }

    public String getTenCT() {
        return tenCT;
    }

    public void setTenCT(String tenCT) {
        this.tenCT = tenCT;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getThoigianBD() {
        return thoigianBD;
    }

    public void setThoigianBD(String thoigianBD) {
        this.thoigianBD = thoigianBD;
    }

    public String getThoigianKT() {
        return thoigianKT;
    }

    public void setThoigianKT(String thoigianKT) {
        this.thoigianKT = thoigianKT;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getDieukien() {
        return dieukien;
    }

    public void setDieukien(String dieukien) {
        this.dieukien = dieukien;
    }
    
}
