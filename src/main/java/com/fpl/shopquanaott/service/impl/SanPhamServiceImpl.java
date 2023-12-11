/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.service.impl;

import com.fpl.shopquanaott.model.SPCT;
import com.fpl.shopquanaott.repository.SPCTRepository;
import com.fpl.shopquanaott.service.SanPhamService;
import java.util.List;

/**
 *
 * @author admin
 */
public class SanPhamServiceImpl implements SanPhamService{
    SPCTRepository sprp = new SPCTRepository();
    
    @Override
    public List<SPCT> getAll() {
     return sprp.getAll();
    }

    @Override
    public SPCT findByMa(String ma) {
     return sprp.findByMa(ma);
    }

    @Override
    public List<SPCT> timTheoLoai(int maLoai) {
     return sprp.timTheoLoai(maLoai);
    }

    @Override
    public int selectMaSPMax() {
    return sprp.selectMaSPMax();
    }

    @Override
    public void insert(SPCT spct) {
     sprp.insert(spct);
    }

    @Override
    public void delete(String maSPCT) {
    sprp.delete(maSPCT);
    }

    @Override
    public void update(SPCT spct) {
    sprp.update(spct);
    }

    @Override
    public void trangThai(int trangThai, String ma) {
    sprp.trangThaiSP(trangThai, ma);
    }

    @Override
    public List<SPCT> findByMauSac(String tenMS) {
    return sprp.findByMauSac(tenMS);
    }

    @Override
    public List<SPCT> findByMSvaSP(String tenMS, int maSP) {
    return sprp.findByMSvaSP(tenMS, maSP);
    }

    @Override
    public List<SPCT> timKiemTheoMa(String ma) {
    return sprp.timKiemTheoMa(ma);
    }

    @Override
    public List<SPCT> sanPhamBanHang() {
    return  sprp.sanPhamBanHang();
    }

    @Override
    public void tangSL(int sl, String maSPCT) {
    sprp.tangSL(sl, maSPCT);
    }

    @Override
    public void giamSL(int sl, String maSPCT) {
    sprp.giamSL(sl, maSPCT);
    }

    @Override
    public List<SPCT> tkMaOrTenSPCT(String nd) {
    return sprp.tkMaOrTenSPCT(nd);
    }

    @Override
    public int laySLSP(int masp) {
    return sprp.laySLSP(masp);
    }

       
    
}
