package javaproject_original;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.html.CSS;

import org.json.simple.*;
import sun.java2d.loops.CustomComponent;
import sun.swing.table.DefaultTableCellHeaderRenderer;

public class DanhSachItems extends javax.swing.JFrame implements TableModelListener{

    String userName;
    DefaultTableModel table;
    String[] header = {"Thu 2","Thu 3","Thu 4","Thu 5","Thu 6","Thu 7","Chu Nhat"};
    Object[] data = new Object[7];
    
    DanhSachItems_Model items_Model;
    List<DanhSachItems_Model> dsItems;
    Map<String, DanhSachItems_Model> mapItemsModel;
    
    
    
    public DanhSachItems() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        
    }
    
    public void KhoiTaoAll(){
        
        table = new DefaultTableModel();
        table.setColumnIdentifiers(header);
        
        
        mapItemsModel = new HashMap<String, DanhSachItems_Model>();
        
       
        
        String fileName = userName + ".json";
        
        
        
        
        try {
            File file = new File(fileName);
            if (file.exists()) {
//                JOptionPane.showMessageDialog(null, "File Exists");
            }
            else {
                returnEmptyJsonFile(fileName);
            }
            
            
            
            
//            returnEmptyJsonFile(fileName);
        } catch (Exception ex) {
            Logger.getLogger(DanhSachItems.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
//        returnEmptyJsonFile(fileName);
        
        
        mapItemsModel = Json.readJsonSimpleDemon(fileName);
        
        
        
       
//        returnEmptyJsonFile();
       
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                
                String id = String.valueOf(i) + String.valueOf(j);
                
                
                
                data[j] = mapItemsModel.get(id).getContent();
                
                
                
//                 Khoi tao Rong
//                items_Model = new DanhSachItems_Model();
//                items_Model.setContent("");
//                mapItemsModel.put(id, items_Model);
            }
            
//            try {
//                Json.writeJsonSimpleDemon(mapItemsModel);
//            } catch (IOException ex) {
//                Logger.getLogger(DanhSachItems.class.getName()).log(Level.SEVERE, null, ex);
//            }
           
            
            table.addRow(data);
        }
        jTable1.setModel(table);
        jTable1.getModel().addTableModelListener(this);
        
        dsItems = new ArrayList<DanhSachItems_Model>();
        
    }
    
    public void returnEmptyJsonFile(String fileName){
        
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 7; j++) {
                String id = String.valueOf(i) + String.valueOf(j);
                
                items_Model = new DanhSachItems_Model();
                items_Model.setContent("");
                mapItemsModel.put(id, items_Model);
            }
            
            try {
                Json.writeJsonSimpleDemon(fileName, mapItemsModel);
            } catch (IOException ex) {
                Logger.getLogger(DanhSachItems.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
//        jTable1.setModel(table);
//        jTable1.getModel().addTableModelListener(this);
        
    }
    
    public void getUserName(){
        txtWelcom.setText(userName);
        userName = txtWelcom.getText().substring(7);
//        JOptionPane.showMessageDialog(null, "User Name: " + userName);
    }
    
    
    
    public void tableChanged(TableModelEvent e){
    	
    	
        
    	
        int row = e.getFirstRow();
        int colum = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        
        String columName = model.getColumnName(colum);
        Object dataObject = model.getValueAt(row, colum);
        
        items_Model = new DanhSachItems_Model(row, colum, dataObject);
        
        boolean check = model.isCellEditable(row, colum);
       
        
        
        String id = String.valueOf(row) + String.valueOf(colum);
        
        
        if (mapItemsModel.containsKey(id)) {
            if (check) {
            mapItemsModel.get(id).setContent(dataObject);
            mapItemsModel.get(id).setId(id);
            
                
        }
        }
        else {
           
            mapItemsModel.get(id).setId(id);
        }
        
       // CHua Xong
       jTable1.setAutoResizeMode(jTable1.AUTO_RESIZE_LAST_COLUMN);
                
                
//        for (String key : mapItemsModel.keySet()) {
//            System.out.println("Key: " + key + " value: " + mapItemsModel.get(key).getContent());
//            
//        }
        
        
                
        
        try {
            Json.writeJsonSimpleDemon(userName+ ".json",mapItemsModel);
        } catch (IOException ex) {
            Logger.getLogger(DanhSachItems.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        JOptionPane.showMessageDialog(null, "You input: " + dataObject.toString() + " At " + row + ", colum: " + colum);
        
    }
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtWelcom = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "2", "3", "4", "5", "6", "7", "Chu Nhat"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                jTable1InputMethodTextChanged(evt);
            }
        });
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnBack.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnBack.setText("<<");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 153, 0));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 102, 102));

        txtWelcom.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtWelcom.setForeground(java.awt.Color.orange);
        txtWelcom.setText("THOI KHOA BIEU");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(txtWelcom)
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtWelcom)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(java.awt.Color.gray);
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        jPanel3.setBackground(java.awt.Color.gray);
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        jPanel4.setBackground(java.awt.Color.gray);
        jPanel4.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(java.awt.Color.gray);
        jPanel5.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 61, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(201, 201, 201)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(227, 227, 227))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(163, 163, 163)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       
       
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1InputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jTable1InputMethodTextChanged
       
         
        
        
    }//GEN-LAST:event_jTable1InputMethodTextChanged

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        
        
        
        
       
    }//GEN-LAST:event_jTable1KeyReleased

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       
                this.dispose();
                
                mainInterface main = new mainInterface();
                main.userName = txtWelcom.getText();
                main.newHome();
                
                main.show();
        
    }//GEN-LAST:event_btnBackActionPerformed

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
            java.util.logging.Logger.getLogger(DanhSachItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DanhSachItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DanhSachItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DanhSachItems.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DanhSachItems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel txtWelcom;
    // End of variables declaration//GEN-END:variables
}
