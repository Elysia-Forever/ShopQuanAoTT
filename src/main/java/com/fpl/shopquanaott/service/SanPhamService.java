/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.fpl.shopquanaott.service;

import com.fpl.shopquanaott.model.SPCT;
import java.util.List;

/**
 *
 * @author admin
 */
public interface SanPhamService {
    List<SPCT> getAll();
    SPCT findByMa(String ma);
    List<SPCT> timTheoLoai(int maLoai);
    int selectMaSPMax();
    void insert(SPCT spct);
    void delete(String maSPCT);
    void update(SPCT spct);
    void trangThai(int trangThai,String ma);
    List<SPCT> findByMauSac(String tenMS);
    List<SPCT> findByMSvaSP(String tenMS,int maSP);
    List<SPCT> timKiemTheoMa(String ma);
    List<SPCT> sanPhamBanHang();
    void tangSL(int sl,String maSPCT);
    void giamSL(int sl,String maSPCT);
    List<SPCT> tkMaOrTenSPCT(String nd);
    int laySLSP(int masp);
   // List<SPCT> selectAll_TenKhoaPhu(String maSPCT);
    
}
