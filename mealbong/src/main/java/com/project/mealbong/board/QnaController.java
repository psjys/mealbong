package com.project.mealbong.board;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.remainderUnsigned;

@Controller
@RequestMapping("/qna")
@AllArgsConstructor
public class QnaController {
    private QnaService qnaService;

    @GetMapping("/qnalist") // 문의글 리스트
    public String inquiry_list(Model model, QnaDTO dto, HttpSession session) {
        dto.setUser_id((String) session.getAttribute("user_id"));

        List<QnaDTO> qnaList = qnaService.qnaList(dto);
        model.addAttribute("qnaList", qnaList);

        return "html/service_page/inquiry/inquiry_list";
    }

    @GetMapping("/qnaform") // 문의글 작성 폼
    public String inquiry_getForm() {
        return "html/service_page/inquiry/inquiry_form";
    }

    @PostMapping("/qnaform") // 글 등록 처리
    public String inquiry_postForm(QnaDTO dto, HttpSession session) {

        String uri = "redirect:/qna/qnalist";
        dto.setUser_id((String) session.getAttribute("user_id"));
        // 글등록 실패 시
        if (qnaService.insert(dto) < 0) {
            uri = "html/service_page/inquiry/inquiry_form";
        }
        return uri;
    }

    @GetMapping("/qnaupdate")
    public String inquiry_getUpdate(QnaDTO dto, Model model) {
        QnaDTO detail = qnaService.detail(dto);
        model.addAttribute("qnaList", detail);
        return "html/service_page/inquiry/inquiry_update";
    }

    @PostMapping("/qnaupdate")
    public String inquiry_postUpdate(QnaDTO dto, Model model, RedirectAttributes rttr) {
        String uri = "redirect:/qna/qnalist";
        int update = qnaService.update(dto);

        rttr.addAttribute("qna_num", dto.getQna_num());
        model.addAttribute("qnaList", dto);

        // 글 수정 실패 시
        if (update < 0) {
            uri = "html/service_page/inquiry/inquiry_update/{qna_num}";
        }
        return uri;
    }

    @GetMapping("/qnadelete")
    public String inquiry_delete(QnaDTO dto) {
        qnaService.delete(dto);
        return "redirect:/qna/qnalist";
    }

    // 답변
    @GetMapping("/ansform")
    public String ans_getForm (QnaDTO dto, Model model) {
        QnaDTO detail = qnaService.detail(dto);
        model.addAttribute("qnaList", detail);
        return "html/service_page/inquiry/ans_form";
    }

    @PostMapping("/ansform")
    public String ans_postForm (QnaDTO dto, Model model, RedirectAttributes rttr) {
        String uri = "redirect:/qna/qnalist";
        int ainsert = qnaService.ainsert(dto);

        rttr.addFlashAttribute("qna_num", dto.getQna_num());
        model.addAttribute("qnaList", dto);

        // 글 수정 실패 시
        if (ainsert < 0) {
            uri = "html/service_page/inquiry/ans_form/{qna_num}";
        }
        return uri;
    }
    @GetMapping("/ansdelete")
    public String ans_delete (QnaDTO dto) {
        qnaService.adelete(dto);
        return "redirect:/qna/qnalist";
    }
}

