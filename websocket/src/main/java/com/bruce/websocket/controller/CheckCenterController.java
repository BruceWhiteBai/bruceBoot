package com.bruce.websocket.controller;

import com.bruce.websocket.config.WebSocketServer;
import com.bruce.websocket.util.ApiReturnObject;
import com.bruce.websocket.util.ApiReturnUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequestMapping("/checkcenter")
public class CheckCenterController {

    //页面请求
    @GetMapping("/socket/{cid}")
    public ModelAndView socket(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/socket");
        mav.addObject("cid", cid);
        return mav;
    }
    //页面请求
    @GetMapping("/socket1/{cid}")
    public ModelAndView socket1(@PathVariable String cid) {
        ModelAndView mav = new ModelAndView("/socket1");
        mav.addObject("cid", cid);
        return mav;
    }


    //推送数据接口
    @ResponseBody
    @RequestMapping("/push")
    public ApiReturnObject pushToWeb(String cid, String message) {
        try {
            WebSocketServer.sendInfo(message, cid);
        } catch (IOException e) {
            e.printStackTrace();
            return ApiReturnUtil.error(cid + "#" + e.getMessage());
        }
        return ApiReturnUtil.success(cid);
    }
}
