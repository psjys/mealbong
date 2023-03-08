package com.project.mealbong.admin;

import com.project.mealbong.board.QnaDTO;
import com.project.mealbong.board.QnaService;
import com.project.mealbong.critest.PageMaker;
import com.project.mealbong.critest.SearchCriteria;
import com.project.mealbong.product.ProductDTO;
import com.project.mealbong.product.ProductService;
import com.project.mealbong.user.User1MapperDTO;
import com.project.mealbong.user.User1Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private QnaService qnaService;
    private ProductService productService;
    private User1Service userService;


    // 회원관리 (관리자 페이지 메인)
    @GetMapping("/useradmin")
    public ModelAndView user_admin(ModelAndView mv, SearchCriteria cri, PageMaker pageMaker) {

        cri.setSnoEno();

        mv.addObject("userList", userService.searchList(cri));

        pageMaker.setCriteria(cri);
        pageMaker.setTotalRowsCount(userService.searchTotalCount(cri));
        mv.addObject("pageMaker", pageMaker);

        mv.setViewName("html/admin/user_admin");

        return mv;
    }

    // 주문관리


    // 상품관리
    @GetMapping("/productadmin") // 상품 리스트
    public ModelAndView product_admin(ModelAndView mv, SearchCriteria cri, PageMaker pageMaker){
        cri.setSnoEno();
        mv.addObject("productAdmin", productService.searchList(cri));

        pageMaker.setCriteria(cri);
        pageMaker.setTotalRowsCount(productService.searchTotalCount(cri));
        mv.addObject("pageMaker", pageMaker);

        mv.setViewName("html/admin/product_admin");

        return mv;

    }

    // 게시판 관리 - 1대1 문의
    @GetMapping("/qnaadmin")
    public ModelAndView qna_admin(ModelAndView mv, SearchCriteria cri, PageMaker pageMaker) {

        cri.setSnoEno();
        mv.addObject("qnaList", qnaService.searchList(cri));

        pageMaker.setCriteria(cri);
        pageMaker.setTotalRowsCount(qnaService.searchTotalCount(cri));
        mv.addObject("pageMaker", pageMaker);

        mv.setViewName("html/admin/qna_admin");

        return mv;
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
        String uri = "redirect:/admin/qnaadmin";
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
        return "redirect:/admin/qnaadmin";
    }
}
