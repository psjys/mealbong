'use strict';

let topBtn = document.querySelector('.topButton'),
    mainBanner = document.querySelector('.main-banner');

// 메인 배너
let imgArr = [
    'image/banner3.png',
    'image/banner1.jpg',
    'image/banner2.jpg',
    'image/banner4.jpg',
];

for (let i = 0; i < imgArr.length; i++) {
    mainBanner.innerHTML += `<li><a href="#"><img src="${imgArr[i]}" alt="banner" class="banner"></a></li>`;
}


// 슬라이드 함수 

let imgSlide = setInterval(function () {

});

// ============================================================
// 탑버튼
document.addEventListener('scroll', () => {
    if (parseInt(window.scrollY) >= innerHeight / 3) {
        topBtn.classList.add('btnScroll');
    } else {
        topBtn.classList.remove('btnScroll');
    }
});

topBtn.addEventListener('mouseenter', () => {
    topBtn.classList.add('btnHover');
});

topBtn.addEventListener('mouseleave', () => {
    topBtn.classList.remove('btnHover');
});

topBtn.addEventListener('click', function (e) {
    e.preventDefault();
    window.scrollTo({
        top: 0, behavior: 'smooth'
    });
});



// ============================================================
// 메뉴 슬라이드
let menuContainer = document.querySelector('.menuContainer'),
    menuDiv = menuContainer.querySelector('.main-top'),
    menuBackBtn = menuContainer.querySelector('.btn_back'),
    menuForwardBtn = menuContainer.querySelector('.btn_forward'),
    menu = menuDiv.querySelectorAll('.pop_pro');

let slide_idx = 0,
    slide_endidx = menu.length - 1,
    beforeTime = -new Date();

//연속클릭방지 지연시간
function time() {
    let currentTime = new Date();

    if (currentTime - beforeTime > 1000) {
        beforeTime = currentTime;
        return true;
    }
}

// 버튼

function back() {
    if (slide_idx != 0) {
        slide_idx = slide_idx + +menuBackBtn.dataset.moveValue;
    }

    menuForwardBtn.classList.remove('nonVisible');
    if (slide_idx <= 0) {
        menuBackBtn.classList.add('nonVisible');
    }
}

function forward() {
    slide_idx = slide_idx + +menuForwardBtn.dataset.moveValue;

    menuBackBtn.classList.remove('nonVisible');
    if (slide_idx >= slide_endidx) {
        menuForwardBtn.classList.add('nonVisible');
    }
}

menuContainer.addEventListener('click', function (e) {
    if (time()) {
        e.preventDefault();
        const btn = e.target.closest('a');
        if (btn === menuBackBtn) {
            back();
        } else if (btn === menuForwardBtn) {
            forward();
        }
        menu[0].style.left = `${slide_idx * -100}%`;
    }
});