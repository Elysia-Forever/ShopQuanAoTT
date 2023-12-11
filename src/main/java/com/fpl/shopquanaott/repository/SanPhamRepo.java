/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.Size;
import com.fpl.shopquanaott.model.SanPham;
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
public class SanPhamRepo {
     String SELECT_ALL_TenSanPham = "SELECT*FROM SANPHAM";
     String FIND_BY_ID = "SELECT *FROM SANPHAM WHERE MASP = ?";
     String FIND_BY_TEN = "SELECT *FROM SANPHAM WHERE TEN = ?";
     String INSERT = "INSERT INTO SANPHAM(TEN) VALUES (?)";
     String DELETE = "DELETE FROM SANPHAM WHERE MASP = ?";
     String UPDATE = "UPDATE SANPHAM SET TEN= ? WHERE MASP = ?";
     
    
    public List<SanPham> selectBySQL(String sql,Object...agrs){
    List<SanPham> list = new ArrayList<>();
    
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql,agrs);
            while(rs.next()){
            SanPham tensp = new SanPham(rs.getInt(1),rs.getString(2));
            list.add(tensp);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuRepo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    } 
    
     public List<SanPham> getAll(){
    return selectBySQL(SELECT_ALL_TenSanPham);
    }
     
     public SanPham findByMa(int ma){
       return selectBySQL(FIND_BY_ID,ma).get(0);
    }
    
    public SanPham findByTen(String ten){
       return selectBySQL(FIND_BY_TEN,ten).get(0);
    }
    
    public void insert(SanPham s){
       JDBCHelper.update(INSERT,s.getTenSP());
    }
    
    public void delete(int ma){
       JDBCHelper.update(DELETE,ma);
    }
    
    public void update(SanPham s){
       JDBCHelper.update(UPDATE,s.getTenSP(),s.getMaTen());
    }
    
    public String layTen(int ma){
     return selectBySQL(FIND_BY_ID, ma).get(0).getTenSP();
    }
}
