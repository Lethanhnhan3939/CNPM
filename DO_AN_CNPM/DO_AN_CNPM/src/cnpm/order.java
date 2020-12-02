/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tkgd;

import DAO.DAO;
import cnpm.ThanhToan;
import cnpm.chucnang;
import cnpm.dangnhap;
import cnpm.ordersanpham;
import cnpm.table;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import cnpm.datban;
import cnpm.shownhacnho;

/**
 *
 * @author emipham
 */
public class order extends javax.swing.JFrame {

    int idNV;

    /**
     * Creates new form order
     */
    public order() {
        initComponents();
        String str = "select * from MONAN";
        loaddsmonan(str);
        hidebuttonsearch();
        hidechucnang();
        btndatban.setEnabled(false);
        int status;
        for (int i = 1; i <= 12; i++) {
            status = getstatus(i);
            if (status == 0) {
                if (i == 1) {
                    ban1.setBackground(Color.white);
                }
                if (i == 2) {
                    ban2.setBackground(Color.white);
                }
                if (i == 3) {
                    ban3.setBackground(Color.white);
                }
                if (i == 4) {
                    ban4.setBackground(Color.white);
                }
                if (i == 5) {
                    ban5.setBackground(Color.white);
                }
                if (i == 6) {
                    ban6.setBackground(Color.white);
                }
                if (i == 7) {
                    ban7.setBackground(Color.white);
                }
                if (i == 8) {
                    ban8.setBackground(Color.white);
                }
                if (i == 9) {
                    ban9.setBackground(Color.white);
                }
                if (i == 10) {
                    ban10.setBackground(Color.white);
                }
                if (i == 11) {
                    ban11.setBackground(Color.white);
                }
                if (i == 12) {
                    ban12.setBackground(Color.white);
                }
            } else if (status == 1) {
                if (i == 1) {
                    ban1.setBackground(Color.red);
                }
                if (i == 2) {
                    ban2.setBackground(Color.red);
                }
                if (i == 3) {
                    ban3.setBackground(Color.red);
                }
                if (i == 4) {
                    ban4.setBackground(Color.red);
                }
                if (i == 5) {
                    ban5.setBackground(Color.red);
                }
                if (i == 6) {
                    ban6.setBackground(Color.red);
                }
                if (i == 7) {
                    ban7.setBackground(Color.red);
                }
                if (i == 8) {
                    ban8.setBackground(Color.red);
                }
                if (i == 9) {
                    ban9.setBackground(Color.red);
                }
                if (i == 10) {
                    ban10.setBackground(Color.red);
                }
                if (i == 11) {
                    ban11.setBackground(Color.red);
                }
                if (i == 12) {
                    ban12.setBackground(Color.red);
                }
            } else if (status == 2) {
                if (i == 1) {
                    ban1.setBackground(Color.yellow);
                }
                if (i == 2) {
                    ban2.setBackground(Color.yellow);
                }
                if (i == 3) {
                    ban3.setBackground(Color.yellow);
                }
                if (i == 4) {
                    ban4.setBackground(Color.yellow);
                }
                if (i == 5) {
                    ban5.setBackground(Color.yellow);
                }
                if (i == 6) {
                    ban6.setBackground(Color.yellow);
                }
                if (i == 7) {
                    ban7.setBackground(Color.yellow);
                }
                if (i == 8) {
                    ban8.setBackground(Color.yellow);
                }
                if (i == 9) {
                    ban9.setBackground(Color.yellow);
                }
                if (i == 10) {
                    ban10.setBackground(Color.yellow);
                }
                if (i == 11) {
                    ban11.setBackground(Color.yellow);
                }
                if (i == 12) {
                    ban12.setBackground(Color.yellow);
                }
            } else if (status == 3) {
                if (i == 1) {
                    ban1.setBackground(Color.green);
                }
                if (i == 2) {
                    ban2.setBackground(Color.green);
                }
                if (i == 3) {
                    ban3.setBackground(Color.green);
                }
                if (i == 4) {
                    ban4.setBackground(Color.green);
                }
                if (i == 5) {
                    ban5.setBackground(Color.green);
                }
                if (i == 6) {
                    ban6.setBackground(Color.green);
                }
                if (i == 7) {
                    ban7.setBackground(Color.green);
                }
                if (i == 8) {
                    ban8.setBackground(Color.green);
                }
                if (i == 9) {
                    ban9.setBackground(Color.green);
                }
                if (i == 10) {
                    ban10.setBackground(Color.green);
                }
                if (i == 11) {
                    ban11.setBackground(Color.green);
                }
                if (i == 12) {
                    ban12.setBackground(Color.green);
                }
            }
        }
        loadtabletrong();

    }

    public void setnametable(String str) {
        nametable.setText(str);
    }

    public static String getnametable() {
        return nametable.getText();
    }

    public void settennguoidung(String s) {
        tennguoidung.setText(s);
    }

    public String gettennguoidung() {
        return tennguoidung.getText();
    }

    public void setidNV(int id) {
        this.idNV = id;
    }

    public void loaddsmonan(String str) {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();

            Object[] columm = {"Tên món ăn", "Đơn vị tính", "Giá tiền"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columm);
            menu.setModel(model);
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                //String sql1 = "select * from MONAN";
                ResultSet rs;
                rs = statement.executeQuery(str);

                Object[] rows = new Object[10];
                while (rs.next()) {
                    //System.out.println(rows[0]);
                    rows[0] = rs.getString("tenMonAn");
                    rows[1] = rs.getString("donvitinh");
                    rows[2] = rs.getInt("gia");
                    model.addRow(rows);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Loaddsmonan error, " + ex);
        }
    }

    public static void addrowtotable(Object[] rows) {
        DefaultTableModel model = (DefaultTableModel) bangmonorder.getModel();
        model.addRow(rows);
    }

    public static void loadtabletrong() {
        Object[] columm = {"Tên món ăn", "Giá bán", "Số lượng", "Giờ gọi", "Thành tiền", "Ghi chú"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columm);
        bangmonorder.setModel(model);
        //txtf__tongtien.setText("0");
        settongtien("0");
        hidechucnang();
    }

    public static void hidechucnang() {
        gopban.setEnabled(false);
        tachmon.setEnabled(false);
       // inmon.setEnabled(false);
        chuyenban.setEnabled(false);
        xoamon.setEnabled(false);
    }

    public static void showchucnang() {
        gopban.setEnabled(true);
        tachmon.setEnabled(true);
        inmon.setEnabled(true);
        chuyenban.setEnabled(true);
        xoamon.setEnabled(true);
        btndatban.setEnabled(false);
    }

    public void loadtableban(int i) {
        showchucnang();
        int tinhtien = 0;
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();

            Object[] columm = {"Tên món ăn", "Giá bán", "Số lượng", "Giờ gọi", "Thành tiền", "Ghi chú"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columm);
            bangmonorder.setModel(model);
            if (conn != null) {
                System.out.println("Connected");

                String sss = "delete from BAN where id='" + i + "' and thanhtien=0";
                boolean checksss;
                checksss = statement.execute(sss);

                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                String sql = "select * from BAN where id='" + i + "'";
                ResultSet rs;
                rs = statement.executeQuery(sql);

                Object[] rows = new Object[10];
                while (rs.next()) {
                    //System.out.println(rows[0]);
                    rows[0] = rs.getString("tenmon");
                    rows[1] = rs.getInt("gia");
                    rows[2] = rs.getInt("soluong");
                    String tam = rs.getString("giogoi");
                    String[] output = tam.split(":");
                    String tientheo = output[2];
                    String layne = "";
                    for (int j = 0; j < 2; j++) {
                        layne = layne + tientheo.charAt(j);
                    }
                    tam = output[0] + ":" + output[1] + ":" + layne;
                    //System.out.println(tam);
                    rows[3] = tam;//rs.getString("giogoi");
                    rows[4] = rs.getInt("thanhtien");
                    rows[5] = rs.getString("ghichu");

                    tinhtien += rs.getInt("thanhtien");

                    model.addRow(rows);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
        settongtien(String.valueOf(tinhtien));
    }

    public boolean themmon(String update) {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();

            Object[] columm = {"Tên món ăn", "Giá bán", "Số lượng", "Giờ gọi", "Thành tiền", "Ghi chú"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columm);
            bangmonorder.setModel(model);
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();

                boolean checked;
                checked = statement.execute(update);
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
        return false;
    }

    public void deletetable(int i) {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();

            Object[] columm = {"Tên món ăn", "Giá bán", "Số lượng", "Giờ gọi", "Thành tiền", "Ghi chú"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columm);
            bangmonorder.setModel(model);
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();

                boolean checked;
                checked = statement.execute("delete from BAN where id='" + i + "'");
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        bangmonorder = new javax.swing.JTable();
        gopban = new javax.swing.JButton();
        thanhtoan = new javax.swing.JButton();
        chuyenban = new javax.swing.JButton();
        inmon = new javax.swing.JButton();
        xoamon = new javax.swing.JButton();
        tachmon = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        ban5 = new javax.swing.JButton();
        ban1 = new javax.swing.JButton();
        ban6 = new javax.swing.JButton();
        ban9 = new javax.swing.JButton();
        ban7 = new javax.swing.JButton();
        ban2 = new javax.swing.JButton();
        ban3 = new javax.swing.JButton();
        ban4 = new javax.swing.JButton();
        ban10 = new javax.swing.JButton();
        ban11 = new javax.swing.JButton();
        ban12 = new javax.swing.JButton();
        ban8 = new javax.swing.JButton();
        btndatban = new javax.swing.JButton();
        tennguoidung = new javax.swing.JTextField();
        inhoadon = new javax.swing.JButton();
        searchname = new javax.swing.JTextField();
        btn_exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        searchbutton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_thuc_uong = new javax.swing.JButton();
        btn_mon_an = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        menu = new javax.swing.JTable();
        txtf__tongtien = new javax.swing.JTextField();
        nametable = new javax.swing.JLabel();
        btn_thoat_ban = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ORDER");
        setBackground(new java.awt.Color(204, 204, 204));
        setSize(new java.awt.Dimension(1000, 700));

        bangmonorder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bangmonorder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên món ăn", "Giá bán", "Số lượng", "Giờ gọi", "Thành tiền", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        bangmonorder.setRowHeight(20);
        jScrollPane3.setViewportView(bangmonorder);
        if (bangmonorder.getColumnModel().getColumnCount() > 0) {
            bangmonorder.getColumnModel().getColumn(0).setMinWidth(200);
            bangmonorder.getColumnModel().getColumn(2).setMinWidth(10);
        }

        gopban.setForeground(new java.awt.Color(0, 27, 72));
        gopban.setText("Gộp bàn");
        gopban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gopbanActionPerformed(evt);
            }
        });

        thanhtoan.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        thanhtoan.setForeground(new java.awt.Color(0, 27, 72));
        thanhtoan.setText("THANH TOÁN");
        thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thanhtoanActionPerformed(evt);
            }
        });

        chuyenban.setForeground(new java.awt.Color(0, 27, 72));
        chuyenban.setText("Chuyển bàn");
        chuyenban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chuyenbanActionPerformed(evt);
            }
        });

        inmon.setForeground(new java.awt.Color(0, 27, 72));
        inmon.setText("Lịch đặt bàn");
        inmon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inmonActionPerformed(evt);
            }
        });

        xoamon.setForeground(new java.awt.Color(0, 27, 72));
        xoamon.setText("Xóa order");
        xoamon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoamonActionPerformed(evt);
            }
        });

        tachmon.setForeground(new java.awt.Color(0, 27, 72));
        tachmon.setText("Tách món");
        tachmon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tachmonActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255)));

        ban5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban5.setForeground(new java.awt.Color(0, 27, 72));
        ban5.setText("BÀN 5");
        ban5.setPreferredSize(new java.awt.Dimension(50, 50));
        ban5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban5ActionPerformed(evt);
            }
        });

        ban1.setBackground(new java.awt.Color(176, 170, 172));
        ban1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban1.setForeground(new java.awt.Color(0, 27, 72));
        ban1.setText("BÀN 1");
        ban1.setPreferredSize(new java.awt.Dimension(50, 50));
        ban1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban1ActionPerformed(evt);
            }
        });

        ban6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban6.setForeground(new java.awt.Color(0, 27, 72));
        ban6.setText("BÀN 6");
        ban6.setPreferredSize(new java.awt.Dimension(50, 50));
        ban6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban6ActionPerformed(evt);
            }
        });

        ban9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban9.setForeground(new java.awt.Color(0, 27, 72));
        ban9.setText("BÀN 9");
        ban9.setPreferredSize(new java.awt.Dimension(50, 50));
        ban9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban9ActionPerformed(evt);
            }
        });

        ban7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban7.setForeground(new java.awt.Color(0, 27, 72));
        ban7.setText("BÀN 7");
        ban7.setPreferredSize(new java.awt.Dimension(50, 50));
        ban7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban7ActionPerformed(evt);
            }
        });

        ban2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban2.setForeground(new java.awt.Color(0, 27, 72));
        ban2.setText("BÀN 2");
        ban2.setPreferredSize(new java.awt.Dimension(50, 50));
        ban2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban2ActionPerformed(evt);
            }
        });

        ban3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban3.setForeground(new java.awt.Color(0, 27, 72));
        ban3.setText("BÀN 3");
        ban3.setPreferredSize(new java.awt.Dimension(50, 50));
        ban3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban3ActionPerformed(evt);
            }
        });

        ban4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban4.setForeground(new java.awt.Color(0, 27, 72));
        ban4.setText("BÀN 4");
        ban4.setPreferredSize(new java.awt.Dimension(50, 50));
        ban4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban4ActionPerformed(evt);
            }
        });

        ban10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban10.setForeground(new java.awt.Color(0, 27, 72));
        ban10.setText("BÀN 10");
        ban10.setPreferredSize(new java.awt.Dimension(50, 50));
        ban10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban10ActionPerformed(evt);
            }
        });

        ban11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban11.setForeground(new java.awt.Color(0, 27, 72));
        ban11.setText("BÀN 11");
        ban11.setPreferredSize(new java.awt.Dimension(50, 50));
        ban11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban11ActionPerformed(evt);
            }
        });

        ban12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban12.setForeground(new java.awt.Color(0, 27, 72));
        ban12.setText("BÀN 12");
        ban12.setPreferredSize(new java.awt.Dimension(50, 50));
        ban12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban12ActionPerformed(evt);
            }
        });

        ban8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ban8.setForeground(new java.awt.Color(0, 27, 72));
        ban8.setText("BÀN 8");
        ban8.setPreferredSize(new java.awt.Dimension(50, 50));
        ban8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ban8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ban7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(ban10, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ban8, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(ban11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ban4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ban1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ban5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ban2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ban9, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(ban12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ban6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ban3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ban1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ban2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ban3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ban4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ban5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ban6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ban9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ban7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ban8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ban12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ban11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ban10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(445, 445, 445))
        );

        jScrollPane1.setViewportView(jPanel4);

        btndatban.setForeground(new java.awt.Color(0, 27, 72));
        btndatban.setText("Đặt bàn");
        btndatban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatbanActionPerformed(evt);
            }
        });

        tennguoidung.setEditable(false);
        tennguoidung.setText("tên user");

        inhoadon.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        inhoadon.setForeground(new java.awt.Color(0, 27, 72));
        inhoadon.setText("IN HÓA ĐƠN");
        inhoadon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inhoadonActionPerformed(evt);
            }
        });

        searchname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchname.setText("Tìm kiếm món ăn");
        searchname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchnameMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                searchnameMousePressed(evt);
            }
        });
        searchname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchnameKeyReleased(evt);
            }
        });

        btn_exit.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_exit.setForeground(new java.awt.Color(255, 0, 0));
        btn_exit.setText("THOÁT");
        btn_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_exitActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 72));
        jLabel1.setText("BÁN HÀNG");

        searchbutton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchbutton.setForeground(new java.awt.Color(0, 27, 72));
        searchbutton.setText("Tìm kiếm");
        searchbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbuttonActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("VNĐ");

        btn_thuc_uong.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_thuc_uong.setText("Thức uống");
        btn_thuc_uong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thuc_uongActionPerformed(evt);
            }
        });

        btn_mon_an.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_mon_an.setText("Món ăn");
        btn_mon_an.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mon_anActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 27, 72));
        jLabel3.setText("TỔNG TIỀN");

        menu.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        menu.setModel(new javax.swing.table.DefaultTableModel(
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
                "Tên", "Giá"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(menu);
        if (menu.getColumnModel().getColumnCount() > 0) {
            menu.getColumnModel().getColumn(1).setMinWidth(100);
            menu.getColumnModel().getColumn(1).setPreferredWidth(50);
            menu.getColumnModel().getColumn(1).setMaxWidth(50);
        }

        txtf__tongtien.setEditable(false);
        txtf__tongtien.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtf__tongtien.setText("                                                     0");
        txtf__tongtien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtf__tongtienActionPerformed(evt);
            }
        });

        nametable.setText("BÀN ");

        btn_thoat_ban.setText("Thoát bàn");
        btn_thoat_ban.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoat_banActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(btn_thuc_uong, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btn_mon_an, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(searchname, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtf__tongtien, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(inhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btndatban, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(chuyenban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(42, 42, 42)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(thanhtoan))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(inmon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(tachmon, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(xoamon, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                    .addComponent(gopban, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(nametable)
                                .addGap(38, 38, 38)
                                .addComponent(btn_thoat_ban)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(567, 567, 567)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(tennguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)
                        .addGap(353, 353, 353)))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(12, 20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(nametable)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tennguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_thoat_ban))
                                .addGap(3, 3, 3)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtf__tongtien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(searchname, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(inhoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(thanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(xoamon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inmon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btndatban, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(54, 54, 54)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(chuyenban, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tachmon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gopban, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btn_mon_an, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                                    .addComponent(btn_thuc_uong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 26, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbuttonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchbuttonActionPerformed

    private void ban8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban8ActionPerformed
        // TODO add your handling code here:
        setnametable(ban8.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(8) != 0 && getstatus(8) != 1) {
            loadtableban(8);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(8) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(8) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
    }//GEN-LAST:event_ban8ActionPerformed

    private void gopbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gopbanActionPerformed
        // TODO add your handling code here:
        chucnang z = new chucnang();
        z.setVisible(true);
        z.setLocationRelativeTo(null);
        z.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        z.setbanchuyen(nametable.getText());
        String tenbanchuyen = nametable.getText();
        String[] tach = tenbanchuyen.split(" ");
        z.loadtablebanleft(Integer.parseInt(tach[1]));
        z.setcombobox(1);
        z.hideketthuc();
    }//GEN-LAST:event_gopbanActionPerformed

    private void inhoadonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inhoadonActionPerformed
        // TODO add your handling code here:

        if (nametable.getText().equals("BÀN ")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần in hóa đón");
        } else if (txtf__tongtien.getText().equals("0")) {
            JOptionPane.showMessageDialog(this, "Không thể xuất hóa đơn !!!");
        } else {
            String tiendeptrai = nametable.getText();
            String[] wtd = tiendeptrai.split(" ");
            int wtdude = Integer.parseInt(wtd[1]);
            String sql = "update BAN "
                    + "set trangthai = '" + 3 + "'"
                    + "where id = '" + wtdude + "'";
            try {
                String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
                Connection conn = DriverManager.getConnection(dbURL);
                Statement statement = conn.createStatement();
                if (conn != null) {

                    boolean check;

                    check = statement.execute(sql);
                    setmuaxang(wtdude);
                }
                conn.close();
            } catch (SQLException ex) {
                System.err.println("Cannot connect database, " + ex);
            }
        }

    }//GEN-LAST:event_inhoadonActionPerformed

    private void btn_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_exitActionPerformed
        // TODO add your handling code here:

        String name = this.gettennguoidung();
        String[] output = name.split(":");
        if (output[0].equals("Quản lí ")) {
            this.dispose();
        } else {
            dangnhap z = new dangnhap();
            z.setVisible(true);
            z.setLocationRelativeTo(null);
            z.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            this.dispose();
        }
    }//GEN-LAST:event_btn_exitActionPerformed

    private void ban1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban1ActionPerformed
        // TODO add your handling code here:
        setnametable(ban1.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(1) != 0 && getstatus(1) != 1) {
            loadtableban(1);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(1) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(1) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }

//        table bann1 = new table();
//        int st = bann1.getstatus() + 1;
//        System.out.println(st);
//        if (st == 1) {
//            bann1.setstatus(st);
//            //[255,153,0]
//            ban1.setBackground(new java.awt.Color(255, 153, 0));
//        } else if (st == 2) {
//            bann1.setstatus(st);
//            //[204,255,204]
//            ban1.setBackground(new java.awt.Color(204, 255, 204));
//        } else if (st == 3) {
//            bann1.setstatus(st);
//            ban1.setBackground(new java.awt.Color(176,170,172));
//        } else {
//            ban1.setBackground(Color.WHITE);
//            bann1.setstatus(0);
//        }
    }//GEN-LAST:event_ban1ActionPerformed
    public void settablename(String str) {
        nametable.setText(str);
    }
    private void searchnameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchnameMouseClicked
        // TODO add your handling code here:
        searchname.setText("");
    }//GEN-LAST:event_searchnameMouseClicked

    private void searchnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchnameKeyReleased
        // TODO add your handling code here:
        String s = searchname.getText();
        String sql = "select * from MONAN where (tenMonAn like N'%" + s + "%' or donvitinh like N'%" + s + "%' or gia like '%" + s + "%') and trangthai='1' ";

        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();

            Object[] columm = {"Tên món ăn", "Đơn vị tính", "Giá tiền"};
            DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columm);
            menu.setModel(model);
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                //String sql1 = "select * from MONAN";
                ResultSet rs;
                rs = statement.executeQuery(sql);

                Object[] rows = new Object[10];
                while (rs.next()) {
                    //System.out.println(rows[0]);
                    rows[0] = rs.getString("tenMonAn");
                    rows[1] = rs.getString("donvitinh");
                    rows[2] = rs.getInt("gia");
                    model.addRow(rows);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }

        System.out.println(searchname.getText());
    }//GEN-LAST:event_searchnameKeyReleased

    private void btn_thuc_uongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thuc_uongActionPerformed
        // TODO add your handling code here:
        String sql = "select * from MONAN where loai=1 and trangthai=1 ";
        loaddsmonan(sql);
    }//GEN-LAST:event_btn_thuc_uongActionPerformed

    private void btn_mon_anActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mon_anActionPerformed
        // TODO add your handling code here:
        String sql = "select * from MONAN where loai=0 and trangthai=1 ";
        loaddsmonan(sql);
    }//GEN-LAST:event_btn_mon_anActionPerformed

    private void ban2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban2ActionPerformed
        // TODO add your handling code here:
        setnametable(ban2.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(2) != 0 && getstatus(2) != 1) {
            loadtableban(2);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(2) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(2) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }


    }//GEN-LAST:event_ban2ActionPerformed

    private void ban3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban3ActionPerformed
        // TODO add your handling code here:
        setnametable(ban3.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(3) != 0 && getstatus(3) != 1) {
            loadtableban(3);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(3) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(3) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }

    }//GEN-LAST:event_ban3ActionPerformed

    private void ban4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban4ActionPerformed
        // TODO add your handling code here:
        setnametable(ban4.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(4) != 0 && getstatus(4) != 1) {
            loadtableban(4);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(4) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(4) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
    }//GEN-LAST:event_ban4ActionPerformed

    private void ban5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban5ActionPerformed
        // TODO add your handling code here:
        setnametable(ban5.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(5) != 0 && getstatus(5) != 1) {
            loadtableban(5);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(5) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(5) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
    }//GEN-LAST:event_ban5ActionPerformed

    private void ban6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban6ActionPerformed
        // TODO add your handling code here:
        setnametable(ban6.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(6) != 0 && getstatus(6) != 1) {
            loadtableban(6);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(6) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(6) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
    }//GEN-LAST:event_ban6ActionPerformed

    private void xoamonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoamonActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) bangmonorder.getModel();
        int i = bangmonorder.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn lần order cần xóa !!!");
        } else {
            //System.out.println(model.getValueAt(i, 3));
            String layban=nametable.getText();
            String[] catlayban=layban.split(" ");
            boolean kiemtra=false;
            String str2="";
            if(i==0)
            {
                kiemtra=true;
                str2 = "insert into BAN(id,trangthai,thanhtien) values('"+catlayban[1]+"',0,0)";
            }
            try {
                String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
                Connection conn = DriverManager.getConnection(dbURL);
                Statement statement = conn.createStatement();
                if (conn != null) {
                    String sql="delete from BAN where giogoi='"+model.getValueAt(i, 3)+"'";
                    boolean check=statement.execute(sql);
                    JOptionPane.showMessageDialog(this,"Xóa order thành công ");
                    if(kiemtra==true)
                    {
                        check=statement.execute(str2);
                        loadtabletrong();
                        setmuatrang(Integer.parseInt(catlayban[1]));
                        hidechucnang();
                        btndatban.setEnabled(true);
                    }
                }
            } catch (SQLException ex) {
                System.err.println("CNPM Main cannot connect database, " + ex);
            }
            model.removeRow(i);
            System.out.println(i);
        }
        //System.out.println(i+" ");
    }//GEN-LAST:event_xoamonActionPerformed

    private void searchnameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchnameMousePressed
        // TODO add your handling code here:
        searchname.setText("");
    }//GEN-LAST:event_searchnameMousePressed

    private void txtf__tongtienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtf__tongtienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtf__tongtienActionPerformed

    private void ban7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban7ActionPerformed
        // TODO add your handling code here:
        setnametable(ban7.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(7) != 0 && getstatus(7) != 1) {
            loadtableban(7);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(7) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(7) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
    }//GEN-LAST:event_ban7ActionPerformed

    private void btn_thoat_banActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoat_banActionPerformed
        // TODO add your handling code here:
        nametable.setText("BÀN ");
        Object[] columm = {"Tên món ăn", "Giá bán", "Số lượng", "Giờ gọi", "Thành tiền", "Ghi chú"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columm);
        bangmonorder.setModel(model);
        hidechucnang();
        btndatban.setEnabled(false);
        btn_thoat_ban.setVisible(false);
        settongtien("0");
    }//GEN-LAST:event_btn_thoat_banActionPerformed

    private void btndatbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatbanActionPerformed
        // TODO add your handling code here:
        if(getquyenuser().equals("Nhân viên"))
        {
            String str=btndatban.getText();
            JOptionPane.showMessageDialog(this,"Bạn không có quyên '"+str+"'!!!");
            return;
        }
        String tam = nametable.getText();
        String[] out = tam.split(" ");
        String str;
        int i = Integer.parseInt(out[1]);
        System.out.println(i);
        if (btndatban.getText().equals("Đặt bàn")) {
            setstatus(i, 1);
            btndatban.setText("Hủy bàn");
            if (i == 1) {
                ban1.setBackground(Color.red);
            }
            if (i == 2) {
                ban2.setBackground(Color.red);
            }
            if (i == 3) {
                ban3.setBackground(Color.red);
            }
            if (i == 4) {
                ban4.setBackground(Color.red);
            }
            if (i == 5) {
                ban5.setBackground(Color.red);
            }
            if (i == 6) {
                ban6.setBackground(Color.red);
            }
            if (i == 7) {
                ban7.setBackground(Color.red);
            }
            if (i == 8) {
                ban8.setBackground(Color.red);
            }
            if (i == 9) {
                ban9.setBackground(Color.red);
            }
            if (i == 10) {
                ban10.setBackground(Color.red);
            }
            if (i == 11) {
                ban11.setBackground(Color.red);
            }
            if (i == 12) {
                ban12.setBackground(Color.red);
            }
        } else {
            setstatus(i, 0);
            btndatban.setText("Đặt bàn");
            if (i == 1) {
                ban1.setBackground(Color.white);
            }
            if (i == 2) {
                ban2.setBackground(Color.white);
            }
            if (i == 3) {
                ban3.setBackground(Color.white);
            }
            if (i == 4) {
                ban4.setBackground(Color.white);
            }
            if (i == 5) {
                ban5.setBackground(Color.white);
            }
            if (i == 6) {
                ban6.setBackground(Color.white);
            }
            if (i == 7) {
                ban7.setBackground(Color.white);
            }
            if (i == 8) {
                ban8.setBackground(Color.white);
            }
            if (i == 9) {
                ban9.setBackground(Color.white);
            }
            if (i == 10) {
                ban10.setBackground(Color.white);
            }
            if (i == 11) {
                ban11.setBackground(Color.white);
            }
            if (i == 12) {
                ban12.setBackground(Color.white);
            }
        }
    }//GEN-LAST:event_btndatbanActionPerformed

    private void inmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inmonActionPerformed
        // TODO add your handling code here:
        shownhacnho z = new  shownhacnho();
        z.setVisible(true);
        z.setLocationRelativeTo(null);
        z.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }//GEN-LAST:event_inmonActionPerformed

    private void menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuMouseClicked
        // TODO add your handling code here:
        ordersanpham z = new ordersanpham();
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) menu.getModel();
        if (getnametable().equals("BÀN ")) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần gọi món !!!");
        } else {

            String yy = getnametable();
            String[] ou = yy.split(" ");
            //int y=Integer.parseInt(ou[1]);

            int i = menu.getSelectedRow();
            z.setVisible(true);
            z.setLocationRelativeTo(null);
            z.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            String st = (String) menu.getValueAt(i, 0);
            z.setten(st);
            int gia = (int) menu.getValueAt(i, 2);
            z.setgia(gia);
            z.hide();
            z.setid(ou[1]);
        }

    }//GEN-LAST:event_menuMouseClicked

    private void ban9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban9ActionPerformed
        // TODO add your handling code here:
        setnametable(ban9.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(9) != 0 && getstatus(9) != 1) {
            loadtableban(9);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(9) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(9) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
    }//GEN-LAST:event_ban9ActionPerformed

    private void ban10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban10ActionPerformed
        // TODO add your handling code here:
        setnametable(ban10.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(10) != 0 && getstatus(10) != 1) {
            loadtableban(10);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(10) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(10) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
    }//GEN-LAST:event_ban10ActionPerformed

    private void ban11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban11ActionPerformed
        // TODO add your handling code here:
        setnametable(ban11.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(11) != 0 && getstatus(11) != 1) {
            loadtableban(11);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(11) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(11) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
    }//GEN-LAST:event_ban11ActionPerformed

    private void ban12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ban12ActionPerformed
        // TODO add your handling code here:
        setnametable(ban12.getText());
        btn_thoat_ban.setVisible(true);
        if (getstatus(12) != 0 && getstatus(12) != 1) {
            loadtableban(12);
            setdatban("Đặt bàn");
            btndatban.setEnabled(false);
        }
        if (getstatus(12) == 1) {
            loadtabletrong();
            setdatban("Hủy bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
        if (getstatus(12) == 0) {
            loadtabletrong();
            setdatban("Đặt bàn");
            btndatban.setEnabled(true);
            settongtien("0");
        }
    }//GEN-LAST:event_ban12ActionPerformed

    private void thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thanhtoanActionPerformed
        String getquyen = tennguoidung.getText();
        String[] getktquyen = getquyen.split(":");
        getquyen = getktquyen[0];
        if (getquyen.equals("Nhân viên") || getquyen.equals("Quản lí ")) {
            JOptionPane.showMessageDialog(this, "Bạn không có quyền thanh toán !!!");
        } else {
            if (getnametable().equals("BÀN ")) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn bàn cần thanh toán !!!");
            } else {
                if (!txtf__tongtien.getText().equals("0")) {
                    String ii = getnametable();
                    String[] oo = ii.split(" ");
                    int iii = Integer.parseInt(oo[1]);
                    //call ui thanh toán
                    ThanhToan tt = new ThanhToan();
                    tt.setLocationRelativeTo(null);
                    tt.setIdBan(iii);
                    tt.setTongTien(this.txtf__tongtien.getText());
                    tt.setidNV(idNV);
                    tt.setDate();
                    tt.settenNV(idNV);
                    tt.setVisible(true);
                    tt.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//                    this.setVisible(false);
//                    new order().setVisible(true);
                }
            }
        }


    }//GEN-LAST:event_thanhtoanActionPerformed

    private void chuyenbanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chuyenbanActionPerformed
        // TODO add your handling code here:
        chucnang z = new chucnang();
        z.setVisible(true);
        z.setLocationRelativeTo(null);
        z.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        z.setbanchuyen(nametable.getText());
        String tenbanchuyen = nametable.getText();
        String[] tach = tenbanchuyen.split(" ");
        z.loadtablebanleft(Integer.parseInt(tach[1]));
        z.setlabelchuyenban("Chuyển bàn");
        z.setbuttonchuyenban("Chuyển");
        z.setcombobox(0);
        z.hideketthuc();
    }//GEN-LAST:event_chuyenbanActionPerformed

    private void tachmonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tachmonActionPerformed
        // TODO add your handling code here:
        chucnang z = new chucnang();
        z.setVisible(true);
        z.setLocationRelativeTo(null);
        z.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        z.setbanchuyen(nametable.getText());
        String tenbanchuyen = nametable.getText();
        String[] tach = tenbanchuyen.split(" ");
        z.loadtablebanleft(Integer.parseInt(tach[1]));
        z.setlabelchuyenban("Tách món");
        z.setbuttonchuyenban("Tách");
        z.setcombobox(2);
        z.showketthuc();
    }//GEN-LAST:event_tachmonActionPerformed

    /**
     * @param args the command line arguments
     */
    //String [] a = new String[100];
    // mảng bàn 
    // 1 bàn 
    // load bàn lên table khi lick 
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
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(order.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //int i = ban[0].getstatus();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                order z = new order();
                z.setLocationRelativeTo(null);
                z.setVisible(true);
                String sql = "select * from MONAN";
                z.loaddsmonan(sql);
                z.hidebuttonsearch();
            }
        });
    }

    public void hidebuttonsearch() {
        searchbutton.setEnabled(false);
    }

    public static void settongtien(String str) {
        txtf__tongtien.setHorizontalAlignment(SwingConstants.RIGHT);
        txtf__tongtien.setText(str);
    }

    public static String gettongtien() {
        return txtf__tongtien.getText();
    }

    public void setdatban(String str) {
        btndatban.setText(str);
    }

    public String getdatban() {
        return btndatban.getText();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton ban1;
    private static javax.swing.JButton ban10;
    private static javax.swing.JButton ban11;
    private static javax.swing.JButton ban12;
    private static javax.swing.JButton ban2;
    private static javax.swing.JButton ban3;
    private static javax.swing.JButton ban4;
    private static javax.swing.JButton ban5;
    private static javax.swing.JButton ban6;
    private static javax.swing.JButton ban7;
    private static javax.swing.JButton ban8;
    private static javax.swing.JButton ban9;
    private static javax.swing.JTable bangmonorder;
    private javax.swing.JButton btn_exit;
    private javax.swing.JButton btn_mon_an;
    private javax.swing.JButton btn_thoat_ban;
    private javax.swing.JButton btn_thuc_uong;
    private static javax.swing.JButton btndatban;
    private static javax.swing.JButton chuyenban;
    private static javax.swing.JButton gopban;
    private javax.swing.JButton inhoadon;
    private static javax.swing.JButton inmon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable menu;
    private static javax.swing.JLabel nametable;
    private javax.swing.JButton searchbutton;
    private javax.swing.JTextField searchname;
    private static javax.swing.JButton tachmon;
    private static javax.swing.JTextField tennguoidung;
    private javax.swing.JButton thanhtoan;
    private static javax.swing.JTextField txtf__tongtien;
    private static javax.swing.JButton xoamon;
    // End of variables declaration//GEN-END:variables
    public static void setmuavang(int i) {
        if (i == 1) {
            ban1.setBackground(Color.yellow);
        }
        if (i == 2) {
            ban2.setBackground(Color.yellow);
        }
        if (i == 3) {
            ban3.setBackground(Color.yellow);
        }
        if (i == 4) {
            ban4.setBackground(Color.yellow);
        }
        if (i == 5) {
            ban5.setBackground(Color.yellow);
        }
        if (i == 6) {
            ban6.setBackground(Color.yellow);
        }
        if (i == 7) {
            ban7.setBackground(Color.yellow);
        }
        if (i == 8) {
            ban8.setBackground(Color.yellow);
        }
        if (i == 9) {
            ban9.setBackground(Color.yellow);
        }
        if (i == 10) {
            ban10.setBackground(Color.yellow);
        }
        if (i == 11) {
            ban11.setBackground(Color.yellow);
        }
        if (i == 12) {
            ban12.setBackground(Color.yellow);
        }
    }

    public static void setmuaxang(int i) {
        if (i == 1) {
            ban1.setBackground(Color.green);
        }
        if (i == 2) {
            ban2.setBackground(Color.green);
        }
        if (i == 3) {
            ban3.setBackground(Color.green);
        }
        if (i == 4) {
            ban4.setBackground(Color.green);
        }
        if (i == 5) {
            ban5.setBackground(Color.green);
        }
        if (i == 6) {
            ban6.setBackground(Color.green);
        }
        if (i == 7) {
            ban7.setBackground(Color.green);
        }
        if (i == 8) {
            ban8.setBackground(Color.green);
        }
        if (i == 9) {
            ban9.setBackground(Color.green);
        }
        if (i == 10) {
            ban10.setBackground(Color.green);
        }
        if (i == 11) {
            ban11.setBackground(Color.green);
        }
        if (i == 12) {
            ban12.setBackground(Color.green);
        }
    }

    public static void setmuatrang(int i) {
        if (i == 1) {
            ban1.setBackground(Color.white);
        }
        if (i == 2) {
            ban2.setBackground(Color.white);
        }
        if (i == 3) {
            ban3.setBackground(Color.white);
        }
        if (i == 4) {
            ban4.setBackground(Color.white);
        }
        if (i == 5) {
            ban5.setBackground(Color.white);
        }
        if (i == 6) {
            ban6.setBackground(Color.white);
        }
        if (i == 7) {
            ban7.setBackground(Color.white);
        }
        if (i == 8) {
            ban8.setBackground(Color.white);
        }
        if (i == 9) {
            ban9.setBackground(Color.white);
        }
        if (i == 10) {
            ban10.setBackground(Color.white);
        }
        if (i == 11) {
            ban11.setBackground(Color.white);
        }
        if (i == 12) {
            ban12.setBackground(Color.white);
        }
    }

    public static void tachmon(int i) {
        DefaultTableModel model = (DefaultTableModel) bangmonorder.getModel();
        int zz = (int) model.getValueAt(i, 4);
        settongtien(String.valueOf(Integer.parseInt(gettongtien()) - zz));
        model.removeRow(i);
    }

    public static int getgiamon(int i) {
        DefaultTableModel model = (DefaultTableModel) bangmonorder.getModel();
        return (int) model.getValueAt(i, 1);
    }

    public static String getgiogoi(int i) {
        DefaultTableModel model = (DefaultTableModel) bangmonorder.getModel();
        String tam = (String) model.getValueAt(i, 3);
        return tam;
    }

    public static void tachmotmon(int i, int x, int y) {
        DefaultTableModel model = (DefaultTableModel) bangmonorder.getModel();
        model.setValueAt(i, x, y);
        int giamontach = (int) model.getValueAt(x, 1);
        System.out.println(giamontach);
        int giahientai = (int) model.getValueAt(x, 4);
        System.out.println(giahientai);
        model.setValueAt(giahientai - giamontach, x, 4);
        int tongtienmoi = Integer.parseInt(gettongtien());
        tongtienmoi = tongtienmoi - giamontach;
        settongtien(String.valueOf(tongtienmoi));
    }

    public static void clickthanhtoan() {
        String getquyen = tennguoidung.getText();
        String[] getktquyen = getquyen.split(":");
        String str1 = "", str2 = "";
        getquyen = getktquyen[0];
        String ii = getnametable();
        String[] oo = ii.split(" ");
        int iii = Integer.parseInt(oo[1]);
        if (iii == 1) {
            str1 = "delete from BAN where id=1";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(1,0,0)";
            ban1.setBackground(Color.white);
        }
        if (iii == 2) {
            str1 = "delete from BAN where id=2";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(2,0,0)";
            ban2.setBackground(Color.white);
        }
        if (iii == 3) {
            str1 = "delete from BAN where id=3";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(3,0,0)";
            ban3.setBackground(Color.white);
        }
        if (iii == 4) {
            str1 = "delete from BAN where id=4";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(4,0,0)";
            ban4.setBackground(Color.white);
        }
        if (iii == 5) {
            str1 = "delete from BAN where id=5";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(5,0,0)";
            ban5.setBackground(Color.white);
        }
        if (iii == 6) {
            str1 = "delete from BAN where id=6";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(6,0,0)";
            ban6.setBackground(Color.white);
        }
        if (iii == 7) {
            str1 = "delete from BAN where id=7";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(7,0,0)";
            ban7.setBackground(Color.white);
        }
        if (iii == 8) {
            str1 = "delete from BAN where id=8";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(8,0,0)";
            ban8.setBackground(Color.white);
        }
        if (iii == 9) {
            str1 = "delete from BAN where id=9";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(9,0,0)";
            ban9.setBackground(Color.white);
        }
        if (iii == 10) {
            str1 = "delete from BAN where id=10";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(10,0,0)";
            ban10.setBackground(Color.white);
        }
        if (iii == 11) {
            str1 = "delete from BAN where id=11";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(11,0,0)";
            ban11.setBackground(Color.white);
        }
        if (iii == 12) {
            str1 = "delete from BAN where id=12";
            str2 = "insert into BAN(id,trangthai,thanhtien) values(12,0,0)";
            ban12.setBackground(Color.white);
        }

        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();
            if (conn != null) {
                System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();

                        // up lên hóa đơn
                //idHD idNV tongtien ngay(datetime)
                String[] gettknv = tennguoidung.getText().split(":");
                String tenthungan = "";
                for (int l = 1; l < gettknv[1].length(); l++) {
                    tenthungan += gettknv[1].charAt(l);
                }
                String getowner = "select * from ACCOUNT where username='" + tenthungan + "'";
                ResultSet rsidnv = statement.executeQuery(getowner);

                //System.out.println(tenthungan);
                int getidnv = 0;
                while (rsidnv.next()) {
                    getidnv = rsidnv.getInt("owner");
                    break;
                }
                        //System.out.println(getidnv);
                // SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                String gettimetinhtien = dtf.format(now);
                String copygettimetinhtien = gettimetinhtien;
//                        System.out.println(dtf.format(now));
//                        System.out.println(getidnv);
//                        System.out.println(jTextField1.getText());
                String updatetohoadon = "insert into HOADON(idNV,tongtien,ngay) values('" + getidnv + "','" + txtf__tongtien.getText() + "','" + gettimetinhtien + "')";
                boolean exeupdatetohoadon;
                exeupdatetohoadon = statement.execute(updatetohoadon);

                        //update hoa don end
                String getidhoadon = "select * from HOADON where ngay='" + copygettimetinhtien + "' and idNV='" + getidnv + "' and tongtien='" + txtf__tongtien.getText() + "' ";
                rsidnv = statement.executeQuery(getidhoadon);
                int getidhoadonvuaup = 0;
                while (rsidnv.next()) {
                    getidhoadonvuaup = rsidnv.getInt("idHD");
                    break;
                }
                //System.out.println(getidhoadonvuaup);
                String[] getidban = nametable.getText().split(" ");
                int idbanuphoadon = Integer.parseInt(getidban[1]);
                //System.out.println(getidban[1]);
                updatecthoadon(idbanuphoadon, getidhoadonvuaup);

//                        //end
//                        //úp lên chi tiết hóa đơn
//                        //idHD ok idMonAn?  soluong?
//                        String updatetocthoadon="select * from BAN where id='"+Integer.parseInt(getidban[1])+"'";
//                        ResultSet rssr=statement.executeQuery(updatetocthoadon);
//                        //getidnv = 0;
//                        String[] savesql=new String[1000];
//                        int run=1;
////                        while(rssr.next())
////                        {
////                            String setchitiethoadon="insert into CTHOADON(idHD,idMonAn,soluong) values('"+getidnv+"','"+getidmon(rsidnv.getString("tenmon"))+"','"+rsidnv.getInt("soluong")+"')";
////                            savesql[run++]=setchitiethoadon;
////                            System.out.println(run);
////                            System.out.println(getidnv);
////                            System.out.println(getidmon(rsidnv.getString("tenmon")));
////                            System.out.println(rsidnv.getInt("soluong"));
////                        }
//                        //end
                boolean thanhtoan;
                loadtabletrong();
                settongtien("0");
                thanhtoan = statement.execute(str1);
                thanhtoan = statement.execute(str2);

            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }

    }

    public static void updatecthoadon(int idban, int idhoadon) {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();
            if (conn != null) {
                // System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                ResultSet rs;
                String sqlgetmon = "select * from BAN where id='" + idban + "'";
                rs = statement.executeQuery(sqlgetmon);
                while (rs.next()) {
                    String setchitiethoadon = "insert into CTHOADON(idHD,idMonAn,soluong) values('" + idhoadon + "','" + getidmon(rs.getString("tenmon")) + "','" + rs.getInt("soluong") + "')";
                    System.out.println(getidmon(rs.getString("tenmon")));
                    System.out.println(rs.getInt("soluong"));
                    exec(setchitiethoadon);
                }
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }

    public static void exec(String str) {
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();
            if (conn != null) {
                // System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                boolean exeupdatecthoadon;
                exeupdatecthoadon = statement.execute(str);
            }
            conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
    }

    public static int getidmon(String ten) {
        int status = 0;
        try {
            String dbURL = "jdbc:sqlserver://localhost;databaseName=QL_NHA_HANG;user=sa;password=sa";
            Connection conn = DriverManager.getConnection(dbURL);
            Statement statement = conn.createStatement();
            if (conn != null) {
                // System.out.println("Connected");
                DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                String sql = "select * from MONAN where tenMonAn=N'" + ten + "'";
                ResultSet rs;
                rs = statement.executeQuery(sql);

                while (rs.next()) {
                    status = rs.getInt("idMonAn");
                    break;
                }
            }
            //conn.close();
        } catch (SQLException ex) {
            System.err.println("Cannot connect database, " + ex);
        }
        return status;
    }
    public static String getquyenuser()
    {
        String tenuser=tennguoidung.getText();
        String[] cuttenuser=tenuser.split(":");
        return cuttenuser[0];
                
    }
}
