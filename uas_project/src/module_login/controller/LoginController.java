/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module_login.controller;

import javax.swing.JOptionPane;

/**
 *
 * @author akashaka
 */
public class LoginController {
     private ModelLogin mL;
    private ViewLogin vL;
    private static ControllerLogin single_instance = null;

    private ControllerLogin(ViewLogin vL) {
        this.mL = new ModelLogin();
//        ViewLogin VL = 
        this.vL =vL;
       
    }
    public static ControllerLogin getInstance(ViewLogin vL) {
        if (single_instance == null) {
            single_instance = new ControllerLogin(vL);
        }

        return single_instance;
    }

    public void Login() {
        ModelLogin nML=mL.login(vL.getUsername().getText(), vL.getPassword().getText()) ;
        if (nML== null) {
            JOptionPane.showMessageDialog(null, "data login tidak ditemukan");
        } else {
            vL.setVisible(false);
            this.mL=nML;
            MainApp mV = new MainApp();
            mV.setVisible(true);
        }
    }

    public void clear() {
        vL.getUsername().setText("");
        vL.getPassword().setText("");
    }

    public ModelLogin getmL() {
        return mL;
    }

    public ViewLogin getvL() {
        return vL;
    }

}
