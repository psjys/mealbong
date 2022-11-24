/* =====================좋아요 및 장바구니 modal box==================== */
/* 로그인 하기 전 */

const modal = document.querySelector('.modal_container'),
    bg = document.querySelector('.bg'),
    body = document.querySelector('body'),
    header = document.querySelector('header'),
    modalBox = modal.querySelector('.modalBox'),
    modal_p = modal.querySelector('p'),
    closeBtn = document.querySelector('.closeBtn'),
    innerbox2 = document.querySelector('.innerbox2'),
    basket = innerbox2.querySelector('.basket'),
    wish = innerbox2.querySelector('.wish');

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

wish.addEventListener('click', () => {

    modal_f("로그인 하셔야 본 서비스를 이용하실 수 있습니다.");
});

basket.addEventListener('click', () => {

    modal_f("로그인 하셔야 본 서비스를 이용하실 수 있습니다.");
});

function modal_f(str) {
    open();
    modal_p.textContent = str;
}

closeBtn.addEventListener('click', close);
bg.addEventListener('click', close);





/* ===================== 장바구니 modal box ================== */
/* 로그인 하고 나서 */


/* ===================== 좋아요 modal box ==================== */
/* 로그인 하고 나서 */

/* ===================== SNS 공유하기 ==================== */

const share = innerbox2.querySelector('#share'),
    SNS = document.querySelector('.SNS_container'),
    SNS_Box = SNS.querySelector('.SNS_Box'),
    SNS_closeBtn = SNS_Box.querySelector('.SNS_closeBtn'),
    nav = document.querySelector('nav');

share.addEventListener('click', () => {

    modal_s(
        ` <a class="facebook" href="https://m.facebook.com/login/?locale=ko_KR/">페이스북<img src="../../../image/facebook_png_640.jpg" alt=""></a>
    <a class="kakaotalk" href="https://accounts.kakao.com/login/?continue=https%3A%2F%2Fcs.kakao.com%2Fhelps%3Fservice%3D8%26locale%3Dko%26category%3D25">카카오톡</a>
    <a class="instagram" href="https://www.instagram.com/">인스타그램</a>`
    );
    console.log('adsf')
});

const SNS_open = () => {
    SNS.classList.remove('hidden');
    body.classList.add('scroll_none');
    header.style.position = 'static';
    nav.style.zIndex = '0';
}

const SNS_close = () => {
    SNS.classList.add('hidden');
    body.classList.remove('scroll_none');
    header.style.position = 'sticky';
    nav.style.zIndex = '2';
}

function modal_s(str) {
    SNS_open();
    SNS_Box.innerHTML += str;
}

SNS.addEventListener('click', function (e) {
    if (e.target.closest('button')) {
        SNS_close();
    }
});

// 상품 수량에 따라 가격 바뀌게

const amount = innerbox2.querySelector('input'),
    total_amount = innerbox2.querySelector('#total_amount');

amount.addEventListener('click', function (e) {
    total_amount.children[1].textContent = `${e.target.value * 1}0,000`;
})
