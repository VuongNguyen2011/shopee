/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAL.ConnectSQL;
import DAL.ConnectUnit;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSet;
import java.util.HashMap;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.ss.formula.functions.Count;


/**
 *
 * @author Nguyen
 */
public class main {
    public static void main(String[] args) throws SQLException {
        ConnectSQL con = new ConnectSQL();
        ConnectUnit sql = new ConnectUnit();
        
        HashMap<String,Object> list = new HashMap<String,Object>();
//       list.put("hoadonID", 1);
        list.put("khachhangID", 2);
        list.put("nhanvienID", 2);
        list.put("giamgiaID", 2);
        list.put("ngaylap", 2);
        list.put("tongtien", 2);
        list.put("tongtiengiamgia", 2);
        list.put("tienconlai", 2);
        
        System.out.println(sql.insert("hoadon",list));
    }
}
