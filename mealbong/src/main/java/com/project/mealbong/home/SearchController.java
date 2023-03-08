package com.project.mealbong.home;

import com.project.mealbong.product.ProductDTO;
import com.project.mealbong.product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/search")
public class SearchController {
    private ProductService productService;

    @GetMapping("/searchlist")
    public String searchPage (@RequestParam(value="keyword") String keyword,
                              Model model) throws Exception {
        List<ProductDTO> productDTO = productService.searchPage(keyword);
        model.addAttribute("keyword", keyword);
        return "/html/search/search";

    }
}
