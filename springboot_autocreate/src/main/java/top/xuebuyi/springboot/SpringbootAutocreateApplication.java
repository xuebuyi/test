package top.xuebuyi.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("top.rainsound.controller") //扫描其他包
@SpringBootApplication
public class SpringbootAutocreateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAutocreateApplication.class, args);
    }

}
