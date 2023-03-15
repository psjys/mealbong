const adress_add_button = document.querySelector(".adress_add_button"),
    content = document.querySelector(".content"),
    content_adress_2 = content.querySelector('.content_adress_2'),
    fixBtn = content_adress_2.getElementsByTagName('button'),
    address_fix_content = document.querySelector('.address_fix_content'),
    fix_address = address_fix_content.querySelector('.fix_address'),
    fix_name = address_fix_content.querySelector('.fix_name'),
    fix_call = address_fix_content.querySelector('.fix_call'),
    address_fix_button = address_fix_content.querySelector('.address_fix_button'),
    content_adress_1 = content.querySelector(".content_adress_1"),
    [fix_check, fix_cancel] = address_fix_button.querySelectorAll('button'),
    content_adress_box = content.querySelector(".content_adress_box"),
    content_adress = content.querySelector(".content_adress");

// content_adress.addEventListener("click", function (e) {
//     addresOj = e.target.closest('button');
//
//     if (this.contains(addresOj)) {
//         address_fix_content.classList.remove('hidden');
//         fixAddress = addresOj.parentNode.parentNode.children[1];
//
//         fixName = addresOj.parentNode.previousSibling.previousSibling.previousSibling.previousSibling;
//         fixCall = addresOj.parentNode.previousSibling.previousSibling;
//         fix_address.nextSibling.nextSibling.value = '';
//         fix_name.nextSibling.nextSibling.value = fixName.textContent;
//         fix_call.nextSibling.nextSibling.value = fixCall.textContent;
//
//         fix_address.textContent = fixAddress.children[0].textContent;
//     }
// })

fix_check.addEventListener('click', function () {
    address_fix_content.classList.add('hidden');
})


fix_cancel.addEventListener('click', function () {
    address_fix_content.classList.add('hidden');
})

document.querySelector(".adress_add_button").addEventListener('click', function () {
    var width = 500;
    var height = 600;

    new daum.Postcode({
        width: width,
        height: height,
        oncomplete: function (data) {
            document.getElementsByClassName('fix_zonecode')[0].value = data.zonecode;
            document.getElementsByClassName('fix_address1')[0].value = data.address;
            address_fix_content.classList.remove('hidden');


            //
            // $.ajax({
            //     url: "/address/test",
            //     type: "POST",
            //     data: JSON.stringify({dely_zip: data.zonecode, dely_address1: data.address}),
            //     contentType: "application/json; charset=utf-8",
            //     success: function (data) {
            //         console.log("성공");
            //         // window.open('/address/test', '_blank', 'width=500,height=600,left=' + (window.screen.width / 2) - (500 / 2) + ',top=' + (window.screen.height / 2) - (600 / 2));
            //     },
            //     error: function (xhr, status, error) {
            //         console.error("실패", error);
            //     }
            // });
        },
    }).open({
        left: (window.screen.width / 2) - (width / 2),
        top: (window.screen.height / 2) - (height / 2)
    });
})


const radios = document.querySelectorAll("input[name=dely_check]");
radios.forEach((radio) => {
    radio.addEventListener("change", function () {
        radios.forEach((r) => r.value = r.checked ? "Y" : "N");
    });
});

function submitForm() {
    document.getElementById("dely_default").submit();
}
