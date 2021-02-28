package top.rainsound.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuebuyi
 * @date 2021-02-23 17:10
 */
@Controller
public class HelloWorld {

    @ResponseBody
    @RequestMapping("/world")
    public String world(){
        return "World !!!";
    }
}
