/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module_barang.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import module.database.KoneksiDatabase;
import module_barang.controller.ManageBarangController;
import module_barang.model.ModelBarang;

/**
 *
 * @author wildan fauzi
 */
public class ManageBarangView extends javax.swing.JInternalFrame {

    private ManageBarangController CB;
    private DefaultTableModel tabel;
    private String sql = "";

    /**
     * Creates new form ManageBarangView
     */
    public ManageBarangView() {
        initComponents();
        CB = new ManageBarangController(this);
        tabel = new DefaultTableModel();
        barangTB.setModel(tabel);
        
        tabel.addColumn("Id Barang");
        tabel.addColumn("Nama Barang");
        tabel.addColumn("Jenis Barang");
        tabel.addColumn("Stok Barang");
        tabel.addColumn("Ukuran Barang");
        tabel.addColumn("Harga Barang");
        
        TampilDataBarang(title);
        CB.kontrol();
    }

    Boolean tampil = true;
    
    public ManageBarangController getCB() {
        return CB;
    }


    public JTextField getJenis() {
        return JenisbTF;
    }

    public JButton getKembali() {
        return KembaliBT;
    }

    public JButton getBatal() {
        return batalBT;
    }

    public JButton getEdit() {
        return editBT;
    }

    public JButton getHapus() {
        return hapusBT;
    }

    public JTextField getHarga() {
        return hargabTF;
    }

    public JTextField getId() {
        return idbTF;
    }

    public JTextField getNama() {
        return namabTF;
    }

    public JTextField getQuantity() {
        return quantitybTF;
    }

    public JButton getTambah() {
        return tambahBT;
    }

    public JTextField getUkuran() {
        return ukuranbTF;
    }

    private void AmbilDataTabel(){
        int index = barangTB.getSelectedRow();
        String idb = String.valueOf(barangTB.getValueAt(index, 0));
        String nama = String.valueOf(barangTB.getValueAt(index, 1));
        String jenis = String.valueOf(barangTB.getValueAt(index, 2));
        String quantity = String.valueOf(barangTB.getValueAt(index, 3));
        String ukuran = String.valueOf(barangTB.getValueAt(index, 4));
        String harga = String.valueOf(barangTB.getValueAt(index, 5));
        
        
        idbTF.setText(idb);
        namabTF.setText(nama);
        JenisbTF.setText(jenis);
        quantitybTF.setText(quantity);
        ukuranbTF.setText(ukuran);
        hargabTF.setText(harga);

        CB.kontroldua();
    }
    
    private void TampilDataBarang (String cari){
        tabel.getDataVector().removeAllElements();
        tabel.fireTableDataChanged();
        
        if(cari.equals("")){
            sql = "SELECT * FROM barang";
        }
        else {
            sql = "SELECT * FROM barang WHERE nama LIKE '"+cari+"%' ";
        }
        
        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res  = stat.executeQuery(sql);
            
            while (res.next()){
                Object[] hasil;
                hasil = new Object[6];
                hasil[0] = res.getString("id_barang");
                hasil[1] = res.getString("nama");
                hasil[2] = res.getString("jenis");
                hasil[3] = res.getString("quantity");
                hasil[4] = res.getString("ukuran");
                hasil[5] = res.getString("harga");
                
                tabel.addRow(hasil);
                
            }
            
        } catch (SQLException ex) {
//            Logger.getLogger(ViewPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Tidak dapat menampilkan tabel \n" + ex);
        }  
    }
    
    
//    private void TampilDataPel (){
//        tabel.getDataVector().removeAllElements();
//        tabel.fireTableDataChanged();
//        
//        String sql = "SELECT * FROM barang ";
//        try {
//            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
//            ResultSet res  = stat.executeQuery(sql);
//            
//            while (res.next()){
//                Object[] hasil;
//                hasil = new Object[6];
//                hasil[0] = res.getString("id_barang");
//                hasil[1] = res.getString("nama");
//                hasil[2] = res.getString("jenis");
//                hasil[3] = res.getString("quantity");
//                hasil[4] = res.getString("ukuran");
//                hasil[5] = res.getString("harga");
//                
//                tabel.addRow(hasil);
//                
//            }
//            
//        } catch (SQLException ex) {
////            Logger.getLogger(ViewPelanggan.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, "Tidak dapat menampilkan tabel \n" + ex);
//        }  
//    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        hapusBT = new javax.swing.JButton();
        batalBT = new javax.swing.JButton();
        tambahBT = new javax.swing.JButton();
        editBT = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        hargabTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        ukuranbTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        quantitybTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        JenisbTF = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        namabTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        idbTF = new javax.swing.JTextField();
        tampildataBT = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        KembaliBT = new javax.swing.JButton();
        databarangPN = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        barangTB = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cariTF = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        hapusBT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        hapusBT.setText("Hapus Data");
        hapusBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusBTActionPerformed(evt);
            }
        });

        batalBT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        batalBT.setText("Batal");
        batalBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalBTActionPerformed(evt);
            }
        });

        tambahBT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tambahBT.setText("Tambah Data");
        tambahBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahBTActionPerformed(evt);
            }
        });

        editBT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        editBT.setText("Edit Data");
        editBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBTActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Harga Barang");

        hargabTF.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Ukuran Barang");

        ukuranbTF.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Stok Barang");

        quantitybTF.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Jenis Barang");

        JenisbTF.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Nama Barang");

        namabTF.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Id Barang");

        idbTF.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        idbTF.setEnabled(false);

        tampildataBT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tampildataBT.setText("Tampil Data");
        tampildataBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tampildataBTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(namabTF, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idbTF, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JenisbTF, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantitybTF, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ukuranbTF, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hargabTF, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(editBT, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tambahBT))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(batalBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(tampildataBT, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(hapusBT, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(26, 26, 26))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idbTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namabTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JenisbTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantitybTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ukuranbTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(hargabTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahBT)
                    .addComponent(batalBT))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editBT)
                    .addComponent(hapusBT)
                    .addComponent(tampildataBT))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Manage Barang");

        KembaliBT.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        KembaliBT.setText("Kembali");
        KembaliBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KembaliBTActionPerformed(evt);
            }
        });

        barangTB.setModel(new javax.swing.table.DefaultTableModel(
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
        barangTB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                barangTBMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(barangTB);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Data Barang");

        cariTF.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        cariTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cariTFKeyPressed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Cari Barang");

        javax.swing.GroupLayout databarangPNLayout = new javax.swing.GroupLayout(databarangPN);
        databarangPN.setLayout(databarangPNLayout);
        databarangPNLayout.setHorizontalGroup(
            databarangPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(databarangPNLayout.createSequentialGroup()
                .addGroup(databarangPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(databarangPNLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
                    .addGroup(databarangPNLayout.createSequentialGroup()
                        .addGroup(databarangPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(databarangPNLayout.createSequentialGroup()
                                .addGap(173, 173, 173)
                                .addComponent(jLabel3))
                            .addGroup(databarangPNLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        databarangPNLayout.setVerticalGroup(
            databarangPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, databarangPNLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addGroup(databarangPNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cariTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(KembaliBT))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(129, 129, 129)
                                .addComponent(jLabel1)))
                        .addGap(18, 18, 18)
                        .addComponent(databarangPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(KembaliBT)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(databarangPN, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hapusBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusBTActionPerformed
        // TODO add your handling code here:
        CB.Delete();
        TampilDataBarang(title);
    }//GEN-LAST:event_hapusBTActionPerformed

    private void batalBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalBTActionPerformed
        // TODO add your handling code here:
        CB.kontrol();
        CB.clear();
    }//GEN-LAST:event_batalBTActionPerformed

    private void tambahBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahBTActionPerformed
        // TODO add your handling code here:
        CB.simpan();
        TampilDataBarang(title);
    }//GEN-LAST:event_tambahBTActionPerformed

    private void editBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBTActionPerformed
        // TODO add your handling code here:
        CB.Update();
        TampilDataBarang(title);
    }//GEN-LAST:event_editBTActionPerformed

    private void KembaliBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KembaliBTActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_KembaliBTActionPerformed

    private void barangTBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barangTBMouseClicked
        // TODO add your handling code here:
        AmbilDataTabel();
    }//GEN-LAST:event_barangTBMouseClicked

    private void tampildataBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tampildataBTActionPerformed
        // TODO add your handling code here:
        tampil = !tampil;
        databarangPN.setVisible(tampil);
        TampilDataBarang(title);
    }//GEN-LAST:event_tampildataBTActionPerformed

    private void cariTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cariTFKeyPressed
        // TODO add your handling code here:
        TampilDataBarang(cariTF.getText());
    }//GEN-LAST:event_cariTFKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField JenisbTF;
    private javax.swing.JButton KembaliBT;
    private javax.swing.JTable barangTB;
    private javax.swing.JButton batalBT;
    private javax.swing.JTextField cariTF;
    private javax.swing.JPanel databarangPN;
    private javax.swing.JButton editBT;
    private javax.swing.JButton hapusBT;
    private javax.swing.JTextField hargabTF;
    private javax.swing.JTextField idbTF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField namabTF;
    private javax.swing.JTextField quantitybTF;
    private javax.swing.JButton tambahBT;
    private javax.swing.JButton tampildataBT;
    private javax.swing.JTextField ukuranbTF;
    // End of variables declaration//GEN-END:variables
}
