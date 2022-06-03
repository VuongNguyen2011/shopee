
package DAL;

import DTO.NhanVien;
import DTO.product;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @Ngay : 04/05/2021
 * @Nguyen Dep Trai
 * @Do An Quan Li Cua Hang Ban May Tinh
 */

public class ConnectUnit {
    private ConnectSQL connectSQL = new ConnectSQL();

    public ConnectUnit() {
        try {
            ConnectSQL.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectUnit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Select * FROM tableName Where Condition ORDER BY orderBy;
    public ResultSet select(String tableName, String condition, String orderby) throws SQLException{
//        System.out.println(tableName);
        
        StringBuilder query = new StringBuilder("SELECT * FROM " + tableName);
        this.addCondition(query,condition);
        this.addOrderBy(query,orderby);
        query.append(";");
        System.out.println(query);
        
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet select(String tableName, String condition) throws SQLException{
        return select(tableName, condition,null);
    }
    
    public ResultSet select(String tableName) throws SQLException{
        return select(tableName,null);
    }

    private void addCondition(StringBuilder query, String condition) {
        if(condition!=null){
            query.append(" WHERE " + condition);
        }
    }

    private void addOrderBy(StringBuilder query, String orderby) {
        if(orderby!=null){
            query.append("ORDER BY " + orderby);
        }
    }
    public boolean insert(String tableName, HashMap<String,Object> columValues) throws SQLException{
        
        StringBuilder query = new StringBuilder("INSERT INTO "+tableName);
        StringBuilder valuesInsert = new StringBuilder();
        query.append("(");
        for(String key : columValues.keySet()){
            query.append(key + ",");
            valuesInsert.append("'"+columValues.get(key).toString()+"',");
        }
        query = query.delete(query.length()-1,query.length());
        valuesInsert = valuesInsert.delete(valuesInsert.length()-1,valuesInsert.length());
        query.append(") VALUES (" + valuesInsert.toString()+")");
        query.append(";");
        System.out.println(query);
        return this.connectSQL.executeUpdate(query.toString())>0;
        
    }
    
    public boolean update(String tableName, HashMap<String,Object> columValues, String condition) throws SQLException{
        StringBuilder query = new StringBuilder("UPDATE "+tableName+" SET ");

        for(String key : columValues.keySet()){
            query.append(key + " = '"+columValues.get(key).toString()+"',");
        }
        query = query.delete(query.length()-1,query.length());
        this.addCondition(query, condition);
        query.append(";");
        System.out.println(query);
        return this.connectSQL.executeUpdate(query.toString())>0;
    }
    public boolean delete(String tableName, String condition) throws SQLException{
        StringBuilder query = new StringBuilder("DELETE FROM "+tableName);
        this.addCondition(query, condition);
        query.append(";");
        System.out.println(query);
        return this.connectSQL.executeUpdate(query.toString())>0;
    }
    // dem so cot trong result 
    public int getColumCount (ResultSet resultset) throws SQLException{
        return resultset.getMetaData().getColumnCount();
    }
    // lay danh sach ten cot trong result
    public String[] getColumName (ResultSet result) throws SQLException{
        ResultSetMetaData rsmd = (ResultSetMetaData) result.getMetaData();
        int columCount = rsmd.getColumnCount();
        String[] list ;
        list = new String[columCount];
        for(int i = 0; i<columCount;i++){
            list[i]=rsmd.getColumnName(i);
        }
        return list;
    }
    public void updateIMG(String name,String maID,String id,InputStream img) throws SQLException{
        String UpdateQuery = null;
        PreparedStatement ps = null;
        UpdateQuery = "UPDATE "+name+" set img = ? WHERE "+maID+" = ?";
        ps = (PreparedStatement) ConnectSQL.getConnection().prepareStatement(UpdateQuery);
        ps.setBlob(1,img);
        ps.setString(2,id);
        ps.executeUpdate();
    }
    public boolean insertIMGNV(NhanVien nv,InputStream img) throws SQLException{
        String insertQuery = null;
        PreparedStatement ps = null;
        insertQuery = "INSERT INTO nhanvien(diachi,sdt,chucvu,gioitinh,tenNV,email,hoNV,img) VALUES (?,?,?,?,?,?,?,?);";
        ps = (PreparedStatement) ConnectSQL.getConnection().prepareStatement(insertQuery);
//        ps.setBlob(1,nv.getdi);
        ps.setString(1,nv.getDiachi());
        ps.setString(2,nv.getSdt());
        ps.setString(3,nv.getChucvu());
        ps.setBoolean(4,nv.isGioitinh());
        ps.setString(5,nv.getTen());
        ps.setString(6,nv.getEmail());
        ps.setString(7,nv.getHo());
        ps.setBlob(8,img);
        ps.executeUpdate();
        return true;
    }
    public boolean insertIMGsp(product nv,InputStream img) throws SQLException{
        String insertQuery = null;
        PreparedStatement ps = null;
        insertQuery = "INSERT INTO product(`sanphamName`, `soluong`, `lai`, `price`, `mota`, `nccID`,`img`) VALUES (?,?,?,?,?,?,?);";
        ps = (PreparedStatement) ConnectSQL.getConnection().prepareStatement(insertQuery);
//        ps.setBlob(1,nv.getdi);
        ps.setString(1,nv.getSpName());
        ps.setInt(2,nv.getSoluong());
        ps.setString(3,nv.getLaixuat());
        ps.setString(4,nv.getGia());
        ps.setString(5,nv.getMota());
        ps.setString(6,nv.getNccID());
        ps.setBlob(7,img);
        ps.executeUpdate();
        return true;
    }
     public ResultSet selectCTKM(String makm) throws SQLException{
//        System.out.println(tableName);
        
        StringBuilder query = new StringBuilder("SELECT c.ctkmName,c.timeKT,c.timeBD,ct.maCode,ct.hinhthuc FROM ctkm as c, ctkm_chitiet as ct WHERE c.ctkmID=ct.ctkmID AND ct.maCode = '" + makm + "' limit 1");
        
        System.out.println(query);
        
        return this.connectSQL.excuteQuery(query.toString());
    }
     public ResultSet selectCT_phieunhap(String ma) throws SQLException{
//        System.out.println(tableName);
        
        StringBuilder query = new StringBuilder("SELECT distinct pn.*,pn.soluong as slpn,p.* FROM `phieunhap_chitiet` as pn, product as p WHERE pn.sanphamID = p.sanphamID AND pn.phieunhapID = '"+ma+"'");
        
//        System.out.println(query);
        
        return this.connectSQL.excuteQuery(query.toString());
    }
     public ResultSet selectCT_phieunhapCT(String mapnString, String masp) throws SQLException{
        StringBuilder query = new StringBuilder("SELECT p.soluong as slpro,pn.soluong as slpn FROM `phieunhap_chitiet` as pn , product as p WHERE p.sanphamID = pn.sanphamID AND pn.phieunhapID = '"+ mapnString + "' AND pn.sanphamID = '"+masp+"'");
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet getSLsanphamALL(){
        StringBuilder query = new StringBuilder("SELECT COUNT(sanphamID) as sl FROM `product`");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet getSL_hoadon_ALL(){
         StringBuilder query = new StringBuilder("SELECT COUNT(hoadonID) as sl FROM `hoadon`");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet getSL_phieunhap_ALL(){
         StringBuilder query = new StringBuilder("SELECT COUNT(phieunhapID) as sl FROM phieunhap");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet getSL_nhanvien_ALL(){
         StringBuilder query = new StringBuilder("SELECT COUNT(nvID) as sl FROM `nhanvien`");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet getSL_SanPhamTop_ALL(String masp){
         StringBuilder query = new StringBuilder("SELECT soluong FROM `top_sanpham` WHERE sanphamID = '"+masp+"'");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet thongke4truong(String g1, String g2, String n1, String n2){
         StringBuilder query = new StringBuilder("SELECT * FROM `hoadon` WHERE ngaylap >= '"+n1+"' AND ngaylap <= '"+n2+"' AND `tongtien` >= '"+g1+"' AND tongtien <= '"+g2+"'");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet thongke3_vangG1_truong(String g2, String n1, String n2){
         StringBuilder query = new StringBuilder("SELECT * FROM `hoadon` WHERE ngaylap >= '"+n1+"' AND ngaylap <= '"+n2+"' AND tongtien <= '"+g2+"'");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
     public ResultSet thongke3_vangG2_truong(String g1, String n1, String n2){
         StringBuilder query = new StringBuilder("SELECT * FROM `hoadon` WHERE ngaylap >= '"+n1+"' AND ngaylap <= '"+n2+"' AND `tongtien`>= '"+g1+"'");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
     public ResultSet thongke3_vangN1(String g1, String g2, String n2){
         StringBuilder query = new StringBuilder("SELECT * FROM `hoadon` WHERE ngaylap <= '"+n2+"' AND `tongtien`>= '"+g1+"' AND tongtien <= '"+g2+"'");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet thongke3_vangN2_truong(String g1, String g2, String n1){
         StringBuilder query = new StringBuilder("SELECT * FROM `hoadon` WHERE ngaylap >= '"+n1+"' AND `tongtien`>= '"+g1+"' AND tongtien <= '"+g2+"'");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet thongke2_vangNgay_truong(String g1, String g2){
         StringBuilder query = new StringBuilder("SELECT * FROM `hoadon` WHERE `tongtien`>= '"+g1+"' AND tongtien <= '"+g2+"'");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet thongke2_vanggia_truong(String n1, String n2){
         StringBuilder query = new StringBuilder("SELECT * FROM `hoadon` WHERE ngaylap >= '"+n1+"' AND ngaylap <= '"+n2+"'");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet thongkePhieuNhap(String n1, String n2){
         StringBuilder query = new StringBuilder("SELECT * FROM `phieunhap` WHERE ngay >= '"+n1+"' AND ngay <= '"+n2+"'");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet thongkeTopSanPham3(String n1, String n2){
         StringBuilder query = new StringBuilder("SELECT Top_spID,sanphamID,sum(soluong) as soluong,ngay,sum(thanhtien) as thanhtien FROM `top_sanpham` WHERE ngay >= '"+n1+"' AND ngay <= '"+n2+"' GROUP by sanphamID ORDER by SUM(soluong) DESC LIMIT 3 ");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public ResultSet thongkeTopSanPham5(String n1, String n2){
         StringBuilder query = new StringBuilder("SELECT Top_spID,sanphamID,sum(soluong) as soluong,ngay,sum(thanhtien) as thanhtien FROM `top_sanpham` WHERE ngay >= '"+n1+"' AND ngay <= '"+n2+"' GROUP by sanphamID ORDER by SUM(soluong) DESC LIMIT 5 ");
                
        return this.connectSQL.excuteQuery(query.toString());
    }
    public String thongkeNhanVien(String manv,String t){
         StringBuilder query = new StringBuilder("SELECT sum(tongtien) as tt FROM `hoadon` as h WHERE nhanvienID = '"+manv+"' AND MONTH(ngaylap) = '"+t+"'");                
        return this.connectSQL.excuteQuery1(query.toString());
    }
    public boolean updateSDT(String ma, String sdt) throws SQLException{
        StringBuilder query = new StringBuilder("UPDATE `nhanvien` SET `sdt`= '"+sdt+"' WHERE `nvID` = "+ma);                
        return this.connectSQL.executeUpdate(query.toString())>0;

    }
    public boolean updatePass(String ma, String pass) throws SQLException{
        StringBuilder query = new StringBuilder("UPDATE `users` SET `pass`= '"+pass+"' WHERE `userID` = "+ma);                
        return this.connectSQL.executeUpdate(query.toString())>0;

    }
}
