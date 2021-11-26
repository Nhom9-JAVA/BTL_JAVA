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
public class CongNo {
    private int MaDSCN;
    private KhachHang kh;
    private String namThang,ghiChu;

    public CongNo() {
    }

    public CongNo(KhachHang kh, String namThang) {
        this.kh = kh;
        this.namThang = namThang;
    }

    

    public CongNo(int MaDSCN, KhachHang kh, String namThang, String ghiChu) {
        this.MaDSCN = MaDSCN;
        this.kh = kh;
        this.namThang = namThang;
        this.ghiChu = ghiChu;
    }

    public int getMaDSCN() {
        return MaDSCN;
    }

    public void setMaDSCN(int MaDSCN) {
        this.MaDSCN = MaDSCN;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    public String getNamThang() {
        return namThang;
    }

    public void setNamThang(String namThang) {
        this.namThang = namThang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
