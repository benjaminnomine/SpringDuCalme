package com.ducalme.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParametresController {
    @RequestMapping(value = "/parametres")
    public String getParametres()
    {
        return "/parametres/index";
    }
}
