/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.helper;

import com.fpl.shopquanaott.model.SPCT;
import com.fpl.shopquanaott.repository.ChatLieuRepo;
import com.fpl.shopquanaott.repository.LoaiSanPhamRepo;
import com.fpl.shopquanaott.repository.MauSacRepo;
import com.fpl.shopquanaott.repository.SanPhamRepo;
import com.fpl.shopquanaott.repository.SizeRepo;
import com.fpl.shopquanaott.service.SanPhamService;
import com.fpl.shopquanaott.service.impl.SanPhamServiceImpl;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class XuatExcel {
    private SanPhamService spSer = new SanPhamServiceImpl();
    private MauSacRepo msRP = new MauSacRepo();
    private SizeRepo sRP = new SizeRepo();
    private ChatLieuRepo clRP = new ChatLieuRepo();
    private LoaiSanPhamRepo lRP = new LoaiSanPhamRepo();
    private SanPhamRepo tenRP = new SanPhamRepo();
    
    public void xuatFileExcel(){
    try{
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet1 = workbook.createSheet("danh sách SP");
        XSSFRow row = null;
        Cell cell = null;
        
        row = sheet1.createRow(1);
        
        cell = row.createCell(0,CellType.STRING);
        cell.setCellValue("Mã SPCT");
        cell = row.createCell(1,CellType.STRING);
        cell.setCellValue("Tên sản phẩm");
        cell = row.createCell(2,CellType.STRING);
        cell.setCellValue("Màu sắc");
        cell = row.createCell(3,CellType.STRING);
        cell.setCellValue("Size");
        cell = row.createCell(4,CellType.STRING);
        cell.setCellValue("Chất liệu");
        cell = row.createCell(5,CellType.STRING);
        cell.setCellValue("Loại");
        cell = row.createCell(6,CellType.STRING);
        cell.setCellValue("Số lượng");
        cell = row.createCell(7,CellType.STRING);
        cell.setCellValue("Giá gốc");
        cell = row.createCell(8,CellType.STRING);
        cell.setCellValue("Giá bán");
        
        List<SPCT> listSPCT = spSer.getAll();
        for(int i = 0; i<listSPCT.size();i++){
        row = sheet1.createRow(2+i);
        
        cell = row.createCell(0,CellType.STRING);
        cell.setCellValue(listSPCT.get(i).getMaSP());
        
        cell = row.createCell(1,CellType.STRING);
        cell.setCellValue(tenRP.layTen(listSPCT.get(i).getTenSP()));
        
        cell = row.createCell(2,CellType.STRING);
        cell.setCellValue(msRP.layTen(listSPCT.get(i).getMauSac()));
        
        cell = row.createCell(3,CellType.STRING);
        cell.setCellValue(sRP.layTen(listSPCT.get(i).getSizeSP()));
        
        cell = row.createCell(4,CellType.STRING);
        cell.setCellValue(clRP.layTen(listSPCT.get(i).getChatLieu()));
        
        cell = row.createCell(5,CellType.STRING);
        cell.setCellValue(lRP.layTen(listSPCT.get(i).getLoaiSP()));
        
        cell = row.createCell(6,CellType.NUMERIC);
        cell.setCellValue(listSPCT.get(i).getSlTon());
        
        cell = row.createCell(7,CellType.NUMERIC);
        cell.setCellValue(listSPCT.get(i).getGiaNhap());
        
        cell = row.createCell(8,CellType.NUMERIC);
        cell.setCellValue(listSPCT.get(i).getGiaBan());
        }
        
        
        File f = new File("E:\\danhsach.xlsx");
        FileOutputStream fos = new FileOutputStream(f);
        workbook.write(fos);
        fos.close();
        
    }
    catch(Exception e){
    e.printStackTrace();
    }
    
    }
}
