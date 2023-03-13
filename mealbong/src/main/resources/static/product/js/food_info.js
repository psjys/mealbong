'use strict';

/* =====================좋아요 및 장바구니 modal box==================== */
/* 로그인 하기 전 */

const modall = document.querySelector('.modal_container'),
    bgg = document.querySelector('.bg'),
    bodyy = document.querySelector('body'),
    headerr = document.querySelector('nav'),
    modalBox = modall.querySelector('.modalBox'),
    modal_p = modall.querySelector('p'),
    closeBtnn = document.querySelector('.closeBtn'),
    innerbox2 = document.querySelector('.innerbox2'),
    basket = innerbox2.querySelector('.basket'),
    wish = innerbox2.querySelector('.wish'),
    outerbox2 = document.querySelector('.outerbox2'),
    product_review = outerbox2.querySelector('.product_review'),
    product_inquiry = outerbox2.querySelector('.product_inquiry');

const openn = () => {
    modall.classList.remove('hidden');
    bodyy.classList.add('scroll_none');
    headerr.style.position = 'static';
    navv.style.zIndex = '0';
}

const closee = () => {
    modall.classList.add('hidden');
    bodyy.classList.remove('scroll_none');
    headerr.style.position = 'sticky';
    navv.style.zIndex = '2';
}

wish.addEventListener('click', () => {

    modal_f("로그인 하셔야 본 서비스를 이용하실 수 있습니다.");
});

basket.addEventListener('click', () => {

    modal_f("로그인 하셔야 본 서비스를 이용하실 수 있습니다.");
});

product_review.addEventListener('click', () => {

    modal_f("로그인 하셔야 본 서비스를 이용하실 수 있습니다.");
});

product_inquiry.addEventListener('click', () => {

    modal_f("로그인 하셔야 본 서비스를 이용하실 수 있습니다.");
});

function modal_f(str) {
    openn();
    modal_p.textContent = str;
}

closeBtnn.addEventListener('click', closee);
bgg.addEventListener('click',() => {
    closee();
    SNS_close();
});





/* ===================== 장바구니 modal box ================== */
/* 로그인 하고 나서 */


/* ===================== 좋아요 modal box ==================== */
/* 로그인 하고 나서 */

/* ===================== SNS 공유하기 ==================== */

const share = innerbox2.querySelector('#share'),
    SNS = document.querySelector('.SNS_container'),
    SNS_Box = SNS.querySelector('.SNS_Box'),
    SNS_closeBtn = SNS_Box.querySelector('.SNS_closeBtn'),
    navv = document.querySelector('nav');

share.addEventListener('click', () => {

    modal_s();
});

const SNS_open = () => {
    SNS.classList.remove('hidden');
    bodyy.classList.add('scroll_none');
    headerr.style.position = 'static';
    navv.style.zIndex = '0';
}

const SNS_close = () => {
    SNS.classList.add('hidden');
    bodyy.classList.remove('scroll_none');
    headerr.style.position = 'sticky';
    navv.style.zIndex = '2';
}

function modal_s() {
    SNS_open();
}

SNS.addEventListener('click', function (e) {
    if (e.target.closest('button')) {
        SNS_close();
    }
});

// 상품 수량에 따라 가격 바뀌게

const amount = innerbox2.querySelector('input'),
      total_amount = innerbox2.querySelector('#total_amount'),
      product_price = innerbox2.querySelector('.product_price');

amount.addEventListener('click', function (e) {
console.log(total_amount.children[1].textContent);
    total_amount.children[1].textContent = `${e.target.value * product_price.childNodes[1].textContent / 1000},000`;
})
