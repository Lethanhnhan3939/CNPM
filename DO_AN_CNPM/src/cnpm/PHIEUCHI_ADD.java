/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cnpm;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Hau Vu
 */
public class PHIEUCHI_ADD extends javax.swing.JDialog
{
    private ArrayList<BUS.NGUYENLIEU> nl = new BUS.DSNGUYENLIEU().getList();
    private DefaultComboBoxModel<BUS.NGUYENLIEU> model = new DefaultComboBoxModel<BUS.NGUYENLIEU>();
    private Date date = new Date();

    public PHIEUCHI_ADD(java.awt.Frame parent, boolean modal)
    {
        super(parent, modal);
        initComponents();
        this.init();
    }
    
    private void init()
    {
        this.nl_cbx.setModel(this.model);
        for (int i = 0; i < this.nl.size(); i++)
        {
            this.model.addElement(this.nl.get(i));
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nl_cbx = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tongtien_lab5 = new javax.swing.JLabel();
        tongtien_lab = new javax.swing.JLabel();
        tongtien_lab2 = new javax.swing.JLabel();
        ghichu_txt = new javax.swing.JTextField();
        sl_txt = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        check = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 27, 72));
        jLabel1.setText("Thêm Phiếu chi");

        jLabel3.setForeground(new java.awt.Color(0, 27, 72));
        jLabel3.setText("Nguyên Liệu");

        jLabel4.setForeground(new java.awt.Color(0, 27, 72));
        jLabel4.setText("Số lượng");

        jLabel5.setForeground(new java.awt.Color(0, 27, 72));
        jLabel5.setText("Tổng tiền");

        tongtien_lab5.setForeground(new java.awt.Color(0, 27, 72));
        tongtien_lab5.setText("VND");

        tongtien_lab.setForeground(new java.awt.Color(0, 27, 72));
        tongtien_lab.setText("...");

        tongtien_lab2.setForeground(new java.awt.Color(0, 27, 72));
        tongtien_lab2.setText("Ghi chú");

        sl_txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sl_txtActionPerformed(evt);
            }
        });
        sl_txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                sl_txtKeyPressed(evt);
            }
        });

        submit.setText("Thêm");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        check.setText("check");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tongtien_lab2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nl_cbx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(tongtien_lab, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tongtien_lab5)
                                .addGap(18, 18, 18)
                                .addComponent(check))
                            .addComponent(ghichu_txt)
                            .addComponent(sl_txt)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(submit)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(nl_cbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(sl_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tongtien_lab)
                    .addComponent(tongtien_lab5)
                    .addComponent(check))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tongtien_lab2)
                    .addComponent(ghichu_txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        try
        {
            BUS.NGUYENLIEU result = (BUS.NGUYENLIEU)this.model.getSelectedItem();
            this.tongtien_lab.setText(String.valueOf(Integer.parseInt(this.sl_txt.getText()) * result.getGia()));
        }
        catch (Exception e) {JOptionPane.showMessageDialog(this, "Số lượng phải là kiểu số");}
        this.dispose();
    }//GEN-LAST:event_submitActionPerformed

    private void sl_txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sl_txtActionPerformed
        
    }//GEN-LAST:event_sl_txtActionPerformed

    private void sl_txtKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sl_txtKeyPressed
        
    }//GEN-LAST:event_sl_txtKeyPressed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        try
        {
            BUS.NGUYENLIEU result = (BUS.NGUYENLIEU)this.model.getSelectedItem();
            this.tongtien_lab.setText(String.valueOf(Integer.parseInt(this.sl_txt.getText()) * result.getGia()));
        }
        catch (Exception e) {JOptionPane.showMessageDialog(this, "Số lượng phải là kiểu số");}
    }//GEN-LAST:event_checkActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton check;
    private javax.swing.JTextField ghichu_txt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JComboBox nl_cbx;
    private javax.swing.JTextField sl_txt;
    private javax.swing.JButton submit;
    private javax.swing.JLabel tongtien_lab;
    private javax.swing.JLabel tongtien_lab2;
    private javax.swing.JLabel tongtien_lab5;
    // End of variables declaration//GEN-END:variables

    public Date getDate() {return this.date;}
    public int getTongtien() {return Integer.parseInt(this.tongtien_lab.getText());}
    public String Check() {return this.sl_txt.getText();}
    public int getSL() {return Integer.parseInt(this.sl_txt.getText());}
    public String getGhichu() {return this.ghichu_txt.getText();}
    public int getIDNL()
    {
        BUS.NGUYENLIEU result = (BUS.NGUYENLIEU)this.model.getSelectedItem();
        return result.getID();
    }
}
