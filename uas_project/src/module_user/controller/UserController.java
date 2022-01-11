/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package module_user.controller;

import module_user.model.UserModel;
import module_user.view.UserView;

/**
 *
 * @author akashaka
 */
public class UserController {
    
    private UserModel MU;
    private UserView VU;
    
    public UserController(UserView VU){
        this.VU = VU;
//        this.MU = MU;
    }
    
    public UserView getVU(){
        return VU;
    }
    
    public UserModel getMU(){
        return MU;
    }
    
    public void Update(){
        MU = new UserModel();
        MU.setId_login(VU.getIdlogin().getText());
        MU.setUsername(VU.getUsername().getText());
        MU.setPassword(VU.getPassword().getText());
        
        MU.EditDataUser();
        VU.clear();
    }
    
    
    
    
}
