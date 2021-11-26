/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author TIEN THANH HOA
 */
public class TienIchTable extends AbstractTableModel{

    //khai bao mang ten cot
    String[] arry = {"Từ ĐM", "Đến ĐM", "Số Điện", "Thành Tiền"};
    Class classes[] = {Integer.class,Integer.class,Integer.class,String.class};
    //khai bao Arraylist benh nhan
    ArrayList<Object[]> list = new ArrayList<>();

    public TienIchTable(ArrayList<Object[]> list) {
        this.list = list;
    }
    
    
    @Override
    public int getRowCount() {//dem so rong trong table
        return list.size();
    }

    @Override
    public int getColumnCount() {// dem so cot trong table
        return arry.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
            switch(i1){
                case 0: return list.get(i)[0];
                case 1: return list.get(i)[1];
                case 2: return list.get(i)[2];
                case 3: return list.get(i)[3];
                default: return null;
            }
        
    }

    @Override
    public Class getColumnClass(int i) {
        if(i == 3){
            return Integer.class;
        }
        else{
            return Integer.class;
        }
        
    }

    @Override
    public String getColumnName(int i) {
        return arry[i];
    }
    
    
}
