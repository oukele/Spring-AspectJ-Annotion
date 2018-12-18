package com.oukele.learning.aop2;

import org.springframework.stereotype.Component;

//目标类
@Component
public class Cat {

    public void eat(){
        System.out.println("小白猫，开始吃鱼了！！！！");
    }
}
