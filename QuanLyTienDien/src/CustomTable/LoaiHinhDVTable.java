/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import qltdModel.LoaiHinhDV;

/**
 *
 * @author thu
 */
public class LoaiHinhDVTable extends AbstractTableModel {
    String[] tieude = {"Mã dịch vụ","Loại hình dịch vụ","Từ định mức","Đến định mức","Đơn giá/Kwh (Chưa VAT)","Thuế VAT(%)"};
    Class[] classes = {Integer.class,String.class,Integer.class,Integer.class,Double.class,Double.class};
    ArrayList<LoaiHinhDV> list = new ArrayList<>();
    public LoaiHinhDVTable(ArrayList<LoaiHinhDV> ds){
        this.list=ds;
    }
    @Override
    public int getRowCount() {
        return  list.size();
    }

    @Override
    public int getColumnCount() {
        return tieude.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getMaLSD();
            case 1: return list.get(rowIndex).getTenLSD();
            case 2: return list.get(rowIndex).getTuDM();    
            case 3: return list.get(rowIndex).getDenDM();
            case 4: return list.get(rowIndex).getDonGia();
            case 5: return list.get(rowIndex).getThueVAT();
            default: return null;
        }
    }
    @Override
    public Class getColumnClass(int i) {
        return classes[i];
    }

    @Override
    public String getColumnName(int i) {
        return tieude[i];
    }
    
}
