package com.fc.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fc.test.model.custom.Msg;

@Controller
public class HomeController {
	 @RequestMapping("/")
	    public String index(Model model){
	       // Msg msg =  new Msg("测试标题","测试内容","欢迎来到HOME页面,您拥有 ROLE_HOME 权限");
	        Msg msg = new Msg("标题", "内容", "额外信息，只对管理员显示");
	        model.addAttribute("msg", msg);
	        return "home";
	    }
	    @RequestMapping("/admin")
	    @ResponseBody
	    public String hello(){
	        return "hello admin";
	    }
	    
	    @RequestMapping("/login")
	    public String login(){
	        return "login";
	    }
}