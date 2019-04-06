/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import com.mycompany.usernavigation.User;
import dao.UserDAO;
import dao.UserDAOImpl;
import java.util.List;

/**
 *
 * @author pc
 */
public class UserService{ 
        UserDAO userDAO=new UserDAOImpl();
        
         public void create (User user){
             userDAO.create(user);
         
         }
    
    public void delete (User user){
        userDAO.delete(user);
    }
    
    public void update (User user){
        userDAO.update(user);
    }
    
    
    public List <User> retreiveAllUsers(){
       return userDAO.retreiveAllUsers();
    }
        
    
}
