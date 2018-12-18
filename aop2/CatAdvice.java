package com.oukele.learning.aop2;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CatAdvice {//切面类

    //execution (* *.*（..） )
    // 第一个* 代表着 返回类型是任意的
    // 第二个* 代表着 类的全限定名 * 代表着所有
    // *(..) 代表着 任意方法 任意的参数
    // 比如  execution ( void com.oukele.learning.aop2.Cat.eat())

    //切点
    @Pointcut("execution(* *.*(..))")
    public void pointcut(){};

    @Before("pointcut()")
    public void clean(){//在猫吃之前执行的方法 ，把鱼清洗一下 （前置通知）
        System.out.println("现在我们把我这条鱼，清洗一下");
    }

    @After("pointcut()")
    public void  tidy(){//猫吃完鱼后执行的方法，收拾一下剩下的残渣 (后置通知)
        System.out.println("收拾，小白猫吃剩下来的残渣。！！！");
    }

}
