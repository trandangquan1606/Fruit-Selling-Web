/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import dao.CartDao;
import dao.ProductDao;
import java.io.IOException;
import java.io.PrintWriter;
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
public class AddToCartServlet extends HttpServlet {

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
            listCart(request, response);
            break;
        case "ADD":
            addToCart(request, response);
            break;
        case "UPDATE":
            updateQuantity(request, response);
            break;
        case "DELETE":
            deleteCart(request, response);
            break;
        default:
            listCart(request, response);
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
    
    
    private void listCart(HttpServletRequest request, HttpServletResponse response) throws Exception {
   
    CartDao cartDao = new CartDao();
    List<Cart> list =  cartDao.getCarts();
    request.setAttribute("carts", list);
    RequestDispatcher dispatcher = request.getRequestDispatcher("cartpage.jsp");
    dispatcher.forward(request, response);
}
    
    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("run at here 001");
        CartDao cartDao  = new CartDao();
        ProductDao productDao = new ProductDao();
        List<Product> products = productDao.getProducts();
        String name = request.getParameter("name");
        String image =  request.getParameter("image");
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));
        System.out.println("run at here 002"+ name + "  " + image + "  " + quantity + "  " + price);
        cartDao.addToCart(name.trim(), quantity, price, image.trim());
         List<Cart> carts = cartDao.getCarts();
            request.setAttribute("products", products);
        request.setAttribute("carts", carts);
        RequestDispatcher dispatcher = request.getRequestDispatcher("products.jsp");
        dispatcher.forward(request, response);
    }
    private void updateQuantity(HttpServletRequest request, HttpServletResponse response) throws Exception{
    
    int idCart = Integer.parseInt(request.getParameter("id"));
    String type = request.getParameter("type");
    CartDao cartDao  = new CartDao();
     cartDao.updateQuantity(idCart, type);
    listCart(request,response);
  
    }
     private void deleteCart(HttpServletRequest request, HttpServletResponse response) throws Exception{
    
    int idCart = Integer.parseInt(request.getParameter("id"));

    CartDao cartDao  = new CartDao();
       cartDao.deleteCartItem(idCart);
    listCart(request,response);
 
    }
    
//
//private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    // read student info from the form
//    String firstName = request.getParameter("firstName");
//    String lastName = request.getParameter("lastName");
//    String email = request.getParameter("email");
//
//    // create a new student object
//    Student student = new Student(firstName, lastName, email);
//    
//    // add the student to the database
//    ProductDao ProductDao = new ProductDao();
//    ProductDao.addStudent(student);
//
//    // calling the student list jsp page
//    listStudents(request, response);
//}
//
//private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    // read student id from the form data
//    String theStudentId = request.getParameter("studentId");
//
//    // get student from the database
//    Student student = new ProductDao().getStudent(theStudentId);
//    
//    // place student in the request attribute
//    request.setAttribute("THE_STUDENT", student);
//
//    // send to jsp page: update-student-form.jsp
//    RequestDispatcher dispatcher = request.getRequestDispatcher("update-student-form.jsp");
//    dispatcher.forward(request, response);
//}
//
//private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    // read student info from the form data
//    int id = Integer.parseInt(request.getParameter("studentId"));
//    String firstName = request.getParameter("firstName");
//    String lastName = request.getParameter("lastName");
//    String email = request.getParameter("email");
//
//    // create a new student object
//    Student student = new Student(id, firstName, lastName, email);
//    
//    // perform update on database
//    new ProductDao().updateStudent(student);
//
//    // send them back to the "list student" page
//    listStudents(request, response);
//}
//
//private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
//    // read student id from the form data
//    String theStudentId = request.getParameter("studentId");
//
//    // delete student from the database
//    new ProductDao().deleteStudent(theStudentId);
//
//    // send them back to the "list student" page
//    listStudents(request, response);
//}
//

}
