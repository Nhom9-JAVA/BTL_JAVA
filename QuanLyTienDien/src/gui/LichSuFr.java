package gui;

import CustomTable.LichSuGiaoDichTable;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import qltdModel.NhanVien;
import database.LichSuGiaoDichController;
import javax.swing.JOptionPane;

public class LichSuFr extends javax.swing.JFrame {

    private boolean add = false, change = false;
    private NhanVien nv;
    private LichSuGiaoDichController ls;

    public LichSuFr(NhanVien d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        nv = d;
   //     vTenAdmin.setText(nv.getHoTen());
        ls = new LichSuGiaoDichController();
        //Kết nối cơ sở dữ liệu
        //Thao tác
        LoadHistory();
    }

    private void LoadHistory() {
        try {
            tableLichSu.setModel(new LichSuGiaoDichTable(ls.getLichSuGDs()));
            if (tableLichSu.getColumnModel().getColumnCount() > 0) {
                tableLichSu.getColumnModel().getColumn(0).setMaxWidth(100);
                tableLichSu.getColumnModel().getColumn(1).setMaxWidth(100);
                tableLichSu.getColumnModel().getColumn(2).setMaxWidth(100);
                tableLichSu.getColumnModel().getColumn(3).setMaxWidth(150);
                tableLichSu.getColumnModel().getColumn(4).setMaxWidth(500);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void LoadHistoryMaKH(String MaKH) {
        try {
            int ma = Integer.parseInt(MaKH);
            if (!ls.getLS(ma).isEmpty()) {
                tableLichSu.setModel(new LichSuGiaoDichTable(ls.getLS(ma)));
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy lịch sử giao dịch này!!!");
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng không hợp lệ!!!");
            System.out.println(ex.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenuTaiKhoan = new javax.swing.JPopupMenu();
        jMenuItemDangXuat = new javax.swing.JMenuItem();
        jMenuItemThongTinAdmin = new javax.swing.JMenuItem();
        lbQLNV = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLichSu = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfMaKhachHang = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();

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
        setTitle("Quản lý nhân viên");

        lbQLNV.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        lbQLNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQLNV.setText("LỊCH SỬ GIAO DỊCH");

        tableLichSu.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tableLichSu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableLichSu.setRowHeight(30);
        tableLichSu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableLichSuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableLichSu);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "THÔNG TIN", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 18))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel1.setText("Mã Khách hàng");

        tfMaKhachHang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tfMaKhachHang.setMargin(new java.awt.Insets(5, 10, 5, 10));
        tfMaKhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMaKhachHangKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(20, 20, 20)
                .addComponent(tfMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/icons8_return_40px.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbQLNV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(244, 244, 244))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 895, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lbQLNV))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnBack)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableLichSuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableLichSuMouseClicked

    }//GEN-LAST:event_tableLichSuMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed

        MainFr home = new MainFr(nv);
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void tfMaKhachHangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMaKhachHangKeyReleased
        if (tfMaKhachHang.getText().trim().equals("")) {
            LoadHistory();
        } else {
            LoadHistoryMaKH(tfMaKhachHang.getText().trim());
        }
    }//GEN-LAST:event_tfMaKhachHangKeyReleased

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
            java.util.logging.Logger.getLogger(LichSuFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LichSuFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LichSuFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LichSuFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVien nv = new NhanVien();
                new LichSuFr(nv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItemDangXuat;
    private javax.swing.JMenuItem jMenuItemThongTinAdmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenuTaiKhoan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbQLNV;
    private javax.swing.JTable tableLichSu;
    private javax.swing.JTextField tfMaKhachHang;
    // End of variables declaration//GEN-END:variables
}
