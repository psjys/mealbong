'use strict';

// 호버 했을 때 커지는거

let innerbox3 = document.querySelectorAll('.pop_pro'),
    img_container1 = document.querySelectorAll('.img_container'),
    food_img1 = document.querySelectorAll('.img_container img');

for (let i = 0; i < img_container1.length; i++) {
    food_img1[i].addEventListener('mouseenter', function (event) {
        event.target.style.transform = "scale(1.1)";
        event.target.style.transition = "all 0.5s";
    });

    food_img1[i].addEventListener('mouseleave', function (event) {
        event.target.style.transform = "scale(1)";
        event.target.style.transition = "all 0.5s";
    });
}

// 장바구니 팝업

const modal1 = document.querySelector('.modal_container'),
    bg1 = document.querySelector('.bg'),
    body1 = document.querySelector('body'),
    header1 = document.querySelector('nav'),
    modal_p1 = modal1.querySelector('p'),
    closeBtn1 = document.querySelector('.closeBtn'),
    basket1 = document.querySelectorAll('.basket');

const open1 = () => {
    modal1.classList.remove('hidden');
    body1.classList.add('scroll_none');
    header1.style.position = 'static';
}


const close1 = () => {
    modal1.classList.add('hidden');
    body1.classList.remove('scroll_none');
    header1.style.position = 'sticky';
}

for (let i = 0; i < basket1.length; i++) {

    basket1[i].addEventListener('click', () => {
        modal_f("로그인 하셔야 본 서비스를 이용하실 수 있습니다.");
    });
}

function modal_f(str) {
    open1();
    modal_p1.textContent = str;
}

closeBtn1.addEventListener('click', close1);
bg1.addEventListener('click', close1);