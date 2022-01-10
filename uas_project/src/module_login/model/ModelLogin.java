/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module_login.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import module.database.KoneksiDatabase;

/**
 *
 * @author akashaka
 */
public class ModelLogin {
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public ModelLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ModelLogin() {
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
    
    public ModelLogin login(String username, String password) {
        String sql = ("select * from login where username='" + username + "' and password='" + password + "'");

        try {
            Statement stat = (Statement) KoneksiDatabase.getKoneksi().createStatement();
            ResultSet res = stat.executeQuery(sql);

            while (res.next()) {

                return new ModelLogin(
                        res.getString("username"), "");
            }

        } catch (SQLException ex) {
            // Logger.getLogger(ModelPelanggan.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data gagal disimpan ke dalam Database \n" + ex);
        }
        return null;
    }

}
