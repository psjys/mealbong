package com.project.mealbong.board;

import com.project.mealbong.critest.PageMaker;
import com.project.mealbong.critest.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/qna")
@AllArgsConstructor
public class QnaController {
    private QnaService qnaService;

    @GetMapping("/qnalist") // 문의글 리스트
    public ModelAndView inquiry_list(ModelAndView mv, SearchCriteria cri, QnaDTO dto, PageMaker pageMaker, HttpSession session) {

        // 1) Criteria 처리
        // => rowsPerPage, currPage 값은 Parameter 를 전달 : 자동으로 set
        // => 그러므로 currPage 를 이용해서 setSnoEno 만 하면 됨
        cri.setSnoEno();

        // 2) Service 처리
        cri.setKeyword((String) session.getAttribute("user_id"));
        mv.addObject("qnaList", qnaService.criList(cri)); // ver01

        // 3) View 처리 => PageMaker
        // => cri, totalRowsCount (DB에서 읽어온다)
        pageMaker.setCriteria(cri);
        pageMaker.setTotalRowsCount(qnaService.criTotalCount(cri)); // ver01 : 전체 Rows 갯수
        mv.addObject("pageMaker", pageMaker);

        mv.setViewName("html/service_page/inquiry/inquiry_list");

        return mv;
    }

    @GetMapping("/qnaform") // 문의글 작성 폼
    public String inquiry_getForm() {
        return "html/service_page/inquiry/inquiry_form";
    }

    @PostMapping("/qnaform") // 글 등록 처리
    public String inquiry_postForm(QnaDTO dto, HttpSession session, HttpServletRequest request) {
        // 파일 업로드
        String realPath = request.getRealPath("/");
        System.out.println("** realpath => " + realPath);
        // ** realpath => /private/var/folders/tg/c8xkq7j505sc6p81px34jnsm0000gn/T/tomcat-docbase.8090.1067151245692605209/


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
    public String ans_getForm(QnaDTO dto, Model model) {
        QnaDTO detail = qnaService.detail(dto);
        model.addAttribute("qnaList", detail);
        return "html/service_page/inquiry/ans_form";
    }

    @PostMapping("/ansform")
    public String ans_postForm(QnaDTO dto, Model model, RedirectAttributes rttr) {
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
    public String ans_delete(QnaDTO dto) {
        qnaService.adelete(dto);
        return "redirect:/qna/qnalist";
    }
}

