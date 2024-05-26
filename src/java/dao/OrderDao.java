/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dbcontext.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;
import model.Order;

/**
 *
 * @author admin
 */
public class OrderDao {

    public OrderDao() {
    }

    
    public List<Order> getAllOrder() throws Exception {
    List<Order> orders = new ArrayList<Order>();
    ConnectDB db = ConnectDB.getInstance();
    String sql = "SELECT * FROM Orders";
    try (Connection con = db.openConnection();
         PreparedStatement statement = con.prepareStatement(sql)) {
        try (ResultSet rs = statement.executeQuery()) {
            while(rs.next()) {
                int id = rs.getInt("id");
                int user_id = rs.getInt("user_id");
                String address = rs.getString("address");
                double total = rs.getDouble("quantity");
                 int quantity = rs.getInt("quantity");
                String date = rs.getString("date");
               orders.add(new Order(id, user_id, address,  total,  quantity,  date));
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    return orders;
}

 
   
 
   
   public void deleteOrderItem(int idOrder) throws Exception {
    ConnectDB db = ConnectDB.getInstance();
    String sql = "DELETE FROM Orders WHERE id = ?";
    
    try (Connection con = db.openConnection();
         PreparedStatement statement = con.prepareStatement(sql)) {
         
        // Set parameter for the DELETE query
        statement.setInt(1, idOrder);
        
        // Execute the DELETE query
        int rowsAffected = statement.executeUpdate();
        
        if (rowsAffected > 0) {
            // The record was successfully deleted
            System.out.println("Record with id " + idOrder + " has been deleted.");
        } else {
            // No record found with the given idOrder
            System.out.println("No record found with id " + idOrder);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        // You may throw an exception or handle the SQLException accordingly
    }
}

   public void addOrder(Order order) throws Exception {
    ConnectDB db = ConnectDB.getInstance();
    String sql = "INSERT INTO Orders (user_id, address, total, quantity, date) VALUES (?, ?,?,?,?)";
    System.out.println("run at here 003");
    try (Connection con = db.openConnection();
            
         PreparedStatement statement = con.prepareStatement(sql)) {
         
        // Set parameters for the INSERT query
        statement.setInt(1, order.getUser_id());
        statement.setString(2, order.getAddress());
         statement.setDouble(3,order.getTotal());
          statement.setInt(4, order.getQuantity());
         statement.setString(5, order.getDate());
        // Execute the INSERT query
        System.out.println("run at here 004");
        int rowsAffected = statement.executeUpdate();
        System.out.println("dao.OrderDao.addOrder() ----------999999 " + rowsAffected);
        if (rowsAffected > 0) {
            System.out.println("run at here 005");
            // The product has been added to the cart successfully
            System.out.println("Product with id " + order.getDate() + " has been added to the cart.");
        } else {
            // Failed to add the product to the cart
            System.out.println("run at here 006");
            System.out.println("Failed to add product with id " +  order.getDate() + " to the cart.");
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        // You may throw an exception or handle the SQLException accordingly
    }
}

}



