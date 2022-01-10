/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module_barang.controller;

import module_barang.model.ModelBarang;
import module_barang.view.BarangView;
import module_barang.view.ManageBarangView;

/**
 *
 * @author akashaka
 */
public class BarangController {
    private ModelBarang MB;
    private BarangView VB;
    private ManageBarangView VMB;
    
    public BarangController(BarangView VB){
    this.VB = VB;
    }
    
    public void clear(){
        VMB.getId().setText("");
        VMB.getNama().setText("");
        VMB.getJenis().setText("");
        VMB.getQuantity().setText("");
        VMB.getUkuran().setText("");
        VMB.getHarga().setText("");
    }
    
    public void kontrol (){
        VMB.getTambah().setEnabled(true);
        VMB.getEdit().setEnabled(false);
        VMB.getHapus().setEnabled(false);
        VMB.getBatal().setEnabled(true);
    }
    
    public void kontroldua (){
        VMB.getTambah().setEnabled(false);
        VMB.getEdit().setEnabled(true);
        VMB.getHapus().setEnabled(true);
        VMB.getBatal().setEnabled(true);
    }
    
    public void simpan(){
        MB = new ModelBarang();
        MB.setNamabarang(VMB.getNama().getText());
        MB.setJenisbarang(VMB.getJenis().getText());
        MB.setQuantity(VMB.getQuantity().getText());
        MB.setUkuran(VMB.getUkuran().getText());
        MB.setHarga(VMB.getHarga().getText());
        
        //JOptionPane.showConfirmDialog(vP, "Nama Pelanggan : "+mP.getNama()+"\n Nomor HP :"+mP.getNohp()+"\n Jenis Kelamin :"+mP.getJeniskelamin()+"\n Umur :"+mP.getUmur()+"\n Alamat :"+mP.getAlamat());
        MB.SimpanDataBarang();
        clear();
    }
    
    public void Update(){
        MB = new ModelBarang();
        MB.setIdbarang(VMB.getId().getText());
        MB.setNamabarang(VMB.getNama().getText());
        MB.setJenisbarang(VMB.getJenis().getText());
        MB.setQuantity(VMB.getQuantity().getText());
        MB.setUkuran(VMB.getUkuran().getText());
        MB.setHarga(VMB.getHarga().getText());
        
        MB.EditDataBarang();
        clear();
        kontrol();
    }
    
    public void Delete(){
        MB = new ModelBarang();
        MB.setIdbarang(VMB.getId().getText());
        
        MB.HapusDataBarang();
        
        clear();
        kontrol();
    }
}
