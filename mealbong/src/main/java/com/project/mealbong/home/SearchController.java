package com.project.mealbong.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {
    @GetMapping("/searchlist")
    public String Search(Model model) {
//        model.addAttribute("data", "data");
        return "/html/search/search";

    }
}
