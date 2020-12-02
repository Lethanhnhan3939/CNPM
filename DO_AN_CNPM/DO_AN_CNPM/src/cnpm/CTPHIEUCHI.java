package cnpm;

import java.util.ArrayList;
import java.util.Date;

public class CTPHIEUCHI extends javax.swing.JDialog
{
    BUS.DSCTPHIEUCHI ct = new BUS.DSCTPHIEUCHI();
    BUS.DSNGUYENLIEU nl = new BUS.DSNGUYENLIEU();
    
    private int idPC;
    private int idNL;

    public CTPHIEUCHI(java.awt.Frame parent, boolean modal, int id)
    {
        super(parent, modal);
        initComponents();
        this.setID(id);
        this.init();
    }
    
    private void init()
    {
        for (int i = 0; i < this.ct.getList().size(); i++)
            if (this.ct.getList().get(i).getIDPC() == this.idPC)
            {
                this.idNL = this.ct.getList().get(i).getIDNL();
                this.soluong.setText(String.valueOf(this.ct.getList().get(i).getSoLuong()));
                break;
            }
        
        for (int i = 0; i < this.nl.getList().size(); i++)
            if (this.nl.getList().get(i).getID() == this.idNL)
            {
                this.nguyenlieu.setText(this.nl.getList().get(i).getName());
                break;
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nguyenlieu = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        thoigian = new javax.swing.JLabel();
        soluong = new javax.swing.JLabel();
        tongtien = new javax.swing.JLabel();
        ghichu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("Thời gian");

        jLabel3.setText("Nguyên Liệu");

        jLabel4.setText("Số Lượng");

        jLabel5.setText("Tổng tiền");

        jLabel6.setText("Ghi chú");

        nguyenlieu.setText("...");

        id.setText("...");

        thoigian.setText("...");

        soluong.setText("...");

        tongtien.setText("...");

        ghichu.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nguyenlieu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(thoigian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(soluong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ghichu, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(thoigian))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nguyenlieu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(soluong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tongtien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ghichu))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ghichu;
    private javax.swing.JLabel id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel nguyenlieu;
    private javax.swing.JLabel soluong;
    private javax.swing.JLabel thoigian;
    private javax.swing.JLabel tongtien;
    // End of variables declaration//GEN-END:variables

    public void setID(int id)
    {
        this.idPC = id;
        this.id.setText(String.valueOf(this.idPC));
    }
    public void setDate(String date) {this.thoigian.setText(date);}
    public void setTongTien(int tien) {this.tongtien.setText(String.valueOf(tien));}
    public void setGhiChu(String ghichu) {this.ghichu.setText(ghichu);}
}
