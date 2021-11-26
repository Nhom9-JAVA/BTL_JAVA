/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import qltdModel.ThongTinCaNhan;

/**
 *
 * @author TIEN THANH HOA
 */
public class ThongTinCaNhanController {
    private Connect conn = null;
    private ResultSet rs = null;

    public ThongTinCaNhanController() {
        conn = new Connect();
        conn.getConnect();
    }
    

    public int ThemThongTin(ThongTinCaNhan thcn) {
        try {
            String sqlAddThongTin = "insert into ThongTinCaNhan values (?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = conn.excuteData(sqlAddThongTin);
            ps.setNString(1, thcn.getHoTen());
            ps.setString(2, thcn.getCMT());
            ps.setString(3, thcn.getNgaySinh());
            ps.setNString(4, thcn.getDiaChi());
            ps.setNString(5, thcn.getGioiTinh());
            ps.setString(6, thcn.getDienThoai());

            int row = ps.executeUpdate();

            if (row > 0) {
                return 1;
            }

        } catch (SQLException ex) {
            System.out.println("Cau truy van khong dung!!" + ex.getMessage());
            return 0;
        }
        return -1;
    }

    public int SuaThongTin(ThongTinCaNhan thcn) {

        try {
            String sqlSuaThongTin = "update ThongTinCaNhan set HoTen = ?,NgaySinh = ?,DiaChi = ?,GioiTinh = ?,DienThoai = ? "
                    + " where CMT = ?";
            PreparedStatement ps = conn.excuteData(sqlSuaThongTin);
            ps.setNString(1, thcn.getHoTen());
            ps.setString(2, thcn.getNgaySinh());
            ps.setNString(3, thcn.getDiaChi());
            ps.setNString(4, thcn.getGioiTinh());
            ps.setString(5, thcn.getDienThoai());
            ps.setString(6, thcn.getCMT());

            int row = ps.executeUpdate();

            
            if (row > 0 ) {
                return 1;
            }
        } catch (SQLException ex) {
            System.out.println("Cau truy van khong dung!!" + ex.getMessage());
            return 0;
        }
        return -1;
    }

    public int XoaThongTin(String cmt) {
        try {
            String sqlXoaThongTin = "delete from ThongTinCaNhan where CMT = ?";
   
            PreparedStatement ps = conn.excuteData(sqlXoaThongTin);
            ps.setString(1,cmt);
            int row = ps.executeUpdate();
            if (row > 0) {
                return 1;
            }
        } catch (SQLException ex) {
            System.out.println("Cau truy van khong dung!!" + ex.getMessage());
            return 0;
        }
        return -1;
    }
 
}
