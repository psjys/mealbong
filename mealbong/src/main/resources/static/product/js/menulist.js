'use strict'
/* ===================== 상품 리스트 정렬 ==================== */
const innerbox23 = document.getElementById("innerbox23")

let category_title = innerbox23.childNodes[1].textContent,
    category_code;

switch (category_title) {
case "한식" :
category_code = "C_01";
break;
case "중식" :
category_code = "C_02";
break;
case "일식" :
category_code = "C_03";
break;
case "양식" :
category_code = "C_04";
break;
case "분식/야식" :
category_code = "C_05";
break;
case "아시안" :
category_code = "C_06";
break;
}


function productList_order(orderList) {
    console.log(category_code);
    $.ajax({
        type: 'Get',
        url: 'productList2',
        data : {orderKey : orderList,
                currPage : 1,
                rowsPerPage : 8,
                category_code : category_code
              },
        success: function (resultPage) {
        console.log("성성공");
          $('#resultArea').html(resultPage);
        },
        error: function () {
        console.log("실실패");
          $('#resultArea').html('~~ Error 발생 !!! ~~~');
        }
      }); //ajax
}

productList_order(1);



// ===========================================================
// menulist에서 이미지 호버했을 때 이미지 확대

let outerbox = document.querySelector('.outerbox'),
    innerbox3 = outerbox.querySelector(".innerbox3"),
    img_container = innerbox3.querySelectorAll('.img_container'),
    food_img = innerbox3.querySelectorAll('img');


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


// ===========================================================
// innerbox1, innerbox2 a 태그들 클릭시 색깔
// 테마별, 순위별 a 태그들


let innerbox1 = outerbox.querySelector('.innerbox1'),
    innerbox2 = outerbox.querySelector('.innerbox2'),
    category = innerbox1.querySelectorAll('a'),
    theme = innerbox2.querySelectorAll('a');

let currentIdx = 0;

const urlParams = new URL(location.href).searchParams;
let name = urlParams.get('category_code');
let aTag = document.querySelectorAll('.innerbox1 a');

window.addEventListener('load', function (){

    switch (name) {
        case 'C_01' :
            aTag[0].style.color = 'lightsalmon';
            aTag[0].style.fontWeight = 'bold';
            break;

        case 'C_02' :
            aTag[1].style.color = 'lightsalmon';
            aTag[1].style.fontWeight = 'bold';
            break;

        case 'C_03' :
            aTag[2].style.color = 'lightsalmon';
            aTag[2].style.fontWeight = 'bold';
            break;
                case 'C_04' :
            aTag[3].style.color = 'lightsalmon';
            aTag[3].style.fontWeight = 'bold';
            break;
                case 'C_05' :
            aTag[4].style.color = 'lightsalmon';
            aTag[4].style.fontWeight = 'bold';
            break;
                case 'C_06' :
            aTag[5].style.color = 'lightsalmon';
            aTag[5].style.fontWeight = 'bold';
            break;
    }
});

innerbox2.addEventListener('click', function (e) {
    let obj = e.target.closest('a');

    if (this.contains(obj)) {
        theme[currentIdx].classList.remove('selected');

        obj.classList.add('selected');

        currentIdx = obj.dataset.direction;
    }
})


/* =====================장바구니 modal box==================== */
/* 로그인 하기 전 */

const modall = document.querySelector('.modal_container'),
    bgg = document.querySelector('.bg'),
    bodyy = document.querySelector('body'),
    headerr = document.querySelector('header'),
    modal_p = modall.querySelector('p'),
    closeBtnn = document.querySelector('.closeBtn'),
    basket = innerbox3.querySelectorAll('.basket');

const openn = () => {
    modall.classList.remove('hidden');
    bodyy.classList.add('scroll_none');
    headerr.style.position = 'static';
}

const closee = () => {
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

