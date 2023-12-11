/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.model;

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
public class NhanVien {
    private String maNV;
    private int chucVu;
    private String hoTen;
    private String email;
    private String sdt;
    private String diaChi;
    private int gioiTinh;
    private int trangThai;
    private String matKhau;
}
