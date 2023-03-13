package com.project.mealbong.faq;


import com.project.mealbong.critest.PageMaker;
import com.project.mealbong.critest.SearchCriteria;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/faq")
public class FaqController {

    FaqService service;


    @GetMapping("/list")
    public ModelAndView faqList(@RequestParam(name ="faq_code", defaultValue = "ALL") String faq_code, ModelAndView mv,SearchCriteria cri, PageMaker pageMaker) {
        cri.setSnoEno();
        cri.setCode_number(faq_code);
        mv.addObject("faqList", service.criList(cri));

        pageMaker.setCriteria(cri);

        pageMaker.setTotalRowsCount(service.criTotalCount(cri));

        mv.addObject("pageMaker", pageMaker);
        mv.setViewName("/html/service_page/faq");
        return mv;
    }

    @GetMapping("/faqInsert")
    public ModelAndView faqInsert(ModelAndView mv) {
        mv.setViewName("/html/service_page/faqInsertForm");
        return mv;
    }

    @PostMapping("/faqInsert")
    public String faqInsert(FaqDTO dto) {
        service.faqInsert(dto);
        return "redirect:/faq/list";
    }


    @GetMapping("/faqDelete")
    public String faqUpdate(@RequestParam("faq_number") int faq_number, FaqDTO dto) {
        dto.setFaq_number(faq_number);
        service.faqDelete(dto);
        return "redirect:/faq/list";
    }


    @GetMapping("/faqUpdate")
    public ModelAndView faqUpdate(FaqDTO dto, ModelAndView mv, @RequestParam("faq_number") int faq_number) {
        dto.setFaq_number(faq_number);
        dto = service.faqDetail(dto);
        mv.addObject("faqDetail", dto);
        mv.setViewName("/html/service_page/faqUpdateForm");
        return mv;
    }

    @PostMapping("/faqUpdate")
    public String faqUpdate(FaqDTO dto) {
        service.faqUpdate(dto);
        return "redirect:/faq/list";
    }
}
