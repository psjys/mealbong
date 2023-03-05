'use strict';

// const content = document.querySelector('.content'),
//     inquiry_box = content.querySelector('.qna_list'),
//     inquiry_list_content = content.querySelectorAll('.ans'),
//     inquiry_list_Box = content.querySelectorAll('.list_Box');
//
// let current = inquiry_list_content[0];
// let next;
//
// inquiry_box.addEventListener("click", function (e) {
//
//     let oj = e.target.closest('.inquiry_list_Box');
//     if (this.contains(oj)) {
//
//         if (oj.children[1].classList.contains('hidden')) {
//             current.classList.add('hidden')
//             oj.children[1].classList.remove('hidden');
//         }
//         else {
//             oj.children[1].classList.add('hidden');
//         }
//         current = oj.children[1];
//     }
// });

// let currentBtn = inquiry_button[0];


// inquiry_list_btn.addEventListener('click', function (e) {
//     let oj = e.target.closest('button')

//     if (this.contains(oj)) {
//         current.classList.add('hidden');
//         currentBtn.style.opacity = '0.5';

//         for (let i = 0; i < inquiry_list_Box.length; i++) {
//             inquiry_list_Box[i].classList.add('hidden');
//         }

//         oj.style.opacity = '1';

//         currentBtn = oj;

//         for (let i = oj.textContent * 10 - 10; i < ((inquiry_list_Box.length / oj.textContent * 10 > 1) ? (oj.textContent * 10) : ((oj.textContent * 10) - (10 - inquiry_list_Box.length % 10))); i++) {
//             inquiry_list_Box[i].classList.remove('hidden');
//         }
//     }
// })

// 글자수 제한
function check_lth (area) {
    let text = area.value;
    let text_length = text.length;
    // let counter = document.querySelector('#counter');
    // counter.html(content.length+" / 500 자");

    let max_length = 500;
    if (text_length > max_length) {
        alert(max_length+ "자 이상 입력할 수 없습니다.");
        text = text.substring(0, max_length);
        area.value = text;
        area.focus();
    }
}