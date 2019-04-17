package com.bruce.session.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/index")
public class Index {

    private static final Logger logger = LoggerFactory.getLogger(Index.class);

    @RequestMapping(value = "/index")
    @ResponseBody
    public String index(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            session.setAttribute("user", "zhangsan");
            session.setAttribute("sadf", "asdf-0");
            System.out.println("不存在session");
        } else {
            session.setAttribute("sadf", "asdf-1");
            System.out.println("存在session");

        }
        return "asdf"+session.getId();
    }


}