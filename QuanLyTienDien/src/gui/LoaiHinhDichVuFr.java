package gui;

import CustomTable.LoaiHinhDVTable;
import database.LoaiHinhDVController;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import qltdModel.LoaiHinhDV;
import qltdModel.NhanVien;

public class LoaiHinhDichVuFr extends javax.swing.JFrame {

    private LoaiHinhDVController lhdv;
    private NhanVien nv;
    private boolean add = false, change = false;

    public LoaiHinhDichVuFr(NhanVien d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);
        nv = d;
 //       vTenAdmin.setText(nv.getHoTen());
        //Kết nối cơ sở dữ liệu
        lhdv = new LoaiHinhDVController();
        DisabledTextField();
        loadDichVu();
    }

    private void load() {
        tableDVDien.setModel(new LoaiHinhDVTable(lhdv.getLoaiHinhDV(cLoaiHinhDV.getSelectedItem().toString())));
    }

    private void reset() {
        tfMaLSD.setText("");
        tfTenDichVu.setText("");
        tfTuDM.setText("");
        tfDenDM.setText("");
        tfDG.setText("");
        tfThue.setText("");
        cLoaiHinhDV.setSelectedIndex(0);
        cLoaiHinhDV.setEnabled(true);
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnDel.setEnabled(false);
        btnSave.setEnabled(false);
        btnCancel.setEnabled(false);
        lbTrangthai.setText("Trạng thái");
    }

    private boolean checkNull() {
        if (tfTenDichVu.getText().equals("")) {
            lbTrangthai.setText("Bạn chưa nhập tên loại hình dịch vụ");
            return false;
        } else if (tfTuDM.getText().equals("")) {
            lbTrangthai.setText("Bạn cần phải nhập số định mức dùng điện");
            return false;
        } else if (tfDG.getText().equals("")) {
            lbTrangthai.setText("Bạn cần nhập đơn giá sử dụng điện");
            return false;
        }
        return true;
    }

    private void loadDichVu() {
        cLoaiHinhDV.setModel(new DefaultComboBoxModel(lhdv.getTenLSD()));
        load();
    }

    private void EnabledTextField() {
        tfMaLSD.setEnabled(true);
        tfTenDichVu.setEnabled(true);
        tfTuDM.setEnabled(true);
        tfDenDM.setEnabled(true);
        tfDG.setEnabled(true);
        tfThue.setEnabled(true);
    }

    private void DisabledTextField() {
        tfMaLSD.setEnabled(false);
        tfTenDichVu.setEnabled(false);
        tfTuDM.setEnabled(false);
        tfDenDM.setEnabled(false);
        tfDG.setEnabled(false);
        tfThue.setEnabled(false);
    }

    private void addService() {
        if (checkNull()) {
            LoaiHinhDV dv = new LoaiHinhDV(Integer.parseInt(tfMaLSD.getText()), tfTenDichVu.getText(), Integer.parseInt(tfTuDM.getText()), Integer.parseInt(tfDenDM.getText()), Double.parseDouble(tfDG.getText()), Double.parseDouble(tfThue.getText()));
            if (lhdv.add(dv) > 0) {
                reset();
                load();
                DisabledTextField();
                lbTrangthai.setText("Đã thêm thành công loại hình dịch vụ " + tfTenDichVu.getText());
            } else {
                lbTrangthai.setText("thêm không thành công loại hình dịch vụ " + tfTenDichVu.getText());
            }
        }
    }

    private void editService() {
        if (checkNull()) {
            LoaiHinhDV dv = new LoaiHinhDV(Integer.parseInt(tfMaLSD.getText()), tfTenDichVu.getText(), Integer.parseInt(tfTuDM.getText()), Integer.parseInt(tfDenDM.getText()), Double.parseDouble(tfDG.getText()), Double.parseDouble(tfThue.getText()));
            if (lhdv.update(dv) > 0) {
                reset();
                load();
                DisabledTextField();
                lbTrangthai.setText("Đã sửa thành công loại hình dịch vụ " + tfTenDichVu.getText());
            } else {
                lbTrangthai.setText("sửa không thành công loại hình dịch vụ " + tfTenDichVu.getText());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenuTaiKhoan = new javax.swing.JPopupMenu();
        jMenuItemDangXuat = new javax.swing.JMenuItem();
        jMenuItemThongTinAdmin = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cLoaiHinhDV = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableDVDien = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        tfDG = new javax.swing.JTextField();
        tfTuDM = new javax.swing.JTextField();
        tfTenDichVu = new javax.swing.JTextField();
        lbSoban = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        lbTenkhach = new javax.swing.JLabel();
        lbSDT1 = new javax.swing.JLabel();
        tfDenDM = new javax.swing.JTextField();
        lbTenkhach1 = new javax.swing.JLabel();
        tfMaLSD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfThue = new javax.swing.JTextField();
        lbTrangthai = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();

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
        setTitle("Loại hình dịch vụ");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("LOẠI HÌNH DỊCH VỤ ĐIỆN");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Giá bán điện", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 20))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ngành dịch vụ");

        cLoaiHinhDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cLoaiHinhDV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cLoaiHinhDVItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(cLoaiHinhDV, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cLoaiHinhDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        tableDVDien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableDVDien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableDVDien.setRowHeight(25);
        tableDVDien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDVDienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableDVDien);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dịch vụ", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 20))); // NOI18N
        jPanel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfDG.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfTuDM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfTenDichVu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbSoban.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSoban.setText("Đơn giá:");

        lbSDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSDT.setText("Từ định mức");

        lbTenkhach.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTenkhach.setText("Tên loại dịch vụ:");

        lbSDT1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSDT1.setText("Đến định mức");

        tfDenDM.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbTenkhach1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTenkhach1.setText("Mã dịch vụ:");

        tfMaLSD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Thuê VAT");

        tfThue.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lbTenkhach1)
                        .addGap(12, 12, 12)
                        .addComponent(tfMaLSD, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lbTenkhach)
                        .addGap(12, 12, 12)
                        .addComponent(tfTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(lbSDT)
                        .addGap(12, 12, 12)
                        .addComponent(tfTuDM, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(lbSDT1)
                        .addGap(12, 12, 12)
                        .addComponent(tfDenDM, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(lbSoban)
                        .addGap(12, 12, 12)
                        .addComponent(tfDG, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel3)
                        .addGap(10, 10, 10)
                        .addComponent(tfThue, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbTenkhach1))
                    .addComponent(tfMaLSD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbTenkhach))
                    .addComponent(tfTenDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbSDT))
                    .addComponent(tfTuDM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbSDT1))
                    .addComponent(tfDenDM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbSoban))
                    .addComponent(tfDG, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel3))
                    .addComponent(tfThue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        lbTrangthai.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTrangthai.setForeground(new java.awt.Color(0, 204, 0));
        lbTrangthai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTrangthai.setText("Trạng thái");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, 353, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbTrangthai)
                .addGap(27, 27, 27))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        btnSave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/floppy-disk (1).png"))); // NOI18N
        btnSave.setEnabled(false);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
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

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/plus.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/edit.png"))); // NOI18N
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/delete.png"))); // NOI18N
        btnDel.setEnabled(false);
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

        btnHome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/smart-home.png"))); // NOI18N
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                        .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
            .addGroup(layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        reset();
        add = true;
        EnabledTextField();

        cLoaiHinhDV.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnAdd.setEnabled(false);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        add = false;
        change = true;
        EnabledTextField();

        btnAdd.setEnabled(false);
        btnDel.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        btnSave.setEnabled(true);
        int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa Loại hình DV này không?", "Thông báo", 2);
        if (click == JOptionPane.YES_OPTION) {
            if (lhdv.del(Integer.parseInt(tfMaLSD.getText())) > 0) {
                load();
                lbTrangthai.setText("Đã xóa thành công loại hình dịch vụ có mã =" + tfMaLSD.getText());
            } else {
                lbTrangthai.setText("xóa không thành công loại hình dịch vụ có mã =" + tfMaLSD.getText());
            }
        } else {
            reset();
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        MainFr home = new MainFr(nv);
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        reset();
        DisabledTextField();
    }//GEN-LAST:event_btnCancelActionPerformed
    int rowSelected;
    private void tableDVDienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDVDienMouseClicked
        btnEdit.setEnabled(true);
        btnDel.setEnabled(true);
        rowSelected = tableDVDien.getSelectedRow();
        TableModel model = tableDVDien.getModel();

        tfMaLSD.setText(model.getValueAt(rowSelected, 0).toString());
        tfTenDichVu.setText(model.getValueAt(rowSelected, 1).toString());
        cLoaiHinhDV.addItem(model.getValueAt(rowSelected, 1).toString());
        tfTuDM.setText(model.getValueAt(rowSelected, 2).toString());
        tfDenDM.setText(model.getValueAt(rowSelected, 3).toString());
        tfDG.setText(model.getValueAt(rowSelected, 4).toString());
        tfThue.setText(model.getValueAt(rowSelected, 5).toString());

    }//GEN-LAST:event_tableDVDienMouseClicked

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        LoaiHinhDV dv = new LoaiHinhDV(Integer.parseInt(tfMaLSD.getText()), tfTenDichVu.getText(), Integer.parseInt(tfTuDM.getText()), Integer.parseInt(tfDenDM.getText()), Double.parseDouble(tfDG.getText()), Double.parseDouble(tfThue.getText()));
        if (add == true) {
            if (lhdv.check(dv) > 0) {
                addService();
                loadDichVu();
            } else {
                lbTrangthai.setText("Mã/Định mức của loại hình này đã tồn tại!");
            }
        } else {
            if (change == true) {
                editService();
                loadDichVu();
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

    private void cLoaiHinhDVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cLoaiHinhDVItemStateChanged
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_cLoaiHinhDVItemStateChanged

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
            java.util.logging.Logger.getLogger(LoaiHinhDichVuFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoaiHinhDichVuFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoaiHinhDichVuFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoaiHinhDichVuFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVien nv = new NhanVien();
                new LoaiHinhDichVuFr(nv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cLoaiHinhDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItemDangXuat;
    private javax.swing.JMenuItem jMenuItemThongTinAdmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenuTaiKhoan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbSDT1;
    private javax.swing.JLabel lbSoban;
    private javax.swing.JLabel lbTenkhach;
    private javax.swing.JLabel lbTenkhach1;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JTable tableDVDien;
    private javax.swing.JTextField tfDG;
    private javax.swing.JTextField tfDenDM;
    private javax.swing.JTextField tfMaLSD;
    private javax.swing.JTextField tfTenDichVu;
    private javax.swing.JTextField tfThue;
    private javax.swing.JTextField tfTuDM;
    // End of variables declaration//GEN-END:variables
}
