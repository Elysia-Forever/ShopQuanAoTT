/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.helper;

import com.fpl.shopquanaott.model.HDCT;
import com.fpl.shopquanaott.model.HoaDon;
import com.fpl.shopquanaott.model.KhachHang;
import com.fpl.shopquanaott.model.SPCT;
import com.fpl.shopquanaott.repository.HDCTRepo;
import com.fpl.shopquanaott.repository.HoaDonRepo;
import com.fpl.shopquanaott.repository.KhachHangRepo;
import com.fpl.shopquanaott.repository.MauSacRepo;
import com.fpl.shopquanaott.repository.NhanVienRepo;
import com.fpl.shopquanaott.repository.SPCTRepository;
import com.fpl.shopquanaott.repository.SanPhamRepo;
import com.fpl.shopquanaott.repository.SizeRepo;
import com.fpl.shopquanaott.service.SanPhamService;
import com.fpl.shopquanaott.service.impl.SanPhamServiceImpl;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InHoaDon {
  private HoaDonRepo hdrp = new HoaDonRepo();
  private KhachHangRepo khrp = new KhachHangRepo();
  private NhanVienRepo nvrp = new NhanVienRepo();
  private HDCTRepo hdctRP = new HDCTRepo();
  private SanPhamService spServ = new SanPhamServiceImpl();
  private MauSacRepo msRP = new MauSacRepo();
  private SizeRepo sRP = new SizeRepo();
  private SanPhamRepo tenRP = new SanPhamRepo();
    public void inHoaDonPDF(String maHD){
        //maHD = "HD1";
        HoaDon hd = hdrp.findByMa(maHD).get(0);
        if(hd == null){
        return;
        }
        File f = new File("E:\\" + maHD + ".pdf");
        Document dc = new Document(PageSize.A5,50,50,50,50);
        
      
            try {
                PdfWriter.getInstance(dc,new FileOutputStream(f.getAbsoluteFile().getPath()));
                dc.open();
                
            ///Font chữ   
            Font titleFont = new Font(BaseFont.createFont("D:\\FPT Polytechnic\\Font\\BPG_Glaho_Arial_V5_big.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED));
            titleFont.setSize(20);
            titleFont.setColor(BaseColor.RED);
            Font noiDung = new Font(BaseFont.createFont("D:\\FPT Polytechnic\\Font\\BPG_Glaho_Arial_V5_big.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED));
            noiDung.setSize(12);
            
            //Tiêu đề
            Paragraph tieuDe = new Paragraph("Shop quần áo thể thao",titleFont);
            tieuDe.setAlignment(Element.ALIGN_CENTER);
            dc.add(new Paragraph(tieuDe));
                
            //Thông tin hóa đơn
            dc.add(new Paragraph(" "));
            dc.add(new Paragraph("Mã hóa đơn : "+hd.getMaHD(),noiDung));
            dc.add(new Paragraph("Nhân viên tạo : "+nvrp.findByMa(hd.getMaNV()).get(0).getHoTen(),noiDung));
            dc.add(new Paragraph("Khách hàng : "+khrp.findByMa(hd.getMaKH()).get(0).getTenKh(),noiDung));
            dc.add(new Paragraph("Ngày tạo : "+hd.getNgayTao(),noiDung));
            dc.add(new Paragraph("Tiền khách phải trả : "+hd.getTienPhaiTra()+"  VNĐ",noiDung));
            dc.add(new Paragraph(" "));
            dc.add(new Paragraph("Các sản phẩm của hóa đơn",noiDung));
            
     
       ///TABLE 
                PdfPTable table = new PdfPTable(5);
                table.setWidthPercentage(100);
                table.setSpacingBefore(25);
                table.setSpacingAfter(25);
                Font tableTitle = new Font(BaseFont.createFont("D:\\FPT Polytechnic\\Font\\BPG_Glaho_Arial_V5_big.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED));
                tableTitle.setSize(10);
                tableTitle.setStyle(Font.BOLDITALIC);
                Font ndTable = new Font(BaseFont.createFont("D:\\FPT Polytechnic\\Font\\BPG_Glaho_Arial_V5_big.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED));
                ndTable.setSize(10);
          //Title table
                PdfPCell c1 = new PdfPCell(new Phrase("Sản phảm",tableTitle));
                table.addCell(c1);
                PdfPCell c2 = new PdfPCell(new Phrase("Màu sắc",tableTitle));
                table.addCell(c2);
                PdfPCell c3 = new PdfPCell(new Phrase("Size",tableTitle));
                table.addCell(c3);
                PdfPCell c4 = new PdfPCell(new Phrase("Số lượng",tableTitle));
                table.addCell(c4);
                PdfPCell c5 = new PdfPCell(new Phrase("Tổng giá",tableTitle));
                table.addCell(c5);
           //Sản phẩm
                List<HDCT> listHDCT = hdctRP.getAllByMa(hd.getMaHD());
                for (HDCT h : listHDCT) {
                    SPCT spct = spServ.findByMa(h.getMaSPCT());
                    table.addCell(new Phrase(tenRP.layTen(spct.getTenSP()),ndTable));
                    table.addCell(new Phrase(msRP.layTen(spct.getMauSac()),ndTable));
                    table.addCell(new Phrase(sRP.layTen(spct.getSizeSP()),ndTable));
                    table.addCell(String.valueOf(h.getSl()));
                    table.addCell(String.valueOf(h.getTongGia())+" VND");
                }
                
           
          //ADD table
             dc.add(table);
             
             
             
          //cam on
           Font ketThuc = new Font(BaseFont.createFont("D:\\FPT Polytechnic\\Font\\BPG_Glaho_Arial_V5_big.ttf",BaseFont.IDENTITY_H,BaseFont.EMBEDDED));
           ketThuc.setSize(16);
           ketThuc.setStyle(Font.ITALIC);
           Paragraph bang = new Paragraph("==============================================");
           bang.setAlignment(Element.ALIGN_CENTER);
           Paragraph camon = new Paragraph("Cảm ơn và hẹn gặp lại",ketThuc);
           camon.setAlignment(Element.ALIGN_CENTER);
           dc.add(bang);
           dc.add(camon);
           
           
           //close
           dc.close();
            } catch (FileNotFoundException ex) {
                System.out.println("In thất bại");
                Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            } catch (DocumentException ex) {
                 System.out.println("In thất bại");
            Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
            catch (IOException ex) {
                 System.out.println("In thất bại");
                Logger.getLogger(InHoaDon.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       
       
    }
}
