/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.fpl.shopquanaott.view;

import com.fpl.shopquanaott.helper.NhanVienHelp;
import com.fpl.shopquanaott.model.DotGiamGia;
import com.fpl.shopquanaott.model.HDCT;
import com.fpl.shopquanaott.model.HoaDon;
import com.fpl.shopquanaott.model.KhachHang;
import com.fpl.shopquanaott.model.SPCT;
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
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class BanHangJPanel extends javax.swing.JPanel {
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
    /**
     * Creates new form test
     */
    public BanHangJPanel() {
        initComponents();
        loadTableSPCT(spSer.sanPhamBanHang());
        loadTableHoaDon();
        loadCBBDotGG();
        loadCBBKH();
        
        txtHDCT.setEditable(false);
        txtDK.setEditable(false);
        txtPhanTramGiam.setEditable(false);
        txtTongTien.setEditable(false);
        txtTienKhachTra.setEditable(false);
        
    }

    
     public void loadTableSPCT(List<SPCT> list){
        DefaultTableModel dtm = (DefaultTableModel) tblSPCT.getModel();
        dtm.setRowCount(0);
        for (SPCT sp : list) {
            dtm.addRow(new Object[]{
              sp.getMaSP(),
              tenRP.layTen(sp.getTenSP()),
         //     lRP.layTen(sp.getLoaiSP()),
              sRP.layTen(sp.getSizeSP()),
              msRP.layTen(sp.getMauSac()),
              clRP.layTen(sp.getChatLieu()),
              sp.getSlTon(),
              sp.getGiaBan(),          
            });
        }
    }
     
     public void loadTableHoaDon(){
      DefaultTableModel dtm = (DefaultTableModel) tblHoaDon.getModel();
      dtm.setRowCount(0);
       List<HoaDon> listHD = hdrp.getAllChuaTT();
        // List<HoaDon> listHD = hdrp.getAll();
         for (HoaDon h : listHD) {
             dtm.addRow(new Object[]{
             h.getMaHD(),
             nvrp.findByMa(h.getMaNV()).get(0).getHoTen(),
             khrp.findByMa(h.getMaKH()).get(0).getTenKh(),
             dotGiamRP.findByMa(h.getMaDot()).get(0).getTenDot(),
             h.getTrangThai() == 1 ? "Đã thanh toán" : "Chưa thành toán"
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
           msRP.findByMa(spSer.findByMa(hdct.getMaSPCT()).getMauSac()).getTen(),
           sRP.findByMa(spSer.findByMa(hdct.getMaSPCT()).getSizeSP()).getTen(),
           hdct.getSl(),
           hdct.getTongGia()
           });
         }
     }
     
     
     public void loadCBBDotGG(){
         DefaultComboBoxModel dcb = (DefaultComboBoxModel) cbbDotGiamGia.getModel();
        dcb.removeAllElements();
//        List<DotGiamGia> list = dotGiamRP.getAll();
          List<DotGiamGia> list = dotGiamRP.selectConHan();
        for (DotGiamGia d : list) {
            dcb.addElement(d.getTenDot());
        }
    }
     
     public void loadCBBKH(){
         DefaultComboBoxModel dcb = (DefaultComboBoxModel) cbbKhachHang.getModel();
        dcb.removeAllElements();
        List<KhachHang> list = khrp.selectALL();
        for (KhachHang k : list) {
            dcb.addElement(k.getTenKh());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblSPCT = new javax.swing.JTable();
        btnThemVaoGio = new javax.swing.JButton();
        btnXoaKhoiGio = new javax.swing.JButton();
        txtTKSPCT = new javax.swing.JTextField();
        btnXoaToanBo = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnThayDoiSL = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnTaoHD = new javax.swing.JButton();
        btnXoaHD = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        cbbDotGiamGia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtPhanTramGiam = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDK = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbKhachHang = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lblMaHD = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTienKhachTra = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtMakh = new javax.swing.JTextField();
        btnTaoHD1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHDCT = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtHDCT = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SPCT", "Tên SP", "Size", "Màu sắc", "Chất liệu", "Tồn  kho", "Gía bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tblSPCT);

        btnThemVaoGio.setBackground(new java.awt.Color(153, 255, 153));
        btnThemVaoGio.setText("Thêm vào giỏ");
        btnThemVaoGio.setBorderPainted(false);
        btnThemVaoGio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemVaoGioMouseClicked(evt);
            }
        });

        btnXoaKhoiGio.setBackground(new java.awt.Color(255, 153, 153));
        btnXoaKhoiGio.setText("Xoá khỏi giỏ");
        btnXoaKhoiGio.setBorderPainted(false);
        btnXoaKhoiGio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaKhoiGioMouseClicked(evt);
            }
        });

        btnXoaToanBo.setBackground(new java.awt.Color(204, 204, 255));
        btnXoaToanBo.setText("Xoá toàn bộ");
        btnXoaToanBo.setBorderPainted(false);
        btnXoaToanBo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaToanBoMouseClicked(evt);
            }
        });

        jButton1.setText("Tìm kiếm sản phẩm");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        btnThayDoiSL.setBackground(new java.awt.Color(255, 204, 204));
        btnThayDoiSL.setText("Thay đổi SL");
        btnThayDoiSL.setBorderPainted(false);
        btnThayDoiSL.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThayDoiSLMouseClicked(evt);
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
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThemVaoGio)
                        .addGap(53, 53, 53)
                        .addComponent(btnXoaKhoiGio, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoaToanBo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnThayDoiSL, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtTKSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(51, 51, 51))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemVaoGio)
                    .addComponent(btnXoaKhoiGio)
                    .addComponent(txtTKSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaToanBo)
                    .addComponent(jButton1)
                    .addComponent(btnThayDoiSL))
                .addGap(22, 22, 22))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnTaoHD.setText("Tạo HĐ");
        btnTaoHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHDMouseClicked(evt);
            }
        });

        btnXoaHD.setText("Xóa HĐ");
        btnXoaHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaHDMouseClicked(evt);
            }
        });

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        cbbDotGiamGia.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbDotGiamGiaItemStateChanged(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Sự kiện :");

        jButton6.setText("+");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel4.setText("Phần trăm");

        jLabel5.setText("Điều kiện");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Khách hàng :");

        cbbKhachHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbKhachHangItemStateChanged(evt);
            }
        });

        jButton7.setText("+");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel7.setText("Hóa đơn :");

        lblMaHD.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblMaHD.setForeground(new java.awt.Color(255, 51, 51));
        lblMaHD.setText(".........");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Tổng tiền hóa đơn :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel9.setText("Tiền khách phải trả :");

        jLabel10.setText("SĐT khách :");

        btnTaoHD1.setText("Hủy");
        btnTaoHD1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTaoHD1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTaoHD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTaoHD1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaHD)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblMaHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbDotGiamGia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDK)
                                    .addComponent(txtPhanTramGiam))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton6)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTienKhachTra, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(58, 58, 58))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(txtMakh)
                                .addGap(60, 60, 60))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cbbKhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7)
                                .addGap(17, 17, 17))))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(lblMaHD))
                .addGap(56, 56, 56)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtMakh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbDotGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPhanTramGiam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(txtTienKhachTra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHD, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaoHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 102));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Nhân viên", "Khách hàng", "Đợt", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        tblHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Sản phẩm", "Tên sản phẩm", "Màu sắc", "Size", "Số lượng", "Đợn giá"
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
        jScrollPane3.setViewportView(tblHDCT);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Mã hóa đơn :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtHDCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(131, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbbDotGiamGiaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbDotGiamGiaItemStateChanged
      String tenDot = cbbDotGiamGia.getSelectedItem().toString();
      DotGiamGia dgg = dotGiamRP.findByTen(tenDot).get(0);
      txtPhanTramGiam.setText(String.valueOf(dgg.getPhanTram()));
      txtDK.setText(String.valueOf(dgg.getDieuKien()));
      
    }//GEN-LAST:event_cbbDotGiamGiaItemStateChanged

    private void cbbKhachHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbKhachHangItemStateChanged
    String tenKH =(String) cbbKhachHang.getSelectedItem();
    if(tenKH == null){
     txtMakh.setText("");
    }
    else{
    KhachHang kh = khrp.findByTen(tenKH).get(0);
    txtMakh.setText(kh.getSdt());
    }

    }//GEN-LAST:event_cbbKhachHangItemStateChanged

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
    int row = tblHoaDon.getSelectedRow();
    if(row == -1){
    return;
    }
    String maHD = tblHoaDon.getValueAt(row,0).toString();
    setFieldHD(maHD);
    loadTableHDCT(maHD);
    
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHDMouseClicked
       HoaDon hd = taoHD();
       hdrp.insert(hd);
       JOptionPane.showMessageDialog(this,"Tạo thành công hóa đơn mới");
       loadTableHoaDon();
    }//GEN-LAST:event_btnTaoHDMouseClicked

    private void btnTaoHD1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTaoHD1MouseClicked

      float a = hdctRP.testNull(txtHDCT.getText());
        System.out.println(a);
    }//GEN-LAST:event_btnTaoHD1MouseClicked

    private void btnThemVaoGioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemVaoGioMouseClicked
     int rowSP = tblSPCT.getSelectedRow();
     int rowHD = tblHoaDon.getSelectedRow();
     if(rowSP == -1 || rowHD == -1){
     JOptionPane.showMessageDialog(this,"Hãy chọn hóa đơn và sản phẩm trước khi thêm");
     return;
     }
     
     String nhapSL = JOptionPane.showInputDialog(this,"Nhập số lượng");
     if(checkSLVao(nhapSL) == 0){
     return;
     }
     
     int sl = Integer.parseInt(nhapSL);
     int slTonKho = Integer.parseInt(tblSPCT.getValueAt(rowSP,5).toString());
     if(sl>slTonKho){
     JOptionPane.showMessageDialog(this,"Vượt quá số lượng tồn kho");
     return;
     }
     
     HDCT hdct = getDataHDCT(sl);
     if(hdctRP.checkTT(hdct.getMaHD(),hdct.getMaSPCT()) > 0){
     hdctRP.updateSPTonTai(hdct,giaBanCuaSP());
     JOptionPane.showMessageDialog(this,"Đã cập nhật");
     spSer.giamSL(sl,hdct.getMaSPCT());
     capNhatTienHD(hdct.getMaHD(),hdctRP.tongTienHDCT(hdct.getMaHD()));
     
     loadTableSPCT(spSer.sanPhamBanHang());
     loadTableHDCT(hdct.getMaHD());
     setFieldHD(txtHDCT.getText());
     return;
     }
     else{
     hdctRP.insert(hdct);
     JOptionPane.showMessageDialog(this,"Thêm thành công");
     spSer.giamSL(sl,hdct.getMaSPCT());
     capNhatTienHD(hdct.getMaHD(),hdctRP.tongTienHDCT(hdct.getMaHD()));
     
     loadTableSPCT(spSer.sanPhamBanHang());
     loadTableHDCT(hdct.getMaHD());
     setFieldHD(txtHDCT.getText());
     }
     
    }//GEN-LAST:event_btnThemVaoGioMouseClicked

    private void btnXoaKhoiGioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaKhoiGioMouseClicked
    int rowHDCT =tblHDCT.getSelectedRow();
    String maHD = txtHDCT.getText();
    if(rowHDCT == -1){
     JOptionPane.showMessageDialog(this,"Hãy chọn 1 sản phẩm trong giỏ hàng");
     return;
    }
  
    if(maHD.isBlank()){
     JOptionPane.showMessageDialog(this,"Chưa chọn hóa đơn");
     return;  
    }
    String maSPCT = tblHDCT.getValueAt(rowHDCT, 0).toString();
    int sl = Integer.parseInt(tblHDCT.getValueAt(rowHDCT, 4).toString());
    
    hdctRP.delete(maHD, maSPCT);
    JOptionPane.showMessageDialog(this,"Đã xóa sản phẩm khỏi hóa đơn");
    spSer.tangSL(sl, maSPCT);
    capNhatTienHD(maHD,hdctRP.tongTienHDCT(maHD));
    huyDotGiamGia(maHD);
    
    loadTableSPCT(spSer.sanPhamBanHang());
    loadTableHDCT(maHD);
    loadTableHoaDon();
    setFieldHD(txtHDCT.getText());
    }//GEN-LAST:event_btnXoaKhoiGioMouseClicked

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
     if(txtHDCT.getText().isBlank()){
     JOptionPane.showMessageDialog(this,"Hãy chọn 1 hóa đơn trước");
     return;
     }
     if(khrp.getBySDT(txtMakh.getText()) == 0){
     taoKHMoi();
     return;
     }
     
     String sdtKH = txtMakh.getText();
//     String tenKh = cbbKhachHang.getSelectedItem().toString();
     KhachHang kh = khrp.findBySDT(sdtKH).get(0);
     HoaDon hd = hdrp.findByMa(txtHDCT.getText()).get(0);
     hd.setMaKH(kh.getMaKH());
     hdrp.update_kh(hd);
     JOptionPane.showMessageDialog(this,"Đã sửa khách hàng");
     loadTableHoaDon();
    }//GEN-LAST:event_jButton7MouseClicked

    private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThanhToanMouseClicked
      String maHD = txtHDCT.getText();
      if(maHD.isBlank()){
      JOptionPane.showMessageDialog(this,"Hãy chọn 1 hóa đơn để thanh toán");
      return;
      }
      
      HoaDon hd = hdrp.findByMa(maHD).get(0);
      if(hd.getTienPhaiTra() <= 0){
      JOptionPane.showMessageDialog(this,"Chưa có sản phẩm để thanh toán");
      return;
      }
      
      hdrp.thanhToan(hd.getMaHD());
      JOptionPane.showMessageDialog(this,"Thanh toán thành công");
      loadTableHoaDon();
      clearForm();
    }//GEN-LAST:event_btnThanhToanMouseClicked

    private void btnXoaToanBoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaToanBoMouseClicked
     String maHD = txtHDCT.getText();
     if(maHD.isBlank()){
       JOptionPane.showMessageDialog(this,"Hãy chọn 1 hóa đơn");
       return;
     }
     List<HDCT> listhdct = hdctRP.getAllByMa(maHD);
     if(listhdct.size() == 0){
      JOptionPane.showMessageDialog(this,"Chưa có sản phẩm để xóa");
      return;
     }
     else{
         for (HDCT h : listhdct) {
             spSer.tangSL(h.getSl(),h.getMaSPCT());
         }
         hdctRP.delete_allByHD(maHD);
         JOptionPane.showMessageDialog(this,"Đã xóa toàn bộ sản phẩm trong hóa đơn :" + maHD);
         loadTableSPCT(spSer.sanPhamBanHang());
         capNhatTienHD(maHD,hdctRP.tongTienHDCT(maHD));
         huyDotGiamGia(maHD);
         
         setFieldHD(maHD);
         loadTableHDCT(maHD);
         loadTableHoaDon();
     }
     
    }//GEN-LAST:event_btnXoaToanBoMouseClicked

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
      DotGiamGia dgg = dotGiamRP.findByTen(cbbDotGiamGia.getSelectedItem().toString()).get(0);
      HoaDon hd = hdrp.findByMa(txtHDCT.getText()).get(0);
      hd.setMaDot(dgg.getMaDot());
      
      float dieuKien = Float.parseFloat(txtDK.getText());
      if(hd.getTongTien() < dieuKien){
       JOptionPane.showMessageDialog(this,"Không đủ điều kiện");
       return;
      }
      else{
       hdrp.update_dot(hd);
       capNhatTienHD(hd.getMaHD(),hdctRP.tongTienHDCT(hd.getMaHD()));
       
       JOptionPane.showMessageDialog(this,"Đã cập nhật đợt cho hóa đơn");
       loadTableHoaDon();
       setFieldHD(hd.getMaHD());
      }
    }//GEN-LAST:event_jButton6MouseClicked

    private void btnXoaHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaHDMouseClicked
      String maHD = txtHDCT.getText();
      if(maHD.isBlank()){
      JOptionPane.showMessageDialog(this,"Hãy chọn 1 hóa đơn");
      return;
      }
      int dem = hdctRP.checkDeXoaHD(maHD);
      if(dem > 0){
      JOptionPane.showMessageDialog(this,"Hãy xóa toàn bộ sản phẩm trước khi xóa hóa đơn");
      return;
      }
      else{
      hdrp.delete(maHD);
      JOptionPane.showMessageDialog(this,"Đã xóa hóa đơn");
      loadTableHoaDon();
      }
    }//GEN-LAST:event_btnXoaHDMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
    String nd = txtTKSPCT.getText();
    if(nd.isBlank()){
        loadTableSPCT(spSer.sanPhamBanHang());
       return;
    }
    else{
     List<SPCT> listSPCT = spSer.tkMaOrTenSPCT(nd);
     if(listSPCT.size() == 0){
      JOptionPane.showMessageDialog(this,"Không tìm thấy sản phẩm");
      return;
     }
     else{
         loadTableSPCT(listSPCT);
     }
    }
    
    }//GEN-LAST:event_jButton1MouseClicked

    private void btnThayDoiSLMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThayDoiSLMouseClicked
      int rowHDCT = tblHDCT.getSelectedRow();
      if(rowHDCT == -1){
      JOptionPane.showMessageDialog(this,"Hãy chọn 1 sản phẩm trong hóa đơn");
      return;
      }
     String maHD = txtHDCT.getText(); 
      
     String slMoi = JOptionPane.showInputDialog(this,"Nhập số lượng mới");
     if(checkSLVao(slMoi) == 0){
     return;
     }
     
    int sLuongMoi = Integer.parseInt(slMoi);
    if(thayDoiSL(sLuongMoi) == 1){
     JOptionPane.showMessageDialog(this,"Thay đổi số lượng thành công");
     capNhatTienHD(maHD,hdctRP.tongTienHDCT(maHD));
     huyDotGiamGia(maHD);
      
     loadTableSPCT(spSer.sanPhamBanHang());
     loadTableHDCT(maHD);
   //  loadTableHoaDon();
     setFieldHD(txtHDCT.getText());
    }
     
     
       
    }//GEN-LAST:event_btnThayDoiSLMouseClicked
    
    public void setFieldHD(String maHD){
    HoaDon hd = hdrp.findByMa(maHD).get(0);
    
    String tenKh = khrp.findByMa(hd.getMaKH()).get(0).getTenKh();
    String tenDot = dotGiamRP.findByMa(hd.getMaDot()).get(0).getTenDot();
    
    txtHDCT.setText(hd.getMaHD());
    
    lblMaHD.setText(hd.getMaHD());
    txtTongTien.setText(String.valueOf(hd.getTongTien()));
    txtTienKhachTra.setText(String.valueOf(hd.getTienPhaiTra()));
    cbbDotGiamGia.setSelectedItem(tenDot);
    cbbKhachHang.setSelectedItem(tenKh);
    }
    
    public HoaDon taoHD(){
    KhachHang kh = khrp.findByMa(1).get(0);
    DotGiamGia dgg = dotGiamRP.findByMa("DOT0").get(0);
    
    HoaDon hd = new HoaDon();
    hd.setMaHD(createMaHD());
    hd.setMaNV(NhanVienHelp.user.getMaNV());
    hd.setMaKH(kh.getMaKH());
    hd.setMaDot(dgg.getMaDot());
    hd.setTongTien(0);
    hd.setTienPhaiTra(0);
    hd.setTrangThai(0);
    return hd;
    }
    
    public String createMaHD(){
    if(hdrp.getAll().size() == 0){
    return "HD1";
    }
    else{
    return "HD" + (hdrp.selectMaMax()+1);
    }
    }
    
    public HDCT getDataHDCT(int sl){
    int row = tblSPCT.getSelectedRow();
    HoaDon hd = hdrp.findByMa(txtHDCT.getText()).get(0);
    SPCT spct = spSer.findByMa(tblSPCT.getValueAt(row,0).toString());
    
    
    HDCT hdct = new HDCT();
    hdct.setMaHD(hd.getMaHD());
    hdct.setMaSPCT(spct.getMaSP());
    hdct.setSl(sl);
    hdct.setTongGia(sl*spct.getGiaBan());
    return hdct;
    }
    
    public void capNhatTienHD(String maHD,float tongTien){
    HoaDon hd = hdrp.findByMa(maHD).get(0);
    DotGiamGia dgg = dotGiamRP.findByMa(hd.getMaDot()).get(0);
    float phanTramGiam = (float) dgg.getPhanTram()/100;
       
    hd.setTongTien(tongTien);
    hd.setTienPhaiTra(tongTien -tongTien*phanTramGiam);
    
    hdrp.update_tongtien(hd);
    }
    
    public float giaBanCuaSP(){
    int rowSP = tblSPCT.getSelectedRow();
    String maSPCT = tblSPCT.getValueAt(rowSP,0).toString();
    SPCT spct = spSer.findByMa(maSPCT);
    return spct.getGiaBan();
    }
    
    public void clearForm(){
    DefaultTableModel dtm = (DefaultTableModel) tblHDCT.getModel();
    dtm.setRowCount(0);
    txtHDCT.setText("");
    lblMaHD.setText(".....");
    txtTongTien.setText("");
    txtTienKhachTra.setText("");
    }
    
    public int checkSLVao(String nhapSL){
    if(nhapSL == null){
    return 0;
    }    
    boolean check = false;
    check = nhapSL.matches("^[1-9][0-9]*$");
 
     if(check == false || nhapSL == null){
     JOptionPane.showMessageDialog(this,"Sai định dạng số lượng");
     return 0;
     }
     return 1;
    }
    
    public void taoKHMoi(){
    String sdt = txtMakh.getText();
    
    int checkKH = khrp.getBySDT(sdt);
    if(checkKH == 0){
     JOptionPane.showMessageDialog(this,"Không tìm thấy khách hàng");
     
     int chon = JOptionPane.showConfirmDialog(this,"Bạn có muốn tạo khách hàng mới?","",JOptionPane.YES_NO_OPTION);
     
     if(chon == JOptionPane.YES_OPTION){
     String tenKh = JOptionPane.showInputDialog(this,"Tên khách hàng");
     KhachHang kh = new KhachHang(0, tenKh, sdt,"","",1,"Đồng");
     khrp.insertKH(kh);
     loadCBBKH();
     JOptionPane.showMessageDialog(this,"Tạo thành công khách hàng mới");
     KhachHang khachHangTK = khrp.findBySDT(sdt).get(0);
     cbbKhachHang.setSelectedItem(khachHangTK.getTenKh());
     }
     
     
    }
    
    }
    
    public void huyDotGiamGia(String maHD){
    HoaDon hd = hdrp.findByMa(maHD).get(0);
    DotGiamGia dgg = dotGiamRP.findByMa(hd.getMaDot()).get(0);
    if(hd.getTongTien() < dgg.getDieuKien()){
    hdrp.huyDotGG(hd.getMaHD());
    }
    }
    
    public int thayDoiSL(int slMoi){
    int row = tblHDCT.getSelectedRow();
    int slCu = Integer.parseInt( tblHDCT.getValueAt(row,4).toString());
    SPCT spct = spSer.findByMa(tblHDCT.getValueAt(row,0).toString());
    String maHD = txtHDCT.getText();
    int slThayDoi = 0;
    
     HDCT hdct = new HDCT();
     hdct.setMaHD(maHD);
     hdct.setMaSPCT(spct.getMaSP());
     hdct.setSl(slMoi);
     hdct.setTongGia(slMoi*spct.getGiaBan());
    
    if(slCu < slMoi){
     hdctRP.thayDoiSlSPCT(hdct);
     slThayDoi = slMoi - slCu;   
     spSer.giamSL(slThayDoi,spct.getMaSP());
     return 1;
    }
    else if(slCu > slMoi){
    hdctRP.thayDoiSlSPCT(hdct);    
    slThayDoi = slCu - slMoi;
    spSer.tangSL(slThayDoi,spct.getMaSP());
    return 1;
    }
    else{
    JOptionPane.showMessageDialog(this,"Số lượng mới và cũ bằng nhau");
    return 0;
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHD;
    private javax.swing.JButton btnTaoHD1;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThayDoiSL;
    private javax.swing.JButton btnThemVaoGio;
    private javax.swing.JButton btnXoaHD;
    private javax.swing.JButton btnXoaKhoiGio;
    private javax.swing.JButton btnXoaToanBo;
    private javax.swing.JComboBox<String> cbbDotGiamGia;
    private javax.swing.JComboBox<String> cbbKhachHang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblMaHD;
    private javax.swing.JTable tblHDCT;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSPCT;
    private javax.swing.JTextField txtDK;
    private javax.swing.JTextField txtHDCT;
    private javax.swing.JTextField txtMakh;
    private javax.swing.JTextField txtPhanTramGiam;
    private javax.swing.JTextField txtTKSPCT;
    private javax.swing.JTextField txtTienKhachTra;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
