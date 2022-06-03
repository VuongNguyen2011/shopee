package DTO;

/**
 *
 * @author Nguyen
 */
public class NhanVien {
    private String maNV;
    private String ho;
    private String ten;
    private String sdt;
    private String email;
    private boolean gioitinh;
    private String chucvu;
    private String diachi;
    private byte[] img;
    
    public NhanVien(String maNV, String ho, String ten, String sdt, String email, boolean gioitinh, String chucvu, String diachi) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.diachi = diachi;
    }
    public NhanVien(String ho, String ten, String sdt, String email, boolean gioitinh, String chucvu, String diachi) {
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.diachi = diachi;
    }
    public void update(String ho, String ten, String sdt, String email, boolean gioitinh, String chucvu, String diachi) {
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.diachi = diachi;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public NhanVien(String maNV, String ho, String ten, String sdt, String email, boolean gioitinh, String chucvu, String diachi, byte[] img) {
        this.maNV = maNV;
        this.ho = ho;
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.gioitinh = gioitinh;
        this.chucvu = chucvu;
        this.diachi = diachi;
        this.img = img;
    }
public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
    

}
