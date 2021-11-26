/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import qltdModel.KhachHang;
import qltdModel.LichSuGiaoDich;

/**
 *
 * @author TIEN THANH HOA
 */
public class LichSuGiaoDichTable extends AbstractTableModel{
    //khai bao mang ten cot
   String[] arry = {"Mã GD", "Mã KH", "Mã HĐ", "Thời gian giao dịch", "Nội dung giao dịch"};

    //khai bao class ten cot
    private Class classes[] = {Integer.class,Integer.class,Integer.class,String.class,String.class};
    
    //khai bao Arraylist benh nhan
    ArrayList<LichSuGiaoDich> listLS = new ArrayList<>();

    public LichSuGiaoDichTable(ArrayList<LichSuGiaoDich> list) {
        this.listLS = list;
    }
    
    
    @Override
    public int getRowCount() {//dem so rong trong table
        return listLS.size();
    }

    @Override
    public int getColumnCount() {// dem so cot trong table
        return arry.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1){
            case 0: return listLS.get(i).getMaGD();
            case 1: return listLS.get(i).getHd().getKh().getMaKH();
            case 2: return listLS.get(i).getHd().getMaHD();
            case 3: return listLS.get(i).getThoiGianGD();
            case 4: return listLS.get(i).getGhiChu();
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
