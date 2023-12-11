/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.ChatLieu;
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
public class KhachHangRepo {
    String SELECT_ALL ="SELECT * FROM KHACHHANG";
    String SELECT_BY_ID = "SELECT *FROM KHACHHANG WHERE MAKHACHHANG = ?";
    String SELECT_BY_TEN = "SELECT *FROM KHACHHANG WHERE HOTENKH = ?";
    String SELECT_BY_SDTKH = "SELECT *FROM KHACHHANG WHERE SDT = ?";
    String SELECT_BY_TEN_OR_MA = "SELECT *FROM KHACHHANG WHERE SDT LIKE ? OR HOTENKH LIKE ?";
    String INSERT = "INSERT INTO KHACHHANG(HOTENKH,SDT,DIACHI,EMAIL,GIOITINH,HANGKH)" 
                     + "VALUES(?,?,?,?,?,?)";
    String DELETE = "DELETE FROM KHACHHANG WHERE MAKHACHHANG = ?";
    String UPDATE = "UPDATE KHACHHANG SET HOTENKH = ?,SDT = ?,DIACHI = ?,EMAIL = ?,GIOITINH =?,HANGKH=? \n" +
                    "WHERE MAKHACHHANG = ?";
    String SELECT_BY_SDT = "select count(*)from khachhang where SDT = ?";        
    
       public List<KhachHang> selectBySQL(String sql,Object...agrs){
          List<KhachHang> list = new ArrayList<>();
    
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql,agrs);
            while(rs.next()){
            KhachHang kh = new KhachHang(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5),rs.getInt(6),rs.getString(7));
            list.add(kh);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuRepo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
       
     public List<KhachHang> selectALL(){
     return selectBySQL(SELECT_ALL);
     }  
     
    public void insertKH(KhachHang kh){
    JDBCHelper.update(INSERT,kh.getTenKh(),kh.getSdt(),kh.getDiaChi(),kh.getEmail(),kh.getGioiTinh(),kh.getHangKH());
    }
    
    public void deleteKH(int makh){
    JDBCHelper.update(DELETE,makh);
    }
    
    public void updateKH(KhachHang kh){
     JDBCHelper.update(UPDATE,kh.getTenKh(),kh.getSdt(),kh.getDiaChi(),kh.getEmail(),kh.getGioiTinh(),kh.getHangKH(),kh.getMaKH());
    }
    
    public List<KhachHang> findByMa(int maKH){
     return selectBySQL(SELECT_BY_ID,maKH);
    }
    
    public List<KhachHang> findByTen(String tenKH){
     return selectBySQL(SELECT_BY_TEN,tenKH);
    }
    public List<KhachHang> findByMaOrTen(String tk){
    return selectBySQL(SELECT_BY_TEN_OR_MA,"%"+tk+"%","%"+tk+"%");
    }
    
    public List<KhachHang> findBySDT(String sdt){
    return selectBySQL(SELECT_BY_SDTKH,sdt);
    }
    
       public int getBySDT(String sdt){
     String sql = SELECT_BY_SDT;
        try {

            ResultSet rs = JDBCHelper.getDataFromQuery(sql,sdt);
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
}
