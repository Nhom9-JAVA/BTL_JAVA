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
 * @author nguye
 */
public class KhachHangDaNopTable extends AbstractTableModel{
    //khai bao mang ten cot
    private String[] arry = {"Mã khách hàng", "Họ Tên", "Số điện thoại", "Địa chỉ","Dịch vụ"};

    //khai bao class ten cot
    private Class classes[] = {Integer.class,String.class,String.class,String.class,String.class};
    
    //khai bao Arraylist benh nhan
    ArrayList<KhachHang> listCN = new ArrayList<>();

    public KhachHangDaNopTable(ArrayList<KhachHang> list) {
        this.listCN = list;
    }
    
    
    @Override
    public int getRowCount() {//dem so rong trong table
        return listCN.size();
    }

    @Override
    public int getColumnCount() {// dem so cot trong table
        return arry.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1){
            case 0: return listCN.get(i).getMaKH();
            case 1: return listCN.get(i).getHoTen();
            case 2: return listCN.get(i).getDienThoai();
            case 3: return listCN.get(i).getDiaChi();
            case 4: return listCN.get(i).getTenLSD();
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
