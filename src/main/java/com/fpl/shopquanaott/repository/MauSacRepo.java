/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.ChatLieu;
import com.fpl.shopquanaott.model.MauSac;
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
public class MauSacRepo {
     String SELECT_ALL_MAUSAC = "SELECT*FROM MAUSAC";
     String FIND_BY_ID = "SELECT *FROM MAUSAC WHERE MAMAUSAC = ?";
     String FIND_BY_TEN = "SELECT *FROM MAUSAC WHERE TENMAUSAC = ?";
     String INSERT = "INSERT INTO MAUSAC(TENMAUSAC) VALUES (?)";
     String DELETE = "DELETE FROM MAUSAC WHERE TENMAUSAC = ?";
     String UPDATE = "UPDATE MAUSAC SET TENMAUSAC = ? WHERE MAMAUSAC = ?";
    
    public List<MauSac> selectBySQL(String sql,Object...agrs){
    List<MauSac> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql,agrs);
            while(rs.next()){
            MauSac ms = new MauSac(rs.getInt(1),rs.getString(2));
            list.add(ms);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuRepo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    
     public List<MauSac> getAll(){
        return selectBySQL(SELECT_ALL_MAUSAC);
    }
     
    public MauSac findByMa(int ma){
       return selectBySQL(FIND_BY_ID,ma).get(0);
    }
    
    public MauSac findByTen(String ten){
       return selectBySQL(FIND_BY_TEN,ten).get(0);
    }
    
    public void insert(MauSac ms){
       JDBCHelper.update(INSERT,ms.getTen());
    }
    
    public void delete(String ten){
       JDBCHelper.update(DELETE,ten);
    }
    
    public void update(MauSac ms){
       JDBCHelper.update(UPDATE,ms.getTen(),ms.getMa());
    }
    
    public String layTen(int ma){
     return selectBySQL(FIND_BY_ID, ma).get(0).getTen();
    }
}
