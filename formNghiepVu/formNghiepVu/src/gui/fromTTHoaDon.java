/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.SachDAO;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author TUAN KIET
 */
public class fromTTHoaDon extends javax.swing.JFrame {

    /**
     * Creates new form fromTTHoaDon
     */
    Vector data = new Vector();
    Vector<String> header = new Vector();
    
    boolean addNew = false;
    boolean changed = false;
   
    DefaultTableModel model;
    
    
    public static fromTTHoaDon Instance;
    
    public fromTTHoaDon() {
       
        initComponents();
         this.setLocationRelativeTo(null);
        this.setTitle("Thông Tin Hóa Đơn");
        Instance = this;
        
        model = (DefaultTableModel) this.tbListSach_TTHD.getModel();

        header.add("Mã Sách");
        header.add("Tên Sách");
        header.add("Số Lượng");
        header.add("Đơn Giá");
        header.add("Tổng Tiền ");
        
        model.setDataVector(null, header);
        
        this.txtDonGia.setEditable(false);
        this.txtThanhTien.setEditable(false);
        this.txtGiamGia.setEditable(false);
        this.txtThanhTien.setEditable(false);
        
//        calculate_total_discount();
    }

    public boolean confirmValueInput() {
        if (!this.txtMaSach.getText().matches("-?\\d+") || this.txtMaSach.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Mã Sách Không Hợp Lệ", "Error", JOptionPane.OK_CANCEL_OPTION);
            return false;
        } 
        if (this.txtTenSach.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Tên Sách Không Hợp Lệ", "Error", JOptionPane.OK_CANCEL_OPTION);
            return false;
        }
        if (!this.txtSoLuong.getText().matches("-?\\d+") || this.txtSoLuong.getText().isEmpty()) {
            JOptionPane.showConfirmDialog(this, "Số Lượng Sách Không Hợp Lệ", "Error", JOptionPane.OK_CANCEL_OPTION);
            return false;
        }
        return true;
    }
    
    
    public boolean checkValidInput() {
        if(confirmValueInput()) {
            ArrayList bookByID = SachDAO.getBookById(Integer.parseInt(this.txtMaSach.getText()));
            ArrayList bookByName = SachDAO.getBookByName(this.txtTenSach.getText());
            
            // User must buy more than one books
            int ammountBookValid = Integer.parseInt(this.txtSoLuong.getText());
            if(!bookByID.isEmpty() && !bookByName.isEmpty() && ammountBookValid >= 1) 
                return true;
            return false;
        }
        return false;
    }
    
    public void loadData() {
       
      
        Vector vec = new Vector();
        vec.add(this.txtMaSach.getText());
        vec.add(this.txtTenSach.getText());
        vec.add(this.txtSoLuong.getText());
        vec.add(this.txtDonGia.getText());
        vec.add(tongTienSach(Integer.parseInt(this.txtSoLuong.getText()), Integer.parseInt(this.txtDonGia.getText())));
        
        data.add(vec);
        
       
        model.setDataVector(data, header);
        this.tbListSach_TTHD.updateUI();
    }
    
    public int tongTienSach(int amount, int price) {
        return amount * price;
    }
    
    //  If there are 5 or more items, apply an additional discount of 100,000.
    public double calculate_total_discount() {
        
        Vector checkCondition = new Vector();
        int cnt = 0;
        
        double additionalDiscount = 0;
        for (int i = 0; i < this.tbListSach_TTHD.getRowCount(); i++) {
            String idBook = String.valueOf(this.tbListSach_TTHD.getValueAt(i, 0));
            if (!checkCondition.contains(idBook)) {
                checkCondition.add(idBook);
                cnt += 1;
            }
        }
        if (cnt >= 5) {         // Buy 5 different books for 100,000 discount
            additionalDiscount = (cnt / 5) * 100000;
        }
        
        return additionalDiscount;
        // 
    }
    
    public double totalBookPrice() {
        double priceBook = 0;
        for (int i = 0; i < this.tbListSach_TTHD.getRowCount(); i++) { 
            // Get price of all book
            priceBook += Integer.parseInt( String.valueOf(this.tbListSach_TTHD.getValueAt(i, 4))); 
        }
        return priceBook;
    }
    
    public double calculate_total_after_discount() {
        return totalBookPrice() - calculate_total_discount();
        
    }
    
    public void calculateBill() {
        this.txtGiamGia.setText( String.valueOf(calculate_total_discount()));
        this.txtThanhTien.setText(String.valueOf(totalBookPrice()));
        this.txtTongTien.setText(String.valueOf(calculate_total_after_discount()));
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelMaSach = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTenSach = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbListSach_TTHD = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtThanhTien = new javax.swing.JTextField();
        txtGiamGia = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnThem1 = new javax.swing.JButton();
        btnThem2 = new javax.swing.JButton();
        bntChooseMulti = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "THONG TIN HOA DON\n", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 24), new java.awt.Color(0, 153, 153))); // NOI18N

        labelMaSach.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelMaSach.setText("Mã Sách:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Tên Sách:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Số Lượng:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Đơn Giá:");

        tbListSach_TTHD.setModel(new javax.swing.table.DefaultTableModel(
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
        tbListSach_TTHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbListSach_TTHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbListSach_TTHD);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Thành Tiền:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Giảm Giá:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Tổng Tiền:");

        btnSua.setBackground(new java.awt.Color(102, 102, 102));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(102, 0, 0));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnThem1.setBackground(new java.awt.Color(255, 51, 51));
        btnThem1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem1.setForeground(new java.awt.Color(255, 255, 255));
        btnThem1.setText("Hủy");
        btnThem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem1ActionPerformed(evt);
            }
        });

        btnThem2.setBackground(new java.awt.Color(0, 51, 51));
        btnThem2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem2.setForeground(new java.awt.Color(255, 255, 255));
        btnThem2.setText("Xác Nhận");
        btnThem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem2ActionPerformed(evt);
            }
        });

        bntChooseMulti.setBackground(new java.awt.Color(204, 204, 204));
        bntChooseMulti.setText("...");
        bntChooseMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntChooseMultiActionPerformed(evt);
            }
        });

        btnThem.setBackground(new java.awt.Color(0, 153, 153));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(labelMaSach)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                        .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                                            .addComponent(txtTenSach)
                                            .addComponent(txtSoLuong))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bntChooseMulti))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem2)))
                .addGap(76, 76, 76))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMaSach)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntChooseMulti))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(154, 154, 154))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnThem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem2ActionPerformed
        // TODO add your handling code here:
        
        // Luu Chi Tiet Don Hang Vao Database 
        int MaDonHang;
        int MaSach;
        int SoLuong;
        int DonGia;
        int insertDetailBillintoDB;
        boolean isvalid = true;
        if(formDonHang.Instance.txtMaHD.getText().matches("-?\\d+")) {
            for (int i = 0; i < this.tbListSach_TTHD.getRowCount(); i++) {
                    MaDonHang = Integer.parseInt(formDonHang.Instance.txtMaHD.getText());
                    MaSach = Integer.parseInt(String.valueOf(this.tbListSach_TTHD.getValueAt(i, 0)));
                    SoLuong = Integer.parseInt(String.valueOf(this.tbListSach_TTHD.getValueAt(i, 2)));
                    DonGia = Integer.parseInt(String.valueOf(this.tbListSach_TTHD.getValueAt(i, 3)));
                    insertDetailBillintoDB = SachDAO.addChiTietHoaDon(MaDonHang, MaSach, SoLuong, DonGia);
                    if (insertDetailBillintoDB < 1) {
                        JOptionPane.showMessageDialog(this, "Cap Nhat That Bai", "Error", JOptionPane.OK_OPTION);
                        isvalid = false; break;
                    }
            }
            if(isvalid) {
                JOptionPane.showMessageDialog(this, "Cap Nhat Thanh Cong", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } else 
                JOptionPane.showMessageDialog(this, "Lỗi Mã Hóa Đơn", "Error", JOptionPane.OK_CANCEL_OPTION);
        
        
        
        
        // Luu Hoa Don Vao Database
        // code continue;
        
    }//GEN-LAST:event_btnThem2ActionPerformed

    private void btnThem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnThem1ActionPerformed

    private void bntChooseMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntChooseMultiActionPerformed
        // TODO add your handling code here:
//        this.toBack();
//        this.setEnabled(false);
//        DanhSachSanPham dssp = new DanhSachSanPham();
//        dssp.setVisible(true);
//        dssp.toFront();
//        this.setEnabled(true);
        new DanhSachSanPham().setVisible(true);
        
    }//GEN-LAST:event_bntChooseMultiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        if(checkValidInput()) {
            loadData();
        } else {
            JOptionPane.showConfirmDialog(this, "Sách Không Tồn Tại", "Not Exist", JOptionPane.OK_CANCEL_OPTION);
        }
        calculateBill();
    }//GEN-LAST:event_btnThemActionPerformed
   
    
    private void tbListSach_TTHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbListSach_TTHDMouseClicked
        // TODO add your handling code here:
        int row = this.tbListSach_TTHD.getSelectedRow();
        this.txtMaSach.setText(String.valueOf(this.tbListSach_TTHD.getValueAt(row, 0)));
        this.txtTenSach.setText(String.valueOf(this.tbListSach_TTHD.getValueAt(row, 1)));
        
        this.txtSoLuong.setEditable(true);
        this.txtSoLuong.setText(String.valueOf(this.tbListSach_TTHD.getValueAt(row, 2)));
        
        this.txtDonGia.setText(String.valueOf(this.tbListSach_TTHD.getValueAt(row, 3)));
    }//GEN-LAST:event_tbListSach_TTHDMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        int row = this.tbListSach_TTHD.getSelectedRow();
        model.removeRow(row);
        this.tbListSach_TTHD.updateUI();
        calculateBill();
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        int row = this.tbListSach_TTHD.getSelectedRow();
        Vector v = (Vector)data.get(row);
        v.set(2, this.txtSoLuong.getText());
        tbListSach_TTHD.updateUI();
    }//GEN-LAST:event_btnSuaActionPerformed

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
            java.util.logging.Logger.getLogger(fromTTHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fromTTHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fromTTHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fromTTHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fromTTHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntChooseMulti;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem1;
    private javax.swing.JButton btnThem2;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel labelMaSach;
    public javax.swing.JTable tbListSach_TTHD;
    public javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtGiamGia;
    public javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtSoLuong;
    public javax.swing.JTextField txtTenSach;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
