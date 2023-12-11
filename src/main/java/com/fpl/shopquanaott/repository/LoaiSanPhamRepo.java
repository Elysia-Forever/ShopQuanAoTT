/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.ChatLieu;
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
public class LoaiSanPhamRepo {
     String SELECT_ALL_LoaiSP = "SELECT*FROM LoaiSP";
     String FIND_BY_ID = "SELECT *FROM LoaiSP WHERE MALoai = ?";
     String FIND_BY_TEN = "SELECT *FROM LoaiSP WHERE TENLoai = ?";
     String INSERT = "INSERT INTO LoaiSP(TENLoai) VALUES (?)";
     String DELETE = "DELETE FROM LoaiSP WHERE MALoai = ?";
     String UPDATE = "UPDATE LoaiSP SET TENLoai= ? WHERE MALoai = ?";
    
    public List<LoaiSanPham> selectBySQL(String sql,Object...agrs){
    List<LoaiSanPham> list = new ArrayList<>();
    
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql,agrs);
            while(rs.next()){
            LoaiSanPham lsp = new LoaiSanPham(rs.getInt(1),rs.getString(2));
            list.add(lsp);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuRepo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
    
    public List<LoaiSanPham> getAll(){
    return selectBySQL(SELECT_ALL_LoaiSP);
    }
    
     public LoaiSanPham findByMa(int ma){
       return selectBySQL(FIND_BY_ID,ma).get(0);
    }
    
    public LoaiSanPham findByTen(String ten){
       return selectBySQL(FIND_BY_TEN,ten).get(0);
    }
    
    public void insert(LoaiSanPham l){
       JDBCHelper.update(INSERT,l.getTen());
    }
    
    public void delete(int ma){
       JDBCHelper.update(DELETE,ma);
    }
    
    public void update(LoaiSanPham l){
       JDBCHelper.update(UPDATE,l.getTen(),l.getMa());
    }
    
    public String layTen(int ma){
     return selectBySQL(FIND_BY_ID, ma).get(0).getTen();
    }
}
