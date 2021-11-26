/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import qltdModel.NhanVien;

/**
 *
 * @author TIEN THANH HOA
 */
public class NhanVienController {

    private Connect conn = null;
    private String sSql = "";
    private ResultSet rs = null;

    public NhanVienController() {
        conn = new Connect();
        conn.getConnect();
    }
    
    public NhanVien checkAdmin(String tk,String mk){
        NhanVien nv = new NhanVien();
        try {
            sSql = "SELECT * FROM NhanVien INNER JOIN ThongTinCaNhan ON NhanVien.CMT = ThongTinCaNhan.CMT WHERE TaiKhoan = '"+tk+"' AND MatKhau = '"+mk+"'";
            rs = conn.loadData(sSql);
            if(rs.next()){
                nv.setMaNV(rs.getInt("MaNV"));
                nv.setHoTen(rs.getNString("HoTen"));
                nv.setDiaChi(rs.getNString("DiaChi"));
                nv.setDienThoai(rs.getString("DienThoai"));
                nv.setNgaySinh(String.valueOf(rs.getDate("NgaySinh")));
                nv.setGioiTinh(rs.getNString("GioiTinh"));
                nv.setCMT(rs.getString("CMT"));
                nv.setTaiKhoan(rs.getString("TaiKhoan"));
                nv.setMatKhau(rs.getString("MatKhau")); 
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!"+e.getMessage());
        }
        return nv;
    }
}
