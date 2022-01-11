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
        this.MU = MU;
    }
    
    public void Update(){
        MU = new UserModel(MU.getUsername() , MU.getUsername());
        MU.setUsername(VU.getUsername().getText());
        MU.setPassword(VU.getPassword().getText());
        
        MU.EditDataUser();
        VU.clear();
    }
    
    
}
