/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import qltdModel.KhachHang;
import qltdModel.ThongTinCaNhan;
import qltdModel.DienKe;
import qltdModel.HoaDon;
import qltdModel.ThongKe;

/**
 *
 * @author Gia Thinh
 */
public class ThongKeController {
    
    private Connect conn = null;
    private ResultSet rs = null;
    private Connection connect =null;
    private  double tongTien, tongTienByDay, tongTienByMonth, tongTienByYear;

    
    public ThongKeController() {
        conn = new Connect();
        connect = conn.getConnect();
    }
//Lấy tất cả danh sách
    public ArrayList<ThongKe> getAllThongKe() {
        
        ArrayList<ThongKe> ls = new ArrayList<>();
        
        try {
            String sSql = "SELECT * FROM((( KhachHang INNER JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT)INNER JOIN DienKe ON KhachHang.MaKH = DienKe.MaKH) INNER JOIN HoaDon ON KhachHang.MaKH = HoaDon.MaKH)";
            rs = conn.loadData(sSql);
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                DienKe dk = new DienKe();
                HoaDon hd = new HoaDon();
                KhachHang kh = new KhachHang();
                ThongTinCaNhan ttcn = new ThongTinCaNhan();
                
                hd.setMaHD(rs.getInt("MaHD"));
                tk.setHd(hd);
                dk.setMaDK(rs.getInt("MaDK"));
                tk.setDk(dk);
                kh.setMaKH(rs.getInt("MaKH"));
                tk.setKh(kh);
                kh.setHoTen(rs.getNString("HoTen"));
                tk.setKh(kh);
                kh.setDiaChi(rs.getNString("DiaChi"));
                tk.setTtcn(kh);
                kh.setTenLSD(rs.getNString("TenLSD"));
                tk.setKh(kh);
                hd.setNgayLap(rs.getString("NgayLap"));
                tk.setHd(hd);
                hd.setTieuThu(rs.getInt("TieuThu"));
                tk.setHd(hd);
                hd.setThanhtien(rs.getDouble("ThanhTien"));
                tk.setHd(hd);
                
                tongTien += rs.getDouble("ThanhTien");
                
                ls.add(tk);
                
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }

        return ls;
    }

    //Hiển thị danh sách thống kê theo ngày tìm kiếm
    public ArrayList<ThongKe> getAllThongKeByDay(int DAY) {
        
        ArrayList<ThongKe> ls = new ArrayList<>();
        
        try {
            String sSql = "SELECT * FROM((( KhachHang INNER JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT)INNER JOIN DienKe ON KhachHang.MaKH = DienKe.MaKH) INNER JOIN HoaDon ON KhachHang.MaKH = HoaDon.MaKH) WHERE DAY(HoaDon.NgayLap) = "+ DAY ;
            rs = conn.loadData(sSql);
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                DienKe dk = new DienKe();
                HoaDon hd = new HoaDon();
                KhachHang kh = new KhachHang();
                ThongTinCaNhan ttcn = new ThongTinCaNhan();
                
                hd.setMaHD(rs.getInt("MaHD"));
                tk.setHd(hd);
                dk.setMaDK(rs.getInt("MaDK"));
                tk.setDk(dk);
                kh.setMaKH(rs.getInt("MaKH"));
                tk.setKh(kh);
                kh.setHoTen(rs.getNString("HoTen"));
                tk.setKh(kh);
                kh.setDiaChi(rs.getNString("DiaChi"));
                tk.setTtcn(kh);
                kh.setTenLSD(rs.getNString("TenLSD"));
                tk.setKh(kh);
                hd.setNgayLap(rs.getString("NgayLap"));
                tk.setHd(hd);
                hd.setTieuThu(rs.getInt("TieuThu"));
                tk.setHd(hd);
                hd.setThanhtien(rs.getDouble("ThanhTien"));
                tk.setHd(hd);
                
                
                tongTienByDay += rs.getDouble("ThanhTien");
                
                ls.add(tk);
                
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }

        return ls;
    }
    
    public ArrayList<ThongKe> getAllThongKeByMonth(int MONTH) {
        
        ArrayList<ThongKe> ls = new ArrayList<>();
        
        try {
            String sSql = "SELECT * FROM((( KhachHang INNER JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT)INNER JOIN DienKe ON KhachHang.MaKH = DienKe.MaKH) INNER JOIN HoaDon ON KhachHang.MaKH = HoaDon.MaKH) WHERE MONTH(HoaDon.NgayLap) = "+ MONTH ;
            rs = conn.loadData(sSql);
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                DienKe dk = new DienKe();
                HoaDon hd = new HoaDon();
                KhachHang kh = new KhachHang();
                ThongTinCaNhan ttcn = new ThongTinCaNhan();
                
                hd.setMaHD(rs.getInt("MaHD"));
                tk.setHd(hd);
                dk.setMaDK(rs.getInt("MaDK"));
                tk.setDk(dk);
                kh.setMaKH(rs.getInt("MaKH"));
                tk.setKh(kh);
                kh.setHoTen(rs.getNString("HoTen"));
                tk.setKh(kh);
                kh.setDiaChi(rs.getNString("DiaChi"));
                tk.setTtcn(kh);
                kh.setTenLSD(rs.getNString("TenLSD"));
                tk.setKh(kh);
                hd.setNgayLap(rs.getString("NgayLap"));
                tk.setHd(hd);
                hd.setTieuThu(rs.getInt("TieuThu"));
                tk.setHd(hd);
                hd.setThanhtien(rs.getDouble("ThanhTien"));
                tk.setHd(hd);
                
                
                tongTienByMonth += rs.getDouble("ThanhTien");
                ls.add(tk);
                
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }

        return ls;
    }
    
    public ArrayList<ThongKe> getAllThongKeByYear(int YEAR) {
        
        ArrayList<ThongKe> ls = new ArrayList<>();
        
        try {
            String sSql = "SELECT * FROM((( KhachHang INNER JOIN ThongTinCaNhan ON KhachHang.CMT = ThongTinCaNhan.CMT)INNER JOIN DienKe ON KhachHang.MaKH = DienKe.MaKH) INNER JOIN HoaDon ON KhachHang.MaKH = HoaDon.MaKH) WHERE YEAR(HoaDon.NgayLap) = "+ YEAR ;
            rs = conn.loadData(sSql);
            while (rs.next()) {
                ThongKe tk = new ThongKe();
                DienKe dk = new DienKe();
                HoaDon hd = new HoaDon();
                KhachHang kh = new KhachHang();
                ThongTinCaNhan ttcn = new ThongTinCaNhan();
                
                hd.setMaHD(rs.getInt("MaHD"));
                tk.setHd(hd);
                dk.setMaDK(rs.getInt("MaDK"));
                tk.setDk(dk);
                kh.setMaKH(rs.getInt("MaKH"));
                tk.setKh(kh);
                kh.setHoTen(rs.getNString("HoTen"));
                tk.setKh(kh);
                kh.setDiaChi(rs.getNString("DiaChi"));
                tk.setTtcn(kh);
                kh.setTenLSD(rs.getNString("TenLSD"));
                tk.setKh(kh);
                hd.setNgayLap(rs.getString("NgayLap"));
                tk.setHd(hd);
                hd.setTieuThu(rs.getInt("TieuThu"));
                tk.setHd(hd);
                hd.setThanhtien(rs.getDouble("ThanhTien"));
                tk.setHd(hd);
                
                
                tongTienByYear += rs.getDouble("ThanhTien");
                ls.add(tk);
                
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }

        return ls;
    }
    public double gettongTien() {
        return tongTien;
    }

    public double getTongTienByDay() {
        return tongTienByDay;
    }

    public double getTongTienByMonth() {
        return tongTienByMonth;
    }

    public double getTongTienByYear() {
        return tongTienByYear;
    }

    public Connection getConnect() {
        return connect;
    }
    
    
}
