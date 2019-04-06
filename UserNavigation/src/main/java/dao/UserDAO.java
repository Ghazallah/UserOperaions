/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mycompany.usernavigation.User;
import java.util.List;

/**
 *
 * @author ghazallah
 */
public interface UserDAO {
    
    public void create (User user);
    
    public void delete (User user);
    
    public void update (User user);
    
    public User retreive (int id);
    
    public List <User> retreiveAllUsers();
}
