package top.xuebuyi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.xuebuyi.domain.SysLog;
import top.xuebuyi.service.SysLogService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-02-02 22:34
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Resource
    private SysLogService sysLogService;

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogs = sysLogService.findAll();
        modelAndView.addObject("sysLogs",sysLogs);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
