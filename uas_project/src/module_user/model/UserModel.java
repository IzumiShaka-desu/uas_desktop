/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module_user.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import module.database.KoneksiDatabase;

/**
 *
 * @author akashaka
 */
public class UserModel {
    private String id_login; 
    private String username; 
    private String password; 

//    public UserModel(String id_login,String username,String password) {
//        this.id_login = id_login;
//        this.username = username;
//        this.password = password;
//    }

    public String getId_login() {
        return id_login;
    }

    public void setId_login(String id_login) {
        this.id_login = id_login;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
   public void EditDataUser (){        
        String sql = "UPDATE login SET username = '"+getUsername()+"' "
                + ", password = '"+getPassword()+"' "
                + " WHERE id_login = '"+getId_login()+"' ";
        try {
            PreparedStatement eksekusi = KoneksiDatabase.getKoneksi().prepareStatement(sql);
            eksekusi.execute();
            
            JOptionPane.showMessageDialog(null, "Berhasil merubah username dan password");
            
        } catch (SQLException ex) {
            //Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Gagal merubah username dan password \n" + ex);
        }
    }
}
