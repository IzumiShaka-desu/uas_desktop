/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_transaksi.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import module.database.KoneksiDatabase;
import com.toedter.calendar.JDateChooser;
import java.awt.print.PrinterException;
import java.util.Date;
import java.sql.PreparedStatement;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTable;

/**
 *
 * @author wildan fauzi
 */
public class DataTransaksiView extends javax.swing.JInternalFrame {

    private String sql = "";
    private TransaksiView VT;
    private DefaultTableModel Tabel;
    private JDateChooser chooser;

    /**
     * Creates new form DataTransaksiView
     */
    //public DataTransaksiView(TransaksiView VT) {
    public DataTransaksiView() {
        initComponents();
//        this.VT = VT;
        Tabel = new DefaultTableModel();
        transaksiTB.setModel(Tabel);
        Tabel.addColumn("Id Transaksi");
        Tabel.addColumn("Nama Barang");
        Tabel.addColumn("Nama Pelanggan");
        Tabel.addColumn("Tanggal Transaksi");
        Tabel.addColumn("Total Belanja");
        Tabel.addColumn("Uang Bayar");
        Tabel.addColumn("Kembalian");
        TampilDataTrans(title);
    }

    private void TampilDataTrans(String cari) {
        Tabel.getDataVector().removeAllElements();
        Tabel.fireTableDataChanged();
        if (cari.equals("")) {
            sql = "SELECT * FROM detail_trans INNER JOIN barang ON detail_trans.id_barang = barang.id_barang INNER JOIN transaksi ON detail_trans.id_trans = transaksi.id_trans ORDER BY detail_trans.id_trans DESC";
        } else {
            sql = "SELECT * FROM detail_trans INNER JOIN barang ON detail_trans.id_barang = barang.id_barang INNER JOIN transaksi ON detail_trans.id_trans = transaksi.id_trans ORDER BY detail_trans.id_trans DESC WHERE transaksi.tanggal_trans  ";
        }

//        String sql = "SELECT * FROM detail_trans INNER JOIN barang ON detail_trans.id_barang = barang.id_barang INNER JOIN transaksi ON detail_trans.id_trans = transaksi.id_trans ORDER BY detail_trans.id_trans DESC";
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {
                Object[] hasil;
                hasil = new Object[7];
                hasil[0] = res.getString("id_trans");
                hasil[1] = res.getString("nama");
                hasil[2] = res.getString("nama_pel");
                hasil[3] = res.getString("tanggal_trans");
                hasil[4] = res.getString("total_belanja");
                hasil[5] = res.getString("uang_bayar");
                hasil[6] = res.getString("kembalian");

                Tabel.addRow(hasil);
            }
            JOptionPane.showMessageDialog(null, "Suskes menampilkan data transaksi");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Tidak dapat menampilkan data transaksi" + ex);
//            Logger.getLogger(ViewPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cariBT = new javax.swing.JButton();
        cariBT1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        transaksiTB = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        datechoosDC1 = new com.toedter.calendar.JDateChooser();
        datechoosDC2 = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Cari Tanggal");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("-");

        cariBT.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cariBT.setText("Cari");
        cariBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBTActionPerformed(evt);
            }
        });

        cariBT1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cariBT1.setText("Reset");
        cariBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariBT1ActionPerformed(evt);
            }
        });

        transaksiTB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(transaksiTB);

        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 779, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jLabel2)
                .addGap(41, 41, 41)
                .addComponent(datechoosDC1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(datechoosDC2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(cariBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cariBT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(datechoosDC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addComponent(jLabel4))
                        .addComponent(datechoosDC2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cariBT)
                            .addComponent(cariBT1))))
                .addGap(21, 21, 21)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Data Transaksi");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(299, 299, 299)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cariBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBTActionPerformed
        // TODO add your handling code here:
        Date date1 = datechoosDC1.getDate();
        Date date2 = datechoosDC2.getDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Tabel.getDataVector().removeAllElements();
        Tabel.fireTableDataChanged();
        String sql = "SELECT * FROM detail_trans INNER JOIN barang ON detail_trans.id_barang = barang.id_barang "
                + "INNER JOIN transaksi ON detail_trans.id_trans = transaksi.id_trans"
                + " where `tanggal_trans` BETWEEN '" + sdf.format(date1) + "' AND '" + sdf.format(date2) + "'  ORDER BY detail_trans.id_trans DESC ";
//        try (PreparedStatement statement =
//    con.prepareStatement("insert into ss values ?, ?, ?, ?")) {
//
//    statement.setString(1, n);
//    statement.setDate(2, dt1);
//    statement.setDate(3, dt2);
//    statement.setString(4, i);
// vSELECT * FROM `transaksi` WHERE `tanggal_trans` BETWEEN '2022-01-10' AND '2022-01-13';
//    statement.executeUpdate
        System.out.print(sql);
        try {

//Date convertedCurrentDate = sdf.parse("2013-09-18");
//String date=sdf.format(convertedCurrentDate );
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {
                Object[] hasil;
                hasil = new Object[7];
                hasil[0] = res.getString("id_trans");
                hasil[1] = res.getString("nama");
                hasil[2] = res.getString("nama_pel");
                hasil[3] = res.getString("tanggal_trans");
                hasil[4] = res.getString("total_belanja");
                hasil[5] = res.getString("uang_bayar");
                hasil[6] = res.getString("kembalian");

                Tabel.addRow(hasil);
            }
            JOptionPane.showMessageDialog(null, "Suskes menampilkan data transaksi");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Tidak dapat menampilkan data transaksi" + ex);
//            Logger.getLogger(ViewPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cariBTActionPerformed

    private void cariBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariBT1ActionPerformed
        // TODO add your handling code here:
        sql = "SELECT * FROM detail_trans INNER JOIN barang ON detail_trans.id_barang = barang.id_barang INNER JOIN transaksi ON detail_trans.id_trans = transaksi.id_trans ORDER BY detail_trans.id_trans DESC";
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {
                Object[] hasil;
                hasil = new Object[7];
                hasil[0] = res.getString("id_trans");
                hasil[1] = res.getString("nama");
                hasil[2] = res.getString("nama_pel");
                hasil[3] = res.getString("tanggal_trans");
                hasil[4] = res.getString("total_belanja");
                hasil[5] = res.getString("uang_bayar");
                hasil[6] = res.getString("kembalian");

                Tabel.addRow(hasil);
            }
            JOptionPane.showMessageDialog(null, "Suskes menampilkan data transaksi");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Tidak dapat menampilkan data transaksi" + ex);
//            Logger.getLogger(ViewPelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cariBT1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MessageFormat header=new MessageFormat("Laporan Transaksi Fotocopy");
        MessageFormat footer=new MessageFormat("Fotocopy Sinar Harapan");
        try {
            transaksiTB.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(DataTransaksiView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cariBT;
    private javax.swing.JButton cariBT1;
    private com.toedter.calendar.JDateChooser datechoosDC1;
    private com.toedter.calendar.JDateChooser datechoosDC2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable transaksiTB;
    // End of variables declaration//GEN-END:variables
}
