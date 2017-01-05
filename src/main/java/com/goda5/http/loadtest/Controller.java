package com.goda5.http.loadtest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@org.springframework.stereotype.Controller
public class Controller {
    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("home.html", null);
    }

    @RequestMapping("/a")
    public void cookie(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("test", "test1");
        cookie.setDomain("google.co.uk");//not allowed.
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie("test1", "test2");
        cookie2.setDomain("localhost");//allowed
        response.addCookie(cookie2);

        Cookie cookie3 = new Cookie("test1", "test2");
        cookie3.setDomain("a.localhost");
        response.addCookie(cookie3);
        response.getWriter().write("test");
    }
}
