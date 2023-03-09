package com.project.mealbong.order;

import com.project.mealbong.user.User1MapperDTO;
import com.project.mealbong.user.User1Service;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/order/")
@AllArgsConstructor
public class OrderController {
    @Resource
    private CartService cs;
    @Resource
    private User1Service us;
    @Resource
    private OrderService os;

    // @GetMapping("cart")
  /*  public ModelAndView cart_form(ModelAndView mav, HttpSession session) {
        mav.setViewName("html/order/cart");
        return mav;

    }*/

//    @GetMapping("cart_delete/{cart_number}")
    @GetMapping("cart")
    public ModelAndView cart_ax(ModelAndView mav,HttpSession session) {

       if(session.getAttribute("user_id") == null) {
            mav.setViewName("html/user/login");
            return mav;
        }

        String user_id = (String) session.getAttribute("user_id");
        int total = 0;
        User1MapperDTO user_dedail = us.find_id(user_id);
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

        mav.addObject("user_address1",user_dedail.getUser_address1());
        mav.addObject("user_address2",user_dedail.getUser_address2());
        mav.addObject("cart_list",cart_list);
        mav.addObject("total",total);
        mav.addObject("total2",total);
        mav.addObject("count",result);


        mav.setViewName("html/order/cart");
        return mav;

    }

    @PostMapping("cart_delete")
    @ResponseBody
    public int cart_delete(CartMapperDTO cartMapperDTO) {
        System.out.println(cartMapperDTO);
        cs.cart_delete(cartMapperDTO.getCart_number());
        return 1;
    }

    @PostMapping("order_test")
    public ModelAndView order_test(ModelAndView mav,@RequestParam String[] cart_numberV,@RequestParam String[] product_countV,CartMapperDTO cartMapperDTO,HttpSession session) {
//        System.out.println(o_value);
//        System.out.println(arr2);
        int total = 0;
        String user_id = (String) session.getAttribute("user_id");
        User1MapperDTO user_info = us.find_id(user_id);
        Map<Integer,CartMapperDTO> result = new HashMap<>();

        for(int i=0; i<cart_numberV.length; i++) {
//            System.out.println(o_value[i]); //cart_number
//            System.out.println(o_value2[i]); // product_count
            cartMapperDTO.setCart_number(Integer.parseInt(cart_numberV[i]));
            cartMapperDTO.setProduct_count(Integer.parseInt(product_countV[i]));
            cs.cart_update(cartMapperDTO);
            total += cs.cart_order(cartMapperDTO.getCart_number()).getPrice_total();
            result.put(i, cs.cart_order(cartMapperDTO.getCart_number()));
//            System.out.println(arr2[i]);


        }
        for(CartMapperDTO ca : result.values()) {
            System.out.println(ca);

        }
        mav.addObject("product", result);
        mav.addObject("total",total);
        mav.addObject("user_info",user_info);
        mav.setViewName("html/order/order");
//        mav.addObject("arr",arr);
        return mav;
    }

    @PostMapping("order")
    public ModelAndView order(ModelAndView mav,@RequestParam String[] cart_number,OrderMapperDTO orderMapperDTO,OrderDetailMapperDTO orderDetailMapperDTO,CartMapperDTO cartMapperDTO,HttpSession session) {
        String user_id = (String) session.getAttribute("user_id");
        String user_name = (String) session.getAttribute("user_name");
        orderMapperDTO.setUser_id(user_id);

        System.out.println(orderMapperDTO);
        os.order_insert(orderMapperDTO);
        int total = orderMapperDTO.getOrder_amount();
        int order_number = os.order_number();
            orderDetailMapperDTO.setOrder_number(order_number);
        for(int i=0;i<cart_number.length;i++) {
            cartMapperDTO=cs.cart_order(Integer.parseInt(cart_number[i]));

            orderDetailMapperDTO.setProduct_number(cartMapperDTO.getProduct_number());
            orderDetailMapperDTO.setProduct_price(cartMapperDTO.getProduct_price());
            orderDetailMapperDTO.setProduct_count(cartMapperDTO.getProduct_count());
            System.out.println(orderDetailMapperDTO);
            os.orderDetail_insert(orderDetailMapperDTO);
            cs.cart_delete(Integer.parseInt(cart_number[i]));
        }
        List<OrderDetailMapperDTO> lists =os.order_submit(order_number);
        mav.addObject("total",total);
//        mav.addObject("order_number",order_number);
        mav.addObject("order_submit",lists);
        mav.addObject("user_name",user_name);
        mav.setViewName("/html/order/order_submit");
        return mav;
    }

}
