package dao;

import dbcontext.ConnectDB;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.*;

public class ProductDao {

    public ProductDao() {
    }

   public List<Product> getProducts() throws Exception {
    List<Product> productList = new ArrayList<>();
    ConnectDB db = ConnectDB.getInstance();
    String sql = "SELECT * FROM Products";
    try (Connection con = db.openConnection();
         PreparedStatement statement = con.prepareStatement(sql);
         ResultSet rs = statement.executeQuery()) {
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String category = rs.getString("category");
            double price = rs.getDouble("price");
            String image = rs.getString("image");
            Product product = new Product(id, name, category, price, image);
            productList.add(product);
        }
    } catch (SQLException ex) {
        Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
    }
    Logger.getLogger(ProductDao.class.getName()).log(Level.INFO, "Products retrieved: {0}", productList.size());
    return productList;
}

  

    public Product getSingleProduct(int id) {
        Product row = null;
         ConnectDB db = ConnectDB.getInstance();
        try {
            Connection con = db.openConnection();
           String query = "select * from products where id=? ";

           PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                row = new Product();
                row.setId(rs.getInt("id"));
                row.setName(rs.getString("name"));
                row.setCategory(rs.getString("category"));
                row.setPrice(rs.getDouble("price"));
                row.setImage(rs.getString("image"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        return row;
    }
//
//    public double getTotalCartPrice(ArrayList<Cart> cartList) {
//        double sum = 0;
//        try {
//            if (cartList.size() > 0) {
//                for (Cart item : cartList) {
//                    query = "select price from products where id=?";
//                    pst = this.con.prepareStatement(query);
//                    pst.setInt(1, item.getId());
//                    rs = pst.executeQuery();
//                    while (rs.next()) {
//                        sum += rs.getDouble("price") * item.getQuantity();
//                    }
//
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
//        return sum;
//    }
//
//    public List<Cart> getCartProducts(ArrayList<Cart> cartList) {
//        List<Cart> book = new ArrayList<>();
//        try {
//            if (cartList.size() > 0) {
//                for (Cart item : cartList) {
//                    query = "select * from products where id=?";
//                    pst = this.con.prepareStatement(query);
//                    pst.setInt(1, item.getId());
//                    rs = pst.executeQuery();
//                    while (rs.next()) {
//                        Cart row = new Cart();
//                        row.setId(rs.getInt("id"));
//                        row.setName(rs.getString("name"));
//                        row.setCategory(rs.getString("category"));
//                        row.setPrice(rs.getDouble("price") * item.getQuantity());
//                        row.setQuantity(item.getQuantity());
//                        book.add(row);
//                    }
//
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//        }
//        return book;
//    }
}
