/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import qltdModel.KhachHang;

/**
 *
 * @author TIEN THANH HOA
 */
public class KhachHangTable extends AbstractTableModel{
    
    //khai bao mang ten cot
    private String[] arry = {"Mã KH", "Họ Tên", "CMT", "Ngày Sinh", "Địa Chỉ", "Giới Tính", "Điện Thoại", "Ngày BDSD", "Tên LSD"};

    //khai bao class ten cot
    private Class classes[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
    
    //khai bao Arraylist benh nhan
    ArrayList<KhachHang> listKH = new ArrayList<>();

    public KhachHangTable(ArrayList<KhachHang> list) {
        this.listKH = list;
    }
    
    
    @Override
    public int getRowCount() {//dem so rong trong table
        return listKH.size();
    }

    @Override
    public int getColumnCount() {// dem so cot trong table
        return arry.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1){
            case 0: return listKH.get(i).getMaKH();
            case 1: return listKH.get(i).getHoTen();
            case 2: return listKH.get(i).getCMT();
            case 3: return listKH.get(i).getNgaySinh();
            case 4: return listKH.get(i).getDiaChi();
            case 5: return listKH.get(i).getGioiTinh();
            case 6: return listKH.get(i).getDienThoai();
            case 7: return listKH.get(i).getNgayBDSD();
            case 8: return listKH.get(i).getTenLSD();
            default: return null;
        }
    }

    @Override
    public Class getColumnClass(int i) {
        return classes[i];
    }

    @Override
    public String getColumnName(int i) {
        return arry[i];
    }
    
    
}
