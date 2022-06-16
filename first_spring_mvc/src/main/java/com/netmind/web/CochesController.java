package com.netmind.web;

import com.netmind.domain.Coche;
import com.netmind.persistence.AlmacenCoches;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/coches")
public class CochesController {

    @RequestMapping(method = RequestMethod.GET, value = "/lista")
    public String get_lista(Model model) {
        List<Coche> coches = AlmacenCoches.getCoches();
        model.addAttribute("mess", "En Model!");
        model.addAttribute("coches", coches);
        return "coches/lista";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listamv")
    public ModelAndView get_lista_MV() {
        List<Coche> coches = AlmacenCoches.getCoches();
        ModelAndView mav = new ModelAndView("coches/lista");
        mav.addObject("coches", coches);
        mav.addObject("mess", "En ModelAndView!");
        return mav;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{marca}/{tipo}")
    public String get_coche_path(Model m, @PathVariable String marca, @PathVariable String tipo) {
        Coche unCoche = AlmacenCoches.getCoche(marca, tipo);
        m.addAttribute("elCoche", unCoche);
        return "coches/detalle";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detalle")
    public String get_coche_query(
            Model m,
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String tipo
    ) {
        Coche unCoche = AlmacenCoches.getCoche(marca, tipo);
        m.addAttribute("elCoche", unCoche);
        return "coches/detalle";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/detallemv")
    public ModelAndView get_coche_query_mav(
            @RequestParam(required = false) String marca,
            @RequestParam(required = false) String tipo
    ) {
        Coche unCoche = AlmacenCoches.getCoche(marca, tipo);
        ModelAndView mav = new ModelAndView("coches/detalle");
        mav.addObject("elCoche", unCoche);
        return mav;
    }


}
