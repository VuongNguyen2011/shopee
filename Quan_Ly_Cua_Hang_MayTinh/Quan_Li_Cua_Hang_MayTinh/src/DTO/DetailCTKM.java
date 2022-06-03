package DTO;

/**
 *
 * @author Nguyen
 */
public class DetailCTKM {
    private String maCT;
    private String maSP;
    private String hinhThuc;

    public DetailCTKM(String maCT, String maSP, String hinhThuc) {
        this.maCT = maCT;
        this.maSP = maSP;
        this.hinhThuc = hinhThuc;
    }

    public DetailCTKM() {
    }

    public String getMaCT() {
        return maCT;
    }

    public void setMaCT(String maCT) {
        this.maCT = maCT;
    }

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }
    
    
    
}
