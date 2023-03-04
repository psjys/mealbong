'use strict'

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
