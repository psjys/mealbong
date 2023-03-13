'use strict';
/* ===================== 상품 리스트 정렬 ==================== */

function productList_order(orderList) {
    $.ajax({
        type: 'Get',
        url: 'productList2',
        data : {orderKey : orderList,
                currPage : 1,
                rowsPerPage : 8,
                category_code : category_code
              },
        success: function (resultPage) {
          $('#resultArea').html(resultPage);
        },
        error: function () {
          $('#resultArea').html('~~ Error 발생 !!! ~~~');
        }
      }); //ajax
} // productList_order

//productList_order(1);



// ===========================================================
// menulist에서 이미지 호버했을 때 이미지 확대

var innerbox33 = document.querySelector(".innerbox3"),
    img_container = innerbox33.querySelectorAll('.img_container'),
    food_img = innerbox33.querySelectorAll('img');


for (let i = 0; i < img_container.length; i++) {


    food_img[i].addEventListener('mouseenter', function (event) {
        event.target.style.transform = "scale(1.1)"
        event.target.style.transition = "all 0.5s"
    })


    food_img[i].addEventListener('mouseleave', function (event) {
        event.target.style.transform = "scale(1)"
        event.target.style.transition = "all 0.5s"
    })
}


/* =====================장바구니 modal box==================== */
/* 로그인 하기 전 */

var modall = document.querySelector('.modal_container'),
    bgg = document.querySelector('.bg'),
    bodyy = document.querySelector('body'),
    headerr = document.querySelector('header'),
    modal_p = modall.querySelector('p'),
    closeBtnn = document.querySelector('.closeBtn'),
    basket = innerbox33.querySelectorAll('.basket');

var openn = () => {
    modall.classList.remove('hidden');
    bodyy.classList.add('scroll_none');
    headerr.style.position = 'static';
}

var closee = () => {
    modall.classList.add('hidden');
    bodyy.classList.remove('scroll_none');
    headerr.style.position = 'sticky';
}

for (let i = 0; i < basket.length; i++) {

    basket[i].addEventListener('click', () => {

        modal_f("로그인 하셔야 본 서비스를 이용하실 수 있습니다.");
    });
}


function modal_f(str) {
    openn();
    modal_p.textContent = str;
}

closeBtnn.addEventListener('click', closee);
bgg.addEventListener('click', closee);

/* =====================장바구니 modal box==================== */
/* 로그인 하고 나서 */

