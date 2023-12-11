/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.DotGiamGia;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DotGIamGiaDAO {
    final String SELECT_ALL_SEARCH = "SELECT * FROM DOTGIAMGIA WHERE NGAYBATDAU >= ? AND NGAYKETTHUC <= ?";

    final String INSERT_SQL = "INSERT INTO DOTGIAMGIA(MaDot,TenDot,NgayBatDau,NgayKetThuc,PhanTramGiam,TrangThai,DieuKien) VALUES(?,?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE DOTGIAMGIA SET TENDOT = ?, NGAYBATDAU = ?, NGAYKETTHUC = ?, PhanTramGiam = ?, DieuKien =? WHERE MaDot = ? ";
    final String DELETE_SQL = "DELETE FROM DOTGIAMGIA WHERE MADOT = ?";
    final String SELECT_ALL_SQL = "SELECT *FROM DOTGIAMGIA";
    final String SELECT_BY_ID = "SELECT * FROM  DOTGIAMGIA WHERE MADOT = ?";
    final String SELECT_BY_TEN = "SELECT * FROM DOTGIAMGIA WHERE TENDOT = ?";
    final String UPDATE_TRANGTHAI = "UPDATE DOTGIAMGIA SET TRANGTHAI = ? WHERE MADOT = ?";
    final String UPDATE_CHUAHETHAN = "UPDATE DOTGIAMGIA SET TRANGTHAI = 1\n" +
                                     "WHERE CAST(NGAYKETTHUC AS DATE) > CAST(GETDATE() AS DATE)";
    final String SELECT_CONHAN = "SELECT*FROM DOTGIAMGIA WHERE TRANGTHAI = 1";
    
    public List<DotGiamGia> selectBySql(String sql, Object... args) {
        List<DotGiamGia> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql, args);
            while (rs.next()) {                
                DotGiamGia entity = new DotGiamGia();
                entity.setMaDot(rs.getString("MADOT"));
                entity.setTenDot(rs.getString("TENDOT"));
                entity.setNgayBD(rs.getDate("NGAYBATDAU"));
                entity.setNgayKT(rs.getDate("NGAYKETTHUC"));
                entity.setPhanTram(rs.getInt("PHANTRAMGIAM"));
                entity.setTrangThai(rs.getInt("TRANGTHAI"));
                entity.setDieuKien(rs.getFloat("DieuKien"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
       public int selectMaMax() {
        String sql = "select max(cast(substring(MADOT,4,LEN(MADOT))as int)) from DOTGIAMGIA";
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
    
    public List<DotGiamGia> getAll(){
    return selectBySql(SELECT_ALL_SQL);
    }
    
    public void insert(DotGiamGia dgg){
    JDBCHelper.update(INSERT_SQL,dgg.getMaDot(),dgg.getTenDot(),dgg.getNgayBD(),dgg.getNgayKT(),dgg.getPhanTram(),dgg.getTrangThai(),dgg.getDieuKien());
    }
    
    
    public void ngungDot(String maDot){
    JDBCHelper.update(UPDATE_TRANGTHAI,0,maDot);
    }
    
    public void delete(String maDot){
    JDBCHelper.update(DELETE_SQL,maDot);
    }
    
    public void update(DotGiamGia dgg){
    JDBCHelper.update(UPDATE_SQL,dgg.getTenDot(),dgg.getNgayBD(),dgg.getNgayKT(),dgg.getPhanTram(),dgg.getDieuKien(),dgg.getMaDot());
    }
    
    public void chuaHetHan(){
    JDBCHelper.update(UPDATE_CHUAHETHAN);
    }
    
    public List<DotGiamGia> findByMa(String maDot){
     return selectBySql(SELECT_BY_ID,maDot);
    }
    
    public List<DotGiamGia> findByTen(String tenDot){
     return selectBySql(SELECT_BY_TEN,tenDot);
    }
    public List<DotGiamGia> selectConHan(){
    return selectBySql(SELECT_CONHAN);
    }
    
    public List<DotGiamGia> selectAllSearchDate(String ngayBD,String ngayKT){
    return selectBySql(SELECT_ALL_SEARCH,ngayBD,ngayKT);
    }
}
