/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.mycompany.usernavigation.User;
import dao.UserDAO;
import dao.UserDAOImpl;

/**
 *
 * @author ghazallah
 */
public class Main {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setFirstName("Muhamamd");
        user.setLastName("Sobhy");
        user.setLastName("Ghazallah");
        user.setEmail("ghazallah64@gmail.com");
        UserDAO userDAO = new UserDAOImpl();
        userDAO.create(user);
    }
}
