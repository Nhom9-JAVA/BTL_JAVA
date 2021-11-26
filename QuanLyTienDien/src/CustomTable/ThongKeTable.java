/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomTable;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import qltdModel.KhachHang;
import qltdModel.HoaDon;
import qltdModel.DienKe;
import qltdModel.ThongKe;



/**
 *
 * @author Gia Thinh
 */
public class ThongKeTable extends AbstractTableModel {
    
    //khai bao mang ten cot
    private String[] arry = {"Mã HĐ", "Mã ĐK", "Mã KH", "Họ Tên KH", "Địa Chỉ", "Dịch vụ", "Ngày lập", "Tiêu thụ", "Tổng tiền"};
    //khai bao class ten cot
    private Class classes[] = {Integer.class,Integer.class,Integer.class,String.class,String.class,String.class,String.class,Integer.class,Double.class};
    
    //khai bao Arraylist thong ke
    ArrayList<ThongKe> listTK = new ArrayList<>();
    
    public ThongKeTable(ArrayList<ThongKe> list) {
        this.listTK = list;
    }

    @Override
    public int getRowCount() {
        //dem so rong trong table
        return listTK.size();
    }

    @Override
    public int getColumnCount() {
        // dem so cot trong table
        return arry.length;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        switch(i1){
            case 0: return listTK.get(i).getHd().getMaHD();
            case 1: return listTK.get(i).getDk().getMaDK();
            case 2: return listTK.get(i).getKh().getMaKH();
            case 3: return listTK.get(i).getKh().getHoTen();
            case 4: return listTK.get(i).getKh().getDiaChi();
            case 5: return listTK.get(i).getKh().getTenLSD();
            case 6: return listTK.get(i).getHd().getNgayLap();
            case 7: return listTK.get(i).getHd().getTieuThu();
            case 8: return listTK.get(i).getHd().getThanhtien();
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
