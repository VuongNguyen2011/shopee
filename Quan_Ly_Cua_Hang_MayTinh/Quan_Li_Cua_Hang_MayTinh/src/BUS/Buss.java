package BUS;


import DAL.ConnectSQL;
import DAL.ConnectUnit;
import DTO.CT_ctkm;
import DTO.ChitietPhieuNhap;
import DTO.CtKm;
import DTO.HoaDon;
import DTO.KhachHang;
import DTO.Ncc;
import DTO.NhanVien;
import DTO.PhieuNhap;
import DTO.product;
import DTO.ChitietPhieuNhap;
import DTO.ChitietHoaDon;
import DTO.Users;
import DTO.top_sanpham;
import GUI.FormLogin;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.compress.utils.IOUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen
 */
public class Buss {
    ConnectSQL dal = new ConnectSQL();
    ConnectUnit sql = new ConnectUnit();
    importData importData1 = new importData();
    Report rp = new Report();
    
    ResultSet rs = null;

    public ArrayList<NhanVien> getDsnv() {
        return dsnv;
    }

    public void setDsnv(ArrayList<NhanVien> dsnv) {
        this.dsnv = dsnv;
    }
    
    ArrayList<KhachHang> dskh = new ArrayList<KhachHang>();
    ArrayList<HoaDon> dshd = new ArrayList<HoaDon>();
    ArrayList<ChitietHoaDon> dshdCT = new ArrayList<ChitietHoaDon>();
    ArrayList<NhanVien> dsnv = new ArrayList<NhanVien>();
    ArrayList<CtKm> dCtkm = new ArrayList<CtKm>();
    ArrayList<CT_ctkm> dsCtkm_ct = new ArrayList<CT_ctkm>();
    ArrayList<top_sanpham> dstopSanPham = new ArrayList<top_sanpham>();

    public Report getRp() {
        return rp;
    }

    public void setRp(Report rp) {
        this.rp = rp;
    }

    public ArrayList<top_sanpham> getDstopSanPham() {
        return dstopSanPham;
    }

    public void setDstopSanPham(ArrayList<top_sanpham> dstopSanPham) {
        this.dstopSanPham = dstopSanPham;
    }

    public ArrayList<ChitietHoaDon> getDshdCT() {
        return dshdCT;
    }

    public void setDshdCT(ArrayList<ChitietHoaDon> dshdCT) {
        this.dshdCT = dshdCT;
    }
    ArrayList<product> dsProduct = new ArrayList<product>();
    ArrayList<Ncc> dsNcc = new ArrayList<Ncc>();
    ArrayList<PhieuNhap> dsPhieuNhap = new ArrayList<PhieuNhap>();
    ArrayList<ChitietPhieuNhap> dsPhieuNhapCT = new ArrayList<ChitietPhieuNhap>();

    public ArrayList<ChitietPhieuNhap> getDsPhieuNhapCT() {
        return dsPhieuNhapCT;
    }

    public void setDsPhieuNhapCT(ArrayList<ChitietPhieuNhap> dsPhieuNhapCT) {
        this.dsPhieuNhapCT = dsPhieuNhapCT;
    }

    public ArrayList<PhieuNhap> getDsPhieuNhap() {
        return dsPhieuNhap;
    }

    public void setDsPhieuNhap(ArrayList<PhieuNhap> dsPhieuNhap) {
        this.dsPhieuNhap = dsPhieuNhap;
    }

    public ArrayList<product> getDsProduct() {
        return dsProduct;
    }

    public void setDsProduct(ArrayList<product> dsProduct) {
        this.dsProduct = dsProduct;
    }

    public ArrayList<CT_ctkm> getDsCtkm_ct() {
        return dsCtkm_ct;
    }
    
    public void setDsCtkm_ct(ArrayList<CT_ctkm> dsCtkm_ct) {
        this.dsCtkm_ct = dsCtkm_ct;
    }

    public ArrayList<CtKm> getdCtkm() {
        return dCtkm;
    }

    public void setdCtkm(ArrayList<CtKm> dCtkm) {
        this.dCtkm = dCtkm;
    }

    public  ArrayList<KhachHang> getDskh() {
        return dskh;
    }

    public  void setDskh(ArrayList<KhachHang> dskh) {
        this.dskh = dskh;
    }

//    public  ArrayList<KhachHang> getDsfind() {
//        return dsfind;
//    }
//
//    public  void setDsfind(ArrayList<KhachHang> dsfind) {
//        Buss.dsfind = dsfind;
//    }
    

    public ArrayList <HoaDon> getHoaDon() throws SQLException{
        dshd.clear();
        rs = sql.select("hoadon");
        while (rs.next()) {            
            dshd.add(new HoaDon(rs.getInt("hoadonID"),rs.getInt("khachhangID"),rs.getInt("nhanvienID"),rs.getString("ngaylap"),rs.getString("tongtien")));
        }
        return dshd;
    }
    public ArrayList <ChitietHoaDon> getHoaDonCT() throws SQLException{
        dshdCT.clear();
        rs = sql.select("chitiethoadon");
        while (rs.next()) {            
            dshdCT.add(new ChitietHoaDon(rs.getString("cthoadonID"),rs.getString("hoadonID"),rs.getString("sanphamID"),rs.getString("soluong"),rs.getString("dongia"),rs.getString("tongtien"),rs.getString("tiengiamgia"),rs.getString("thanhtien")));
        }
        return dshdCT;
    }
    public ArrayList <ChitietHoaDon> getHoaDonCTMaHd(String mahd) throws SQLException{
        ArrayList <ChitietHoaDon> ds = new ArrayList<>();
        rs = sql.select("chitiethoadon","hoadonID = '"+mahd+"'");
        while (rs.next()) {            
            ds.add(new ChitietHoaDon(rs.getString("cthoadonID"),rs.getString("hoadonID"),rs.getString("sanphamID"),rs.getString("soluong"),rs.getString("dongia"),rs.getString("tongtien"),rs.getString("tiengiamgia"),rs.getString("thanhtien")));
        }
        return ds;
    }
    public ArrayList <PhieuNhap> getPhieuNhaps() throws SQLException{
        dsPhieuNhap.clear();
        rs = sql.select("phieunhap");
        while (rs.next()) {            
            dsPhieuNhap.add(new PhieuNhap(rs.getString("phieunhapID"),rs.getString("nhanvienID"),rs.getString("nccID"),rs.getString("tongtien"),rs.getString("ngay")));
        }
        return dsPhieuNhap;
    }
    public ArrayList <top_sanpham> getTop_sanphams() throws SQLException{
        dstopSanPham.clear();
        rs = sql.select("top_sanpham");
        while (rs.next()) {            
            dstopSanPham.add(new top_sanpham(rs.getString("Top_spID"),rs.getString("sanphamID"),rs.getString("soluong"),rs.getString("ngay"),rs.getString("thanhtien")));
        }
        return dstopSanPham;
    }
    public ArrayList <ChitietPhieuNhap> get_CT_PhieuNhaps(String mapn) throws SQLException{
        dsPhieuNhapCT.clear();
        rs = sql.select("phieunhap_chitiet","phieunhapID = '"+mapn+"'");
        while (rs.next()) {            
            dsPhieuNhapCT.add(new ChitietPhieuNhap(rs.getString("phieunhapctID"),rs.getString("phieunhapID"),rs.getString("sanphamID"),rs.getString("soluong"),rs.getString("thanhtien")));
        }
        return dsPhieuNhapCT;
    }
    public ArrayList <product> get_CT_PhieuNhapsMoi(String mapn) throws SQLException{
        rs = sql.selectCT_phieunhap(mapn);
        ArrayList <product> ds = new ArrayList<>();
        while (rs.next()) {            
             ds.add(new product(String.valueOf(rs.getInt("sanphamID")),rs.getString("sanphamName"),rs.getInt("slpn"),rs.getString("lai"),rs.getString("price"),rs.getString("mota"),rs.getString("nccID"),rs.getBytes("img")));
        }
        return ds;
    }
    
    public ArrayList <product> getProducts() throws SQLException{
        dsProduct.clear();
        rs = sql.select("product");
        while (rs.next()) {            
            dsProduct.add(new product(String.valueOf(rs.getInt("sanphamID")),rs.getString("sanphamName"),rs.getInt("soluong"),rs.getString("lai"),rs.getString("price"),rs.getString("mota"),rs.getString("nccID"),rs.getBytes("img")));
        }
        return dsProduct;
    }
    public ArrayList <product> get_PN_Products() throws SQLException{
        dsProduct.clear();
        rs = sql.select("product");
        while (rs.next()) {            
            dsProduct.add(new product(String.valueOf(rs.getInt("sanphamID")),rs.getString("sanphamName"),rs.getInt("soluong"),rs.getString("lai"),rs.getString("price"),rs.getString("mota"),rs.getString("nccID"),rs.getBytes("img")));
        }
        return dsProduct;
    }
    public ArrayList <Ncc> getNccs() throws SQLException{
        dsNcc.clear();
        rs = sql.select("ncc");
        while (rs.next()) {            
            dsNcc.add(new Ncc(rs.getString("nccID"),rs.getString("nccName"),rs.getString("sdt"),rs.getString("email"),rs.getString("diachi")));
        }
        return dsNcc;
    }
    
    public ArrayList <KhachHang> getKhachHangs() throws SQLException{
        dskh.clear();
        rs = sql.select("khachhang");
        while (rs.next()) {            
            dskh.add(new KhachHang(rs.getInt("khID"),rs.getString("hoKH"),rs.getString("tenKH"),rs.getString("diachi"),rs.getString("phone"),rs.getBoolean("gioitinh")));
        }
        return dskh;
    }
    public ArrayList <CtKm> getCtKms() throws SQLException{
        dCtkm.clear();
        rs = sql.select("ctkm");
        while (rs.next()) {            
            dCtkm.add(new CtKm(String.valueOf(rs.getInt("ctkmID")),rs.getString("ctkmName"),rs.getString("loai"),rs.getString("timeBD"),rs.getString("timeKT"),rs.getString("noidung"),rs.getString("dieukien")));
        }
        return dCtkm;
    }
    public ArrayList <CT_ctkm> getCT_ctkms() throws SQLException{
        
        dsCtkm_ct.clear();
        rs = sql.select("ctkm_chitiet");
        while (rs.next()) {            
            dsCtkm_ct.add(new CT_ctkm (String.valueOf(rs.getInt("kmctID")),String.valueOf(rs.getInt("ctkmID")),(rs.getString("maCode")),rs.getString("hinhthuc")));
        }
        return dsCtkm_ct;
    }
    
    public ArrayList <NhanVien> getNhanViens() throws SQLException{
        dsnv.clear();
        rs = sql.select("nhanvien");
        while (rs.next()) {     
            dsnv.add(new NhanVien(String.valueOf(rs.getInt("nvID")),rs.getString("hoNV"),rs.getString("tenNV"),rs.getString("sdt"),rs.getString("email"),rs.getBoolean("gioitinh"),rs.getString("chucvu"),rs.getString("diachi"),rs.getBytes("img")));
        }
        return dsnv;
    }
   
    public  KhachHang getByID(int id) throws SQLException{

         for(KhachHang kh : dskh){
             if(kh.getId() == id) return kh;
         }
         return null;
    }

    public ConnectSQL getDal() {
        return dal;
    }

    public void setDal(ConnectSQL dal) {
        this.dal = dal;
    }

    public ConnectUnit getSql() {
        return sql;
    }

    public void setSql(ConnectUnit sql) {
        this.sql = sql;
    }

    public importData getImportData1() {
        return importData1;
    }

    public void setImportData1(importData importData1) {
        this.importData1 = importData1;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public ArrayList<HoaDon> getDshd() {
        return dshd;
    }

    public void setDshd(ArrayList<HoaDon> dshd) {
        this.dshd = dshd;
    }

    public Buss() throws SQLException {
        dskh = getKhachHangs();
        dshd = getHoaDon();
        dsnv = getNhanViens();
    }
    
     // ======================================== ============== =================================================
    // =========================================== LOGIN =====================================================
    
        public String checkLogin(String user, String pass) throws SQLException{
            String s = "`user` = '" + user + "' AND `pass` = '"+ pass+"'";
//            System.out.println(s);
             rs = sql.select("users",s);
             if(rs.next()){
                 return rs.getString("nhanvienID");
             }
             return "";
        }
       
    
    // ========================================== LOGIN END =================================================
    // ======================================== ============== =================================================

    
    // ========================= Khach Hang =====================================
    
    public KhachHang findMa(int mskh) {
        for (KhachHang kh : dskh) {
            if (kh.getId()==(mskh)) {
                return kh;
            }
        }
        return null;
    }
   

    public ArrayList<KhachHang> findHo(String ho) throws SQLException {
       
        ArrayList<KhachHang> ds = new ArrayList<>();
        for (KhachHang kh : dskh) {
            if (kh.getHo().indexOf(ho) >= 0) {
                ds.add(kh);
            }
        }
        return ds;    
    }
    public ArrayList<KhachHang> findMa1(int ma) throws SQLException {
        ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
//        ds = null;
        ds.add(findMa(ma));
        return ds;    
    }
    

    public  ArrayList<KhachHang> findTen(String ten) throws SQLException {
//       dskh = getKhachHangs();
    ArrayList<KhachHang> ds = new ArrayList<>();
//        ds = null;
        for (KhachHang kh : dskh) {
            if (kh.getTen().indexOf(ten) >= 0) {
                ds.add(kh);
            }
        }
        return ds;
    }
    public  ArrayList<KhachHang> finddiachi(String diachi1) throws SQLException {
       dskh = getKhachHangs();
    ArrayList<KhachHang> ds = new ArrayList<>();
//        ds = null;
        for (KhachHang kh : dskh) {
            if (kh.getDiachi().toLowerCase().indexOf(diachi1.toLowerCase()) >= 0 ) {
                ds.add(kh);
            }
        }
        return ds;
    }
    public  ArrayList<KhachHang> findphone(String phone) throws SQLException {
    ArrayList<KhachHang> ds = new ArrayList<>();
    
    for (KhachHang kh : dskh) {
            if (kh.getPhone().indexOf(phone)>=0) {
//                System.out.println(Integer.parseInt(kh.getTotal()));
                ds.add(kh);
            }
        }
        return ds;
    }
    
    public ArrayList<KhachHang> readExcel(String name) throws IOException{
        return importData1.readExcel(name);
    }
    public boolean updateKH(KhachHang kh) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("hoKH", kh.getHo());
        list.put("tenKH",kh.getTen());
        list.put("diachi",kh.getDiachi());
        list.put("phone", kh.getPhone());
        int z = 0;
        if(kh.isGioitinh()){
            z=1;
        }
        list.put("gioitinh", z);
        return sql.update("khachhang", list, "khID = "+kh.getId());
    }
    public boolean deleteKH(int id) throws SQLException{
        return sql.delete("khachhang", "khID = "+id);
    }
    public boolean insertKhachHang(KhachHang kh) throws SQLException, IOException{
       HashMap<String,Object> list = new HashMap<String,Object>();
       list.put("hoKH", kh.getHo());
        list.put("tenKH",kh.getTen());
        list.put("diachi",kh.getDiachi());
        list.put("phone", kh.getPhone());
        int z = 0;
        if(kh.isGioitinh()){
            z=1;
        }
        list.put("gioitinh", z);
        return sql.insert("khachhang", list);
    }
    public boolean checkSDTKH(String sdt) throws SQLException{
        rs = sql.select("khachhang"," phone = '"+sdt+"'");
        if(rs.next()){
            return false;
        }
        return true;
    }
    // ======================================== KHACH HANG END =================================================
    // ======================================== ============== =================================================
    // =========================================== HOA DON =====================================================
    public ArrayList<HoaDon> findMaHD(String ma) throws SQLException {
       
        ArrayList<HoaDon> ds = new ArrayList<>();
        for (HoaDon kh : dshd) {
            if (String.valueOf(kh.getHoadonID()).indexOf(ma) >= 0) {
                ds.add(kh);
            }
        }
        return ds;    
    }
    public boolean insertHoaDon(HoaDon hd) throws SQLException, IOException{
       HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("khachhangID", hd.getKhachhangID());
        list.put("nhanvienID",hd.getNhanvienID());
        list.put("ngaylap",hd.getNgaylap());
        list.put("tongtien","");
       
//        
        return sql.insert("hoadon", list);
    }
    public boolean update_Tien_HoaDon(String id,String sum) throws SQLException, IOException{
       HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("tongtien", sum);
       
//        
        return sql.update("hoadon", list," hoadonID = '"+id+"'");
    }
    public ResultSet loadComboxNVBH() throws SQLException{
        return rs = sql.select("nhanvien");
        
    }
    public ResultSet loadComboxNcc() throws SQLException{
        return rs = sql.select("ncc");
        
    }
    
    public String getMaHd(String manv,String makh) throws SQLException{
        rs = sql.select("hoadon","khachhangID = "+makh+" AND nhanvienID = " +manv+" ","hoadonID DESC LIMIT 1");
        if(rs.next()){
            return rs.getString("hoadonID");
        }
        return "3";
    }
    
    
    
    
    // ========================================== HOA DON END =================================================
    // ======================================== ============== =================================================
    // ======================================== ============== =================================================
    // =========================================== HOA DON CT =====================================================
    
    public boolean insertHoaDonCT(ChitietHoaDon hd) throws SQLException, IOException{
       HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("hoadonID", hd.getMahd());
        list.put("sanphamID",hd.getMaSP());
        list.put("soluong",hd.getSoluong());
        list.put("dongia",hd.getDongia());
        list.put("tongtien",hd.getTongtien());
        list.put("tiengiamgia",hd.getTiengiamgia());
        list.put("thanhtien",hd.getThanhtien());
    
        return sql.insert("chitiethoadon", list);
    }
    public boolean inserspTOP(top_sanpham hd) throws SQLException, IOException{
       HashMap<String,Object> list = new HashMap<String,Object>();
    
        list.put("sanphamID",hd.getSanphamID());
        list.put("soluong",hd.getSoluong());
        list.put("ngay",hd.getNgay());
        list.put("thanhtien",hd.getThanhtien());
    
        return sql.insert("top_sanpham", list);
    }
    
    // ========================================== HOA DON CT END =================================================
    // ======================================== ============== =================================================
    // ============================================ NHAN VIEN =========================================
    
    public ArrayList<String> getManvArray() throws SQLException{
        ArrayList<String> ds = new ArrayList<>();
        rs = sql.select("nhanvien");
        while (rs.next()) {            
            ds.add(rs.getString("nvID"));
        }
        return ds;
    } 
    public int getTongTienNv(String manvString, String t) throws SQLException{
        
        String x = sql.thongkeNhanVien(manvString,t);

        if(x!=null){
            return Integer.parseInt(x);
        }
        return 0;
    }
    
    public NhanVien findMaNv(int msnv) {
        for (NhanVien kh : dsnv) {
            if (kh.getMaNV()==String.valueOf((msnv))) {
                return kh;
            }
        }
        return null;
    }
    public ResultSet loadComboxNV() throws SQLException{
        return rs = sql.select("chucvu");
        
    }
 
    public ArrayList<NhanVien> findHoNV(String ho) throws SQLException {
       
        ArrayList<NhanVien> ds = new ArrayList<>();
        for (NhanVien nv : dsnv) {
            if (nv.getHo().indexOf(ho) >= 0) {
                ds.add(nv);
            }
        }
        return ds;    
    }
    public String getChucvu(String name) throws SQLException{
        rs = sql.select("chucvu","chucvuName = '" + name+"'");
        if(rs.next()){
            return (rs.getString("chucvuID"));
        }
        return "2";
    }
    public String getChucvuName(String id) throws SQLException{
        rs = sql.select("chucvu","chucvuID = '" + id+"'");
        if(rs.next()){
            return (rs.getString("chucvuName"));
        }
        return "Nhân Viên";
    }
    public ArrayList<NhanVien> findMa1nv(int ma) throws SQLException {
        ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
        for (NhanVien nv : dsnv) {
            if (nv.getMaNV().indexOf(String.valueOf(ma)) >= 0) {
                ds.add(nv);
                break;
            }
        }
        return ds;     
    }
    

    public  ArrayList<NhanVien> findTenNV(String ten) throws SQLException {

    ArrayList<NhanVien> ds = new ArrayList<>();

        for (NhanVien nv : dsnv) {
            if (nv.getTen().indexOf(ten) >= 0) {
                ds.add(nv);
            }
        }
        return ds;
    }
    public  ArrayList<HoaDon> findHoadon(String ma) throws SQLException {

    ArrayList<HoaDon> ds = new ArrayList<>();

        for (HoaDon nv : dshd) {
            if (String.valueOf(nv.getHoadonID()).indexOf(ma) >= 0) {
                ds.add(nv);
            }
        }
        return ds;
    }
    public  ArrayList<NhanVien> findchucvuNV(String cv) throws SQLException {

    ArrayList<NhanVien> ds = new ArrayList<>();
//        ds = null;
        for (NhanVien nv : dsnv) {
            if (nv.getChucvu().toLowerCase().indexOf(cv.toLowerCase()) >= 0 ) {
                ds.add(nv);
            }
        }
        return ds;
    }
    public  ArrayList<NhanVien> findphoneNV(String phone) throws SQLException {
    ArrayList<NhanVien> ds = new ArrayList<>();
    
    for (NhanVien nv : dsnv) {
            if (nv.getSdt().indexOf(phone)>=0) {
//                System.out.println(Integer.parseInt(kh.getTotal()));
                ds.add(nv);
            }
        }
        return ds;
    }
    
    
    public boolean insertNV(NhanVien nv,InputStream img) throws SQLException, IOException{
      return sql.insertIMGNV(nv, img);
    }
    
//    public boolean updateNV(InputStream img) throws SQLException{
//        
//    }
    
    public boolean updateNV(NhanVien nv, InputStream img) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
//        byte[] bytes = null;
//        try {
//            bytes = IOUtils.toByteArray(img);
//        } catch (IOException ex) {
//            Logger.getLogger(Buss.class.getName()).log(Level.SEVERE, null, ex);
//        }
        list.put("hoNV", nv.getHo());
        list.put("tenNV",nv.getTen());
        list.put("diachi",nv.getDiachi());
        list.put("sdt", nv.getSdt());
        list.put("chucvu", nv.getChucvu());
        list.put("email", nv.getEmail());
//        list.put("img",bytes);
        int z = 0;
        if(nv.isGioitinh()){
            z=1;
        }
        list.put("gioitinh", z);
        sql.updateIMG("nhanvien","nvID",nv.getMaNV(), img);
        return sql.update("nhanvien", list,"nvID = " +nv.getMaNV());
    }
    public boolean updateNV(NhanVien nv) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("hoNV", nv.getHo());
        list.put("tenNV",nv.getTen());
        list.put("diachi",nv.getDiachi());
        list.put("sdt", nv.getSdt());
        list.put("chucvu", nv.getChucvu());
        list.put("email", nv.getEmail());
        int z = 0;
        if(nv.isGioitinh()){
            z=1;
        }
        list.put("gioitinh", z);
        return sql.update("nhanvien", list,"nvID = " +nv.getMaNV());
    }
    public boolean deleteNV(int id) throws SQLException{
        return sql.delete("nhanvien", "nvID = "+id);
    }
      // ========================================== NHAN VIEN END =================================================
    // ======================================== ============== =================================================
  
     // ======================================== ============== =================================================
    // =========================================== Chuong trinh KM =====================================================
    
    
    public boolean insertCTKM(CtKm km) throws SQLException, IOException{
       HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("ctkmName", km.getTenCT());
        list.put("loai",km.getLoai());
        list.put("timeBD",km.getThoigianBD());
        list.put("timeKT", km.getThoigianKT());
        list.put("noidung", km.getNoidung());
        list.put("dieukien", km.getDieukien());
//        
        return sql.insert("ctkm", list);
    }
    
    public boolean insertCTKM_CT(CT_ctkm km) throws SQLException, IOException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("ctkmID", km.getCtkmID());
        list.put("maCode",km.getSanphamID());
        list.put("hinhthuc",km.getHinhthuc());
       
        return sql.insert("ctkm_chitiet", list);
    }
    
   
    public boolean updateCTKM(CtKm km) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("ctkmName", km.getTenCT());
        list.put("loai",km.getLoai());
        list.put("timeBD",km.getThoigianBD());
        list.put("timeKT", km.getThoigianKT());
        list.put("noidung", km.getNoidung());
        list.put("dieukien", km.getDieukien());
//        
        return sql.update("ctkm", list,"ctkmID = " +km.getMaMK());
    }
    public boolean updateCTKM_CT(CT_ctkm km) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("ctkmID", km.getCtkmID());
        list.put("maCode",km.getSanphamID());
        list.put("hinhthuc",km.getHinhthuc());
//        
        return sql.update("ctkm_chitiet", list,"kmctID = " +km.getCt_ctkmID());
    }
    public boolean deleteCTKM(int id) throws SQLException{
        return sql.delete("ctkm", "ctkmID = "+id);
    
    }
    public boolean deleteCTKM_CT(int id) throws SQLException{
        return sql.delete("ctkm_chitiet", "kmctID = "+id);
    
    }
    public ArrayList <CT_ctkm> getCTCtKms(String id) throws SQLException{
        ArrayList <CT_ctkm> ds = new ArrayList<>();
        rs = sql.select("ctkm_chitiet","ctkmID = "+id);
        while (rs.next()) {            
            ds.add(new CT_ctkm(String.valueOf(rs.getInt("kmctID")),String.valueOf(rs.getInt("ctkmID")),(rs.getString("maCode")),rs.getString("hinhthuc")));
        }
        return ds;
    }
    public HashMap<String,Object> findCTKM(String ma) throws SQLException {
        rs = sql.selectCTKM(ma);
        HashMap<String,Object> list = new HashMap<String,Object>();
        if (rs.next()) {
//            list.put("timeBD",rs.getString("timeBD"));
            list.put("d",rs.getString("timeKT"));
            list.put("c",rs.getString("hinhthuc"));
            list.put("b",rs.getString("maCode"));
            list.put("a",rs.getString("ctkmName") );

        }
        return list;     
    }
    // ========================================== Chuong trinh KM END =================================================
    // ======================================== ============== =================================================

    // ======================================== ============== =================================================
    // =========================================== Product =====================================================
    
    public boolean insertSP(product sp,InputStream img) throws SQLException, IOException{
      return sql.insertIMGsp(sp, img);
    }
    public String getDongiaSP(String id) throws SQLException{
        rs = sql.select("product"," sanphamID = '"+id+"'");
        if (rs.next()) {            
            return  rs.getString("price");
        }
        return null;
    }
    public String getSLSP(String id) throws SQLException{
        rs = sql.select("product"," sanphamID = '"+id+"'");
        if (rs.next()) {            
            return  rs.getString("soluong");
        }
        return null;
    }
//    public boolean updateNV(InputStream img) throws SQLException{
//        
//    }
    
    public boolean updateSP(product sp, InputStream img) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();

        list.put("sanphamName", sp.getSpName());
        list.put("soluong", sp.getSoluong());
        list.put("lai", sp.getLaixuat());
        list.put("price", sp.getGia());
        list.put("mota", sp.getMota());
        list.put("nccID", sp.getNccID());
        sql.updateIMG("product","sanphamID",sp.getSpID(), img);
        return sql.update("product", list,"sanphamID = " +sp.getSpID());
    }
    public boolean updateSP(product sp) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("sanphamName", sp.getSpName());
        list.put("soluong", sp.getSoluong());
        list.put("lai", sp.getLaixuat());
        list.put("price", sp.getGia());
        list.put("mota", sp.getMota());
        list.put("nccID", sp.getNccID());
        return sql.update("product", list,"sanphamID = " +sp.getSpID());
    }
    public boolean updateSP_NH(String maspString, String sl) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("soluong",sl);
        return sql.update("product", list,"sanphamID = '" +maspString+"'");
    }
    public boolean updateSL_MuaHang(String maspString, String sl) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("soluong",sl);
        return sql.update("product", list,"sanphamID = '" +maspString+"'");
    }
    public boolean updateSLPN(int x, String mapn, String masp) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("soluong",x);
       
        return sql.update("phieunhap_chitiet ", list," phieunhapID = '" +mapn+"' AND sanphamID = '"+masp+"'");
    }
    public boolean deleteSP(int id) throws SQLException{
        return sql.delete("product", "sanphamID = "+id);
    }
    
    public ArrayList<product> findMasp(int ma) throws SQLException {
        ArrayList<product> ds = new ArrayList<product>();
        for (product sp : dsProduct) {
            if (sp.getSpID().indexOf(String.valueOf(ma)) >= 0) {
                ds.add(sp);
                break;
            }
        }
        return ds;     
    }
    public ArrayList<top_sanpham> findMaspTopSP(int ma) throws SQLException {
        ArrayList<top_sanpham> ds = new ArrayList<top_sanpham>();
        for (top_sanpham sp : dstopSanPham) {
            if (sp.getSanphamID().indexOf(String.valueOf(ma)) >= 0) {
                ds.add(sp);
            }
        }
        return ds;     
    }
    

    public  ArrayList<product> findTensp(String ten) throws SQLException {

    ArrayList<product> ds = new ArrayList<>();

        for (product sp : dsProduct) {
            if (sp.getSpName().indexOf(ten) >= 0) {
                ds.add(sp);
            }
        }
        return ds;
    }
    
    // ========================================== Product END =================================================
    // ======================================== ============== =================================================

     // ======================================== ============== =================================================
    // =========================================== NCC =====================================================
   

    public ArrayList<Ncc> findtenNCC(String ho) throws SQLException {
       
        ArrayList<Ncc> ds = new ArrayList<>();
        for (Ncc kh : dsNcc) {
            if (kh.getNccName().indexOf(ho) >= 0 || kh.getNccName().equalsIgnoreCase(ho)) {
                ds.add(kh);
            }
        }
        return ds;    
    }
    public ArrayList<Ncc> findMaNcc(String ma) throws SQLException {
       ArrayList<Ncc> ds = new ArrayList<>();
        for (Ncc kh : dsNcc) {
            if (kh.getNccID().equalsIgnoreCase(ma)) {
                ds.add(kh);
            }
        }
        return ds;     
    }
    

    public  ArrayList<Ncc> findphoneNcc(String phone) throws SQLException {
    ArrayList<Ncc> ds = new ArrayList<>();
    
    for (Ncc kh : dsNcc) {
            if (kh.getSdt().indexOf(phone)>=0) {
//                System.out.println(Integer.parseInt(kh.getTotal()));
                ds.add(kh);
            }
        }
        return ds;
    }

    public ArrayList<Ncc> getDsNcc() {
        return dsNcc;
    }

    public void setDsNcc(ArrayList<Ncc> dsNcc) {
        this.dsNcc = dsNcc;
    }
    public  ArrayList<Ncc> findEmailNcc(String phone) throws SQLException {
    ArrayList<Ncc> ds = new ArrayList<>();
    
    for (Ncc kh : dsNcc) {
            if (kh.getEmail().indexOf(phone)>=0) {
//                System.out.println(Integer.parseInt(kh.getTotal()));
                ds.add(kh);
            }
        }
        return ds;
    }
    
    
    
    public boolean updateNcc(Ncc kh) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("nccName", kh.getNccName());
        list.put("diachi",kh.getDiachi());
        list.put("email",kh.getEmail());
        list.put("sdt", kh.getSdt());
        return sql.update("ncc", list, "nccID = "+kh.getNccID());
    }
    public boolean deleteNCc(int id) throws SQLException{
        return sql.delete("ncc", "nccID = "+id);
    }
    public boolean insertNcc(Ncc kh) throws SQLException, IOException{
       HashMap<String,Object> list = new HashMap<String,Object>();
       list.put("nccName", kh.getNccName());
        list.put("diachi",kh.getDiachi());
        list.put("email",kh.getEmail());
        list.put("sdt", kh.getSdt());
        return sql.insert("ncc", list);
    }
    public boolean checkSDTNcc(String sdt) throws SQLException{
        rs = sql.select("ncc"," sdt = '"+sdt+"'");
        if(rs.next()){
            return false;
        }
        return true;
    }
    // ========================================== NCC END =================================================
    // ======================================== ============== =================================================

     // ======================================== ============== =================================================
    // =========================================== PHIEU NHAP =====================================================
     public ArrayList <PhieuNhap> thongkePhieuNhaps(String n1, String n2) throws SQLException{
          ArrayList <PhieuNhap> ds = new ArrayList<>();
        rs = sql.thongkePhieuNhap(n1, n2);
        while (rs.next()) {            
            ds.add(new PhieuNhap(rs.getString("phieunhapID"),rs.getString("nhanvienID"),rs.getString("nccID"),rs.getString("tongtien"),rs.getString("ngay")));
        }
        return ds;
    }
     public ArrayList <top_sanpham> thongkeTopSanpham(String n1, String n2) throws SQLException{
          ArrayList <top_sanpham> ds = new ArrayList<>();
        rs = sql.thongkeTopSanPham3(n1, n2);
        while (rs.next()) {            
            ds.add(new top_sanpham(rs.getString("Top_spID"),rs.getString("sanphamID"),rs.getString("soluong"),rs.getString("ngay"),rs.getString("thanhtien")));
        }
        return ds;
    }
     public ArrayList <top_sanpham> thongkeTopSanpham5(String n1, String n2) throws SQLException{
          ArrayList <top_sanpham> ds = new ArrayList<>();
        rs = sql.thongkeTopSanPham5(n1, n2);
        while (rs.next()) {            
            ds.add(new top_sanpham(rs.getString("Top_spID"),rs.getString("sanphamID"),rs.getString("soluong"),rs.getString("ngay"),rs.getString("thanhtien")));
        }
        return ds;
    }
    public boolean insertPhieuNhapCT1(String phieunhapID,String soluong, String tt){
        try {
            rs = sql.select("product ",null," sanphamID DESC LIMIT 1");
            String sanphamID = null;
            if(rs.next()){
                sanphamID = rs.getString("sanphamID");
                boolean x = insertPhieuNhapCT(phieunhapID, sanphamID, soluong,tt);
                if(x){
                    return true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Buss.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Buss.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    
    public ArrayList<PhieuNhap> findMaPhieuNhap(String ma) throws SQLException {
       ArrayList<PhieuNhap> ds = new ArrayList<>();
        for (PhieuNhap kh : dsPhieuNhap) {
            if (kh.getMaPN().equalsIgnoreCase(ma) || kh.getMaPN().indexOf(ma)>=0) {
                ds.add(kh);
            }
        }
        return ds;     
    }
    public ArrayList<PhieuNhap> findMaNV(String ma) throws SQLException {
       ArrayList<PhieuNhap> ds = new ArrayList<>();
        for (PhieuNhap kh : dsPhieuNhap) {
            if (kh.getMaNV().equalsIgnoreCase(ma) || kh.getMaNV().indexOf(ma)>=0) {
                ds.add(kh);
            }
        }
        return ds;     
    }
    
    public ArrayList<PhieuNhap> findMaNCC(String ma) throws SQLException {
       ArrayList<PhieuNhap> ds = new ArrayList<>();
        for (PhieuNhap kh : dsPhieuNhap) {
            if (kh.getMaNCC().equalsIgnoreCase(ma) || kh.getMaNCC().indexOf(ma)>=0) {
                ds.add(kh);
            }
        }
        return ds;     
    }
    public String findMaNv(String ma) throws SQLException {
        rs = sql.select("nhanvien","nvID = '"+ma+"'");
        if(rs.next()){
            return rs.getString("nvID");
        }
        return null;
    }
    

    
    public boolean updatePhieuNhap(PhieuNhap kh) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("nhanvienID", kh.getMaNV());
        list.put("nccID",kh.getMaNCC());
        list.put("tongtien",kh.getTongTien());
        list.put("ngay", kh.getNgayNhap());
        return sql.update("phieunhap", list, "phieunhapID = "+kh.getMaPN());
    }
    
    public boolean deletePhieuNhap(String id) throws SQLException{
        return sql.delete("phieunhap", "phieunhapID = "+id);
    }
    public boolean insertPhieuNhap(PhieuNhap kh) throws SQLException, IOException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("nhanvienID", kh.getMaNV());
        list.put("nccID",kh.getMaNCC());
        list.put("tongtien",kh.getTongTien());
        list.put("ngay", kh.getNgayNhap());
        return sql.insert("phieunhap", list);
    }
    public boolean insertPhieuNhapCT(String phieunhapID,String spID,String sl,String thanhtien) throws SQLException, IOException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("phieunhapID", phieunhapID);
        list.put("sanphamID",spID);
        list.put("soluong",sl);
        list.put("thanhtien",thanhtien);
        return sql.insert("phieunhap_chitiet", list);
    }

    public int updateSLNhapHang(String mapn, String masp) throws SQLException{
        rs = sql.selectCT_phieunhapCT(mapn, masp);
        int s=0;
        if(rs.next()){
            s+= Integer.parseInt(rs.getString("slpro"))- Integer.parseInt(rs.getString("slpn"));
            System.out.println(Integer.parseInt(rs.getString("slpro")));
            System.out.println(Integer.parseInt(rs.getString("slpn")) );
        }
        return s;
    }
    public boolean updateSL_Xoa_PhieuNhap(String mapn, String masp) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("soluong",updateSLNhapHang(mapn, masp));
        return sql.update("product", list, "sanphamID = "+masp);
    }
    public boolean deletePhieuNhapCT(String idpnString,String idsp) throws SQLException{
        return sql.delete("phieunhap_chitiet ", " phieunhapctID = '"+idpnString+"' AND sanphamID = '"+idsp+"' ");
    }
     public boolean updateTT_PN(String mapn, String masp, String tt) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("thanhtien",tt);
        return sql.update("phieunhap_chitiet", list,"phieunhapID = '" +mapn+"' AND sanphamID = '"+masp +"'");
    }
//    
    // ========================================== PHIEU NHAP END =================================================
    // ======================================== ============== =================================================
     // ======================================== ============== =================================================
    // =========================================== THONG KE HOA DON =====================================================
    
    public ArrayList <HoaDon> thongke4truong(String g1, String g2, String n1, String n2) throws SQLException{
          ArrayList <HoaDon> ds = new ArrayList<>();
        rs = sql.thongke4truong(g1, g2, n1, n2);
        while (rs.next()) {            
            ds.add(new HoaDon(rs.getInt("hoadonID"),rs.getInt("khachhangID"),rs.getInt("nhanvienID"),rs.getString("ngaylap"),rs.getString("tongtien")));
        }
        return ds;
    }
    public ArrayList <HoaDon> thongke3_vangG1_truong(String g2, String n1, String n2) throws SQLException{
          ArrayList <HoaDon> ds = new ArrayList<>();
        rs = sql.thongke3_vangG1_truong(g2, n1, n2);
        while (rs.next()) {            
            ds.add(new HoaDon(rs.getInt("hoadonID"),rs.getInt("khachhangID"),rs.getInt("nhanvienID"),rs.getString("ngaylap"),rs.getString("tongtien")));
        }
        return ds;
    }
     public ArrayList <HoaDon> thongke3_vangG2_truong(String g1, String n1, String n2) throws SQLException{
          ArrayList <HoaDon> ds = new ArrayList<>();
        rs = sql.thongke3_vangG2_truong(g1, n1, n2);
        while (rs.next()) {            
            ds.add(new HoaDon(rs.getInt("hoadonID"),rs.getInt("khachhangID"),rs.getInt("nhanvienID"),rs.getString("ngaylap"),rs.getString("tongtien")));
        }
        return ds;
    }
     public ArrayList <HoaDon> thongke3_vangN1(String g1, String g2, String n2) throws SQLException{
          ArrayList <HoaDon> ds = new ArrayList<>();
        rs = sql.thongke3_vangN1(g1, g2, n2);
        while (rs.next()) {            
            ds.add(new HoaDon(rs.getInt("hoadonID"),rs.getInt("khachhangID"),rs.getInt("nhanvienID"),rs.getString("ngaylap"),rs.getString("tongtien")));
        }
        return ds;
    }
    public ArrayList <HoaDon> thongke3_vangN2_truong(String g1, String g2, String n1) throws SQLException{
         ArrayList <HoaDon> ds = new ArrayList<>();
        rs = sql.thongke3_vangN2_truong(g1, g2, n1);
        while (rs.next()) {            
            ds.add(new HoaDon(rs.getInt("hoadonID"),rs.getInt("khachhangID"),rs.getInt("nhanvienID"),rs.getString("ngaylap"),rs.getString("tongtien")));
        }
        return ds;
    }
    public ArrayList <HoaDon> thongke2_vangNgay_truong(String g1, String g2) throws SQLException{
         ArrayList <HoaDon> ds = new ArrayList<>();
        rs = sql.thongke2_vangNgay_truong(g1, g2);
        while (rs.next()) {            
            ds.add(new HoaDon(rs.getInt("hoadonID"),rs.getInt("khachhangID"),rs.getInt("nhanvienID"),rs.getString("ngaylap"),rs.getString("tongtien")));
        }
        return ds;
    }
    public ArrayList <HoaDon> thongke2_vanggia_truong(String n1, String n2) throws SQLException{
          ArrayList <HoaDon> ds = new ArrayList<>();
        rs = sql.thongke2_vanggia_truong(n1, n2);
        while (rs.next()) {            
            ds.add(new HoaDon(rs.getInt("hoadonID"),rs.getInt("khachhangID"),rs.getInt("nhanvienID"),rs.getString("ngaylap"),rs.getString("tongtien")));
        }
        return ds;
    }
   
    // ========================================== THONG KE HOA DON END =================================================
    // ======================================== ============== =================================================
     // ======================================== ============== =================================================
    // =========================================== HOA DON =====================================================
    
    // ========================================== HOA DON END =================================================
    // ======================================== ============== =================================================

    
    public void writeExcel(String name) throws IOException, SQLException{
//        dskh = getKhachHangs();
        importData1.writeExcel(dskh, name);
    }
    


    public void xuatPDF(String name)throws DocumentException, SQLException{
//        dskh = getKhachHangs();
        importData1.xuatPDF(dskh, name);
    }
    public void xuatPDF_CT_HD(ArrayList<ChitietHoaDon> list,String name,String s)throws DocumentException, SQLException{
        rp.XuatFileHD(name,list,s);
    }
    public String getSLsanphamALL() throws SQLException{
        rs = sql.getSLsanphamALL();
        if(rs.next()){
            return rs.getString("sl");
        }
        return null;
    }
    public String getSL_hoadon_ALL() throws SQLException{
         rs = sql.getSL_hoadon_ALL();
        if(rs.next()){
            return rs.getString("sl");
        }
        return null;
    }
    public String getSL_phieunhap_ALL() throws SQLException{
         rs = sql.getSL_phieunhap_ALL();
        if(rs.next()){
            return rs.getString("sl");
        }
        return null;
    }
    public String getSL_nhanvien_ALL() throws SQLException{
         rs = sql.getSL_nhanvien_ALL();
        if(rs.next()){
            return rs.getString("sl");
        }
        return null;
    }
    public String getSL_SanPhamTop_ALL(String masp) throws SQLException{
         rs = sql.getSL_SanPhamTop_ALL(masp);
        if(rs.next()){
            return rs.getString("soluong");
        }
        return null;
    }
    
    public NhanVien getNv(String manv) throws SQLException{
        System.out.println(FormLogin.getMaNV());
       rs = sql.select("nhanvien","nvID = '"+manv+"'");
       NhanVien nv = null;
       if(rs.next()){
           nv = new NhanVien(rs.getString("nvID"),rs.getString("hoNv"),rs.getString("tenNV"),rs.getString("sdt"),rs.getString("email"),rs.getBoolean("gioitinh"),rs.getString("chucvu"),rs.getString("diachi"),rs.getBytes("img"));
           return nv;
    }
       return null;}
    public Users getUser1(String manv) throws SQLException{
       rs = sql.select("users","nhanvienID = "+Integer.parseInt(manv));
       Users nv ;
       if(rs.next()){
           nv = new Users(Integer.parseInt(rs.getString("userID")),Integer.parseInt(rs.getString("nhanvienID")),rs.getString("fullName"),rs.getString("user"),rs.getString("pass"),Integer.parseInt(rs.getString("chucvuID")));
           return nv;
    }
       return null;}
    public String getlevel(String manv) throws SQLException{
       rs = sql.select("chucvu","chucvuID = '"+(manv)+"'");
       if(rs.next()){
           return rs.getString("chucvuName");
    }
       return null;}
 
    public boolean updateUsrt(String sdt,String manv) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("sdt",sdt+"");
        return sql.update("nhanvien", list, "nvID = '"+manv+"'");
    }
    public boolean updateMatKhau(String sdt,String manv) throws SQLException{
        HashMap<String,Object> list = new HashMap<String,Object>();
        list.put("pass",sdt+"");
        return sql.update("users", list, "userID = '"+manv+"'");
    }
    public boolean updateSDT(String sdt,String manv) throws SQLException{
        return sql.updateSDT(manv, sdt);
    }
    public boolean updatePass(String pass,String manv) throws SQLException{
        return sql.updatePass(manv, pass);
    }
    public void xuatExcel_HoaDon(ArrayList<HoaDon> list) throws IOException{
        importData1.writeExcel_HoaDon(list,"C:\\Users\\Nguyen\\Desktop\\hoadon1.xlsx");
    }
}
