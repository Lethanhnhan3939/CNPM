package cnpm;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class THONGKE extends javax.swing.JFrame
{
    DefaultComboBoxModel model_month = new DefaultComboBoxModel();
    DefaultComboBoxModel model_year = new DefaultComboBoxModel();
    DefaultTableModel model;
    ButtonGroup  options;
    private int n;

    public THONGKE()
    {
        initComponents();
        this.options = new ButtonGroup();
        this.options.add(this.khongloc_rb);
        this.options.add(this.locthang_rb);
        this.options.add(this.locnam_rb);
        this.init();
        this.importTable_khongloc();
    }
    
    private void init()
    {
        for (int i = 1970; i <= 2099; i++)
            this.model_year.addElement(i);
        for (int i = 1; i <= 12; i++)
            this.model_month.addElement(i);
        
        this.month.setModel(model_month);
        this.year.setModel(model_year);
        
        Date now = new Date();
        this.year.setSelectedIndex(now.getYear() - 70);
        this.month.setSelectedIndex(now.getMonth());
        
        this.khongloc_rb.setSelected(true);
    }
    
    private void deleteTable()
    {
        int rowCount = this.model.getRowCount();
        for(int i = rowCount; i > 0; i--)
        {
            this.model.removeRow(i-1);
        }
    }
    
    private void importTable_khongloc()
    {
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        
        ResultSet resHD = DAO.DAO.select(
                "convert(nvarchar(10), cast(HOADON.ngay as date), 103) ngay, sum(HOADON.tongtien) doanhthu",
                "HOADON",
                "HOADON.ngay in (select ngay from HOADON) group by convert(nvarchar(10), cast(HOADON.ngay as date), 103)");
        
        try
        {
            while (resHD.next())
            {
                Object rowDATA[] = new Object[5];
                this.n++;
                rowDATA[0] = this.n;
                rowDATA[1] = (String) resHD.getString(1);
                
                ResultSet resThu = DAO.DAO.select("convert(nvarchar(10), PHIEUTHU.ngaythu, 103), PHIEUTHU.tongtien", "PHIEUTHU", null);
                int tongThu = 0;
                while (resThu.next())
                {
                    
                    if (resThu.getString(1).equals(resHD.getString(1)))
                        tongThu = tongThu + resThu.getInt(2);
                    rowDATA[4] = tongThu;
                }
                
                ResultSet resChi = DAO.DAO.select("convert(nvarchar(10), PHIEUCHI.thoigian, 103), PHIEUCHI.tongtien", "PHIEUCHI", null);
                int tongChi = 0;
                while (resChi.next())
                {
                    if (resChi.getString(1).equals(resHD.getString(1)))
                        tongChi = tongChi + resChi.getInt(2);
                    rowDATA[2] = tongChi;
                }
                
                rowDATA[3] = resHD.getInt(2);
                this.model.addRow(rowDATA);
            }
        }
        catch (Exception e) {System.out.println("GUI.THONGKE.importTable() error: " + e);}
    }
    
    private void importTable_locthang(int month, int year)
    {
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        String monthToString;
        if (month < 10) monthToString = "0" + String.valueOf(month);
        else monthToString = String.valueOf(month);
        
        ResultSet resHD = DAO.DAO.select(
                "convert(nvarchar(10), cast(HOADON.ngay as date), 103) ngay, sum(HOADON.tongtien) doanhthu",
                "HOADON",
                "convert(nvarchar(10), cast(HOADON.ngay as date), 103) like '%/" + monthToString + "/" + String.valueOf(year) + "' group by convert(nvarchar(10), cast(HOADON.ngay as date), 103)");
        
        try
        {
            while (resHD.next())
            {
                Object rowDATA[] = new Object[5];
                this.n++;
                rowDATA[0] = this.n;
                rowDATA[1] = (String) resHD.getString(1);
                
                ResultSet resThu = DAO.DAO.select("convert(nvarchar(10), PHIEUTHU.ngaythu, 103), PHIEUTHU.tongtien", "PHIEUTHU", null);
                int tongThu = 0;
                while (resThu.next())
                {
                    
                    if (resThu.getString(1).equals(resHD.getString(1)))
                        tongThu = tongThu + resThu.getInt(2);
                    rowDATA[4] = tongThu;
                }
                
                ResultSet resChi = DAO.DAO.select("convert(nvarchar(10), PHIEUCHI.thoigian, 103), PHIEUCHI.tongtien", "PHIEUCHI", null);
                int tongChi = 0;
                while (resChi.next())
                {
                    if (resChi.getString(1).equals(resHD.getString(1)))
                        tongChi = tongChi + resChi.getInt(2);
                    rowDATA[2] = tongChi;
                }
                
                rowDATA[3] = resHD.getInt(2);
                this.model.addRow(rowDATA);
            }
        }
        catch (Exception e) {System.out.println("GUI.THONGKE.importTable() error: " + e);}
    }
    
    private void importTable_locnam(int year)
    {
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        
        ResultSet resHD = DAO.DAO.select(
                "month(HOADON.ngay), sum(HOADON.tongtien)",
                "HOADON",
                "year(HOADON.ngay) = " + year + " group by month(HOADON.ngay)");
        
        try
        {
            while (resHD.next())
            {
                Object rowDATA[] = new Object[5];
                this.n++;
                rowDATA[0] = this.n;
                rowDATA[1] = resHD.getInt(1);
                ResultSet resThu = DAO.DAO.select(
                        "month(PHIEUTHU.ngaythu), sum(PHIEUTHU.tongtien)",
                        "PHIEUTHU",
                        "year(PHIEUTHU.ngaythu) = " + year + " group by month(PHIEUTHU.ngaythu)");
                
                while (resThu.next())
                {
                    if (resHD.getInt(1) == resThu.getInt(1))
                        rowDATA[4] = resThu.getInt(2);
                }
                
                ResultSet resChi = DAO.DAO.select(
                        "month(PHIEUCHI.thoigian), sum(PHIEUCHI.tongtien)",
                        "PHIEUCHI",
                        "year(PHIEUCHI.thoigian) = " + year + " group by month(PHIEUCHI.thoigian)");
                
                while (resChi.next())
                {
                    if (resHD.getInt(1) == resChi.getInt(1))
                        rowDATA[2] = resChi.getInt(2);
                }
                rowDATA[3] = resHD.getInt(2);
                this.model.addRow(rowDATA);
            }
        }
        catch (Exception e) {System.out.println("GUI.THONGKE.importTable() error: " + e);}
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        month = new javax.swing.JComboBox();
        year = new javax.swing.JComboBox();
        filter = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        locnam_rb = new javax.swing.JRadioButton();
        locthang_rb = new javax.swing.JRadioButton();
        khongloc_rb = new javax.swing.JRadioButton();
        cthoadon = new javax.swing.JButton();
        ctphieuchi = new javax.swing.JButton();
        ctphieuthu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("THỐNG KÊ");

        filter.setText("Lọc");
        filter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Thời gian", "Chi", "Doanh Thu", "Thu"
            }
        ));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(50);
            table.getColumnModel().getColumn(0).setMaxWidth(50);
            table.getColumnModel().getColumn(1).setMinWidth(80);
            table.getColumnModel().getColumn(1).setMaxWidth(80);
        }

        locnam_rb.setText("Lọc theo năm (Thống kê theo tháng)");

        locthang_rb.setText("Lọc theo tháng (Thống kê theo ngày)");

        khongloc_rb.setText("Không lọc");

        cthoadon.setText("Hóa đơn");
        cthoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cthoadonActionPerformed(evt);
            }
        });

        ctphieuchi.setText("Chi");
        ctphieuchi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctphieuchiActionPerformed(evt);
            }
        });

        ctphieuthu.setText("Thu");
        ctphieuthu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ctphieuthuActionPerformed(evt);
            }
        });

        jLabel2.setText("Chi Tiết:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 352, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(locthang_rb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(khongloc_rb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(locnam_rb, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 62, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ctphieuthu, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ctphieuchi, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cthoadon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(year, 0, 82, Short.MAX_VALUE)
                            .addComponent(month, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(filter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(filter))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(khongloc_rb)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locthang_rb)
                    .addComponent(month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locnam_rb)
                    .addComponent(year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cthoadon)
                    .addComponent(ctphieuchi)
                    .addComponent(ctphieuthu)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterActionPerformed
        this.deleteTable();
        int month = (int)this.month.getSelectedItem();
        int year = (int)this.year.getSelectedItem();
        if (this.khongloc_rb.isSelected() == true)
        {
            this.importTable_khongloc();
        }
        if (this.locthang_rb.isSelected() == true)
        {
            this.importTable_locthang(month, year);
        }
        if (this.locnam_rb.isSelected() == true)
        {
            this.importTable_locnam(year);
        }
    }//GEN-LAST:event_filterActionPerformed

    private void cthoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cthoadonActionPerformed
        if (this.locnam_rb.isSelected() == true)
        {
            try
            {
                this.model = (DefaultTableModel) table.getModel();
                int row = this.table.getSelectedRow();
                int month = (int) this.model.getValueAt(row, 1);
                HOADON frame = new HOADON(month, (int)this.year.getSelectedItem());
                frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
            catch (SQLException ex) {System.out.print("GUI.THONGKE.tableMouseClickedAction error: " + ex);}
        }
        else
        {
            try
            {
                this.model = (DefaultTableModel) table.getModel();
                int row = this.table.getSelectedRow();
                String date = (String) this.model.getValueAt(row, 1);
                try
                {
                    HOADON frame = new HOADON(date);
                    frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
                }
                catch (SQLException ex) {System.out.print("GUI.THONGKE.tableMouseClickedAction error: " + ex);}
            }
            catch (Exception e) {}
        }
        
    }//GEN-LAST:event_cthoadonActionPerformed

    private void ctphieuthuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctphieuthuActionPerformed
        if (this.locnam_rb.isSelected() == true)
        {
            try
            {
                this.model = (DefaultTableModel) table.getModel();
                int row = this.table.getSelectedRow();
                int month = (int) this.model.getValueAt(row, 1);
                PHIEUTHU frame = new PHIEUTHU(month, (int)this.year.getSelectedItem());
                frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
            catch (Exception ex) {System.out.print("GUI.THONGKE.tableMouseClickedAction error: " + ex);}
        }
        else
        {
            try
            {
                this.model = (DefaultTableModel) table.getModel();
                int row = this.table.getSelectedRow();
                String date = (String) this.model.getValueAt(row, 1);
                try
                {
                    PHIEUTHU frame = new PHIEUTHU(date);
                    frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
                }
                catch (Exception ex) {System.out.print("GUI.THONGKE.tableMouseClickedAction error: " + ex);}
            }
            catch (Exception e) {}
        }
    }//GEN-LAST:event_ctphieuthuActionPerformed

    private void ctphieuchiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ctphieuchiActionPerformed
        if (this.locnam_rb.isSelected() == true)
        {
            try
            {
                this.model = (DefaultTableModel) table.getModel();
                int row = this.table.getSelectedRow();
                int month = (int) this.model.getValueAt(row, 1);
                PHIEUCHI frame = new PHIEUCHI(month, (int)this.year.getSelectedItem());
                frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                frame.setVisible(true);
            }
            catch (Exception ex) {System.out.print("GUI.THONGKE.tableMouseClickedAction error: " + ex);}
        }
        else
        {
            try
            {
                this.model = (DefaultTableModel) table.getModel();
                int row = this.table.getSelectedRow();
                String date = (String) this.model.getValueAt(row, 1);
                try
                {
                    PHIEUCHI frame = new PHIEUCHI(date);
                    frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                    frame.setVisible(true);
                }
                catch (Exception ex) {System.out.print("GUI.THONGKE.tableMouseClickedAction error: " + ex);}
            }
            catch (Exception e) {}
        }
    }//GEN-LAST:event_ctphieuchiActionPerformed

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
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(THONGKE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new THONGKE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cthoadon;
    private javax.swing.JButton ctphieuchi;
    private javax.swing.JButton ctphieuthu;
    private javax.swing.JButton filter;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton khongloc_rb;
    private javax.swing.JRadioButton locnam_rb;
    private javax.swing.JRadioButton locthang_rb;
    private javax.swing.JComboBox month;
    private javax.swing.JTable table;
    private javax.swing.JComboBox year;
    // End of variables declaration//GEN-END:variables

    //Lấy ngày trên ComboBox
    public Date getDate()
    {
        Date result = new Date();
        result.setMonth((int)this.month.getSelectedItem());
        result.setYear((int)this.year.getSelectedItem());
        return result;
    }
    
    //Xuất ngày ra thành chuỗi để so sánh
    public String toStringDate(Date date)
    {
        String d = null;
        if (date.getDate() < 10) d = "0" + String.valueOf(date.getDate());
        else d = String.valueOf(date.getDate());
        String m = null;
        if (date.getMonth() < 10) m = "0" + String.valueOf(date.getMonth());
        else m = String.valueOf(date.getMonth());
        String result = d + "/" + m + "/" + String.valueOf(date.getYear());
        return result;
    }
}
