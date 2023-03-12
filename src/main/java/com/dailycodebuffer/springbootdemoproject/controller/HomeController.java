package com.dailycodebuffer.springbootdemoproject.controller;

import com.dailycodebuffer.springbootdemoproject.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HomeController {
    @RequestMapping("/")
    public String home(){
        return "Hello world";
    }

  // @RequestMapping("/user")
    @GetMapping("/user")
    public User user(){
        User user =new User();
        user.setId("1");
        user.setName("saroj");
        user.setEmailId("saroj@gmail.com");
     return user;
    }
    @GetMapping("/{id}")
    public String PathVariable(@PathVariable String id){

        return "The varibal is:"+id;

    }
}
