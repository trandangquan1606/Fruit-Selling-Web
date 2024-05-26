/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

var checkout = document.querySelector(".checkout");
checkout.style.backgroundColor = "red";



//SEARCH 
var btnSearch = document.querySelector(".btn-search");
var searchCancel = document.querySelector(".search-cancel");
var searchPage = document.querySelector(".search");
var computedStyle = window.getComputedStyle(searchPage);

console.log('check btn search', btnSearch, checkout);

btnSearch.addEventListener('click', () => {
    if (computedStyle.display !== "none") {
        searchPage.style.display = "none";
    } else {
        searchPage.style.display = "block";
    }
});
searchCancel.addEventListener('click', () => {
    searchPage.style.display = "none";
});

//

var productNumberCard = document.querySelector(".header-cart-number");
productNumberCard.innerText = 1;
console.log('check number of cart', productNumberCard.innerText);

