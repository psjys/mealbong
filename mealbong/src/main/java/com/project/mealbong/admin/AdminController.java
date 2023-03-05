package com.project.mealbong.admin;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    @GetMapping("/adminlist")
    public String adminPage () {
        return "html/admin/admin";
    }
    @GetMapping("/qnaadmin")
    public String qnaAdmin() {
        return "html/service_page/inquiry/inquiry_list";
    }
}
