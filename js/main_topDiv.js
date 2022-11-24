'use strict';

// 상단 div 숨기기 

let space = document.querySelector('.space'),
    spaceBtn = space.querySelector('.space-close');

spaceBtn.addEventListener('click', function () {
    space.style.visibility = 'hidden';
    spaceBtn.style.visibility = 'hidden';
    space.style.height = 0 + 'px';
});

// 버튼 클릭 시 검색 페이지 넘어가기 / alert 팝업 뜨기 

let searchDiv = document.querySelector('.search'),
    button = searchDiv.querySelector('.button'),
    buttonInput = document.getElementById('search_input');

function search(e) {
    let searchInput = buttonInput.value;

    if (searchInput == "") {
        e.preventDefault();
        alert("검색어를 입력해 주세요");
    }
}

buttonInput.addEventListener('keydown', function (e) {
    if (e.key == 'Enter') {
        e.preventDefault();
        button.click();
    }
});

button.addEventListener('click', function (e) {
    search(e);
});

// 호버 했을 때 커지는거 

let innerbox3 = document.querySelectorAll('.pop_pro'),
    img_container = document.querySelectorAll('.img_container'),
    food_img = document.querySelectorAll('.img_container img');

for (let i = 0; i < img_container.length; i++) {
    food_img[i].addEventListener('mouseenter', function (event) {
        event.target.style.transform = "scale(1.1)"
        event.target.style.transition = "all 0.5s"
    });

    food_img[i].addEventListener('mouseleave', function (event) {
        event.target.style.transform = "scale(1)"
        event.target.style.transition = "all 0.5s"
    });
}

// 장바구니 팝업

const modal = document.querySelector('.modal_container'),
    bg = document.querySelector('.bg'),
    body = document.querySelector('body'),
    header = document.querySelector('nav'),
    modal_p = modal.querySelector('p'),
    closeBtn = document.querySelector('.closeBtn'),
    basket = document.querySelectorAll('.basket');

const open = () => {
    modal.classList.remove('hidden');
    body.classList.add('scroll_none');
    header.style.position = 'static';
}

const close = () => {
    modal.classList.add('hidden');
    body.classList.remove('scroll_none');
    header.style.position = 'sticky';
}

for (let i = 0; i < basket.length; i++) {

    basket[i].addEventListener('click', () => {
        modal_f("로그인 하셔야 본 서비스를 이용하실 수 있습니다.");
    });
}

function modal_f(str) {
    open();
    modal_p.textContent = str;
}

closeBtn.addEventListener('click', close);
bg.addEventListener('click', close);