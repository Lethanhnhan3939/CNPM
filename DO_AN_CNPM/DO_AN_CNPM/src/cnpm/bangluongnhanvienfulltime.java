/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnpm;

import DAO.DAO;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.objects.NativeString;

/**
 *
 * @author tiennguyen
 */
public class bangluongnhanvienfulltime extends javax.swing.JFrame {

    /**
     * Creates new form bangluongnhanvienfulltime
     */
    public bangluongnhanvienfulltime() {
        initComponents();
          loadTable();
    }

    public static void loadTable() {
                Date date=new Date();
        //tính tổng thời gian trước khi table đc load lên
        try {
        ResultSet res=DAO.select("idNV", "NHANVIEN", "loaiNV=1");
        while (res.next()){
            int idNV=res.getInt(1);
            System.out.println(idNV);
            //get lương cứng
            int luongcung=0;
            ResultSet res2= DAO.select("luong","NHANVIEN",String.format("idNV=%d",idNV));
            try  {
                res2.next();
                luongcung=res2.getInt(1);
            } catch (SQLException ex) {}
            System.out.println(luongcung);
            //get lương ứng
            int ungluong=0;
            ResultSet res3= DAO.select("tamung","LUONG",String.format("idNV=%d and luongthang=%d and nam=%d",idNV,(date.getMonth()+1),(date.getYear()+1900)));
            try  {
                res3.next();
                ungluong=res3.getInt(1);
            } catch (SQLException ex) {}
            //update tổng thời gian
            float tongtime=tinhtongtime(idNV, date.getMonth()+1);
            DAO.update("LUONG", "tongthoigian="+tongtime,"idNV="+idNV+" and luongthang="+(date.getMonth()+1)+" and nam="+(date.getYear()+1900));
            DAO.update("LUONG", "tongluong="+(luongcung-ungluong),"idNV="+idNV+" and luongthang="+(date.getMonth()+1)+" and nam="+(date.getYear()+1900));
        }
        }catch (SQLException ex) {
            System.err.println("Tinh luong err: " + ex);
        }
//load table
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();

            Object[] columm = {"ID", "Tên NV", "Tổng giờ làm", "Ứng lương", "Tổng lương", "Ghi chú"};
            DefaultTableModel model = new DefaultTableModel();

            //SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
                //String strDate = dateFormat.format(jTable1.getValueAt(i, 4));

            //model = (DefaultTableModel) bangdanhsachtk.getModel();
            model.setColumnIdentifiers(columm);
            bangluong.setModel(model);
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();

                String sqlgetdatayear = "select YEAR(timevao) AS getyy from BANGLUONG group by YEAR(timevao)";
                String yearseach = "";
                ResultSet gety = statement.executeQuery(sqlgetdatayear);
                while (gety.next()) {
                    yearseach = gety.getString("getyy");
                    list_search_year.addItem(yearseach);
                    //jComboBox3.setSelectedItem(yearseach);
                }

                String sql1 = "select NHANVIEN.idNV,NHANVIEN.tenNV,tongluong,tamung,tongthoigian,ghichu from LUONG,NHANVIEN where LUONG.idNV=NHANVIEN.idNV and NHANVIEN.loaiNV='true'";
                ResultSet rs;
                rs = statement.executeQuery(sql1);

                Object[] rows = new Object[10];
                while (rs.next()) {
                    //System.out.println(rows[0]);
                    rows[0] = rs.getInt("idNV");
                    rows[1] = rs.getString("tenNV");
                    rows[2] = rs.getInt("tongthoigian");
                    rows[3] = rs.getInt("tamung");
                    rows[4] = rs.getInt("tongluong");
                    rows[5] = rs.getString("ghichu");

                    model.addRow(rows);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bangluong = new javax.swing.JTable();
        inexcel = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        editbangluong = new javax.swing.JButton();
        list_search_month = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_search = new javax.swing.JButton();
        list_search_year = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 72));
        jLabel1.setText("Bảng lương nhân viên Fulltime");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 27, 72));
        jLabel2.setText("Tháng");

        jScrollPane1.setForeground(new java.awt.Color(0, 27, 72));

        bangluong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MSNV", "Tên NV", "Lương cứng", "Tổng thời gian", "Ứng lương", "Tổng lương", "Ghi chú"
            }
        ));
        bangluong.setRowHeight(20);
        jScrollPane1.setViewportView(bangluong);

        inexcel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        inexcel.setForeground(new java.awt.Color(0, 27, 72));
        inexcel.setText("In Excel");

        cancel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cancel.setForeground(new java.awt.Color(0, 27, 72));
        cancel.setText("Đóng");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 27, 72));
        jLabel5.setText("Tìm kiếm theo:");

        editbangluong.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        editbangluong.setForeground(new java.awt.Color(0, 27, 72));
        editbangluong.setText("Chỉnh sửa");
        editbangluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbangluongActionPerformed(evt);
            }
        });

        list_search_month.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        list_search_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                list_search_monthActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 27, 72));
        jLabel3.setText("Năm");

        jButton1.setText("Xem chi tiết");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_search.setText("Tìm");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 293, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(editbangluong, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inexcel, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(list_search_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(list_search_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(btn_search)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(15, 15, 15)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(list_search_month, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(list_search_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_search))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inexcel)
                    .addComponent(editbangluong)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void list_search_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_list_search_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_list_search_monthActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        bangluongnv z = new bangluongnv();
        z.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) bangluong.getModel();
        int i = -1;
        i = bangluong.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần xem chi tiết lương !!!");
        } else {
            z.setLocationRelativeTo(null);
            z.setVisible(true);
            z.loadTable((int) bangluong.getValueAt(i, 0));
            z.setidan((int) bangluong.getValueAt(i, 0));
            //z.hidebutton();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void editbangluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbangluongActionPerformed
        // TODO add your handling code here:
        chinhsuabangluon z = new chinhsuabangluon();
        z.setLocationRelativeTo(null);
        z.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) bangluong.getModel();
        int i = -1;
        i = bangluong.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần chỉnh sửa !!!");
        } else {
            z.setLocationRelativeTo(null);
            z.setVisible(true);
            
            z.setid((int) model.getValueAt(i, 0));
            z.settennv((String) model.getValueAt(i, 1));
            z.settonggiocon((int) model.getValueAt(i, 2));
            z.setungluong((int) model.getValueAt(i,3));
            z.settongluong((int) model.getValueAt(i, 4));
            z.setghichu((String) model.getValueAt(i, 5));
            
            z.hideid();
            z.hideten();
            z.hidetonggio();
            z.hidetongluong();
            
        }
    }//GEN-LAST:event_editbangluongActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        try {
            Object[] columm = {"ID", "Tên NV", "Tổng giờ làm", "Ứng lương", "Tổng lương", "Ghi chú"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columm);
            bangluong.setModel(model);
            
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                Object[] rows = new Object[6];
                ResultSet rs3;
                String txt_search="SELECT L.idNV,NV.tenNV,L.tongthoigian,L.tamung,L.tongluong,L.ghichu FROM LUONG L join NHANVIEN NV on L.idNV=NV.idNV "
                        + "WHERE NV.loaiNV=1 AND L.luongthang="+list_search_month.getSelectedItem()+" and nam="+list_search_month.getSelectedItem();
                rs3= statement.executeQuery(txt_search);
                while (rs3.next()) {
                    rows[0] = rs3.getInt(1);
                    rows[1] = rs3.getString(2);
                    rows[2] = rs3.getInt(3);
                    rows[3] = rs3.getInt(4);
                    rows[4] = rs3.getInt(5);
                    rows[5] = rs3.getString(6);

                    model.addRow(rows);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }//GEN-LAST:event_btn_searchActionPerformed
    public void loadTable(int i) {
        
        //load table here
        try {
            Object[] columm = {"Giờ vào", "Giờ ra", "Ghi chú"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columm);
            bangluong.setModel(model);
            
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();

            //SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
                //String strDate = dateFormat.format(jTable1.getValueAt(i, 4));

            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                String sql1 = "select * from BANGLUONG where idNV =" + i;
                ResultSet rs;
                rs = statement.executeQuery(sql1);

                String str1 = "", str2 = "", str = "";
                Object[] rows = new Object[10];
                while (rs.next()) {
                        //System.out.println(rows[0]);

                    str1 = dateFormat.format(rs.getTime("timevao"));
                    String[] output = str1.split(" ");
                    str1 = output[0];
                    str2 = dateFormat.format(rs.getDate("timevao"));
                    output = str2.split(" ");
                    str2 = output[1];
                    str = str1 + " " + str2;
                    rows[0] = str;
                        //System.out.println(rows[2]);

                    str1 = dateFormat.format(rs.getTime("timera"));
                    output = str1.split(" ");
                    str1 = output[0];
                    str2 = dateFormat.format(rs.getDate("timera"));
                    output = str2.split(" ");
                    str2 = output[1];
                    str = str1 + " " + str2;
                    rows[1] = str;
                    //System.out.println(rows[1]);
                    rows[2] = rs.getString("ghichu");
                    model.addRow(rows);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Load table err: " + ex);
        }
    }
    
    public static float tinhtongtime(int idNV, int thang){
        float tong_time=0;
        Date date=new Date();
        ResultSet res;
        res = DAO.select("*","BANGLUONG",String.format("idNV=%d",idNV));    //lấy thông tin từ bảng lương
        try {
            while (res.next()){
                if ( parseInt(NativeString.substring(res.getString(2), 5, 7))==thang && 
                        parseInt(NativeString.substring(res.getString(2), 0, 4))==date.getYear()+1900){   //tách tháng 
                    int split_hour_in=parseInt(NativeString.substring(res.getString(2), 11, 13));   //lấy time vào
                    int split_hour_out=parseInt(NativeString.substring(res.getString(3), 11, 13));  //lấy time ra
                    
                    int split_minute_in=parseInt(NativeString.substring(res.getString(2), 14, 16)); //lấy time vào
                    int split_minute_out=parseInt(NativeString.substring(res.getString(3), 14, 16));    //lấy time ra
                    
                    tong_time+=(split_hour_out-split_hour_in)+(split_minute_out-split_minute_in)*1.0/60;    //time tính theo giờ
//                    System.out.format("%d %s %s \n",res.getInt(1),res.getString(2),res.getString(3));
                }
            }
        } catch (SQLException ex) {
            System.err.print("Lỗi tính tổng time: "+ex);
        }
        System.out.print(tong_time);
        return tong_time;
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
            java.util.logging.Logger.getLogger(bangluongnhanvienfulltime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bangluongnhanvienfulltime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bangluongnhanvienfulltime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bangluongnhanvienfulltime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                bangluongnhanvienfulltime z = new bangluongnhanvienfulltime();
                z.setLocationRelativeTo(null);
                z.loadTable();
                z.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable bangluong;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton cancel;
    private javax.swing.JButton editbangluong;
    private javax.swing.JButton inexcel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox list_search_month;
    private static javax.swing.JComboBox list_search_year;
    // End of variables declaration//GEN-END:variables
}
