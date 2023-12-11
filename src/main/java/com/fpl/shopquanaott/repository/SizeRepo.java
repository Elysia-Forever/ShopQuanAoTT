/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.ChatLieu;
import com.fpl.shopquanaott.model.Size;
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
public class SizeRepo {
     String SELECT_ALL_SIZE = "SELECT*FROM SIZE";
     String FIND_BY_ID = "SELECT *FROM SIZE WHERE MASIZE = ?";
     String FIND_BY_TEN = "SELECT *FROM SIZE WHERE TENSIZE = ?";
     String INSERT = "INSERT INTO SIZE(TENSIZE) VALUES (?)";
     String DELETE = "DELETE FROM SIZE WHERE MASIZE = ?";
     String UPDATE = "UPDATE SIZE SET TENSIZE= ? WHERE MASIZE = ?";
    
    public List<Size> selectBySQL(String sql,Object...agrs){
    List<Size> list = new ArrayList<>();
    
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql,agrs);
            while(rs.next()){
           Size s = new Size(rs.getInt(1),rs.getString(2));
            list.add(s);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuRepo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    } 
    
     public List<Size> getAll(){
    return selectBySQL(SELECT_ALL_SIZE);
    }
     
     public Size findByMa(int ma){
       return selectBySQL(FIND_BY_ID,ma).get(0);
    }
    
    public Size findByTen(String ten){
       return selectBySQL(FIND_BY_TEN,ten).get(0);
    }
    
    public void insert(Size s){
       JDBCHelper.update(INSERT,s.getTen());
    }
    
    public void delete(int ma){
       JDBCHelper.update(DELETE,ma);
    }
    
    public void update(Size s){
       JDBCHelper.update(UPDATE,s.getTen(),s.getMa());
    }
    
    public String layTen(int ma){
     return selectBySQL(FIND_BY_ID, ma).get(0).getTen();
    }
}
