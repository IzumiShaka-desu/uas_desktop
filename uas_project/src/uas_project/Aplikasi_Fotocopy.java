/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas_project;

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

LoginController lc=LoginController.getInstance(new LoginView());
        lc.getvL().setVisible(true);
//        Dashboard Halutama = new Dashboard();
//        Halutama.setVisible(true);
   }
}
