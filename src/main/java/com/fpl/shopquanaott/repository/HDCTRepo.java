/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.HDCT;
import com.fpl.shopquanaott.model.KhachHang;
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
public class HDCTRepo {
    String SELECT_ALL = "SELECT*FROM HOADONCHITIET";
    String SELECT_ALL_BY_MAHD = "SELECT*FROM HOADONCHITIET WHERE MAHoadon = ?";
    String CHECK_TONTAI = "SELECT COUNT(*) FROM HOADONCHITIET WHERE MAHOADON = ? AND MASANPHAMCT = ?";
    String INSERT = "INSERT INTO HOADONCHITIET(MAHOADON,MASANPHAMCT,SL,DONGIA)\n" +
                      "VALUES(?,?,?,?)";
    String UPDATE_SL = "UPDATE HOADONCHITIET SET SL = ?,DONGIA =? WHERE MAHOADON = ? AND MASANPHAMCT = ?";
    String TongTien_HDCT = "select sum(dongia) from hoadonchitiet where MaHoaDon = ?"; 
    String DELETE = "DELETE FROM HOADONCHITIET WHERE MAHOADON = ? AND MASANPHAMCT = ?";
    String THEMSP_DATONTAI = "UPDATE HOADONCHITIET SET SL = SL+?, DonGia = (SL+?)*?\n" +
                             "WHERE MaHoaDon = ? AND MaSanPhamCT = ?";
    String DELETE_ALL_HD = "DELETE FROM HOADONCHITIET WHERE MAHOADON = ?";
    String DEM_HD_BY_MAHD = "SELECT COUNT(*) FROM HOADONCHITIET WHERE MAHOADON = ?";
    public List<HDCT> selectBySQL(String sql,Object...agrs){
          List<HDCT> list = new ArrayList<>();
    
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql,agrs);
            while(rs.next()){
            HDCT hdct = new HDCT(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getFloat(4));
            list.add(hdct);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuRepo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
      
      public List<HDCT> getAllByMa(String maHD){
      return selectBySQL(SELECT_ALL_BY_MAHD,maHD);
      }
      
      public int checkTT(String maHD,String maSPCT){
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(CHECK_TONTAI,maHD,maSPCT);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      }
      
      public float tongTienHDCT(String maHD){
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(TongTien_HDCT,maHD);
            while (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      }
      
      public void insert(HDCT hdct){
      JDBCHelper.update(INSERT,hdct.getMaHD(),hdct.getMaSPCT(),hdct.getSl(),hdct.getTongGia());
      }
      
      public void delete(String maHD,String maSPCT){
      JDBCHelper.update(DELETE,maHD,maSPCT);
      }
      
      public void updateSPTonTai(HDCT hdct,float giaSP){
      JDBCHelper.update(THEMSP_DATONTAI,hdct.getSl(),hdct.getSl(),giaSP,hdct.getMaHD(),hdct.getMaSPCT());
      }
      
      public void delete_allByHD(String maHD){
      JDBCHelper.update(DELETE_ALL_HD,maHD);
      }
      
         public int checkDeXoaHD(String maHD){
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(DEM_HD_BY_MAHD,maHD);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      }
      
      
      
     public float testNull(String maHD){
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(TongTien_HDCT, maHD);
        if (rs.next()) {
            float tongTien = rs.getFloat(1);
            if (!rs.wasNull()) {
                return tongTien;
            } else {
                // Giá trị là NULL
                // Xử lý theo ý muốn, ví dụ trả về 0
                return 100;
            }
        }
            
        }catch (Exception e) {
            e.printStackTrace();
         }
        return 0;
      }
     
     public void thayDoiSlSPCT(HDCT hdct){
     JDBCHelper.update(UPDATE_SL,hdct.getSl(),hdct.getTongGia(),hdct.getMaHD(),hdct.getMaSPCT());
     }
}
