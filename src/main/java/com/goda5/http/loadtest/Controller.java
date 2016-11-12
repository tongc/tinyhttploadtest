package com.goda5.http.loadtest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home.html", null);
    }
}
