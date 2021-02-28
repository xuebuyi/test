package top.xuebuyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import top.xuebuyi.domain.Product;
import top.xuebuyi.service.ProductService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * @author xuebuyi
 * @date 2021-01-24 15:22
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    //查询所有产品
    @RequestMapping("/findAll")
    @RolesAllowed("ADMIN") //JSR-250权限控制注解,只有拥有ADMIN的角色才可以访问该方法
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Product> products = productService.findAll();
        mv.addObject("productList",products);
        mv.setViewName("product-list");
        return mv;
    }

    //添加产品
    @RequestMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll";
    }

}
