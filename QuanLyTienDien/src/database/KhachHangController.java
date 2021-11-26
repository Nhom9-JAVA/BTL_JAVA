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
import qltdModel.KhachHang;
import qltdModel.ThongTinCaNhan;

/**
 *
 * @author TIEN THANH HOA
 */
public class KhachHangController {

    private Connect conn = null;
    private ResultSet rs = null;
    private LoaiHinhDVController loaiDV;
    private ThongTinCaNhanController thongTinCN;

    public KhachHangController() {
        conn = new Connect();
        conn.getConnect();
        thongTinCN = new ThongTinCaNhanController();
    }

    public ArrayList<KhachHang> getAllKhachHang() {

        ArrayList<KhachHang> ls = new ArrayList<>();
        try {
            String sSql = "SELECT * FROM KhachHang INNER JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT";
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

    public boolean checkmaKH(int maKH) {
        try {
            String sSql = "SELECT * FROM KhachHang where KhachHang.MaKH = " + maKH;
            rs = conn.loadData(sSql);
            KhachHang kh = new KhachHang();
            while (rs.next()) {
                kh.setMaKH(rs.getInt("MaKH"));
            }
            if (kh.getMaKH() == 0) {
                return false;
            }

        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return true;
    }

    public int ThemKhachHang(KhachHang kh) {
        try {
            thongTinCN.ThemThongTin(new ThongTinCaNhan(kh.getHoTen(), kh.getCMT(), kh.getNgaySinh(), kh.getDiaChi(), kh.getGioiTinh(), kh.getDienThoai()));
            String sqlAddKH = "insert into KhachHang values (?, ?, ?)";
            PreparedStatement ps = conn.excuteData(sqlAddKH);
            ps.setString(1, kh.getCMT());
            ps.setString(2, kh.getNgayBDSD());
            ps.setNString(3, kh.getTenLSD());

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

    public int Update(KhachHang kh) {

        try {
            thongTinCN.SuaThongTin(new ThongTinCaNhan(kh.getHoTen(), kh.getCMT(), kh.getNgaySinh(), kh.getDiaChi(), kh.getGioiTinh(), kh.getDienThoai()));
            String sqlSuaKH = "update KhachHang set CMT  =?, NgayBDSD = ?,TenLSD=?"
                    + " where MaKH = ?";
            PreparedStatement ps = conn.excuteData(sqlSuaKH);
            ps.setString(1, kh.getCMT());
            ps.setString(2, kh.getNgayBDSD());
            ps.setNString(3, kh.getTenLSD());
            ps.setInt(4, kh.getMaKH());

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

    public int Delete(int ma) {
        try {
            thongTinCN.XoaThongTin(getKhachHang(ma).get(0).getCMT());
            String sqlSuaKH = "delete from KhachHang where MaKH = ?";
            PreparedStatement ps = conn.excuteData(sqlSuaKH);
            ps.setInt(1, ma);
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

    public ArrayList<KhachHang> getKhachHang(int MaKH) {
        ArrayList<KhachHang> ls = new ArrayList<>();
        try {
            String sSql = "SELECT * FROM KhachHang INNER JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT WHERE MaKH = " + MaKH;
            rs = conn.loadData(sSql);
            if (rs.next()) {
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

}
