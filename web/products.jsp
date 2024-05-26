<%-- 
    Document   : products
    Created on : Apr 13, 2024, 4:47:26 AM
    Author     : HP
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="dao.ProductDao"%>
<%@page import="model.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
User auth = (User) request.getSession().getAttribute("auth");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./assets/css/style.css" />
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
              crossorigin="anonymous">
        <title>JSP Page</title>
        <style>
            .header_nav{
                width: 100%;
                display:flex;
                justify-content: space-between !important;
                align-items: center;
                padding: 20px 60px;
                background-color: white !important;
                box-shadow: 0px 0.5px 10px grey;
                position: fixed;
                top: 0;
                left: 0;
                z-index: 99;
            }
            .navbar-brand{
                color:#81C408;
                font-size: var(--fontSize-4);
                font-weight: bold;
            }
            .btn{
                color: #81C408;
                font-size: 25px;
            }
            .btn-search{
                border: 1px solid #81C408;
                border-radius: 50%;
                width:35px;
                height:35px;
                display: flex;
                justify-content: center;
                align-items: center;

            }
            .btn-search:hover{
                background-color: var(--orange);
            }
            .header-tag{
                display: flex;
                margin-bottom: 0px;
                gap:20px;
            }
            .nav-item > a{
                font-size: var(--fontSize-2);
            }
            .header-btn-icon{
                display: flex;
                align-items: center;
            }
            .header-cart{
                position: relative;

            }
            .header-cart-number{
                position: absolute;
                top: -5px;
                right: 8px;
            }
            .product-title{
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 30px 74px
            }
            .product-category{
                display: flex;
                justify-content: space-between;
                align-items: center;
                gap:10px;
            }
            .btn-category{
                max-width: 130px;
                padding: 8px 10px;
                text-align: center;
                background-color: var(--light-grey);
                border-radius: 20px;
                min-width: 130px;
            }
            .product-list{
                display: flex;
                justify-content: center;
                flex-wrap: wrap;
                align-items: center;
                gap: 24px;
                padding: 0 60px;
            }
            .product-card{
                width: 261px;
                border: 0.5px solid var(--orange);
                border-radius: 10px;
            }
            .product-card-image{
                position: relative;
                width: 100%;
                height: 182px;
                overflow: hidden;
                border-radius: 10px 10px 0 0 ;
            }
            .product-card-image button{
                color: var(--white);
                background-color: var(--orange);
                padding: 5px 15px;
                border-radius: 24px;
                position: absolute;
                top: 15px;
                left: 15px;

            }
            .product-card-image img{
                width: 100%;
                height: 100%;
                object-fit: cover;
            }
            .product-card-image img:hover{
                transition: ease-in-out 0.2s;
                transform: scale(1.3);
            }
            .product-card-body{
                padding: 10px;
            }
            .btn-icon{
                display: flex;
                justify-content: space-between;
                align-items: center;
                border: 1px solid #81C408;
                padding: 3px 5px;
                border-radius: 20px;
            }
            .btn-icon > button{
                color: #81C408;
                font-size: 20px;
            }
            .product-card-des{
                display: -webkit-box;
                -webkit-line-clamp: 4;
                -webkit-box-orient: vertical;
                overflow: hidden;
            }
            .product-price{
                display: flex;
                justify-content: space-between;
                align-items: center;
            }

        </style>
    </head>

    <body>
        <%  String tag[] = {"Home", "Shop", "ShopDetail", "Contact", "checkout"};  %>

        <header>

            <div class="container-fluid header_nav ">
                <a class="navbar-brand" href="ProductControllerServlet">Fruitables</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <ul class="header-tag">
                    <% for (int i = 0; i < tag.length; i++) {%>
                    <li class="nav-item">
                        <a class="nav-link" href="#"><%= tag[i]%></a>
                    </li>
                    <% }%>
                </ul>
                <div class="header-btn-icon">
                    <button class = " btn btn-search">
                        <ion-icon name="search-outline"></ion-icon>
                    </button>
                    <div class="header-cart">
                        
                        <a href="OrderServlet">
                            <button class = "btn btn-cart">
                               <ion-icon name="bookmark-outline"></ion-icon>
                            </button>
                        </a> 
                        
                    </div>
                    <div class="header-cart">
                        <a href="AddToCartServlet">
                            <button class = "btn btn-cart">
                                <ion-icon name="cart-outline"></ion-icon>
                            </button>
                        </a> 
                        <div class="header-cart-number">
                            ${carts.size()}
                        </div>
                    </div>
                    <c:choose>
                        <c:when test="${auth == null}">
                            <a href="./login.jsp">
                                <button class="btn btn-person">
                                    <ion-icon name="person-outline"></ion-icon>
                                </button>
                            </a>
                        </c:when>
                        <c:otherwise>
                            <a href="LogOutServelet"><p>Logout</p></a>
                        </c:otherwise>
                    </c:choose>


                </div>

            </div>


        </header>

        <div class="product">
            <div class="product-title">
                <h1>
                    Our Organic
                    Product
                </h1>
                <div class = "product-category">
                    <% String categories[] = {"All product", "Vegetables", "Fruits", "Bread", "Meat"}; %>
                    <% for (int i = 0; i < categories.length; i++) {%>
                    <button class = "btn-category">
                        <%= categories[i]%>
                    </button>
                    <% }%>
                </div>

            </div>
            <div class="product-list">

                <c:forEach var="tempProduct" items="${products}" >
                    <div class="product-card">
                        <div class="product-card-image">
                            <c:url var = "detail" value="ProductControllerServlet">
                                <c:param name = "id_product" value = "${tempProduct.id}"></c:param>
                                 <c:param name="command" value="DETAIL"></c:param>
                            </c:url>
                            <a href="${detail}">
                                 <img src=${tempProduct.image} alt="alt"/>
                            </a>
                        </div>
                        <div class="product-card-body">
                            <h2>${tempProduct.name}</h2>
                            <p class="product-card-des">Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt</p>
                            <div class = "product-price">
                                <h5>
                                    ${tempProduct.price}
                                </h5>
                                <div class ="btn-icon">
                                    <ion-icon name="cart-outline"></ion-icon>
                                        <c:url var="add" value="AddToCartServlet">
                                            <c:param name="command" value="ADD"></c:param>
                                            <c:param name="name" value="${tempProduct.name}"></c:param>
                                            <c:param name="quantity" value="${1}"></c:param>
                                            <c:param name="price" value="${tempProduct.price}"></c:param>
                                            <c:param name="image" value="${tempProduct.image}"></c:param>
                                        </c:url>
                                    <a  href="${add}">
                                        <button>
                                            Add to card
                                        </button>
                                    </a>
                                </div>
                            </div>
                        </div>
                    </div> 
                </c:forEach>

            </div>
        </div>

    </body>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
    crossorigin="anonymous"></script>
    <script type="module" src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.esm.js"></script>
    <script nomodule src="https://unpkg.com/ionicons@7.1.0/dist/ionicons/ionicons.js"></script>


</html>
