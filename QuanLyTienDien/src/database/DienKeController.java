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
import java.util.logging.Level;
import java.util.logging.Logger;
import qltdModel.DienKe;
import qltdModel.KhachHang;

/**
 *
 * @author Gia Thinh
 */
public class DienKeController {

    private Connect conn = null;
    private ResultSet rs = null;
    private PreparedStatement ps = null;

    public DienKeController() {
        conn = new Connect();
        conn.getConnect();
    }

    public ArrayList<DienKe> getAllDienKe() {
        ArrayList<DienKe> ls = new ArrayList<>();
        try {
            String sSql = "SELECT *FROM  DienKe";
            rs = conn.loadData(sSql);
            while (rs.next()) {
                DienKe dk = new DienKe();
                KhachHang kh = new KhachHang();
                dk.setMaDK(rs.getInt("MaDK"));
                kh.setMaKH(rs.getInt("MaKH"));
                dk.setKh(kh);
                dk.setNamThang(String.valueOf(rs.getDate("NamThang")));
                dk.setCSC(rs.getInt("CSC"));
                dk.setCSM(rs.getInt("CSM"));
                ls.add(dk);
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return ls;
    }

    public ArrayList<DienKe> getDienKeByMaDK(int madk) {
        ArrayList<DienKe> ls = new ArrayList<>();
        try {
            String sql = "SELECT MaDK, KhachHang.MaKH, NamThang, CSC, CSM FROM KhachHang INNER JOIN DienKe ON DienKe.MaKH = KhachHang.MaKH INNER JOIN ThongTinCaNhan ON ThongTinCaNhan.CMT = KhachHang.CMT where MaDK = " + madk;
            rs = conn.loadData(sql);
            while (rs.next()) {
                DienKe dk = new DienKe();
                KhachHang kh = new KhachHang();
                dk.setMaDK(rs.getInt("MaDK"));
                kh.setMaKH(rs.getInt("MaKH"));
                dk.setKh(kh);
                dk.setNamThang(String.valueOf(rs.getDate("NamThang")));
                dk.setCSC(rs.getInt("CSC"));
                dk.setCSM(rs.getInt("CSM"));
                ls.add(dk);
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return ls;
    }

    public int Insert(DienKe dk) {
        try {
            String sqlSuaDK = "insert into DienKe values(?,?,?,?)";
            ps = conn.excuteData(sqlSuaDK);
            ps.setInt(1, dk.getKh().getMaKH());
            ps.setString(2, dk.getNamThang());
            ps.setInt(3, dk.getCSC());
            ps.setInt(4, dk.getCSM());
            int row = ps.executeUpdate();
            if (row > 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DienKeController.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return -1;
    }

    public int Update(DienKe dk) {

        try {
            String sqlSuaDK = "update DienKe set NamThang = ?, CSC = ?, CSM = ? where MaDK = ? and MaKH  = ? ";
            ps = conn.excuteData(sqlSuaDK);
            ps.setString(1, dk.getNamThang());
            ps.setInt(2, dk.getCSC());
            ps.setInt(3, dk.getCSM());
            ps.setInt(4, dk.getMaDK());
            ps.setInt(5, dk.getKh().getMaKH());
            int row = ps.executeUpdate();
            if (row > 0) {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DienKeController.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return -1;
    }

    public ArrayList<DienKe> getDienKeByidKH(int MaKH) {
        ArrayList<DienKe> ls = new ArrayList<>();
        try {
            String sSql = "SELECT * FROM KhachHang INNER JOIN DienKe ON KhachHang.MaKH = DienKe.MaKH WHERE DienKe.MaKH = " + MaKH;
            rs = conn.loadData(sSql);
            while (rs.next()) {
                DienKe dk = new DienKe();
                KhachHang kh = new KhachHang();
                dk.setMaDK(rs.getInt("MaDK"));
                kh.setMaKH(rs.getInt("MaKH"));
                dk.setKh(kh);
                dk.setNamThang(String.valueOf(rs.getDate("NamThang")));
                dk.setCSC(rs.getInt("CSC"));
                dk.setCSM(rs.getInt("CSM"));
                ls.add(dk);
            }
        } catch (Exception e) {
            System.out.println("Cau truy van dkong dung !!!" + e.getMessage());
        }
        return ls;
    }

    public int LoadLuongTieuThu(int maKH) {
        String x = "";
        String sql = "SELECT * FROM DienKe WHERE MaKH = " + maKH;
        int tieuthu = 0;
        int CSC = 0, CSM = 0;
        rs = conn.loadData(sql);
        try {
            while (rs.next()) {
                CSC = rs.getInt("CSC");
                CSM = rs.getInt("CSM");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        tieuthu = CSM - CSC;
        return tieuthu;
    }

    public int getMaDK(int maKH) {
        String x = "";
        String sql = "SELECT * FROM DienKe WHERE MaKH = " + maKH;
        int maDK = 0;
        int CSC = 0, CSM = 0;
        rs = conn.loadData(sql);
        try {
            while (rs.next()) {
                maDK = rs.getInt("MaDK");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return maDK;
    }

}
