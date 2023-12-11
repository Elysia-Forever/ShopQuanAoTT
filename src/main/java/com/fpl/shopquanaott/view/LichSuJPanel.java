/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fpl.shopquanaott.view;

import com.fpl.shopquanaott.helper.InHoaDon;
import com.fpl.shopquanaott.model.HDCT;
import com.fpl.shopquanaott.model.HoaDon;
import com.fpl.shopquanaott.repository.ChatLieuRepo;
import com.fpl.shopquanaott.repository.DotGIamGiaDAO;
import com.fpl.shopquanaott.repository.HDCTRepo;
import com.fpl.shopquanaott.repository.HoaDonRepo;
import com.fpl.shopquanaott.repository.KhachHangRepo;
import com.fpl.shopquanaott.repository.LoaiSanPhamRepo;
import com.fpl.shopquanaott.repository.MauSacRepo;
import com.fpl.shopquanaott.repository.NhanVienRepo;
import com.fpl.shopquanaott.repository.SanPhamRepo;
import com.fpl.shopquanaott.repository.SizeRepo;
import com.fpl.shopquanaott.service.SanPhamService;
import com.fpl.shopquanaott.service.impl.SanPhamServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class LichSuJPanel extends javax.swing.JPanel {
private SanPhamService spSer = new SanPhamServiceImpl();
private MauSacRepo msRP = new MauSacRepo();
private SizeRepo sRP = new SizeRepo();
private ChatLieuRepo clRP = new ChatLieuRepo();
private LoaiSanPhamRepo lRP = new LoaiSanPhamRepo();
private SanPhamRepo tenRP = new SanPhamRepo();
private DotGIamGiaDAO dotGiamRP = new DotGIamGiaDAO();
private KhachHangRepo khrp = new KhachHangRepo();
private NhanVienRepo nvrp = new NhanVienRepo();
private HoaDonRepo hdrp = new HoaDonRepo();
private HDCTRepo hdctRP = new HDCTRepo();
private InHoaDon inHD = new InHoaDon();

    public LichSuJPanel() {
        initComponents();
        loadTableHoaDon(hdrp.getAll());
        clearTable();
        
    }

   public void loadTableHoaDon(List<HoaDon> listHD){
      DefaultTableModel dtm = (DefaultTableModel) tblHoaDON.getModel();
      dtm.setRowCount(0);
         for (HoaDon h : listHD) {
             dtm.addRow(new Object[]{
             h.getMaHD(),
             nvrp.findByMa(h.getMaNV()).get(0).getHoTen(),
             khrp.findByMa(h.getMaKH()).get(0).getTenKh(),
             dotGiamRP.findByMa(h.getMaDot()).get(0).getTenDot(),
             h.getNgayTao(),
             h.getTongTien(),
             h.getTienPhaiTra(),
             trangThaiHD(h.getTrangThai())
             });
         }
     }
   
    public void loadTableHDCT(String maHD){
     DefaultTableModel dtm = (DefaultTableModel) tblHDCT.getModel();
     dtm.setRowCount(0);
     List<HDCT> listHDCT = hdctRP.getAllByMa(maHD);
         for (HDCT hdct : listHDCT) {
           dtm.addRow(new Object[]{
           hdct.getMaSPCT(),
           tenRP.findByMa(spSer.findByMa(hdct.getMaSPCT()).getTenSP()).getTenSP(),
        //   clRP.findByMa(spSer.findByMa(hdct.getMaSPCT()).getChatLieu()),
           msRP.findByMa(spSer.findByMa(hdct.getMaSPCT()).getMauSac()).getTen(),
           sRP.findByMa(spSer.findByMa(hdct.getMaSPCT()).getSizeSP()).getTen(),
           hdct.getSl(),
           hdct.getTongGia()
           });
         }
     }
   
   public String trangThaiHD(int trangThai){
    if(trangThai == 1){
    return "Đã thanh toán";
    }
    else{
    return "Chưa thanh toán";
    }
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        lblNV = new javax.swing.JLabel();
        lblKH = new javax.swing.JLabel();
        lblDot = new javax.swing.JLabel();
        lblNgayTao = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblTienKhach = new javax.swing.JLabel();
        btnIn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDON = new javax.swing.JTable();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jdcBatDau = new com.toedter.calendar.JDateChooser();
        jdcKetThuc = new com.toedter.calendar.JDateChooser();
        btnTimKiem = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        lblMaHDCT = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(231, 252, 249));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Thông tin hóa đơn");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Mã hóa đơn :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Nhân viên tạo :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Khách hàng :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Đợt :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ngày tạo :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Tổng tiền của hóa đơn :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Số tiền khách cần trả :");

        lblMaHD.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaHD.setText(".....");

        lblNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNV.setText(".....");

        lblKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblKH.setText(".....");

        lblDot.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDot.setText(".....");

        lblNgayTao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNgayTao.setText(".....");

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTongTien.setText(".....");

        lblTienKhach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTienKhach.setText(".....");

        btnIn.setText("IN HÓA ĐƠN");
        btnIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNV, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblKH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblDot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblNgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTongTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTienKhach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblMaHD))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblNV))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblKH))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblDot))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblNgayTao))
                .addGap(45, 45, 45)
                .addComponent(jLabel8)
                .addGap(14, 14, 14)
                .addComponent(lblTongTien)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTienKhach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(btnIn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDON.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Nhân viên", "Khách hàng", "Đợt", "Ngày tạo", "Tổng tiền", "Khách cần trả", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDONMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDON);

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Đã thanh toán", "Chưa thanh toán" }));
        cbbTrangThai.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbTrangThaiItemStateChanged(evt);
            }
        });

        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        jLabel11.setText("Ngày bắt đầu");

        jLabel12.setText("Ngày kết thúc");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jdcBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jdcKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(126, 126, 126))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTimKiem))
                    .addComponent(jdcBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdcKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 102));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Màu sắc", "Size", "Số lượng", "Tổng giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblHDCT);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Mã hóa đơn :");

        lblMaHDCT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMaHDCT.setText(".....");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMaHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(lblMaHDCT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Lịch sử giao dịch");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(553, 553, 553))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(75, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDONMouseClicked
      int row = tblHoaDON.getSelectedRow();
      if(row == -1){
      return;
      }
      String maHD = (String) tblHoaDON.getValueAt(row,0);
      String nv = (String) tblHoaDON.getValueAt(row,1);
      String kh = (String) tblHoaDON.getValueAt(row,2);
      String dot = (String) tblHoaDON.getValueAt(row,3);
      String ngayTao = (String) tblHoaDON.getValueAt(row,4);
      float tongTien = Float.parseFloat(tblHoaDON.getValueAt(row,5).toString());
      float tienTra = Float.parseFloat(tblHoaDON.getValueAt(row,6).toString());
      
      lblMaHD.setText(maHD);
      lblNV.setText(nv);
      lblKH.setText(kh);
      lblDot.setText(dot);
      lblNgayTao.setText(ngayTao);
      lblTongTien.setText(String.valueOf(tongTien));
      lblTienKhach.setText(String.valueOf(tienTra));
      lblMaHDCT.setText(maHD);
      
        loadTableHDCT(maHD);
    }//GEN-LAST:event_tblHoaDONMouseClicked

    private void cbbTrangThaiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbTrangThaiItemStateChanged
     String trangThai = cbbTrangThai.getSelectedItem().toString();
     if(trangThai.equalsIgnoreCase("All")){
         loadTableHoaDon(hdrp.getAll());
     }
     else if(trangThai.equalsIgnoreCase("Đã thanh toán")){
         loadTableHoaDon(hdrp.selectByTT(1));
     }
     else{
         loadTableHoaDon(hdrp.selectByTT(0));
     }
    }//GEN-LAST:event_cbbTrangThaiItemStateChanged

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        Date bd = jdcBatDau.getDate();
        Date kt = jdcKetThuc.getDate();
        
        if(bd == null || kt == null){
         JOptionPane.showMessageDialog(this,"Hãy chọn đủ ngày bắt đầu và kết thúc");
          return;
        }
        if(kt.before(bd)){
            JOptionPane.showMessageDialog(this,"Ngày bắt đầu phải trước ngày kết thúc");
            return;
        }
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String ngayBD = sdf.format(bd);
        String ngayKT = sdf.format(kt);
        
        List<HoaDon> listHD = hdrp.timKiemTheoNgay(ngayBD, ngayKT);
        if(listHD.size() == 0){
        JOptionPane.showMessageDialog(this,"Không tìm thấy hóa đơn thỏa mãn");
        return;
        }
        else{
            loadTableHoaDon(listHD);
        }
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInMouseClicked
     int row = tblHoaDON.getSelectedRow();
     if(row == -1){
     JOptionPane.showMessageDialog(this,"Hãy chọn 1 hóa đơn để in");
      return;
     }
     String chuatt = tblHoaDON.getValueAt(row,7).toString();
     if(chuatt.equalsIgnoreCase("Chưa thanh toán")){
     JOptionPane.showMessageDialog(this,"Không được in hóa đơn chưa thanh toán");
     }
     else{
     String maHD = tblHoaDON.getValueAt(row,0).toString();
     inHD.inHoaDonPDF(maHD);
     JOptionPane.showMessageDialog(this,"In thành công : " +maHD);
     }
     
    }//GEN-LAST:event_btnInMouseClicked
    public void clearTable(){
    DefaultTableModel dtm = (DefaultTableModel) tblHDCT.getModel();
    dtm.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIn;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcBatDau;
    private com.toedter.calendar.JDateChooser jdcKetThuc;
    private javax.swing.JLabel lblDot;
    private javax.swing.JLabel lblKH;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JLabel lblMaHDCT;
    private javax.swing.JLabel lblNV;
    private javax.swing.JLabel lblNgayTao;
    private javax.swing.JLabel lblTienKhach;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblHoaDON;
    // End of variables declaration//GEN-END:variables
}
