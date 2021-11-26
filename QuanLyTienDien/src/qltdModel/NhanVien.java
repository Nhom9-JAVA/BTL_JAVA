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
public class NhanVien extends ThongTinCaNhan{
    private int MaNV;
    private String taiKhoan,matKhau;

    public NhanVien() {
    }

    public NhanVien(int MaNV, String taiKhoan, String matKhau) {
        this.MaNV = MaNV;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public NhanVien(int MaNV, String taiKhoan, String matKhau, String hoTen, String CMT, String ngaySinh, String diaChi, String gioiTinh, String dienThoai) {
        super(hoTen, CMT, ngaySinh, diaChi, gioiTinh, dienThoai);
        this.MaNV = MaNV;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public int getMaNV() {
        return MaNV;
    }

    public void setMaNV(int MaNV) {
        this.MaNV = MaNV;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }
    
    

    
    
    
}
