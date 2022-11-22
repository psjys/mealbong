'use strict';

let mainBanner = document.querySelector('.main-banner'),
    slide_list_li = mainBanner.querySelectorAll('li'),
    button = mainBanner.querySelectorAll('.mainButton');

// 메인 배너
let imgArr = [
    'image/banner3.png',
    'image/banner1.jpg',
    'image/banner2.jpg',
    'image/banner4.jpg',
];

for (let i = 0; i < imgArr.length; i++) {
    mainBanner.innerHTML += `<li><img src="${imgArr[i]}" alt="banner" class="banner"></li>`;
}

let beforeIdx = 0,
    i = 0;

function slideImg() {
    // 이미지 슬라이드
    slide_list_li[i].style.left = `0`;
    if (beforeIdx > i) {
        slide_list_li[beforeIdx].style.left = '100%';
    }
    else if (beforeIdx < i) {
        slide_list_li[beforeIdx].style.left = '-100%';
    }

    // slide_list_li[i].classList.remove('nonVisible');
    // slide_list_li[beforeIdx].classList.add('nonVisible');
    slide_list_li[(i + 1) % slide_list_li.length].style.left = '100%';
}

// 자동 슬라이드 
let slide = setInterval(function () {
    i = ++i % slide_list_li.length;
    slideImg();
}, 1500);

mainBanner.addEventListener('mouseenter', function () {
    clearInterval(slide);
});

