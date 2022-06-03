package DTO;

/**
 *
 * @author Nguyen
 */
public class KhachHang {
    private int id;
    private String ho;
    private String ten;
    private String diachi;
    private String phone;
    private boolean gioitinh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHo() {
        return ho;
    }

    public KhachHang(int id, String ten, String diachi, String phone, boolean gioitinh) {
        this.id = id;
        this.ten = ten;
        this.diachi = diachi;
        this.phone = phone;
        this.gioitinh = gioitinh;
    }

    public KhachHang(int id, String ho, String ten, String diachi) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
    }

    public KhachHang(String ho, String ten, String diachi, String phone, boolean gioitinh) {
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.phone = phone;
        this.gioitinh = gioitinh;
    }

    public KhachHang() {
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

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public KhachHang(int id, String ho, String ten, String diachi, String phone, boolean gioitinh) {
        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.phone = phone;
        this.gioitinh = gioitinh;
    }
    public void update(String ho, String ten, String diachi, String phone, boolean gioitinh) {
//        this.id = id;
        this.ho = ho;
        this.ten = ten;
        this.diachi = diachi;
        this.phone = phone;
        this.gioitinh = gioitinh;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }
    
    
}
