package top.xuebuyi.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import top.xuebuyi.domain.SysLog;
import top.xuebuyi.service.SysLogService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author xuebuyi
 * @date 2021-02-02 18:05
 */
@Component  //bean
@Aspect  //切面
public class LogAop {

    @Resource
    private HttpServletRequest request;
    @Resource
    private SysLogService sysLogService;

    private Date visitTime; //开始时间
    private  Class clazz; //访问的类
    private Method method; //访问的方法

    //前置通知 主要获取开始时间,执行的类,执行的方法
    @Before("execution(* top.xuebuyi.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = new Date(); //当前时间就是开始访问的时间
        clazz = joinPoint.getTarget().getClass(); //访问的类
        String methodName = joinPoint.getSignature().getName(); //访问方法的名称
        Object[] args = joinPoint.getArgs();//获取访问的方法的参数

        //获取执行的方法的method对象
        if (args == null || args.length == 0){
            method = clazz.getMethod(methodName); //只能获取无参数的方法

        }else {
            Class[] classArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                classArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName,classArgs);
        }
    }

    //后置通知
    @After("execution(* top.xuebuyi.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint){
        Long time = new  Date().getTime() - visitTime.getTime();

        String url = null;
        //获取url
        if (clazz != null && method != null && clazz != LogAop.class && clazz != SysLogController.class){
            //1.获取类上的@RequestMapping注解的值
            RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnnotation != null){
                String[] classValue = classAnnotation.value();//获取注解的value值(数组)

                //2.获取方法上的@RequestMapping注解的值
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String[] methodValue = methodAnnotation.value();

                    url = classValue[0] + "/"+ methodValue[0];

                    //获取访问的ip地址
                    String ip = request.getRemoteAddr();

                    //获取当前操作的用户(可以通过SecurityContext获取,也可以从request.getSession中获取)
//        request.getSession().getAttribute("SPRING_SECURITY_CONTEXT")
                    SecurityContext context = SecurityContextHolder.getContext(); //从上下文中去获取当前登陆的用户
                    User user = (User) context.getAuthentication().getPrincipal();//获取当前对象
                    String username = user.getUsername();

                    //将日志相关信息封装到SysLog对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名] "+clazz.getName()+"[方法名] "+method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisitTime(visitTime);

                    //调用service完成操作
                    sysLogService.save(sysLog);
                }
            }
        }

    }
}
