package com.oukele.learning.aop4;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Main {//测试类
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookDao bookDao = context.getBean(BookDao.class);
        try {
            bookDao.add("啦啦啦");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
