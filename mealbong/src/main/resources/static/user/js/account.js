'use strict';

const main = document.querySelector('main'),
    user_id = document.getElementById('user_id'),
    idCheck = main.querySelector('.idCheck'),
    emailCheck = main.querySelector('.emailCheck'),
    upw = document.getElementById('upw'),
    upw2 = document.getElementById('upw2'),
    user_email = document.getElementById('user_email'),
    phoneCheck = main.querySelector('.phoneCheck'),
    user_phone = document.getElementById('user_phone'),
    phone_num = document.getElementById('phone_num'),
    checkBtn4 = main.querySelector('.checkBtn4'),
    Btn4_box = main.querySelector('.Btn4_box'),
    button_submit = main.querySelector('.button_submit'),
    uname = document.getElementById('uname'),
    addressbutton = document.querySelector('.addressbutton'),
    account_p = main.querySelector('.account_p'),
    account_p2 = main.querySelector('.account_p2'),
    address_input = document.getElementById('address_input'),
    pwCheck = main.querySelector('.pwCheck'),
    user_password3 = document.getElementById('user_password3'),
    user_birth = document.getElementById('user_birth');

   let userZip = main.querySelector('.userZip');


// ======모달참조
const modal = main.querySelector('.modal_container'),
    bg = main.querySelector('.bg'),
    body = document.querySelector('body'),
    header = document.querySelector('header'),
    modal_p = modal.querySelector('p'),
    closeBtn = main.querySelector('.closeBtn');
//
// // ==========정규식
//
// // const regex = /^[a-zA-Z0-9]{4,12}$/
 const regex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,16}$/;
 // const regPass = /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{10,20}$/;
 const regPass = /^(?=.*[a-zA-Z])(?=.*[!@#$%^&*+=-])(?=.*[0-9]).{5,20}$/;
 const regMail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
//
// // ===================================================
//
//
let clr1,clr2,clr3;
// checkBtn1.addEventListener('click', () => {
//     const result = regex.test(uid.value);
//
//     if (result) {
//         modal_f("사용할 수 있는 아이디 입니다");
//         clr1 = true;
//     }
//     else {
//         modal_f("6자 이상 16자 이하의 영문 혹은 영문과 숫자를 조합");
//     }
//
// });
//
// uid.addEventListener('keydown', () => {
//     setTimeout(() => {
//         if (clr1) {
//             clr1 = false;
//         }
//     }, 50)
// });
//
// umail.addEventListener('keydown',() => {
//
//     setTimeout(() => {
//         if (clr2) {
//             clr2 = false;
//         }
//     }, 50)
// });
//
// phone.addEventListener('keydown', ()=> {
//     setTimeout(()=>{
//         if(clr3) {
//             clr3 = false;
//         }
//     },50)
// })
//
// upw.addEventListener('keydown', () => {
//     setTimeout(()=>{
//         const result = regPass.test(upw.value);
//         upw_input(account_p,result);
//
//
//     },50)
// });
//
// upw2.addEventListener('keydown', () => {
//     setTimeout(()=>{
//         const check = upw.value == upw2.value
//         upw_input(account_p2,check);
//
//
//     },50)
// });
//
// function upw_input(zz,iff) {
//     if (iff) {
//         zz.classList.add('account_hidden');
//     } else {
//         zz.classList.remove('account_hidden');
//     }
// }
//
// checkBtn2.addEventListener('click', () => {
//     const result = regMail.test(umail.value);
//
//     if (result) {
//         modal_f("사용할 수 있는 이메일 입니다");
//         clr2 = true;
//     } else if (umail.value == "") {
//         modal_f("이메일을 입력해 주세요")
//     }
//     else {
//         modal_f("이메일 형식으로 입력해 주세요");
//     }
//
// });
//
// phone.addEventListener('keydown',() => {
//     setTimeout(() => {
//         nmph_input(checkBtn3,phone.value.length >= 11);
//     }, 50);
// } );
//
// function nmph_input(zz,iff) {
//     if (iff) {
//
//         zz.style.background = "lightSalmon";
//         zz.style.cursor = "pointer";
//         zz.removeAttribute('disabled');
//         zz.classList.remove('button_opacity');
//     } else {
//
//         zz.classList.add('button_opacity');
//         zz.style.cursor = "default";
//         zz.setAttribute('disabled', '');
//     }
// }
//
// checkBtn3.addEventListener('click', () => {
//     modal_f("인증번호가 발송되었습니다. 인증번호를 입력해 주세요.");
//     Btn4_box.style.display = "flex";
// });
//
// // ======폰번인증
//
// checkBtn4.addEventListener('click', () => {
//     if (phone_num.value == "1234567") {
//         modal_f("인증완료");
//         phone_num.value = "";
//         checkBtn4.classList.add('button_opacity');
//         checkBtn4.style.cursor = "default";
//         checkBtn4.setAttribute('disabled', '');
//         Btn4_box.style.display = "none";
//
//         clr3 = true;
//     } else {
//         modal_f("잘못된 인증코드입니다.");
//     }
// });
//
// phone_num.addEventListener('keydown', () => {
//     setTimeout(() => {
//         nmph_input(checkBtn4,phone_num.value.length >= 7);
//     }, 50);
// });
//
//
// // =====전송버튼
//
button_submit.addEventListener('click', () => {
   // const clrCheck = clr1 ==true && clr2 == true && clr3 == true;

    userZip = +userZip;
    //if(clrCheck && upw.value == upw2.value && uname.value != "" && address_input.value != "") {

    // if(clrCheck && upw.value == upw2.value && uname.value != "" && address_input.value != "") {
    //    button_submit.setAttribute('type','submit');
    // } else {
    //     modal_f("양식을 확인해주세요");
    // }

    if(upw.value != upw2.value) {
        modal_f("6자이상 동일 비밀번호 입력");
    }else{
        if(user_birth.value == "") {
            modal_f("양식을 확인해주세요");
        } else {

            if(idCheck.getAttribute("value") == "Y" && emailCheck.getAttribute("value") == "Y" && phoneCheck.getAttribute("value") == "Y") {
                button_submit.setAttribute('type','submit');
            } else {
                modal_f("중복확인 해주세요");
            }

        }
    }
});

// // =======주소검색
//
// // const addressbutton = document.querySelector(".addressbutton");
//
//
// addressbutton.addEventListener('click', function () {
//     var width = 500;
//     var height = 600;
//     new daum.Postcode({
//         width: width,
//         height: height
//     }).open({
//         left: (window.screen.width / 2) - (width / 2),
//         top: (window.screen.height / 2) - (height / 2)
//     });
// })
//
//
// // ==================== 모달
//
const open = () => {
    modal.classList.remove('hidden');
    body.classList.add('scroll_none');
}

const close = () => {
    modal.classList.add('hidden');
    body.classList.remove('scroll_none');
}

function modal_f(str) {
    open();
    modal_p.textContent = str;
}

closeBtn.addEventListener('click', close);
bg.addEventListener('click', close);


//=================추가
function id_check() {
    $.ajax({
        url: "/user1/id_check",
        type: "POST",
        dataType : "JSON",
        data : {"user_id" : $(user_id).val()},
        success : function (data) {
            if(data == 1) {
                modal_f("중복된 아이디 입니다.");
            } else if (data == 0) {
                modal_f("사용 가능한 아이디 입니다.");
                idCheck.classList.add('button_opacity');
                idCheck.style.cursor = "default";
                idCheck.setAttribute('disabled', '');
                user_id.setAttribute('readonly','');
                $(idCheck).attr("value","Y");
            }
        }
    });
}

function email_check() {
    $.ajax({
        url: "/user1/email_check",
        type: "POST",
        dataType : "JSON",
        data : {"user_email" : $(user_email).val()},
        success : function (data) {
            console.log(data);
            if(data > 0) {
                modal_f("중복된 이메일 입니다.");
            } else if (data == 0) {
                modal_f("사용 가능한 이메일 입니다.");
                emailCheck.classList.add('button_opacity');
                emailCheck.style.cursor = "default";
                emailCheck.setAttribute('disabled', '');
                user_email.setAttribute('readonly','');
                $(emailCheck).attr("value","Y");
            }
        }
    });
}
//
// function pw_check() {
//     $.ajax({
//         url: "/user1/delete",
//         type: "POST",
//         dataType : "JSON",
//         data : {"user_password" : $(user_password3).val()},
//         success : function (data) {
//             console.log(data);
//                 modal_f("현재 비밀번호가 틀렸습니다.");
//         }
//     });
// }

function phone_check() {
    $.ajax({
        url: "/user1/phone_check",
        type: "POST",
        dataType : "JSON",
        data : {"user_phone" : $(user_phone).val()},
        success : function (data) {
            console.log(data);
            if(data > 0) {
                modal_f("중복된 휴대폰 번호 입니다.");
            } else if (data == 0) {
                modal_f("사용 가능한 휴대폰 번호 입니다.");
                phoneCheck.classList.add('button_opacity');
                phoneCheck.style.cursor = "default";
                phoneCheck.setAttribute('disabled', '');
                user_phone.setAttribute('readonly','');
                $(phoneCheck).attr("value","Y");
            }
        }
    });
}
// pwCheck.addEventListener('click',() =>{
//
//      if (user_password3.value == "") {
//          modal_f("비밀번호를 입력해 주세요")
//      }
//     else {
//          pw_check();
//     }
// });


idCheck.addEventListener('click',() =>{
        const result = regex.test(user_id.value);

    if (result) {
        id_check();
    }
    else {
        modal_f("6자 이상 16자 이하의 영문 혹은 영문과 숫자를 조합");
    }
    console.log(idCheck.getAttribute("value") == "Y");
});

emailCheck.addEventListener('click',() =>{
    const result = regMail.test(user_email.value);

    if (result) {
        email_check();
    } else if (user_email.value == "") {
        modal_f("이메일을 입력해 주세요")
    }
    else {
        modal_f("이메일 형식으로 입력해 주세요");
    }
});

phoneCheck.addEventListener('click',() =>{
    if(user_phone.value.length>=11) {
    phone_check();
    } else {
        modal_f("휴대폰 번호를 확인해 주세요");
    }
});




