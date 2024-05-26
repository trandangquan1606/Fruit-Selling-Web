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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;

/**
 *
 * @author admin
 */
public class CartDao {

    public CartDao() {
    }

    
    public Cart getCartById(int cartId) throws Exception {
    Cart cart = null;
    ConnectDB db = ConnectDB.getInstance();
    String sql = "SELECT * FROM Cart WHERE id = ?";
    try (Connection con = db.openConnection();
         PreparedStatement statement = con.prepareStatement(sql)) {
        statement.setInt(1, cartId);
        try (ResultSet rs = statement.executeQuery()) {
            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                cart = new Cart(id, name, image, price, quantity);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    if (cart != null) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.INFO, "Product retrieved: {0}", cart.getName());
    } else {
        Logger.getLogger(ProductDao.class.getName()).log(Level.INFO, "Product with ID " + cartId + " not found.");
      
    }
    return cart;
}

   public List<Cart> getCarts() throws Exception {
    List<Cart> cartList = new ArrayList<>();
    ConnectDB db = ConnectDB.getInstance();
    String sql = "SELECT * FROM Cart";
    try (Connection con = db.openConnection();
         PreparedStatement statement = con.prepareStatement(sql);
         ResultSet rs = statement.executeQuery()) {
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int quantity = rs.getInt("quantity");
            double price = rs.getDouble("price");
            String image = rs.getString("image");
            Cart cart = new Cart(id, name, image, price, quantity);
            cartList.add(cart);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    Logger.getLogger(ProductDao.class.getName()).log(Level.INFO, "Products retrieved: {0}", cartList.size());
       System.out.println("dao.CartDao.getCarts() -------------------- " + cartList.size());
    return cartList;
}
   
   public void updateQuantity(int idCart, String type) throws Exception {
    
       
    Cart cart = this.getCartById(idCart);
     if (cart == null) {
        System.out.println("Product with ID " + idCart + " not found.");
        return;
    }
    
    // Xác định hành động cần thực hiện (tăng hoặc giảm)
    int newQuantity = cart.getQuantity();
    if ("up".equals(type)) { // Nếu type là 1, tăng số lượng
        newQuantity++;
         System.out.println("dao.CartDao.updateQuantity()1"+ newQuantity);
    } else if ("down".equals(type)) { // Nếu type là -1, giảm số lượng
        newQuantity--;
        System.out.println("dao.CartDao.updateQuantity()2"+ newQuantity);
    } else {
        System.out.println("Invalid type: " + type);
        return;
    }
    ConnectDB db = ConnectDB.getInstance();
    String sqlUpdate = "UPDATE Cart SET quantity = ? WHERE id = ?";
    
       try {
         Connection con = db.openConnection();
         PreparedStatement updateStatement = con.prepareStatement(sqlUpdate);
         updateStatement.setInt(1, newQuantity);
          updateStatement.setInt(2, cart.getId());
          updateStatement.executeUpdate();
       } catch (Exception e) {
       }
}

   
   public void deleteCartItem(int idCart) throws Exception {
    ConnectDB db = ConnectDB.getInstance();
    String sql = "DELETE FROM Cart WHERE id = ?";
    
    try (Connection con = db.openConnection();
         PreparedStatement statement = con.prepareStatement(sql)) {
         
        // Set parameter for the DELETE query
        statement.setInt(1, idCart);
        
        // Execute the DELETE query
        int rowsAffected = statement.executeUpdate();
        
        if (rowsAffected > 0) {
            // The record was successfully deleted
            System.out.println("Record with id " + idCart + " has been deleted.");
        } else {
            // No record found with the given idCart
            System.out.println("No record found with id " + idCart);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        // You may throw an exception or handle the SQLException accordingly
    }
}

   public void addToCart(String name, int quantity,double price,String image) throws Exception {
    ConnectDB db = ConnectDB.getInstance();
    String sql = "INSERT INTO Cart (name, quantity,price,image) VALUES (?, ?,?,?)";
    
    try (Connection con = db.openConnection();
         PreparedStatement statement = con.prepareStatement(sql)) {
         
        // Set parameters for the INSERT query
        statement.setString(1, name);
        statement.setInt(2, quantity);
         statement.setDouble(3, price);
          statement.setString(4, image);
        // Execute the INSERT query
        int rowsAffected = statement.executeUpdate();
        
        if (rowsAffected > 0) {
            // The product has been added to the cart successfully
            System.out.println("Product with id " + name + " has been added to the cart.");
        } else {
            // Failed to add the product to the cart
            System.out.println("Failed to add product with id " + name + " to the cart.");
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
        // You may throw an exception or handle the SQLException accordingly
    }
}

}


