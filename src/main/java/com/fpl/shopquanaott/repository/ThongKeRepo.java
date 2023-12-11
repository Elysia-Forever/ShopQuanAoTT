/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import java.math.BigDecimal;
import java.sql.ResultSet;

/**
 *
 * @author admin
 */
public class ThongKeRepo {
     String TONGTIEN_HD = "SELECT SUM(TIENPHAITRA) FROM HOADON WHERE TRANGTHAI = 1";
     String TONGTIEN_HD_THEONGAY = "SELECT SUM(TIENPHAITRA) FROM HOADON WHERE TRANGTHAI = 1 AND NGAYTAO >= ? AND NGAYTAO <=?";
     String SL_SP_DABAN = "SELECT SUM(SL) FROM HOADONCHITIET WHERE MaSanPhamCT = ?";
     String TONGTIEN_HD_HOMNAY = "SELECT SUM(TIENPHAITRA) FROM HOADON WHERE TRANGTHAI = 1 AND DAY(NGAYTAO) = DAY(GETDATE())";
     String TONGTIEN_HD_THANGNAY = "SELECT SUM(TIENPHAITRA) FROM HOADON WHERE TRANGTHAI = 1 AND MONTH(NGAYTAO) = MONTH(GETDATE())";
     String TONGTIEN_HD_NAMNAY = "SELECT SUM(TIENPHAITRA) FROM HOADON WHERE TRANGTHAI = 1 AND YEAR(NGAYTAO) = YEAR(GETDATE())";
    
     public int slHoaDonTT(){
         String HD_DA_TT = "SELECT COUNT(*) FROM HOADON WHERE TRANGTHAI = 1";
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(HD_DA_TT);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      }
      
       public BigDecimal tienHD(String sql,Object...args){
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql,args);
            while (rs.next()) {
                return rs.getBigDecimal(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BigDecimal(0);
      }
       
      public BigDecimal  tongTienHD(){
      return tienHD(TONGTIEN_HD);
      }
      
      public BigDecimal tongTienTimKien(String ngayBD,String ngayKT){
      return tienHD(TONGTIEN_HD_THEONGAY,ngayBD,ngayKT);
      }
      
        public int slSPBan(String maSPCT){
         String SPBAN = SL_SP_DABAN;
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(SPBAN,maSPCT);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      }
        
        
         public int slHoaDonBan(String maNV){
         String NVBAN = "select COUNT(*) FROM HOADON WHERE MaNV = ?";
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(NVBAN,maNV);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      }  
      
        public float doanhThuNV(String maNV){
         String NVBAN = "select sum(TienPhaiTra) from hoadon where MaNV = ?";
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(NVBAN,maNV);
            while (rs.next()) {
                return rs.getFloat(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      }  
        
        
     ////theo ngày
         public int slHoaDonTTNgay(){
         String HD_DA_TT = "SELECT COUNT(*) FROM HOADON WHERE TRANGTHAI = 1 AND DAY(NGAYTAO) = DAY(GETDATE())";
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(HD_DA_TT);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      }
         
      public BigDecimal tongTienHomNay(){
      return tienHD(TONGTIEN_HD_HOMNAY);
      }   
      
    ///theo thang
       public int slHoaDonTTThang(){
         String HD_DA_TT = "SELECT COUNT(*) FROM HOADON WHERE TRANGTHAI = 1 AND MONTH(NGAYTAO) = MONTH(GETDATE())";
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(HD_DA_TT);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      }
       
     public BigDecimal tongTienThangNay(){
      return tienHD(TONGTIEN_HD_THANGNAY);
      }

  ///theo nam
       public int slHoaDonTTNam(){
         String HD_DA_TT = "SELECT COUNT(*) FROM HOADON WHERE TRANGTHAI = 1 AND YEAR(NGAYTAO) = YEAR(GETDATE())";
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(HD_DA_TT);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
      } 
     public BigDecimal tongTienNamNay(){
      return tienHD(TONGTIEN_HD_NAMNAY);
      }  
}
