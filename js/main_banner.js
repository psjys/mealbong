'use strict';

let slides = document.querySelector('.main-banner'),
    slide = document.querySelectorAll('.main-banner li'),
    currentIdx = 0,
    slideCount = slide.length,
    container = document.querySelector('.slide-container')
    prevBtn = container.querySelector('.btn_left'),
    nextBtn = container.querySelector('.btn_right');

function moveSlide(num) {
    slides.style.left = -num * 100 +'%';
    currentIdx = num;
} 

container.addEventListener('click', function (e) {
    // e.preventDefault();
    console.log(e.target);
    if (currentIdx < slideCount - 1) {
        moveSlide(currentIdx + 1);
        console.log(currentIdx);
    }
});

console.log(document.querySelector('.btn_left'));