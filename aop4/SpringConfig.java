package com.oukele.learning.aop4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration//声明当前类是配置类 （ 类似于 xml 文件一样 ）
@ComponentScan(basePackages = "com.oukele.learning.aop4")//扫描某个包中的注解
@EnableAspectJAutoProxy//激活 代理功能
public class SpringConfig {

}
