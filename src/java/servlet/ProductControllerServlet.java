/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.CartDao;
import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Cart;
import model.Product;

/**
 *
 * @author admin
 */
public class ProductControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet StudentControllerServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet StudentControllerServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
    String theCommand = request.getParameter("command");
    if (theCommand == null) {
        theCommand = "LIST";
    }
    switch (theCommand) {
        case "LIST":
            listProducts(request, response);
            break;
        case "DETAIL":
            detailProduct(request, response);
            break;
//        case "LOAD":
//            loadStudent(request, response);
//            break;
//        case "UPDATE":
//            updateStudent(request, response);
//            break;
//        case "DELETE":
//            deleteStudent(request, response);
//            break;
        default:
            listProducts(request, response);
    }
} catch (Exception ex) {
    Logger.getLogger(ProductControllerServlet.class.getName()).log(Level.SEVERE, null, ex);
}

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws Exception {
   
    ProductDao productDao = new ProductDao();
    CartDao cartDao = new CartDao();
    List<Cart> carts  = cartDao.getCarts();
    List<Product> list =  productDao.getProducts();
    request.setAttribute("products", list);
    RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
    dispatcher.forward(request, response);
}
private void detailProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
  
    ProductDao productDao = new ProductDao();
    int id = Integer.parseInt(request.getParameter("id_product"));
    Product product =  productDao.getSingleProduct(id);
    request.setAttribute("product", product);
    System.out.println("servlet--------------------00 ::: " + product);
    RequestDispatcher dispatcher = request.getRequestDispatcher("detail.jsp");
    dispatcher.forward(request, response);
}


}
