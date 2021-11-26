/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import qltdModel.CongNo;
import qltdModel.KhachHang;
import qltdModel.ThongTinCaNhan;

/**
 *
 * @author thu
 */
public class CongNoController {

    private Connect conn = null;
    private ResultSet rs = null;
    private KhachHangController khachHang;

    public CongNoController() {
        conn = new Connect();
        conn.getConnect();
        khachHang = new KhachHangController();
    }

    public ArrayList<CongNo> getAllDSCongNo() {

        ArrayList<CongNo> ls = new ArrayList<>();
        try {
            String sSql = "SELECT * FROM DSCongNo JOIN KhachHang ON KhachHang.MaKH = DSCongNo.MaKH  JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT ORDER BY DSCongNo.MaKH DESC";
            //load dữ liệu từ csdl
            rs = conn.loadData(sSql);
            while (rs.next()) {
                CongNo cn = new CongNo();
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt(5));
                kh.setCMT(rs.getString(6));
                kh.setNgayBDSD(rs.getString(7));
                kh.setTenLSD(rs.getNString(8));
                kh.setHoTen(rs.getNString(9));
                kh.setNgaySinh(rs.getString(11));
                kh.setDiaChi(rs.getNString(12));
                kh.setGioiTinh(rs.getNString(13));
                kh.setDienThoai(rs.getString(14));
                cn.setMaDSCN(rs.getInt(1));
                cn.setKh(kh);
                cn.setNamThang(rs.getString(3));
                cn.setGhiChu(rs.getString(4));
                ls.add(cn);
            }

        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return ls;
    }

    public ArrayList<KhachHang> getAllKhachHangDaNop() {

        ArrayList<KhachHang> ls = new ArrayList<>();
        try {
            String sSql = "SELECT * FROM KhachHang INNER JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT  WHERE KhachHang.MaKH NOT IN (SELECT MaKH FROM DSCongNo) ORDER BY KhachHang.MaKH DESC";
            rs = conn.loadData(sSql);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt(1));
                kh.setCMT(rs.getString(2));
                kh.setNgayBDSD(rs.getString(3));
                kh.setTenLSD(rs.getNString(4));
                kh.setHoTen(rs.getNString(5));
                kh.setNgaySinh(rs.getString(7));
                kh.setDiaChi(rs.getNString(8));
                kh.setGioiTinh(rs.getNString(9));
                kh.setDienThoai(rs.getString(10));
                ls.add(kh);
            }

        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return ls;
    }

    public ArrayList<KhachHang> TimKiemKhachHang(String MaKH) {

        ArrayList<KhachHang> ls = new ArrayList<>();
        try {
            String sSql = "SELECT * FROM KhachHang INNER JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT  WHERE KhachHang.MaKH NOT IN (SELECT MaKH FROM DSCongNo) AND KhachHang.MaKH=" + MaKH + " ORDER BY KhachHang.MaKH DESC";
            rs = conn.loadData(sSql);
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt(1));
                kh.setCMT(rs.getString(2));
                kh.setNgayBDSD(rs.getString(3));
                kh.setTenLSD(rs.getNString(4));
                kh.setHoTen(rs.getNString(5));
                kh.setNgaySinh(rs.getString(7));
                kh.setDiaChi(rs.getNString(8));
                kh.setGioiTinh(rs.getNString(9));
                kh.setDienThoai(rs.getString(10));
                ls.add(kh);
            }

        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return ls;
    }

    public ArrayList<CongNo> getTimKiemDSCongNo(String MaKH) {

        ArrayList<CongNo> ls = new ArrayList<>();
        try {
            String sSql = "SELECT * FROM DSCongNo JOIN KhachHang ON KhachHang.MaKH = DSCongNo.MaKH  JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT WHERE KhachHang.MaKH=" + MaKH + " ORDER BY DSCongNo.MaKH DESC";
            rs = conn.loadData(sSql);
            while (rs.next()) {
                CongNo cn = new CongNo();
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt(5));
                kh.setCMT(rs.getString(6));
                kh.setNgayBDSD(rs.getString(7));
                kh.setTenLSD(rs.getNString(8));
                kh.setHoTen(rs.getNString(9));
                kh.setNgaySinh(rs.getString(11));
                kh.setDiaChi(rs.getNString(12));
                kh.setGioiTinh(rs.getNString(13));
                kh.setDienThoai(rs.getString(14));
                cn.setMaDSCN(rs.getInt(1));
                cn.setKh(kh);
                cn.setNamThang(rs.getString(3));
                cn.setGhiChu(rs.getString(4));
                ls.add(cn);
            }

        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return ls;
    }

    public int ThemCongNo(CongNo cn) {
        try {
            String sqlAddKH = "insert into DSCongNo values (?, ?, ?)";
            PreparedStatement ps = conn.excuteData(sqlAddKH);
            ps.setInt(1, cn.getKh().getMaKH());
            ps.setString(2, cn.getNamThang());
            ps.setNString(3, cn.getGhiChu());
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
