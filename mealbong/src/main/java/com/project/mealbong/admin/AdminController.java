package com.project.mealbong.admin;

import com.project.mealbong.board.QnaDTO;
import com.project.mealbong.board.QnaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    QnaService qnaService;
    // 관리자 페이지 메인
    @GetMapping("/adminlist")
    public String adminPage() {
        return "html/admin/admin";
    }

    // 게시판 관리 - 1대1 문의
    @GetMapping("/qnaadmin")
    public String qnaAdmin(Model model, QnaDTO dto, HttpSession session) {
        dto.setUser_id((String) session.getAttribute("user_id"));
        List<QnaDTO> qnaAdmin = qnaService.qnaList(dto);
        model.addAttribute("qnaList", qnaAdmin);

        return "html/admin/qna_admin";
    }
}
