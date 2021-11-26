package gui;

import CustomTable.TienIchTable;
import database.LoaiHinhDVController;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import qltdModel.LoaiHinhDV;
import qltdModel.NhanVien;

public class TienIchFr extends javax.swing.JFrame {

    private NhanVien nv;
    private LoaiHinhDVController loaiDV = null;
    private ArrayList<Object[]> li = new ArrayList<>();

    public TienIchFr(NhanVien d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        //gán nv form bằng nhân viên mới
        nv = d;
     //   vTenAdmin.setText(nv.getHoTen());
        loaiDV = new LoaiHinhDVController();
        loadDichVu();
        reset();
    }

    private void reset() {
        tfCSD.setText("");
        tfGia.setText("");
        cLoaiDV.setSelectedItem(null);
        tfGia.setEnabled(false);
        cLoaiDV.setEnabled(false);
    }

    private String cutChar(String arry) {
        return arry.replaceAll("\\D+", "");
    }

    private void loadData() {
        try {
            double tongTien = 0;

            // Thực thi câu lệnh SQL
            for (LoaiHinhDV item : loaiDV.getLoaiHinhDV(cLoaiDV.getSelectedItem().toString())) {
                if (KhoangTieuThu(Integer.parseInt(tfCSD.getText()), item.getTuDM(), item.getDenDM()) > 0) {
                    int tuDM = item.getTuDM();
                    int denDM = item.getDenDM();
                    int tieuThu = KhoangTieuThu(Integer.parseInt(tfCSD.getText()), tuDM, denDM);
                    String thanhtien = formatMoney(KhoangTieuThu(Integer.parseInt(tfCSD.getText()), tuDM, denDM) * item.getDonGia());
                    li.add(new Object[]{tuDM, denDM, tieuThu, thanhtien});
                    tongTien += tieuThu * item.getDonGia();
                }
                tfTongTien.setText(formatMoney(tongTien));
                tfVAT.setText(formatMoney(Double.parseDouble(cutChar(tfTongTien.getText())) * (item.getThueVAT() / 100)));
                tfTTTT.setText(formatMoney(Double.parseDouble(cutChar(tfTongTien.getText())) + Double.parseDouble(cutChar(tfVAT.getText()))));
            }
            tableGiaDien.setModel(new TienIchTable(li));

////            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //Hiển thị các loại dịch vụ lên Combobox
    private void loadDichVu() {
        cLoaiDV.removeAllItems();
        cLoaiDV.setModel(new DefaultComboBoxModel<>(loaiDV.getTenLSD()));

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

    // x = tổng tiêu thụ, k1 = bắt đầu khoảng, k2 = cuối khoảng
    public int KhoangTieuThu(int tieuthu, int tudm, int dendm) {
        if (tieuthu <= tudm) {
            return 0;
        }
        if(tieuthu >= dendm){
            return dendm - tudm;
        }
        return tieuthu - tudm;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenuTaiKhoan = new javax.swing.JPopupMenu();
        jMenuItemDangXuat = new javax.swing.JMenuItem();
        jMenuItemThongTinAdmin = new javax.swing.JMenuItem();
        jLabel3 = new javax.swing.JLabel();
        btnHome = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableGiaDien = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cLoaiDV = new javax.swing.JComboBox<>();
        tfGia = new javax.swing.JTextField();
        rbLHDV = new javax.swing.JRadioButton();
        rbGia = new javax.swing.JRadioButton();
        tfCSD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfTongTien = new javax.swing.JLabel();
        tfVAT = new javax.swing.JLabel();
        tfTTTT = new javax.swing.JLabel();

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("BẢNG GIÁ ĐIỆN SINH HOẠT");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/smart-home.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        tableGiaDien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tableGiaDien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Từ ĐM", "Đến ĐM", "Số Điện", "Thành Tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableGiaDien.setRowHeight(35);
        tableGiaDien.setRowMargin(5);
        jScrollPane1.setViewportView(tableGiaDien);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Nhập các chỉ số để tính tiền", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 20))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Chỉ số điện");

        cLoaiDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cLoaiDV.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cLoaiDVPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        tfGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfGia.setMargin(new java.awt.Insets(5, 10, 5, 10));

        buttonGroup1.add(rbLHDV);
        rbLHDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbLHDV.setText("Loại hình dịch vụ");
        rbLHDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbLHDVMouseClicked(evt);
            }
        });

        buttonGroup1.add(rbGia);
        rbGia.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbGia.setText("Nhập giá");
        rbGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbGiaMouseClicked(evt);
            }
        });

        tfCSD.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tfCSD.setMargin(new java.awt.Insets(5, 10, 5, 10));
        tfCSD.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tfCSDPropertyChange(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tính tiền");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbLHDV))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbGia)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfCSD, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfCSD, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbLHDV)
                    .addComponent(rbGia))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Thành Tiền", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tổng tiền:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 37, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("VAT (10%):");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 67, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Tổng tiền thanh toán: ");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 97, -1, -1));

        tfTongTien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(tfTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 37, -1, -1));

        tfVAT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(tfVAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 67, -1, -1));

        tfTTTT.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(tfTTTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 97, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        MainFr home = new MainFr(nv);
        //Chuyển hướng trang
        dispose();
        this.setVisible(false);
        home.setVisible(true);

    }//GEN-LAST:event_btnHomeActionPerformed

    private void cLoaiDVPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cLoaiDVPopupMenuWillBecomeInvisible
//        loadData();
    }//GEN-LAST:event_cLoaiDVPopupMenuWillBecomeInvisible

    private void rbLHDVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbLHDVMouseClicked
        if (rbLHDV.isSelected()) {
            tfGia.setEnabled(false);
            cLoaiDV.setEnabled(true);
        }
    }//GEN-LAST:event_rbLHDVMouseClicked

    private void rbGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbGiaMouseClicked
        if (rbGia.isSelected()) {
            cLoaiDV.setEnabled(false);
            tfGia.setEnabled(true);
        }
    }//GEN-LAST:event_rbGiaMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (tfCSD.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập chỉ số điện");
        } else {
            try {
                if (rbLHDV.isSelected()) {
                    loadData();
                } else if (rbGia.isSelected()) {
                    tfTongTien.setText(formatMoney(Double.parseDouble(cutChar(tfCSD.getText())) * Double.parseDouble(cutChar(tfGia.getText()))));
                    tfVAT.setText(formatMoney(Double.parseDouble(cutChar(tfTongTien.getText())) * 0.1));
                    tfTTTT.setText(formatMoney(Double.parseDouble(cutChar(tfTongTien.getText())) + Double.parseDouble(cutChar(tfVAT.getText()))));
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Chỉ sô nhập vào không đúng");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jMenuItemThongTinAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemThongTinAdminActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        jPopupMenuTaiKhoan.setVisible(false);
        new ProfileAdmin(nv).setVisible(true);
    }//GEN-LAST:event_jMenuItemThongTinAdminActionPerformed

    private void jMenuItemDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDangXuatActionPerformed
        // TODO add your handling code here:
        int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        if (click == JOptionPane.YES_OPTION) {
            new LoginFr().setVisible(true);
            jPopupMenuTaiKhoan.setVisible(false);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jMenuItemDangXuatActionPerformed

    private void tfCSDPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tfCSDPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tfCSDPropertyChange

    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVien detail = new NhanVien();
                new TienIchFr(detail).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHome;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cLoaiDV;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuItem jMenuItemDangXuat;
    private javax.swing.JMenuItem jMenuItemThongTinAdmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenuTaiKhoan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbGia;
    private javax.swing.JRadioButton rbLHDV;
    private javax.swing.JTable tableGiaDien;
    private javax.swing.JTextField tfCSD;
    private javax.swing.JTextField tfGia;
    private javax.swing.JLabel tfTTTT;
    private javax.swing.JLabel tfTongTien;
    private javax.swing.JLabel tfVAT;
    // End of variables declaration//GEN-END:variables
}
