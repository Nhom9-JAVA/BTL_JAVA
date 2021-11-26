/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import qltdModel.HoaDon;
import qltdModel.KhachHang;
import qltdModel.LichSuGiaoDich;


/**
 *
 * @author TIEN THANH HOA
 */
public class LichSuGiaoDichController {
    private Connect conn = null;
    private ResultSet rs = null;

    public LichSuGiaoDichController() {
        conn = new Connect();
        conn.getConnect();
    }
    
    public ArrayList<LichSuGiaoDich> getLichSuGDs() throws SQLException{
        ArrayList<LichSuGiaoDich> lichSuGD = new ArrayList<>();
        try {
            String sSql ="select MaGD,KhachHang.MaKH,HoaDon.MaHD,ThoiGianDG,GhiChu from LichSuGiaoDich " +
                    "inner join HoaDon on LichSuGiaoDich.MaHD = HoaDon.MaHD " +
                    "inner join KhachHang on HoaDon.MaKH = KhachHang.MaKH " +
                    "order by MaGD desc";
            rs = conn.loadData(sSql);
            while(rs.next()){
                LichSuGiaoDich ls = new LichSuGiaoDich();
                HoaDon hd = new HoaDon();
                //lay ma khach hang
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt(2));
                hd.setKh(kh);
                //lay ma hoa don
                hd.setMaHD(rs.getInt(3));
                
                //lay ma giao dich
                ls.setMaGD(rs.getInt(1));
                ls.setHd(hd);
                ls.setThoiGianGD(String.valueOf(rs.getDate(4)));
                ls.setGhiChu(rs.getNString(5));
                
                lichSuGD.add(ls);
            }

        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return lichSuGD;
    }
    
    public ArrayList<LichSuGiaoDich> getLS(int maKH){
        ArrayList<LichSuGiaoDich> lichSuGD = new ArrayList<>();
        try {
            String sSql ="select MaGD,KhachHang.MaKH,HoaDon.MaHD,ThoiGianDG,GhiChu from LichSuGiaoDich " +
                    "inner join HoaDon on LichSuGiaoDich.MaHD = HoaDon.MaHD " +
                    "inner join KhachHang on HoaDon.MaKH = KhachHang.MaKH " +
                    "where KhachHang.MaKH ="+maKH;
            rs = conn.loadData(sSql);
            if(rs.next()){
                LichSuGiaoDich ls = new LichSuGiaoDich();
                HoaDon hd = new HoaDon();
                //lay ma khach hang
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getInt(2));
                hd.setKh(kh);
                //lay ma hoa don
                hd.setMaHD(rs.getInt(3));
                
                //lay ma giao dich
                ls.setMaGD(rs.getInt(1));
                ls.setHd(hd);
                ls.setThoiGianGD(String.valueOf(rs.getDate(4)));
                ls.setGhiChu(rs.getNString(5));
                lichSuGD.add(ls);
            }

        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return lichSuGD;
    }
    

}
