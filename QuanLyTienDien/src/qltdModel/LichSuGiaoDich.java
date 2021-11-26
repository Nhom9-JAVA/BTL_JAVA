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
public class LichSuGiaoDich {
    private int MaGD;
    private HoaDon hd;
    private String thoiGianGD,ghiChu;

    public LichSuGiaoDich() {
    }

    public LichSuGiaoDich(HoaDon hd, String thoiGianGD, String ghiChu) {
        this.hd = hd;
        this.thoiGianGD = thoiGianGD;
        this.ghiChu = ghiChu;
    }

    public LichSuGiaoDich(int MaGD, HoaDon hd, String thoiGianGD, String ghiChu) {
        this.MaGD = MaGD;
        this.hd = hd;
        this.thoiGianGD = thoiGianGD;
        this.ghiChu = ghiChu;
    }

    public int getMaGD() {
        return MaGD;
    }

    public void setMaGD(int MaGD) {
        this.MaGD = MaGD;
    }

    public HoaDon getHd() {
        return hd;
    }

    public void setHd(HoaDon hd) {
        this.hd = hd;
    }

    public String getThoiGianGD() {
        return thoiGianGD;
    }

    public void setThoiGianGD(String thoiGianGD) {
        this.thoiGianGD = thoiGianGD;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    
}
