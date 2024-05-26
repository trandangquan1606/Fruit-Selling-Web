

/* global i */

document.addEventListener("DOMContentLoaded", function () {
    var buttons = document.querySelectorAll(".btn-category");
    var bgColor = getComputedStyle(document.documentElement).getPropertyValue("--orange");
    var lightGrey = getComputedStyle(document.documentElement).getPropertyPriority('--light-grey');
    console.log('check color :::', buttons);
    buttons.forEach(function (button) {
        button.addEventListener("click", function () {
            // Đặt màu trắng cho tất cả các nút
            buttons.forEach(function (btn) {
                btn.style.backgroundColor = lightGrey;
                btn.style.color = "black";
            });

            // Đặt màu nền mới cho nút được nhấn
            button.style.backgroundColor = bgColor;
            button.style.color = "white";

            // Lấy văn bản của nút và ghi log
            var buttonText = button.textContent;
            console.log("Button text: " + buttonText);
        });
    });

});


var productList = document.querySelector(".product-list");
const listProduct = [
    {
        id: 1,
        pr_name: "Grapes",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-5.jpg",
        pr_price: 4.99,
        pr_des: "Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt"
    },
    {
        id: 2,
        pr_name: "Apricots",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-4.jpg",
        pr_price: 4.99,
        pr_des: "Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt"
    },
    {
        id: 3,
        pr_name: "Banana",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-3.jpg",
        pr_price: 4.99,
        pr_des: "Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt"
    },
    {
        id: 4,
        pr_name: "Raspberries",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-2.jpg",
        pr_price: 4.99,
        pr_des: "Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt"
    },
    {
        id: 5,
        pr_name: "Oranges",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-1.jpg",
        pr_price: 4.99,
        pr_des: "Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt"
    },
    {
        id: 6,
        pr_name: "Apples",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-6.jpg",
        pr_price: 4.99,
        pr_des: "Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt"
    },
    {
        id: 7,
        pr_name: "Grapes",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-5.jpg",
        pr_price: 4.99,
        pr_des: "Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt"
    },
    {
        id: 8,
        pr_name: "Grapes",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-5.jpg",
        pr_price: 4.99,
        pr_des: "Lorem ipsum dolor sit amet consectetur adipisicing elit sed do eiusmod te incididunt"
    }
];
listProduct.forEach((product) => {
    var productCard = document.createElement('div');
    productCard.className = "product-card";

    var productCardImage = document.createElement('div');
    productCardImage.className = "product-card-image";
    productCardImage.innerHTML = `<img src=${product.pr_thumbnail} alt="alt"/>`;

    var productCardBody = document.createElement('div');
    productCardBody.className = "product-card-body";
    productCardBody.innerHTML = `
        <h2>${product?.pr_name}</h2>
        <p class="product-card-des">${product.pr_des}</p>
        <div class = "product-price">
            <h5>\$${product.pr_price}/kg</h5>
            <div class ="btn-icon">
                <ion-icon name="cart-outline"></ion-icon>
                <button>Add to cart</button>
            </div>
        </div>`;

    productCard.appendChild(productCardImage);
    productCard.appendChild(productCardBody);
    productList.appendChild(productCard);
});



//Product self


const listProductSell = [
    {
        id: 1,
        pr_name: "Grapes",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-5.jpg",
        pr_price: 4.99,
        pr_rate: 5,
    },
    {
        id: 2,
        pr_name: "Apricots",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-4.jpg",
        pr_price: 4.99,
        pr_rate: 5,
    },
    {
        id: 3,
        pr_name: "Banana",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-3.jpg",
        pr_price: 4.99,
        pr_rate: 5,
    },
    {
        id: 4,
        pr_name: "Raspberries",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-2.jpg",
        pr_price: 4.99,
        pr_rate: 5,
    },
    {
        id: 5,
        pr_name: "Oranges",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-1.jpg",
        pr_price: 4.99,
        pr_rate: 5,
    },
    {
        id: 6,
        pr_name: "Apples",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-6.jpg",
        pr_price: 4.99,
        pr_rate: 5,
    },
    {
        id: 7,
        pr_name: "Grapes",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-5.jpg",
        pr_price: 4.99,
        pr_rate: 5,
    },
    {
        id: 8,
        pr_name: "Grapes",
        pr_thumbnail: "https://themewagon.github.io/fruitables/img/fruite-item-5.jpg",
        pr_price: 4.99,
        pr_rate: 5,
    }
];
var productSellList = document.querySelector(".productSell-list-card");
// number of cart
var productNumberCard = document.querySelector(".header-cart-number");
productNumberCard.innerText = 1;
console.log('check number of cart', productNumberCard.innerText);
listProductSell.forEach((product) => {

    var template = document.querySelector('template');
    var clone = document.importNode(template.content, true);
    var productPrice = clone.querySelector(".productSell-card-price");
    var productThumbnail = clone.querySelector(".productSell-card-image img");
    var productRate = clone.querySelector(".group-star");
    var productName = clone.querySelector(".productSell-card-name");
    var productBtnAdd = clone.querySelector(".btn-icon");


    var cartIcon = document.createElement('ion-icon');
    cartIcon.setAttribute("name", "cart-outline");
    cartIcon.style.fontSize = "25px";
    cartIcon.style.fontWeight = "bold";
    productBtnAdd.appendChild(cartIcon);

    var buttonAdd = document.createElement('button');
    buttonAdd.textContent = "Add to card";
    productBtnAdd.appendChild(buttonAdd);

    productBtnAdd.addEventListener('click', () => {
        productNumberCard.innerText = 2; tt;

        alert('click me!');
    });


    productThumbnail.src = product.pr_thumbnail;
    productPrice.textContent = `${product.pr_price} \$`;
    productPrice.style.fontSize = "20px";
    productPrice.style.fontWeight = "bold";
    productName.textContent = product.pr_name;

    var productCardInfo = clone.querySelector('.productSell-card-info');
    // Xóa bỏ nội dung cũ của productRate trước khi thêm mới
    productRate.innerHTML = '';

    // Thêm icon sao vào trong productRate trong mỗi lần lặp
    for (var i = 0; i < product.pr_rate; i++) {
        var starIcon = document.createElement('ion-icon');
        starIcon.setAttribute('name', 'star');
        productRate.appendChild(starIcon);
    }

    // Thêm các phần tử con vào phần tử gốc productCardInfo
    productCardInfo.appendChild(productName);
    productCardInfo.appendChild(productRate);
    productCardInfo.appendChild(productPrice);
    productCardInfo.appendChild(productBtnAdd);
    productSellList.appendChild(clone);

});




// CHECK OUT

var checkout = document.querySelector(".checkout");
console.log('check checkout :::: ', checkout);


//SEARCH 
var btnSearch = document.querySelector(".btn-search");
var searchCancel = document.querySelector(".search-cancel");
var searchPage = document.querySelector(".search");
var computedStyle = window.getComputedStyle(searchPage);

console.log('check btn search', searchPage);

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

