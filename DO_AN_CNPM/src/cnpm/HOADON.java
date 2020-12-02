package cnpm;

import DAO.DAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class HOADON extends javax.swing.JFrame
{
    BUS.DSHOADON ds = new BUS.DSHOADON();
    ArrayList<BUS.HOADON> list = this.ds.getList();
    DefaultTableModel model;
    DefaultTableModel model_uathich;
    
    private int n = 0;

    DefaultComboBoxModel model_day1 = new DefaultComboBoxModel();
    DefaultComboBoxModel model_month1 = new DefaultComboBoxModel();
    DefaultComboBoxModel model_year1 = new DefaultComboBoxModel();
    DefaultComboBoxModel model_month = new DefaultComboBoxModel();
    DefaultComboBoxModel model_year = new DefaultComboBoxModel();

    public HOADON() throws SQLException
    {
        initComponents();
        this.init();
        this.init_uathich();
        Date now = new Date();
        int month = now.getMonth() + 1;
        int year = now.getYear() + 1900;
        this.addDATABASE(ds.importDS_theothang(month, year));
    }
    
    public HOADON(String date) throws SQLException
    {
        initComponents();
        this.init();
        this.init_uathich();
        this.theoThongKe(date);
    }
    
    public HOADON(int month, int year) throws SQLException
    {
        initComponents();
        this.init();
        this.init_uathich();
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
        
        Date now = new Date();
        this.year1.setSelectedIndex(now.getYear() - 70);
        this.month1.setSelectedIndex(now.getMonth());
        this.day1.setSelectedIndex(now.getDate() - 1);
    }
    
    private void init_uathich()
    {
        for (int i = 1; i <= 12; i++)
            this.model_month.addElement(i);
        for (int i = 1970; i <= 2099; i++)
            this.model_year.addElement(i);
        
        this.month_ua_thich.setModel(model_month);
        this.year_ua_thich.setModel(model_year);
        
        Date now = new Date();
        this.year_ua_thich.setSelectedIndex(now.getYear() - 70);
        this.month_ua_thich.setSelectedIndex(now.getMonth());
        this.loadTable_uathich(now.getMonth() + 1);
    }
    
    private void addDATABASE(ArrayList<BUS.HOADON> a)
    {
        Object rowData[] = new Object[6];
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        for (int i = 0; i < a.size(); i++)
        {
            rowData[0] = i + 1;
            rowData[1] = a.get(i).getID();
            rowData[4] = a.get(i).getTenNV();
            rowData[5] = a.get(i).getTongtien();
            rowData[2] = a.get(i).toString();
            ResultSet res = DAO.select("convert(nvarchar(8), ngay, 108)", "HOADON", "idHD = " + a.get(i).getID());
            try
            {
                while (res.next())
                    rowData[3] = res.getTime(1).toString();
            }
            catch (Exception e) {System.out.println(e);}
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
        Object rowData[] = new Object[6];
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        for (int i = 0; i < ds.getList().size(); i++)
        {
            if (this.ds.getList().get(i).toString().equals(date) == true)
            {
                rowData[0] = i + 1;
                rowData[1] = ds.getList().get(i).getID();
                rowData[4] = ds.getList().get(i).getTenNV();
                rowData[5] = ds.getList().get(i).getTongtien();
                rowData[2] = ds.getList().get(i).toString();
                ResultSet res = DAO.select("convert(nvarchar(8), ngay, 108)", "HOADON", "idHD = " + ds.getList().get(i).getID());
                try
                {
                    while (res.next())
                        rowData[3] = res.getTime(1).toString();
                }
                catch (Exception e) {System.out.println(e);}
                this.model.addRow(rowData);
                this.n++;
            }
        }
    }
    
    public void theoThongKeThang(int month, int year)
    {
        Object rowData[] = new Object[6];
        this.model = (DefaultTableModel) table.getModel();
        this.n = 0;
        ResultSet res = DAO.select(
                "HOADON.idHD, NHANVIEN.tenNV, HOADON.tongtien, convert(nvarchar(10), HOADON.ngay, 103), convert(nvarchar(8), HOADON.ngay, 108)",
                "HOADON, NHANVIEN",
                "HOADON.idNV = NHANVIEN.idNV and month(HOADON.ngay) = " + month + " and YEAR(HOADON.ngay) = " + year);
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
                rowData[5] = res.getString(5);
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
        search_txt = new javax.swing.JTextField();
        search_btn = new javax.swing.JButton();
        year1 = new javax.swing.JComboBox();
        month1 = new javax.swing.JComboBox();
        day1 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_uathich = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_filter_ua_thich = new javax.swing.JButton();
        year_ua_thich = new javax.swing.JComboBox();
        month_ua_thich = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 27, 72));
        jLabel4.setText("Danh sách Hóa Đơn");

        search_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_txtKeyReleased(evt);
            }
        });

        search_btn.setText("Lọc Ngày");
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

        month1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                month1ActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "ID", "Ngày", "Thời gian", "Nhân viên", "Tổng tiền"
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
            table.getColumnModel().getColumn(3).setMinWidth(80);
            table.getColumnModel().getColumn(3).setMaxWidth(80);
        }

        table_uathich.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Món ăn", "SL", "Hạng"
            }
        ));
        jScrollPane2.setViewportView(table_uathich);
        if (table_uathich.getColumnModel().getColumnCount() > 0) {
            table_uathich.getColumnModel().getColumn(0).setMinWidth(50);
            table_uathich.getColumnModel().getColumn(0).setMaxWidth(50);
            table_uathich.getColumnModel().getColumn(2).setMinWidth(50);
            table_uathich.getColumnModel().getColumn(2).setMaxWidth(50);
            table_uathich.getColumnModel().getColumn(3).setMinWidth(50);
            table_uathich.getColumnModel().getColumn(3).setMaxWidth(50);
        }

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 27, 72));
        jLabel5.setText("Top món ăn ưa thích nhất tháng");

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Tìm kiểm");

        btn_filter_ua_thich.setText("Lọc");
        btn_filter_ua_thich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_filter_ua_thichActionPerformed(evt);
            }
        });

        jLabel2.setText("Tháng");

        jLabel3.setText("Năm");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(163, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search_btn))))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(month_ua_thich, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(2, 2, 2)
                        .addComponent(year_ua_thich, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_filter_ua_thich, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(190, 190, 190)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(month1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(day1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_btn)
                    .addComponent(year1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btn_filter_ua_thich)
                    .addComponent(year_ua_thich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(month_ua_thich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        this.model = (DefaultTableModel) table.getModel();
        int row = this.table.getSelectedRow();
        int idHD = (int) this.model.getValueAt(row, 1);
        String tenNV = (String) this.model.getValueAt(row, 2);
        int tongtien = (int) this.model.getValueAt(row, 3);
        String ngay = (String) this.model.getValueAt(row, 4);
        CTHOADON dlg = new CTHOADON(this, true, idHD);
        dlg.setTitle("Chi tiết hóa đơn mã " + idHD);
        dlg.setTenNV(tenNV);
        dlg.setNgay(ngay);
        dlg.setTongtien(tongtien);
        dlg.setVisible(true);
    }//GEN-LAST:event_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.deleteTable();
        this.addDATABASE(this.list);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void search_txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_txtKeyReleased
        ResultSet res;
        res = DAO.select(
                "HOADON.idHD, NHANVIEN.tenNV",
                "HOADON, NHANVIEN",
                "HOADON.idNV = NHANVIEN.idNV and (NHANVIEN.tenNV like N'%" + this.search_txt.getText() + "%' or HOADON.idHD like '%" + this.search_txt.getText() + "%')");
        try
        {
            this.deleteTable();
            int i = 0;
            while (res.next())
            {
                int idHD = res.getInt(1);
                Object rowDATA[] = new Object[5];
                rowDATA[0] = (int) i + 1;
                rowDATA[1] = (int) res.getInt(1);
                rowDATA[2] = (String) res.getString(2);
                for (int j = 0; j < ds.getList().size(); j++)
                {
                    if(idHD == ds.getList().get(j).getID())
                    {
                        rowDATA[3] = ds.getList().get(j).getTongtien();
                        rowDATA[4] = ds.getList().get(j).toString();
                    }
                }
                this.model.addRow(rowDATA);
                i++;
            }
        }
        catch (SQLException ex) {}
    }//GEN-LAST:event_search_txtKeyReleased

    private void btn_filter_ua_thichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_filter_ua_thichActionPerformed
        loadTable_uathich((Integer)month_ua_thich.getSelectedItem());
    }//GEN-LAST:event_btn_filter_ua_thichActionPerformed

    private void loadTable_uathich(int month)
    {
        this.model_uathich = (DefaultTableModel) this.table_uathich.getModel();
        ResultSet res = DAO.select(
                "idMonAn,sum(soluong) SL, rank () OVER (ORDER BY sum(soluong) DESC) HẠNG",
                "CTHOADON CT, HOADON HD",
                "CT.idHD=HD.idHD AND CT.idMonAn IN (select idMonAn from MONAN) AND MONTH(HD.ngay)="+month+" GROUP BY idMonAn");
        try
        {
            int i = 0;
            while (res.next())
            {
                Object rowDATA[] = new Object[4];
                rowDATA[0] = i + 1;
                rowDATA[1] = res.getString(1);
                rowDATA[2] = res.getInt(2);
                rowDATA[3] = res.getInt(3);
                this.model_uathich.addRow(rowDATA);
                i++;
            }
        }
        catch (SQLException ex) {System.out.println("Load ua thich error: "+ex);}
    }
    
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
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOADON.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HOADON().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HOADON.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_filter_ua_thich;
    private javax.swing.JComboBox day1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox month1;
    private javax.swing.JComboBox month_ua_thich;
    private javax.swing.JButton search_btn;
    private javax.swing.JTextField search_txt;
    private javax.swing.JTable table;
    private javax.swing.JTable table_uathich;
    private javax.swing.JComboBox year1;
    private javax.swing.JComboBox year_ua_thich;
    // End of variables declaration//GEN-END:variables

//******************************************************************************************************
    public String toStringDate(Date date)
    {
        String d = null;
        if (date.getDate() < 10) d = "0" + String.valueOf(date.getDate());
        else d = String.valueOf(date.getDate());
        String m = null;
        if (date.getMonth() < 10) m = "0" + String.valueOf(date.getMonth() + 1);
        else m = String.valueOf(date.getMonth());
        String result = d + "/" + m + "/" + String.valueOf(date.getYear() + 1900);
        return result;
    }
}
