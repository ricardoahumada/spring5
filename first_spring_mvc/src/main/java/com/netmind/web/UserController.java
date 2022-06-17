package com.netmind.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/users")
public class UserController {

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public ModelAndView show_login_form() {
        return new ModelAndView("users/login");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ModelAndView post_login_form(LoginForm loginForm, HttpSession session) {
        System.out.println(loginForm);

        String email_esperado = "r@r.com";
        String pass_esperado = "xxx";

        if (loginForm.isValid() && loginForm.getEmail().equals(email_esperado) && loginForm.getPassword().equals(pass_esperado)) {
            session.setAttribute("email", email_esperado);
            session.setAttribute("logged", true);
            return new ModelAndView("redirect:/web/coches/lista");
        } else {
            ModelAndView mav = new ModelAndView("users/login");
            mav.addObject("error", "Datos incorrectos!");
            return mav;
        }

    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
        session.invalidate();
        return new ModelAndView("redirect:/web/users/login");
    }

}
