package com.project.mealbong.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/search")
public class SearchController {
    @GetMapping("/searchlist")
    public String search(@RequestParam(value="keyword") String keyword,
                         Model model) throws Exception {
//        List<상품 DTO> 상품DTO = 상품 Service.상품목록(keyword);
//        model.addAttribute("keyword", 상품DTO);
        return "/html/search/search";

    }
}
