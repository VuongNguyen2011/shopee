/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Buss;
import DTO.ChitietPhieuNhap;
import DTO.PhieuNhap;
import DTO.product;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author KHANH
 */
public class ChiTietPhieuNhap extends javax.swing.JFrame {

    /**
     * Creates new form PhieuNhap2
     */
    private String maPN;
    Buss buss;
    DefaultTableModel tablemodel;
    DefaultTableModel tablemodel1;

    public ChiTietPhieuNhap(String mapn) throws SQLException {
        initComponents();
        maPN = mapn;
        buss = new Buss();
        tablemodel = (DefaultTableModel) jTable_PhieuNhapSpMoi.getModel();
        tablemodel1 = (DefaultTableModel) jTable_PhieuNhapSpDaCo.getModel();
        jTextField_ID_PN_PhieuNhapSpMoi.setText(maPN);
        jTextField_ID_PN_PhieuNhapSpDaCo.setText(maPN);
        loadComboxNcc();
        loadData();
        loadDataDACO();
        setLocationRelativeTo(null);
    }

    private ChiTietPhieuNhap() {
    }

    private void loadComboxNcc() throws SQLException {
        ResultSet rs = null;
        rs = buss.loadComboxNcc();
        Vector v = new Vector();
        while (rs.next()) {
            v.add(rs.getString("nccID"));
            DefaultComboBoxModel com = new DefaultComboBoxModel(v);
            jComboBox_NCC_PN1.setModel(com);
        }
    }
    private void loadData() throws SQLException {
        ArrayList<product> ds = new ArrayList<>();
        ds = buss.get_CT_PhieuNhapsMoi(maPN);
        tablemodel.setRowCount(0);
        int i = 1;
        System.out.println(i);
        int sum = 0;
        for (product sp : ds) {
           
            Vector vctData = new Vector();
            sum+=(Integer.parseInt(sp.getGia()) + (Integer.parseInt(sp.getGia())*Integer.parseInt(sp.getLaixuat()))/100)*(sp.getSoluong());
            vctData.add(i);
            i++;
            vctData.add(jTextField_ID_PN_PhieuNhapSpMoi.getText());
            vctData.add(sp.getSpID());
            vctData.add(sp.getSpName());
           
            vctData.add(sp.getGia());
            vctData.add(sp.getLaixuat());
            vctData.add(Integer.parseInt(sp.getGia()) + (Integer.parseInt(sp.getGia())*Integer.parseInt(sp.getLaixuat()))/100);
            vctData.add(sp.getNccID());
               
            vctData.add(sp.getSoluong());
            vctData.add(sp.getMota());
            tablemodel.addRow(vctData);

        }
        if(i==1){
                    jLabelSoLuong.setText("0");

        }else{
                    jLabelSoLuong.setText(String.valueOf(i-1));

        }
        jLabelTongTien.setText(""+sum);
    }
    private void loadDataDACO() throws SQLException {
        ArrayList<ChitietPhieuNhap> ds = new ArrayList<>();
        ds = buss.get_CT_PhieuNhaps(maPN);
        tablemodel1.setRowCount(0);
        int i = 1;
        int sum = 0;
        for (ChitietPhieuNhap sp : ds) {
           
            Vector vctData = new Vector();
            sum+=Integer.parseInt(sp.getThanhtien());
            vctData.add(i);
            i++;
            vctData.add(jTextField_ID_PN_PhieuNhapSpMoi.getText());
            vctData.add(sp.getSanphamID());
           
            vctData.add(sp.getSoluong());
            vctData.add(sp.getThanhtien());
            vctData.add(sp.getPhieunhapctID());
            tablemodel1.addRow(vctData);

        }
        if(i==1){
                    jLabelSoLuongCu.setText("0");

        }else{
                    jLabelSoLuongCu.setText(String.valueOf(i-1));

        }
        jLabelthanhtienCu.setText(""+sum);
    }
private void loadDataSp(ArrayList<product> ds) throws SQLException {
            tablemodel.setRowCount(0);
            int i = 1;
            for (product sp : ds) {
            Vector vctData = new Vector();
            vctData.add(i);
            i++;
            vctData.add(maPN);
            vctData.add(sp.getSpID());
            vctData.add(sp.getSpName());
           
            vctData.add(sp.getGia());
            vctData.add(sp.getLaixuat());
            vctData.add(Integer.parseInt(sp.getGia()) + (Integer.parseInt(sp.getGia())*Integer.parseInt(sp.getLaixuat()))/100);
            vctData.add(sp.getNccID());
////
//         
            vctData.add(sp.getSoluong());
            vctData.add(sp.getMota());

            tablemodel.addRow(vctData);

        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_PhieuNhapSpMoi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField_ID_PN_PhieuNhapSpMoi = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField_ID_SP_PhieuNhapSpMoi = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField_TenSP_PhieuNhapSpMoi = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField_GiaTienNhap_PhieuNhapSpMoi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField_GiaTienBan_PhieuNhapSpMoi = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField_Lai_PhieuNhapSpMoi = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField_SoLuong_PhieuNhapSpMoi = new javax.swing.JTextField();
        jButton_Them_PhieuNhapSpMoi = new javax.swing.JButton();
        jButton_Sua_PhieuNhapSpMoi = new javax.swing.JButton();
        jButton_Xoa_PhieuNhapSpMoi = new javax.swing.JButton();
        jButton_Reset_PhieuNhapSpMoi = new javax.swing.JButton();
        jComboBox_NCC_PN1 = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabelSoLuong = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabelTongTien = new javax.swing.JLabel();
        jTextField_mota = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_PhieuNhapSpDaCo = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jTextField_ID_PN_PhieuNhapSpDaCo = new javax.swing.JTextField();
        jTextField_ID_SP_PhieuNhapSpDaCo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField_SoLuong_PhieuNhapSpDaCo = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jButton_Xoa_PhieuNhapSpDaCo = new javax.swing.JButton();
        jButton_Them_PhieuNhapSpDaCo = new javax.swing.JButton();
        jButton_Reset_PhieuNhapSpDaCo = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabelSoLuongCu = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabelthanhtienCu = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jTextField_ID_SP_PhieuNhapSpDaCo1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jPanel2.setBackground(new java.awt.Color(63, 169, 229));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Chi tiết phiếu nhập");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 255));

        jTabbedPane1.setBackground(new java.awt.Color(153, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel5.setBackground(new java.awt.Color(153, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTable_PhieuNhapSpMoi.setBackground(new java.awt.Color(153, 255, 255));
        jTable_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable_PhieuNhapSpMoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Mã phiếu nhập", "Mã sản phẩm ", "Tên sản phẩm", "Giá tiền nhập", "Phần trăm lãi", "Giá tiền bán", "Nhà cung cấp", "Số lượng", "Mô tả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_PhieuNhapSpMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PhieuNhapSpMoiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_PhieuNhapSpMoi);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã phiếu nhập");

        jTextField_ID_PN_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_ID_PN_PhieuNhapSpMoi.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã sản phẩm");

        jTextField_ID_SP_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_ID_SP_PhieuNhapSpMoi.setEnabled(false);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tên sản phẩm");

        jTextField_TenSP_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Giá tiền nhập");

        jTextField_GiaTienNhap_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Giá tiền bán ");

        jTextField_GiaTienBan_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_GiaTienBan_PhieuNhapSpMoi.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Phần trăm lãi");

        jTextField_Lai_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_Lai_PhieuNhapSpMoi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField_Lai_PhieuNhapSpMoiFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_Lai_PhieuNhapSpMoiFocusLost(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Nhà cung cấp");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Số lượng");

        jTextField_SoLuong_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton_Them_PhieuNhapSpMoi.setBackground(new java.awt.Color(153, 255, 153));
        jButton_Them_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Them_PhieuNhapSpMoi.setText("Thêm");
        jButton_Them_PhieuNhapSpMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Them_PhieuNhapSpMoiActionPerformed(evt);
            }
        });

        jButton_Sua_PhieuNhapSpMoi.setBackground(new java.awt.Color(102, 153, 255));
        jButton_Sua_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Sua_PhieuNhapSpMoi.setText("Sửa");
        jButton_Sua_PhieuNhapSpMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Sua_PhieuNhapSpMoiActionPerformed(evt);
            }
        });

        jButton_Xoa_PhieuNhapSpMoi.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Xoa_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Xoa_PhieuNhapSpMoi.setText("Xóa");
        jButton_Xoa_PhieuNhapSpMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Xoa_PhieuNhapSpMoiActionPerformed(evt);
            }
        });

        jButton_Reset_PhieuNhapSpMoi.setBackground(new java.awt.Color(204, 204, 204));
        jButton_Reset_PhieuNhapSpMoi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Reset_PhieuNhapSpMoi.setText("Reset");
        jButton_Reset_PhieuNhapSpMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Reset_PhieuNhapSpMoiActionPerformed(evt);
            }
        });

        jComboBox_NCC_PN1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_NCC_PN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_NCC_PN1ActionPerformed(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Số lượng :");

        jLabelSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSoLuong.setText("10");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel20.setText("Tổng tiền : ");

        jLabelTongTien.setBackground(new java.awt.Color(255, 51, 51));
        jLabelTongTien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelTongTien.setText("1000");
        jLabelTongTien.setOpaque(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextField_mota.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setText("Mô tả");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("%");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton_Them_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Sua_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jButton_Xoa_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                                .addComponent(jButton_Reset_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBox_NCC_PN1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(80, 80, 80))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_ID_PN_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_ID_SP_PhieuNhapSpMoi))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_TenSP_PhieuNhapSpMoi))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_GiaTienNhap_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_GiaTienBan_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_SoLuong_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField_mota, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)))
                                .addContainerGap(49, Short.MAX_VALUE))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField_Lai_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_ID_PN_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_GiaTienBan_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_ID_SP_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_TenSP_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_SoLuong_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_GiaTienNhap_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_mota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_NCC_PN1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Lai_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Them_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Sua_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Xoa_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Reset_PhieuNhapSpMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        jTabbedPane1.addTab("Nhập sản phẩm mới", jPanel5);

        jPanel4.setBackground(new java.awt.Color(153, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable_PhieuNhapSpDaCo.setBackground(new java.awt.Color(153, 255, 255));
        jTable_PhieuNhapSpDaCo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stt", "Mã phiếu nhập", "Mã sản phẩm", "Số lượng", "Thành tiền", "ID"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_PhieuNhapSpDaCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_PhieuNhapSpDaCoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable_PhieuNhapSpDaCo);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Mã phiếu nhập");

        jTextField_ID_PN_PhieuNhapSpDaCo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_ID_PN_PhieuNhapSpDaCo.setEnabled(false);

        jTextField_ID_SP_PhieuNhapSpDaCo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Mã sản phẩm");

        jTextField_SoLuong_PhieuNhapSpDaCo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_SoLuong_PhieuNhapSpDaCo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_SoLuong_PhieuNhapSpDaCoFocusLost(evt);
            }
        });
        jTextField_SoLuong_PhieuNhapSpDaCo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField_SoLuong_PhieuNhapSpDaCoMouseClicked(evt);
            }
        });
        jTextField_SoLuong_PhieuNhapSpDaCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SoLuong_PhieuNhapSpDaCoActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Số lượng");

        jButton_Xoa_PhieuNhapSpDaCo.setBackground(new java.awt.Color(255, 102, 102));
        jButton_Xoa_PhieuNhapSpDaCo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Xoa_PhieuNhapSpDaCo.setText("Xóa");
        jButton_Xoa_PhieuNhapSpDaCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Xoa_PhieuNhapSpDaCoActionPerformed(evt);
            }
        });

        jButton_Them_PhieuNhapSpDaCo.setBackground(new java.awt.Color(153, 255, 153));
        jButton_Them_PhieuNhapSpDaCo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Them_PhieuNhapSpDaCo.setText("Thêm");
        jButton_Them_PhieuNhapSpDaCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Them_PhieuNhapSpDaCoActionPerformed(evt);
            }
        });

        jButton_Reset_PhieuNhapSpDaCo.setBackground(new java.awt.Color(204, 204, 204));
        jButton_Reset_PhieuNhapSpDaCo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton_Reset_PhieuNhapSpDaCo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/Refresh.png"))); // NOI18N
        jButton_Reset_PhieuNhapSpDaCo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_Reset_PhieuNhapSpDaCoActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Số lượng :");

        jLabelSoLuongCu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelSoLuongCu.setText("10");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Tổng tiền : ");

        jLabelthanhtienCu.setBackground(new java.awt.Color(255, 51, 51));
        jLabelthanhtienCu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelthanhtienCu.setText("1000");
        jLabelthanhtienCu.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelSoLuongCu, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelthanhtienCu, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSoLuongCu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelthanhtienCu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("Thành Tiền");

        jTextField_ID_SP_PhieuNhapSpDaCo1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextField_ID_SP_PhieuNhapSpDaCo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_ID_SP_PhieuNhapSpDaCo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(41, 41, 41)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField_SoLuong_PhieuNhapSpDaCo, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addComponent(jTextField_ID_SP_PhieuNhapSpDaCo)
                    .addComponent(jTextField_ID_PN_PhieuNhapSpDaCo)
                    .addComponent(jTextField_ID_SP_PhieuNhapSpDaCo1))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton_Reset_PhieuNhapSpDaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton_Them_PhieuNhapSpDaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton_Xoa_PhieuNhapSpDaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(145, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField_ID_PN_PhieuNhapSpDaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton_Reset_PhieuNhapSpDaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_ID_SP_PhieuNhapSpDaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_Them_PhieuNhapSpDaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_SoLuong_PhieuNhapSpDaCo)
                        .addComponent(jButton_Xoa_PhieuNhapSpDaCo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_ID_SP_PhieuNhapSpDaCo1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Nhập sản phẩm đã có", jPanel4);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_Xoa_PhieuNhapSpMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Xoa_PhieuNhapSpMoiActionPerformed

        
        int i = jTable_PhieuNhapSpMoi.getSelectedRow();

        boolean x = false;
        try {
            buss.updateSL_Xoa_PhieuNhap(jTextField_ID_PN_PhieuNhapSpMoi.getText(),jTextField_ID_SP_PhieuNhapSpMoi.getText());
            x = buss.deletePhieuNhapCT(jTextField_ID_PN_PhieuNhapSpMoi.getText(),jTextField_ID_SP_PhieuNhapSpMoi.getText());
//            System.out.println(x);
            if (x) {
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
//                buss.get().remove(i);
                try {
                    loadData();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiKhachHang.class.getName()).log(Level.SEVERE, null, ex);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_Xoa_PhieuNhapSpMoiActionPerformed

    private void jButton_Them_PhieuNhapSpDaCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Them_PhieuNhapSpDaCoActionPerformed

        if(jTextField_SoLuong_PhieuNhapSpDaCo.getText().trim().equalsIgnoreCase("") || jTextField_ID_SP_PhieuNhapSpDaCo1.getText().trim().equalsIgnoreCase("")||jTextField_ID_SP_PhieuNhapSpDaCo.getText().trim().equalsIgnoreCase("")){
            JOptionPane.showMessageDialog(rootPane,"Các trường không được bỏ trống");
        }else{
            try {
                boolean x = buss.updateSP_NH(jTextField_ID_SP_PhieuNhapSpDaCo.getText(),String.valueOf(Integer.parseInt(jTextField_SoLuong_PhieuNhapSpDaCo.getText())+Integer.parseInt(buss.getSLSP(jTextField_ID_SP_PhieuNhapSpDaCo.getText()))));
                if(x){
                                JOptionPane.showMessageDialog(rootPane,"Thêm thành công");
                                buss.updateTT_PN(jTextField_ID_PN_PhieuNhapSpDaCo.getText(),jTextField_ID_SP_PhieuNhapSpDaCo.getText(),jTextField_ID_SP_PhieuNhapSpDaCo1.getText());
                                buss.insertPhieuNhapCT(jTextField_ID_PN_PhieuNhapSpDaCo.getText(),jTextField_ID_SP_PhieuNhapSpDaCo.getText(),jTextField_SoLuong_PhieuNhapSpDaCo.getText(),jTextField_ID_SP_PhieuNhapSpDaCo1.getText());
                }
                loadDataDACO();
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButton_Them_PhieuNhapSpDaCoActionPerformed

    private void jComboBox_NCC_PN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_NCC_PN1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_NCC_PN1ActionPerformed

    private void jTextField_ID_SP_PhieuNhapSpDaCo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_ID_SP_PhieuNhapSpDaCo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ID_SP_PhieuNhapSpDaCo1ActionPerformed

    private void jTextField_SoLuong_PhieuNhapSpDaCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SoLuong_PhieuNhapSpDaCoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SoLuong_PhieuNhapSpDaCoActionPerformed

    private void jButton_Them_PhieuNhapSpMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Them_PhieuNhapSpMoiActionPerformed
        if (jTextField_Lai_PhieuNhapSpMoi.getText().trim().equals("") || jTextField_SoLuong_PhieuNhapSpMoi.getText().trim().equalsIgnoreCase("") || jTextField_TenSP_PhieuNhapSpMoi.getText().trim().equalsIgnoreCase("") || jTextField_GiaTienBan_PhieuNhapSpMoi.getText().trim().equalsIgnoreCase("") || jTextField_GiaTienNhap_PhieuNhapSpMoi.getText().trim().equalsIgnoreCase("")||jTextField_mota.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(rootPane, "Các trường không được bỏ trống");
        } else {
            product sp = new product(jTextField_ID_SP_PhieuNhapSpMoi.getText(), jTextField_TenSP_PhieuNhapSpMoi.getText(), Integer.parseInt(jTextField_SoLuong_PhieuNhapSpMoi.getText()), jTextField_Lai_PhieuNhapSpMoi.getText(), jTextField_GiaTienBan_PhieuNhapSpMoi.getText(), jTextField_mota.getText(), String.valueOf(jComboBox_NCC_PN1.getSelectedItem()));
            InputStream img = null;
            try {
                img = new FileInputStream(new File("C:\\Users\\Nguyen\\Documents\\NetBeansProjects\\Quan_Li_Cua_Hang_MayTinh\\src\\IMG\\noImg.png"));
                boolean x = buss.insertSP(sp, img);
                if (x) {
                    JOptionPane.showMessageDialog(rootPane, "Thêm thành công");
                    buss.insertPhieuNhapCT1(maPN,jTextField_SoLuong_PhieuNhapSpMoi.getText(),String.valueOf(Integer.parseInt(jTextField_GiaTienBan_PhieuNhapSpMoi.getText())*Integer.parseInt(jTextField_SoLuong_PhieuNhapSpMoi.getText())));
                    loadData();
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
//                System.out.println(ImgPath);

        }

    }//GEN-LAST:event_jButton_Them_PhieuNhapSpMoiActionPerformed

    private void jTable_PhieuNhapSpMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PhieuNhapSpMoiMouseClicked

        int i = jTable_PhieuNhapSpMoi.getSelectedRow();
        jTextField_ID_SP_PhieuNhapSpMoi.setText(String.valueOf(tablemodel.getValueAt(i,2)));
        jTextField_TenSP_PhieuNhapSpMoi.setText(String.valueOf(tablemodel.getValueAt(i,3)));
        jTextField_GiaTienNhap_PhieuNhapSpMoi.setText(String.valueOf(tablemodel.getValueAt(i,4)));
        jTextField_Lai_PhieuNhapSpMoi.setText(String.valueOf(tablemodel.getValueAt(i,5)));
        jTextField_GiaTienBan_PhieuNhapSpMoi.setText(String.valueOf(tablemodel.getValueAt(i,6)));
        jComboBox_NCC_PN1.setSelectedItem(tablemodel.getValueAt(i,7));
        jTextField_SoLuong_PhieuNhapSpMoi.setText(String.valueOf(tablemodel.getValueAt(i,8)));
        jTextField_mota.setText(String.valueOf(tablemodel.getValueAt(i,9)));


    }//GEN-LAST:event_jTable_PhieuNhapSpMoiMouseClicked

    private void jButton_Sua_PhieuNhapSpMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Sua_PhieuNhapSpMoiActionPerformed
        try {
            int sl = buss.updateSLNhapHang(jTextField_ID_PN_PhieuNhapSpMoi.getText(),jTextField_ID_SP_PhieuNhapSpMoi.getText());
         if (jTextField_Lai_PhieuNhapSpMoi.getText().trim().equals("") || jTextField_SoLuong_PhieuNhapSpMoi.getText().trim().equalsIgnoreCase("") || jTextField_TenSP_PhieuNhapSpMoi.getText().trim().equalsIgnoreCase("") || jTextField_GiaTienBan_PhieuNhapSpMoi.getText().trim().equalsIgnoreCase("") || jTextField_GiaTienNhap_PhieuNhapSpMoi.getText().trim().equalsIgnoreCase("")||jTextField_mota.getText().trim().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(rootPane, "Các trường không được bỏ trống");
        } else {
//            buss.
            product sp = new product(jTextField_ID_SP_PhieuNhapSpMoi.getText(), jTextField_TenSP_PhieuNhapSpMoi.getText(),sl +Integer.parseInt(jTextField_SoLuong_PhieuNhapSpMoi.getText()), jTextField_Lai_PhieuNhapSpMoi.getText(), jTextField_GiaTienBan_PhieuNhapSpMoi.getText(), jTextField_mota.getText(), String.valueOf(jComboBox_NCC_PN1.getSelectedItem()));
            try {
                boolean x = buss.updateSP(sp);
                if (x) {
                    JOptionPane.showMessageDialog(rootPane, "Sửa thành công");
                    buss.updateSLPN(Integer.parseInt(jTextField_SoLuong_PhieuNhapSpMoi.getText()),jTextField_ID_PN_PhieuNhapSpMoi.getText(),jTextField_ID_SP_PhieuNhapSpMoi.getText());
                    loadData();
                }
            }catch (SQLException ex) {
                Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
//                System.out.println(ImgPath);
             
//                System.out.println(ImgPath);

        }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton_Sua_PhieuNhapSpMoiActionPerformed

    private void jButton_Reset_PhieuNhapSpMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Reset_PhieuNhapSpMoiActionPerformed

        jTextField_ID_SP_PhieuNhapSpMoi.setText("");
        jTextField_TenSP_PhieuNhapSpMoi.setText("");
        jTextField_mota.setText("");
        jTextField_Lai_PhieuNhapSpMoi.setText("");
        jTextField_GiaTienBan_PhieuNhapSpMoi.setText("");
        jTextField_GiaTienNhap_PhieuNhapSpMoi.setText("");
        jTextField_SoLuong_PhieuNhapSpMoi.setText("0");
        jComboBox_NCC_PN1.setSelectedIndex(0);

    }//GEN-LAST:event_jButton_Reset_PhieuNhapSpMoiActionPerformed

    private void jTextField_Lai_PhieuNhapSpMoiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Lai_PhieuNhapSpMoiFocusGained

        jTextField_GiaTienBan_PhieuNhapSpMoi.setText(String.valueOf((Integer.parseInt(jTextField_GiaTienNhap_PhieuNhapSpMoi.getText())*Integer.parseInt(jTextField_Lai_PhieuNhapSpMoi.getText()))/100 + Integer.parseInt(jTextField_GiaTienNhap_PhieuNhapSpMoi.getText())));

    }//GEN-LAST:event_jTextField_Lai_PhieuNhapSpMoiFocusGained

    private void jTextField_Lai_PhieuNhapSpMoiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Lai_PhieuNhapSpMoiFocusLost
              jTextField_GiaTienBan_PhieuNhapSpMoi.setText(String.valueOf((Integer.parseInt(jTextField_GiaTienNhap_PhieuNhapSpMoi.getText())*Integer.parseInt(jTextField_Lai_PhieuNhapSpMoi.getText()))/100 + Integer.parseInt(jTextField_GiaTienNhap_PhieuNhapSpMoi.getText())));

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Lai_PhieuNhapSpMoiFocusLost

    private void jButton_Reset_PhieuNhapSpDaCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Reset_PhieuNhapSpDaCoActionPerformed

        jTextField_SoLuong_PhieuNhapSpDaCo.setText("");
        jTextField_ID_SP_PhieuNhapSpDaCo.setText("");
        jTextField_ID_SP_PhieuNhapSpDaCo1.setText("");

    }//GEN-LAST:event_jButton_Reset_PhieuNhapSpDaCoActionPerformed

    private void jTextField_SoLuong_PhieuNhapSpDaCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField_SoLuong_PhieuNhapSpDaCoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SoLuong_PhieuNhapSpDaCoMouseClicked

    private void jTextField_SoLuong_PhieuNhapSpDaCoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_SoLuong_PhieuNhapSpDaCoFocusLost

        try {
            jTextField_ID_SP_PhieuNhapSpDaCo1.setText(String.valueOf(Integer.parseInt(jTextField_SoLuong_PhieuNhapSpDaCo.getText())*Integer.parseInt(buss.getDongiaSP(jTextField_ID_SP_PhieuNhapSpDaCo.getText()))));
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jTextField_SoLuong_PhieuNhapSpDaCoFocusLost

    private void jTable_PhieuNhapSpDaCoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_PhieuNhapSpDaCoMouseClicked

        int i = jTable_PhieuNhapSpDaCo.getSelectedRow();
        jTextField_ID_SP_PhieuNhapSpDaCo.setText(String.valueOf(tablemodel1.getValueAt(i,2)));
        jTextField_SoLuong_PhieuNhapSpDaCo.setText(String.valueOf(tablemodel1.getValueAt(i,3)));
        jTextField_ID_SP_PhieuNhapSpDaCo1.setText(String.valueOf(tablemodel1.getValueAt(i,4)));
        
    }//GEN-LAST:event_jTable_PhieuNhapSpDaCoMouseClicked

    private void jButton_Xoa_PhieuNhapSpDaCoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_Xoa_PhieuNhapSpDaCoActionPerformed


        
        int i = jTable_PhieuNhapSpDaCo.getSelectedRow();

        boolean x = false;
        try {
            buss.updateSL_Xoa_PhieuNhap(jTextField_ID_PN_PhieuNhapSpDaCo.getText(),jTextField_ID_SP_PhieuNhapSpDaCo.getText());
            x = buss.deletePhieuNhapCT(String.valueOf(tablemodel1.getValueAt(i,5)),jTextField_ID_SP_PhieuNhapSpDaCo.getText());
//            System.out.println(x);
            if (x) {
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công");
//                buss.get().remove(i);
                try {
                    loadDataDACO();
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLiKhachHang.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(QuanLiKhachHang.class.getName()).log(Level.SEVERE, null, ex);

        }
        
        
    }//GEN-LAST:event_jButton_Xoa_PhieuNhapSpDaCoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietPhieuNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiTietPhieuNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Reset_PhieuNhapSpDaCo;
    private javax.swing.JButton jButton_Reset_PhieuNhapSpMoi;
    private javax.swing.JButton jButton_Sua_PhieuNhapSpMoi;
    private javax.swing.JButton jButton_Them_PhieuNhapSpDaCo;
    private javax.swing.JButton jButton_Them_PhieuNhapSpMoi;
    private javax.swing.JButton jButton_Xoa_PhieuNhapSpDaCo;
    private javax.swing.JButton jButton_Xoa_PhieuNhapSpMoi;
    private javax.swing.JComboBox<String> jComboBox_NCC_PN1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelSoLuong;
    private javax.swing.JLabel jLabelSoLuongCu;
    private javax.swing.JLabel jLabelTongTien;
    private javax.swing.JLabel jLabelthanhtienCu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_PhieuNhapSpDaCo;
    private javax.swing.JTable jTable_PhieuNhapSpMoi;
    private javax.swing.JTextField jTextField_GiaTienBan_PhieuNhapSpMoi;
    private javax.swing.JTextField jTextField_GiaTienNhap_PhieuNhapSpMoi;
    private javax.swing.JTextField jTextField_ID_PN_PhieuNhapSpDaCo;
    private javax.swing.JTextField jTextField_ID_PN_PhieuNhapSpMoi;
    private javax.swing.JTextField jTextField_ID_SP_PhieuNhapSpDaCo;
    private javax.swing.JTextField jTextField_ID_SP_PhieuNhapSpDaCo1;
    private javax.swing.JTextField jTextField_ID_SP_PhieuNhapSpMoi;
    private javax.swing.JTextField jTextField_Lai_PhieuNhapSpMoi;
    private javax.swing.JTextField jTextField_SoLuong_PhieuNhapSpDaCo;
    private javax.swing.JTextField jTextField_SoLuong_PhieuNhapSpMoi;
    private javax.swing.JTextField jTextField_TenSP_PhieuNhapSpMoi;
    private javax.swing.JTextField jTextField_mota;
    // End of variables declaration//GEN-END:variables
}
