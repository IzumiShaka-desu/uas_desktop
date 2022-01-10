/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module_login.controller;

import javax.swing.JOptionPane;
import module_login.model.ModelLogin;
import module_login.view.LoginView;
import uas_project.Dashboard;

/**
 *
 * @author akashaka
 */
public class LoginController {
     private ModelLogin mL;
    private LoginView vL;
    private static LoginController single_instance = null;

    private LoginController(LoginView vL) {
        this.mL = new ModelLogin();
//        ViewLogin VL = 
        this.vL =vL;
       
    }
    public static LoginController getInstance(LoginView vL) {
        if (single_instance == null) {
            single_instance = new LoginController(vL);
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
            Dashboard mV = new Dashboard();
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

    public LoginView getvL() {
        return vL;
    }

}
