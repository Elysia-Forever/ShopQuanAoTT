/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.repository;

import com.fpl.shopquanaott.helper.JDBCHelper;
import com.fpl.shopquanaott.model.SPCT;
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
public class SPCTRepository {
    String SELECT_ALL = "SELECT *FROM SANPHAMCHITIET";
    String SELECT_SP_BANHANG = "SELECT *FROM SANPHAMCHITIET WHERE SLTON>0 AND TINHTRANG = 1";
    
    String SELECT_ALL_THEOTEN = "SELECT MASPCT,Ten,TenLoai,TenSize,TENMAUSAC,TENCHATLIEU,SLTON,GiaGoc,GiaBan,TinhTrang,Anh FROM SANPHAMCHITIET\n" +
"INNER JOIN LoaiSP ON SANPHAMCHITIET.MaLoai = LoaiSP.MaLoai\n" +
"INNER JOIN Size ON SANPHAMCHITIET.MaSize = Size.MaSize\n" +
"INNER JOIN MauSac ON SANPHAMCHITIET.MaMauSac = MauSac.MaMauSac\n" +
"INNER JOIN ChatLieu ON SANPHAMCHITIET.MaChatLieu = ChatLieu.MaChatLieu\n" +
"INNER JOIN SANPHAM ON SANPHAMCHITIET.MaSP = SANPHAM.MaSP\n"  +
"WHERE MASPCT = ?";
    
    String FIND_BY_MA = "SELECT *FROM SANPHAMCHITIET WHERE MASPCT = ?";
    String FIND_BY_LIKE_MA = "SELECT *FROM SANPHAMCHITIET WHERE MASPCT LIKE ?";
  //  String FIND_BY_LOAI = "SELECT *FROM SANPHAMCHITIET WHERE MALOAI=?";
    String FIND_BY_TENSP = "SELECT *FROM SANPHAMCHITIET WHERE MASP=?";
    String INSERT = "INSERT INTO SANPHAMCHITIET(MaSPCT,MaSP,MaLoai,MaSize,MaMauSac,MaChatLieu,SLTon,GiaGoc,GiaBan,TinhTrang,Anh)\n" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    String DELETE = "DELETE FROM SANPHAMCHITIET WHERE MASPCT = ?";
    
    String UPDATE = "UPDATE SANPHAMCHITIET SET MaSP = ?,MaLoai = ?,MaSize = ?,MaMauSac = ?,MaChatLieu = ?,SLTon = ?,\n" +
                    "GiaGoc = ?,GiaBan = ?,TinhTrang = ?,Anh = ? WHERE MaSPCT = ?";
    String UPDATE_TRANGTHAI = "UPDATE SANPHAMCHITIET SET TinhTrang = ?\n" +
                              "WHERE MaSPCT = ?";
    
    String FIND_BY_MAUSAC = "SELECT * FROM SANPHAMCHITIET INNER JOIN MAUSAC ON SANPHAMCHITIET.MAMAUSAC = MAUSAC.MAMAUSAC\n" +
                            "WHERE TENMAUSAC = ?";
     String FIND_BY_MAUSAC_MASP = "SELECT * FROM SANPHAMCHITIET INNER JOIN MAUSAC ON SANPHAMCHITIET.MAMAUSAC = MAUSAC.MAMAUSAC\n" +
                            "WHERE TENMAUSAC = ? AND MASP = ?";
    String UPDATE_TANGSL = "UPDATE SANPHAMCHITIET SET SLTON = SLTON + ? WHERE MASPCT = ? "; 
    String UPDATE_GIAMSL = "UPDATE SANPHAMCHITIET SET SLTON = SLTON - ? WHERE MASPCT = ? "; 
    String FIND_BY_TENSP_MASPCT = "select *from SANPHAMCHITIET INNER JOIN SANPHAM ON SANPHAMCHITIET.MaSP = SANPHAM.MaSP\n" +
                                  "WHERE MaSPCT LIKE ? OR SanPham.Ten LIKE ? AND TINHTRANG =1 AND SLTON >0";
    String SELECT_SL_SP = "SELECT SUM(SLTON) FROM SANPHAMCHITIET WHERE MASP = ?";
    
    public List<SPCT> selectBySql(String sql,Object...arg){
    List<SPCT> listSP = new ArrayList<>();
    
        try {
            ResultSet rs = JDBCHelper.getDataFromQuery(sql, arg);
            while(rs.next()){
            SPCT sp = new SPCT(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getFloat(8),rs.getFloat(9),rs.getInt(10),rs.getString(11));
            listSP.add(sp);
            }
            rs.getStatement().getConnection().close();
            return listSP;
        } catch (SQLException ex) {
            Logger.getLogger(SPCTRepository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
        
    public List<SPCT> getAll(){
    return selectBySql(SELECT_ALL);
    }
    
    public SPCT findByMa(String ma){
    return selectBySql(FIND_BY_MA,ma).get(0);
    }
    
    public List<SPCT> timTheoLoai(int maLoai){
    return selectBySql(FIND_BY_TENSP,maLoai);
    }
    
    public List<SPCT> timKiemTheoMa(String ma){
    return selectBySql(FIND_BY_LIKE_MA,"%"+ma+"%");
    }
    
    //lấy mã cao nhất trong sql
       public int selectMaSPMax() {
        String sql = "select max(cast(substring(MASPCT,3,LEN(MASPCT))as int)) from SanPhamChiTiet";
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
     
    public void insert(SPCT spct){
      JDBCHelper.update(INSERT,spct.getMaSP(),spct.getTenSP(),spct.getLoaiSP(),spct.getSizeSP()
      ,spct.getMauSac(),spct.getChatLieu(),spct.getSlTon(),spct.getGiaNhap(),spct.getGiaNhap(),spct.getTinhTrang(),spct.getAnh());
    }
    
    public void delete(String maSPCT){
    JDBCHelper.update(DELETE,maSPCT);
    }
    
    public void update(SPCT spct){
    JDBCHelper.update(UPDATE,spct.getTenSP(),spct.getLoaiSP(),spct.getSizeSP(),spct.getMauSac(),spct.getChatLieu(),
    spct.getSlTon(),spct.getGiaNhap(),spct.getGiaNhap(),spct.getTinhTrang(),spct.getAnh(),spct.getMaSP());
    }
    
    public void trangThaiSP(int trangThai,String maSPCT){
    JDBCHelper.update(UPDATE_TRANGTHAI,trangThai,maSPCT);
    }
    
    public List<SPCT> findByMauSac(String tenMS){
    return selectBySql(FIND_BY_MAUSAC,tenMS);
    }
    public List<SPCT> findByMSvaSP(String tenMS,int maSP){
    return selectBySql(FIND_BY_MAUSAC_MASP,tenMS,maSP);
    }
    
    public List<SPCT> sanPhamBanHang(){
    return selectBySql(SELECT_SP_BANHANG);
    }
    
    public void tangSL(int sl,String maSPCT){
    JDBCHelper.update(UPDATE_TANGSL,sl,maSPCT);
    }
    
    public void giamSL(int sl,String maSPCT){
    JDBCHelper.update(UPDATE_GIAMSL,sl,maSPCT);
    }
    
    public List<SPCT> tkMaOrTenSPCT(String nd){
    return selectBySql(FIND_BY_TENSP_MASPCT,"%"+nd+"%","%"+nd+"%");
    }
    
//    public List<SPCT> selectAll_TenKhoaPhu(String maSPCT){
//   return selectBySql(SELECT_ALL_THEOTEN,maSPCT);
//    }
    public int laySLSP(int masp){
     String sql = SELECT_SL_SP;
        try {

            ResultSet rs = JDBCHelper.getDataFromQuery(sql,masp);
            while (rs.next()) {
                return rs.getInt(1);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }
}
