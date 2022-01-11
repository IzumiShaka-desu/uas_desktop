/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_project;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import module_login.controller.LoginController;
import module_login.view.LoginView;
import uas_project.Dashboard;

/**
 *
 * @author wildan fauzi
 */
public class Aplikasi_Fotocopy {
    public static void main (String[]args){
//    MainApp main = new MainApp();
//    main.setVisible(true);
    try {
        UIManager.setLookAndFeel( new FlatLightLaf() );
    } catch( Exception ex ) {
        System.err.println( "Failed to initialize LaF" );
    }
        LoginController lc = LoginController.getInstance(new LoginView());
        lc.getvL().setVisible(true);
//        Dashboard Halutama = new Dashboard();
//        Halutama.setVisible(true);
   }
}
