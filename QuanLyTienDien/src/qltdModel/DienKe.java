/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qltdModel;

/**
 *
 * @author Gia Thinh
 */
public class DienKe {
    private int MaDK;
    private KhachHang kh;
    private String namThang;
    private int CSC,CSM;

    public DienKe() {
    }

    public DienKe(int MaDK) {
        this.MaDK = MaDK;
    }

    public DienKe(int MaDK, KhachHang kh, String namThang, int CSC, int CSM) {
        this.MaDK = MaDK;
        this.kh = kh;
        this.namThang = namThang;
        this.CSC = CSC;
        this.CSM = CSM;
    }

    public int getMaDK() {
        return MaDK;
    }

    public void setMaDK(int MaDK) {
        this.MaDK = MaDK;
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

    public int getCSC() {
        return CSC;
    }

    public void setCSC(int CSC) {
        this.CSC = CSC;
    }

    public int getCSM() {
        return CSM;
    }

    public void setCSM(int CSM) {
        this.CSM = CSM;
    }
    
    
}
