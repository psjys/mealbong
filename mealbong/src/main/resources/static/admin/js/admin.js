'use strict';

// 게시판 관리 - 1대1 문의
function qna() {
    $.ajax({
        type: 'Get',
        url: "/admin/qnaadmin",
        success: function (resultPage) {
            document.getElementById('resultArea').innerHTML = resultPage;
        },
        error: function () {
            document.getElementById('resultArea').innerHTML = 'error 발생';
        }
    });
};

