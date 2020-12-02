/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnpm;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static tkgd.order.settongtien;
import static tkgd.order.showchucnang;
import tkgd.order;

/**
 *
 * @author tiennguyen
 */
public class chucnang extends javax.swing.JFrame {

    /**
     * Creates new form chucnang
     */
    public chucnang() {
        initComponents();

        String str = "BÀN ";
        ketthuc.setVisible(false);
//        String idban=banchuyen.getText();
//        String[] tp=idban.split(" ");
//        int iidd = Integer.parseInt(tp[1]);
    }

    public void loadtablebanright() {
        String q = (String) chonban.getSelectedItem();
        System.out.println(q);
        String[] ccc = q.split(" ");

        int i = Integer.parseInt(ccc[1]);
          //      System.out.println(zz);

        //int i=chonban.getSelectedIndex();
        //i+=1;
        if (getstatus(i) == 0 || getstatus(i) == 1) {
            loadtablerighttrong();
        } else {
            try {
                String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
                Connection conn = DriverManager.getConnection(dbURL);
                Statement statement = conn.createStatement();

                Object[] columm = {"Tên món ăn", "Số lượng"};
                DefaultTableModel model = new DefaultTableModel();
                model.setColumnIdentifiers(columm);
                tableright.setModel(model);
                if (conn != null) {
                    String sql = "select * from BAN where id='" + i + "'";
                    ResultSet rs;
                    rs = statement.executeQuery(sql);

                    Object[] rows = new Object[10];
                    while (rs.next()) {
                        //System.out.println(rows[0]);
                        rows[0] = rs.getString("tenmon");
                        rows[1] = rs.getInt("soluong");
                        model.addRow(rows);
                    }
                }
                conn.close();
            } catch (SQLException ex) {
                System.err.println("Cannot connect database, " + ex);
            }
        }
    }

    public void loadtablebanleft(int i) {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();

            Object[] columm = {"Tên món ăn", "Số lượng"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columm);
            tableleft.setModel(model);
            if (conn != null) {
                String sql = "select * from BAN where id='" + i + "'";
                ResultSet rs;
                rs = statement.executeQuery(sql);

                Object[] rows = new Object[10];
                while (rs.next()) {
                    //System.out.println(rows[0]);
                    rows[0] = rs.getString("tenmon");
                    rows[1] = rs.getInt("soluong");
                    model.addRow(rows);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }

    public void loadtablelefttrong() {
        Object[] columm = {"Tên món ăn", "Số lượng"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columm);
        tableleft.setModel(model);
    }

    public void loadtablerighttrong() {
        Object[] columm = {"Tên món ăn", "Số lượng"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columm);
        tableright.setModel(model);
    }

    public int getstatus(int i) {
        int status = 0;
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                String sql = "select * from BAN where id='" + i + "'";
                ResultSet rs;
                rs = statement.executeQuery(sql);

                while (rs.next()) {
                    status = rs.getInt("trangthai");
                    break;
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
        return status;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        banchuyen = new javax.swing.JLabel();
        chonban = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableleft = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableright = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        chuyen = new javax.swing.JButton();
        ketthuc = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        banchuyen.setText("jLabel1");

        chonban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chonbanActionPerformed(evt);
            }
        });

        tableleft.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(tableleft);

        tableright.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane2.setViewportView(tableright);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Gộp bàn");

        chuyen.setText("Gộp");
        chuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuyenActionPerformed(evt);
            }
        });

        ketthuc.setText("Kết thúc");
        ketthuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ketthucActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(banchuyen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(chonban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(342, 342, 342)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ketthuc)
                            .addComponent(chuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chonban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(banchuyen))
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(chuyen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ketthuc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chonbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chonbanActionPerformed
        // TODO add your handling code here:
        loadtablebanright();

    }//GEN-LAST:event_chonbanActionPerformed

    private void chuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuyenActionPerformed
        // TODO add your handling code here:
        if (getbuttonchuyenban().equals("Tách")) {
            String sql1, sql2, sql3;
            DefaultTableModel model = new DefaultTableModel();
            model = (DefaultTableModel) tableleft.getModel();
            int i = -1;
            i = tableleft.getSelectedRow();
            if (i == -1) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn món cần tách");
            } else {
                DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
                Calendar cal = Calendar.getInstance();
                String str = String.valueOf(cal.getTime());
                String[] out = str.split(" ");
                str = out[3];

                String laystringid = (String) chonban.getSelectedItem();
                String[] laystringidne = laystringid.split(" ");
                laystringid = laystringidne[1];

                String laystringids = banchuyen.getText();
                String[] laystringidnes = laystringids.split(" ");
                laystringids = laystringidnes[1];

                int sluong = (int) tableleft.getValueAt(i, 1);
                if (sluong == 1) {
                    addrowtableright(new Object[]{
                        tableleft.getValueAt(i, 0),
                        tableleft.getValueAt(i, 1)});
                    //update database

                    

                    sql1 = " insert into BAN (id,trangthai,tenmon,soluong,gia,thanhtien,giogoi) "
                            + "values ('" + Integer.parseInt(laystringid) + "','" + 2 + "',N'" + model.getValueAt(i, 0) + "','" + 1 + "','" + order.getgiamon(i) + "','" + order.getgiamon(i) + "','" + str + "')";
                    sql2 = "delete from BAN where id='" + Integer.parseInt(laystringids) + "' and giogoi='" + order.getgiogoi(i) + "'";
                    //remove bên bảng chức năng
                    model.removeRow(i);
                    //remove bên order
                    
                    order.tachmon(i);
                } else {
                    addrowtableright(new Object[]{tableleft.getValueAt(i, 0), 1});
                    
                    sql1 = " insert into BAN (id,trangthai,tenmon,soluong,gia,thanhtien,giogoi) "
                            + "values ('" + Integer.parseInt(laystringid) + "','" + 2 + "',N'" + model.getValueAt(i, 0) + "','" + 1 + "','" + order.getgiamon(i) + "','" + order.getgiamon(i) + "','" + str + "')";
                    int t1 = order.getgiamon(i);
                    int t2 = t1 * (sluong - 1);
                    int t3 = sluong - 1;
                    sql2 = "update BAN "
                            + "set soluong = '" + t3 + "'"
                            + ",thanhtien = '" + t1 + "'"
                            + "where id = '" + Integer.parseInt(laystringids) + "'and giogoi='" + order.getgiogoi(i) + "'";
                    model.setValueAt(sluong - 1, i, 1);
                    order.tachmotmon(sluong - 1, i, 2);
                }
                try {
                    String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
                    Connection conn = DriverManager.getConnection(dbURL);
                    Statement statement = conn.createStatement();
                    if (conn != null) {
                       
                        boolean check;
                        if(getstatus(i)==0 || getstatus(i)==1)
                        {
                            sql3="delete from BAN where id ='"+Integer.parseInt(laystringid)+"' and thanhtien=0";
                            check=statement.execute(sql3);
                        }
                        check = statement.execute(sql1);
                        check = statement.execute(sql2);
                    }
                    conn.close();
                } catch (SQLException ex) {
                    System.err.println("Cannot connect database, " + ex);
                }
                // xóa sql thanhtien =0 của bàn trống
                
                // set lại màu bàn
                order.setmuavang(Integer.parseInt(laystringid));
                setstatus(Integer.parseInt(laystringid),2 );
                if(getstatus(Integer.parseInt(laystringids))==0 || getstatus(Integer.parseInt(laystringids))==1)
                {
                    order.setmuatrang(Integer.parseInt(laystringids));
                    setstatus(Integer.parseInt(laystringids),0 );
                }else {order.setmuavang(Integer.parseInt(laystringids));setstatus(Integer.parseInt(laystringids),2);}
                // set màu cho bàn tách nếu số món =0

            }
        } else {
            String b1 = banchuyen.getText();
            String[] b2 = b1.split(" ");
            int b3 = Integer.parseInt(b2[1]);
            System.out.println(b3);
            String c1 = (String) chonban.getSelectedItem();
            String[] c2 = c1.split(" ");
            int c3 = Integer.parseInt(c2[1]);
            System.out.println(c3);
            try {
                String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
                Connection conn = DriverManager.getConnection(dbURL);
                Statement statement = conn.createStatement();
                if (conn != null) {
                    System.out.println("Connected");
                    DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                    String trunggian = "delete from BAN where id='" + c3 + "' and thanhtien=0";
                    String chuyenthoi = "update BAN "
                            + "set id = '" + c3 + "'"
                            + "where id = '" + b3 + "'";
                    boolean chuyenthoinao;
                    chuyenthoinao = statement.execute(chuyenthoi);
                    chuyenthoinao = statement.execute(trunggian);
                }
                conn.close();
            } catch (SQLException ex) {
                System.err.println("Cannot connect database, " + ex);
            }
            if (getbuttonchuyenban().equals("Gộp")) {
                JOptionPane.showMessageDialog(this, "Gộp bàn thành công !!!");
            } else if (getbuttonchuyenban().equals("Chuyển")) {
                JOptionPane.showMessageDialog(this, "Chuyển bàn thành công !!!");
            }
            order.loadtabletrong();
            this.dispose();
            order.setmuatrang(b3);
            order.setmuavang(c3);
        }
    }//GEN-LAST:event_chuyenActionPerformed

    private void ketthucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ketthucActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_ketthucActionPerformed

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
            java.util.logging.Logger.getLogger(chucnang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(chucnang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(chucnang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(chucnang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new chucnang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banchuyen;
    private javax.swing.JComboBox chonban;
    private javax.swing.JButton chuyen;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton ketthuc;
    private javax.swing.JTable tableleft;
    private javax.swing.JTable tableright;
    // End of variables declaration//GEN-END:variables
    public void setbanchuyen(String str) {
        banchuyen.setText(str);
    }

    public void setlabelchuyenban(String str) {
        jLabel2.setText(str);
    }

    public void setbuttonchuyenban(String str) {
        chuyen.setText(str);
    }

    public String getlabelchuyenbann() {
        return jLabel2.getText();
    }

    public String getbuttonchuyenban() {
        return chuyen.getText();
    }

    public void setcombobox(int x) {
        String str = "BÀN ";
        if (x == 1) {
            //System.out.println("SDFadf");
            for (int i = 1; i <= 12; i++) {
                str = "BÀN ";
                if (getstatus(i) == 2 || getstatus(i) == 3) {
                    str += i;
                    chonban.addItem(str);
                }
            }
        }
        if (x == 0) {
            //System.out.println("tien");
            for (int i = 1; i <= 12; i++) {
                str = "BÀN ";
                if (getstatus(i) == 0 || getstatus(i) == 1) {
                    str += i;
                    chonban.addItem(str);
                }
            }
        }
        if (x == 2) {
            for (int i = 1; i <= 12; i++) {
                str = "BÀN ";
                str += i;
                chonban.addItem(str);
            }
        }
        loadtablebanright();
    }

    public void addrowtableright(Object[] a) {
        DefaultTableModel model = (DefaultTableModel) tableright.getModel();
        model.addRow(a);
    }

    public void hideketthuc() {
        ketthuc.setVisible(false);
    }

    public void showketthuc() {
        ketthuc.setVisible(true);
    }
    public boolean setstatus(int i, int s) {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();

            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                String sql = "UPDATE BAN SET trangthai ='" + s + "' WHERE id='" + i + "'";
                boolean checked = statement.execute(sql);

            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
        return false;
    }
}
