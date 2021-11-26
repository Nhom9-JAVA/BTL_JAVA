/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import qltdModel.DienKe;
/**
 *
 * @author Gia Thinh
 */
public class DienKeTable extends AbstractTableModel{
    private String name[] = {"Mã DK", "Mã KH", "Ngày Tháng", "Chỉ số cũ", "Chỉ số mới"};
    private Class classes[] = {Integer.class, Integer.class, String.class, Integer.class, Integer.class};
    ArrayList<DienKe> list = new ArrayList<>();
    public DienKeTable(ArrayList<DienKe> list){
        this.list = list;
    }
    @Override
    public int getRowCount() {
        return list.size();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        return name.length;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return list.get(rowIndex).getMaDK();
            case 1: return list.get(rowIndex).getKh().getMaKH();
            case 2: return list.get(rowIndex).getNamThang();
            case 3: return list.get(rowIndex).getCSC();
            case 4: return list.get(rowIndex).getCSM();
            default: return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return name[column];
    }
    
    
}
