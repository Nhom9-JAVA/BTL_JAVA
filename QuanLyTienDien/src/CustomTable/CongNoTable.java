/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import qltdModel.CongNo;

/**
 *
 * @author nguye
 */
public class CongNoTable extends AbstractTableModel{
    //khai bao mang ten cot
    private String[] arry = {"Mã KH", "Họ Tên", "Năm Tháng", "Nội dung"};

    //khai bao class ten cot
    private Class classes[] = {Integer.class,String.class,String.class,String.class};
    
    //khai bao Arraylist benh nhan
    ArrayList<CongNo> listCN = new ArrayList<>();

    public CongNoTable(ArrayList<CongNo> list) {
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
            case 0: return listCN.get(i).getKh().getMaKH();
            case 1: return listCN.get(i).getKh().getHoTen();
            case 2: return listCN.get(i).getNamThang();
            case 3: return listCN.get(i).getGhiChu();
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
