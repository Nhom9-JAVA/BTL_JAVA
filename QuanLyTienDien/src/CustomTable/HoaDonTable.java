/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import qltdModel.HoaDon;
/**
 *
 * @author Quach Thao
 */
public class HoaDonTable extends AbstractTableModel{
    private String name[] = {"Mã HD", "Mã KH", "Mã DK", "Tiêu Thụ","Thành Tiền", "Ngày Lập"};
    private Class classes[] = {Integer.class, Integer.class, Integer.class, Integer.class,Double.class, String.class};
    ArrayList<HoaDon> list = new ArrayList<>();
    public HoaDonTable(ArrayList<HoaDon> list){
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
            case 0: return list.get(rowIndex).getMaHD();
            case 1: return list.get(rowIndex).getKh().getMaKH();
            case 2: return list.get(rowIndex).getDk().getMaDK();
            case 3: return list.get(rowIndex).getTieuThu();
            case 4: return list.get(rowIndex).getThanhtien();
            case 5: return list.get(rowIndex).getNgayLap();
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
