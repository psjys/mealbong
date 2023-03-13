package com.project.mealbong.delivery;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@AllArgsConstructor
@RequestMapping("/address")
public class DeliveryController {

    DeliveryService service;

    @GetMapping("/list")
    public ModelAndView list(ModelAndView mv) {
        List<DeliveryDTO> deliveryList = service.deliveryList();
        mv.addObject("deliveryList", deliveryList);
        mv.setViewName("/html/my_page/address");
        return mv;
    }

    @PostMapping("/test")
    public ModelAndView test(@RequestBody DeliveryDTO dto, ModelAndView mv) throws Exception {
        System.out.println(dto);

        System.out.println(dto.getDely_zip());

        mv.setViewName("/html/my_page/delyTest");

        return mv;
    }
    @GetMapping("/daum")
    public ModelAndView daum(ModelAndView mv) {
        mv.setViewName("/html/my_page/daum");
        return mv;
    }

}
