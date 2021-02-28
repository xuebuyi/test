package top.xuebuyi.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import top.xuebuyi.domain.Orders;
import top.xuebuyi.service.OrdersService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-25 17:10
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

    @Resource
    private OrdersService ordersService;
    //查询所有订单(未分页)
    /*@RequestMapping("/findAll")
    public ModelAndView findAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll();
        modelAndView.addObject("ordersList", ordersList);
        modelAndView.setViewName("orders-list");
        return modelAndView;
    }*/

    //查询所有订单(分页)
    @RequestMapping("/findAll")
    @Secured("ROLE_ADMIN") //secured权限控制
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer pageNumber,@RequestParam(name = "size", required = true, defaultValue = "3") Integer pageSize){
        ModelAndView modelAndView = new ModelAndView();
        List<Orders> ordersList = ordersService.findAll(pageNumber, pageSize);
        //PageHelper插件中的pageInfo, 实质是一个分页bean
        PageInfo pageInfo = new PageInfo(ordersList);
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("orders-page-list");
        return modelAndView;
    }

    //
    @RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId){
        Orders orders = ordersService.findById(ordersId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orders",orders);
        modelAndView.setViewName("orders-show");
        return modelAndView;
    }

}
