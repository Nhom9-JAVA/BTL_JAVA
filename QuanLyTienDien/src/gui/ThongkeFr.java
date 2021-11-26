package gui;

import CustomTable.ThongKeTable;
import database.DienKeController;
import database.KhachHangController;
import database.ThongKeController;
import database.ThongTinCaNhanController;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.jfree.chart.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import qltdModel.NhanVien;
import qltdModel.ThongKe;

public class ThongkeFr extends javax.swing.JFrame {

    private DienKeController dkCller = new DienKeController();
    private KhachHangController khCller = new KhachHangController();
    private ThongTinCaNhanController ttcnCller = new ThongTinCaNhanController();
    private ThongKeController tkCller = new ThongKeController();
    private NhanVien nv;
    private boolean add = false, change = false;
    private boolean leapYear = false, Year = false, Month = false, Day = false;

    public ThongkeFr(NhanVien d){
        initComponents();
        //Kết nối cơ sở dữ liệu
        setResizable(false);
        setLocationRelativeTo(this);
//        lbTrangthai.setText(String.valueOf(new SimpleDateFormat("EEEE dd/MM/yyyy").format(new java.util.Date())));
        cbxYear.setValue(Double.parseDouble(new SimpleDateFormat("yyyy").format(new java.util.Date())));
        checkYear();
        addDay();
        loadData();
        Refresh();
        nv = d;
        
    }

    private void loadData() {
        try {

            tableThongke.setModel(new ThongKeTable(tkCller.getAllThongKe()));

            //Số hóa đơn
            int count = tableThongke.getRowCount();
            lblSoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 24));
            lblSoHoaDon.setForeground(new java.awt.Color(255, 0, 0));
            lblSoHoaDon.setText(String.valueOf(count));

            //Tổng doanh thu
            lblTongDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 24));
            lblTongDoanhThu.setForeground(new java.awt.Color(255, 0, 0));
            lblTongDoanhThu.setText(formatNumber(tkCller.gettongTien()));

            if (tableThongke.getColumnModel().getColumnCount() > 0) {
                tableThongke.getColumnModel().getColumn(0).setMaxWidth(100);
                tableThongke.getColumnModel().getColumn(1).setMaxWidth(100);
                tableThongke.getColumnModel().getColumn(2).setMaxWidth(100);
                tableThongke.getColumnModel().getColumn(3).setMaxWidth(200);
                tableThongke.getColumnModel().getColumn(4).setMaxWidth(150);
                tableThongke.getColumnModel().getColumn(5).setMaxWidth(200);
                tableThongke.getColumnModel().getColumn(6).setMaxWidth(100);
                tableThongke.getColumnModel().getColumn(7).setMaxWidth(100);
                tableThongke.getColumnModel().getColumn(8).setMaxWidth(150);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private String cutChar(String arry) {
        return arry.replaceAll("\\D+", "");
    }

    private String formatMoney(double money) {
        String result = "";
        Locale locale = new Locale("vi", "VN");
        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();

        formatSymbols.setGroupingSeparator(',');
        formatSymbols.setCurrencySymbol("VNĐ");
        format.setDecimalFormatSymbols(formatSymbols);

        result = String.valueOf(format.format(money));

        return result;
    }

    private String formatNumber(double number) {
        String result = "";
        DecimalFormat format = new DecimalFormat();
        DecimalFormatSymbols formatSymbols = new DecimalFormatSymbols();

        formatSymbols.setGroupingSeparator(',');
        format.setDecimalFormatSymbols(formatSymbols);

        result = String.valueOf(format.format(number));

        return result;
    }

    private void checkYear() {
        if (Double.parseDouble(String.valueOf(cbxYear.getValue())) % 4 == 0 && Double.parseDouble(String.valueOf(cbxYear.getValue())) % 100 != 0 || Double.parseDouble(String.valueOf(cbxYear.getValue())) % 400 == 0) {
            leapYear = true;
        } else {
            leapYear = false;
        }
    }

    private void Refresh() {
        Year = false;
        Month = false;
        Day = false;

        radXemnam.setSelected(false);
        radXemthang.setSelected(false);
        radXemngay.setSelected(false);

        cbxDay.setEnabled(false);
        cbxMonth.setEnabled(false);
        cbxYear.setEnabled(false);
        cbxMonth.setSelectedIndex(0);
        cbxDay.setSelectedIndex(0);
    }

    private void checkOption() {
        Refresh();
        if (radXemnam.isSelected()) {
            cbxYear.setEnabled(true);
            Year = true;
        } else if (radXemthang.isSelected()) {
            cbxMonth.setEnabled(true);
            cbxYear.setEnabled(true);
            Month = true;
        } else if (radXemngay.isSelected()) {
            cbxDay.setEnabled(true);
            cbxMonth.setEnabled(true);
            cbxYear.setEnabled(true);
            Day = true;
        }
    }

    private void addDay() {
        cbxDay.setEnabled(true);
        String[] day = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"};
        switch (Integer.parseInt(cbxMonth.getSelectedItem().toString())) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                cbxDay.removeAllItems();
                for (String i : day) {
                    cbxDay.addItem(i);
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                cbxDay.removeAllItems();
                for (int i = 0; i < day.length - 1; i++) {
                    cbxDay.addItem(day[i]);
                }
                break;

            case 2:
                cbxDay.removeAllItems();
                if (leapYear == true) {
                    for (int i = 0; i < day.length - 2; i++) {
                        cbxDay.addItem(day[i]);
                    }
                } else {
                    for (int i = 0; i < day.length - 3; i++) {
                        cbxDay.addItem(day[i]);
                    }
                }
                break;
        }
    }
    
    private double getDay(String s) {
        String[] arry = s.replace("-", " ").split("\\s");
        return Double.parseDouble(arry[arry.length - 1]);
    }

    private double getMonth(String s) {
        String[] arry = s.replace("-", " ").split("\\s");
        return Double.parseDouble(arry[arry.length - 2]);
    }

    private double getYear(String s) {
        String[] arry = s.replace("-", " ").split("\\s");
        return Double.parseDouble(arry[arry.length - 3]);
    }

    private void FindDay() {

        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try {
            tableThongke.setModel(new ThongKeTable(tkCller.getAllThongKeByDay(Integer.parseInt(cbxDay.getSelectedItem().toString()))));
            //Số hóa đơn
            lblSoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 24));
            lblSoHoaDon.setForeground(new java.awt.Color(255, 0, 0));
            lblSoHoaDon.setText(String.valueOf(tableThongke.getRowCount()));

            //Tổng doanh thu
            lblTongDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 24));
            lblTongDoanhThu.setForeground(new java.awt.Color(255, 0, 0));
            lblTongDoanhThu.setText(formatNumber(tkCller.getTongTienByDay()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void FindMonth() {

        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try {
            tableThongke.setModel(new ThongKeTable(tkCller.getAllThongKeByMonth(Integer.parseInt(cbxMonth.getSelectedItem().toString()))));
            //Số hóa đơn
            lblSoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 24));
            lblSoHoaDon.setForeground(new java.awt.Color(255, 0, 0));
            lblSoHoaDon.setText(String.valueOf(tableThongke.getRowCount()));

            //Tổng doanh thu
            lblTongDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 24));
            lblTongDoanhThu.setForeground(new java.awt.Color(255, 0, 0));
            lblTongDoanhThu.setText(formatNumber(tkCller.getTongTienByMonth()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void FindYear() {

        DecimalFormat formatter = new DecimalFormat("###,###,###");
        try {
            tableThongke.setModel(new ThongKeTable(tkCller.getAllThongKeByYear(Integer.parseInt(cbxYear.getValue().toString()))));
            //Số hóa đơn
            lblSoHoaDon.setFont(new java.awt.Font("Tahoma", 1, 24));
            lblSoHoaDon.setForeground(new java.awt.Color(255, 0, 0));
            lblSoHoaDon.setText(String.valueOf(tableThongke.getRowCount()));

            //Tổng doanh thu
            lblTongDoanhThu.setFont(new java.awt.Font("Tahoma", 1, 24));
            lblTongDoanhThu.setForeground(new java.awt.Color(255, 0, 0));
            lblTongDoanhThu.setText(formatNumber(tkCller.getTongTienByYear()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThongke = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        radXemngay = new javax.swing.JRadioButton();
        radXemthang = new javax.swing.JRadioButton();
        radXemnam = new javax.swing.JRadioButton();
        cbxDay = new javax.swing.JComboBox<String>();
        cbxMonth = new javax.swing.JComboBox<String>();
        cbxYear = new javax.swing.JSpinner();
        btnBack = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        btnQueryChart = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblSoHoaDon = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbTrangthai = new javax.swing.JLabel();
        lblTongDoanhThu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Thống kê");

        tableThongke.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tableThongke.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableThongke.setRowHeight(30);
        jScrollPane1.setViewportView(tableThongke);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );

        buttonGroup1.add(radXemngay);
        radXemngay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radXemngay.setText("Xem theo ngày");
        radXemngay.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radXemngayItemStateChanged(evt);
            }
        });

        buttonGroup1.add(radXemthang);
        radXemthang.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radXemthang.setText("Xem theo tháng");
        radXemthang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radXemthangItemStateChanged(evt);
            }
        });

        buttonGroup1.add(radXemnam);
        radXemnam.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radXemnam.setText("Xem theo năm");
        radXemnam.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                radXemnamItemStateChanged(evt);
            }
        });

        cbxMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        cbxMonth.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbxMonthPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbxYear.setEditor(new javax.swing.JSpinner.NumberEditor(cbxYear, "####"));

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/icons8_refresh_60px.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/icons8_home_50px_1.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/icons8_search_50px.png"))); // NOI18N
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnQueryChart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/icons8_chart_70px.png"))); // NOI18N
        btnQueryChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQueryChartActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbxDay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(radXemngay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(radXemthang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMonth, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(radXemnam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxYear)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnQueryChart, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radXemngay)
                    .addComponent(radXemthang)
                    .addComponent(radXemnam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnHome, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnFind, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                    .addComponent(btnQueryChart, javax.swing.GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE)))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Tổng Số Hóa Đơn:");

        lblSoHoaDon.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSoHoaDon.setText("0");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Tổng Tiền Thu Về:");

        lbTrangthai.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lbTrangthai.setForeground(new java.awt.Color(0, 204, 0));
        lbTrangthai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTrangthai.setText("Trạng Thái");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("VNĐ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongDoanhThu)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblSoHoaDon)
                    .addComponent(jLabel4)
                    .addComponent(lblTongDoanhThu)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20))
        );

        setSize(new java.awt.Dimension(1742, 747));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        MainFr home = new MainFr(nv);
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if (Day == true) {
            FindDay();
        } else if (Month == true) {
            FindMonth();
        } else if (Year == true) {
            FindYear();
        } else {
            lbTrangthai.setText("Bạn cần chọn phương thức tìm kiếm!");
        }
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        
        loadData();
        buttonGroup1.clearSelection();
    }//GEN-LAST:event_btnBackActionPerformed

    private void radXemnamItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radXemnamItemStateChanged
        checkOption();
    }//GEN-LAST:event_radXemnamItemStateChanged

    private void radXemthangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radXemthangItemStateChanged
        checkOption();
    }//GEN-LAST:event_radXemthangItemStateChanged

    private void radXemngayItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_radXemngayItemStateChanged
        checkOption();
    }//GEN-LAST:event_radXemngayItemStateChanged

    private void cbxMonthPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbxMonthPopupMenuWillBecomeInvisible
        checkYear();
        if (Day == true) {
            addDay();
        } else {
            return;
        }
    }//GEN-LAST:event_cbxMonthPopupMenuWillBecomeInvisible

    private void btnQueryChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQueryChartActionPerformed
        try {
            String ThangLap = "";
            String NamLap = "";
            String query = "";

            //Tìm kiếm theo tháng
            for (ThongKe tk : tkCller.getAllThongKe()) {
                if (Month == true) {
                    if (getMonth(tk.getHd().getNgayLap()) == Double.parseDouble(cbxMonth.getSelectedItem().toString()) && getYear(tk.getHd().getNgayLap()) == Double.parseDouble(cbxYear.getValue().toString())) {
                        ThangLap = cbxMonth.getSelectedItem().toString();
                        NamLap = cbxYear.getValue().toString();
                        query = "SELECT NgayLap, SUM(ThanhTien) AS 'ThanhTien' FROM HoaDon WHERE MONTH(HoaDon.NgayLap) = "+ThangLap+" AND  YEAR(HoaDon.NgayLap) = " + NamLap + " GROUP BY NgayLap ORDER BY NgayLap DESC";
                    }
                } else if (Year == true) {
                    if (getYear(tk.getHd().getNgayLap()) == Double.parseDouble(cbxYear.getValue().toString())) {
                        NamLap = cbxYear.getValue().toString();
                        query = "SELECT NgayLap, SUM(ThanhTien) AS 'ThanhTien' FROM HoaDon WHERE YEAR(HoaDon.NgayLap) = " + NamLap + " GROUP BY NgayLap ORDER BY NgayLap DESC";
                    }
                } else {
                    JOptionPane.showConfirmDialog(null, "Bạn chưa chọn Tháng hoặc năm để hiển thị thống kê doanh thu", "Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }

            //Kiểm tra điều kiện rỗng
            if (NamLap.equals("") && ThangLap.equals("")) {
                JOptionPane.showConfirmDialog(null, "Không có biểu đồ thống kê doanh thu", "Thông báo", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            //Vẽ biểu đồ
            JDBCCategoryDataset dataset = new JDBCCategoryDataset(tkCller.getConnect(),query);
            JFreeChart chart = ChartFactory.createBarChart("Biểu đồ thống kê doanh số tiêu thụ điện", "Ngày Lập", "Thành tiền", dataset, PlotOrientation.VERTICAL, false, true, true);
            BarRenderer renderer = null;
            CategoryPlot plot = null;
            renderer = new BarRenderer();
            ChartFrame frame = new ChartFrame("Query Chart", chart);
            frame.setVisible(true);
            frame.setSize(1280, 960);
            frame.setLocationRelativeTo(this);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnQueryChartActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThongkeFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongkeFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongkeFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongkeFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVien nv = new NhanVien();
                try {
                    new ThongkeFr(nv).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(ThongkeFr.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnQueryChart;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxDay;
    private javax.swing.JComboBox<String> cbxMonth;
    private javax.swing.JSpinner cbxYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JLabel lblSoHoaDon;
    private javax.swing.JLabel lblTongDoanhThu;
    private javax.swing.JRadioButton radXemnam;
    private javax.swing.JRadioButton radXemngay;
    private javax.swing.JRadioButton radXemthang;
    private javax.swing.JTable tableThongke;
    // End of variables declaration//GEN-END:variables
}
