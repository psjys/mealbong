package com.project.mealbong.product;

import com.project.mealbong.critest.PageMaker;
import com.project.mealbong.critest.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ImageService imageService;

    @GetMapping("/productList") // 상품 리스트
    public ModelAndView product_list(@RequestParam(value = "currPage", required = false) int currPage, @RequestParam("rowsPerPage") int rowsPerPage, @RequestParam("category_code") String code_number,
                                     ModelAndView mv, SearchCriteria cri, PageMaker pageMaker) {
        cri.setSnoEno();

        cri.setRowsPerPage(rowsPerPage);
        cri.setCurrPage(currPage);
        cri.setCode_number(code_number);

        mv.addObject("productList", productService.criList(cri));
        mv.addObject("code_number", productService.categoryList());

        System.out.println(cri);

        pageMaker.setCriteria(cri);
        pageMaker.setTotalRowsCount(productService.criTotalCount(cri));
        mv.addObject("pageMaker", pageMaker);

        mv.setViewName("html/menu_list/product_list");

        return mv;
    }

    @GetMapping("{product_number}")   // 상품 상세 페이지
    public String product_detail(Model model, ProductDTO productDTO, ImageDTO imageDTO){
        ProductDTO productDetail = productService.productDetail(productDTO.getProduct_number());
        model.addAttribute("productDetail", productDetail);

        List<ImageDTO> imageList = imageService.imageList(productDTO.getProduct_number());
        model.addAttribute("imageList", imageList);

        return "html/menu_list/product_detail";
    }

    @GetMapping("/productForm")  // 상품 작성 폼
    public String product_getForm(){
        return "html/menu_list/product_form";
    }

    @PostMapping("/productForm")    // 상품 등록 처리
    public String product_postForm (ProductDTO dto, RedirectAttributes rttr){
        String uri = "redirect:/admin/productadmin";

        // 상품 등록 실패 시
        if (productService.insert(dto) < 0){
            uri = "html/product/product_form";
        }
        rttr.addFlashAttribute("productList", productService.productList());
        return uri;
    }

    @GetMapping("/productUpdate")    // 상품 수정
    public String product_getUpdate (ProductDTO dto, Model model){
        ProductDTO detail = productService.detail(dto);
        model.addAttribute("productList", detail);
        return "html/menu_list/product_update";
    }

    @PostMapping("/productUpdate")  // 상품 수정 처리
    public String product_postUpdate (ProductDTO dto, Model model, RedirectAttributes rttr){
        String uri = "redirect:/admin/productadmin";

        int update = productService.update(dto);
        rttr.addFlashAttribute("product_number", dto.getProduct_number());

        model.addAttribute("productList", dto);

        if(update < 0) {
            uri="html/menu_list/product_update/{product_number}";
        }

        return uri;
    }

    @GetMapping("/productDelete")   // 상품 삭제
    public String product_delete(ProductDTO dto) {
        productService.delete(dto);
        return "redirect:/admin/productadmin";
    }

}
