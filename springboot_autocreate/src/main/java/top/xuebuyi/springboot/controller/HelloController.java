package top.xuebuyi.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuebuyi
 * @date 2021-02-23 17:06
 */
@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "Hello World!!!";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
