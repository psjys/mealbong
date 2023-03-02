'use strict';

const main = document.querySelector('main'),
loginBtn = main.querySelector('.loginbutton'),
loginId = document.getElementById('user_id'),
loginPw = document.getElementById('user_password'),
login = document.querySelector('.login'),
login_li = login.getElementsByTagName('li'),
inputTag = main.getElementsByClassName('login-input'),
loginDiv = main.querySelector('.logindiv'),
nav = document.querySelector('nav'),
    failed_flag = document.querySelector('.failed_flag');

// ======모달참조
const modal = main.querySelector('.modal_container'),
bg = main.querySelector('.bg'),
body = document.querySelector('body'),
header = document.querySelector('header'),
modal_p = modal.querySelector('p'),
closeBtn = main.querySelector('.closeBtn');

let value1;
let test;
// const testbtn = document.getElementById('tbtn');
//
// testbtn.addEventListener('click',() =>{
//     $.ajax({
//         url:"http://localhost:8090/user1/login",
//         type: "POST",
//         data: {
//             user_id : $(loginId).val(),
//             user_password : $(loginPw).val()
//         },
//         success: function (json) {
//             if(json == "") {
//                 alert("json 비어있다는데?");
//             } else {
//                 alert("json 잘 넘어옴");
//                 sessionStorage.setItem("login", JSON.stringify(json));
//                 alert(`${json.user_name}님 환영합닌다!`);
//             }
//         },
//         error: function () {
//             alert("오류임");
//         }
//     });
// });

const open = () => {
    modal.classList.remove('hidden');
    body.classList.add('scroll_none');
    header.style.position = 'static';
    nav.style.zIndex = '0';
}
    if (+failed_flag.value.length > 0) {
        modal_p.textContent = failed_flag.value;
        open();
    }


const close = () => {
    modal.classList.add('hidden');
    body.classList.remove('scroll_none');
    header.style.position = 'sticky';
    nav.style.zIndex = '2';
    //failed_flag.value = "";
    // console.log(+failed_flag.value.length > 0);
    // console.log(failed_flag.value);
}

loginBtn.addEventListener('click', () => {
  //  failed_flag.value = "";
    if(loginId.value == ""){
        modal_f("아이디를 입력해 주세요");
    } else if(loginPw.value == "") {
        modal_f("비밀번호를 입력해 주세요");
    } else {
        loginBtn.setAttribute('type', 'submit');
    }



    console.log(+failed_flag.value.length);
    console.log(+failed_flag.value.length>0);


});

loginDiv.addEventListener('keydown', (e) => {
    if(e.key === 'Enter') {
        loginBtn.click();
    }
});


function modal_f (str) {
    open();
    modal_p.textContent = str;
}

closeBtn.addEventListener('click', close);
bg.addEventListener('click', close);

