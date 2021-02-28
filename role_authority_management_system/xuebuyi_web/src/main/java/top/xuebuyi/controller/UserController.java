package top.xuebuyi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import top.xuebuyi.domain.Role;
import top.xuebuyi.domain.UserInfo;
import top.xuebuyi.service.UserService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-31 15:24
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    //用户查询
    @RequestMapping("/findAll")
    @PreAuthorize("hasRole('ROLE_ADMIN')") //基于表达式的权限控制
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<UserInfo> userInfos = userService.findAll();
        modelAndView.addObject("userList", userInfos);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    //用户添加
    @RequestMapping("/save")
    @PreAuthorize("authentication.principal.username == 'rose'") //基于SPEL表达式的结果进行权限控制(只有username = 'rose' 才可以访问save方法), principal:当前正在操作的对象
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:findAll";
    }

    //查询指定id的用户
    @RequestMapping("findById")
    public ModelAndView findById(String id){
        UserInfo userInfo = userService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    //查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userId){
        ModelAndView modelAndView = new ModelAndView();
        //1.根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        //2.根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);
        modelAndView.addObject("user",userInfo);
        modelAndView.addObject("roleList",otherRoles);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    //给用户添加角色
    @RequestMapping("/addRoleToUser")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll";
    }
}
