/*
 * This code is sample code, provided as-is, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you. Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.netmind.web;

import com.netmind.domain.Message;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")      // Map controller to /home
public class HomeController {

    @RequestMapping(method = RequestMethod.GET, value = "")
    public String get() {
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hola")
    public String get_hola(Model model) {
        String mensaje = "Este es el mensaje de hola...";
        model.addAttribute("mess", mensaje);
        return "hola";
    }

    @RequestMapping(value = "/crear_mensaje", method = RequestMethod.GET)
    public ModelAndView mostrar_form_mensaje() {
        ModelAndView mav = new ModelAndView("crear_mensaje_form");
        return mav;
    }

    @RequestMapping(value = "/crear_mensaje", method = RequestMethod.POST)
    public ModelAndView recibir_form_mensaje(Message unMensaje) {
        ModelAndView mav = null;
        if (unMensaje.isValid()) {
            //alamcenar y redirect home
            mav = new ModelAndView("redirect:../home");
        } else {
            //monstrar error
            mav = new ModelAndView("crear_mensaje_form");
            mav.addObject("error", "Completa los campos con el formato correcto!");
            mav.addObject("elMensaje", unMensaje);
        }

        return mav;
    }

}