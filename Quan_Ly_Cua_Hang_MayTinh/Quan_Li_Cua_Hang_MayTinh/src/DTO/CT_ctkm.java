package DTO;

/**
 *
 * @author Nguyen
 */
public class CT_ctkm {
    private String ct_ctkmID;
    private String sanphamID;
    private String ctkmID;
    private String hinhthuc;

    public CT_ctkm() {
    }

    public CT_ctkm(String ct_ctkmID, String sanphamID, String ctkmID, String hinhthuc) {
        this.ct_ctkmID = ct_ctkmID;
        this.sanphamID = sanphamID;
        this.ctkmID = ctkmID;
        this.hinhthuc = hinhthuc;
    }
    public CT_ctkm( String ctkmID,String sanphamID, String hinhthuc) {
        this.sanphamID = sanphamID;
        this.ctkmID = ctkmID;
        this.hinhthuc = hinhthuc;
    }

    public String getCt_ctkmID() {
        return ct_ctkmID;
    }

    public void setCt_ctkmID(String ct_ctkmID) {
        this.ct_ctkmID = ct_ctkmID;
    }

    public String getSanphamID() {
        return sanphamID;
    }

    public void setSanphamID(String sanphamID) {
        this.sanphamID = sanphamID;
    }

    public String getCtkmID() {
        return ctkmID;
    }

    public void setCtkmID(String ctkmID) {
        this.ctkmID = ctkmID;
    }

    public String getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(String hinhthuc) {
        this.hinhthuc = hinhthuc;
    }
    
}
