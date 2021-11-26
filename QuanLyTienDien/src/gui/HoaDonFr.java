/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import CustomTable.DienKeTable;
import CustomTable.HoaDonTable;
import CustomTable.KhachHangTable;
import database.Connect;
import database.DienKeController;
import database.HoaDonController;
import database.KhachHangController;
import database.LoaiHinhDVController;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import qltdModel.NhanVien;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.*;
import qltdModel.CongNo;
import qltdModel.DienKe;
import qltdModel.HoaDon;
import qltdModel.KhachHang;
import qltdModel.LichSuGiaoDich;

/**
 *
 * @author Quach Thao
 */
public class HoaDonFr extends javax.swing.JFrame {

    /**
     * Creates new form HoaDonFr
     */
    private Connect conn = null;
    private ResultSet rs = null;
    private NhanVien nv;
    private int selectedrow = 0;
    KhachHangController khCller = new KhachHangController();
    HoaDonController hdCller = new HoaDonController();
    DienKeController dkCller = new DienKeController();
    LoaiHinhDVController dvCller = new LoaiHinhDVController();
    public HoaDonFr(NhanVien d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        //kết nối cơ sở dữu liệu
        conn = new Connect();
        conn.getConnect();
        nv = d;
        loadTableDK();
        loadTableKH();
        loadTableHD();
        loadCombo();
      //  vTenAdmin.setText(nv.getHoTen());
        //System.out.println(nv.getMaNV());
    }

    private void loadCombo() {
        ComboLoaiDV.setModel(new DefaultComboBoxModel(dvCller.getTenLSD()));
    }

    private void loadTableKH() {
        TableKH.setModel(new KhachHangTable(khCller.getAllKhachHang()));
    }

    private void loadTableDK() {
        TableDK.setModel(new DienKeTable(dkCller.getAllDienKe()));
    }

    private void loadTableHD() {
        TableHoaDon.setModel(new HoaDonTable(hdCller.getAllHoaDon()));
    }

    private void reset() {
        txtMaKH.setText("");
        ComboLoaiDV.setSelectedItem(null);
        vTieuThu.setText("0");
        vThanhTien.setText("0 VNĐ");
        vThue.setText("0 VNĐ");
        vTongTien.setText("0 VNĐ");
        txtTienNhanKH.setText("");
        vTienthua.setText("0 VNĐ");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuTaiKhoan = new javax.swing.JPopupMenu();
        JMenuDangXuat = new javax.swing.JMenuItem();
        jMenuThongTinAdmin = new javax.swing.JMenuItem();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableDK = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableKH = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        ComboLoaiDV = new javax.swing.JComboBox<>();
        btnTinhTien = new javax.swing.JButton();
        txtMaKH = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        vTieuThu = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        vThanhTien = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vThue = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableHoaDon = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnPay = new javax.swing.JButton();
        txtTienNhanKH = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        vTienthua = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        vTongTien = new javax.swing.JLabel();
        vTrangThai = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        JMenuDangXuat.setLabel("Đăng xuất");
        JMenuDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JMenuDangXuatActionPerformed(evt);
            }
        });
        jPopupMenuTaiKhoan.add(JMenuDangXuat);

        jMenuThongTinAdmin.setText("Thông tin tài khoản");
        jMenuThongTinAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuThongTinAdminActionPerformed(evt);
            }
        });
        jPopupMenuTaiKhoan.add(jMenuThongTinAdmin);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hóa Đơn");

        TableDK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TableDK);

        TableKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TableKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableKHMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableKH);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Dịch vụ khách hàng", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        ComboLoaiDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ComboLoaiDV.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ComboLoaiDVPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        btnTinhTien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnTinhTien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/icons8_receipt_20px.png"))); // NOI18N
        btnTinhTien.setText("Tính tiền");
        btnTinhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTinhTienActionPerformed(evt);
            }
        });

        txtMaKH.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });
        txtMaKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaKHKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Mã KH");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Loại hình dịch vụ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTinhTien)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(ComboLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addComponent(btnTinhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thanh toán", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Lượng điện tiêu thụ");

        vTieuThu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        vTieuThu.setText("0");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Thành tiền");

        vThanhTien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        vThanhTien.setText("0 VNĐ");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Thuế VAT");

        vThue.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        vThue.setText("0 VNĐ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel12)))
                    .addComponent(jLabel11))
                .addGap(25, 25, 25)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(vThanhTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                    .addComponent(vTieuThu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(vThue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(vTieuThu))
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(vThanhTien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(vThue))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TableHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableHoaDon);

        btnPay.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnPay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/pay (1).png"))); // NOI18N
        btnPay.setEnabled(false);
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        txtTienNhanKH.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        txtTienNhanKH.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtTienNhanKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienNhanKHKeyReleased(evt);
            }
        });

        btnPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/printer.png"))); // NOI18N
        btnPrint.setEnabled(false);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tổng tiền:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Tiền nhận của khách:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tiền thừa:");

        vTienthua.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vTienthua.setText("0 VNĐ");

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/smart-home (1).png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        vTongTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        vTongTien.setText("0 VNĐ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienNhanKH, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vTienthua, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(btnPay)
                .addGap(15, 15, 15)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(btnHome))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel2)
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(16, 16, 16)
                .addComponent(jLabel5))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(vTongTien)
                .addGap(7, 7, 7)
                .addComponent(txtTienNhanKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(vTienthua))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        vTrangThai.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        vTrangThai.setForeground(new java.awt.Color(0, 204, 0));
        vTrangThai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vTrangThai.setText("Trạng Thái");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("QUẢN LÝ HÓA ĐƠN / IN HÓA ĐƠN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 793, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 308, Short.MAX_VALUE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(vTrangThai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(376, 376, 376))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel8)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //popup đăng xuất
    private void JMenuDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JMenuDangXuatActionPerformed
        // TODO add your handling code here:
        int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (click == JOptionPane.YES_OPTION) {
            new LoginFr().setVisible(true);
            jPopupMenuTaiKhoan.setVisible(false);
            this.setVisible(false);

        }
    }//GEN-LAST:event_JMenuDangXuatActionPerformed
    //Lấy ngày hiện tại
    private String getDateNow() {
        Calendar calendar = Calendar.getInstance();
        String now = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        return now;
    }
    //Lấy năm hiện tại
    private String getYearNow() {
        Calendar calendar = Calendar.getInstance();
        String now = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        int yearDiff = calendar.get(Calendar.YEAR);
        String result = String.valueOf(yearDiff);
        return result;
    }

    //Lấy tháng hiện tại
    private String getMonthNow() {
        Calendar calendar = Calendar.getInstance();
        String now = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        int monthDiff = calendar.get(Calendar.MONTH) + 1;
        String result = String.valueOf(monthDiff);
        return result;
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

    private String cutChar(String arry) {
        String a = arry.replace(",", "");
        String b = a.replaceAll("\\D+", "");
        return b;
    }

    //Kiểm tra khách hàng đã nộp tiền tháng này hay chưa 
    private boolean check() throws SQLException {
        //Thực thi câu lệnh SQL
        int maKH = Integer.parseInt(txtMaKH.getText());
        rs = conn.loadData("SELECT MONTH(NgayLap) AS 'ThangLap', YEAR(NgayLap) AS 'NamLap',NgayLap FROM HoaDon WHERE MaKH =" + maKH);
        while (rs.next()) {
            if (rs.getString("NamLap").trim().equals(getYearNow()) && rs.getString("ThangLap").trim().equals(getMonthNow())) {
                vTrangThai.setText("Bạn đã thanh toán tiền tháng này!!!");
                return false;
            } else if (rs.getString("NgayLap").trim().equals(getDateNow())) {
                vTrangThai.setText("Bạn đã thanh toán tiền tháng này!");
                return false;
            }
        }
        return true;
    }

    private void addHD() {
        if (txtMaKH.equals("") == false) {
            //Lấy dữ liệu
            int maKH = Integer.parseInt(txtMaKH.getText());
            int maDK = dkCller.getMaDK(Integer.parseInt(txtMaKH.getText()));
            int tieuthu = Integer.parseInt(vTieuThu.getText());
            double thanhtien = Double.parseDouble(cutChar(vTongTien.getText()));
            String ngaylap = getDateNow();
            KhachHang kh = new KhachHang(maKH);
            DienKe dk = new DienKe(maDK);
            HoaDon hd = new HoaDon(kh, dk, tieuthu, ngaylap, thanhtien);
            hdCller.addHoaDon(hd);
        }
    }

    private void addLichSuGiaoDich() {
        //Lấy dữ liệu
        int maKH = Integer.parseInt(txtMaKH.getText());
        String sSql = "SELECT *  FROM HoaDon WHERE NgayLap = '" + getDateNow() + "' AND MaKH = " + maKH;
        rs = conn.loadData(sSql);
        int maHD = 0;
        try {
            while (rs.next()) {
                maHD = rs.getInt("MaHD");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonFr.class.getName()).log(Level.SEVERE, null, ex);
        }
        String thoigian = getDateNow();
        String ghichu = "Thanh toán thành công hóa đơn" + maHD + " ngày " + getDateNow() + "'";
        HoaDon hd = new HoaDon(maHD);
        //System.out.println(maHD);
        LichSuGiaoDich ls = new LichSuGiaoDich(hd, thoigian, ghichu);
        hdCller.addLS(ls);
    }

    private void xoaCongNo() {
        //lay dữ liệu
        int maKH = Integer.parseInt(txtMaKH.getText());
        String x = "";
        rs = conn.loadData("SELECT * FROM DienKe WHERE MaKH = " + maKH);
        try {
            while (rs.next()) {
                x = rs.getString("NamThang");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonFr.class.getName()).log(Level.SEVERE, null, ex);
        }
        KhachHang kh = new KhachHang(maKH);
        CongNo cn = new CongNo(kh, x);
        hdCller.xoaCN(cn);
    }

    private void ComboLoaiDVPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ComboLoaiDVPopupMenuWillBecomeInvisible

    }//GEN-LAST:event_ComboLoaiDVPopupMenuWillBecomeInvisible

    private void txtMaKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKHKeyReleased
        if (txtMaKH.getText().equals("")) {
            reset();
            TableKH.setModel(new KhachHangTable(khCller.getAllKhachHang()));
            TableDK.setModel(new DienKeTable(dkCller.getAllDienKe()));
            TableHoaDon.setModel(new HoaDonTable(hdCller.getAllHoaDon()));
            vTrangThai.setText("Hãy nhập mã khách hàng để kiểm tra!!!");
        } else {
            try {
                vTrangThai.setText("Trạng Thái");
                TableKH.setModel(new KhachHangTable(khCller.getKhachHang(Integer.parseInt(txtMaKH.getText()))));
                TableDK.setModel(new DienKeTable(dkCller.getDienKeByidKH(Integer.parseInt(txtMaKH.getText()))));
                TableHoaDon.setModel(new HoaDonTable(hdCller.getHoaDonByidKH(Integer.parseInt(txtMaKH.getText()))));
                String sSql = "SELECT * FROM KhachHang WHERE MaKH = " + Integer.parseInt(txtMaKH.getText());
                rs = conn.loadData(sSql);
                String Loai = "";
                try {
                    while (rs.next()) {
                        Loai = rs.getNString("TenLSD");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonFr.class.getName()).log(Level.SEVERE, null, ex);
                }
                ComboLoaiDV.setSelectedItem(Loai);
                int tieuthu = dkCller.LoadLuongTieuThu(Integer.parseInt(txtMaKH.getText()));
                String x = "";
                if (tieuthu == 0) {
                    vThanhTien.setText("0 VNĐ");
                    vThanhTien.setText("0 VNĐ");
                }
                x = String.valueOf(tieuthu);
                vTieuThu.setText(x);
                try {
                    if (check() == false) {
                        vTrangThai.setText("Bạn đã thanh toán tiền tháng này!!!");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(HoaDonFr.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (Exception e) {
                vTrangThai.setText("Lỗi nhập dữ liệu!!");
            }

        }


    }//GEN-LAST:event_txtMaKHKeyReleased

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed

        try {
            if (check() == true) {
                if (txtTienNhanKH.getText().equals("")) {
                    vTrangThai.setText("Bạn chưa nhập số tiền nhận!!!");
                } else {
                    addHD();
                    addLichSuGiaoDich();
                    xoaCongNo();
                    loadTableHD();
                    vTrangThai.setText("Hóa đơn đã được thêm thành công");
                    btnPrint.setEnabled(true);
                }
            } else {
                vTrangThai.setText("Bạn đã thanh toán tiền tháng này!!!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonFr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            vTrangThai.setText("Thêm hóa đơn thất bại!!!");
        }


    }//GEN-LAST:event_btnPayActionPerformed

    private void txtTienNhanKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienNhanKHKeyReleased
        try {
            if (txtTienNhanKH.getText().equals("") == false) {
                double tiennhan = Double.parseDouble(txtTienNhanKH.getText());
                double tong = Double.parseDouble(cutChar(vTongTien.getText()));
                String x = "";
                if (tiennhan < tong) {
                    vTrangThai.setText("Số tiền nhận không đủ thanh toán!!!");
                } else {
                    x = String.valueOf(formatMoney(tiennhan - tong));
                    vTienthua.setText(x);
                    vTrangThai.setText("Số tiền hợp lệ!!!");
                }
            } else {
                vTrangThai.setText("Bạn nhập số tiền đã nhận");
            }
        } catch (Exception e) {
            vTrangThai.setText("Lỗi nhập liệu!");
        }
    }//GEN-LAST:event_txtTienNhanKHKeyReleased

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        JasperPrint print = null;
        try {
            //Khai báo report
            HashMap map = new HashMap();
            JasperReport report = JasperCompileManager.compileReport("E:\\JAVA\\BTL_Java\\QuanLyTienDien\\src\\gui\\rpHoaDon.jrxml");
            if (txtMaKH.getText().trim().equals("") == false) {
                map.put("MaKH", Integer.parseInt(txtMaKH.getText()));
            }
            print = JasperFillManager.fillReport(report, map, conn.getConnect());
            JasperViewer.viewReport(print, false);
            reset();
            btnPay.setEnabled(false);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        this.setVisible(false);
        new MainFr(nv).setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void btnTinhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTinhTienActionPerformed
        // TODO add your handling code here:
        try {
            btnPrint.setEnabled(false);
            int makh = Integer.parseInt(txtMaKH.getText());
            if (khCller.checkmaKH(makh)) {
                String x = "";
                String y = "";
                String z = "";
                int tieuthu = Integer.parseInt(vTieuThu.getText());
                String TenDV = ComboLoaiDV.getSelectedItem().toString();
                double thanhtien = hdCller.ThanhTien(tieuthu, TenDV);
                double thue = hdCller.Thue(tieuthu, TenDV);
                double tong = thanhtien + thue;
                x = String.valueOf(formatMoney(thanhtien));
                y = String.valueOf(formatMoney(thue));
                z = String.valueOf(formatMoney(tong));
                vThanhTien.setText(x);
                vThue.setText(y);
                vTongTien.setText(z);
                btnPay.setEnabled(true);
            } else {
                vTrangThai.setText("Mã khách hàng không hợp lệ!!!");
            }
        } catch (Exception e) {
            vTrangThai.setText("Mã khách hàng không hợp lệ!!!");
        }

    }//GEN-LAST:event_btnTinhTienActionPerformed

    private void TableKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableKHMouseClicked
        try {
            selectedrow = TableKH.getSelectedRow();
            TableModel model = TableKH.getModel();
            txtMaKH.setText(model.getValueAt(selectedrow, 0).toString());
            int tieuthu = dkCller.LoadLuongTieuThu(Integer.parseInt(txtMaKH.getText()));
            String x = "";
            x = String.valueOf(tieuthu);
            vTieuThu.setText(x);
            ComboLoaiDV.setSelectedItem(model.getValueAt(selectedrow, 8).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_TableKHMouseClicked

    private void jMenuThongTinAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuThongTinAdminActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        jPopupMenuTaiKhoan.setVisible(false);
        new ProfileAdmin(nv).setVisible(true);
    }//GEN-LAST:event_jMenuThongTinAdminActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(HoaDonFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDonFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDonFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDonFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVien nv = new NhanVien();
                new HoaDonFr(nv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboLoaiDV;
    private javax.swing.JMenuItem JMenuDangXuat;
    private javax.swing.JTable TableDK;
    private javax.swing.JTable TableHoaDon;
    private javax.swing.JTable TableKH;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnTinhTien;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuThongTinAdmin;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenuTaiKhoan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtTienNhanKH;
    private javax.swing.JLabel vThanhTien;
    private javax.swing.JLabel vThue;
    private javax.swing.JLabel vTienthua;
    private javax.swing.JLabel vTieuThu;
    private javax.swing.JLabel vTongTien;
    private javax.swing.JLabel vTrangThai;
    // End of variables declaration//GEN-END:variables
}
