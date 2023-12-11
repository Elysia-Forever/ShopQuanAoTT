/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.ChatLieu;
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
public class ChatLieuRepo {
     String SELECT_ALL_CHATLIEU = "SELECT*FROM CHATLIEU";
     String FIND_BY_ID = "SELECT *FROM CHATLIEU WHERE MACHATLIEU = ?";
     String FIND_BY_TEN = "SELECT *FROM CHATLIEU WHERE TENCHATLIEU = ?";
     String INSERT = "INSERT INTO CHATLIEU(TENCHATLIEU) VALUES (?)";
     String DELETE = "DELETE FROM CHATLIEU WHERE MACHATLIEU = ?";
     String UPDATE = "UPDATE CHATLIEU SET TENCHATLIEU= ? WHERE MACHATLIEU = ?";
     
     
    public List<ChatLieu> selectBySQL(String sql,Object...agrs){
    List<ChatLieu> list = new ArrayList<>();
    
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql,agrs);
            while(rs.next()){
            ChatLieu cl = new ChatLieu(rs.getInt(1),rs.getString(2));
            list.add(cl);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuRepo.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    } 
    
    public List<ChatLieu> getAll(){
    return selectBySQL(SELECT_ALL_CHATLIEU);
    }
    
    public ChatLieu findByMa(int ma){
       return selectBySQL(FIND_BY_ID,ma).get(0);
    }
    
    public ChatLieu findByTen(String ten){
       return selectBySQL(FIND_BY_TEN,ten).get(0);
    }
    
    public void insert(ChatLieu cl){
       JDBCHelper.update(INSERT,cl.getTen());
    }
    
    public void delete(int ma){
       JDBCHelper.update(DELETE,ma);
    }
    
    public void update(ChatLieu ms){
       JDBCHelper.update(UPDATE,ms.getTen(),ms.getMa());
    }
    
    public String layTen(int ma){
     return selectBySQL(FIND_BY_ID, ma).get(0).getTen();
    }
}
