package gui;

import CustomTable.KhachHangTable;
import database.DienKeController;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.TableModel;
import qltdModel.NhanVien;
import database.KhachHangController;
import database.LoaiHinhDVController;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import qltdModel.DienKe;
import qltdModel.KhachHang;

public class qlkhFr extends javax.swing.JFrame {

    private KhachHangController khController = new KhachHangController();
    private LoaiHinhDVController loaiDVController = new LoaiHinhDVController();
    private DienKeController dienKeController = new DienKeController();
    private boolean add = false, change = false;
    private NhanVien nv;

    public qlkhFr(NhanVien d) {
        initComponents();
        setResizable(false);
        setLocationRelativeTo(this);

        //Kết nối cơ sở dữ liệu
        Disabled();
        loadDichVu();
        loadData();
        reset();
        nv = d;
       // vTenAdmin.setText(nv.getHoTen());
    }

    private void loadData() {
        try {
            tableNV.setModel(new KhachHangTable(khController.getAllKhachHang()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void Enabled() {
        tfMaKH.setEnabled(true);
        tfHoten.setEnabled(true);
        tfCMT.setEnabled(true);
        tfNgaysinh.setEnabled(true);
        tfDiachi.setEnabled(true);
        rbNu.setEnabled(true);
        rbNam.setEnabled(true);
        tfSDT.setEnabled(true);
        cTenLSD.setEnabled(true);
        tfNgayBDSD.setEnabled(true);
    }

    private void Disabled() {
//        tfMaNV.setEnabled(false);
//        tfHoten.setEnabled(false);
//        tfCMT.setEnabled(false);
        tfNgaysinh.setEnabled(false);
        tfDiachi.setEnabled(false);
        rbNu.setEnabled(false);
        rbNam.setEnabled(false);
        tfSDT.setEnabled(false);
        cTenLSD.setEnabled(false);
        tfNgayBDSD.setEnabled(false);

    }

    private void reset() {
        add = false;
        change = false;
        tfMaKH.setText("");     // Mã nhân viên
        tfHoten.setText("");    // Họ tên
        ((JTextField) tfNgaysinh.getDateEditor().getUiComponent()).setText(""); //Ngày sinh
        tfSDT.setText("");      // Số điện thoại
        ((JTextField) tfNgayBDSD.getDateEditor().getUiComponent()).setText("");
        cTenLSD.setSelectedItem(null);
        tfCMT.setText("");
        tfDiachi.setText("");   // Địa chỉ
        lbTrangthai.setText("Trạng Thái");  // Trạng thái
        rbNam.setSelected(false);   //GT: Nam
        rbNu.setSelected(false);   //GT: Nam
        btnEdit.setEnabled(false);  //GT: Nữ
        btnDel.setEnabled(false);   // Xóa
        btnSave.setEnabled(false);  // Lưu
        btnCancel.setEnabled(false);//Hủy
        btnAdd.setEnabled(true);    // Thêm
    }

    private void checkGT(String GT) {
        if (GT.equalsIgnoreCase("Nam")) {
            rbNam.setSelected(true);
        } else {
            rbNu.setSelected(true);
        }
    }

    private boolean checkNull() {
//        if (tfMaNV.getText().equals("")) {
//            lbTrangthai.setText("Bạn chưa nhập mã khách hàng!");
//            return false;
//        } 
        if (tfHoten.getText().equals("")) {
            lbTrangthai.setText("Bạn chưa nhập họ tên khách hàng!");
            return false;
        } else if (rbNam.isSelected() == false && rbNu.isSelected() == false) {
            lbTrangthai.setText("Bạn chưa chọn giới tính!");
            return false;
        } else if (((JTextField) tfNgaysinh.getDateEditor().getUiComponent()).getText().equals("")) {
            lbTrangthai.setText("Bạn chưa nhập ngày sinh!");
            return false;
        } else if (tfSDT.getText().equals("")) {
            lbTrangthai.setText("Bạn chưa nhập số điện thoại!");
            return false;
        } else if (tfCMT.getText().equals("")) {
            lbTrangthai.setText("Bạn chưa nhập số Chứng minh thư!");
            return false;
        } else if (tfDiachi.getText().equals("")) {
            lbTrangthai.setText("Bạn chưa nhập địa chỉ!");
            return false;
        } else {
            return true;
        }
    }

    private String gioiTinh() {
        String x = "";
        if (rbNam.isSelected()) {
            x = "Nam";
        } else {
            x = "Nữ";
        }
        return x;
    }

    private void loadDichVu() {
        cTenLSD.removeAllItems();
        cTenLSD.setModel(new DefaultComboBoxModel<>(loaiDVController.getTenLSD()));
    }

    private String getDateNow() {
        Calendar calendar = Calendar.getInstance();
        String now = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());

        return now;
    }

    public KhachHang getModel() {
        int MaKH = Integer.parseInt(tfMaKH.getText());
        String HoTenKH = tfHoten.getText();
        String CMT = tfCMT.getText();
        String NgaySinh = ((JTextField) tfNgaysinh.getDateEditor().getUiComponent()).getText();
        String DiaChi = tfDiachi.getText();
        String GioiTinh = gioiTinh();
        String DienThoai = tfSDT.getText();
        String NgayBDSD = getDateNow();
        String TenLSD = (String) cTenLSD.getSelectedItem();

        KhachHang k = new KhachHang(MaKH, NgayBDSD, TenLSD, HoTenKH, CMT, NgaySinh, DiaChi, GioiTinh, DienThoai);
        return k;
    }

    private void addNV() {
        if (checkNull() == true) {
            KhachHang kh = new KhachHang();
            kh.setHoTen(tfHoten.getText());
            kh.setCMT(tfCMT.getText());
            kh.setDiaChi(tfDiachi.getText());
            kh.setDienThoai(tfSDT.getText());
            kh.setGioiTinh(gioiTinh());
            kh.setNgaySinh(((JTextField) tfNgaysinh.getDateEditor().getUiComponent()).getText());
            kh.setNgayBDSD(getDateNow());
            kh.setTenLSD((String) cTenLSD.getSelectedItem());
            if (khController.ThemKhachHang(kh) > 0) {
                addDienKe();
                reset();
                loadData();
                Disabled();
                lbTrangthai.setText("Thêm thông tin khách hàng thành công!");
            } else {
                lbTrangthai.setText("Thêm thông tin khách hàng thất bại!");
            }
        }
    }

    private void addDienKe() {
        if (checkNull() == true) {
            //Lấy dữ liệu
            ArrayList<KhachHang> list = new ArrayList<>(khController.getAllKhachHang());
            DienKe dienKe = new DienKe();
            KhachHang kh = new KhachHang();
            kh.setMaKH(list.get(list.size() - 1).getMaKH());
            dienKe.setKh(kh);
            dienKe.setNamThang(getDateNow());
            dienKe.setCSC(0);
            dienKe.setCSM(0);
            if (dienKeController.Insert(dienKe) != 0) {
                reset();
                loadData();
                Disabled();
            }
        }
    }

    private void changeNV() {
        if (checkNull() == true) {
            int click = tableNV.getSelectedRow();
            if (khController.Update(getModel()) > 0) {
                reset();
                loadData();
                Disabled();
                lbTrangthai.setText("Sửa thông tin khách hàng thành công!");
            } else {
                lbTrangthai.setText("Sửa thông tin khách hàng thất bại!");
            }
        }
    }

    private String cutChar(String arry) {
        return arry.replaceAll("\\D+", "");
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
        tableNV = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbHoten = new javax.swing.JLabel();
        lbGioitinh = new javax.swing.JLabel();
        lbNgaysinh = new javax.swing.JLabel();
        lbSDT = new javax.swing.JLabel();
        lbDiachi = new javax.swing.JLabel();
        tfHoten = new javax.swing.JTextField();
        tfSDT = new javax.swing.JTextField();
        tfDiachi = new javax.swing.JTextField();
        rbNam = new javax.swing.JRadioButton();
        rbNu = new javax.swing.JRadioButton();
        tfNgaysinh = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        tfMaKH = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfNgayBDSD = new com.toedter.calendar.JDateChooser();
        tfCMT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cTenLSD = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDel = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnFind = new javax.swing.JButton();
        lbTrangthai = new javax.swing.JLabel();

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
        setTitle("Quản lý khách hàng");

        lbQLNV.setFont(new java.awt.Font("Tahoma", 0, 40)); // NOI18N
        lbQLNV.setForeground(new java.awt.Color(0, 51, 255));
        lbQLNV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbQLNV.setText("QUẢN LÝ KHÁCH HÀNG");

        tableNV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tableNV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableNV.setRowHeight(30);
        tableNV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableNVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableNV);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin cá nhân", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 20))); // NOI18N

        lbHoten.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbHoten.setText("Họ và Tên:");

        lbGioitinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbGioitinh.setText("Giới tính:");

        lbNgaysinh.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNgaysinh.setText("Ngày sinh:");

        lbSDT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbSDT.setText("Số điện thoại:");

        lbDiachi.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDiachi.setText("Địa chỉ:");

        tfHoten.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tfSDT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfSDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfSDTKeyReleased(evt);
            }
        });

        tfDiachi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        buttonGroup1.add(rbNam);
        rbNam.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rbNam.setText("Nam");

        buttonGroup1.add(rbNu);
        rbNu.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        rbNu.setText("Nữ");

        tfNgaysinh.setDateFormatString("yyyy-MM-dd");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tên LSD");

        tfMaKH.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfMaKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfMaKHKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Mã khách hàng");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Ngày BDSD");

        tfNgayBDSD.setDateFormatString("yyyy-MM-dd");

        tfCMT.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tfCMT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfCMTKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Chứng minh thư");

        cTenLSD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHoten, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDiachi, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgaysinh, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbSDT, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE)
                        .addComponent(lbGioitinh)
                        .addGap(12, 12, 12)
                        .addComponent(rbNu, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(rbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfSDT)
                            .addComponent(tfHoten)
                            .addComponent(tfDiachi)
                            .addComponent(tfNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(cTenLSD, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNgayBDSD, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfCMT, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbGioitinh)
                            .addComponent(rbNu)
                            .addComponent(rbNam)
                            .addComponent(tfMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbHoten)
                                    .addComponent(tfHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfCMT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(13, 13, 13)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNgayBDSD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbNgaysinh, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(5, 5, 5))))
                    .addComponent(tfNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbDiachi)
                    .addComponent(tfDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cTenLSD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/user (1).png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/user(2).png"))); // NOI18N
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnDel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/user.png"))); // NOI18N
        btnDel.setEnabled(false);
        btnDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDelActionPerformed(evt);
            }
        });

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

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/smart-home.png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnFind.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFind.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Photos/search (1).png"))); // NOI18N
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnDel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSave, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );

        lbTrangthai.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbTrangthai.setForeground(new java.awt.Color(0, 204, 0));
        lbTrangthai.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTrangthai.setText("Trạng Thái");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(306, 306, 306)
                .addComponent(lbQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 985, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 436, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lbQLNV, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        reset();
        add = true;
        Enabled();
        ((JTextField) tfNgayBDSD.getDateEditor().getUiComponent()).setText(getDateNow());
        //set mã khách hàng về dạng 
        tfMaKH.setEnabled(false);
        cTenLSD.setSelectedItem(null);
        tfNgayBDSD.setEnabled(false);
        btnAdd.setEnabled(false);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        add = false;
        change = true;
        Enabled();
        tfNgayBDSD.setEnabled(false);
        btnAdd.setEnabled(false);
        btnDel.setEnabled(false);
        btnEdit.setEnabled(false);
        btnSave.setEnabled(true);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDelActionPerformed
        int click = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này hay không?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
        if (click == JOptionPane.OK_OPTION) {
            try {
                khController.Delete(Integer.parseInt(tfMaKH.getText()));
                reset();
                loadData();
                Disabled();
                lbTrangthai.setText("Xóa khách hàng thành công!");
            } catch (Exception e) {
                lbTrangthai.setText("Xóa khách hàng khong thành công!");
            }

        } else {
            reset();
        }
    }//GEN-LAST:event_btnDelActionPerformed

    private void tableNVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableNVMouseClicked
        int click = tableNV.getSelectedRow();
        TableModel model = tableNV.getModel();
        tfMaKH.setText(model.getValueAt(click, 0).toString());
        tfHoten.setText(model.getValueAt(click, 1).toString());
        tfCMT.setText(model.getValueAt(click, 2).toString());
        ((JTextField) tfNgaysinh.getDateEditor().getUiComponent()).setText(model.getValueAt(click, 3).toString());
        tfDiachi.setText(model.getValueAt(click, 4).toString());
        checkGT(model.getValueAt(click, 5).toString());
        tfSDT.setText(model.getValueAt(click, 6).toString());
        ((JTextField) tfNgayBDSD.getDateEditor().getUiComponent()).setText(model.getValueAt(click, 7).toString());
        cTenLSD.setSelectedItem(model.getValueAt(click, 8).toString());

        btnEdit.setEnabled(true);
        btnDel.setEnabled(true);

    }//GEN-LAST:event_tableNVMouseClicked

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        MainFr home = new MainFr(nv);
        dispose();
        this.setVisible(false);
        home.setVisible(true);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (add == true) {
            addNV();
        } else {
            if (change != false) {
                changeNV();
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        reset();
        Disabled();
        loadData();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        if (!khController.getKhachHang(Integer.parseInt(tfMaKH.getText())).isEmpty()) {
            Disabled();
            tableNV.setModel(new KhachHangTable(khController.getKhachHang(Integer.parseInt(tfMaKH.getText()))));
            btnCancel.setEnabled(true);
        }

    }//GEN-LAST:event_btnFindActionPerformed

    private void tfSDTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfSDTKeyReleased
        tfSDT.setText(cutChar(tfSDT.getText()));

        if (tfSDT.getText().length() == 10) {
            btnSave.setEnabled(true);
            lbTrangthai.setText("Số điện thoại đã hợp lệ!!");
        } else {
            btnSave.setEnabled(false);
            lbTrangthai.setText("Số điện thoại không được khác 10 chữ số");
        }
    }//GEN-LAST:event_tfSDTKeyReleased

    private void tfCMTKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfCMTKeyReleased
        tfCMT.setText(cutChar(tfCMT.getText()));

        if (tfCMT.getText().length() == 12) {
            btnSave.setEnabled(true);
            lbTrangthai.setText("Số chứng minh thư đã hợp lệ!!");
        } else {
            btnSave.setEnabled(false);
            lbTrangthai.setText("Số chứng minh thư không được khác 12 số!!");
        }
    }//GEN-LAST:event_tfCMTKeyReleased

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

    private void tfMaKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfMaKHKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfMaKHKeyReleased

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
            java.util.logging.Logger.getLogger(qlkhFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(qlkhFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(qlkhFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(qlkhFr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NhanVien nv = new NhanVien();
                new qlkhFr(nv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnDel;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFind;
    private javax.swing.JButton btnSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cTenLSD;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItemDangXuat;
    private javax.swing.JMenuItem jMenuItemThongTinAdmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenuTaiKhoan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbDiachi;
    private javax.swing.JLabel lbGioitinh;
    private javax.swing.JLabel lbHoten;
    private javax.swing.JLabel lbNgaysinh;
    private javax.swing.JLabel lbQLNV;
    private javax.swing.JLabel lbSDT;
    private javax.swing.JLabel lbTrangthai;
    private javax.swing.JRadioButton rbNam;
    private javax.swing.JRadioButton rbNu;
    private javax.swing.JTable tableNV;
    private javax.swing.JTextField tfCMT;
    private javax.swing.JTextField tfDiachi;
    private javax.swing.JTextField tfHoten;
    private javax.swing.JTextField tfMaKH;
    private com.toedter.calendar.JDateChooser tfNgayBDSD;
    private com.toedter.calendar.JDateChooser tfNgaysinh;
    private javax.swing.JTextField tfSDT;
    // End of variables declaration//GEN-END:variables

}
