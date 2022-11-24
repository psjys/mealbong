'use strict';

let space = document.querySelector('.space'),
    spaceBtn = space.querySelector('.space-close');

spaceBtn.addEventListener('click', function () {
    space.style.visibility = 'hidden';
    spaceBtn.style.visibility = 'hidden';
    space.style.height = 0 + 'px';
});