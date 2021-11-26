/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltdModel;

/**
 *
 * @author TIEN THANH HOA
 */
public class HoaDon {
    private int MaHD;
    private KhachHang kh;
    private DienKe dk;
    private int tieuThu;
    private String ngayLap;
    private double thanhtien;
    public HoaDon() {
    }

    public HoaDon(int MaHD) {
        this.MaHD = MaHD;
    }

    public HoaDon(int MaHD, KhachHang kh, DienKe dk, int tieuThu, String ngayLap) {
        this.MaHD = MaHD;
        this.kh = kh;
        this.dk = dk;
        this.tieuThu = tieuThu;
        this.ngayLap = ngayLap;
    }

    public HoaDon(KhachHang kh, DienKe dk, int tieuThu, String ngayLap, double thanhtien) {
        this.kh = kh;
        this.dk = dk;
        this.tieuThu = tieuThu;
        this.ngayLap = ngayLap;
        this.thanhtien = thanhtien;
    }

    public int getMaHD() {
        return MaHD;
    }

    public void setMaHD(int MaHD) {
        this.MaHD = MaHD;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public DienKe getDk() {
        return dk;
    }

    public void setDk(DienKe dk) {
        this.dk = dk;
    }

    public int getTieuThu() {
        return tieuThu;
    }

    public void setTieuThu(int tieuThu) {
        this.tieuThu = tieuThu;
    }

    public String getNgayLap() {
        return ngayLap;
    }

    public void setNgayLap(String ngayLap) {
        this.ngayLap = ngayLap;
    }

    public double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(double thanhtien) {
        this.thanhtien = thanhtien;
    }
    
    
}
