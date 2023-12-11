/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.HoaDon;
import com.fpl.shopquanaott.model.LoaiSanPham;
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
public class HoaDonRepo {
    String SELECT_ALL = "SELECT *FROM HOADON";
    String SELECT_ALL_CHUATT = "SELECT *FROM HOADON WHERE TRANGTHAI != 1";
    String SELECT_BY_TRANGTHAI = "SELECT *FROM HOADON WHERE TRANGTHAI = ?";
    String FIND_BY_MA = "SELECT *FROM HOADON WHERE MAHOADON = ?";
    String INSERT = "INSERT INTO HOADON(MAHOADON,MANV,MAKH,MADOT,NGAYTAO,TONGTIEN,TIENPHAITRA,TRANGTHAI)\n" +
                    "VALUES(?,?,?,?,GETDATE(),?,?,?)";
    String UPDATE_TONGTIEN = "UPDATE HOADON SET TONGTIEN = ?,TIENPHAITRA=? WHERE MAHOADON = ?";
    String UPDATE_KH = "UPDATE HOADON SET MAKH = ? WHERE MAHOADON = ?";
    String THANHTOAN = "UPDATE HOADON SET TRANGTHAI = 1 WHERE MAHOADON = ?";
    String UPDATE_DOTGG = "UPDATE HOADON SET MADOT = ? WHERE MAHOADON = ?";
    String SELECT_BY_DATE = "SELECT *FROM HOADON WHERE NGAYTAO >= ? AND NGAYTAO <= ?";
    String DELETE = "DELETE FROM HOADON WHERE MAHOADON = ?";
    String HUY_DOT = "UPDATE HOADON SET MADOT = 'DOT0',TIENPHAITRA = TONGTIEN WHERE MAHOADON = ?";
    public List<HoaDon> selectBySQL(String sql,Object...agrs){
    List<HoaDon> list = new ArrayList<>();
    
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql,agrs);
            while(rs.next()){
            HoaDon hd = new HoaDon(rs.getString(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getFloat(7),rs.getInt(8));
            list.add(hd);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuRepo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
    public List<HoaDon> getAll(){
    return selectBySQL(SELECT_ALL);
    }
    
    public List<HoaDon> getAllChuaTT(){
    return selectBySQL(SELECT_ALL_CHUATT);
    }
    
    public List<HoaDon> findByMa(String maHD){
    return selectBySQL(FIND_BY_MA,maHD);
    }
    
      public int selectMaMax() {
        String sql = "select max(cast(substring(MAHOADON,3,LEN(MAHOADON))as int)) from HOADON";
        try {

            ResultSet rs = JDBCHelper.getDataFromQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
    
    public void insert(HoaDon hd){
    JDBCHelper.update(INSERT,hd.getMaHD(),hd.getMaNV(),hd.getMaKH(),hd.getMaDot(),hd.getTongTien(),hd.getTienPhaiTra(),hd.getTrangThai());
    }
    
    public void update_tongtien(HoaDon hd){
    JDBCHelper.update(UPDATE_TONGTIEN,hd.getTongTien(),hd.getTienPhaiTra(),hd.getMaHD());
    }
    
    public void update_kh(HoaDon hd){
    JDBCHelper.update(UPDATE_KH,hd.getMaKH(),hd.getMaHD());
    }
    
    public void thanhToan(String maHD){
    JDBCHelper.update(THANHTOAN,maHD);
    }
    
    public void update_dot(HoaDon hd){
        JDBCHelper.update(UPDATE_DOTGG,hd.getMaDot(),hd.getMaHD());
    }
    
    public void delete(String maHD){
     JDBCHelper.update(DELETE,maHD);
    }
    
    public List<HoaDon> selectByTT(int tt){
     return selectBySQL(SELECT_BY_TRANGTHAI,tt);
    }
    
    public List<HoaDon> timKiemTheoNgay(String ngayBD,String ngayKT){
    return selectBySQL(SELECT_BY_DATE,ngayBD,ngayKT);
    }
    public void huyDotGG(String maHD){
     JDBCHelper.update(HUY_DOT,maHD);
    }
}
