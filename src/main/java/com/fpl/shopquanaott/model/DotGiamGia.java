/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.model;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author admin
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DotGiamGia {
   private String maDot;
   private String tenDot;
   private Date ngayBD;
   private Date ngayKT;
   private int phanTram;
   private float dieuKien;
   private int trangThai;
   
//   @Override
//   public String toString(){
//   }
}
