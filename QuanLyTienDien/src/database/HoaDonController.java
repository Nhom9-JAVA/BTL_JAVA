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
import qltdModel.CongNo;
import qltdModel.DienKe;
import qltdModel.HoaDon;
import qltdModel.KhachHang;
import qltdModel.LichSuGiaoDich;

/**
 *
 * @author Quach Thao
 */
public class HoaDonController {

    private Connect conn = null;
    private ResultSet rs = null;

    public HoaDonController() {
        conn = new Connect();
        conn.getConnect();
    }

    public ArrayList<HoaDon> getAllHoaDon() {
        ArrayList<HoaDon> ls = new ArrayList<>();
        try {
            String sSql = "SELECT * FROM HoaDon ";
            rs = conn.loadData(sSql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                KhachHang kh = new KhachHang();
                DienKe dk = new DienKe();
                hd.setMaHD(rs.getInt("MaHD"));
                kh.setMaKH(rs.getInt("MaKH"));
                hd.setKh(kh);
                dk.setMaDK(rs.getInt("MaDK"));
                hd.setDk(dk);
                hd.setTieuThu(rs.getInt("TieuThu"));
                hd.setThanhtien((rs.getDouble("ThanhTien")));
                hd.setNgayLap(String.valueOf(rs.getDate("NgayLap")));
                ls.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
//        System.out.println(ls.get(0).getHoTen());
        return ls;
    }

    public ArrayList<HoaDon> getHoaDonByidKH(int MaKH) {
        ArrayList<HoaDon> ls = new ArrayList<>();
        try {
            String sSql = "SELECT * FROM HoaDon INNER JOIN KhachHang ON KhachHang.MaKH = HoaDon.MaKH WHERE HoaDon.MaKH = " + MaKH;
            rs = conn.loadData(sSql);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                KhachHang kh = new KhachHang();
                DienKe dk = new DienKe();
                hd.setMaHD(rs.getInt("MaHD"));
                kh.setMaKH(rs.getInt("MaKH"));
                hd.setKh(kh);
                dk.setMaDK(rs.getInt("MaDK"));
                hd.setDk(dk);
                hd.setTieuThu(rs.getInt("TieuThu"));
                hd.setThanhtien((rs.getDouble("ThanhTien")));
                hd.setNgayLap(String.valueOf(rs.getDate("NgayLap")));
                ls.add(hd);
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return ls;
    }
    //load tieu thu
    public double KhoangTieuThu(int TieuThu, int TuDM, int DenDM) {
        if (TieuThu <= TuDM) {
            return 0;
        }
        if (TieuThu >= DenDM) {
            return DenDM - TuDM;
        }
        return TieuThu - TuDM;
    }
    
    public double ThanhTien(int TieuThu, String TenLSD) {
        double tinhtien = 0;
        try {
            String sSql = "SELECT * FROM LoaiHinhDV WHERE TenLSD = N'" + TenLSD + "'";
            rs = conn.loadData(sSql);
            while (rs.next()) {
                int TuDM = rs.getInt("TuDM");
                int DenDM = rs.getInt("DenDM");
                int DonGia = rs.getInt("DonGia");
                tinhtien += KhoangTieuThu(TieuThu, TuDM, DenDM) * DonGia;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tinhtien;
    }

    public double Thue(int TieuThu, String TenLSD) {
        double tinhtien = 0;
        double thue = 0;
        double VAT = 0;
        try {
            String sSql = "SELECT * FROM LoaiHinhDV WHERE TenLSD = N'" + TenLSD + "'";
            rs = conn.loadData(sSql);
            while (rs.next()) {
                int TuDM = rs.getInt("TuDM");
                int DenDM = rs.getInt("DenDM");
                int DonGia = rs.getInt("DonGia");
                VAT = ((rs.getInt("ThueVAT")) / 100.0);
                tinhtien += KhoangTieuThu(TieuThu, TuDM, DenDM) * DonGia;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        thue = tinhtien * VAT;
        return thue;
    }

    public void addHoaDon(HoaDon hd) {

        PreparedStatement st = null;
        try {
            String addSql = "INSERT INTO HoaDon(MaKH,MaDK,TieuThu, ThanhTien, NgayLap) VALUES (?,?,?,?,?)";
            st = conn.excuteData(addSql);
            st.setInt(1, hd.getKh().getMaKH());
            st.setInt(2, hd.getDk().getMaDK());
            st.setDouble(3, hd.getTieuThu());
            st.setDouble(4, hd.getThanhtien());
            st.setString(5, hd.getNgayLap());
            int kq = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }

    }

    public void addLS(LichSuGiaoDich ls) {
        PreparedStatement st = null;
        try {
            String addSql = "INSERT INTO LichSuGiaoDich(MaHD,ThoiGianDG,GhiChu) VALUES (?,?,?)";
            st = conn.excuteData(addSql);
            st.setInt(1, ls.getHd().getMaHD());
            st.setString(2, ls.getThoiGianGD());
            st.setNString(3, ls.getGhiChu());
            int kq = st.executeUpdate();
            if (kq != 0) {
                System.out.println("ad ls thanh cong!!");
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
    }

    public void xoaCN(CongNo cn) {
        PreparedStatement st = null;
        try {
            String delSql = "DELETE DSCongNo WHERE NamThang = ? AND MaKH = ?";

            st = conn.excuteData(delSql);
            st.setString(1, cn.getNamThang());
            st.setInt(2, cn.getKh().getMaKH());
            int kq = st.executeUpdate();
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
    }
}
