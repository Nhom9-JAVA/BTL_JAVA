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
public class KhachHang extends ThongTinCaNhan{
    private int MaKH;
    private String ngayBDSD,tenLSD;

    public KhachHang(int MaKH) {
        this.MaKH = MaKH;
    }

    public KhachHang() {
    }

    public KhachHang(int MaKH, String ngayBDSD, String tenLSD) {
        this.MaKH = MaKH;
        this.ngayBDSD = ngayBDSD;
        this.tenLSD = tenLSD;
    }
    
    
    public KhachHang(int MaKH, String ngayBDSD, String tenLSD, String hoTen, String CMT, String ngaySinh, String diaChi, String gioiTinh, String dienThoai) {
        super(hoTen, CMT, ngaySinh, diaChi, gioiTinh, dienThoai);
        this.MaKH = MaKH;
        this.ngayBDSD = ngayBDSD;
        this.tenLSD = tenLSD;
    }

    public int getMaKH() {
        return MaKH;
    }

    public void setMaKH(int MaKH) {
        this.MaKH = MaKH;
    }

    public String getNgayBDSD() {
        return ngayBDSD;
    }

    public void setNgayBDSD(String ngayBDSD) {
        this.ngayBDSD = ngayBDSD;
    }

    public String getTenLSD() {
        return tenLSD;
    }

    public void setTenLSD(String tenLSD) {
        this.tenLSD = tenLSD;
    }
    
    public String getCMTByMa(int MaKH){
        return getCMT();
    }
    
    
}
