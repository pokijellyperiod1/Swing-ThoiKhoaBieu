package javaproject_original;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.Statement;
import  java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.SpinnerModel;
import javax.swing.table.DefaultTableModel;

public class mainInterface extends javax.swing.JFrame{

    String userName;
    List<String> listTenLoaiChiTieu;
    
    Connection connection;
    String dbName;
    Statement statement;
    ResultSet rs;
    int rs_Update;
    String query;
    PreparedStatement ps;
    
    String[] header = {"Ten Chi Tieu", "So Tien", "Chi Tiet"};
    Object[] data = new Object[4];
    DefaultTableModel table;

    
    
    public mainInterface() {
        
        initComponents();
        txtSoTien.setVisible(false);
        
        addTenLoaiChiTieu();
        
        
        Connection connection;
        Statement statement;
        ResultSet rs;
        
        spinnerSoLuong.setValue(1);
        
        data = new Object[4];
        
        
        table = new DefaultTableModel();
        table.setColumnIdentifiers(header);
        jTable1.setModel(table);
        
    }
    
    List<Button> listButton = new ArrayList<>();
    public void setTableChiTieu(){
        
        data = new Object[4];
        table = new DefaultTableModel();
        table.setColumnIdentifiers(header);
        jTable1.setModel(table);
        int idUser = getID_From_MySQL();
        
        
        dbName = "login_form";
        query="SELECT * FROM chitieu where idUser = " + idUser;
        connection = MyConnection.getConnection(dbName);
        int sum = 0;
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                data[0] = rs.getString("tenDanhMuc");
                data[1] = rs.getString("soTien");
                data[2] = rs.getString("chiTiet");
                
                table.addRow(data);
                jTable1.setModel(table);
                
                
                
              sum += Integer.parseInt(rs.getString("soTien"));
                
            }
            Object[] test = new Object[3];
            test[0] = "";
            test[1] = "";
            table.addRow(test);
            
            test[0] = "Sum";
            test[1] = sum;
            table.addRow(test);
            jTable1.setModel(table);
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public int getID_From_MySQL(){
        
        String query_Select_ID = "SELECT idUser as a FROM login_form.users where username ='" + userName + "'";
        
        
        dbName = "login_form";
        
        query="SELECT TaiKhoan as a FROM login_form.users where username ='" + userName + "'";
        connection = MyConnection.getConnection(dbName);
        
        int id = 1;
        try {
            ps = connection.prepareStatement(query_Select_ID);
            rs = ps.executeQuery();
            while (rs.next()) {                
                id = rs.getInt(1);
            }
//            JOptionPane.showMessageDialog(null, "ID: " + id);
            
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return id;
        
    }
    
    
    
    public void addTenLoaiChiTieu(){
        listTenLoaiChiTieu = new ArrayList<String>();
        comboDanhMuc.removeAllItems();
        dbName = "login_form";
        query="SELECT * FROM tenloaidanhmuc";
        connection = MyConnection.getConnection(dbName);
        
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            
            while (rs.next()) {                
                listTenLoaiChiTieu.add(rs.getString("tenDanhMuc"));
                
            }
            
            for (String loaiChiTieu : listTenLoaiChiTieu) {
                    
                    comboDanhMuc.addItem(loaiChiTieu);
                    comboTenLoaiChiTieu.addItem(loaiChiTieu);
                }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    public void newHome(){
        if (userName.startsWith("Welcom")) {
            txtWelcomPage.setText(userName);
        }else 
        
        txtWelcomPage.setText("Welcom " + userName);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jMenu13 = new javax.swing.JMenu();
        jMenu14 = new javax.swing.JMenu();
        jMenu15 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenu16 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu19 = new javax.swing.JMenu();
        jMenu20 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        comboDanhMuc = new javax.swing.JComboBox();
        btnThemMon = new javax.swing.JButton();
        spinnerSoLuong = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtChiTiet = new javax.swing.JTextArea();
        txtSoTien = new javax.swing.JTextField();
        btnSoTien = new javax.swing.JButton();
        comboSoTien = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtTenDanhMuc = new javax.swing.JTextField();
        btnThemDanhMuc = new javax.swing.JButton();
        btnTaiKhoan = new javax.swing.JButton();
        btnThongKe = new javax.swing.JButton();
        btnThemMoney = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        comboTenLoaiChiTieu = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtWelcomPage = new javax.swing.JLabel();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu22 = new javax.swing.JMenu();
        menuThoiKhoaBieu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenu2.setText("jMenu2");

        jMenu3.setText("jMenu3");

        jMenu4.setText("jMenu4");

        jMenu5.setText("jMenu5");

        jMenu6.setText("jMenu6");

        jMenu7.setText("jMenu7");

        jMenu8.setText("jMenu8");

        jMenu9.setText("jMenu9");

        jMenu10.setText("jMenu10");

        jMenu11.setText("jMenu11");

        jMenu12.setText("jMenu12");

        jMenu13.setText("jMenu13");

        jMenu14.setText("jMenu14");

        jMenu15.setText("jMenu15");

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jMenu16.setText("jMenu16");

        jMenu19.setText("File");
        jMenuBar2.add(jMenu19);

        jMenu20.setText("Edit");
        jMenuBar2.add(jMenu20);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboDanhMuc.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Danh Mục", " " }));

        btnThemMon.setText("Thêm");
        btnThemMon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMonActionPerformed(evt);
            }
        });

        txtChiTiet.setColumns(20);
        txtChiTiet.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        txtChiTiet.setRows(5);
        txtChiTiet.setText("Chi Tiet");
        jScrollPane1.setViewportView(txtChiTiet);

        btnSoTien.setText("+");
        btnSoTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSoTienActionPerformed(evt);
            }
        });

        comboSoTien.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "25", "30" }));

        jLabel1.setText("Số Tiền");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(29, 29, 29)
                .addComponent(comboSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnSoTien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(comboDanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(btnThemMon)
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThemMon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSoTien)
                    .addComponent(comboSoTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        jLabel2.setText("Ten Danh Muc");

        btnThemDanhMuc.setText("Thêm Danh Mục");
        btnThemDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDanhMucActionPerformed(evt);
            }
        });

        btnTaiKhoan.setText("Tài Khoản");
        btnTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaiKhoanActionPerformed(evt);
            }
        });

        btnThongKe.setText("Thống Kê");
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThongKeMouseClicked(evt);
            }
        });
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnThemMoney.setText("Thêm Money");
        btnThemMoney.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoneyActionPerformed(evt);
            }
        });

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        comboTenLoaiChiTieu.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ten loai chi tieu" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThemDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThongKe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboTenLoaiChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemDanhMuc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboTenLoaiChiTieu, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addComponent(btnThemMoney, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jPanel5.setBackground(new java.awt.Color(189, 118, 14));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtWelcomPage.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtWelcomPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtWelcomPage.setText("CHI TIÊU");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtWelcomPage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtWelcomPage, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu22.setText("Menu");

        menuThoiKhoaBieu.setText("Dang Xuat");
        menuThoiKhoaBieu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuThoiKhoaBieuActionPerformed(evt);
            }
        });
        jMenu22.add(menuThoiKhoaBieu);

        jMenuItem1.setText("Thoi Khoa Bieu");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu22.add(jMenuItem1);

        jMenuBar3.add(jMenu22);

        setJMenuBar(jMenuBar3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuThoiKhoaBieuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuThoiKhoaBieuActionPerformed
        
        this.dispose();
        Login user = new Login();
        user.show();
        
    }//GEN-LAST:event_menuThoiKhoaBieuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.dispose();
       
        
        DanhSachItems dsItems = new DanhSachItems();
                
        dsItems.userName = txtWelcomPage.getText();
        dsItems.getUserName();
        dsItems.KhoiTaoAll();

        dsItems.show();
        
        JOptionPane.showMessageDialog(null, "Welcom to Thoi Khoa Bieu");
        
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnSoTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSoTienActionPerformed
        if (btnSoTien.getText().equals("+")) {
            txtSoTien.setVisible(true);
            comboSoTien.setVisible(false);
            btnSoTien.setText("-");
        }
        else {
            txtSoTien.setVisible(false);
            comboSoTien.setVisible(true);
            btnSoTien.setText("+");
        }
    }//GEN-LAST:event_btnSoTienActionPerformed

    
    public double getTaiKhoan_FromMySQL(){
        
        int idUser = getID_From_MySQL();
        
        dbName = "login_form";
        
        query="SELECT TaiKhoan as a FROM login_form.users where username ='" + userName + "'";
        connection = MyConnection.getConnection(dbName);
        
        
        double taiKhoan = 0;
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
        
            
            while (rs.next()) {            
                taiKhoan = rs.getInt(1);
        }
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
//        JOptionPane.showMessageDialog(null, "Tai Khoan: " + taiKhoan);
        
        return taiKhoan;
    }
    
    
    private void btnThemMonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMonActionPerformed
       
        int id = 1;
        String tenDanhMuc  = comboDanhMuc.getSelectedItem().toString();
        String soTien;
        String chiTiet = txtChiTiet.getText();
        int idUser = getID_From_MySQL();
        
        double soDu = getTaiKhoan_FromMySQL();
        
        dbName = "login_form";
        connection = MyConnection.getConnection(dbName);
        query = "INSERT INTO chitieu(id, tenDanhMuc, soTien, chiTiet, idUser) VALUES(?,?,?,?,?)";
        String querySelect = "SELECT max(id) as a FROM login_form.chitieu";
        try {
            ps = connection.prepareStatement(querySelect);
            rs = ps.executeQuery();
            while (rs.next()) {                
                id = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
       
        if (txtSoTien.getText().isEmpty()) {
             soTien = comboSoTien.getSelectedItem().toString();
        }else {
            soTien = txtSoTien.getText();
        }
        
        
        
        
       
        
        try {
            ps = connection.prepareStatement(query);
            
            
            ps.setInt(1, id);
            ps.setString(2, tenDanhMuc);
            if ((int)spinnerSoLuong.getValue() <= 0) {
                JOptionPane.showMessageDialog(null, "So Luong Khong Hop Le");
                return ;
            }
            double tongTien = Integer.valueOf(soTien)* (int)spinnerSoLuong.getValue();
            ps.setDouble(3, tongTien);
            ps.setString(4, chiTiet);
            ps.setInt(5, idUser);
            
            JOptionPane.showMessageDialog(null, "Da Them");
            System.out.println(id);
            System.out.println(tenDanhMuc);
            System.out.println(tongTien);
            
            rs_Update = ps.executeUpdate();
            
            soDu -= tongTien;
//            UPDATE `login_form`.`users` SET `TaiKhoan` = '15' WHERE (`idUser` = '2');
            query = "UPDATE `login_form`.`users` SET `TaiKhoan` = " + String.valueOf(soDu) + " WHERE (`idUser` = " + idUser +")";
            ps = connection.prepareStatement(query);
            rs_Update = ps.executeUpdate();
            
            
            
        } catch (SQLException ex) {
            
//            JOptionPane.showMessageDialog(null, "Id Trung");
            ex.printStackTrace();
            
        }
        
        
    }//GEN-LAST:event_btnThemMonActionPerformed

    private void btnThemMoneyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoneyActionPerformed
        double soDu = getTaiKhoan_FromMySQL();
        int idUser = getID_From_MySQL();

        String m  = JOptionPane.showInputDialog("Nhap...");

        soDu += Double.valueOf(m);
        //            UPDATE `login_form`.`users` SET `TaiKhoan` = '15' WHERE (`idUser` = '2');
        query = "UPDATE `login_form`.`users` SET `TaiKhoan` = " + String.valueOf(soDu) + " WHERE (`idUser` = " + idUser +")";
        try {
            ps = connection.prepareStatement(query);
            rs_Update = ps.executeUpdate();
        } catch (SQLException ex) {
//            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        //
    }//GEN-LAST:event_btnThemMoneyActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed

        setTableChiTieu();

    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMouseClicked

        //        query="SELECT * FROM `users`";
        //
        //
        //        connection = MyConnection.getConnection("login_form");
        //
        //        String str ="";
        //
        //        try {
            //            ps = connection.prepareStatement(query);
            //            rs = ps.executeQuery();
            //
            //            while (rs.next()) {
                //
                //                txtSoTien.setText(rs.getString("id"));
                //                txtTenDanhMuc.setText(rs.getString("username"));
                ////                txtPassword.setText(rs.getString("password"));
                //
                //                str+= rs.getString("username");
                //                str+= " ";
                //                txtChiTiet.setText(str+"\n");
                //
                //            }
            //
            //
            //        } catch (SQLException ex) {
            //            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
            //        }

    }//GEN-LAST:event_btnThongKeMouseClicked

    private void btnTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaiKhoanActionPerformed

        double x = getTaiKhoan_FromMySQL();
        JOptionPane.showMessageDialog(null, "Tai Khoan cua ban la: " + x + "00 VND");

    }//GEN-LAST:event_btnTaiKhoanActionPerformed

    private void btnThemDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDanhMucActionPerformed

        dbName = "login_form";
        query="INSERT INTO tenloaidanhmuc(idDanhMuc, tenDanhMuc) VALUES(?,?)";
        connection = MyConnection.getConnection(dbName);

        int idDanhMuc =1;
        String tenDanhMuc = txtTenDanhMuc.getText() ;
        if (tenDanhMuc.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ten Danh Muc Rong!!");
            return ;
        }

        //Tim Id Lon Nhat
        String querySelect = "SELECT max(idDanhMuc) as a FROM login_form.tenloaidanhmuc";
        try {
            ps = connection.prepareStatement(querySelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                idDanhMuc = rs.getInt(1) + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, idDanhMuc);
            ps.setString(2, tenDanhMuc);
            rs_Update = ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Them Danh Muc Thanh Cong");

            comboDanhMuc.addItem(tenDanhMuc);
            comboTenLoaiChiTieu.addItem(tenDanhMuc);

        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnThemDanhMucActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed

        String[] header = {"Ten Chi Tieu", "So Tien", "Chi Tiet"};
        Object[] data = new Object[4];
        DefaultTableModel table;

        table = new DefaultTableModel();
        table.setColumnIdentifiers(header);
        jTable1.setModel(table);

        String tenDanhMuc = String.valueOf(comboTenLoaiChiTieu.getSelectedItem());
        dbName = "login_form";

        query = "SELECT * FROM login_form.chitieu where tenDanhMuc = '" + tenDanhMuc + "'";

        connection = MyConnection.getConnection(dbName);
        int sum = 0;

        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                data[0] = rs.getString("tenDanhMuc");
                data[1] = rs.getString("soTien");
                data[2] = rs.getString("chiTiet");

                table.addRow(data);
                jTable1.setModel(table);

                sum += Integer.parseInt(rs.getString("soTien"));

            }
            Object[] test = new Object[3];
            test[0] = "";
            test[1] = "";
            table.addRow(test);

            test[0] = "Sum";
            test[1] = sum;
            table.addRow(test);
            jTable1.setModel(table);

        } catch (SQLException ex) {
            Logger.getLogger(mainInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

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
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(mainInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new mainInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSoTien;
    private javax.swing.JButton btnTaiKhoan;
    private javax.swing.JButton btnThemDanhMuc;
    private javax.swing.JButton btnThemMon;
    private javax.swing.JButton btnThemMoney;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox comboDanhMuc;
    private javax.swing.JComboBox comboSoTien;
    private javax.swing.JComboBox comboTenLoaiChiTieu;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu13;
    private javax.swing.JMenu jMenu14;
    private javax.swing.JMenu jMenu15;
    private javax.swing.JMenu jMenu16;
    private javax.swing.JMenu jMenu19;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu20;
    private javax.swing.JMenu jMenu22;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JMenuItem menuThoiKhoaBieu;
    private javax.swing.JSpinner spinnerSoLuong;
    private javax.swing.JTextArea txtChiTiet;
    private javax.swing.JTextField txtSoTien;
    private javax.swing.JTextField txtTenDanhMuc;
    private javax.swing.JLabel txtWelcomPage;
    // End of variables declaration//GEN-END:variables

   
}
