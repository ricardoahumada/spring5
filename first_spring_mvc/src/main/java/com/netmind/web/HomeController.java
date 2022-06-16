/*
 * This code is sample code, provided as-is, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you. Enjoy.
 * Copyright LearningPatterns Inc.
 */

package com.netmind.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}