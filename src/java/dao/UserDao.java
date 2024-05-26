/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import dbcontext.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.User;

/**
 *
 * @author admin
 */
public class UserDao {

    public UserDao() {
    }
    public User getUser(String email , String password){
       User user = null;
       ConnectDB db = ConnectDB.getInstance();
       String sql = "Select * from Users where email =? and password =? ";
       
        try {
            Connection con = db.openConnection();
            PreparedStatement prt  = con.prepareStatement(sql);
            prt.setString(1, email);
            prt.setString(2, password);
            ResultSet rs = prt.executeQuery();
            
            while(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPassword(rs.getString("passoword"));
                user.setPhone(rs.getString("phone"));
            }
        } catch (Exception e) {
        }
       return user;
       
    }
}
