/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnpm;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BUS Vu
 */
public class NGUYENLIEU extends javax.swing.JFrame {

    BUS.DSNGUYENLIEU ds = new BUS.DSNGUYENLIEU();
    ArrayList<BUS.NGUYENLIEU> list = this.ds.getList();
    DefaultTableModel model;
    
    private int n = 0;
    
    public NGUYENLIEU()
    {
        initComponents();
        this.addDATABASE(this.list);
    }
    
    private void addDATABASE(ArrayList<BUS.NGUYENLIEU> a)
    {
        Object rowData[] = new Object[6];
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        for (int i = 0; i < a.size(); i++)
        {
            rowData[0] = i + 1;
            rowData[1] = a.get(i).getID();
            rowData[2] = a.get(i).getName();
            rowData[3] = a.get(i).getGia();
            rowData[4] = a.get(i).getDonvi();
            BUS.DSNCC ncc = new BUS.DSNCC();
            for (int j = 0; j < ncc.getList().size(); j++)
            {
                if (a.get(i).getIdNCC() == ncc.getList().get(j).getID())
                {
                    rowData[5] = ncc.getList().get(j).getName();
                    break;
                }
            }
            this.model.addRow(rowData);
            this.n++;
        }
    }
    
    private void deleteTable()
    {
        int rowCount = this.model.getRowCount();
        for(int i = rowCount; i > 0; i--)
        {
            this.model.removeRow(i-1);
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        add_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        search_txt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên nguyên liệu", "Giá", "Đơn vị tính", "Nhà cung cấp"
            }
        ));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(204, 204, 255));
        jScrollPane3.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(1).setMinWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(50);
            table.getColumnModel().getColumn(3).setMinWidth(100);
            table.getColumnModel().getColumn(3).setMaxWidth(100);
            table.getColumnModel().getColumn(4).setMinWidth(100);
            table.getColumnModel().getColumn(4).setMaxWidth(100);
        }

        add_btn.setForeground(new java.awt.Color(0, 27, 72));
        add_btn.setText("Thêm nguyên liệu");
        add_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 27, 72)));
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        update_btn.setForeground(new java.awt.Color(0, 27, 72));
        update_btn.setText("Sửa thông tin");
        update_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 27, 72)));
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn.setForeground(new java.awt.Color(0, 27, 72));
        delete_btn.setText("Xóa nguyên liệu");
        delete_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 27, 72)));
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 72));
        jLabel4.setText("NGUYÊN LIỆU");

        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        jLabel1.setText("Tìm nguyên liệu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 775, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(search_txt)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4)
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        NGUYENLIEU_ADD dlg = new NGUYENLIEU_ADD(this, true);
        dlg.setVisible(true);
        if (dlg.getName().equals("") || dlg.getDonvi().equals("") || dlg.checkgia() == false)
        {
            JOptionPane.showMessageDialog(this, "Không được để trống các thành phần trong hộp thoại");
        }
        else
        {
            Object rowData[] = new Object[6];
            this.ds.add(dlg.getName(), dlg.getIDNCC(), dlg.getGia(), dlg.getDonvi());
            rowData[0] = n + 1;
            rowData[1] = this.list.get(n).getID();
            rowData[2] = this.list.get(n).getName();
            rowData[3] = this.list.get(n).getGia();
            rowData[4] = this.list.get(n).getDonvi();
            BUS.DSNCC ncc = new BUS.DSNCC();
            for (int j = 0; j < ncc.getList().size(); j++)
            {
                if (this.list.get(n).getIdNCC() == ncc.getList().get(j).getID())
                {
                    rowData[5] = ncc.getList().get(j).getName();
                    break;
                }
            }
            this.model.addRow(rowData);
            this.n++;
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        try
        {
            this.model = (DefaultTableModel) table.getModel();
            int row = this.table.getSelectedRow();
            int id = (int) this.model.getValueAt(row, 1);
            if (this.ds.delete(id) == true)
            {
                this.ds.delete(id);
                this.model.removeRow(row);
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Còn một số bản Chi tiết phiếu chi thuộc nguyên liệu này");
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Chọn nguyên liệu để xóa");
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        try
        {
            NGUYENLIEU_UPDATE dlg = new NGUYENLIEU_UPDATE(this, true);
            dlg.setName(this.getName());
            dlg.setGia(this.getGia());
            dlg.setDonvi(this.getDonvi());
            dlg.setNCC(this.getIDNCC());
            dlg.setVisible(true);
            if (dlg.getName().equals("") || dlg.checkgia() == false || dlg.getDonvi().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Không được để trống các thành phần trong hộp thoại");
            }
            else
            {
                this.ds.update(this.getID(), dlg.getName(), dlg.getIDNCC(), dlg.getGia(), dlg.getDonvi());
                this.setName(dlg.getName());
                this.setGia(dlg.getGia());
                this.setDonvi(dlg.getDonvi());
                this.setIDNCC(dlg.getIDNCC());
            }
            
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Chọn nguyên liệu trước khi sửa");
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        ArrayList<BUS.NGUYENLIEU> a = this.ds.search(this.search_txt.getText());
        this.deleteTable();
        this.addDATABASE(a);
    }//GEN-LAST:event_search_txtKeyReleased

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTable table;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables

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
            java.util.logging.Logger.getLogger(NGUYENLIEU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NGUYENLIEU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NGUYENLIEU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NGUYENLIEU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NGUYENLIEU().setVisible(true);
            }
        });
    }

    public int getID()
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        return (int) this.model.getValueAt(row, 1);
    }
    
    public String getName()
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        return (String) this.model.getValueAt(row, 2);
    }
    
    public int getGia()
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        return (int) this.model.getValueAt(row, 3);
    }
    
    public String getDonvi()
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        return (String) this.model.getValueAt(row, 4);
    }
    
    public int getIDNCC()
    {
        int row = this.table.getSelectedRow();
        return this.list.get(row).getIdNCC();
    }
    
    public void setName(String name)
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        this.model.setValueAt((String) name, row, 2);
    }
    
    public void setGia(int gia)
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        this.model.setValueAt((int) gia, row, 3);
    }
    
    public void setDonvi(String donvi)
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        this.model.setValueAt((String) donvi, row, 4);
    }
    
    public void setIDNCC(int id)
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        BUS.DSNCC ncc = new BUS.DSNCC();
        for (int i = 0; i < ncc.getList().size(); i++)
        {
            if (ncc.getList().get(i).getID() == id)
            {
                this.model.setValueAt((String) ncc.getList().get(i).getName(), row, 5);
            }
        }
        
    }
}
