package com.project.mealbong.order;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/order/")
@AllArgsConstructor
public class OrderController {
    @Resource
    private CartService cs;

    @GetMapping("cart")
    public ModelAndView cart_form(ModelAndView mav, HttpSession session) {
        String user_id = (String) session.getAttribute("user_id");
        int total = 0;
        List<CartMapperDTO> cart_list = cs.cart_list(user_id);
        int result = cs.cart_count(user_id);
        for (CartMapperDTO t:cart_list
             ) {
            total += t.getPrice_total();
        }

        if(result > 0) {
            mav.addObject("fee",3000);
        } else {
            mav.addObject("fee",0);
        }

        mav.addObject("cart_list",cart_list);
        mav.addObject("total",total);
        mav.addObject("total2",total);
        mav.addObject("count",result);
        mav.setViewName("html/order/cart");
        return mav;

    }
}
