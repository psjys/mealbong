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
    QnaService qnaService;
    ProductService productService;
    User1Service userService;


    // 회원관리 (관리자 페이지 메인)
    @GetMapping("/useradmin")
    public ModelAndView user_admin() {
        ModelAndView mav = new ModelAndView();
        List<User1MapperDTO> userList = userService.user_list();
        mav.addObject("userList",userList);
        mav.setViewName("html/admin/user_admin");
        return mav;
    }

    // 주문관리


    // 상품관리
    @GetMapping("/productadmin") // 상품 리스트
    public String product_admin(Model model){
        List<ProductDTO> productAdmin = productService.productAdmin();
        model.addAttribute("productAdmin", productAdmin);
        System.out.println(productAdmin);
        return "html/admin/product_admin";
    }

    // 게시판 관리 - 1대1 문의
    @GetMapping("/qnaadmin")
    public ModelAndView qna_admin(ModelAndView mv, SearchCriteria cri, PageMaker pageMaker, HttpSession session) {

        cri.setSnoEno();

        cri.setKeyword((String) session.getAttribute("user_id"));
        mv.addObject("qnaList", qnaService.criList(cri)); // ver01

        pageMaker.setCriteria(cri);
        pageMaker.setTotalRowsCount(qnaService.criTotalCount(cri)); // ver01 : 전체 Rows 갯수
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
