package cnpm;

import javax.swing.table.DefaultTableModel;
import BUS.*;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author BUSVu
 */
public class NCC extends javax.swing.JFrame
{
    BUS.DSNCC ds = new BUS.DSNCC();
    ArrayList<BUS.NCC> list = this.ds.getList();
    DefaultTableModel model;
    
    private int n = 0;
    
    public NCC()
    {
        initComponents();
        this.addDATABASE(this.list);
    }
    
    private void addDATABASE(ArrayList<BUS.NCC> a)
    {
        Object rowData[] = new Object[4];
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        for (int i = 0; i < a.size(); i++)
        {
            rowData[0] = i + 1;
            rowData[1] = a.get(i).getID();
            rowData[2] = a.get(i).getName();
            rowData[3] = a.get(i).getSdt();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        search_txt = new javax.swing.JTextField();
        add_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        notice_lab = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 779, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 413, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Tên Nhà cung cấp", "Số điện thoại"
            }
        ));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(204, 204, 255));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(40);
            table.getColumnModel().getColumn(0).setMaxWidth(40);
            table.getColumnModel().getColumn(1).setMinWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(50);
            table.getColumnModel().getColumn(3).setMinWidth(200);
            table.getColumnModel().getColumn(3).setMaxWidth(200);
        }

        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        add_btn.setForeground(new java.awt.Color(0, 27, 72));
        add_btn.setText("Thêm nhà cung cấp");
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
        delete_btn.setText("Xóa nhà cung cấp");
        delete_btn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 27, 72)));
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 27, 72));
        jLabel2.setText("NHÀ CUNG CẤP");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel1.setText("tìm kiếm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(notice_lab, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(search_txt))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(notice_lab)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
                JOptionPane.showMessageDialog(this, "Còn một số nguyên liệu thuộc nhà cung cấp này");
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Chọn nhà cung cấp để xóa");
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        NCC_ADD dlg = new NCC_ADD(this, true);
        dlg.setVisible(true);dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        if (dlg.getName().equals("") || dlg.getSdt().equals(""))
        {
            JOptionPane.showMessageDialog(this, "Không được để trống các thành phần trong hộp thoại");
        }
        else
        {
            try
            {
                Double.parseDouble(dlg.getSdt());
                Object rowData[] = new Object[4];
                this.ds.add(dlg.getName(), dlg.getSdt());
                this.model = (DefaultTableModel) table.getModel();
                rowData[0] = n + 1;
                rowData[1] = this.list.get(n).getID();
                rowData[2] = this.list.get(n).getName();
                rowData[3] = this.list.get(n).getSdt();
                this.model.addRow(rowData);
                this.n++;
            }
            catch(Exception e) {JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");}
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        
    }//GEN-LAST:event_tableMouseClicked

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
        try
        {
            NCC_UPDATE dlg = new NCC_UPDATE(this, true);
            dlg.setName(this.getName());
            dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
            dlg.setSdt(this.getSdt());
            dlg.setVisible(true);
            if (dlg.getName().equals("") || dlg.getSdt().equals(""))
            {
                JOptionPane.showMessageDialog(this, "Không được để trống các thành phần trong hộp thoại");
            }
            else
            {
                try
                {
                    double k = Double.parseDouble(dlg.getSdt());
                    this.ds.update(this.getID(), dlg.getName(), dlg.getSdt());
                    this.setName(dlg.getName());
                    this.setSdt(dlg.getSdt());
                }
                catch (Exception e) {JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");}
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Chọn nhà cung cấp trước khi sửa");
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        ArrayList<BUS.NCC> a = this.ds.search(this.search_txt.getText());
        this.deleteTable();
        this.addDATABASE(a);
    }//GEN-LAST:event_search_txtKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JButton delete_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel notice_lab;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTable table;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables

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
            java.util.logging.Logger.getLogger(NCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NCC().setVisible(true);
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
    
    public String getSdt()
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        return (String) this.model.getValueAt(row, 3);
    }
    
    public void setName(String name)
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        this.model.setValueAt((String) name, row, 2);
    }
    
    public void setSdt(String sdt)
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        this.model.setValueAt((String) sdt, row, 3);
    }
}
