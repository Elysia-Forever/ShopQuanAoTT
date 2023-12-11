/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpl.shopquanaott.helper;

import com.fpl.shopquanaott.model.NhanVien;

/**
 *
 * @author admin
 */
public class NhanVienHelp {
    public static NhanVien user = null;
    
    public static void logOut(){
      NhanVienHelp.user = null;
    }
    
    public static boolean isLogin(){
    return NhanVienHelp.user != null;
    }
    
    public static boolean isQuanLy(){
    return NhanVienHelp.isLogin() && user.getChucVu() == 1;
    }
}
