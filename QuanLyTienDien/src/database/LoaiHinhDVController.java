/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import qltdModel.LoaiHinhDV;

/**
 *
 * @author TIEN THANH HOA
 */
public class LoaiHinhDVController {
    private Connect conn = null;
    private ResultSet rs = null;

    public LoaiHinhDVController() {
        conn = new Connect();
        conn.getConnect();
    }
    
    public ArrayList<LoaiHinhDV> getLoaiHinhDV(String tenLSD){
        ArrayList<LoaiHinhDV> loaiDV = new ArrayList<>();
        try {
            String sSql ="select * from LoaiHinhDV where TenLSD = N'"+tenLSD+"'";
            rs = conn.loadData(sSql);
            while(rs.next()){
                LoaiHinhDV lhv = new LoaiHinhDV();
                lhv.setMaLSD(rs.getInt(1));
                lhv.setTenLSD(rs.getNString(2));
                lhv.setTuDM(rs.getInt(3));
                lhv.setDenDM(rs.getInt(4));
                lhv.setDonGia(rs.getDouble(5));
                lhv.setThueVAT(rs.getDouble(6));
                loaiDV.add(lhv);
            }

        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return loaiDV;
    }
    
    public Vector<String> getTenLSD(){
        Vector<String> ds = new Vector<>();
        try {
            String sSql = "select distinct TenLSD from LoaiHinhDV";
            rs = conn.loadData(sSql);
            while(rs.next()){
                ds.add(rs.getNString(1));
            }
        } catch (Exception e) {
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return ds;
    }
    
    public int add(LoaiHinhDV dv){
        PreparedStatement st = null;
        try{
            String sql = "INSERT INTO LoaiHinhDV (TenLSD,TuDM, DenDM, DonGia, ThueVAT) VALUES (?,?,?,?,?)";
            st = conn.excuteData(sql);
            st.setString(1,  dv.getTenLSD());
            st.setInt(2, dv.getTuDM());
            st.setInt(3,dv.getDenDM() );
            st.setDouble(4, dv.getDonGia());
            st.setDouble(5, dv.getThueVAT());
            if(st.executeUpdate()>0){
                return 1;
            }
        }catch(Exception e){
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return -1;
    }
    
    public int update (LoaiHinhDV dv){
        PreparedStatement st = null;
        try{
            String sql = "Update LoaiHinhDV set TenLSD=?, TuDM=?, DenDM=?,DonGia=?,ThueVAT=? where MaLSD=?";
            st = conn.excuteData(sql);
            st.setString(1,  dv.getTenLSD());
            st.setInt(2, dv.getTuDM());
            st.setInt(3,dv.getDenDM() );
            st.setDouble(4, dv.getDonGia());
            st.setDouble(5, dv.getThueVAT());
            st.setInt(6, dv.getMaLSD());
            if(st.executeUpdate()>0){
                return 1;
            }
        }catch(Exception e){
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return -1;
    }
    
    public int del (int MaLSD){
        PreparedStatement st = null;
        try{
            String sql = "Delete LoaiHinhDV where MaLSD=?";
            st = conn.excuteData(sql);
            st.setInt(1,  MaLSD);
            if(st.executeUpdate()>0){
                return 1;
            }
        }catch(Exception e){
            System.out.println("Cau truy van khong dung !!!" + e.getMessage());
        }
        return -1;
    }
    public int check(LoaiHinhDV dv) {
        try {
            String sql = "SELECT * FROM LoaiHinhDV ORDER BY MaLSD, TenLSD, TuDM, DenDM";
            rs = conn.loadData(sql);
            while (rs.next()) {
                if (rs.getString("TenLSD").toString().trim().equals(dv.getTenLSD()) && rs.getString("TuDM").toString().trim().equals(dv.getTuDM()+"") && rs.getString("DenDM").toString().trim().equals(dv.getDenDM()+"")) {
                    return -1;
                }
                if (rs.getString("MaLSD").toString().trim().equals(dv.getMaLSD())) { 
                    return -1;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Loi cau truy van khong chinh xac!"+ex.getMessage());
        }
        return 1;
    }
}
