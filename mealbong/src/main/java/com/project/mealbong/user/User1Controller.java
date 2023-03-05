package com.project.mealbong.user;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/user1/")
@AllArgsConstructor
public class User1Controller {


    PasswordEncoder passwordEncoder;

    @Resource
    private User1Service us;



    @GetMapping("terms")
    public ModelAndView terms() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("html/user/Terms");
        return mav;
    }

    @GetMapping("save")
    public ModelAndView saveForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("html/user/account");
        return mav;
    }

    @PostMapping("save")
    public ModelAndView save(@ModelAttribute User1MapperDTO user1MapperDTO) {
        ModelAndView mav = new ModelAndView();
        System.out.println(user1MapperDTO);
        user1MapperDTO.setUser_password(passwordEncoder.encode(user1MapperDTO.getUser_password()));
        us.user_save(user1MapperDTO);
        mav.addObject("user_name",user1MapperDTO);
        mav.setViewName("html/user/account_submit");
        return mav;
    }


    @GetMapping("list")
    @PostMapping("list")
    public ModelAndView list() {
        ModelAndView mav = new ModelAndView();
        List<User1MapperDTO> lists = us.user_list();
        mav.addObject("user_list",lists);
        mav.setViewName("html/user/user_list");

        return mav;
    }

    @GetMapping("{user_id}")
    public ModelAndView find_id(HttpServletRequest request,User1MapperDTO user1MapperDTO,HttpSession session,ModelAndView mav) {
        String uri = "html/user/user_detail";

            if(session.getAttribute("user_id") == null) {

                mav.addObject("message","로그인 후 이용하세요");
                mav.setViewName("html/user/login");
                return mav;
            } // session 확인

        user1MapperDTO = us.find_id(user1MapperDTO.getUser_id());
        mav.addObject("user_detail",user1MapperDTO);


        if("U".equals(request.getParameter("jCode"))) {
            uri = "html/user/user_update";
        }

        mav.setViewName(uri);

        return mav;
    }

    @PostMapping("delete")
    public ModelAndView delete(ModelAndView mav,HttpSession session, User1MapperDTO user1MapperDTO) {

        //user1MapperDTO.setUser_password(user_password);
        //user1MapperDTO.setUser_id((String) session.getAttribute("user_id"));



//        if(session.getAttribute("user_id") == null) {
//
//            mav.addObject("message","로그인 후 이용하세요");
//            mav.setViewName("html/user/login");
//            return mav;
//        } // session 확인

           if(session.getAttribute("user_id") == null) {

               mav.setViewName("html/user/login");
            return mav;
        } // session 확인



        us.user_delete((String) session.getAttribute("user_id"));
   //     mav.setViewName("html/user/user_delete");
//
//        session.removeAttribute("user_id");
//        session.removeAttribute("user_name");
        session.invalidate();
        mav.setViewName("html/user/user_delete");

        return mav;
    }

    @PostMapping("pw_check")
    public int pw_check(User1MapperDTO user1MapperDTO,HttpSession session) {
        String password = (String)session.getAttribute("user_password");
        System.out.println(session.getAttribute("user_password"));
        if(!passwordEncoder.matches(user1MapperDTO.getUser_password(), password)) {
            return 1;
        }
       return 0;
    }


    @GetMapping("admin/{user_id}")
    public ModelAndView admin_userinfo(@PathVariable String user_id,ModelAndView mav) {
        String uri = "html/user/user_detail";

        User1MapperDTO find_id = us.find_id(user_id);
        mav.addObject("user_detail",find_id);
        mav.setViewName(uri);


        return mav;
    }

    @GetMapping("login")
    public ModelAndView loginForm(ModelAndView mav) {
        mav.setViewName("html/user/login");
        return mav;
    }

    @PostMapping("login")
    public ModelAndView login(HttpSession session, ModelAndView mav, @ModelAttribute User1MapperDTO user1MapperDTO,RedirectAttributes rttr) {
        String uri;
        String user_id = user1MapperDTO.getUser_id();

        user1MapperDTO = us.find_id(user_id);

            session.setAttribute("user_id",user1MapperDTO.getUser_id());
            session.setAttribute("user_name",user1MapperDTO.getUser_name());
            session.setAttribute("user_password",user1MapperDTO.getUser_password());
            uri="redirect:/";

        mav.setViewName(uri);

        return mav;
    }


    @PostMapping("login_check")
    public int login_check(User1MapperDTO user1MapperDTO) {
        String password = user1MapperDTO.getUser_password();
        user1MapperDTO = us.find_id(user1MapperDTO.getUser_id());
        if(user1MapperDTO != null) {
            if(user1MapperDTO.getUser_password().equals(password)) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return 3;
        }
    }

//    @PostMapping("pw_check")
//    public int pw_check(User1MapperDTO user1MapperDTO,HttpSession session) {
//        String password = (String)session.getAttribute("user_password");
//        System.out.println(session.getAttribute("user_password"));
//        if(!passwordEncoder.matches(user1MapperDTO.getUser_password(), password)) {
//            return 1;
//        }
//        return 0;
//    }

    @GetMapping("logout")
    public ModelAndView logout(ModelAndView mav,HttpSession session) {
//        session.removeAttribute("user_id");
//        session.removeAttribute("user_name");
        session.invalidate();
        mav.setViewName("redirect:/");
        return mav;
    }

    @PostMapping("update")
    public ModelAndView update(ModelAndView mav,@ModelAttribute User1MapperDTO user1MapperDTO,HttpSession session) {

        if("".equals(user1MapperDTO.getUser_password())) {
            System.out.println("들옴");
            user1MapperDTO.setUser_password((String) session.getAttribute("user_password"));
        } else {
            System.out.println("여기도");
        user1MapperDTO.setUser_password(passwordEncoder.encode(user1MapperDTO.getUser_password()));
        }
        us.user_update(user1MapperDTO);
        session.setAttribute("user_name",user1MapperDTO.getUser_name());
        session.setAttribute("user_password",user1MapperDTO.getUser_password());
        System.out.println(session.getAttribute("user_password"));
        mav.setViewName("redirect:/");
        return mav;
    }

    @PostMapping("id_check")
    public int id_check(String user_id) {

        int result = us.id_check(user_id);
        return result;
    }

    @PostMapping("email_check")
    public int email_check(String user_email) {

        int result = us.email_check(user_email);
        return result;
    }

    @PostMapping("phone_check")
    public int phone_check(String user_phone) {

        int result = us.phone_check(user_phone);
        return result;
    }



}
