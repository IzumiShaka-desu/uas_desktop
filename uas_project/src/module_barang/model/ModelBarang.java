/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module_barang.model;

import module.database.KoneksiDatabase;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author akashaka
 */
public class ModelBarang {
    private String idbarang;
    private String namabarang;
    private String jenisbarang;
    private String quantity;
    private String ukuran;
    private String harga;

    public String getIdbarang() {
        return idbarang;
    }

    public void setIdbarang(String idbarang) {
        this.idbarang = idbarang;
    }

    public String getNamabarang() {
        return namabarang;
    }

    public void setNamabarang(String namabarang) {
        this.namabarang = namabarang;
    }

    public String getJenisbarang() {
        return jenisbarang;
    }

    public void setJenisbarang(String jenisbarang) {
        this.jenisbarang = jenisbarang;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }
    
    public void SimpanDataBarang (){
        String sql = ("INSERT INTO barang (namabarang, jenis, satuan, harga, ukuran)" 
                + "VALUES ('"+getNamabarang()+"' , '"+getJenisBarang()+"' , '"+getSatuanbarang()+"' , '"+getHarga()+"' , '"+getUkuran()+"' ) " );
   
        try {
            PreparedStatement eksekusi = KoneksiDatabase.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan ke dalam Database");
            
        } catch (SQLException ex) {
            //Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal disimpan ke dalam Database \n" + ex);
        }
    }
    
    public void EditDataBarang (){        
        String sql = "UPDATE barang SET namabarang = '"+getNamabarang()+"' " 
                + ", jenis = '"+getJenis()+"' " 
                + ", satuan = '"+getSatuan()+"' " 
                + ", harga = '"+getHarga()+"' " 
                + ", ukuran = '"+getUkuran()+"' "
                + " WHERE idb = '"+getIdb()+"' "; 
        try {
            PreparedStatement eksekusi = KoneksiDB.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil diUpdate ke dalam Database");
            
        } catch (SQLException ex) {
            //Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal diUpdate ke dalam Database \n" + ex);
        }
    }
    
    public void HapusDataBarang (){
        String sql = "DELETE FROM barang WHERE idb = '"+getIdb()+"' ";
        
        try {
            PreparedStatement eksekusi = KoneksiDB.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus dari Database");
            
        } catch (SQLException ex) {
            //Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal dihapus dari Database \n" + ex);
        }
    }
    
    
    
    
}
