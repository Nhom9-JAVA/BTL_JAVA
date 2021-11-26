package gui;

import CustomTable.DienKeTable;
import CustomTable.KhachHangTable;
import database.CongNoController;
import database.DienKeController;
import database.KhachHangController;
import java.sql.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import qltdModel.CongNo;
import qltdModel.DienKe;
import qltdModel.KhachHang;
import qltdModel.NhanVien;

public class qlChiSoDienFr extends javax.swing.JFrame {

    private DienKeController dkCller = new DienKeController();
    private KhachHangController khCller = new KhachHangController();
    private CongNoController cnCller = new CongNoController();
    private NhanVien nv;
    private boolean add = false, change = false;

    public qlChiSoDienFr(NhanVien d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        //Kết nối cơ sở dữ liệu
        Disabled();
        loadKH();
        loadData();
        reset();
        nv = d;
      //  vTenAdmin.setText(nv.getHoTen());
//        checkDecentralization();
    }

    private void loadData() {
        try {
            tableElectrical.setModel(new DienKeTable(dkCller.getAllDienKe()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void loadKH() {
        try {

            tableNV.setModel(new KhachHangTable(khCller.getAllKhachHang()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void Enabled() {
        tfNgayNop.setEnabled(true);
        tfCSC.setEnabled(true);
        tfCSM.setEnabled(true);
    }

    private void Disabled() {
        tfNgayNop.setEnabled(false);
        tfCSC.setEnabled(false);
        tfCSM.setEnabled(false);
    }

    private void checkKyTu(String arry) {
        char[] character = arry.toCharArray();
        for (int i = 0; i < character.length; i++) {
            if (String.valueOf(character[i]).matches("\\D+")) {
                btnSave.setEnabled(false);
                lbTrangthai.setText("Số lượng không thể chứa kí tự");
                break;
            } else {
                btnSave.setEnabled(true);
            }
        }
    }

    private String cutChar(String arry) {
        return arry.replaceAll("\\D+", "");
    }

    private String cutNumber(String arry) {
        return arry.replaceAll("\\d+", "");
    }
 
    private String convertedToNumbers(String arry) {
        return arry.replace(",", "");
    }

    

    private void reset() {
        add = false;
        change = false;
        ((JTextField) tfNgayNop.getDateEditor().getUiComponent()).setText("");
        tfCSC.setText("");
        tfCSM.setText("");
        lbTrangthai.setText("Trạng Thái");
        btnSave.setEnabled(false);
        btnEdit.setEnabled(false);

        btnCancel.setEnabled(false);
    }

    private boolean checkNull() {
        if (tfMaDK.getText().equals("")) {
            lbTrangthai.setText("Bạn chưa nhập mã điện kế!");
            return false;
        } else if (tfMaKH.getText().equals("")) {
            lbTrangthai.setText("Bạn chưa nhập mã khách hàng!");
            return false;
        } else if (((JTextField) tfNgayNop.getDateEditor().getUiComponent()).getText().equals("")) {
            lbTrangthai.setText("Bạn chưa chọn ngày nộp!");
            return false;
        } else if (tfCSC.getText().equals("")) {
            lbTrangthai.setText("Bạn chưa nhập chỉ số cũ!");
            return false;
        } else if (tfCSM.getText().equals("")) {
            lbTrangthai.setText("Bạn chưa nhập chỉ số mới!");
            return false;
        }
        return true;
    }

    private String getDateNow() {
        Calendar calendar = Calendar.getInstance();
        String now = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
        return now;
    }

    private String getMonthLater() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        String later = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

        return later;
    }

    //Thêm vào ds chưa nộp
    private void addList() {
        if (checkNull() == true) {
            //Lấy dữ liệu
            CongNo cn = new CongNo();
            KhachHang kh = new KhachHang();
            kh.setMaKH(Integer.parseInt(tfMaKH.getText()));
            cn.setKh(kh);
            cn.setNamThang(((JTextField) tfNgayNop.getDateEditor().getUiComponent()).getText());
            cn.setGhiChu("Chưa nộp tiền");
            if (cnCller.ThemCongNo(cn) != 0) {
                reset();
                loadData();
                Disabled();
            }
        }
    }

    private void editDienKe() {
        if (checkNull()) {

            //Lấy dữ liệu
            KhachHang kh = new KhachHang();
            int MaDK = Integer.parseInt(tfMaDK.getText());
            kh.setMaKH(Integer.parseInt(tfMaKH.getText()));
            String NamThang = ((JTextField) tfNgayNop.getDateEditor().getUiComponent()).getText();
            int CSC = Integer.parseInt(tfCSC.getText());
            int CSM = Integer.parseInt(tfCSM.getText());
            DienKe dk = new DienKe(MaDK, kh, NamThang, CSC, CSM);
            if (CSC >= CSM) {
                lbTrangthai.setText("Cập nhật thất bại!");
            } else {
                if (dkCller.Update(dk) != 0) {
                    addList();
                    reset();
                    loadData();
                    Disabled();
                    lbTrangthai.setText("Cập nhật thành công!");
                } else {
                    lbTrangthai.setText("Cập nhật thất bại!");
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuTaiKhoan = new javax.swing.JPopupMenu();
        jMenuItemDangXuat = new javax.swing.JMenuItem();
        jMenuItemThongTinAdmin = new javax.swing.JMenuItem();
        lbQLTU = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbMatu = new javax.swing.JLabel();
        lbTen = new javax.swing.JLabel();
        tfMaKH = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tfCSC = new javax.swing.JTextField();
        tfCSM = new javax.swing.JTextField();
        tfNgayNop = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        tfMaDK = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableNV = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnEdit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        lbTrangthai = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableElectrical = new javax.swing.JTable();

        jMenuItemDangXuat.setText("Đăng xuất");
        jMenuItemDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDangXuatActionPerformed(evt);
            }
        });
        jPopupMenuTaiKhoan.add(jMenuItemDangXuat);

        jMenuItemThongTinAdmin.setText("Thông tin tài khoản");
        jMenuItemThongTinAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemThongTinAdminActionPerformed(evt);
            }
        });
        jPopupMenuTaiKhoan.add(jMenuItemThongTinAdmin);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý điện");

        lbQLTU.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbQLTU.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQLTU.setText("QUẢN LÝ CHỈ SỐ ĐIỆN");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cập nhật chỉ số điện", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        lbMatu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbMatu.setText("Mã khách hàng");

        lbTen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTen.setText("Ngày chốt số");

        tfMaKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfMaKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMaKHKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Chỉ số cũ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Chỉ số mới");

        tfCSC.setEditable(false);
        tfCSC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfCSC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCSCKeyReleased(evt);
            }
        });

        tfCSM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfCSM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCSMKeyReleased(evt);
            }
        });

        tfNgayNop.setDateFormatString("yyyy-MM-dd");
        tfNgayNop.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Mã điện kế");

        tfMaDK.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfMaDK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMaDKKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(lbMatu)
                    .addComponent(lbTen)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfMaKH)
                    .addComponent(tfCSC)
                    .addComponent(tfCSM)
                    .addComponent(tfNgayNop, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(tfMaDK))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfMaDK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMatu)
                    .addComponent(tfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfNgayNop, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lbTen)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfCSC, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(tfCSM, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        tableNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableNV.setRowHeight(25);
        jScrollPane1.setViewportView(tableNV);

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/edit.png"))); // NOI18N
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/icons8_refresh_50px_1.png"))); // NOI18N
        btnCancel.setEnabled(false);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/icons8_home_50px_1.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/floppy-disk.png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 67, Short.MAX_VALUE)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        lbTrangthai.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTrangthai.setForeground(new java.awt.Color(0, 204, 0));
        lbTrangthai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTrangthai.setText("Trạng Thái");

        tableElectrical.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableElectrical.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableElectrical.setRowHeight(25);
        tableElectrical.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableElectricalMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableElectrical);
        tableElectrical.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(30, 30, 30)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(lbQLTU, javax.swing.GroupLayout.PREFERRED_SIZE, 751, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(lbQLTU)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        add = false;
        change = true;
        Enabled();
        tfMaDK.setEditable(false);
        tfMaKH.setEditable(false);
//        tfMaDK.setEnabled(false);
//        tfMaKH.setEnabled(false);

        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Disabled();
        reset();
        loadData();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainFr home = new MainFr(nv);
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tfCSMKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCSMKeyReleased
        tfCSM.setText(cutChar(tfCSM.getText()));
    }//GEN-LAST:event_tfCSMKeyReleased

    private void tableElectricalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableElectricalMouseClicked
        int click = tableElectrical.getSelectedRow();
        TableModel model = tableElectrical.getModel();

        tfMaDK.setText(model.getValueAt(click, 0).toString());
        tfMaKH.setText(model.getValueAt(click, 1).toString());
        ((JTextField) tfNgayNop.getDateEditor().getUiComponent()).setText(getMonthLater());
        tfCSC.setText(convertedToNumbers(model.getValueAt(click, 4).toString()));

        btnEdit.setEnabled(true);

    }//GEN-LAST:event_tableElectricalMouseClicked

    private void tfMaDKKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMaDKKeyReleased
        tfMaDK.setText(cutChar(tfMaDK.getText()));
        if (tfMaDK.getText().trim().equals("")) {
            loadData();
        } else {
            tableElectrical.setModel(new DienKeTable(dkCller.getDienKeByMaDK(Integer.parseInt(tfMaDK.getText()))));
        }
    }//GEN-LAST:event_tfMaDKKeyReleased

    private void tfMaKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMaKHKeyReleased
        tfMaKH.setText(cutChar(tfMaKH.getText()));
        if (tfMaKH.getText().trim().equals("")) {
            loadData();
            loadKH();
        } else {
            tableNV.setModel(new KhachHangTable(khCller.getKhachHang(Integer.parseInt(tfMaKH.getText()))));
        }
    }//GEN-LAST:event_tfMaKHKeyReleased

    private void tfCSCKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCSCKeyReleased
        tfCSC.setText(cutChar(tfCSC.getText()));
    }//GEN-LAST:event_tfCSCKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (add == false) {
            if (change != false) {
                editDienKe();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void jMenuItemDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDangXuatActionPerformed
        // TODO add your handling code here:
        int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (click == JOptionPane.YES_OPTION) {
            new LoginFr().setVisible(true);
            jPopupMenuTaiKhoan.setVisible(false);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jMenuItemDangXuatActionPerformed

    private void jMenuItemThongTinAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemThongTinAdminActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        jPopupMenuTaiKhoan.setVisible(false);
        new ProfileAdmin(nv).setVisible(true);
    }//GEN-LAST:event_jMenuItemThongTinAdminActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For nvs see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(qlChiSoDienFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qlChiSoDienFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qlChiSoDienFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qlChiSoDienFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVien nv = new NhanVien();
                new qlChiSoDienFr(nv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItemDangXuat;
    private javax.swing.JMenuItem jMenuItemThongTinAdmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenuTaiKhoan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbMatu;
    private javax.swing.JLabel lbQLTU;
    private javax.swing.JLabel lbTen;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JTable tableElectrical;
    private javax.swing.JTable tableNV;
    private javax.swing.JTextField tfCSC;
    private javax.swing.JTextField tfCSM;
    private javax.swing.JTextField tfMaDK;
    private javax.swing.JTextField tfMaKH;
    private com.toedter.calendar.JDateChooser tfNgayNop;
    // End of variables declaration//GEN-END:variables
}
