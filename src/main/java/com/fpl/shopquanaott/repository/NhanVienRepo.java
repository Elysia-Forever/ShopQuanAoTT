/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.MauSac;
import com.fpl.shopquanaott.model.NhanVien;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class NhanVienRepo {
      String SELECT_ALL = "select *from NHANVIEN";
      String SELECT_ALL_ID = "SELECT *FROM NHANVIEN WHERE MANHANVIEN = ? ";
      String SELECT_ALL_TEN = "SELECT *FROM NHANVIEN WHERE HoTen = ? ";
      String INSERT = "INSERT INTO NHANVIEN(MANHANVIEN,MACV,HOTEN,EMAIL,SDT,DIACHI,GIOITINH,TRANGTHAI,MATKHAU)"
                      + "VALUES(?,?,?,?,?,?,?,?,?)";
      String DELETE = "DELETE FROM NHANVIEN WHERE MANHANVIEN = ?";
      String UPDATE_TINHTRANG = "UPDATE NHANVIEN SET TRANGTHAI = ? WHERE MANHANVIEN = ?";
      String UPDATE = "UPDATE NHANVIEN SET MACV = ?,HOTEN = ?,EMAIL = ?,SDT = ?,DIACHI = ?,GIOITINH = ? WHERE MANHANVIEN = ?";
      String SELECT_NHANVIEN_BY_MA_SDT = "SELECT *FROM NHANVIEN WHERE MANHANVIEN LIKE ? OR SDT LIKE ?";
      
     public List<NhanVien> selectBySQL(String sql,Object...agrs){
    List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql,agrs);
            while(rs.next()){
            NhanVien nv = new NhanVien();
            nv.setMaNV(rs.getString(1));
            nv.setChucVu(rs.getInt(2));
            nv.setHoTen(rs.getString(3));
            nv.setEmail(rs.getString(4));
            nv.setSdt(rs.getString(5));
            nv.setDiaChi(rs.getString(6));
            nv.setGioiTinh(rs.getInt(7));
            nv.setTrangThai(rs.getInt(8));
            nv.setMatKhau(rs.getString(9));
            list.add(nv);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuRepo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
     
     public List<NhanVien> getAll(){
     return selectBySQL(SELECT_ALL);
     }
     
     public void insert(NhanVien nv){
     JDBCHelper.update(INSERT,nv.getMaNV(),nv.getChucVu(),nv.getHoTen(),nv.getEmail(),nv.getSdt(),
     nv.getDiaChi(),nv.getGioiTinh(),nv.getTrangThai(),nv.getMatKhau());
     }
     
     public void delete(String manv){
     JDBCHelper.update(DELETE,manv);
     }
     
     public void update_tinhtrang(String manv,int tt){
     JDBCHelper.update(UPDATE_TINHTRANG,tt,manv);
     }
     
     public void update(NhanVien nv){
     JDBCHelper.update(UPDATE,nv.getChucVu(),nv.getHoTen(),nv.getEmail(),nv.getSdt(),
     nv.getDiaChi(),nv.getGioiTinh(),nv.getMaNV());
     }
     
     public List<NhanVien> findByMa(String maNV){
     return selectBySQL(SELECT_ALL_ID,maNV);
     }
     
     public List<NhanVien> findByTen(String tenNV){
     return selectBySQL(SELECT_ALL_TEN,tenNV);
     }
     public List<NhanVien> findByMaOrSDT(String tk){
     return selectBySQL(SELECT_NHANVIEN_BY_MA_SDT,"%"+tk+"%","%"+tk+"%");
     }
}
