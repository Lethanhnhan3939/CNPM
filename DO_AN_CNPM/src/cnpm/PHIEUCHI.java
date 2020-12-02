package cnpm;

import DAO.DAO;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class PHIEUCHI extends javax.swing.JFrame
{
    private BUS.DSCTPHIEUCHI dsct = new BUS.DSCTPHIEUCHI();
    BUS.DSPHIEUCHI ds = new BUS.DSPHIEUCHI();
    ArrayList<BUS.PHIEUCHI> list = this.ds.getList();
    DefaultTableModel model;
    Date date = new Date();
    private int n = 0;

    DefaultComboBoxModel model_day1 = new DefaultComboBoxModel();
    DefaultComboBoxModel model_month1 = new DefaultComboBoxModel();
    DefaultComboBoxModel model_year1 = new DefaultComboBoxModel();

    public PHIEUCHI()
    {   
        initComponents();
        this.init();
        Date now = new Date();
        int month = now.getMonth() + 1;
        int year = now.getYear() + 1900;
        this.addDATABASE(ds.importDS_theothang(month, year));
    }
    
    public PHIEUCHI(String date)
    {
        initComponents();
        this.init();
        this.theoThongKe(date);
    }
    
    public PHIEUCHI(int month, int year)
    {
        initComponents();
        this.init();
        this.theoThongKeThang(month, year);
    }
    
    private void init()
    {
        for (int i = 1970; i <= 2099; i++)
            this.model_year1.addElement(i);
        for (int i = 1; i <= 12; i++)
            this.model_month1.addElement(i);
        for (int i = 1; i <= 31; i++)
            this.model_day1.addElement(i);
        
        this.day1.setModel(model_day1);
        this.month1.setModel(model_month1);
        this.year1.setModel(model_year1);
        
        //set default list item
        year1.setSelectedItem(date.getYear()+1900);
        month1.setSelectedItem(date.getMonth()+1);
        day1.setSelectedItem(date.getDate());
    }
    
    private void addDATABASE(ArrayList<BUS.PHIEUCHI> a)
    {
        Object rowData[] = new Object[5];
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        for (int i = 0; i < a.size(); i++)
        {
            rowData[0] = i + 1;
            rowData[1] = a.get(i).getID();
            rowData[2] = a.get(i).toString();
            rowData[3] = a.get(i).getSotien();
            rowData[4] = (String) a.get(i).getGhiChu();
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
    
    public void theoThongKe(String date)
    {
        Object rowData[] = new Object[5];
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        for (int i = 0; i < ds.getList().size(); i++)
        {
            if (this.ds.getList().get(i).toString().equals(date) == true)
            {
                rowData[0] = i + 1;
                rowData[1] = ds.getList().get(i).getID();
                rowData[2] = ds.getList().get(i).toString();
                rowData[3] = ds.getList().get(i).getSotien();
                rowData[4] = ds.getList().get(i).getGhiChu();
                this.model.addRow(rowData);
                this.n++;
            }
        }
    }
    
    public void theoThongKeThang(int month, int year)
    {
        Object rowData[] = new Object[5];
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        ResultSet res = DAO.select(
                "idPC, convert(nvarchar(10), thoigian, 103), tongtien, ghichu",
                "PHIEUCHI",
                "month(thoigian) = " + month + " and YEAR(thoigian) = " + year);
        try
        {
            this.n = 0;
            while (res.next())
            {
                rowData[0] = n + 1;
                rowData[1] = res.getInt(1);
                rowData[2] = res.getString(2);
                rowData[3] = res.getInt(3);
                rowData[4] = res.getString(4);
                this.model.addRow(rowData);
                this.n++;
            }
        }
        catch (Exception ex) {}
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        add_btn = new javax.swing.JButton();
        delete_btn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        refresh2 = new javax.swing.JButton();
        search_btn = new javax.swing.JButton();
        year1 = new javax.swing.JComboBox();
        search_txt = new javax.swing.JTextField();
        month1 = new javax.swing.JComboBox();
        day1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 72));
        jLabel4.setText("Danh sách Phiếu Chi");

        add_btn.setText("Thêm");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        delete_btn.setText("Xóa");
        delete_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btnActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Ngày", "Tổng tiền", "Ghi chú"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(1).setMinWidth(50);
            table.getColumnModel().getColumn(1).setMaxWidth(50);
            table.getColumnModel().getColumn(2).setMinWidth(80);
            table.getColumnModel().getColumn(2).setMaxWidth(80);
            table.getColumnModel().getColumn(3).setMinWidth(70);
            table.getColumnModel().getColumn(3).setMaxWidth(70);
        }

        refresh2.setText("Refresh");
        refresh2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refresh2ActionPerformed(evt);
            }
        });

        search_btn.setText("Lọc ngày");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });

        year1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                year1ActionPerformed(evt);
            }
        });

        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        month1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                month1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm theo ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(delete_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel1))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(refresh2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(52, 52, 52)
                                        .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search_btn)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(add_btn)
                        .addComponent(delete_btn)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refresh2)
                    .addComponent(search_btn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed
        PHIEUCHI_ADD dlg = new PHIEUCHI_ADD(this, true);
        dlg.setVisible(true);
        if (dlg.Check() == "")
        {
            JOptionPane.showMessageDialog(this, "Không được để trống các thành phần trong hộp thoại");
        }
        else
        {
            Object rowData[] = new Object[5];
            this.ds.add(dlg.getDate(), dlg.getTongtien(), dlg.getGhichu());
            this.dsct.add(this.ds.getList().get(this.ds.getList().size() - 1).getID(), dlg.getIDNL(), dlg.getSL());
            this.deleteTable();
            this.addDATABASE(this.list);
            this.n++;
        }
    }//GEN-LAST:event_add_btnActionPerformed

    private void delete_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btnActionPerformed
        try
        {
            this.model = (DefaultTableModel) table.getModel();
            int row = this.table.getSelectedRow();
            int id = (int) this.model.getValueAt(row, 1);
            this.ds.delete(id);
            this.ds.delete(id);
            this.model.removeRow(row);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Chọn một phiếu chi để xóa");
        }
    }//GEN-LAST:event_delete_btnActionPerformed

    private void refresh2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refresh2ActionPerformed
        this.deleteTable();
        this.addDATABASE(this.list);
    }//GEN-LAST:event_refresh2ActionPerformed

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
        Date date = new Date();
        date.setDate((int) this.model_day1.getSelectedItem());
        date.setMonth((int) this.model_month1.getSelectedItem());
        date.setYear((int) this.model_year1.getSelectedItem());
        this.deleteTable();
        this.addDATABASE(this.ds.searchDATE(date));
    }//GEN-LAST:event_search_btnActionPerformed

    private void year1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_year1ActionPerformed
        int i = (int)this.model_month1.getSelectedItem();
        int y = (int)this.model_year1.getSelectedItem();
        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
        {
            this.model_day1.removeAllElements();
            for (int j = 1; j <= 31; j++)
            this.model_day1.addElement(j);
        }
        if (i == 4 || i == 6 || i == 9 || i == 11)
        {
            this.model_day1.removeAllElements();
            for (int j = 1; j <= 30; j++)
            this.model_day1.addElement(j);
        }
        if (i == 2 && y % 4 == 0)
        {
            this.model_day1.removeAllElements();
            for (int j = 1; j <= 29; j++)
            this.model_day1.addElement(j);
        }
        if (i == 2 && y % 4 != 0)
        {
            this.model_day1.removeAllElements();
            for (int j = 1; j <= 28; j++)
            this.model_day1.addElement(j);
        }
    }//GEN-LAST:event_year1ActionPerformed

    private void month1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_month1ActionPerformed
        int i = (int)this.model_month1.getSelectedItem();
        int y = (int)this.model_year1.getSelectedItem();
        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12)
        {
            this.model_day1.removeAllElements();
            for (int j = 1; j <= 31; j++)
            this.model_day1.addElement(j);
        }
        if (i == 4 || i == 6 || i == 9 || i == 11)
        {
            this.model_day1.removeAllElements();
            for (int j = 1; j <= 30; j++)
            this.model_day1.addElement(j);
        }
        if (i == 2 && y % 4 == 0)
        {
            this.model_day1.removeAllElements();
            for (int j = 1; j <= 29; j++)
            this.model_day1.addElement(j);
        }
        if (i == 2 && y % 4 != 0)
        {
            this.model_day1.removeAllElements();
            for (int j = 1; j <= 28; j++)
            this.model_day1.addElement(j);
        }
    }//GEN-LAST:event_month1ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        CTPHIEUCHI dlg = new CTPHIEUCHI(this, true, this.getID());
        dlg.setTitle("Chi tiết Phiếu chi mã: " + String.valueOf(this.getID()));
        dlg.setDate(this.getDate());
        dlg.setTongTien(this.getTongTien());
        dlg.setGhiChu(this.getGhiChu());
        dlg.setVisible(true);
    }//GEN-LAST:event_tableMouseClicked

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        try
        {
            int check  = Integer.parseInt(this.search_txt.getText());
            if (check == 0) check = 1/0;
            ArrayList<BUS.PHIEUCHI> text = this.ds.searchID(check);
            this.deleteTable();
            this.addDATABASE(text);
        }
        catch (Exception e)
        {
            if (this.search_txt.getText().equals(""))
            {
                this.deleteTable();
                this.addDATABASE(this.list);
            }
            else this.deleteTable();
        }
    }//GEN-LAST:event_search_txtKeyReleased

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
            java.util.logging.Logger.getLogger(PHIEUCHI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PHIEUCHI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PHIEUCHI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PHIEUCHI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PHIEUCHI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JComboBox day1;
    private javax.swing.JButton delete_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox month1;
    private javax.swing.JButton refresh2;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTable table;
    private javax.swing.JComboBox year1;
    // End of variables declaration//GEN-END:variables

    public int getID()
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        return (int) this.model.getValueAt(row, 1);
    }
    public String getDate()
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        return (String) this.model.getValueAt(row, 2);
    }
    public int getTongTien()
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        return (int) this.model.getValueAt(row, 3);
    }
    public String getGhiChu()
    {
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        return (String) this.model.getValueAt(row, 4);
    }
}
