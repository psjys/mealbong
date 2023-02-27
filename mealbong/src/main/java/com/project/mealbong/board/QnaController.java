package com.project.mealbong.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/qna")
public class QnaController {
    @Autowired
    private QnaService qnaService;

    @GetMapping("/qnalist") // 문의글 리스트
    public String inquiry_form(Model model) {
        List<QnaDTO> qnaList = qnaService.qnaList();
        model.addAttribute("qnaList", qnaList);
        return "html/service_page/inquiry/inquiry_list";
    }
//    @PostMapping("/qnaform") // 글 등록 처리
//    public String create (String title, String contents, HttpSession session) {
//
//    }

}
