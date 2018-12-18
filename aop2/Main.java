package com.oukele.learning.aop2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        //加载配置类
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //从容器中获取Cat类
        Cat cat = context.getBean(Cat.class);
        cat.eat();//调用Cat类的方法

    }
}
