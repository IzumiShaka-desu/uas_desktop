/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package module.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wildan fauzi
 */
public class KoneksiDatabase {
    private static Connection conn;
        private static Properties propert = new Properties();
        
        private static String driver = "com.mysql.jdbc.Driver"; 
        private static String url = "jdbc:mysql://localhost:3306/java pos"; 
        private static String username = "root"; 
        private static String password = ""; 
        
        public static Connection getKoneksi() throws SQLException {
        if(conn == null){

//            try {   
//                //propert.load(new FileInputStream("D:\\Kuliah\\Semester 5\\Pem Basis Desktop\\UAS\\uas_desktop\\uas_project\\src\\module\\database\\Database.properties"));
//                // isi sesuai dengan database.properties disimpan
//                //propert.load(new FileInputStream(""));
//                } 
//            catch (IOException ex) {
//                System.err.println("error mengambil file"+ex);
//                System.err.println("berhasil terhubung"+ex);
//                }
            try {
                conn = DriverManager.getConnection(url,username,password);
                } 
            catch (SQLException ex) {
                Logger.getLogger(KoneksiDatabase.class.getName()).log(Level.SEVERE, null, ex);
                }
            }   
        return conn;
    }
    public static void main (String[] args) throws SQLException{
    if(getKoneksi().equals(conn)){
        System.out.println("sukses terkoneksi");
    }
    }
}
