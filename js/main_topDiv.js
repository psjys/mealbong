'use strict';

// 상단 div 숨기기 

let space = document.querySelector('.space'),
    spaceBtn = space.querySelector('.space-close');

spaceBtn.addEventListener('click', function () {
    space.style.visibility = 'hidden';
    spaceBtn.style.visibility = 'hidden';
    space.style.height = 0 + 'px';
});

