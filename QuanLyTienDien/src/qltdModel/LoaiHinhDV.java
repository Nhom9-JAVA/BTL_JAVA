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
public class LoaiHinhDV {
    private int MaLSD;
    private String tenLSD;
    private int tuDM,denDM;
    private double donGia;
    private double ThueVAT;

    public LoaiHinhDV() {
    }

    public LoaiHinhDV(int MaLSD, String tenLSD, int tuDM, int denDM, double donGia,double ThueVAT) {
        this.MaLSD = MaLSD;
        this.tenLSD = tenLSD;
        this.tuDM = tuDM;
        this.denDM = denDM;
        this.donGia = donGia;
        this.ThueVAT = ThueVAT;
    }

    public int getMaLSD() {
        return MaLSD;
    }

    public void setMaLSD(int MaLSD) {
        this.MaLSD = MaLSD;
    }

    public String getTenLSD() {
        return tenLSD;
    }

    public void setTenLSD(String tenLSD) {
        this.tenLSD = tenLSD;
    }

    public int getTuDM() {
        return tuDM;
    }

    public void setTuDM(int tuDM) {
        this.tuDM = tuDM;
    }

    public int getDenDM() {
        return denDM;
    }

    public void setDenDM(int denDM) {
        this.denDM = denDM;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public double getThueVAT() {
        return ThueVAT;
    }

    public void setThueVAT(double ThueVAT) {
        this.ThueVAT = ThueVAT;
    }

    
    
    
}
