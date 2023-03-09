'use strict';

// document.querySelectorAll('.clickable').forEach((button, i, buttons) => {
//     button.addEventListener('click', e => {
//         buttons.forEach(btn => btn.classList.remove('clicked'));
//         e.target.classList.add('clicked');
//     });
// });
//
// $('.clickable').click(function(){
//
//     $('.clickable').not(this).removeClass('active');
//
//     $(this).toggleClass('active');
//
// });

const urlParams = new URL(location.href).searchParams;
let name = urlParams.get('searchType');
let aTag = document.querySelectorAll('.aTag a');

window.addEventListener('load', function (){
    if (name = 'n') {
        aTag[3].style.backgroundColor = 'lightsalmon';
    }
})